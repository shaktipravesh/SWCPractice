package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		sc.nextLine();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize = sc.nextInt();
			int[] aNum = new int[iSize];
			for(int i = 0; i < iSize; i++) {
				aNum[i] = sc.nextInt();
			}
			
			int iLongestSubSeq = Subseq.findLongestConseqSubseq(aNum, iSize);
			System.out.println(iLongestSubSeq);
			
		}
		sc.close();
	}

}

//User function Template for Java

class Subseq
{   
  // Function to find Longest Consecutive Subsequence
	static int findLongestConseqSubseq(int arr[], int n)
	{
		int iLongestSubSeq = 1, iSubSeq = 1;
		if(n == 0)
			return 0;
		Arrays.parallelSort(arr);
		for(int i = 1; i < n; i++) {
			if(arr[i] == (arr[i-1] + 1))
				iSubSeq++;
			else if(arr[i] == arr[i-1])
				; //do nothing
			else
				iSubSeq = 1;
			
			if(iSubSeq > iLongestSubSeq)
				iLongestSubSeq = iSubSeq;
		}
		return iLongestSubSeq;
	}
}



/*
 * https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1/
 * 
 * Given an array arr[] of positive integers. Find the length of the longest
 * sub-sequence such that elements in the subsequence are consecutive integers,
 * the consecutive numbers can be in any order.
 * 
 * Input: The first line of input contains T, number of test cases. First line
 * of line each test case contains a single integer N. Next line contains N
 * integer array.
 * 
 * Output: Print the output of each test case in a seprate line.
 * 
 * Your Task: This is a function problem. You only need to complete the function
 * findLongestConseqSubseq that takes arr and n as parameters and retuns the
 * length.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 105 0 <= a[i] <= 105
 * 
 * Example: Input: 2 7 2 6 1 9 4 5 3 7 1 9 3 10 4 20 2 Output: 6 4
 *
 *
 * Explanation: Testcase 1: The consecutive numbers here are 1, 2, 3, 4, 5, 6.
 * These 6 numbers form the longest consecutive subsquence. Testcase2: 1, 2, 3,
 * 4 is the longest consecutive subsequence.
 */

//Input
//3
//7
//2 6 1 9 4 5 3
//7
//1 9 3 10 4 20 2
//20
//6 6 2 3 1 4 1 5 6 2 8 7 4 2 1 3 4 5 9 6
//Output
//6
//4
//9
