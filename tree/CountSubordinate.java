package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountSubordinate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		//direct subordinate
		List<Integer>[] diSub = new ArrayList[size + 1];
		
		for (int i = 1; i <= size; i++) {
			diSub[i] = new ArrayList<>();
		}
		
		for (int i = 2; i <= size; i++) {
			int pos = sc.nextInt();
			diSub[pos].add(i);
		}
		
		countSubordinate(diSub);
	}
	
	static void countSubordinate(List<Integer>[] diSub) {
		int[] sub = new int[diSub.length]; 
		
		helper(diSub, sub, 1);
		
		for (int i = 1; i < sub.length; i++) {
			System.out.print(sub[i] + " ");
		}
		
	}

	static int helper(List<Integer>[] diSub, int[] sub, int index) {
		
		
		for (Integer a : diSub[index]) {
			sub[index] += (helper(diSub, sub, a) + 1);
		}
		
		return sub[index];
	}
	
	
}
