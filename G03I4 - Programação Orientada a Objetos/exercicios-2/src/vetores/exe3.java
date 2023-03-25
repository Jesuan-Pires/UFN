package vetores;

import java.util.Scanner;

public class exe3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double[] notas = new double[5];		
		double soma = 0;
		
		for(int i = 0; i < notas.length; i++) {
			System.out.println("Entre com a nota do " + (i + 1) + "º aluno: ");
			notas[i] = sc.nextDouble();
			soma += notas[i];
		}
		
		double media = soma / notas.length;
		
		System.out.println("Media geral: " + media);
		
		sc.close();

	}

}
