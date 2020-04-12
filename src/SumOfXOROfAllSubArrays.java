import java.util.Scanner;

public class SumOfXOROfAllSubArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int[] arr = new int [10000];
			int n = 0;
			n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			solver x = new solver();
			System.out.println(x.sumSubarrayXOR(arr, n));
			
		}
	}	
}

class solver {
	static long sumSubarrayXOR(int arr[], int n)
    {
		long iSum = 0;
        int[] mySet = new int[n];
        for(int i = 0; i < n; i++){
        	iSum += arr[i];
        	mySet[i] = arr[i];
        }
        for(int i = 0; i < n; i++){
            for(int j = n-1; j > i; j--){
            	mySet[j] = mySet[j-1]^arr[j];
            	 iSum += mySet[j];
            }
        }
         return iSum;
    }
}