package exe3;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Conversao conv = new Conversao();
		
		String palavra;
		
		System.out.println("Entre com uma String: ");
		palavra = sc.nextLine();
		
		System.out.println("String: " + palavra);
		
		try {
			System.out.println("Conversao para Double: " + conv.converte(palavra));
		} catch (Exception ex) {
			ex.getMessage();
			System.out.println("Não é possível converter: " 
								+ palavra 
								+ " para Double! Erro: " + ex);
		}

		
		
		sc.close();
	}

}
