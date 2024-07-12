package tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class CNode {
	Node node, parent;
	
	public CNode() {
		node = parent = null;
	}
	public CNode(Node node, Node parent) {
		this.node = node;
		this.parent = parent;
	}
	
}

public class IsCousins {
	
	
	public static void main(String[] args) {
		Node root = new Node(1),
			 node2 = new Node(2),
			 node3 = new Node(3),
			 node4 = new Node(4),
			 node5 = new Node(5),
			 node6 = new Node(6),
			 node7 = new Node(7),
			 node8 = new Node(8),
			 node9 = new Node(9),
			 node10 = new Node(10),
			 node11 = new Node(11);
		root.left = node2;
		root.right = node9;
		node9.right = node10;
		node10.right = node11;
		node2.left = node3;
		node2.right = node4;
		node4.right = node5;
		node5.left = node6;
		node5.right = node7;
		node6.right = node8;
		System.out.println(isCousins2(root, node7, node6));
		
	}
	
	public static boolean isCousins2(Node root, Node a, Node b) {
		if (root == null) return false;
		
		//this level checks when travel over a level
		ArrayList<Integer> level = new ArrayList<Integer>();
		level.add(1);
		int i = 0,      // 0 <= i < sum of nodes
			count = 0; 	// num of child nodes
		
		//these for saving the parents of a and b 
		Node parents[] = new Node[2];
		int j = 0; // 0 <= j <= 1
		
		
		//add -> queue
		Queue<CNode> queue = new LinkedList<>();
		queue.add(new CNode(root, null));
		
		while (!queue.isEmpty()) {
			CNode temp = queue.remove();
			level.set(i, level.get(i) - 1);
			
			
			Node node = temp.node,
				 parent = temp.parent;
			
			if (node == a || node == b) {
				parents[j++] = parent;
				
				//Nếu xuất hiện 2 node cẩn kiểm tra ở cùng 1 level
				if (j == 2) {
					
					//Nếu chúng có cùng node cha -> false
					if (parents[0] == parents[1]) return false;
					
					return true;
				}
			}
			
			if (node.left != null) {
				queue.add(new CNode(node.left, node));
				count++;
			}
			
			if (node.right != null) {
				queue.add(new CNode(node.right, node));
				count++;
			} 
			
			//Nếu level(i) = 0 -> ta đã thăm hết level(i)
			if (level.get(i) == 0) {
				
				//Nếu j = 1  -> chứng tỏ 2 node này khác level
				if (j == 1) return false;
				
				i++;
				level.add(count);
				count = 0;
			}
		}
		
		return false;

	}
	
	
	
	/////////
	public static boolean isCousins(Node root, Node a, Node b) {
		if (root == null) return false;
		
		return !(getDepth(root, a) != getDepth(root, b) ||
				hasSameRoot(root, a, b));
		
	}
	
	public static boolean hasSameRoot(Node root, Node a, Node b) {
		if (root == null) return false;
		
		return (root.left == a && root.right == b) || 
				(root.left == b && root.right == a) ||
				hasSameRoot(root.left, a, b) ||
				hasSameRoot(root.right, a, b);
		
	}
	
	public static int getDepth(Node root, Node a) {
		
		if (root != null) {
			if (root == a) return 0;
			
			int ld = getDepth(root.left, a);
			if (ld != -1) return ld + 1;
			
			int rd = getDepth(root.right, a);
			if (rd != -1) return rd + 1;
		}
		
		return -1;
	}
	
}
