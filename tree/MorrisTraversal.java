package tree;

public class MorrisTraversal {
	
	public static void main(String[] args) {
		Node root = new Node(0),
			 node1 = new Node(1),
			 node2 = new Node(2),
			 node3 = new Node(3),
			 node4 = new Node(4),
			 node5 = new Node(5);
		
		root.right = node1;
		node1.right = node2;
		node2.right = node3;
		node3.right = node4;
		node4.right = node5;
		
		morrisInorder(root);
		System.out.println();
		Traversal.postorder(root, true);
	}
	
	static void morrisPostorder(Node root) {
		while (root != null) {
			
			if (root.left == null)
			{
				System.out.print(root.data + " ");
				root = root.right;
			}
			else 
			{
				Node curr = root.left;
				
				while (curr.right != null && curr.right != root) 
					curr = curr.right;
				
				if (curr.right == root) 
				{
					System.out.print(root.data + " ");
					curr.right = null;
					root = root.right;
				}
				else 
				{
					curr.right = root;
					root = root.left;
				}
			}
		}
	}
	static void morrisInorder(Node root) {
		
		while (root != null) {
			
			if (root.left == null)
			{
				System.out.print(root.data + " ");
				root = root.right;
			}
			else 
			{
				Node curr = root.left;
				
				while (curr.right != null && curr.right != root) 
					curr = curr.right;
				
				if (curr.right == root) 
				{
					System.out.print(root.data + " ");
					curr.right = null;
					root = root.right;
				}
				else 
				{
					curr.right = root;
					root = root.left;
				}
			}
		}
	}
	
	static void morrisPreorder(Node root) {
		
		while (root != null) {
			
			if (root.left == null) 
			{
				System.out.print(root.data + " ");
				root = root.right;
			} 
			else 
			{
				Node curr = root.left;
				
				while (curr.right != null && curr.right != root) 
					curr = curr.right;
				
				if (curr.right == root)
				{
					curr.right = null;
					root = root.right;
				}
				else 
				{
					System.out.print(root.data + " ");
					curr.right = root;
					root = root.left;
				}
			}
			
		}
		
	}
}
