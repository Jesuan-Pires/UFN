package atividades;

import java.util.Scanner;

public class exe_9 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		int idade;

		System.out.print("Entre com a idade: ");
		idade = ler.nextInt();

		if (idade > 0) {
			if (idade < 16) {
				System.out.println("N�o apto a votar!");
			} else if (idade >= 16 && idade < 18 || idade > 70) {
				System.out.println("Voto � facultativo!");
			} else {
				System.out.println("Voto � obrigat�rio!");
			}
		} else {
			System.out.println("Idade Inv�lida!");
		}

	}

}
