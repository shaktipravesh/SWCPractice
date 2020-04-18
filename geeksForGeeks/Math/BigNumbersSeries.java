package Math;

import java.util.Scanner;

public class BigNumbersSeries {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] aBigNumber = new int[101][200];
		int[][] aFactorial = new int[101][200];
		aFactorial = createFactorialOf100(aFactorial);
		aBigNumber = createBigNumberof100(aBigNumber, aFactorial);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iNum = sc.nextInt();
			for(int i = aBigNumber[iNum][0]; i > 0; i--) {
				System.out.print(aBigNumber[iNum][i]);
			}
			System.out.println();
		}
		sc.close();
	}

	private static int[][] createBigNumberof100(int[][] aBigNumber, int[][] aFactorial) {
		aBigNumber[0][1] = 0;
		aBigNumber[0][0] = 1;
		for(int i = 1; i <=100; i++) {
			aBigNumber[i] = multiplyLargeNumber(aBigNumber[i], aFactorial[i], i);
		}
		return aBigNumber;
	}

	private static int[][] createFactorialOf100(int[][] aFactorial) {
		aFactorial[0][0] = 1;
		aFactorial[0][1] = 1;
		aFactorial[1][0] = 1;
		aFactorial[1][1] = 1;
		for(int i = 2; i <=100; i++) {
			aFactorial[i] = multiplyLargeNumber(aFactorial[i], aFactorial[i-1], i);
		}
		return aFactorial;
	}

	private static int[] multiplyLargeNumber(int[] aRes, int[] aNum, int iNum) {
		int iMul = 0;
		for(int i = 1; i <= aNum[0]; i++) {
			iMul = aNum[i]*iNum;
			for(int j = i; iMul > 0; j++) {
				iMul = aRes[j] + iMul;
				aRes[j] = iMul%10;
				iMul = iMul/10;
				if(aRes[0] < j)
					aRes[0] = j;
			}
		}
		return aRes;
	}

}


/*
 * 
 * BigNumber N = (Factorial of N) * N Given a series of numbers 0 1 4 18 96 600
 * 4320 …., and series starting from n=0 , find the pattern and output the nth
 * value of above series. Input The first line of the input contains a single
 * integer T denoting the number of test cases. The first line of each test case
 * contains n. Output
 * 
 * For each test case, output the nth value of above series. Constraints 1 ≤ T ≤
 * 101 0 ≤ n≤ 100
 * 
 * Example Input: 5 0 1 2 3 4
 * 
 * 
 * Output: 0 1 4 18 96
 * 
 */