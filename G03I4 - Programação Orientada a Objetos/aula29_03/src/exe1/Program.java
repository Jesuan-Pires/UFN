package exe1;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double num, raiz;

		try {
			System.out.println("Entre com um valor: ");
			num = sc.nextDouble();
			raiz = Math.sqrt(num);
			System.out.println("A raiz quadrada: " + raiz);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
		}

		sc.close();

	}

}
