package BitMagic;

import java.util.Scanner;

public class BitMagic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			ReverseBits reverseBit = new ReverseBits();
			reverseBit.ReverseBits(sc);
		}

			
	}

}

	