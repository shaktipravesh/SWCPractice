package math.numberTheory;

import java.util.Scanner;

public class SumOfPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] primeNumbers = new int[100001];
		int[] primeNumbersIndex = new int[1000001];
		
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		createAllPrimeNumber(primeNumbers, primeNumbersIndex);
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iNum = sc.nextInt();
			printSumOfPrime(primeNumbers, primeNumbersIndex, iNum);
		}

		sc.close();
	}


	private static void printSumOfPrime(int[] primeNumbers, int[] primeNumbersIndex, int iNum) {
		boolean twoPrimeNotFound = true;
		for(int i = 0; primeNumbers[i] <= iNum; i++ ) {
			if(primeNumbersIndex[iNum - primeNumbers[i]] == 1) {
				System.out.println(primeNumbers[i] + " " + (iNum - primeNumbers[i]));
				twoPrimeNotFound = false;
				break;
			}
		}
		
		if(twoPrimeNotFound)
			System.out.println(-1);
	}


	private static int[] createAllPrimeNumber(int[] primeNumbers, int[] primeNumbersIndex) {
		primeNumbers[0] = 2; 
		primeNumbers[1] = 3; 
		primeNumbers[2] = 5; 
		primeNumbersIndex[2] = 1;
		primeNumbersIndex[3] = 1;
		primeNumbersIndex[4] = 0;
		primeNumbersIndex[5] = 1;
		int iCount = 2;
		for(int i = 6; i <= 1000000; i++ ) {
			int sqrtNum = (int) Math.ceil(Math.sqrt(i));
			boolean isPrime = true;
			for(int j = 0; primeNumbers[j] <= sqrtNum; j++) {
				if(i % primeNumbers[j] == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				primeNumbers[++iCount] = i;
				primeNumbersIndex[i] = 1;
			}
		}
		return null;
	}

}


/*
 * 
 * https://practice.geeksforgeeks.org/problems/sum-of-prime/0/
 * 
 * Given a number (greater than 2), print two prime numbers whose sum will be
 * equal to given number, else print -1 if no such number exists.
 * 
 * NOTE: A solution will always exist if the number is even. Read Goldbach’s
 * conjecture.
 * 
 * If [a, b] is one solution with a <= b, and [c, d] is another solution with c
 * <= d, and a < c then print [a, b] only and not all possible solutions.
 * 
 * Input: The first line contains an integer T, depicting total number of test
 * cases. Then following T lines contains an integer N.
 * 
 * Output: Print the two prime numbers in a single line with space in between.
 * 
 * Constraints: 1 ≤ T ≤ 50 2 ≤ N ≤ 1000000
 * 
 * Example: Input: 2 8 3 Output 3 5 -1
 * 
 * Explanation: Testcase 1: two prime numbers from 1 to 8 are 3 and 5 whose sum
 * is 8.
 * 
 */





