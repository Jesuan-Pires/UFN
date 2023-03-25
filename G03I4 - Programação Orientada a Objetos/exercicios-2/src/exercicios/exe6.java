package exercicios;

import java.util.Scanner;

public class exe6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		double n = 1;

		while (n != 0) {
			System.out.print("Valor: ");
			n = sc.nextDouble();
		}
		sc.close();
	}

}
