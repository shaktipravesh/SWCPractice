package BitMagic;

import java.util.Scanner;

public class FindOutTheTeam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iNum = sc.nextInt();
			if(iNum == 1)
				System.out.println(iNum);
			else
				System.out.println(iNum>>1);
		}
	}

}
