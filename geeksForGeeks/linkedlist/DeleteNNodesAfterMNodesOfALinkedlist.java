package linkedlist;

import java.util.Scanner;

public class DeleteNNodesAfterMNodesOfALinkedlist {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		sc.nextLine();
		for (int iTemp = 1; iTemp <= iTestCt; iTemp++) {
			int iCount = sc.nextInt();
			int iM = sc.nextInt();
			int iN = sc.nextInt();
			Node head = new Node(sc.nextInt());
			Node tail = head;
			while (iCount-- > 1) {
				tail.next = new Node(sc.nextInt());
				tail = tail.next;
			}

			new DeleteNNodesAfterMNodes().linkdelete(head, iM, iN);
			printList(head);
		}
		sc.close();
	}

	public static void printList(Node head) {
		if (head == null)
			return;
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

}

class DeleteNNodesAfterMNodes {
	static void linkdelete(Node head, int M, int N) {
		int iM = M, iN = N;
		Node temp = head;
		while (temp != null) {
			M = iM;
			N = iN;
			Node mNode = temp;
			Node nNode = mNode;
			while (M-- > 1 && mNode != null) {
				mNode = mNode.next;
			}

			if (iM > 0) {
				if(mNode != null) {
					nNode = mNode.next;
				} else {
					nNode = mNode;
				}
			}

			while (N-- > 0 && nNode != null) {
				Node delete = nNode;
				nNode = nNode.next;
				delete = null;
			}
			if (iM > 0) {
				if(mNode != null)
					mNode.next = nNode;
			}
			else
				mNode = nNode;
			temp = nNode;
		}
	}
}



/*
 * https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1/
 * 
 * 
 * Given a linked list, delete N nodes after skipping M nodes of a linked list
 * until the last of the linked list.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line of input contains number of elements in the linked list and next M
 * and N respectively space separated. The last line contains the elements of
 * the linked list.
 * 
 * Output: Function should not print any output to stdin/console.
 * 
 * User Task: The task is to complete the function linkdelete() which should
 * modify the linked list as required.
 * 
 * Example: Input: 2 8 2 1 9 1 3 5 9 4 10 1 6 6 1 1 2 3 4 5 6
 * 
 * Output: 9 1 5 9 10 1 1 2 3 4 5 6
 * 
 * Explanation: Testcase 1: Deleting one node after skipping the M nodes each
 * time, we have list as 9-> 1-> 5-> 9-> 10-> 1.
 */


//5
//8
//2 1
//9 1 3 5 9 4 10 1
//6
//6 1
//1 2 3 4 5 6
//6
//1 2
//8 4 9 10 1 3
//6
//0 2
//8 4 9 10 1 3
//6
//2 0
//8 4 9 10 1 3
