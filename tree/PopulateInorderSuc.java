package tree;

//Populate Inorder Successor for all nodes
public class PopulateInorderSuc {
	
	public static void main(String[] args) {

		//inorder : left -> root -> right
		INode root = new INode(0),
			  node1 = new INode(1),
			  node2 = new INode(2);
		
		root.left = node1;
		root.right = node2;
		
		root = populate(root);

		INode temp = root;
		while (temp.left != null) 
			temp = temp.left;
		
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}
	static INode iNode = null;
	static INode populate(INode root) {
		if (root != null) {
			populate(root.left);

			if (iNode != null) {
				iNode.next = root;
			}
			iNode = root;
			
			populate(root.right);
		}
		
		return root;
	}
	
	
}

class INode {
	int data;
	INode left, right, next;
	
	public INode(int data) {
		this.data = data;
		left = right = next = null;
	}
}
