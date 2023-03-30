package exe2;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcao = 1, operacao = 10;
		double v1 = 0, v2 = 0, resultado = 0;

		Calculadora cal = new Calculadora(operacao, v2, v1, resultado);
		System.out.println("CALCULADORA");

		do {
			cal.inicio();
			System.out.print("Opcao: ");
			operacao = sc.nextInt();
			System.out.println();
			System.out.print("Entre com valor 1: ");
			v1 = sc.nextDouble();
			System.out.print("Entre com valor 2: ");
			v2 = sc.nextDouble();
			
			switch (operacao) {
			case 1:
				System.out.println("\nResultado: " + cal.calcular(v1, v2, operacao));
				break;
			case 2:
				System.out.println("\nResultado: " + cal.calcular(v1, v2, operacao));
				break;
			case 3:
				System.out.println("\nResultado: " + cal.calcular(v1, v2, operacao));
				break;
			case 4:
				System.out.println("\nResultado: " + cal.calcular(v1, v2, operacao));
				break;
			default:
				System.out.println("\nResultado: " + cal.calcular(v1, v2, operacao));
				break;
			}
		} while (opcao != 0);

		sc.close();
	}

}
