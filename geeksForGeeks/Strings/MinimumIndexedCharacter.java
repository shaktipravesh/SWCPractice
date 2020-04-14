package Strings;

import java.util.Scanner;

public class MinimumIndexedCharacter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		sc.nextLine();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			String str = sc.nextLine();
			String patt = sc.nextLine();
			char minIndexChar = getMinimumIndexedCharacter(str, patt);
			System.out.println(minIndexChar);
			
		}

	}

	private static char getMinimumIndexedCharacter(String str, String patt) {
		char minIndexChar = '$';
		int[] pattArray = new int[256];
		for(int i = 0; i< patt.length(); i++) {
			pattArray[patt.charAt(i)] = 1;
		}
		for(int i = 0; i< str.length(); i++) {
			if(pattArray[str.charAt(i)] == 1) {
				minIndexChar = str.charAt(i);
				break;
			}
		}
		
		return minIndexChar;
	}

}
