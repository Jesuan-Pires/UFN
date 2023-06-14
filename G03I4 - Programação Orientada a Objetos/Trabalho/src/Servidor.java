import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
	private static final String ARQUIVO_PRODUTOS = "produtos.txt";
	private static List<Produto> listaProdutos;

	public static void main(String[] args) {
		listaProdutos = carregarProdutos();

		try {
			ServerSocket serverSocket = new ServerSocket(1234);
			System.out.println("Servidor iniciado. Aguardando conexões...");

			while (true) {
				Socket clienteSocket = serverSocket.accept();
				System.out.println("Cliente conectado: " + clienteSocket);

				Thread t = new Thread(() -> {
					try {
						DataInputStream in = new DataInputStream(clienteSocket.getInputStream());
						DataOutputStream out = new DataOutputStream(clienteSocket.getOutputStream());

						while (true) {
							int opcao = in.readInt();

							switch (opcao) {
							case 1:
								cadastrarProduto(in, out);
								break;
							case 2:
								alterarPrecoProduto(in, out);
								break;
							case 3:
								excluirProduto(in, out);
								break;
							case 4:
								enviarProdutosCadastrados(out);
								break;
							case 5:
								out.writeUTF("Saindo do sistema...");
								clienteSocket.close();
								System.out.println("Cliente desconectado: " + clienteSocket);
								return;
							default:
								out.writeUTF("Opção inválida! Tente novamente.");
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				});

				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void cadastrarProduto(DataInputStream in, DataOutputStream out) throws IOException {
		int codigo = in.readInt();
		String descricao = in.readUTF();
		double precoCusto = in.readDouble();
		double precoVenda = in.readDouble();
		int estoque = in.readInt();

		Produto novoProduto = new Produto(codigo, descricao, precoCusto, precoVenda, estoque);
		listaProdutos.add(novoProduto);

		salvarProdutos();

		out.writeUTF("Produto cadastrado com sucesso!");
	}

	private static void alterarPrecoProduto(DataInputStream in, DataOutputStream out) throws IOException {
		int codigo = in.readInt();
		double novoPreco = in.readDouble();

		Produto produto = buscarProduto(codigo);

		if (produto != null) {
			produto.setPrecoVenda(novoPreco);
			salvarProdutos();
			out.writeUTF("Preço do produto atualizado com sucesso!");
		} else {
			out.writeUTF("Produto não encontrado!");
		}
	}

	private static void excluirProduto(DataInputStream in, DataOutputStream out) throws IOException {
		int codigo = in.readInt();

		Produto produto = buscarProduto(codigo);

		if (produto != null) {
			listaProdutos.remove(produto);
			salvarProdutos();
			out.writeUTF("Produto excluído com sucesso!");
		} else {
			out.writeUTF("Produto não encontrado!");
		}
	}

	private static void enviarProdutosCadastrados(DataOutputStream out) throws IOException {
		out.writeInt(listaProdutos.size());

		for (Produto produto : listaProdutos) {
			out.writeInt(produto.getCodigo());
			out.writeUTF(produto.getDescricao());
			out.writeDouble(produto.getPrecoCusto());
			out.writeDouble(produto.getPrecoVenda());
			out.writeInt(produto.getEstoque());
		}
	}

	private static Produto buscarProduto(int codigo) {
		for (Produto produto : listaProdutos) {
			if (produto.getCodigo() == codigo) {
				return produto;
			}
		}
		return null;
	}

	private static void salvarProdutos() {
		try (FileOutputStream fileOut = new FileOutputStream(ARQUIVO_PRODUTOS);
				ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
			objOut.writeObject(listaProdutos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<Produto> carregarProdutos() {
		List<Produto> produtos = new ArrayList<>();

		try (FileInputStream fileIn = new FileInputStream(ARQUIVO_PRODUTOS);
				ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
			produtos = (List<Produto>) objIn.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return produtos;
	}
}
