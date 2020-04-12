import java.util.*;
import java.lang.*;
import java.io.*;
public class NumberOfPairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
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
			for(int i = 1; i <= 1000; i++) {
				for(int j = 1; j <= 1000; j++) {
					if(iX[i] > 0 && iY[j] > 0) {
						iMVal = j*Math.log(i);
						iNVal = i*Math.log(j);
						if(iMVal > iNVal) {
							iRes += iX[i]*iY[j];
						}
					}
				}
			}
			
			System.out.println(iRes);
			final long endTime = System.currentTimeMillis();
			System.out.println("Total execution time: " + (endTime - startTime));
		}

	}

}
