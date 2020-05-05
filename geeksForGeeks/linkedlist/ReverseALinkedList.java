package linkedlist;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReverseALinkedList {

	Node head;
	Node lastNode;
	static PrintWriter out;
	
	public void addToTheLast(Node node) {
		if(head == null) {
			head = node;
			lastNode = node;
		} else {
			lastNode.next = node;
			lastNode = node;
		}
	}
	

	
	void printList() {
		Node temp = head;
		while(temp != null) {
			out.print(temp.data + " ");
			temp = temp.next;
		}
		out.println();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t  = Integer.parseInt(br.readLine());
		
		while(t >0) {
			int n = Integer.parseInt(br.readLine());
			ReverseALinkedList rll = new ReverseALinkedList();
			String nums[] = br.readLine().split(" ");
			if(n > 0) {
				int a1 = Integer.parseInt(nums[0]);
				Node head = new Node(a1);
				rll.addToTheLast(head);
			}
			for(int i = 0; i < n; i++) {
				int a = Integer.parseInt(nums[i]);
				rll.addToTheLast(new Node(a));
			}
			
			rll.head = new ReverseLL().reverseList(rll.head);
			rll.printList();
			
			t--;
		}
		out.close();
	}

}


class ReverseLL
{
    // This function should reverse linked list and return
   // head of the modified linked list.
   Node reverseList(Node head)
   {
	   Node myHead = null;
	   Node next = null;
	   Node current = head;
	   while(current != null) {
		   myHead = current;
		   current = current.next;
		   myHead.next = next;
		   next = myHead;
	   }
       return myHead;
   }
}


/*
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1/
 * 
 * Given a linked list of N nodes. The task is to reverse this list.
 * 
 * Input: Head of following linked list 1->2->3->4->NULL Output: Linked list
 * should be changed to, 4->3->2->1->NULL
 * 
 * Input: Head of following linked list 1->2->3->4->5->NULL Output: Linked list
 * should be changed to, 5->4->3->2->1->NULL
 * 
 * Input: NULL Output: NULL
 * 
 * Input: 1->NULL Output: 1->NULL
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line contains length of linked list and next line contains the elements
 * of linked list.
 * 
 * Output: Reverse the linked list and return head of the modified list.
 * 
 * User Task: The task is to complete the function reverseList() which head
 * reference as the only argument and should return new head after reversing the
 * list.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 103
 * 
 * Example: Input: 2 6 1 2 3 4 5 6 5 2 7 8 9 10 Output: 6 5 4 3 2 1 10 9 8 7 2
 * 
 * Explanation: Testcase 1: After reversing the list, elements are as
 * 6->5->4->3->2->1. Testcase 2: After reversing the list, elements are as
 * 10->9->8->7->2.
 * 
 */
//
//2
//6
//1 2 3 4 5 6
//5
//2 7 8 9 10



