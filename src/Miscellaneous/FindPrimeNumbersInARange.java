package Miscellaneous;

import java.util.Scanner;

public class FindPrimeNumbersInARange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] primeNumbers = new int[10000];
		int[] primeNumbersIndex = new int[100001];
		
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		createAllPrimeNumber(primeNumbers, primeNumbersIndex);
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iM = sc.nextInt();
			int iN = sc.nextInt();
			for(int i = primeNumbersIndex[iM]; primeNumbers[i] <= iN; i++) {
				if(primeNumbers[i]  >= iM)
					System.out.print(primeNumbers[i] + " ");
			}
			System.out.println();
			
		}

		sc.close();
	}

	private static int[] createAllPrimeNumber(int[] primeNumbers, int[] primeNumbersIndex) {
		primeNumbers[0] = 2; 
		primeNumbers[1] = 3; 
		primeNumbers[2] = 5; 
		primeNumbersIndex[2] = 0;
		primeNumbersIndex[3] = 1;
		primeNumbersIndex[4] = 1;
		primeNumbersIndex[5] = 2;
		int iCount = 2;
		for(int i = 6; i <= 100000; i++ ) {
			int sqrtNum = (int) Math.ceil(Math.sqrt(i));
			boolean isPrime = true;
			for(int j = 0; primeNumbers[j] <= sqrtNum; j++) {
				primeNumbersIndex[i] = primeNumbersIndex[i-1];
				if(i % primeNumbers[j] == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				primeNumbers[++iCount] = i;
				primeNumbersIndex[i] = iCount;
			}
		}
		return null;
	}

}
