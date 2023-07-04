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
				
				Produto produto = new Produto("", 0);
				produto = (Produto) in.readObject();
				
				
				System.out.println("Recebi: " + produto.getCodigo() + " e " + produto.getQtd());
				
				CadastrarProduto cadastrado = new CadastrarProduto();
				CadastrarProduto registrar = new CadastrarProduto();
				registrar = cadastrado.buscarProduto(produto.getCodigo());
				registrar.salvarProdutosNoArquivo();
				System.out.println(produto);
				

				server.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
