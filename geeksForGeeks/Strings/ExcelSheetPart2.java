package Strings;

import java.util.Scanner;

public class ExcelSheetPart2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		String excelSheet;
		int iNum = 0;
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			excelSheet = sc.next();
			iNum = getExcelSheetNametoNum(excelSheet);
			System.out.println(iNum);
		}

		sc.close();

	}

	private static int getExcelSheetNametoNum(String excelSheet) {
		int iNum = 0;
		for(int i = 0; i <excelSheet.length(); i++) {
			char c = excelSheet.charAt(i);
			iNum = iNum*26 + (c-'A') + 1;
		}
		return iNum;
	}

}


/*
 * https://practice.geeksforgeeks.org/problems/excel-sheet-part-2/0/
 * 
 * Given a string S that represents column title of an Excel sheet, find the
 * number that represents that column. In excel A column is number 1, AA is 27
 * and so on.
 * 
 * Input: The first line contains an integer T, depicting total number of test
 * cases. T testcases follow. Each testcase contains a single line of input
 * containing string S.
 * 
 * Output: For each testcase, in a new line, print the column number.
 * 
 * Constraints: 1 ≤ T ≤ 100 1 ≤ |S| <=7
 * 
 * Example: Input 2 A AA Output 1 27
 * 
 */


//For Input:
//2
//UMU
//RWXP
//Your Output is:
//14555
//332556