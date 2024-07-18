package tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class FindAllBinaryTreeInorder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		
		int[] inorder = new int[length];
		
		for (int i = 0; i < length; i++) 
			inorder[i] = sc.nextInt();
		
		ArrayList<Node> trees = findAllBinaryTree(inorder, 0, length - 1);
		
		for (Node root : trees) {
			Traversal.preorder(root, true);
			System.out.println();
		}
		
	}
	
	static ArrayList<Node> findAllBinaryTree(int[] inorder, int start, int end) {
		
		ArrayList<Node> trees = new ArrayList<Node>();
		
		if (start > end) {
			trees.add(null);
			return trees;
		}
		
		for (int i = start; i <= end; i++) {
			
			ArrayList<Node> leftTree = findAllBinaryTree(inorder, start, i - 1);
			
			ArrayList<Node> rightTree = findAllBinaryTree(inorder, i + 1, end);
			
			for (int j = 0; j < leftTree.size(); j++) {
				for (int k = 0; k < rightTree.size(); k++) {
					
					Node root = new Node(inorder[i]);
					
					root.left = leftTree.get(j);
					
					root.right = rightTree.get(k);
					
					trees.add(root);
				}
			}
			
		}
		
		return trees;
	}
}
