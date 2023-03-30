package aula28_03;

public class Principal {

	public static void main(String[] args) {
		try {
		//Exemplo 1: Tentando acessar um elemnto fora do Índice de um array
		int[] numeros = {1, 2, 3};
		System.out.println(numeros[3]); //ArrayIndexOUTBoundsException
		}catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("Erro: indice fora do array!" + ex.getMessage());
		}
	}

}
