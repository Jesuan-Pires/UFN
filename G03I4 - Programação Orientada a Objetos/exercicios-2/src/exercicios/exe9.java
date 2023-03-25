package exercicios;

public class exe9 {

	public static void main(String[] args) {

		int i, j, cont = 0;

		for (i = 50; i >= 1; i--) {
			for (j = 1; j <= i; j++) {
				if (i % j == 0) {
					cont++;
				}
			}
			if(cont == 2) {
			System.out.println(i);
			}
			cont = 0;
		}
	}
}