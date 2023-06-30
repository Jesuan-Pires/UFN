import java.io.Serializable;

public class Produto implements Serializable{
	
	private String codigo;
	private String descricao;
	private double precoCusto;
	private double precoVenda;
	private int estoqueDisponivel;
	
	public Produto(String codigo, String descricao, double precoCusto, double precoVenda, int estoqueDisponivel) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.estoqueDisponivel = estoqueDisponivel;
	}
	
	public Produto(String codigo, int estoqueDisponivel) {
		this.codigo = codigo;
		this.estoqueDisponivel = estoqueDisponivel;
	}

	public String getCodigo() {
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
	
	public double setPrecoVenda(double precoVenda) {
		return this.precoVenda = precoVenda;
	}

	public int getEstoqueDisponivel() {
		return estoqueDisponivel;
	}
	
	public void venderProduto() {		
		
	}
	
	@Override
	public String toString() {
		return "Codigo: " + codigo +
				", Descrição: " + descricao +
				", Preço de Custo: " + precoCusto +
				", Preço de venda: " + precoVenda +
				", Estoque Disponível: " + estoqueDisponivel;
	}

} 