package matrix;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BooleanMatrixProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for (int iTemp = 1; iTemp <= iTestCt; iTemp++) {
			int iRow = sc.nextInt();
			int iCol = sc.nextInt();
			int[][] aMatrix = new int[iRow + 1][iCol + 1];
			for (int i = 1; i <= iRow; i++) {
				for (int j = 1; j <= iCol; j++) {
					aMatrix[i][j] = sc.nextInt();
					if (aMatrix[i][j] == 1) {
						aMatrix[i][0] = 1;
						aMatrix[0][j] = 1;
					}
				}
			}
			
			Instant start = Instant.now();
			long startTime = System.nanoTime();

			
			aMatrix = getModifiedBoolMatrix(aMatrix, iRow, iCol);
			
			long stopTime = System.nanoTime();
			System.out.println(stopTime - startTime);

			Instant end = Instant.now();
			System.out.println(Duration.between(start, end));
			System.out.println();
		}
		sc.close();

	}

	private static int[][] getModifiedBoolMatrix(int[][] aMatrix, int iRow, int iCol) {
		for (int i = 1; i <= iRow; i++) {
			StringBuilder strRow = new StringBuilder();
			for (int j = 1; j <= iCol; j++) {
				if (aMatrix[i][0] == 1 || aMatrix[0][j] == 1) {
					strRow.append("1 ");
				} else {
					strRow.append("0 ");
				}
			}
			System.out.println(strRow);
		}
		return aMatrix;
	}
}



/*

#include <iostream>
using namespace std;


int main() {
		int iTestCt = 0;
		cin >> iTestCt;
		for (int iTemp = 1; iTemp <= iTestCt; iTemp++) {
			int iRow = 0;
			int iCol = 0;
			cin >> iRow >> iCol;
			
			int aMatrix[1001][1001] = {0};
			for (int i = 1; i <= iRow; i++) {
				for (int j = 1; j <= iCol; j++) {
					cin >> aMatrix[i][j];
					if (aMatrix[i][j] == 1) {
						aMatrix[i][0] = 1;
						aMatrix[0][j] = 1;
					}
				}
			}
        	for (int i = 1; i <= iRow; i++) {
        		string strRow = "";
        		for (int j = 1; j <= iCol; j++) {
        			if (aMatrix[i][0] == 1 || aMatrix[0][j] == 1) {
        				strRow.append("1 ");
        			} else {
        				strRow.append("0 ");
        			}
        		}
        		cout << strRow <<endl;
        	}
		}
	}

*/

/*
 *
 *https://practice.geeksforgeeks.org/problems/boolean-matrix-problem/0/
 *
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a
 * matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and
 * jth column as 1.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. The first line of each test case is r and c, r is the number of
 * rows and c is the number of columns. The second line of each test case
 * contains all the elements of the matrix in a single line separated by a
 * single space.
 * 
 * Output: Print the modified array.
 * 
 * Constraints: 1 ≤ T ≤ 100 1 ≤ r, c ≤ 1000 0 ≤ A[i][j] ≤ 1
 * 
 * Example: Input: 3 2 2 1 0 0 0 2 3 0 0 0 0 0 1 4 3 1 0 0 1 0 0 1 0 0 0 0 0
 * 
 * Output: 1 1 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 0 0
 * 
 * Explanation: Testcase1: Since only first element of matrix has 1 (at index
 * 1,1) as value, so first row and first column are modified to 1.
 * 
 */