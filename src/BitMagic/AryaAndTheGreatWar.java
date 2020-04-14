package BitMagic;

import java.util.Scanner;

public class AryaAndTheGreatWar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iNum = sc.nextInt();
			int iSteps = 0;
			iSteps = getSetBits(iNum);
			System.out.println(iSteps);
		}
		sc.close();

	}

	private static int getSetBits(int iNum) {
		int iSetBits = 0;
		while(iNum > 0) {
			iSetBits += iNum &1;
			iNum = iNum >>1;
		}
		return iSetBits;
	}

}
