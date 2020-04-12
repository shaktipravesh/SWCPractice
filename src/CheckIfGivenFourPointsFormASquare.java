import java.util.Scanner;

public class CheckIfGivenFourPointsFormASquare {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int isSquare = 0;
			int[] a = new int[]{0, 0, 0, 0}; 
			int[] b = new int[]{0, 0, 0, 0}; 
			for (int i = 0; i < 4; i++) {
				a[i] = sc.nextInt(); 
				b[i] = sc.nextInt(); 
			}
			isSquare =  isItaSquare(a, b);
			System.out.println(isSquare);
		}

	}

	private static int isItaSquare(int[] a, int[] b) {
		int iSide = 0, iDia1 = 0, iDia2 = 0, iSideTemp = 0;
		iSide = (a[0] - a[1])*(a[0] - a[1]) + (b[0] - b[1])*(b[0] - b[1]);
		if(iSide == 0)
		    return 0;
		
		for(int i = 0; i < 4; i++) {
			int j = (i+1)%4;
			iSideTemp = (a[i] - a[j])*(a[i] - a[j]) + (b[i] - b[j])*(b[i] - b[j]);
			if(iSide != iSideTemp) {
				if(!(((iSide > iSideTemp) && (iSide == 2*iSideTemp)) || (2*iSide == iSideTemp)))
					return 0;
			}
			j = (i+2)%4;
			iSideTemp = (a[i] - a[j])*(a[i] - a[j]) + (b[i] - b[j])*(b[i] - b[j]);
			if(iSide != iSideTemp) {
				if(!(((iSide > iSideTemp) && (iSide == 2*iSideTemp)) || (2*iSide == iSideTemp)))
					return 0;
			}
		}

		return 1;
	}

}
