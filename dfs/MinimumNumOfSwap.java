package dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import tree.Pair;

//Minimum number of swaps required to sort an array
public class MinimumNumOfSwap {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		
		int[] arr = new int[size];
		
		for (int i = 0; i < size; i++)
			arr[i] = sc.nextInt();
		
		int totalSwap = getMinSwap2(arr);
		
		System.out.println(totalSwap);
	}
	
	
	static int getMinSwap1(int[] arr) {
		int size = arr.length;
		
		int[] visited = new int[size];
		Arrays.fill(visited, 0);
		
		List<Pair<Integer, Integer>> list = new LinkedList<>();
		
		for (int i = 0; i < size; i++) 
			list.add(new Pair<>(arr[i], i));
		
		list.sort(
			new Comparator<Pair<Integer, Integer>>() {
				
				@Override
				public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
					return o1.key > o2.key ? 1 : -1;
				};
			}
		);
		
		int	totalSwap = 0;
		for (int i = 0; i < size; i++) {
			
			int count = 0;
			
			while (visited[i] != 1) {
				visited[i] = 1;
				
				count++;
				
				i = list.get(i).value;
			}
			
			if (count != 0) 
				totalSwap += (count - 1);
		}
		
		return totalSwap;
	}
	
	//greed algorithm
	static int getMinSwap2(int[] arr) {
		
		int[] sortedArr = Arrays.copyOfRange(arr, 0, arr.length);
		
		Arrays.sort(sortedArr);
		
		int minSwap = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i] != sortedArr[i]) {
				minSwap++;
				
				swap(arr, i, indexOf(arr, sortedArr[i]));
			}
		}
		
		return minSwap;
	}
	
	static int indexOf(int[] arr, int v) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == v)
				return i;
		}
		
		return -1;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
}
