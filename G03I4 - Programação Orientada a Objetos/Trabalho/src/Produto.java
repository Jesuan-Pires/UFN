import java.io.Serializable;

public class Produto implements Serializable {
	private int codigo;
	private String descricao;
	private double precoCusto;
	private double precoVenda;
	private int estoque;

	public Produto(int codigo, String descricao, double precoCusto, double precoVenda, int estoque) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.estoque = estoque;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setPrecoVenda(double novoPreco) {
		this.precoVenda = novoPreco;
	}
}
