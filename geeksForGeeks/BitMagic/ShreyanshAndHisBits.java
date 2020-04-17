package BitMagic;

import java.util.Scanner;

public class ShreyanshAndHisBits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			long iNum = sc.nextLong();
			//System.out.println(Long.toBinaryString(iNum));
			long iSmallerNumCount = 0;
			iSmallerNumCount = getSmallerThanNumCount(iNum, iSmallerNumCount);
			System.out.println(iSmallerNumCount);
		}
		sc.close();
	}

	private static long getSmallerThanNumCount(long iNum, long iSmallerNumCount) {

		int iTrueBitCt = 0;
		int iCount = 0;
		while(iNum > 0) {
			iCount++;
			if((iNum & 1) == 1) {
				iTrueBitCt++;
				iSmallerNumCount += get_nCr(iCount-1, iTrueBitCt);
			}
			iNum = iNum>>1;
		}
		
		return iSmallerNumCount;
	}
	
	
	private static long get_nCr(int n, int r) {
		System.out.println("n: " + n + " r: " + r);
		long nCrValue = 0;
		if(n < r)
			return nCrValue;
		long lNumerator = 1;
		long lDenomrator = 1;
		if((n-r) < r) {
			r = n-r;
		} 
		for(int i = 1, j = n; i <=r; i++, j--) {
			lNumerator *= j;
			lDenomrator *= i;
			if(lNumerator%lDenomrator == 0) {
				lNumerator /= lDenomrator;
				lDenomrator = 1;
			}
		}
		nCrValue = lNumerator/lDenomrator;
		
		return nCrValue;
	}
	
	private static long getSmallerThanNumCount(long iNum) {
		int iTotalBitCt = getTotalBitCt(iNum);
		int iTrueBitCt = getTrueBitCount(iNum);
		int i2ndLastTrueBitPos = get2ndLastBitCt(iNum, iTotalBitCt);
		long iTotalNum = 0;

		//System.out.println(iTotalBitCt + " " + i2ndLastTrueBitPos + " " + iTrueBitCt);
		//n = iTotalBitCt, r =iTrueBitCt
		//n-1Cr-1 + nCr-1 = nCr
		//get_nCmstscmstscmstscr(iTotalBitCt, iTrueBitCt)
		
		iTotalNum = get_nCr(iTotalBitCt-1, iTrueBitCt) + get_nCr(i2ndLastTrueBitPos-1, iTrueBitCt-1);
		//System.out.println(iTotalNum);
		
		return iTotalNum;
	}


	
	private static int getAllBitSmallNumCt(long iNum, int iTotalBitCt) {
		int iTrueBitPos = 0;
		int iLastTrueBitPos = 0;
		int iCount = 0;
		if(iTotalBitCt > 1)
		while(iNum > 0) {
			iCount++;
			if((iNum & 1) == 1) {
				iTrueBitPos = iLastTrueBitPos;
				iLastTrueBitPos = iCount;
			}
			iNum = iNum>>1;
		}
		return iTrueBitPos;
	}
	


	private static int get2ndLastBitCt(long iNum, int iTotalBitCt) {
		int i2ndLastTrueBitPos = 0;
		int iLastTrueBitPos = 0;
		int iCount = 0;
		if(iTotalBitCt > 1)
		while(iNum > 0) {
			iCount++;
			if((iNum & 1) == 1) {
				i2ndLastTrueBitPos = iLastTrueBitPos;
				iLastTrueBitPos = iCount;
			}
			iNum = iNum>>1;
		}
		return i2ndLastTrueBitPos;
	}

	private static int getTrueBitCount(long iNum) {
		int iTrueBitCt = 0;
		while(iNum > 0) {
			iNum = iNum & (iNum-1);
			iTrueBitCt++;
		}
		return iTrueBitCt;
	}

	private static int getTotalBitCt(long iNum) {
		int iTotalBitCt = 0;
		while(iNum > 0) {
			iTotalBitCt++;
			iNum = iNum >> 1;
		}
		return iTotalBitCt;
	}

}


/*
 * Shreyansh has an integer N. He is really curious about the binary
 * representation of integers. He sees that any given integer has a number of
 * set bits. Now he wants to find out that how many positive integers, strictly
 * less than N, have the same number of set bits as N. He is a little weak in
 * maths. Help him find the number of integers. Note : Since N takes large
 * values, brute force won't work.
 * 
 * Input : First line of input contains a single integer T denoting the number
 * of test cases. The only line of each test case contains an integer N.
 * 
 * Output : For each test case, print the required answer in a new line.
 * 
 * Constraints : 1 <= T <= 1000 1 <= N <= 10^12
 * 
 * Example : Input : 3 8 1 4
 * 
 * Output : 3 0 2
 * 
 * Explanation : Case 1 : Binary representation of 8 : 1000 So the integers less
 * than 8 with same number of set bits are : 4, 2, 1
 * 
 * Case 2 : Binary representation of 1 : 1 There are no positive integers less
 * than 1.
 * 
 * Case 3 : Binary representation of 8 : 100 So the integers less than 4 with
 * same number of set bits are : 2, 1
 * 
 */

/*
 * 3 891315145025 703252478527 891315145025
 */
/*
 * For Input:
2
891315145025
703252478527
Your Output is:
91140287370
31247927460
 * Possibly your code doesn't work correctly for multiple test-cases (TCs).
 * 
 * The first test case where your code failed:
 * 
 * Input: 891315145025
 * 
 * Its Correct output is: 98375361881
 * 
 * And Your Code's output is: 91140287370
 */