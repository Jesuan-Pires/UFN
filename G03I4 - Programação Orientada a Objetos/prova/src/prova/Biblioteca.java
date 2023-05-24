package prova;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	List<ItemBiblioteca> itens = new ArrayList<ItemBiblioteca>();

	public void adicionarItem(ItemBiblioteca item) {
		itens.add(item);
	}

	public void removerItem(ItemBiblioteca item) {
		itens.remove(item);
	}

	public void exibirItens() {
		System.out.println("----------------------------");
		System.out.println("Itens na Biblioteca:");
		System.out.println("----------------------------");
		for (ItemBiblioteca item : itens) {
			System.out.println();
			item.exibirInformacoes();
		}
		System.out.println("----------------------------");
	}

	public void realizarEmprestimo(ItemBiblioteca item) {
		item.emprestar();
	}

}
