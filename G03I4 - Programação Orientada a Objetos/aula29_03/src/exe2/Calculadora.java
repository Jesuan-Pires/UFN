package exe2;

public class Calculadora {

	public double resultado;
	public int op;
	public double v1;
	public double v2;

	public Calculadora(double v1, double v2, int op) {
		this.v1 = v1;
		this.v2 = v2;
		this.op = op;
	}

	public void inicio() {

		System.out.println("Entre com uma opcao: ");
		System.out.println("1 - Soma\n" + "2 - Subtracao\n" + "3 - Divisao\n" + "4 - Multiplicacao\n" + "0 - Sair\n");

	}

	public double calcular(double v1, double v2, int op) {
		
		if (op == 1) {
			this.resultado = v1 + v2;
		} else if (op == 2) {
			this.resultado = v1 - v2;
		} else if (op == 3) {
			this.resultado = v1 / v2;
		} else if (op == 4) {
			this.resultado = v1 * v2;
		} else if (op == 0){
			this.resultado = 0;
		}

		return this.resultado;
	}

}
