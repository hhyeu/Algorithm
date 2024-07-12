package tree;

//Check if two trees are Mirror
public class Mirror {
	
	public static void main(String[] args) {
		Node root1 = new Node(1),
			 node11 = new Node(2),
			 node12 = new Node(3),
			 node13 = new Node(4);
		
		Node root2 = new Node(1),
			 node21 = new Node(2),
			 node22 = new Node(3),
			 node23 = new Node(4);
		
		root1.left = node11;
		node11.right = node12;
		node11.left = node13;
		
		root2.right = node21;
		node21.left = node22;
		node21.right = node23;
		
		System.out.println(mirror(root1, root2));
	}
	
	static boolean mirror(Node firstRoot, Node secondRoot) {
		
		if (firstRoot == null && secondRoot == null) return true;
		
		if (firstRoot == null || secondRoot == null) return false;
		
		return firstRoot.data == secondRoot.data &&
			   mirror(firstRoot.left, secondRoot.right) &&
			   mirror(firstRoot.right, secondRoot.left);
	}
}
