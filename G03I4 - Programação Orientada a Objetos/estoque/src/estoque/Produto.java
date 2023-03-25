package estoque;

import java.util.Scanner;

public class Produto {
	
	private int cod;
	private String descricao;
	//private double precoCusto;
	//private double precoVenda;
	private int estoque = 0;

	Scanner sc = new Scanner(System.in);

	public Produto(int cod, String descricao, double precoCusto, double precoVenda, int estoque, int opcao) {
		this.cod = cod;
		this.descricao = descricao;
		//this.precoCusto = precoCusto;
		//this.precoVenda = precoVenda;
		this.estoque = estoque;
	}

	public int vendeProduto(int estoque) {
		return this.estoque -= estoque;
	}

	public void baixaEstoque(int opcao, int estoque) {
		if (opcao == 1) {
			System.out.println(">>> Foram roubadas " + estoque + " unidade(s) de " + this.descricao + " <<<");
		} else if (opcao == 2) {
			System.out.println(">>> Foram perdidos/quebrados " + estoque + " unidade(s) de " + this.descricao + " <<<");
		} else if (opcao == 3) {
			System.out.println(">>> Foram estraviadas " + estoque + " unidade(s) de " + this.descricao + " <<<");
		} else
			System.out.println("OPCAO INVALIDA!");

		this.estoque -= estoque;
	}

	public int retornaEstoque() {
		System.out.println("Codigo: " + this.cod 
							+ "\nProduto: " 
							+ this.descricao 
							+ "\nQuantidade: " 
							+ this.estoque);
		
		return this.estoque;
	}

	public void entraEstoque(int cod, String descricao, int estoque) {
		this.cod = cod;
		this.descricao = descricao;
		this.estoque += estoque;
	}

	public void inicio() {
		System.out.println("\n1 - Venda do produto\n" 
							+ "2 - Entra estoque\n" 
							+ "3 - Baixa estoque\n"
							+ "4 - Retorna estoque\n" 
							+ "0 - Sair");
		
		System.out.print("\nOpcao: ");
	}
	public void titulo() {
		separador();
		System.out.println("SISTEMA ESTOQUE LOJA");
		separador();
	}
	
	public void separador() {
		System.out.println("----------------------------------------------------");
	}
	
}
