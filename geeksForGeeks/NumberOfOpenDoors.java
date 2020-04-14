import java.util.Scanner;

public class NumberOfOpenDoors {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
		    long iNum = sc.nextLong();
		    getOpenDoor(iNum);		    
		}

	}

	private static void getOpenDoor(long iNum) {

		int iOpenCt = (int) Math.sqrt(iNum);
		System.out.println(iOpenCt);
	}

}
