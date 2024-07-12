package tree;

import java.util.Scanner;

//Subtree with given sum in a Binary Tree
public class SumOfSubTree {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = sc.nextInt();
		
		Node root = new Node(1),
			 node1 = new Node(3),
			 node2 = new Node(6),
			 node3 = new Node(5),
			 node4 = new Node(9),
			 node5 = new Node(8);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		
		System.out.println(isSumOfSubTree(root, sum));
	}
	static boolean isSumOfSubTree(Node root, int sum) {
		
		return (sumOfSubTree(root, sum) == sum);
	}
	
	static int sumOfSubTree(Node root, int sum) {
		
		if (root == null) return 0;
		
		int left = sumOfSubTree(root.left, sum);
		if (left == sum) return left;
		
		int right = sumOfSubTree(root.right, sum);
		if (right == sum) return right;
		
		return root.data + left + right;
	}
}
