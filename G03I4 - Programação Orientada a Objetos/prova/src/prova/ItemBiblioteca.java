package prova;

public abstract class ItemBiblioteca {

	protected String titulo;
	protected String autor;
	protected String ano;

	public abstract void emprestar();

	public abstract void devolver();

	public abstract void exibirInformacoes();

}
