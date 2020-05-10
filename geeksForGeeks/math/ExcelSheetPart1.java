package Math;

import java.util.Scanner;

public class ExcelSheetPart1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		String excelSheet;
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iM = sc.nextInt();
			excelSheet = getExcelSheetName(iM);
			System.out.println(excelSheet);
		}

		sc.close();
		
	}

	private static String getExcelSheetName(int iM) {
		String excelSheet = new String();
		char cMod;
		int iMod = 0;
		while(iM > 0) {
			iMod = (iM%26 == 0) ? 26 : iM%26;
			iMod = iMod + 'A' - 1;
			cMod = (char) iMod;
			excelSheet = cMod + excelSheet;
			iM = (iM%26 == 0) ? iM/26-1 : iM/26;
		}
		return excelSheet;
	}

}



/*
 * https://practice.geeksforgeeks.org/problems/excel-sheet/0/
 * 
 * Given a positive integer N, print its corresponding column title as it would
 * appear in an Excel sheet. For N =1 we have column A, for 27 we have AA and so
 * on.
 * 
 * Note: The alphabets are all in uppercase.
 * 
 * Input: The first line contains an integer T, depicting total number of test
 * cases. Then following T lines contains an integer N.
 * 
 * Output: For each testcase, in a new line, print the string corrosponding to
 * the column number.
 * 
 * Constraints: 1 ≤ T ≤ 100 1 ≤ N ≤ 107
 * 
 * Example: Input: 1 51 Output: AY
 */