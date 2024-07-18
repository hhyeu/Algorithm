package tree;

public class Node implements Comparable<Node>{
	public Integer data;
	public String value;
	public Node left, right;

	public Node() {
		this.data = null;
		this.left = this.right = null;
	}
	
	public Node(Integer data) {
		this.data = data;
		this.left = this.right = null;
	}
	
	public Node (String value) {
		this.value = value;
		this.left = this.right = null;
	}
	
	public int getNodes(Node root) {
		if (root == null) return 0;
		
		return 1 + getNodes(root.left) + getNodes(root.right);
	}
	
	public int getAllData(Node root) {
		if (root == null) return 0;
		
		return root.data + getAllData(root.left) + getAllData(root.right);
	}

	@Override
	public int compareTo(Node that) {
		// TODO Auto-generated method stub
		return this.data - that.data;
	}
}
