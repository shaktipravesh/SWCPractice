package arrays;

import java.util.Scanner;

public class SaveGotham {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize = sc.nextInt();
			long iSum = 0;
			int[] iNumArray = new int[iSize+1];
			int[] aComparator = new int[iSize+1];
			iNumArray[0] = sc.nextInt();
			int i = 1, iCounter = 0;
			aComparator[0] = iNumArray[0];
			for(i = 1; i < iSize; i++) {
				iNumArray[i] = sc.nextInt();
				if(iNumArray[i] > iNumArray[i-1]) {
					for(; iCounter >= 0; iCounter--) {
						if(iNumArray[i] > aComparator[iCounter]) {
							iSum += iNumArray[i];
						} else {
							break;
						}
					}
				}
				iCounter++;
				aComparator[iCounter] = iNumArray[i];
				
			}
			System.out.println(iSum%1000000001);
		}
		sc.close();
	}

}















/*
 * https://practice.geeksforgeeks.org/problems/save-gotham/0/
 * Save Gotham!
 * Gotham has been attacked by Joker . Bruce Wayne has deployed automatic
 * machine gun at each tower of Gotham. All the towers in Gotham are in straight
 * line. You are given no of towers 'n' followed by height of 'n' towers. For
 * every tower(p), find the height of the closest tower (towards the right),
 * greater than the height of tower(p). Now , Print sum of all such heights (mod
 * 1000000001).
 * 
 * Note : If for a tower(k) , no such tower exsits then take its height as 0.
 * 
 * Input: First line of the input contains t, the number of test cases. First
 * line of each test case contains 'n' denoting no of towers. This is followed
 * by 'n' spaced integers h1,h2.....h(n) representing height of towers.
 * 
 * Output: On a single line, output the sum(mod 1000000001).
 * 
 * 
 * Constraints: 1<=t<=100 1<=n<=18000 0<=a[i]<=100000
 * 
 * 
 * Example:
 * 
 * Input: 
 * 1 
 * 9 
 * 112 133 161 311 122 512 1212 0 19212
 * 
 * 
 * Output: 41265
 * 
 * Explanation : 
 * nextgreater(112) : 133 
 * nextgreater(133) : 161 
 * nextgreater(161) : 311 
 * nextgreater(311) : 512 
 * nextgreater(122) : 512 
 * nextgreater(512) : 1212
 * nextgreater(1212) : 19212 
 * nextgreater(0) : 19212 
 * nextgreater(19212) : 0
 * 
 * add = 133+161+311+512+512+1212+19212+19212+0 = 41265.
 * 
 * Expected Time complexity - O(n).
 * 
 */











/*
 * 2 9 112 133 161 311 122 512 1212 0 19212 41 8467 6334 6500 9169 5724 1478
 * 9358 6962 4464 5705 8145 3281 6827 9961 491 2995 1942 4827 5436 2391 4604
 * 3902 153 292 2382 7421 8716 9718 9895 5447 1726 4771 1538 1869 9912 5667 6299
 * 7035 9894 8703 3811
 * 
 * 
 * Input: 41 8467 6334 6500 9169 5724 1478 9358 6962 4464 5705 8145 3281 6827
 * 9961 491 2995 1942 4827 5436 2391 4604 3902 153 292 2382 7421 8716 9718 9895
 * 5447 1726 4771 1538 1869 9912 5667 6299 7035 9894 8703 3811
 * 
 * Its Correct output is: 264509
 * 
 * And Your Code's output is: 125308
 */