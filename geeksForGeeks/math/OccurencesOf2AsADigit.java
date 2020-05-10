package math;

import java.util.Scanner;

public class OccurencesOf2AsADigit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			long iNum = sc.nextInt();
			long iOccurance = 0;
			GfG gfg = new GfG();
			iOccurance = gfg.count2s(iNum);
			System.out.println(iOccurance);
		}
		
		sc.close();

	}

}

class GfG
{
    public long count2s(long n)
    {
		long iOccurance = 0;
		long iX = 2;
		long iDividePlace = 10;
		long iPlace = 1;
		long iNumTemp = n;
		long iRemainder = 0;
		while(iNumTemp/iPlace > 0) {
			iOccurance += (iNumTemp/iDividePlace)*iPlace;
			iRemainder = (iNumTemp%iDividePlace)/iPlace;
			if(iRemainder > iX) {
				iOccurance += iPlace;
			}
			else if(iRemainder == iX) {
				iOccurance += 1 + iNumTemp%iPlace;
			}

			iDividePlace = iDividePlace*10;
			iPlace = iPlace*10;
		}
		return iOccurance;
    }
    
}


/*
 * Count the number of 2s as digit in all numbers from 0 to n.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. Then T test cases follow. Each test case contains the input
 * integer n.
 * 
 * Output: Print the count of the number of 2s as digit in all numbers from 0 to
 * n.
 * 
 * Constraints: 1<=T<=100 1<=N<=10^5
 * 
 * Example: Input: 2 22 100
 * 
 * Output: 6 20
 */


