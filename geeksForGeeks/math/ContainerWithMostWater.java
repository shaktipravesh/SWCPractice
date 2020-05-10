package math;

import java.util.Scanner;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize = sc.nextInt();
			int[] aNum = new int[iSize];
			for(int i = 0; i < iSize; i++) {
				aNum[i] = sc.nextInt();
			}
			int iMostWater = getContainerWithMostWater(aNum, iSize);
			System.out.println(iMostWater);
		}

		sc.close();
	}

	private static int getContainerWithMostWater(int[] aNum, int iSize) {
		int iStart = 0, iEnd = iSize-1;
		int iMostWater = 0;
		int iContainWater =0;
		for(; iStart < iEnd;) {
			if(aNum[iStart] > aNum[iEnd]) {
				iContainWater = aNum[iEnd]*(iEnd-iStart);
				iEnd--;
			} else {
				iContainWater = aNum[iStart]*(iEnd-iStart);
				iStart++;
			}
			if(iMostWater < iContainWater)
				iMostWater = iContainWater;
		}
		return iMostWater;
	}

}


/*
 * https://practice.geeksforgeeks.org/problems/container-with-most-water/0
 * 
 * Given N non-negative integers a_1, a_2, ..., a_n where each represents a
 * point at coordinate (i, a_i) . N vertical lines are drawn such that the two
 * endpoints of line i is at (i, a_i) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. Each test case contains an integer N followed by N space
 * separated integers.
 * 
 * Output: For each test case, the output is the integer denoting the maximum
 * area of water that can be contained ( maximum area instead of maximum volume
 * as working with 2D)
 * 
 * Constraints: 1 <= T <= 100 2 <= N <= 50 1 <= A[] <= 100
 * 
 * Example: Input: 2 4 1 5 4 3 5 3 1 2 4 5 Output: 6 12
 * 
 * Explanation: 1. 5 and 3 are distance 2 apart. So the size of the base = 2.
 * Height of container = min(5, 3) = 3. So total area = 3 * 2 = 6. 2. 5 and 3
 * are distance 4 apart. So the size of the base = 4. Height of container =
 * min(5, 3) = 3. So total area = 4 * 3 = 12.
 * 
 */

//4
//4
//1 5 4 3 
//5
//3 1 2 4 5
//10
//1 3 17 2 18 15 13 6 11 7
//10
//14 17 8 5 12 7 19 15 20 10




