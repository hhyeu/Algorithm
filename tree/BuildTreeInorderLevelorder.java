package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildTreeInorderLevelorder {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int size = sc.nextInt();
		
		String  in[] = new String[size],
				le[] = new String[size];
		
		for (int i = 0; i < size; i++) {
			in[i] = sc.next();
		}
		
		for (int i = 0; i < size; i++)
			le[i] = sc.next();
		
		Node root = buildTree(in, le, 0, size - 1);
		Traversal.inorder(root);
	}

	private static Node buildTree(String[] in, String[] le, int start, int end) {
		if (start > end) return null;
		
		Node root = new Node(le[0]);
		
		if (start == end) return root;
		
		int index = -1;
		for (int i = start; i <= end; i++) {
			if (root.value.equals(in[i])) {
				index = i;
				break;
			}
		}
		
		HashMap<String, Integer> inLeft = new HashMap<>();
		for (int i = start; i < index; i++) 
			inLeft.put(in[i], i);
		
		//le : a b c d e f (d -> index)
		//leLeft : a b c
		//leRight : e f
		String[] leLeft = new String[inLeft.size()],
				 leRight = new String[le.length - inLeft.size() - 1];
		
		int li = 0,
			ri = 0;
		for (int i = 1; i < le.length; i++) {
			
			if (inLeft.containsKey(le[i])) 
				leLeft[li++] = le[i];
			else 
				leRight[ri++] = le[i];
			
		}
		
		root.left = buildTree(in, leLeft, start, index - 1);
		root.right = buildTree(in, leRight, index + 1, end);
		
		return root;
	}
	
	
}
