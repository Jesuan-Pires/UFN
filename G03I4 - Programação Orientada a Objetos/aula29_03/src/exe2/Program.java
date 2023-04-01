package exe2;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int op = 0;
		double v1 = 0, v2 = 0;

		Calculadora cal = new Calculadora(v1, v2, op);
		System.out.println("CALCULADORA\n");

		do {
			cal.inicio();
			System.out.print("Opcao: ");
			op = sc.nextInt();
			
			System.out.println();
			
			switch (op) {
			case 0:
				op = 0;
				System.out.println("Operacao encerrada!");
				break;
			case 1:
				System.out.print("Entre com valor 1: ");
				v1 = sc.nextDouble();
				System.out.print("Entre com valor 2: ");
				v2 = sc.nextDouble();
				System.out.println("\nResultado: " + cal.calcular(v1, v2, op) + "\n");
				break;
			case 2:
				System.out.print("Entre com valor 1: ");
				v1 = sc.nextDouble();
				System.out.print("Entre com valor 2: ");
				v2 = sc.nextDouble();
				System.out.println("\nResultado: " + cal.calcular(v1, v2, op) + "\n");
				break;
			case 3:
				System.out.print("Entre com valor 1: ");
				v1 = sc.nextDouble();
				System.out.print("Entre com valor 2: ");
				v2 = sc.nextDouble();
				System.out.println("\nResultado: " + cal.calcular(v1, v2, op) + "\n");
				break;
			case 4:
				System.out.print("Entre com valor 1: ");
				v1 = sc.nextDouble();
				System.out.print("Entre com valor 2: ");
				v2 = sc.nextDouble();
				System.out.println("\nResultado: " + cal.calcular(v1, v2, op) + "\n");
				break;
			default:
				System.out.println("Operacao não encontrada!");
				break;
			}
		} while (op != 0);

		sc.close();
	}

}
