package atividades;

import java.util.Scanner;

public class exe_4 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		final int x = 4;
		int vetor[] = new int[x];
		int soma = 0, media;
		
		System.out.print("Entre com " + x + " valores inteiros: ");
		for(int i = 0; i < x; i++) {
			vetor[i] = ler.nextInt();
			soma += vetor[i];
		}
		
		media = soma / 4;
		
		System.out.print("Valores maiores que a media: ");
		for(int i =0; i < x; i++) {
			if(vetor[i] > media) {
				System.out.print(vetor[i] + " ");
			}
		}
		

	}

}
