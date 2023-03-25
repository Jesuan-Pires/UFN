package vetores;

import java.util.Scanner;

public class exe4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double[][] matriz = new double[3][4];
		double[] soma = new double[3];
		double[] media = new double[3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("Entre com a " + (j + 1) + "ª nota do Aluno " + (i + 1) + ": ");
				matriz[i][j] = sc.nextDouble();
				soma[i] += matriz[i][j];
			}
			System.out.println();
		}
		
		sc.close();

		for (int i = 0; i < 3; i++) {
				//System.out.println(soma[i]);
				media[i] = soma[i] / 4;
				System.out.println("Media do aluno " + (i + 1) + ": " + media[i]);
		}

	}

}
