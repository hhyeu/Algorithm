package tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsPerfect {
	
	public static void main(String[] args) {
		Node root = new Node(0),
			 node1 = new Node(1),
			 node2 = new Node(2),
			 node3 = new Node(3),
			 node4 = new Node(4),
			 node5 = new Node(5),
			 node6 = new Node(6),
			 node7 = new Node(7);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		node6.left = node7;
		System.out.println(isPerfect(root));
	}
	
	
	static boolean isPerfect(Node root) {
		
		if (root == null) return true;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		
		int level = 1,
			flag = 1;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			
			LinkedList<Integer> valueList = new LinkedList<Integer>();

			for (int i = 0; i < size; i++) {
				Node temp = queue.poll();

				valueList.add(temp.data);
				
				if (temp.left != null) 
					queue.add(temp.left);
				if (temp.right != null) 
					queue.add(temp.right);
				
			}
			
			if (valueList.size() != level) {
				flag = 0;
				break;
			}
			
			level = level * 2;
		}
		
		return flag == 1;
	}
	
}
