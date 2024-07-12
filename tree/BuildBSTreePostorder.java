package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BuildBSTreePostorder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		
		List<Integer> postorder = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			int a = sc.nextInt();
			postorder.add(a);
		}
		
		Node root = buildBstreePostorder(postorder);
		Traversal.preorder(root, true);
	}

	static Node buildBstreePostorder(List<Integer> postorder) {
		
		if (postorder.isEmpty()) return null;
		
		int i = postorder.size() - 1;
		
		Node root = new Node(postorder.get(i--));
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while (i >= 0) {
			Node temp = new Node(postorder.get(i--));
			Node top = stack.peek();
			
			if (temp.data > top.data) {
				
				top.right = temp;
				
			} else {
				
				while (!stack.empty() && temp.data < stack.peek().data) {
					
					top = stack.pop();
					
				}
				
				top.left = temp;
				
			}
			
			stack.push(temp);
			
		}
		
		return root;
	}
}
