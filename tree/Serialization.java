package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Serialization {
	
	//turn binary tree -> a preorder string
	static String serialization(Node root, String delimiter) {
		
		if (root == null) return null;
		
		List<String> file = new LinkedList<>();
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.empty()) {
			
			Node top = stack.pop();
			
			if (top == null) {
				
				file.add("#");
				
			} else {
				
				file.add("" + top.data);
				
				stack.add(top.right);
				stack.add(top.left);
			}
			
		}
		
		return String.join(delimiter, file);
	}
}
