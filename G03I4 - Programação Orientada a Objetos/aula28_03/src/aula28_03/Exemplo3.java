package aula28_03;

public class Exemplo3 {

	public static void main(String[] args) {
		//Tentando converter uma String em numero
		String numero = "abc";
		
		try {
		int valor = Integer.parseInt(numero); //numberFormatException
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
}
