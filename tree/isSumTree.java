package tree;

public class isSumTree {
	
	public static boolean isLeafNode(Node node) {
		if (node == null) return false;
		
		if (node.left == null && node.right == null) return true;
		
		return false;
	}
	
	public static boolean sumTree(Node root) {
		
		if (root == null || isLeafNode(root)) return true;
		
		
		int ls = 0, rs = 0;
		
		if (root.left == null) 
			ls = 0;
		else if (isLeafNode(root.left))
			ls = root.left.data;
		else
			ls = 2 * root.left.data;
			
		
		if (root.right == null) 
			rs = 0;
		else if (isLeafNode(root.right))
			rs = root.right.data;
		else
			rs = 2 * root.right.data;
		
		
		return ((root.data == ls + rs) &&
				sumTree(root.left) &&
				sumTree(root.right));
	}
}
