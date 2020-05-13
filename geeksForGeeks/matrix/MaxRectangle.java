package Matrix;

import java.util.Scanner;

public class MaxRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iM = sc.nextInt();
			int iN = sc.nextInt();
			int[][] aNum = new int[iM][iN];
			for(int i = 0; i < iM; i++) {
				for(int j = 0; j < iN; j++) {
					aNum[i][j] = sc.nextInt();
				}
			}
			GfG g = new GfG();
			System.out.println(g.maxArea(aNum, iM, iN));
		}
		sc.close();
	}

}


class GfG {
    public int maxArea(int a[][], int m, int n) {
    	int aMaxArea = 0;
    	int[] aNum = new int[n];
    	for(int j = 0; j < n; j++) {
    		aNum[j] = a[0][j];
    	}
    	aMaxArea = getMaxHistogramArea(aNum, n);
    	for(int i = 1; i < m; i++) {
    		int aRowArea = 0;
    		for(int j = 0; j < n; j++) {
    			if(a[i][j] == 1) {
    				aNum[j] += a[i][j];
    			} else {
    				aNum[j] = 0;
    			}
    			System.out.print(aNum[j]);
    		}
    		System.out.println();
    		aRowArea = getMaxHistogramArea(aNum, n);
    		if(aMaxArea < aRowArea)
    			aMaxArea = aRowArea;
    	}
    	
       return aMaxArea;
    }

	private static int getMaxHistogramArea(int[] aNum, int iSize) {
		
		int[] aStackIndex = new int[iSize];
		int[] aStackValue = new int[iSize];
		//String sMaxHistogramArea = null;
		int lMaxHistogramArea = 0, lArea = 0;
		aStackValue[0] = aNum[0];
		int i = 0, j = 0;
		for(i = 1, j = 0; i < iSize; i++) {
			if(aNum[i] > aStackValue[j]) {
				aStackIndex[++j] = i;
				aStackValue[j] = aNum[i];
			} else if(aNum[i] < aStackValue[j]) {
				while(j >=0 && (aNum[i] < aStackValue[j])) {
					lArea = getMultiplicationofLongNum(aStackValue[j], i-aStackIndex[j]);
					if(lArea > lMaxHistogramArea)
						lMaxHistogramArea = lArea;
					aStackValue[j] = aNum[i];
					j--;
				}
				j++;
			}
		}
		for(; j>=0; j--) {
			lArea = getMultiplicationofLongNum(aStackValue[j], i-aStackIndex[j]);
			if(lArea > lMaxHistogramArea)
				lMaxHistogramArea = lArea;
		}
		//sMaxHistogramArea = "" + lMaxHistogramArea;
		return lMaxHistogramArea;
	}

	private static int getMultiplicationofLongNum(int l, int i) {
		int iMultiplication = l*i;
		return iMultiplication;
	}

}


/*
 * https://practice.geeksforgeeks.org/problems/max-rectangle/1/ 
 * Given a binary matrix, Your task is to complete the function maxArea which the maximum size
 * rectangle area in a binary-sub-matrix with all 1’s. The function takes 3
 * arguments the first argument is the Matrix M[ ] [ ] and the next two are two
 * integers n and m which denotes the size of the matrix M. Your function should
 * return an integer denoting the area of the maximum rectangle .
 * 
 * Input: The first line of input is an integer T denoting the no of test cases
 * . Then T test cases follow. The first line of each test case are 2 integers n
 * and m denoting the size of the matrix M . Then in the next line are n*m space
 * separated values of the matrix M.
 * 
 * Output: For each test case output will be the area of the maximum rectangle .
 * 
 * Constraints: 1<=T<=100 1<=n,m<=1000 0<=M[][]<=1
 * 
 * Example: Input 1 4 4 0 1 1 0 1 1 1 1 1 1 1 1 1 1 0 0
 * 
 * Output 8
 * 
 * Explanation For the above test case the matrix will look like 0 1 1 0 1 1 1 1
 * 1 1 1 1 1 1 0 0 the max size rectangle is 1 1 1 1 1 1 1 1 and area is 4 *2 =
 * 8
 */



//4
//4 4 
//0 1 1 0 
//1 1 1 1 
//1 1 1 1 
//1 1 0 0
//15 3
//0 0 1 
//1 0 1 
//0 1 1 
//0 0 0 
//0 0 0 
//1 1 0 
//1 1 0 
//1 1 0 
//1 0 0 
//1 0 0 
//1 1 0 
//1 1 1 
//1 0 1 
//0 1 1 
//1 0 1
//14 18
//0 1 1 1 0 1 1 0 0 1 0 1 1 1 1 0 0 1 
//0 0 1 0 0 1 0 1 1 0 1 0 1 0 0 0 0 1 
//1 1 1 1 0 1 1 1 1 0 0 1 1 1 1 0 1 1 
//0 1 1 0 0 1 1 0 1 1 0 0 1 0 1 1 0 1 
//0 0 0 0 1 0 0 1 0 0 1 0 1 0 1 0 1 1 
//0 0 0 0 0 1 0 0 1 1 0 1 0 0 1 1 1 1 
//0 0 1 1 1 0 0 1 0 1 0 1 0 1 0 1 1 1 
//1 0 1 0 0 0 1 0 0 1 0 0 1 1 1 1 1 0 
//1 1 1 1 1 0 1 1 1 0 0 1 1 1 0 1 0 0 
//0 1 1 0 0 0 1 1 0 1 0 1 0 0 1 1 1 1 
//1 1 0 1 1 0 0 1 0 0 1 1 1 0 1 0 0 0 
//1 0 1 0 1 0 0 0 1 0 0 0 0 0 0 1 0 0 
//0 1 1 0 1 0 0 1 1 0 1 0 1 0 1 0 1 1 
//0 0 1 0 1 0 1 0 0 0 0 0 1 0 0 0 1 1
//
//8
//8
//7



