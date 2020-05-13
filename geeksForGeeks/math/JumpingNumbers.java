package math;

import java.util.Scanner;

public class JumpingNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		int[] aJumpingNumber = new int[10000];
		aJumpingNumber = createJumpingNumbers(aJumpingNumber);
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iNum = sc.nextInt();
			for(int i = 0; aJumpingNumber[i] <= iNum; i++) {
				System.out.print(aJumpingNumber[i] + " ");
			}
			System.out.println();
		}
		sc.close();
		
	}

	private static int[] createJumpingNumbers(int[] aJumpingNumber) {
		for(int i = 0; i < 10; i++) {
			aJumpingNumber[i] = i;
		}
		for(int i = 1, j = 9; aJumpingNumber[j] <= 1010101010; i++) {
			int iNum = aJumpingNumber[i];
			if(iNum % 10 > 0)
				aJumpingNumber[++j] = iNum*10 + iNum % 10 - 1;
			if(iNum % 10 < 9)
				aJumpingNumber[++j] = iNum*10 + iNum % 10 + 1;
		}
		return aJumpingNumber;
	}

}


/*
 * https://practice.geeksforgeeks.org/problems/jumping-numbers/0/
 * Given a positive number X. Find all Jumping Numbers smaller than or equal to
 * X. Jumping Number: A number is called Jumping Number if all adjacent digits
 * in it differ by only 1. All single digit numbers are considered as Jumping
 * Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and
 * 89098 are not.
 * 
 * Input: The first line of the input contains T denoting the number of
 * testcases. Each testcase contain a positive number X.
 * 
 * Output: Output all the jumping numbers less than X in sorted order. Jump to
 * example for better understanding.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 109
 * 
 * Example: Input: 2 10 50 Output: 0 1 2 3 4 5 6 7 8 9 10 0 1 2 3 4 5 6 7 8 9 10
 * 12 21 23 32 34 43 45
 * 
 * Explanation: Testcase 2: Here, the most significant digits of each jumping
 * number is following increasing order, i.e., jumping numbers starting from 0,
 * followed by 1, then 2 and so on, themselves being in increasing order 2, 21,
 * 23.
 * 
 */

//3
//10
//50
//1000041