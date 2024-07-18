package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//Minimize deletion of edges to convert Tree into a forest of size at most N/2
public class ConvertTreeToHalfForest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		if (size == 0) {
			System.out.println(removalEdges);
			System.exit(0);
		}
		
		List<Integer>[] adj = new List[size];
		for (int i = 0; i < size; i++)
			adj[i] = new LinkedList<Integer>();

		for (int i = 0; i < size - 1; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			adj[start].add(end);
		}
		
		countNode(adj, 0, size);
		System.out.println(removalEdges);
	}
	static int removalEdges = 0;
	static int countNode(List<Integer>[] adj, int i, int size) {
		
		if (adj[i].isEmpty()) return 1;
		
		int count = 1;
		
		for (Integer child : adj[i]) {
			int temp = countNode(adj, child, size);
			
			if (count + temp > size / 2) {
				removalEdges++;
			} else {
				count += temp;
			}
		}
			
		return count;
	}
}
