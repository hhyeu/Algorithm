package tree;

import java.util.Scanner; 

public class CalDepOfFullBTree {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		String arr[] = new String[size];
		
		for (int i = 0 ; i < size; i++)
			arr[i] = sc.next();
		
		System.out.println(getDepth(arr));
		
		
	}

	static int index = 0;
	
	public static int getDepth(String arr[]) {
		if (arr[index].equals("l")) return 0;
		
		index++;
		int left = getDepth(arr);
		
		index++;
		int right = getDepth(arr);
		
		return Math.max(left, right) + 1;
	}
}
