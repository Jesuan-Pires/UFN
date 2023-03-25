package atividades;

import java.util.Scanner;

public class exe_5 {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		
		int x, y;
		
		System.out.println("Entre com 2 valores: ");
		x = ler.nextInt();
		y = ler.nextInt();
		
		if(x > 0 && y > 0) {
			System.out.println("Quadrante 1");
		}else if(x < 0 && y > 0) {
			System.out.println("Quadrante 2");
		}else if(x < 0 && y < 0) {
			System.out.println("Quadrante 3");
		}else if(x > 0 && y < 0) {
			System.out.println("Quadrante 4");
		}else if(x == 0 && y > 0 || x == 0 &&  y < 0) {
			System.out.println("O ponto encontra-se no eixo Y");
		}else if(x > 0 && y == 0 || x < 0 && y == 0) {
			System.out.println("O ponto encontra-se no eixo X");
		}else if(x == 0 && y == 0){
			System.out.println("O ponto encontra-se no centro do plano cartesiano");
		}else {
			System.out.println("Erro!");
		}

	}

}
