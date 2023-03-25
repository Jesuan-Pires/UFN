package exercicios;

import java.util.Scanner;

public class exe5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double aux;

		System.out.print("Entre com o valor do fatorial: ");
		double n = sc.nextInt();

		for (double i = n; i > 1; i--) {
			aux = n * (i - 1);
			n = aux;
		}

		System.out.println(n);

		sc.close();
	}
}
