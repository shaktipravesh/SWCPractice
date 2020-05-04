package linkedlist;

import java.util.Scanner;

public class FindingMiddleElementInALinkedList {

	Node head;
	public void addToTheLast(Node node) {
		if(head == null) {
			head = node;
		} else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		sc.nextLine();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int n = sc.nextInt();
			FindingMiddleElementInALinkedList llist = new FindingMiddleElementInALinkedList();
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for(int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}
			
			FindMiddleSolution findMiddle = new FindMiddleSolution();
			System.out.println(findMiddle.getMiddle(llist.head));
		}
		sc.close();

	}

}

class FindMiddleSolution
{
    int getMiddle(Node node)
    {

    	int iMiddle = 0;
    	Node singleMove = node;
    	Node doubleMove = node;
    	while(doubleMove != null && doubleMove.next != null) {
    		singleMove = singleMove.next;
    		doubleMove = doubleMove.next.next;
    	}

    	iMiddle = singleMove.data;
    	return iMiddle;
    }
}


/*
 * https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1
 * 
 * Given a singly linked list of N nodes. The task is to find middle of the
 * linked list. For example, if given linked list is 1->2->3->4->5 then output
 * should be 3. If there are even nodes, then there would be two middle nodes,
 * we need to print second middle element. For example, if given linked list is
 * 1->2->3->4->5->6 then output should be 4.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line of input contains length of linked list and next line contains
 * data of nodes of linked list.
 * 
 * Output: For each testcase, there will be a single line of output containing
 * data of middle element of linked list.
 * 
 * User Task: The task is to complete the function getMiddle() which takes head
 * reference as the only argument and should return the data at the middle node
 * of linked list.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 100
 * 
 * Example: Input: 2 5 1 2 3 4 5 6 2 4 6 7 5 1
 * 
 * Output: 3 7
 * 
 * Explanation: Testcase 1: Since, there are 5 elements, therefore 3 is the
 * middle element at index 2 (0-based indexing).
 */