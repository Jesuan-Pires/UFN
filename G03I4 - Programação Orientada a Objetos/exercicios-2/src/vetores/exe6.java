package vetores;

import java.util.Scanner;

public class exe6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] cidades = new String[5];
		double[] populacao = new double[5];
		double maior, menor;
		int auxMaior = 0, auxMenor = 0;
		
		for(int i = 0; i < cidades.length; i++) {
			System.out.println("Entre com o nome da cidade: ");
			cidades[i] = sc.nextLine();
		}
		
		for(int i = 0; i < populacao.length; i++) {
			System.out.println("Entre com a populacao da cidade "+cidades[i]+": ");
			populacao[i] = sc.nextDouble();
		}
		
		maior = menor = populacao[0];
		
		for(int i = 1; i < populacao.length; i++) {
			if(maior < populacao[i]) {
				maior = populacao[i];
				auxMaior = i;
			}
			if(menor > populacao[i]) {
				menor = populacao[i];
				auxMenor = i;
			}
		}
		
		sc.close();
		
		System.out.println("Cidade mais populosa: " + cidades[auxMaior]);
		System.out.println("Cidade menos populosa: " + cidades[auxMenor]);

	}

}
