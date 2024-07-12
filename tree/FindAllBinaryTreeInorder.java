package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FindAllBinaryTreeInorder {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		List<Integer> inorder = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			int data = sc.nextInt();
			inorder.add(data);
		}
		
		findAllBinaryTreeInorder(inorder);
	}

	private static void findAllBinaryTreeInorder(List<Integer> inorder) {

		for (int i = 0; i < inorder.size(); i++) 
			findPreorder(i, inorder, 0, inorder.size() - 1);
		
	}

	private static void findPreorder(int rootIndex, List<Integer> inorder, int start, int end) {
		
		if (start < 0 || end < 0) return;
		
		if (start == end) {
			System.out.println(inorder.get(start) + " ");
			return;
		}
		
		System.out.println(inorder.get(rootIndex) + " ");
		
		//left
		findPreorder(rootIndex, inorder, start, rootIndex - 1);
				
		//right
		findPreorder(rootIndex, inorder, rootIndex + 1, end);
	}
	
	
}
