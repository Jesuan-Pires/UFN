package vetores;

import java.util.Scanner;

public class exe5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] vetor = new int[10];
		int maior, menor;
		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Entre com um valor: ");
			vetor[i] = sc.nextInt();
		}
		
		maior = menor = vetor[0];
		
		for(int i = 1; i < vetor.length; i++) {
			if(maior < vetor[i]) {
				maior = vetor[i];
			}
			if(menor > vetor[i]) {
				menor = vetor[i];
			}
		}
		
		System.out.println("Maior valor: "+ maior);
		System.out.println("Menor valor: "+ menor);
		sc.close();
		
	}
}
