package prova;

public class Revista extends ItemBiblioteca implements Emprestavel {

	public Revista(String titulo, String autor, String ano) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
	}
	int disponibilidade;

	@Override
	public void emprestar() {
		System.out.println("Emprestando Revista");
		disponibilidade = 1;
	}

	@Override
	public void devolver() {
		System.out.println("Revista devolvido");
		disponibilidade = 0;
	}

	@Override
	public void exibirInformacoes() {
		System.out.println("**Revista**");
		System.out.println("Titulo: " + this.titulo);
		System.out.println("Ano: " + this.ano);
		System.out.println("Autor: " + this.autor);
		verificarDisponibilidade();
	}

	@Override
	public void verificarDisponibilidade() {
		if (disponibilidade == 0) {
			System.out.println("Revista Disponivel!");
		} else {
			System.out.println("Revista nao esta disponivel!");
		}
	}

	@Override
	public void obterPrazoDeDevolucao(String date) {
		System.out.println("data de devolucao Revista: " + date);
	}

}
