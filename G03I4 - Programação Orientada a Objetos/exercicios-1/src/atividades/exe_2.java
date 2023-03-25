package atividades;

import java.util.Scanner;

public class exe_2 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		float kmInicial, kmFinal;
		float disPerc, valorRece;
		float media, lucro, qtdLitros;
		
		System.out.print("Marcação inicial: ");
		kmInicial = ler.nextFloat();
		System.out.print("Marcação final: ");
		kmFinal = ler.nextFloat();
		System.out.print("Quantidade de combustivel gasta: ");
		qtdLitros = ler.nextFloat();
		System.out.print("Vaor total recebido dos passageiros: ");
		valorRece = ler.nextFloat();
		
		
		disPerc = kmFinal - kmInicial;
		media = disPerc / qtdLitros;
		lucro = valorRece - (qtdLitros * 4.9f);
		
		System.out.println("media de consumo: " + media + " km/l");
		System.out.println("O lucro total do dia foi de: " + lucro);
		
	}

}
