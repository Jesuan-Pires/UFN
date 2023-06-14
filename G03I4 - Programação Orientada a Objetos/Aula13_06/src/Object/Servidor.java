package Object;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {		
		try {
			//Criação do socket servidor e definição da porta(1234)
			ServerSocket servidor = new ServerSocket(1234);
			System.out.println("Socket Servidor criado com sucesso");

			while (true) {
				/*Servidor aguarda uma conexão de um cliente o 
				 servidor bloqueia nesta linha enquanto um cliente não chega
				 Quando um cliente se conecta, o servidor recebe uma referencia do 
				 socket do cliente que se conectou (retorno do metodo)
				 */
				Socket cliente = servidor.accept();
				//Extrai o fluxo de saida e entrada de dados do socket
				ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(cliente.getInputStream());
				
				
				//Servidor recebe dois inteiros do cliente, x e y
				Numero n;
				Resposta res;
				
				n = (Numero)in.readObject();
				
				System.out.println("Recebi " + n.getX() + " e " + n.getY());
				
				//Servidor calcula a resposta e envia para o cliente
				res = new Resposta(n.getX() + n.getY());
				out.writeObject(res);

				cliente.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

