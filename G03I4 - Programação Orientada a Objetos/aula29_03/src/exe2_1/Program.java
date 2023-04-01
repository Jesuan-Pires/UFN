package exe2_1;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int opcao = -1;
		double n1, n2, resultado;
		n1 = n2 = resultado = 0;
		Calculadora calc = new Calculadora();

		do {
			calc.inicio();
			opcao = scanner.nextInt();
			if (opcao >= 1 && opcao <= 4) {
				try {
					System.out.print("Digite o primeiro número: ");
					n1 = scanner.nextDouble();
					System.out.print("Digite o segundo número: ");
					n2 = scanner.nextDouble();
				} catch (Exception ex) {
					String msg = ex.getMessage();
					System.out.println("\nException: " + ex + " = " + msg + "\n");
				}
				scanner.nextLine();
				try {
					switch (opcao) {
					case 1:
						resultado = calc.soma(n1, n2);
						break;
					case 2:
						resultado = calc.subtracao(n1, n2);
						break;
					case 3:
						resultado = calc.multiplicacao(n1, n2);
						break;
					case 4:
						resultado = calc.divisao(n1, n2);
						break;
					}
				} catch (Exception ex) {
					String msg = ex.getMessage();
					System.out.println("\nException: " + ex + " = " + msg + "\n");
				}
				System.out.println("Resultado: " +resultado + "\n");
			} else if (opcao != 0) {
				System.out.println("Opção inválida.");
			}

		} while (opcao != 0);
		System.out.println("Programa encerrado!");

		scanner.close();
	}
}