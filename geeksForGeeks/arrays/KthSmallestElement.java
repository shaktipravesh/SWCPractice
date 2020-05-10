package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallestElement {

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
			int iKth = sc.nextInt();
			iKth = getKthSmallestElement(aNum, iSize, iKth);
			System.out.println(iKth);
		}
		sc.close();

	}

	private static int getKthSmallestElement(int[] aNum, int iSize, int iKth) {
		Arrays.parallelSort(aNum);
		iKth = aNum[iKth - 1];
		return iKth;
	}

}


/*
 * https://practice.geeksforgeeks.org/problems/kth-smallest-element/0/
 * 
 * Given an array arr[] and a number K where K is smaller than size of array,
 * the task is to find the Kth smallest element in the given array. It is given
 * that all array elements are distinct. Expected Time Complexity: O(n)
 * 
 * Input: The first line of input contains an integer T, denoting the number of
 * testcases. Then T test cases follow. Each test case consists of three lines.
 * First line of each testcase contains an integer N denoting size of the array.
 * Second line contains N space separated integer denoting elements of the
 * array. Third line of the test case contains an integer K.
 * 
 * Output: Corresponding to each test case, print the kth smallest element in a
 * new line.
 * 
 * Constraints: 1 <= T <= 100 1 <= N <= 105 1 <= arr[i] <= 105 1 <= K <= N
 * 
 * Example: Input: 2 6 7 10 4 3 20 15 3 5 7 10 4 20 15 4 Output: 7 15
 * 
 * Explanation: Testcase 1: 3rd smallest element in the given array is 7.
 * Testcase 2: 4th smallest elemets in the given array is 15.
 * 
 * 
 */