package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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


		List<Pair<Integer, Integer>> inorder = getInorder(nodes);
		
		System.out.println(inorder);
		inorder.sort(
			new Comparator<Pair<Integer, Integer>>() {

				@Override
				public int compare(Pair<Integer,Integer> o1, Pair<Integer,Integer> o2) {
					return o1.key > o2.key ? 1 : -1;
				};

			}
		);
		
		
		boolean[] visited = new boolean[size];
		Arrays.fill(visited, false);
		
		int minSwap = 0;
		
		for (int i = 0; i < size; i++) {
			
			if (visited[i] == true)
				continue;
			
			int count = 0;
			
			while (visited[i] != true) {
				visited[i] = true;
				count++;
				i = inorder.get(i).value;
			}
			
			if (count != 0)
				minSwap += (count - 1);
		}
		
		System.out.println(minSwap);
	}
	
	static List<Pair<Integer, Integer>> getInorder(int[] nodes) {
		List<Pair<Integer, Integer>> inorder = new ArrayList<>();
		
		helper(nodes, inorder, 0);

		return inorder;
	}
	
	static int index = 0;
	
	static void helper(int[] nodes, List<Pair<Integer, Integer>> inorder, int i) {
		
		if (i >= nodes.length) return;
		
		helper(nodes, inorder, i * 2 + 1);
		
		inorder.add(new Pair<>(nodes[i], index++));
		
		helper(nodes, inorder, i * 2 + 2);
		
	}
	
	
	
}
