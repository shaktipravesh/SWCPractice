package linkedlist;

import java.util.Scanner;

public class GivenALinkedListOf0s1sAnd2sSortIt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		sc.nextLine();
		for (int iTemp = 1; iTemp <= iTestCt; iTemp++) {
			int iCount = sc.nextInt();
			Node head = new Node(sc.nextInt());
			Node tail = head;
			while (iCount-- > 1) {
				tail.next = new Node(sc.nextInt());
				tail = tail.next;
			}
			new LinkedList();
			head = LinkedList.segregate(head);
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

class LinkedList {
	static Node segregate(Node head) {
		Node zeroHead = null;
		Node zeroTail = null;
		Node oneHead = null;
		Node oneTail = null;
		Node twoHead = null;
		Node twoTail = null;
		Node temp = head;
		while (temp != null) {
			if (temp.data == 0) {
				if (zeroHead == null) {
					zeroHead = temp;
					zeroTail = temp;
				} else {
					zeroTail.next = temp;
					zeroTail = zeroTail.next;
				}
			} else if (temp.data == 1) {
				if (oneHead == null) {
					oneHead = temp;
					oneTail = temp;
				} else {
					oneTail.next = temp;
					oneTail = oneTail.next;
				}
			} else if (temp.data == 2) {
				if (twoHead == null) {
					twoHead = temp;
					twoTail = temp;
				} else {
					twoTail.next = temp;
					twoTail = twoTail.next;
				}
			} else {

			}
			temp = temp.next;
		}

		if (zeroHead != null) {
			temp = zeroHead;
			if (oneHead != null) {
				zeroTail.next = oneHead;
				if (twoHead != null) {
					oneTail.next = twoHead;
					twoTail.next = null;
				} else {
					oneTail.next = null;
				}
			} else if (twoHead != null) {
				zeroTail.next = twoHead;
				twoTail.next = null;
			} else {
				zeroTail.next = null;
			}
		} else if (oneHead != null) {
			temp = oneHead;
			if (twoHead != null) {
				oneTail.next = twoHead;
				twoTail.next = null;
			} else {
				oneTail.next = null;
			}
		} else if (twoHead != null) {
			temp = twoHead;
			twoTail.next = null;
		} else {
			;// do nothing
		}

		return temp;
	}

}


/*
 * https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
 * 
 * Given a linked list of N nodes where nodes can contain values 0s, 1s and 2s
 * only. The task is to segregate 0s, 1s and 2s linked list such that all zeros
 * segregate to headside, 2s at the end of the linked list and 1s in the mid of
 * 0s and 2s.
 * 
 * Input: First line of input contains number of testcases T. For each testcase,
 * first line of input contains length of linked list and next line contains N
 * elements as the data in the linked list.
 * 
 * Output: For each testcase, segregate the 0s, 1s and 2s and display the linked
 * list.
 * 
 * Your Task: The task is to complete the function segregate() which segregate
 * the nodes in the linked list as asked in the problem statement. The printing
 * is done automatically by the driver code.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 103
 * 
 * User Task: The task is to complete the function sortList() which takes head
 * reference as the argument and returns void.
 * 
 * Example: Input: 2 8 1 2 2 1 2 0 2 2 4 2 2 0 1 Output: 0 1 1 2 2 2 2 2 0 1 2 2
 * 
 * Explanation: Testcase 1: All the 0s are segregated to left end of the linked
 * list, 2s to the right end of the list and 1s in between. Testcase 2: After
 * arranging all the 0s,1s and 2s in the given format , output will be 0 1 2 2.
 */