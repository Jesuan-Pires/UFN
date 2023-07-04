import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastrarProduto {
	ArrayList<Produto> produtos = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	File file = new File("arquivo.txt");

	String codigo, descricao;
	double precoCusto, precoVenda, novoValor;;
	int estoqueDisponivel;

	// O construtor Carrega os produtos do arquivo no início
	public CadastrarProduto() {
		carregarProdutosDoArquivo();
	}

	public void cadastrar() {
		System.out.print("Entre com o código do produto: ");
		codigo = sc.nextLine();

		Produto produtoEncontrado = buscarProduto(codigo);

		if (produtoEncontrado == null) {
			System.out.print("Entre com a descrição do produto: ");
			descricao = sc.nextLine();
			System.out.print("Entre com o preço de custo do produto: ");
			precoCusto = sc.nextDouble();
			sc.nextLine();
			System.out.print("Entre com o preço de venda do produto: ");
			precoVenda = sc.nextDouble();
			sc.nextLine();
			System.out.print("Entre com a quantidade do produto: ");
			estoqueDisponivel = sc.nextInt();
			sc.nextLine();

			Produto produto = new Produto(codigo, descricao, precoCusto, precoVenda, estoqueDisponivel);

			produtos.add(produto);

//			for (Produto produto1 : produtos) {
//				System.out.println(produto1);
//			}

			salvarProdutoNoArquivo(produto); // Salva o novo produto no arquivo

		} else {
			System.out.println("Código já cadastrado! Escolha um novo!");
		}
	}

	// ALTERAR PREÇO DO PRODUTO
	public void alterarPrecoProduto() {
		System.out.println("Entre com o código do produto para efetuar a alteração de valor: ");
		codigo = sc.nextLine();

		Produto produtoEncontrado = buscarProduto(codigo);
		if (produtoEncontrado != null) {
			System.out.print("Entre com o novo valor do produto " + produtoEncontrado.getDescricao() + ": ");
			novoValor = sc.nextDouble();
			sc.nextLine();
			produtoEncontrado.setPrecoVenda(novoValor);
			System.out.println("Preço do produto alterado com sucesso!");

			salvarProdutosNoArquivo(); // Atualiza o arquivo após a alteração de preço

		} else {
			System.out.println("Produto não encontrado!");
		}
	}

	// BUSCAR PRODUTO POR CÓDIGO
	public Produto buscarProduto(String codigo) {
		for (Produto produto : produtos) {
			if (produto.getCodigo().equals(codigo)) {
				return produto;
			}
		}
		return null;
	}

	// EXCLUINDO PRODUTO DA LISTA
	public void excluirProduto() {
		System.out.println("Entre com o código do produto que deseja efetuar a exclusão: ");
		codigo = sc.nextLine();
		Produto produtoEncontrado = buscarProduto(codigo);
		if (produtoEncontrado != null) {
			System.out.print("Excluindo produto número " + produtoEncontrado.getDescricao() + "...\n");
			produtos.remove(produtoEncontrado);
			System.out.println("Produto excluído com sucesso!");

			salvarProdutosNoArquivo(); // Atualiza o arquivo após a exclusão do produto

		} else {
			System.out.println("Produto não encontrado!");
		}
	}

	// CARREGA OS PRODUTOS ATUALIZADOS
	public void carregarProdutosDoArquivo() {
		try {
			Scanner fsc = new Scanner(file);
			/*
			 * O método hasNextLine() retorna true se houver uma linha seguinte para ser
			 * lida no arquivo e retorna false caso contrário. Portanto, o laço while
			 * continuará executando enquanto houver linhas a serem lidas no arquivo.
			 */
			while (fsc.hasNextLine()) {
				String linha = fsc.nextLine();
				String[] x = linha.split(", ");
				/*
				 * função split(", "), que separa a linha em substrings sempre que encontra a
				 * sequência ", " (vírgula seguida de espaço).
				 */
				if (x.length == 5) {
					String codigo = x[0];
					String descricao = x[1];
					double precoCusto = Double.parseDouble(x[2]);
					double precoVenda = Double.parseDouble(x[3]);
					int estoqueDisponivel = Integer.parseInt(x[4]);

					Produto produto = new Produto(codigo, descricao, precoCusto, precoVenda, estoqueDisponivel);
					produtos.add(produto);
				}
			}
			fsc.close();
		} catch (IOException e) {
			System.out.println("Erro ao carregar produtos do arquivo!");
		}
	}

	// SALVA SOMENTE UM PRODUTO(1º)
	public void salvarProdutoNoArquivo(Produto produto) {
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.append(produto.getCodigo() + ", " + produto.getDescricao() + ", " + produto.getPrecoCusto() + ", "
					+ produto.getPrecoVenda() + ", " + produto.getEstoqueDisponivel() + "\n");
			fw.flush();
			fw.close();
			System.out.println("Produto cadastrado com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao cadastrar produto!");
		}
	}

	// SALVA OS PRODUTOS ATUALIZADOS
	public void salvarProdutosNoArquivo() {
		try {
			FileWriter fw = new FileWriter(file);
			// append grava concatenado
			for (Produto arquivo : produtos) {
				fw.append(arquivo.getCodigo() + ", " + arquivo.getDescricao() + ", " + arquivo.getPrecoCusto() + ", "
						+ arquivo.getPrecoVenda() + ", " + arquivo.getEstoqueDisponivel() + "\n");
			}
			fw.flush();
			fw.close();
			System.out.println("Produtos atualizados com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao atualizar produtos!");
		}
	}
	
	public void vendaEfetuada() {
		Produto produtoVendido = buscarProduto(codigo);
		produtoVendido.venderProduto(estoqueDisponivel);
		salvarProdutoNoArquivo(produtoVendido);
	}

}
