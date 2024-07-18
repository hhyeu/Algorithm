package tree;

import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		LinkedList<Node> nodes = new LinkedList<Node>();
		
		for (int i = 0; i < 3; i++)
			nodes.add(new Node(i));
		
		System.out.println(nodes);
	}
}
