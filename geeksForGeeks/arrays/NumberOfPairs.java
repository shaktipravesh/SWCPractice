package Arrays;

import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
public class NumberOfPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		double iLog[] = new double [1001];
		for(int i = 1; i <= 1000; i++) {
			iLog[i] = Math.log(i);
		}
		
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			//efficientNumberofPairs(sc);
			myNumberOdPairs(sc, iLog);
		}

	}

	private static void efficientNumberofPairs(Scanner sc) {
		int iM = 0, iN = 0, iRes = 0;		
		iM = sc.nextInt();
		iN = sc.nextInt();
		int iX[] = new int [iM];
		int iY[] = new int [iN];		
		iM = sc.nextInt();
		iN = sc.nextInt();

		for(int i = 0; i < iM; i++) {
			iX[i] = sc.nextInt();
		}
		for(int i = 0; i < iN; i++) {
			iY[i] = sc.nextInt();
		}
		Arrays.sort(iX);
		Arrays.sort(iY);
		int i1 = 0, i2 = 0, j1 = 0, j2 = 0, j3 = 0;
		while(iX[i1]< 2) {
			i1++;
		}
		while(iX[i2]< 3) {
			i2++;
		}
		while(iX[j1]< 1) {
			j1++;
		}
		while(iX[j2]< 2) {
			j2++;
		}
		while(iX[j3]< 5) {
			j3++;
		}
		long count = 0;
		long cx2 = 0;
		
		
	}

	private static void myNumberOdPairs(Scanner sc, double[] iLog) {
		int iM = 0, iN = 0, iRes = 0;
		double iNVal = 0;
		double iMVal = 0;
		int iX[] = new int [1001];
		int iY[] = new int [1001];
		
		iM = sc.nextInt();
		iN = sc.nextInt();

		for(int i = 0; i < iM; i++) {
			iX[sc.nextInt()]++ ;
		}
		for(int i = 0; i < iN; i++) {
			iY[sc.nextInt()]++ ;
		}
		final long startTime = System.currentTimeMillis();
		int iXRef[] = new int [1001];
		int iYRef[] = new int [1001];
		for(int i = 1, j = 1; i <= 1000; i++) {
			if(iX[i] > 0) {
				iXRef[0]++;
				iXRef[j++] = i;
			}
		}
		for(int i = 1, j = 1; i <= 1000; i++) {
			if(iY[i] > 0) {
				iYRef[0]++;
				iYRef[j++] = i;
			}
		}			
		for(int i = 1; i <= iXRef[0]; i++) {
			for(int j = 1; j <= iYRef[0]; j++) {
				//iMVal = iYRef[j]*Math.log(iXRef[i]);
				iMVal = iYRef[j]*iLog[iXRef[i]];
				iNVal = iXRef[i]*iLog[iYRef[j]];
				if(iMVal > iNVal) {
					iRes += iX[iXRef[i]]*iY[iYRef[j]];
				}
			}
		}
		
		System.out.println(iRes);
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime));
	}

}
