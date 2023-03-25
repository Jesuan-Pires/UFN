package exercicios;

import java.util.Scanner;

public class exe7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double nota = 1;
		int i = 1;
		
		while(nota != -1) {
		System.out.print("Entre com a nota do aluno " + i + ": ");
		nota = sc.nextDouble();
		i++;
		}
		
		sc.close();
	}

}
