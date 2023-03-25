package vetores;

import java.util.Scanner;

public class exe1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] nomes = new String[5];

		for (int j = 1,i = 0; i < 5; i++) {
			System.out.print("Entre com o "+ (j++) + "º nome: ");
			nomes[i] = sc.nextLine();
		}
		
		for(int i = 0; i < 5; i++) {
			System.out.println(nomes[i]);
		}
		
		sc.close();

	}

}
