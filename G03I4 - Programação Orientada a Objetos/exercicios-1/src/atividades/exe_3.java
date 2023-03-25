package atividades;

import java.util.Scanner;

public class exe_3 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		float n;
		
		System.out.print("Entre com um valor: ");
		n = ler.nextFloat();
		
		if(n % 2 == 0) {
			System.out.println("É par!");
		}else {
			System.out.println("É impar!");
		}

	}

}
