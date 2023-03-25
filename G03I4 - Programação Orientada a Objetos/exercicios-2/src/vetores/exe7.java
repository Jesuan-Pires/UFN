package vetores;

import java.util.Scanner;

public class exe7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double[][] matriz = new double[4][3];
		String[] disciplina = new String[4];
		int i = 0, j = 0;
		double maior, menor;

		disciplina[0] = "portugês";
		disciplina[1] = "inglês";
		disciplina[2] = "matemática";
		disciplina[3] = "história";

		for (i = 0; i < 4; i++) {
			for (j = 0; j < 3; j++) {
				System.out.println("Entre com a nota do aluno " + (j + 1) + " de " + disciplina[i] + ": ");
				matriz[i][j] = sc.nextDouble();
			}
			System.out.println();
		}
		sc.close();

		maior = menor = 0;
		
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 3; j++) {
				if (j == 0) {
					maior = menor = matriz[i][j];
				}
				if (maior < matriz[i][j]) {
					maior = matriz[i][j];
				}
				if (menor > matriz[i][j]) {
					menor = matriz[i][j];
				}
			}
			System.out.println("Maior nota em " + disciplina[i] + " :" + maior);
			System.out.println("Menor nota em " + disciplina[i] + " :" + menor);
		}

	}

}
