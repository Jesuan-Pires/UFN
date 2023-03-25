package atividades;

import java.util.Scanner;

public class exe_10 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		float a, b;
		int opcao;
		
		System.out.println("Entre com 2 valores: ");
		a = ler.nextFloat();
		b = ler.nextFloat();
		
		System.out.println("Tecle[1] para soma dos valores: ");
		System.out.println("Tecle[2] para subtração dos valores: ");
		System.out.println("Tecle[3] para multiplicação dos valores: ");
		System.out.println("Tecle[4] para divisão dos valores: ");
		
		opcao = ler.nextInt();
		
		switch(opcao) {
			case 1:
				System.out.println(a + " + " + b + " = " + (a + b));
				break;
			case 2:
				System.out.println(a + " - " + b + " = " + (a - b));
				break;
			case 3:
				System.out.println(a + " * " + b + " = " + (a * b));
				break;
			case 4:
				System.out.println(a + " / " + b + " = " + (a / b));
				break;
			default:
				System.out.println("Comando Inválido!");
				break;
		}

	}

}
