package linkedlist;

import java.util.Scanner;

public class ReverseALinkedListInGroupsOfGivenSize {

	Node head;
	Node lastNode;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		sc.nextLine();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int n = sc.nextInt();
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			Node tail = head;
			for(int i = 1; i < n; i++) {
				int a = sc.nextInt();
				tail.next = new Node(a);
				tail = tail.next;
			}
			int k = sc.nextInt();
			ReverseInGrop reverseInGrop = new ReverseInGrop();
			Node res = reverseInGrop.reverse(head, k);
			printList(res);
			
		}
		sc.close();

	}


	public void addToTheLast(Node node) {
		if(head == null) {
			head = node;
			lastNode = node;
		} else {
			lastNode.next = node;
			lastNode = node;
		}
	}
	
	private static void printList(Node node) {
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
}

/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/
class ReverseInGrop
{
    public Node reverse(Node node, int k)
    {
    	Node resHead = null;
    	Node resTail = null;
    	Node myHead = node;
    	while(myHead != null) {
    		Node tempHead = myHead;
    		Node tempTail = null;
    		Node prevNode = null;
    		for(int i = 0; i < k && myHead != null; i++) {
    			prevNode = myHead;
    			myHead = myHead.next;
    		}
    		prevNode.next = null;
    		tempTail = tempHead;
    		tempHead = reverseList(tempHead);
    		
    		if(resHead == null) {
    			resHead = tempHead;
    			resTail = tempTail;
    		} else {
    			resTail.next = tempHead;
    			resTail = tempTail;
    		}
    	}
        return resHead;
    }
    
    
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
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1/
 * 
 * Given a linked list of size N. The task is to reverse every k nodes (where k
 * is an input to the function) in the linked list.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line contains length of linked list and next line contains the linked
 * list elements.
 * 
 * Output: For each testcase, there will be a single line of output which
 * contains the linked list with every k group elements reversed.
 * 
 * User Task: The task is to complete the function reverse() which should
 * reverse the linked list in group of size k.
 * 
 * Example: Input: 
 * 2 
 * 8 
 * 1 2 2 4 5 6 7 8 
 * 4 
 * 5 
 * 1 2 3 4 5 
 * 3
 * 
 * Output: 4 2 2 1 8 7 6 5 3 2 1 5 4
 * 
 * Explanation: Testcase 1: Since, k = 4. So, we have to reverse everty group of
 * two elements. Modified linked list is as 4, 2, 2, 1, 8, 7, 6, 5.
 * 
 * 
 * 
 */

//2
//8
//1 2 2 4 5 6 7 8
//4
//5
//1 2 3 4 5
//3
