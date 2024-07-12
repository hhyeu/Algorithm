package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BuildFullTreePreorder {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		
		List<Integer> preorder = new ArrayList<>(),
					  internal = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			int a = sc.nextInt(),
				b = sc.nextInt();
			preorder.add(a);
			internal.add(b);
		}
		
		Node root = buildFullTreePreorder(preorder, internal);
		Traversal.postorder(root, true);
	}

	static Node buildFullTreePreorder(List<Integer> preorder, List<Integer> internal) {
		
		if (preorder.isEmpty()) return null;
		
		int i = 0;
		Node root = new Node(preorder.get(i++));
		
		Stack<Node> stack = new Stack<>();
		stack.add(root);
		
		while (i < preorder.size()) {
			
			Node top = stack.peek();
			Node temp = new Node(preorder.get(i));
			
			if (top.left == null) {
				top.left = temp;
			} else {
				top.right = temp;
				stack.pop();
			}
			
			if (internal.get(i) == 1) {
				stack.push(temp);
			}
			
			i++;
		}
		
		return root;
	
	}
}
