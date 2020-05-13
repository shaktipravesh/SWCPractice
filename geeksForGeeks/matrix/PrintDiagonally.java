package matrix;

import java.util.Scanner;

public class PrintDiagonally {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize = sc.nextInt();
			int[][] aMatrix = new int[iSize][iSize];
			for(int i = 0; i < iSize; i++) {
				for(int j = 0; j < iSize; j++) {
					aMatrix[i][j] = sc.nextInt();
				}
			}
			printDiagonallyMatrix(aMatrix, iSize);
			System.out.println();
		}
		sc.close();

	}

	private static void printDiagonallyMatrix(int[][] aMatrix, int iSize) {
		for(int i = 0; i < (2*iSize-1); i++) {
			int iRow = i/iSize;
			int iCol = i%iSize;
			if(iRow > 0) {
				iRow = i%iSize + 1;
				iCol = iSize - 1;
			}
			for(;iCol >= 0 && iRow < iSize; iRow++, iCol--) {
				System.out.print(aMatrix[iRow][iCol] + " ");
			}
		}
		
	}

}


/*
 * 
 * https://practice.geeksforgeeks.org/problems/print-diagonally/0
 * 
 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the
 * example for more details.
 * 
 * For Example: If the matrix is
 * 
 * 1 2 3 4 5 6 7 8 9 The output should Return the following :
 * 
 * [ [1], [2, 4], [3, 5, 7], [6, 8], [9] ] i.e print the elements of array
 * diagonally.
 * 
 * Note: The input array given is in single line and you have to output the
 * answer in one line only.
 * 
 * 
 * 
 * Input:
 * 
 * The first line contains an integer T, depicting total number of test cases.
 * Then following T lines contains an integer N depicting the size of square
 * matrix and next line followed by the value of array.
 * 
 * 
 * Output:
 * 
 * Print the elements of matrix diagonally in separate line.
 * 
 * 
 * Constraints:
 * 
 * 1 ≤ T ≤ 30 1 ≤ N ≤ 20 0 ≤ A[i][j] ≤ 9
 * 
 * 
 * Example:
 * 
 * Input: 2 2 1 2 3 4 3 1 2 3 4 5 6 7 8 9 Output: 1 2 3 4 1 2 4 3 5 7 6 8 9
 * 
 */