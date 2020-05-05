package linkedlist;

import java.util.Scanner;

public class RotateALinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		sc.nextLine();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int n = sc.nextInt();
			Node head = null;
			Node tail = null;
			for(int i =0; i < n; i++) {
				int a = sc.nextInt();
				if(i == 0) {
					head = new Node(a);
					tail = head;
				} else {
					tail.next = new Node(a);
					tail = tail.next;
				}
			}
			int k = sc.nextInt();
			
			Rotate g = new Rotate();
			head = g.rotate(head, k);
			printList(head);
			
		}
		
		sc.close();
	}

	private static void printList(Node node) {
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}


}


/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
*/
class Rotate {
    
     /*  This function should rotate list counter-
    clockwise by k and return new head (if changed) */
    public Node rotate(Node head, int k) {
    	Node tail = head;
    	Node prev = head;
    	for(int i = 0; i < k && head != null; i++) {
    		prev = head;
    		head = head.next;
    		if(head == null) {
    			head = tail;
    		}
    	}
    	if(k == 0 || head == tail) {
    		return tail;
    	}
    	prev.next = null;
    	prev = head;
    	while(prev != null && prev.next != null) {
    		prev = prev.next;
    	}
    	if(prev != null)
    	    prev.next = tail;
    	return head;
    }
}

//
//7
//8
//1 2 3 4 5 6 7 8
//4
//5
//2 4 7 8 9
//4
//9
//9 8 6 19 12 3 26 18 5
//9
//8
//1 2 3 4 5 6 7 8
//4
//5
//2 4 7 8 9
//3
//2
//1 2
//4
//2
//1 2
//3



/*
 * 
 * https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1
 *
 * Given a singly linked list of size N. The task is to rotate the linked list
 * counter-clockwise by k nodes, where k is a given positive integer smaller
 * than or equal to length of the linked list.
 * 
 * Input: The first line of input contains the number of testcases T. For each
 * test case, the first line of input contains the length of a linked list and
 * the next line contains linked list elements and the last line contains k, by
 * which linked list is to be rotated.
 * 
 * Output: For each test case, print the rotated linked list.
 * 
 * User Task: The task is to complete the function rotate() which takes a head
 * reference as the first argument and k as the second argument. The printing is
 * done automatically by the driver code.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 103 1 <= k <= 103
 * 
 * Example: Input: 2 8 1 2 3 4 5 6 7 8 4 5 2 4 7 8 9 Output: 5 6 7 8 1 2 3 4 8 9
 * 2 4 7
 * 
 * Explanation: Testcase 1: After rotating the linked list by 4 elements
 * (anti-clockwise), we reached to node 5, which is (k+1)th node from beginning,
 * now becomes head and tail of the linked list is joined to the previous head.
 * Testcase 2: After rotating the linked list by 3 elements (anti-clockwise), we
 * will get the resulting linked list as 8 9 2 4 7.
 * 
 */