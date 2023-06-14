import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 1234);
			System.out.println("Conexão estabelecida com sucesso");

			DataInputStream in = new DataInputStream(socket.getInputStream());
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			Scanner scanner = new Scanner(System.in);

			int opcao;

			do {
				exibirMenu();
				opcao = scanner.nextInt();
				scanner.nextLine(); // Limpa o buffer do teclado

				out.writeInt(opcao);

				switch (opcao) {
				case 1:
					cadastrarProduto(scanner, out, in);
					break;
				case 2:
					alterarPrecoProduto(scanner, out, in);
					break;
				case 3:
					excluirProduto(scanner, out, in);
					break;
				case 4:
					receberProdutosCadastrados(in);
					break;
				case 5:
					out.writeUTF("Sair");
					System.out.println("Saindo do sistema...");
					break;
				default:
					System.out.println("Opção inválida! Tente novamente.");
				}

				System.out.println(in.readUTF());
			} while (!"Saindo do sistema...".equals(in.readUTF()));

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void exibirMenu() {
		System.out.println("===== MENU =====");
		System.out.println("1 - Cadastrar produto");
		System.out.println("2 - Alterar preço do produto");
		System.out.println("3 - Excluir produto");
		System.out.println("4 - Mostrar produtos cadastrados");
		System.out.println("5 - Sair do sistema");
		System.out.print("Escolha uma opção: ");
	}

	private static void cadastrarProduto(Scanner scanner, DataOutputStream out, DataInputStream in) throws IOException {
		System.out.println("===== CADASTRO DE PRODUTO =====");

		System.out.print("Código: ");
		int codigo = scanner.nextInt();
		scanner.nextLine(); // Limpa o buffer do teclado

		System.out.print("Descrição: ");
		String descricao = scanner.nextLine();

		System.out.print("Preço de custo: ");
		double precoCusto = scanner.nextDouble();

		System.out.print("Preço de venda: ");
		double precoVenda = scanner.nextDouble();

		System.out.print("Estoque disponível: ");
		int estoque = scanner.nextInt();

		out.writeInt(codigo);
		out.writeUTF(descricao);
		out.writeDouble(precoCusto);
		out.writeDouble(precoVenda);
		out.writeInt(estoque);
	}

	private static void alterarPrecoProduto(Scanner scanner, DataOutputStream out, DataInputStream in)
			throws IOException {
		System.out.println("===== ALTERAÇÃO DE PREÇO DO PRODUTO =====");

		System.out.print("Informe o código do produto: ");
		int codigo = scanner.nextInt();

		System.out.print("Novo preço de venda: ");
		double novoPreco = scanner.nextDouble();

		out.writeInt(codigo);
		out.writeDouble(novoPreco);
	}

	private static void excluirProduto(Scanner scanner, DataOutputStream out, DataInputStream in) throws IOException {
		System.out.println("===== EXCLUSÃO DE PRODUTO =====");

		System.out.print("Informe o código do produto: ");
		int codigo = scanner.nextInt();

		out.writeInt(codigo);
	}

	private static void receberProdutosCadastrados(DataInputStream in) throws IOException {
		int totalProdutos = in.readInt();

		System.out.println("===== PRODUTOS CADASTRADOS =====");

		for (int i = 0; i < totalProdutos; i++) {
			int codigo = in.readInt();
			String descricao = in.readUTF();
			double precoCusto = in.readDouble();
			double precoVenda = in.readDouble();
			int estoque = in.readInt();

			System.out.println("Código: " + codigo);
			System.out.println("Descrição: " + descricao);
			System.out.println("Preço de custo: " + precoCusto);
			System.out.println("Preço de venda: " + precoVenda);
			System.out.println("Estoque disponível: " + estoque);
			System.out.println("------------------------------------");
		}
	}
}
