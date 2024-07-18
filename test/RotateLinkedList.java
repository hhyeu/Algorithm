package test;

import java.util.Scanner;

//Rotate a Linked List
public class RotateLinkedList {
	
	
	static Node rotate(Node head, int k) {
		
		if (head == null || 
			head.next == null) return head;
		
		Node temp = head;
		while (k > 1) {
			temp = temp.next;
			k--;
		}
		
		if (temp.next == null) return head;
		
		Node newhead = temp.next;
		temp.next = null;
		temp = newhead;
		
		while (temp.next != null) 
			temp = temp.next;
		
		temp.next = head;
		
		return newhead;
	}
}

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		next = null;
	}
}
