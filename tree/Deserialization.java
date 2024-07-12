package tree;

import java.util.Stack;

public class Deserialization {
	
	static Node deserialization(String file, String delimiter) {
		String[] preorder = file.split(delimiter);

		int i = 0;
		Node root = new Node(Integer.parseInt(preorder[i++]));
		
		Stack<Node> stack = new Stack<>();
		stack.add(root);
		
		while (i < preorder.length) {
			
			if (preorder[i].equals("#")) {
				i++;
				continue;
			}
			
			Node top = stack.peek(),
				 temp = new Node(Integer.parseInt(preorder[i++]));

			if (top.left == null) {
				top.left = temp;
			} else {
				top.right = temp;
				stack.pop();				
			}
			
			stack.push(temp);
		}
		
		return root;
	}
}
