package BitMagic;

import java.util.Scanner;

public class NitikaAndHerQueries {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize = sc.nextInt();
			int iQuery = sc.nextInt();
			long iSum = 0;
			int[] iNumArray = new int[iSize+1];
			int[][] iBitRecord = new int[iSize+1][33];
			for(int i =1; i <= iSize; i++) {
				iNumArray[i] = sc.nextInt();
			}
			iBitRecord = getSumOfXOROfAllPairsEfficient(iNumArray, iSize, iBitRecord);
			for(int i = 1; i <= iQuery; i++) {
				int iStartSkip = sc.nextInt();
				int iEndSkip = sc.nextInt();
				int iXORValue = 0;
				iXORValue = getSkippedXORValue(iBitRecord, iSize, iStartSkip, iEndSkip);
	
				System.out.println(iXORValue);
			}
		}

		sc.close();
	}
	
	private static int getSkippedXORValue(int[][] iBitRecord, int iSize, int iStartSkip, int iEndSkip) {
		int ones[] = new int[33];
		int iXORValue = 0;
		for(int i = 0; i < 32; i++) {
			ones[i] = iBitRecord[iSize][i] - iBitRecord[iEndSkip][i] + iBitRecord[iStartSkip-1][i];
		}
		for(int i = 31; i >=0; i--) {
			iXORValue = iXORValue << 1;
			if(ones[i]%2==1)
				iXORValue = iXORValue | 1;
		}
		return iXORValue;
	}

	private static int[][] getSumOfXOROfAllPairsEfficient(int[] iNumArray, int iSize, int[][] iBitRecord) {
		for(int i = 1; i <iNumArray.length; i++) {
			int x = iNumArray[i];
			int p = 0;
			while(x != 0) {
				if((x & 1)==1) 
					iBitRecord[i][p] = iBitRecord[i-1][p] + 1;
				else
					iBitRecord[i][p] = iBitRecord[i-1][p];
				x = x >>>1;
				p++;
			}
			for(; p < 32; p++) {
				iBitRecord[i][p] = iBitRecord[i-1][p];
			}
		}
		return iBitRecord;
	}
}





/*
 * https://practice.geeksforgeeks.org/problems/nitika-and-her-queries/0/
 * 
 * Nitika recently read about XOR operation and she got obssessed with it. She
 * has an array containing N Positive integers. She wants to perform Q queries
 * on the array. In a query She gives two integers L and R.(1 based indexing).
 * Now, she asks what is the xor of all the elements of the array after not
 * including the subarray ranging from L to R (both inclusive). Nitika
 * guarantees that in each query, The resulting array is non empty.
 * 
 * Input: The First line contains an integer T, the number oftestcases. The
 * first line of eachtestcase contains Two integers N ,Q -the Size of the array
 * and the number of queries respectively. The next Line contains N integers
 * denoting the array. Each of the next Q lines contains two integers L and R.
 * 
 * Output: For each query Print the required answer.
 * 
 * Constraints: 1<=T<=10 1<= N,Q <=1e5 0<=Ai<=1e9 1<=L,R<=N
 * 
 * Example: Input: 
 * 1 
 * 10 3 
 * 4 7 8 5 9 6 1 0 20 10 
 * 3 8 
 * 1 6 
 * 2 3 
 * Output: 
 * 29 
 * 31 
 * 17
 * 
 * Explanation:
 * 
 * For the first query: The resulting array is: (4 ,7 ,20, 10) Their Xor will
 * be: 29 For the Second query: The resulting array is: (1, 0, 20, 10) Their Xor
 * will be: 31 For the Third query: The resulting array is: (4, 5, 9, 6, 1,0
 * ,20, 10) Their Xor will be: 17
 * 
 * 
 * 
 */