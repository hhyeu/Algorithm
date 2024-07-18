package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Minimum swap required to convert complete binary tree to binary search tree
public class ConvertBTreeToBST {	
	
	static int[] nodes;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		nodes = new int[size];
		
		for (int i = 0; i < size; i++) 
			nodes[i] = sc.nextInt();


		
		List<Integer> inorder = getInorder(nodes);
		System.out.println(inorder);
		int min, count = 0;
		for (int i = 0; i < size; i++) {
			min = i;
			for (int j = i; j < size; j++) {
				if (inorder.get(min) > inorder.get(j)) min = j;
			}
			
			if (min != i) {
				int temp = inorder.get(i);
				inorder.set(i, inorder.get(min));
				inorder.set(min, temp);
				count++;
			}
			
		}
		
		System.out.println(count);
	}
	static List<Integer> getInorder(int[] nodes) {
		
		List<Integer> inorder = new ArrayList<Integer>();
		
		helper(nodes, inorder, 0);

		return inorder;
	}
	
	static void helper(int[] nodes2, List<Integer> inorder, int i) {
		
		if (i >= nodes.length) return;
		
		helper(nodes, inorder, i * 2 + 1);
		
		inorder.add(nodes[i]);
		
		helper(nodes, inorder, i * 2 + 2);
		
	}
	
	
	
}
