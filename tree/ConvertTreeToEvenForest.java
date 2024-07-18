package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Convert a tree to forest of even nodes --> greedy
public class ConvertTreeToEvenForest {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int size = sc.nextInt();
		
		if (size % 2 == 1 || size == 0) {
			System.out.println(removalEdges);
			System.exit(-1);
		}
		
		List<Integer>[] adj = new List[size];
		for (int i = 0; i < size; i++)
			adj[i] = new LinkedList<Integer>();

		for (int i = 0; i < size - 1; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			adj[start - 1].add(end - 1);
		}
		countNode(adj, 0);
		System.out.println(removalEdges);
	}
	
	static int removalEdges = -1;
	
	static int countNode(List<Integer>[] adj, int i) {
		
		if (adj[i].isEmpty()) return 1;
		
		int count = 1;
		
		for (Integer child : adj[i]) 
			count += countNode(adj, child);
		
		if (count % 2 == 0)
			removalEdges++;
			
		return count;
	}
	
	
}
