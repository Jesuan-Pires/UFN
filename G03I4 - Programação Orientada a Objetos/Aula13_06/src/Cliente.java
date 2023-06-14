import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("172.25.2.142", 1234);
			System.out.println("Conexão estabelecida com sucesso");

			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			DataInputStream in = new DataInputStream(s.getInputStream());

			int x = 3, y = 2, resposta;

			out.writeInt(x);
			out.writeInt(y);

			resposta = in.readInt();

			System.out.println("A soma: " + resposta);

			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
