package aula28_03;

public class Exemplo2 extends RuntimeException{

	public static void main(String[] args) {
		//Divisão por 0
		int a = 10, b = 0;
		try {
		System.out.println(a / b); //ArithmeticException
		}catch(Exception ex){
			System.out.println(ex);
		}
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
