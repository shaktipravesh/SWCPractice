package dynamicProgramming.matrix;

import java.util.Scanner;

public class NumberOfUniquePaths {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		int iSize = 20;
		int[][] aMatrix = new int[21][21];
		aMatrix[0][1] = 1;
		aMatrix = createUniquePathMat(aMatrix, iSize);
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iRow = sc.nextInt();
			int iCol = sc.nextInt();
			System.out.println(aMatrix[iRow][iCol]);
		}
		sc.close();
	}

	private static int[][] createUniquePathMat(int[][] aMatrix, int iSize) {

		for(int iRow = 1; iRow <= iSize; iRow++) {
			for(int iCol = 1; iCol <= iSize; iCol++) {
				aMatrix[iRow][iCol] = aMatrix[iRow - 1][iCol] + aMatrix[iRow][iCol - 1];
			}
		}
		return aMatrix;
	}

}

/*
 * https://practice.geeksforgeeks.org/problems/number-of-unique-paths/0/
 * 
 * Given a M X N matrix with your initial position at top-left cell, find the
 * number of possible unique paths to reach the bottom right cell of the matrix
 * from the initial position.
 * 
 * Note: Possible moves can be either down or right at any point in time, i.e.,
 * we can move to matrix[i+1][j] or matrix[i][j+1] from matrix[i][j].
 * 
 * Input: The first line contains an integer T, depicting total number of test
 * cases. Then following T lines contains an two integers A and B depicting the
 * size of the grid.
 * 
 * Output: Print the number of unique paths to reach bottom-right cell from the
 * top-left cell.
 * 
 * Constraints: 1 ≤ T ≤ 30 1 ≤ M ≤ 15 1 ≤ N ≤ 15
 * 
 * Example: Input: 2 2 2 3 4
 * 
 * Output: 2 10
 * 
 * Example: Testcase 1: There are only two unique paths to reach end of the
 * matrix of size two from starting cell of the matrix.
 * 
 */

//5
//2 2
//3 4
//4 5
//5 5 
//6 6