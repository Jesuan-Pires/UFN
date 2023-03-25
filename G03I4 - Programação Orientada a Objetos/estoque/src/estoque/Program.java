package estoque;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cod = 0, estoque = 0, opcao = 0, exit = 1;
		String descricao = "";
		double precoCusto = 0, precoVenda = 0;

		Produto produto = new Produto(cod, descricao, precoCusto, precoVenda, estoque, opcao);

		produto.titulo();
		produto.inicio();

		while (exit != 0) {
			opcao = sc.nextInt();
			System.out.println();

			switch (opcao) {

			case 0:
				produto.separador();
				System.out.println("Programa Finalizado!");
				produto.separador();
				produto.retornaEstoque();
				exit = 0;
				break;

			case 1:
				produto.separador();
				System.out.println("Vender Produto");
				produto.separador();
				if (estoque == 0) {
					System.out.println(">>> Estoque vazio! Entre com intens ao estoque! <<<");
				} else {
					System.out.print("Quantidade de produtos a ser vendida: ");
					estoque = sc.nextInt();
					produto.vendeProduto(estoque);
				}
				produto.separador();
				break;

			case 2:
				produto.separador();
				System.out.println("Entrada de produto no estoque");
				produto.separador();
				if (estoque == 0) {
					System.out.print("Codigo para o produto: ");
					cod = sc.nextInt();
					sc.nextLine();
					System.out.print("Descricao do produto: ");
					descricao = sc.nextLine();
				}
				System.out.print("Quantidade de unidades do produto: ");
				estoque = sc.nextInt();
				produto.separador();
				produto.entraEstoque(cod, descricao, estoque);
				break;

			case 3:
				produto.separador();
				System.out.println("Baixa estoque");
				produto.separador();
				if (estoque == 0) {
					System.out.println(">>> Estoque vazio! Entre com intens ao estoque! <<<");
				} else {
					System.out.println("1 - Roubo \n" + "2 - Perda/quebra \n" + "3 - outro ");
					System.out.print("\nOpcao: ");
					opcao = sc.nextInt();
					System.out.print("\nQuantidade baixa estoque: ");
					estoque = sc.nextInt();
					produto.baixaEstoque(opcao, estoque);
				}
				produto.separador();
				break;

			case 4:
				produto.separador();
				System.out.println("Estado do estoque");
				produto.separador();
				if (estoque == 0) {
					System.out.println(">>> Estoque vazio! Entre com itens ao estoque! <<<");
				} else {
					produto.retornaEstoque();
				}
				produto.separador();
				break;
			default:
				System.out.println("OPCAO INVALIDA!");
				break;
			}
			if (exit != 0) {
				produto.inicio();
			}
		}
		sc.close();
	}
}
