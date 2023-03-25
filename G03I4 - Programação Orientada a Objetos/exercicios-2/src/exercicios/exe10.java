package exercicios;

import java.util.Scanner;

public class exe10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double valor = 2, soma = 0, media = 0;
		int cont = 0;
		
		while(valor != 0){
			System.out.print("Valor: ");
			valor = sc.nextDouble();
			soma += valor; 
			cont++;
			if(valor == 1) {
				soma--;
				media = soma / (cont - 1);
				System.out.println("Media: " + media);
			}
		}
		sc.close();
		
	}
}
