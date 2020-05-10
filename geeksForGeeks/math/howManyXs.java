package math;

import java.util.Scanner;

public class howManyXs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iX = sc.nextInt();
			int iLower = sc.nextInt();
			int iUpper = sc.nextInt();
			int iOccurance = 0;
			iOccurance= getOccurences(iLower, iUpper, iX);
			iOccurance = getRangeOccurencesEfficient(iLower, iUpper, iX);
			System.out.println(iOccurance);
		}
		
		sc.close();

	}

	private static int getRangeOccurencesEfficient(int iLower, int iUpper, int iX) {
		int iLowerOccurence =0;
		int iUpperOccurence =0;
		iLowerOccurence = getRangeOccurencesEfficient(iLower, iX);
		iUpperOccurence = getRangeOccurencesEfficient(iUpper-1, iX);
		return (iUpperOccurence - iLowerOccurence);
	}

	private static int getRangeOccurencesEfficient(int iNum, int iX) {
		int iOccurance = 0;
		int iDividePlace = 10;
		int iPlace = 1;
		int iNumTemp = iNum;
		int iRemainder = 0;
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

	private static int getOccurences(int iLower, int iUpper, int iX) {
		int iOccurance = 0;
		for(int i = iLower+1; i < iUpper; i++) {
			for(int j = i; j > 0; ) {
				int iRemainder = j%10;
				
				if((iRemainder ==0 && iX == 0) || (iRemainder > 0 && iX > 0 && iRemainder%iX == 0 && iRemainder/iX == 1))
					iOccurance++;
				j = j/10;
			}
		}
		return iOccurance;
	}

}


/*
 * https://practice.geeksforgeeks.org/problems/how-many-xs/0 
 * How Many X's? 
 * Given
 * an integer X within the range of 0 to 9, and given two positive integers as
 * upper and lower bounds respectively, find the number of times X occurs as a
 * digit in an integer within the range, excluding the bounds. Print the
 * frequency of occurrence as output.
 * 
 * Input: The first line of input is an integer T, denoting the number of test
 * cases. For each test case, there are two lines of input, first consisting of
 * the integer X, whose occurrence has to be counted. Second, the lower and
 * upper bound, L and U which are positive integers, on the same line separated
 * by a single space, respectively.
 * 
 * Output: For each test case, there is only one line of output, the count of
 * the occurrence of X as a digit in the numbers lying between the lower and
 * upper bound, excluding them.
 * 
 * Constraints: 1<=T<=100 0<=X<=9 0<L<U<=10^5
 * 
 * Example: 
 * Input 
 * 5 
 * 3 
 * 100 250 
 * 2 
 * 10000 12345 
 * 0 
 * 20 21 
 * 9 
 * 899 1000 
 * 1 
 * 1100 1345
 * Output: 
 * 35 
 * 1120 
 * 0 
 * 120 
 * 398
 * 
 * Explanation:
 * 
 * In the first test case, the occurrence of 3 in the numbers starting from 101
 * to 249 is counted and comes out to be 35.
 * 
 * Similarly, for all the other test cases, the occurrence of the given number X
 * is printed as output.
 * 
 */
