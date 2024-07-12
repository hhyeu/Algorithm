package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BuildBSTreePreorder {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		
		List<Integer> preorder = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			int a = sc.nextInt();
			preorder.add(a);
		}
		
		Node root = buildBstreePreorder(preorder);
		Traversal.preorder(root, true);
	}
	
	
	static Node buildBstreePreorder(List<Integer> preorder) {
		if (preorder.isEmpty()) return null;
		
		int i = 0;

		Node root = new Node(preorder.get(i++));
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (i < preorder.size()) {
			
			Node temp = new Node(preorder.get(i++));
			Node top = stack.peek();
			
			if (temp.data < top.data) {
				
				stack.peek().left = temp;
			
			} else {	
				
				while (!stack.empty() && temp.data > stack.peek().data) {
					
					top = stack.pop();
				
				}
					
				top.right = temp;
								
			}
			
			stack.push(temp);
			
		}

		return root;
	}
}
