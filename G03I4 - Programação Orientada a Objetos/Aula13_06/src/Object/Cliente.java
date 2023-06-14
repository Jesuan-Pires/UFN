package Object;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("172.25.2.136", 1234);
			System.out.println("Conexão estabelecida com sucesso");

			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());

			Numero n = new Numero(10, 2);
			Resposta res;
			
			out.writeObject(n);

			res = (Resposta)in.readObject();

			System.out.println("A soma: " + res.getValor());

			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
