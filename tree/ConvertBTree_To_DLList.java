package tree;

//Convert Binary Tree to Doubly Linked List using inorder traversal
public class ConvertBTree_To_DLList {
	public static void main(String[] args) {
		
		Node root = new Node(10),
			 node1 = new Node(12),
			 node2 = new Node(15),
			 node3 = new Node(25),
			 node4 = new Node(30),
			 node5 = new Node(36);
		
		root.left = node1;
		root.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		node2.left = node5;
		
		getDLL(root);
		
		while (in != null) {
			System.out.print(in.data + " ");
			in = in.pre;
		}
	}
	
	static DNode in = null;
	
	static void getDLL(Node root) {
		
		if (root != null) {
			getDLL(root.left);
			
			DNode temp = new DNode(root.data); 	
			
			if (in != null) {
				temp.pre = in;
				in.next = temp;
			}
			in = temp;
			System.out.println(temp.data);
			
			getDLL(root.right);
		}
		
	}
}	

class DNode {
	
	public int data;
	public DNode pre, next;
	
	public DNode(int data) {
		this.data = data;
		pre = next = null;
	}
}
