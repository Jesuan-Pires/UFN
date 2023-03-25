package atividades;

import java.util.Scanner;

public class exe_7 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		final int x = 3;
		int vetor[] = new int[x];
		int aux;

		System.out.print("Entre com " + x + " valores: ");

		for (int i = 0; i < x; i++) {
			vetor[i] = ler.nextInt();
		}

		for (int i = 0; i < vetor.length; i++) {
			for (int j = 0; j < vetor.length - 1; j++) {
				if (vetor[j] > vetor[j + 1]) {
					aux = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = aux;
				}
			}
		}

		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);
		}
	}
}
