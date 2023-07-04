import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public Servidor() {

    }

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server Criado!");

            while (true) {
                Socket client = server.accept();
                ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(client.getInputStream());

                Produto produto = new Produto("", 0);
                produto = (Produto) in.readObject();

                System.out.println("Recebi: " + produto.getCodigo() + " e " + produto.getQtd());
                int quantidade = produto.getQtd();
                CadastrarProduto cp = new CadastrarProduto();
                produto = cp.buscarProduto(produto.getCodigo());
                if (produto != null) {
                    produto.venderProduto(quantidade);
                    if(produto.getQtd() - quantidade < 0) {
                    System.out.println("Estoque excede valor disponivel!");	
                    }
                    System.out.println(produto);

                    cp.salvarProdutosNoArquivo(); // Salva as alterações no arquivo
                    
                    out.writeObject(produto); // Retorna o objeto atualizado para o cliente
                
                } else {
                    System.out.println("Produto não encontrado!");
                    out.writeObject(null); // Retorna null para indicar que o produto não foi encontrado
                }

                //client.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}