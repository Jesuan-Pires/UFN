package prova;

public class Program {

	public static void main(String[] args) {

		Livro livro1 = new Livro("Cosmos", "1996", "Carl Sagan");
		Revista revista1 = new Revista("Capricho", "2000", "Patati-Patata");

		Biblioteca biblioteca = new Biblioteca();

		biblioteca.adicionarItem(revista1);
		biblioteca.adicionarItem(livro1);
		biblioteca.exibirItens();

		revista1.emprestar();
		revista1.obterPrazoDeDevolucao("10-08-2022");
		livro1.emprestar();
		livro1.obterPrazoDeDevolucao("10-05-2023");
		revista1.verificarDisponibilidade();
		livro1.verificarDisponibilidade();
		revista1.devolver();
		livro1.devolver();
		revista1.verificarDisponibilidade();
		livro1.verificarDisponibilidade();
		biblioteca.realizarEmprestimo(revista1);
		biblioteca.realizarEmprestimo(livro1);
		revista1.verificarDisponibilidade();
		livro1.verificarDisponibilidade();
		biblioteca.removerItem(revista1);
		biblioteca.removerItem(livro1);
		biblioteca.exibirItens();

	}

}
