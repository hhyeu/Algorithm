package test;

import tree.Node;

class Test0  {
	public static void main(String[] args) {
		Node a = new Node(2);
		System.out.println(a.data);
		change(a);
		System.out.println(a.data);
	}

	private static void change(Node a) {
		a.data = 3;
		
	}
	
	
}