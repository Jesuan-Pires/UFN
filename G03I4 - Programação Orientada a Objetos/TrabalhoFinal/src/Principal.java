import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CadastrarProduto cadastro = new CadastrarProduto();
		int opcao = 0;

		while (opcao != 4) {
			System.out.println("Sistema Cadastro de Produtos ");
			System.out.println("1 - Cadastrar produto");
			System.out.println("2 - Alterar preço produto");
			System.out.println("3 - Excluir produto");
			System.out.println("4 - Sair do sistema");

			System.out.print("Opcao: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				cadastro.cadastrar();
				break;
			case 2:
				cadastro.alterarPrecoProduto();
				break;
			case 3:
				cadastro.excluirProduto();
				break;
			case 4:
				System.out.println("Sistema Encerrado!");
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		}
	}
}
