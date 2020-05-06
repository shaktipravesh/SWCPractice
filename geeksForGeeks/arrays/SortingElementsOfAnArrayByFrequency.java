package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SortingElementsOfAnArrayByFrequency {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		sc.nextLine();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iNum = sc.nextInt();
			int[] aNum = new int[iNum];
			for(int i = 0; i < iNum; i++) {
				aNum[i] = sc.nextInt();
			}
			
			Sorting.sortByFreq(aNum, iNum);
			System.out.println();
		}
		sc.close();
	}

}


class Sorting
{
    static void sortByFreq(int arr[], int n)
    {
    	int[] aNum = new int[61];
    	for(int i = 0; i < n; i++) {
			aNum[arr[i]]++;
		}
    	
    	int[] myArray = new int[61];
    	for(int i = 1, j = 0; i <= 60; i++) {
    		if(aNum[i] > 0) {
    			myArray[j++] = aNum[i]*100 + (60-i+1);
    		}
    	}
    	Arrays.parallelSort(myArray);
    	for(int i = 60; i > 0 && myArray[i] > 0; i--) {
    		int iNum = myArray[i]%100;
    		for(int j = 1; j <= myArray[i]/100; j++) {
    			System.out.print((60-iNum+1) + " ");
			}
		}
	}
    
//    void cSortbyFreq(int arr[], int n) {
//    	int[] hash= new int[61];
//    	for(int i=0;i<n;i++)
//    	    hash[arr[i]]++;
//    	    
//    	multimap<int,int,greater <int>> m;
//    	for(int i=0;i<61;i++)
//    	{
//    	    if(hash[i]>0)
//    	        m.insert(make_pair(hash[i],i));
//    	}
//    	multimap<int,int>::iterator it;
//    	for(it=m.begin();it!=m.end();it++)
//    	{
//    	    int j = it->first;
//    	    while(j--)
//    	        cout<<it->second<<" ";
//    	}
//    }
}


/*
 * https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency-1587115621/1
 * 
 * Given an array A[] of integers, sort the array according to frequency of
 * elements. That is elements that have higher frequency come first. If
 * frequencies of two elements are same, then smaller number comes first.
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. The description of T test cases follows. The first line of each
 * test case contains a single integer N denoting the size of array. The second
 * line contains N space-separated integers A1, A2, ..., AN denoting the
 * elements of the array.
 * 
 * Output: For each testcase, in a new line, print each sorted array in a
 * seperate line. For each array its numbers should be seperated by space.
 * 
 * Your Task: This is a function problem. You only need to complete the function
 * sortByFreq that takes arr, and n as parameters and prints the sorted
 * elements. Endline is provided by the driver code.
 * 
 * Constraints: 1 ≤ T ≤ 70 30 ≤ N ≤ 130 1 ≤ Ai ≤ 60
 * 
 * Example: Input: 2 5 5 5 4 6 4 5 9 9 9 2 5 Output: 4 4 5 5 6 9 9 9 2 5
 * 
 * Explanation: Testcase1: The highest frequency here is 2. Both 5 and 4 have
 * that frequency. Now since the frequencies are same then smaller element comes
 * first. So 4 4 comes first then comes 5 5. Finally comes 6. The output is 4 4
 * 5 5 6. Testcase2: The highest frequency here is 3. The element 9 has the
 * highest frequency. So 9 9 9 comes first. Now both 2 and 5 have same
 * frequency. So we print smaller element first. The output is 9 9 9 2 5.
 * 
 */

//3
//5
//1 2 3 4 5
//5
//5 5 4 6 4
//5
//9 9 9 2 5

