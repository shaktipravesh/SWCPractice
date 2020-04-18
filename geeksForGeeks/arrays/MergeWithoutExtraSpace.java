package Arrays;

import java.util.Scanner;

public class MergeWithoutExtraSpace {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize1 = 0, iSize2 = 0;
			int arr1[] = new int[iSize1];
		    int arr2[] = new int[iSize2];
		    iSize1 = sc.nextInt(); 
		    iSize2 = sc.nextInt();
		    for(int i = 0; i < iSize1; i++) {
		    	arr1[i] = sc.nextInt();
		    }
		    for(int i = 0; i < iSize2; i++) {
		    	arr2[i] = sc.nextInt();
		    }
		    mergeArray(arr1, arr2, iSize1, iSize2);
		}

	}

	private static void mergeArray(int[] arr1, int[] arr2, int iSize1, int iSize2) {

		for(int i = 0, j = 0; i < iSize1 && j < iSize2; ) {
			
		}
		
	}

}
