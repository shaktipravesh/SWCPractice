import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersinaMatrix5356 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
		luckyNumbers(matrix);
	}
    public static List<Integer> luckyNumbers (int[][] matrix) {
    	List<Integer> iRetList = new ArrayList<Integer>();
    	int[] iColumnMax = new int[matrix[0].length];
        int[] iRowMin = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[i].length; j++) {
        		if(matrix[i][j] > matrix[iColumnMax[j]][j])
        			iColumnMax[j] = i;
        		if(matrix[i][j] < matrix[i][iRowMin[i]])
        			iRowMin[i] = j;
        	}
        }
        for(int i = 0; i < iColumnMax.length; i++) {
        	for(int j = 0; j < iRowMin.length; j++) {
        		if(iColumnMax[i] == j && iRowMin[j] == i)
        			iRetList.add(matrix[j][i]);
        	}
        }
        return iRetList;
    }
}
