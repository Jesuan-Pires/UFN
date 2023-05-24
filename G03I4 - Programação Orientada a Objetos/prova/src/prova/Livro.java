package prova;

public class Livro extends ItemBiblioteca implements Emprestavel {

	public Livro(String titulo, String autor, String ano) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
	}

	int disponibilidade;

	@Override
	public void emprestar() {
		System.out.println("Emprestando Livro");
		disponibilidade = 1;
	}

	@Override
	public void devolver() {
		System.out.println("Livro devolvido");
		disponibilidade = 0;
	}

	@Override
	public void exibirInformacoes() {
		System.out.println("**Livro**");
		System.out.println("Titulo: " + this.titulo);
		System.out.println("Ano: " + this.ano);
		System.out.println("Autor: " + this.autor);
		verificarDisponibilidade();
	}

	@Override
	public void verificarDisponibilidade() {
		if (disponibilidade == 0) {
			System.out.println("Livro disponivel!");
		} else {
			System.out.println("Livro nao esta disponivel!");
		}
	}

	@Override
	public void obterPrazoDeDevolucao(String date) {
		System.out.println("data de devolucao Livro: " + date);
	}

}
