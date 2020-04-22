package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumTipCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			long iTip = 0;
			int iSize = sc.nextInt();
			int iX = sc.nextInt();
			int iY = sc.nextInt();
			long[][] aTipData = new long[iSize][2];
			
			for(int i = 0; i < iSize; i++) {
				aTipData[i][0] = sc.nextInt();
			}
			for(int i = 0; i < iSize; i++) {
				aTipData[i][1] = sc.nextInt();
			}

			iTip = getMaximumTip(aTipData, iSize, iX, iY);
			System.out.println(iTip);
		}
		sc.close();
	}

	private static long getMaximumTip(long[][] aTipData, int iSize, int iX, int iY) {
		long[] aTip = new long[iSize];
		int iMod = 100000;
		long maxTip = 0;
		for(int i = 0; i < iSize; i++) {
			aTip[i] = (aTipData[i][0]) - (aTipData[i][1]);
			if(aTip[i] < 0)
				aTip[i] = aTip[i]*iMod - i;
			else 
				aTip[i] = aTip[i]*iMod + i;
		}
		
		Arrays.parallelSort(aTip);
		long iIndex = 0;
		long iXIndex = 0,  iYIndex = 0;
		for(int i = 0, j = 1; (i < iY || j <= iX) && (i + j) <= iSize;  ) {
			if(i < iY && j <= iX) {
				if(getPositiveValue(aTip[i]) > getPositiveValue(aTip[iSize - j])) {
					iIndex = getPositiveValue(aTip[i]%iMod);
					maxTip += Math.max(aTipData[(int) iIndex][1], aTipData[(int) iIndex][0]);
					i++;
				} else if(getPositiveValue(aTip[i]) < getPositiveValue(aTip[iSize - j])){
					iIndex = getPositiveValue(aTip[iSize - j]%iMod);
					maxTip += Math.max(aTipData[(int) iIndex][1], aTipData[(int) iIndex][0]);
					j++;
				} else if((getPositiveValue(aTip[i]) == getPositiveValue(aTip[iSize - j]) && getPositiveValue(aTip[i]) <= 0)) {
					iIndex = getPositiveValue(aTip[i]%iMod);
					maxTip += Math.max(aTipData[(int) iIndex][1], aTipData[(int) iIndex][0]);
					i++;	
				} else if((getPositiveValue(aTip[i]) == getPositiveValue(aTip[iSize - j]) && getPositiveValue(aTip[i]) > 0)) {				
					iIndex = getPositiveValue(aTip[iSize - j]%iMod);
					maxTip += Math.max(aTipData[(int) iIndex][1], aTipData[(int) iIndex][0]);
					j++;	
				}
			} else if(j > iX) {
				iIndex = getPositiveValue(aTip[i]%iMod);
				maxTip += aTipData[(int) iIndex][1];
				i++;
			} else if(i >= iY) {
				iIndex = getPositiveValue(aTip[iSize - j]%iMod);
				maxTip += aTipData[(int) iIndex][0];
				j++;
			}
		}
		
		return maxTip;
	}

	private static long getPositiveValue(long aTip) {
		if(aTip < 0)
			return aTip*-1;

		return aTip;
	}

}




//  5 
//  5 3 3 
//  1 2 3 4 5 
//  5 4 3 2 1 
//  8 4 4 
//  1 4 3 2 7 5 9 6 
//  1 2 3 6 5 4 9 8 
//  4 4 1
//  10 20 30 40 
//  1 25 3 100 
//  5 3 3 
//  7415 4545 5454 7564 2289 
//  4545 4445 7428 1147 9952 
//  9 5 5 
//  9 5 1 3 4 7 8 9 6 
//  1 2 4 7 5 8 9 6 3
  

/*
 * https://practice.geeksforgeeks.org/problems/maximum-tip-calculator/0/
 * 
 * Rahul and Ankit are the only two waiters in Royal Restaurant. Today, the
 * restaurant received N orders. The amount of tips may differ when handled by
 * different waiters, if Rahul takes the ith order, he would be tipped Ai rupees
 * and if Ankit takes this order, the tip would be Bi rupees. In order to
 * maximize the total tip value they decided to distribute the order among
 * themselves. One order will be handled by one person only. Also, due to time
 * constraints Rahul cannot take more than X orders and Ankit cannot take more
 * than Y orders. It is guaranteed that X + Y is greater than or equal to N,
 * which means that all the orders can be handled by either Rahul or Ankit. Find
 * out the maximum possible amount of total tip money after processing all the
 * orders.
 * 
 * 
 * Input:
 * 
 * • The first line contains one integer, number of test cases. • The second
 * line contains three integers N, X, Y. • The third line contains N integers.
 * The ith integer represents Ai. • The fourth line contains N integers. The ith
 * integer represents Bi.
 * 
 * 
 * 
 * Output: Print a single integer representing the maximum tip money they would
 * receive.
 * 
 * 
 * Constraints: 1 ≤ N ≤ 105 1 ≤ X, Y ≤ N; X + Y ≥ N 1 ≤ Ai, Bi ≤ 104
 * 
 * 
 * 
 * Example:
 * 
 * Input:
 * 
 * 2 5 3 3 1 2 3 4 5 5 4 3 2 1 8 4 4 1 4 3 2 7 5 9 6 1 2 3 6 5 4 9 8
 * 
 * 
 * 
 * Output:
 * 
 * 21 43
 */
 
