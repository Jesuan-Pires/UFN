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
				System.out.println("Não apto a votar!");
			} else if (idade >= 16 && idade < 18 || idade > 70) {
				System.out.println("Voto é facultativo!");
			} else {
				System.out.println("Voto é obrigatório!");
			}
		} else {
			System.out.println("Idade Inválida!");
		}

	}

}
