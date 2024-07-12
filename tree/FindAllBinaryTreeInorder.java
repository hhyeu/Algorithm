package tree;

import java.util.ArrayList; 
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FindAllBinaryTreeInorder {
	
	static Scanner sc = new Scanner(System.in);
	static int length;
	static int[] inorder;
	static HashMap<Integer, Integer> hm;
	public static void main(String[] args) {
		length = sc.nextInt();
		
		inorder = new int[length];
		
		int[] preorder = new int[length];

		hm = new HashMap<>();
		
		for (int i = 0; i < length; i++) {
			inorder[i] = i;
			hm.put(i, i);
		}

		Rec(preorder, 0);
	}
	
	static int count = 1;
	
	static void print(int[] preorder) { 
		System.out.print(count + "-");
		count++;
		for (int a : preorder) {
			System.out.print(a + " ");
		}
		System.out.println();
	}
	
	static boolean check(int[] preorder, int k, int v) {
		for (int i = 0; i < k; i++) {
			if (preorder[i] == v) return false;
		}
		
		return true;
	}
	
	static void Rec(int[] preorder, int k) {
		for (int i = 0; i < length; i++) {
			
			if (check(preorder, k, inorder[i])) {
				
				preorder[k] = inorder[i];
				
				if (k == length - 1) {
					
					if(canBuild(preorder, 0, k)) {
					print(preorder);
					}

					preIndex = 0;
				}
				else
					Rec(preorder, k + 1);
			}
		}
	}
	
	static int preIndex = 0;
	static boolean canBuild(int[] preorder, int start, int end) {

		if (start > end) return true;
		
		if (start == end) {
			if (preorder[preIndex++] == inorder[start]) {
				return true;
			}
			return false;
		}

		int inIndex = hm.get(preorder[preIndex++]);
		
		if (inIndex > end || inIndex < start) return false;
		
		boolean left = canBuild(preorder, start, inIndex - 1);
		if (left == false) return false;
		
		return canBuild(preorder, inIndex + 1, end);
	}
	
}
