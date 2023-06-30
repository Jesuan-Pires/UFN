import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		try {

			Scanner sc = new Scanner(System.in);
			Socket client = new Socket("localhost", 1234);
			System.out.println("Cliente Conectado!");

			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());

			String codigo;
			int qtd;
			Produto res;

			System.out.println("Entre com o código do produto que deseja comprar: ");
			codigo = sc.nextLine();
			System.out.println("Entre com a quantidade de produtos que deseja comprar: ");
			qtd = sc.nextInt();

			Produto produto = new Produto(codigo, qtd);

			out.writeObject(produto);

			res = (Produto) in.readObject();

			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
