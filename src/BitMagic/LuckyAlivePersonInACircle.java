package BitMagic;

import java.util.Scanner;

public class LuckyAlivePersonInACircle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iNum = sc.nextInt();
			int iLuckyPersonToAlive = 0;
			iLuckyPersonToAlive = getLuckyPersontoAlive(iNum);
			System.out.println(iLuckyPersonToAlive);
		}

	}

	//O(1) Complexity
	private static int getLuckyPersontoAlive(int iNum) {
		int iMaxButNum = getMaxBitTrueNumber(iNum);
		int iLuckyPersonAlive = 0;
		iNum = iNum^iMaxButNum;
		iLuckyPersonAlive = 2*iNum + 1;
		
		return iLuckyPersonAlive;
	}
	

	//O(1) complexity
	private static int getMaxBitTrueNumber(int iNum) {
		iNum |= iNum>>1;
		iNum |= iNum>>2;
		iNum |= iNum>>4;
		iNum |= iNum>>8;
		iNum |= iNum>>16;
		iNum += 1;
		iNum = iNum >>1;
		return iNum;
	}

}


/*
 * https://practice.geeksforgeeks.org/problems/lucky-alive-person-in-a-circle/0
 * Lucky alive person in a circle 
 * Given n people standing in a circle where 1st
 * is having sword, find the luckiest person in the circle, if from 1st soldier
 * who is having a sword each have to kill the next soldier and handover the
 * sword to next soldier, in turn, the soldier will kill the adjacent soldier
 * and handover the sword to next soldier such that one soldier remains in this
 * war who is not killed by anyone.
 * 
 * Input: The first line contains an integer T, number of test cases. For each
 * test case, there is an integer n.
 * 
 * Output: For each test case, the output is the integer displaying the last
 * person who is alive.
 * 
 * Constraints: 1<=T<=100 1<=n<=10^8
 * 
 * Example: 
 * Input 
 * 2 
 * 5 
 * 10 
 * Output 
 * 3 
 * 5
 * 
 * Explanation: 1.In first go 1 3 5 (remains) as 2 and 4 killed by 1 and 3. In
 * second go 3 will remain as 5 killed 1 and 3rd killed 5 hence, 3 remains
 * alive. 2. In first 1 3 5 7 9 remains as 2 4 6 8 10 were killed by 1 3 5 7 and
 * 9. In second 1 5 9 are left as 1 kills 3 and 5 kill the 7th soldier.In third
 * 5th soldiers remain alive as 9 kills the 1st soldier and 5 kill the 9th
 * soldier.
 * 
 * 
 * 
 */