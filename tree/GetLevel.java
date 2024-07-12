package tree;

public class GetLevel {
	public static void main(String[] args) {
		Node root = new Node(0),
			 node1 = new Node(1),
			 node2 = new Node(2),
			 node3 = new Node(3);
		
		root.right = node1;
		node1.right = node2;
		node2.right = node3;
		System.out.println(getLevel(root, 0, 1));
	}
	static int getLevel(Node root, int key, int level) {
		
		if (root != null) {
			if (root.data == key) 
				return level;
			
			int left = getLevel(root.left, key, level + 1);
			if (left != 0) return left;
			
			return getLevel(root.right, key, level + 1);
		}
		
		return 0;		
	}
}
