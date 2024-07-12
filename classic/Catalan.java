package classic;

import java.util.Scanner;

public class Catalan {
	
	static Scanner sc = new Scanner(System.in);
	static int[] C;
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		
		C = new int[n + 1];
		C[0] = 1;
		
		for (int i = 0; i <= n; i++) {
			System.out.print(getCatalan(i) + " ");
		}
	}

	private static int getCatalan(int n) {
		
		
		for (int i = 1; i <= n; i++) {
			
			if (C[i - 1] != 0 && C[n - i] != 0) 
			{
				C[n] += C[i - 1] * C[n - i]; 
			} 
			else if (C[i - 1] != 0) 
			{
				C[n] += C[i - 1] * getCatalan(n - i);
			} 
			else if (C[n - i] != 0) 
			{
				C[n] += getCatalan(i - 1) * C[n - i];
			}
			else 
			{
				C[n] += getCatalan(i - 1) * getCatalan(n - i);
			}
			
		}
		
		
		return C[n];
	}
}
