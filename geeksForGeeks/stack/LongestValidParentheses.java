package stack;

import java.util.Scanner;

public class LongestValidParentheses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			String paranthesesString = new String();
			paranthesesString = sc.next();
			int iSize = paranthesesString.length();
			int longestValidParentheses =getLongestValidParentheses(paranthesesString, iSize);
			System.out.println(longestValidParentheses);
		}
		sc.close();

	}

	private static int getLongestValidParentheses(String paranthesesString, int iSize) {
		int[] aValidParentheses = new int[iSize];
		int iIndex = -1;
		int iLongestParenthesesLength = 0;
		for(int i = 0; i < iSize; i++) {
			if(paranthesesString.charAt(i) == '('){
				aValidParentheses[i] = 1;
				iIndex = i;
			} else if(paranthesesString.charAt(i) == ')' && iIndex >= 0){
				if(paranthesesString.charAt(i) == ')') {
					aValidParentheses[i] = getValidLength(aValidParentheses, i, iIndex);//aValidParenthese[i-1] + 2;
					int iStart = i - aValidParentheses[i] + 1;
					aValidParentheses[iStart] = aValidParentheses[i];
					iIndex = getIndexToCompare(aValidParentheses, i);
					if(iLongestParenthesesLength < aValidParentheses[i])
						iLongestParenthesesLength = aValidParentheses[i];
				}
				
			} else {
				
			}	
		}
		//iLongestParenthesesLength = getLongestParenthesesLength(aValidParentheses, iSize);
		return iLongestParenthesesLength;
	}

	private static int getLongestParenthesesLength(int[] aValidParentheses, int iSize) {
		int iLength = 0;
		int iLongestLength = 0;
		for(int i = 0; i < iSize; ) {
			if(aValidParentheses[i] == 0) {
				iLength = 0;
			}
			if(iLongestLength < iLength) {
				iLongestLength = iLength;
			}
		}
		return 0;
	}

	private static int getIndexToCompare(int[] aValidParentheses, int iEnd) {
		int iIndex = -1;
		int iStart = 0;
		for(iStart = iEnd; iStart >= 0;) {
			if(aValidParentheses[iStart] > 1) {
				iStart = iStart - aValidParentheses[iStart];
				iIndex = iStart;
			} else if(aValidParentheses[iStart] == 0) {
				iIndex = -1;
				break;
			} else 
				break;
		}
		return iIndex;
	}

	private static int getValidLength(int[] aValidParentheses, int iEnd, int iIndex) {
		int iLength = 0;
		int iStart = iIndex - 1;
		if(aValidParentheses[iIndex] == 1) {
			iLength += iEnd - iIndex + 1;
		}
		for(; iStart >= 0 && aValidParentheses[iStart] > 1; ) {
			iLength += aValidParentheses[iStart];
			iStart -= aValidParentheses[iStart];
		}
		return iLength;
	}

}

/*
 * https://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0/
 * 
 * Given a string S consisting of opening and closing parenthesis '(' and ')'.
 * Find length of the longest valid parenthesis substring.
 * 
 * Input: First line contains number of test cases T. Each test case have one
 * line string S of character '(' and ')' of length N.
 * 
 * Constraints: 1 <= T <= 500 1 <= N <= 105
 * 
 * Example: Input: 2 ((() )()())
 * 
 * Output: 2 4
 * 
 */


//3
//((()
//)()())
//((())()()))()()(())


