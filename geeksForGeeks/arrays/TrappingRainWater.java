package arrays;

import java.util.Scanner;
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class TrappingRainWater {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iSize = sc.nextInt();
			
			
			long iTrapedWater = 0;
			
			//two array method O(n) space O(n)
			iTrapedWater = getTrappedWater(sc, iSize);
			//two array method O(n) space O(1)
			iTrapedWater = getTrappedWaterTwoPointerMethod(sc, iSize);
			System.out.println(iTrapedWater);
		}
		sc.close();
	}

	

    private static long getTrappedWaterTwoPointerMethod(Scanner sc, int iSize) {
    	int arr[]=new int[iSize];
	    for(int i=0;i<iSize;i++)
	    {
	        arr[i]=sc.nextInt();
	    }
	    long result=0;
	    int left=0;
	    int right=iSize-1;
	    int left_max=arr[0];
	    int right_max=arr[iSize-1];
	    while(left<right)
	    {   
	       
	       if(right_max>left_max)
	       {
	          left++;
	          while(left<right && arr[left]<left_max)
	          {
	             result=result+left_max-arr[left];
	             left++;
	          }
	          left_max=arr[left];
	       
	       }else{
	           
	           right--;
	            while(left<right && arr[right]<right_max)
	          {
	             result=result+right_max-arr[right];
	             right--;
	          }
	          right_max=arr[right];
	       }
	    }
		return result;
	}



	private static long getTrappedWater(Scanner sc, int iSize) {
    	long iTrapedWater = 0;
    	int[][] iNumArray = new int[iSize+2][3];
		for(int i =1; i <= iSize; i++) {
			iNumArray[i][0] = sc.nextInt();
			iNumArray[i][1] = Math.max(iNumArray[i-1][1], iNumArray[i][0]);
		}
		for(int i =iSize; i > 0; i--) {
			iNumArray[i][2] = Math.max(iNumArray[i+1][2], iNumArray[i][0]);
			iTrapedWater += Math.min(iNumArray[i][1], iNumArray[i][2]) - iNumArray[i][0];
		}
		
		return iTrapedWater;
	}



	static class Reader 
    { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 
  
        public Reader() 
        { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
        } 
  
        public int nextInt() throws IOException 
        { 
            int ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do
            { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = read()) >= '0' && c <= '9'); 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    } 
	public static void main_main (String[] args) throws java.lang.Exception {
		//code
		Reader sc=new Reader();
		int t=sc.nextInt();
		while(t-->0)
		{    
		    int s=sc.nextInt();
		    int arr[]=new int[s];
		    for(int i=0;i<s;i++)
		    {
		        arr[i]=sc.nextInt();
		    }
		    int result=0;
		    int left=0;
		    int right=s-1;
		    int left_max=arr[0];
		    int right_max=arr[s-1];
		    while(left<right)
		    {   
		       
		       if(right_max>left_max)
		       {
		          left++;
		          while(left<right && arr[left]<left_max)
		          {
		             result=result+left_max-arr[left];
		             left++;
		          }
		          left_max=arr[left];
		       
		       }else{
		           
		           right--;
		            while(left<right && arr[right]<right_max)
		          {
		             result=result+right_max-arr[right];
		             right--;
		          }
		          right_max=arr[right];
		       }
		    }
		   
		   
		    System.out.println(result);
		}
	}
}




/*
 * https://practice.geeksforgeeks.org/problems/trapping-rain-water/0/
 * 
 * Given an array arr[] of N non-negative integers representing height of blocks
 * at index i as Ai where the width of each block is 1. Compute how much water
 * can be trapped in between blocks after raining. Structure is like below: | |
 * |_| We can trap 2 units of water in the middle gap.
 * 
 * 
 * 
 * Input: The first line of input contains an integer T denoting the number of
 * test cases. The description of T test cases follows. Each test case contains
 * an integer N denoting the size of the array, followed by N space separated
 * numbers to be stored in array.
 * 
 * Output: Output the total unit of water trapped in between the blocks.
 * 
 * Constraints: 1 <= T <= 100 3 <= N <= 107 0 <= Ai <= 108
 * 
 * Example: Input: 2 4 7 4 0 9 3 6 9 9
 * 
 * Output: 10 0
 * 
 * Explanation: Testcase 1: Water trapped by block of height 4 is 3 units, block
 * of height 0 is 7 units. So, total unit of water trapped is 10 units.
 * 
 * 
 */

