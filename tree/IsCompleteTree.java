package tree;

import java.util.LinkedList;
import java.util.Queue;

//Check whether a given Binary Tree is Complete or not
public class IsCompleteTree {
	
	public static void main(String[] args) {
		Node root = new Node(0),
			 node1 = new Node(1),
			 node2 = new Node(2),
			 node3 = new Node(3),
			 node4 = new Node(4),
			 node5 = new Node(5);
	
		root.left = node1;
		root.right = node2;
		node1.left = node3;
//		node1.right = node4;
//		node3.left = node5;
		
		int[] pre = {0};
		
		System.out.println(isCompleteTree2(root, 0, root.countNumOfNodes(root)));
	}
	
	
	static boolean isCompleteTree1(Node root) {
		
		if (root == null) return true;
		
		boolean flag = false;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				
				Node temp = queue.poll();
				
				
				if (temp == null) {
					flag = true;
				} else {
					if (flag) return false;
					
					queue.add(temp.left);
					queue.add(temp.right);
				}
			}
			
		}
		
		return true;
	}
	
	static boolean isCompleteTree2(Node root, int index, int numOfNodes) {

		if (root == null) return true;
		
		if (index >= numOfNodes) return false;
		
		return isCompleteTree2(root.left, 2 * index + 1, numOfNodes) &&
				isCompleteTree2(root.right,  2 * index + 2, numOfNodes);
	}
	
	static int getDepth(Node root) {
		int count = 0;
		
		while (root != null) {
			count++;
			root = root.left;
		}
		
		return count;
	}
}
