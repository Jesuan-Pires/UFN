import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastrarProduto {
    List<Produto> produtos = new ArrayList<>();
    File file = new File("arquivo.txt");

    String codigo, descricao;
    double precoCusto, precoVenda;
    int estoqueDisponivel;

    // CADASTRAR UM PRODUTO
    public void cadastrarProduto() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o código do produto: ");
        codigo = sc.nextLine();
        System.out.print("Entre com a descrição do produto: ");
        descricao = sc.nextLine();
        System.out.print("Entre com o preço de custo do produto: ");
        precoCusto = sc.nextDouble();
        System.out.print("Entre com o preço de venda do produto: ");
        precoVenda = sc.nextDouble();
        System.out.print("Entre com a quantidade do produto: ");
        estoqueDisponivel = sc.nextInt();

        Produto produto = new Produto(codigo, descricao, precoCusto, precoVenda, estoqueDisponivel);
        produtos.add(produto);

        try {
            FileWriter fw = new FileWriter(file, true);

            for (Produto produto1 : produtos) {
                fw.append(produto1.getCodigo() + ", " +
                        produto1.getDescricao() + ", " +
                        produto1.getPrecoCusto() + ", " +
                        produto1.getPrecoVenda() + ", " +
                        produto1.getEstoqueDisponivel() + "\n");
            }
            fw.flush();
            fw.close();

            System.out.println("Produto cadastrado com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao cadastrar produto!");
        }
    }

    // ALTERAR PREÇO DO PRODUTO
    public void alterarPrecoProduto() {
        Scanner sc = new Scanner(System.in);
        String codigo;
        double novoValor;
        System.out.println("Entre com o código do produto para efetuar a alteração de valor: ");
        codigo = sc.nextLine();

        Produto produtoEncontrado = buscarProduto(codigo);
        if (produtoEncontrado != null) {
            System.out.println("AQUIII");
            System.out.print("Entre com o novo valor do produto " + produtoEncontrado.getDescricao() + ": ");
            novoValor = sc.nextDouble();
            produtoEncontrado.setPrecoVenda(novoValor);
            System.out.println("Preço do produto alterado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    // BUSCAR PRODUTO POR CÓDIGO
    public Produto buscarProduto(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }
}
