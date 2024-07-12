package tree;

import java.util.ArrayList;

public class GNode {
	int data;
	String value;
	ArrayList<GNode> childs;
	
	GNode (int data) {
		this.data = data;
		childs = new ArrayList<>();
	}
	
	GNode (String value) {
		this.value = value;
		childs = new ArrayList<>();
	}
	
	static int getNodes(GNode root) {
		if (root == null) return 0;
		
		int sum = 0;
		
		for (GNode node : root.childs) {
			sum += getNodes(node);
		}
		
		return sum + 1;
	}
}
