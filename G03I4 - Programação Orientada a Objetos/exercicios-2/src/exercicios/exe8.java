package exercicios;

import java.util.Scanner;

public class exe8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String cidade = "";
		
		while (!cidade.equals("SAO PAULO")) {
			System.out.print("Entre com uma cidade: ");
			cidade = sc.nextLine().toUpperCase();
		}
		sc.close();
	}

}
