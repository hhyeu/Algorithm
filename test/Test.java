package test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import tree.Node;



public class Test {
	
	
	public static void main(String[] args) {
		
		Comparator<Node> com = (i, j) -> i.data > j.data ? 1 : 0;
		
		List<Node> nodes = new LinkedList<Node>();

		for (int i = 3; i > 0; i--) 
			nodes.add(new Node(i));
		
		Collections.sort(nodes, com);
		
		for (Node p : nodes)
			System.out.println(p.data);
	}
}
