package linkedlist;

import java.util.Scanner;

public class DeleteWithoutHeadPointer {

	Node head;
	Node tail;
	
	void printList(Node head) {
		Node tnode = head;
		while(tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
		System.out.println();
	}
	
	void addToTheLast(Node node) {
		if(head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}
	
	Node search_Node(Node head, int k) {
		Node current = head;
		while(current != null) {
			if(current.data == k)
				break;
			current = current.next;
		}
		return current;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		sc.nextLine();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int n = sc.nextInt();
			DeleteWithoutHeadPointer llist = new DeleteWithoutHeadPointer();
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for(int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}
			
			int k = sc.nextInt();
			Node del = llist.search_Node(llist.head, k);
			Solution g = new Solution();
			if(del != null && del.next != null) {
				g.deleteNode(del);
			}
			llist.printList(llist.head);
			
		}
		sc.close();
	}

}

/*
class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/

// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted
class Solution
{
    void deleteNode(Node node)
    {

    	Node current = node; 
    	Node next = current.next;
    	current.next = next.next;
    	next.next = null;
    	current.data = next.data; 	

    }
}




/*
 * https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
 * 
 * You are given a pointer/ reference to the node which is to be deleted from
 * the linked list of N nodes. The task is to delete the node. Pointer/
 * reference to head node is not given. Note: No head reference is given to you.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line of input contains length of linked list and next line contains the
 * data of the linked list. The last line contains the node to be deleted.
 * 
 * Output: For each testcase, in a newline, print the linked list after deleting
 * the given node.
 * 
 * Your Task: This is a function problem. You only need to complete the function
 * deleteNode that takes reference to the node that needs to be deleted. The
 * printing is done automatically by the driver code.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 103
 * 
 * Example: Input: 2 2 1 2 1 4 10 20 4 30 20 Output: 2 10 4 30
 * 
 * Explanation: Testcase 1: After deleting 1 from the linked list, we have
 * remaining nodes as 2. Testcase 2: After deleting 20 from the linked list, we
 * have remaining nodes as 10, 4 and 30.
 * 
 */

