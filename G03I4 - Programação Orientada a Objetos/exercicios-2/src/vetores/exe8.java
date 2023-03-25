package vetores;

import java.util.Scanner;

public class exe8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] vetor = new int[10];
		int cont = 0, contImpar = 0;

		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Entre com um valor: ");
			vetor[i] = sc.nextInt();
			if (vetor[i] % 2 == 0) {
				cont++;
			} else {
				contImpar++;
			}
		}
		
		sc.close();

		System.out.println("Qtd Pares: " + cont);
		System.out.println("Qtd Impares: " + contImpar);

	}

}
