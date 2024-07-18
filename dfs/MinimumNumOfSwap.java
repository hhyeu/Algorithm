package dfs;

import java.util.Arrays;
import java.util.Scanner;

//Minimum number of swaps required to sort an array
public class MinimumNumOfSwap {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		int[] visited = new int[size];
		Arrays.fill(visited, 0);
		
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = sc.nextInt();
		
		int count = 0,
			totalSwap = 0;
		for (int i = 0; i < size; i++) {

			while (visited[i] != 1) {
				visited[i] = 1;
				count++;
				
				i = arr[i] - 1;
			}
			
			if (count != 0) { 
				totalSwap += (count - 1);
				count = 0;
			}
		}
		
		System.out.println(totalSwap);
	}
}
