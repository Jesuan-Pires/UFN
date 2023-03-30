package exe2;

public class Calculadora {
	private double resultado;
	private int operacao;
	private double v1;
	private double v2;

	public Calculadora(int operacao, double resultado, double v1, double v2) {
		this.operacao = operacao;
		this.resultado = resultado;
		this.v1 = v1;
		this.v2 = v2;
	}

	public void inicio() {
		System.out.println("Entre com uma opcao: ");
		System.out.println("1 - Soma\n" + "2 - Subtracao\n" + "3 - Divisao\n" + "4 - Multiplicacao\n" + "0 - Sair\n");
	}

	public double calcular(double v1, double v2, int operacao) {

		if (operacao == 1) {
			this.resultado = v1 + v2;
		} else if (operacao == 2) {
			this.resultado = v1 - v2;
		} else if (operacao == 3) {
			this.resultado = v1 - v2;
		} else if (operacao == 3) {
			this.resultado = v1 / v2;
		} else if (operacao == 4) {
			this.resultado = v1 * v2;
		}

		return this.resultado;
	}

}
