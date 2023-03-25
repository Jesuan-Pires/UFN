package vetores;

public class exe2 {

	public static void main(String[] args) {
		
		int[][] tabuada = new int[10][10];
		
		for(int i = 0 + 1; i < tabuada.length + 1; i++) {
			for(int j = 0 + 1; j < tabuada.length + 1; j++) {
				System.out.println(i + " X " + j + " = " + i*j);
			}
			System.out.println();
		}
		
	}

}
