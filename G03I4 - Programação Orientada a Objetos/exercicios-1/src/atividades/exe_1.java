package atividades;

import java.util.Scanner;

public class exe_1 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		float a, b;
		System.out.print("Entre com 2 valores: ");
		a = ler.nextFloat();
		b = ler.nextFloat();
		
		System.out.println("Soma: " + (a + b));
		System.out.println("Subtração: " + (a - b));
		System.out.println("Multiplicação: " + (a * b));
		System.out.println("Divisão: " + (a / b));
		
		ler.close();
	}

}
