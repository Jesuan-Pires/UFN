package exe2_1;

public class Calculadora {

	public void inicio() {
		System.out.println("-----------------------------------------------");
		System.out.println("Escolha uma operacao: ");
		System.out.println("-----------------------------------------------");
		System.out.println("1 - Soma\n" + "2 - Subtracao\n" + "3 - Multiplicacao\n" + "4 - Divisao\n" + "0 - Sair\n");
		System.out.print("Opcao: ");
	}

	public double soma(double n1, double n2) {
		return n1 + n2;
	}

	public double subtracao(double n1, double n2) {
		return n1 - n2;
	}

	public double multiplicacao(double n1, double n2) {
		return n1 * n2;
	}

	public double divisao(double n1, double n2) throws ArithmeticException {
		if (n2 == 0) {
			throw new ArithmeticException();
		}
		
		return n1 / n2;
	}
}
