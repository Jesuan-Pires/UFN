package exercicios;

public class exe4 {

	public static void main(String[] args) {
		
		int soma = 1;
		
		for(int i = 2; i <= 100; i++) {
			System.out.print("soma = "+soma+" + "+ i +" = ");
			soma += i;
			System.out.print(soma+"\n");
		}
	}

}
