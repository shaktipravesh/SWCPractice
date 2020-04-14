
public class MaximumSubsetXOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int set[] = {44, 22, 33, 11};
		maxSubarrayXOR(set, 4);
	}

	public static int maxSubarrayXOR(int set[], int n)
    {
        int[][][] mySet = new int[n][n][n];
        int iMaxXOR = 0;
        for(int i = 0; i < n; i++){
        	for(int j = 0; j <= i; j++){
        		mySet[i][j][0] = set[i];
        	}
        }
        for(int j = 0; j < n; j++){
            for(int i = j; i < n; i++){
                for(int k = i - j + 1; k + j < n; k++){
                    mySet[k+j][j][i-j+1] = mySet[i][j][i-j]^set[k+j];
                    if((mySet[k+j][j][i-j+1]) > iMaxXOR)
                        iMaxXOR = mySet[k+j][j][i-j+1];
                }
               
            }
        }
//        for(int i = 0; i <= n; i++){
//            for(int j = 1; j <= i+1; j++){
//            	mySet[i+1][j][0] = mySet[i][0][0]^set[j];
//                if((set[i]^set[j]) > iMaxXOR)
//                    iMaxXOR = set[i]^set[j];
//            }
//        }
         //add code here.
         return iMaxXOR;
    }
}
