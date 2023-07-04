import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String codigo;
			int qtd, opcao = 1;

			Socket client = new Socket("localhost", 12345);
			System.out.println("Cliente Conectado!");

			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());

			while (opcao != 0) {
				System.out.println("Sistema Cadastro de Produtos ");
				System.out.println("1 - Comprar produto");
				System.out.println("0 - Sair do sistema");

				System.out.print("Opcao: ");
				opcao = sc.nextInt();
				sc.nextLine();

				switch (opcao) {
				case 0:
					System.out.println("Sistema Encerrado!");
					client.close();
					sc.close();
					break;
				case 1:
					System.out.println("Entre com o código do produto que deseja comprar: ");
					codigo = sc.nextLine();
					System.out.println("Entre com a quantidade de produtos que deseja comprar: ");
					qtd = sc.nextInt();
					Produto cadastrado = new Produto(codigo, qtd);
					out.writeObject(cadastrado);
					Produto produtoAtualizado = (Produto) in.readObject();
					if (produtoAtualizado != null) {
						System.out.println(
								"Quantidade disponível após a compra: " + produtoAtualizado.getEstoqueDisponivel());
					} else {
						System.out.println("Produto não encontrado!");
					}
					break;

				default:
					System.out.println("Opção Inválida!");
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
