package classic;

import java.util.Scanner;

public class Combination {
	static Scanner sc = new Scanner(System.in);
	static int[][] C;
	
	public static void main(String[] args) {
		
		
		System.out.print("k = ");
		int k = sc.nextInt();
		System.out.print("n = ");
		int n = sc.nextInt();
		
		C = new int[n + 1][n + 1];
		
		System.out.println(getComb(k, n));
		
	}
	
	static int getComb(int k, int n) {
		
		if (k == 0 || k == n) {
			
			C[k][n] = 1;
			
		} else if (C[k - 1][n - 1] != 0 && C[k][n - 1] != 0){
			
			C[k][n] = C[k - 1][n - 1] + C[k][n - 1];
			
		} else {
			
			C[k][n] = getComb(k - 1, n - 1) + getComb(k, n - 1);
			
		}
		
		return C[k][n];
	}
}
