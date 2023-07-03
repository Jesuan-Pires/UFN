import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public Servidor() {
		
	}

	public static void main(String[] args) {

		try {

			ServerSocket server = new ServerSocket(1234);
			System.out.println("Server Criado!");

			while (true) {
				Socket client = server.accept();
				ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(client.getInputStream());

				Produto produto;
				CadastrarProduto cp = new CadastrarProduto();
											
				produto = (Produto) in.readObject();
				String codigo = produto.getCodigo();
				int qtd = produto.getQtd();
				
				System.out.println("Recebi: " + produto.getCodigo() + " e " + produto.getQtd());
			
				Produto produtoEncontrado = cp.buscarProduto(codigo);
				out.writeObject(produtoEncontrado);
				cp = (CadastrarProduto) in.readObject();
				cp.vendaEfetuada();

				server.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
