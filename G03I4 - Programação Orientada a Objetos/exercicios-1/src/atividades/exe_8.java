package atividades;

import java.util.Scanner;

public class exe_8 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		int x, y;
		
		System.out.println("Entre com 2 valores: ");
		x = ler.nextInt();
		y = ler.nextInt();
		
		if(x % y == 0 || y % x == 0) {
			System.out.println("São Multiplos!");
		}else {
			System.out.println("Não são multiplos!");
		}
	}

}
