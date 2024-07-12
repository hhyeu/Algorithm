package tree;

import java.util.HashMap;
import java.util.Scanner;



public class BuildTreeInorderPreorder {
	
	static HashMap<String, Integer> hm = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	static int pIndex = 0;
	
	public static void main(String[] args) {
		int size = sc.nextInt();
		
		String  in[] = new String[size],
				pre[] = new String[size];
		
		for (int i = 0; i < size; i++) {
			in[i] = sc.next();
			hm.put(in[i], i);
		}
		
		for (int i = 0; i < size; i++)
			pre[i] = sc.next();
		
		Node root = buildTree(in, pre, 0, size - 1);
		Traversal.preorder(root);
	}

	public static Node buildTree(String[] in, String[] pre, int start, int end) {
		
		if (start > end) return null;
		
		Node root = new Node(pre[pIndex]);
		
		if (start == end) return root;
		
		int iIndex = hm.get(pre[pIndex++]);
		
		root.left = buildTree(in, pre, start, iIndex - 1);
		
		root.right = buildTree(in, pre, iIndex + 1, end);
		
		return root;
	}
	
	
	
	
	
}
