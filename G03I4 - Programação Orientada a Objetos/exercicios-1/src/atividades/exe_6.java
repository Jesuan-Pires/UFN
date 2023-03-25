package atividades;

import java.util.Scanner;

public class exe_6 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		final int x = 3;
		int vetor[] = new int[x];
		int maior = 0;
		
		System.out.print("Entre com " + x + " valores: ");
		
		for(int i = 0; i < x; i++) {
			vetor[i] = ler.nextInt();
		}
		
		for(int i = 0; i < vetor.length; i++) {
			if(vetor[i] > maior) {
				maior = vetor[i];
			}
		}
		
		System.out.println("Maior: " + maior);
		
	}
}
