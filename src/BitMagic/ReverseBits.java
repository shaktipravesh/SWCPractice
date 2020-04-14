package BitMagic;

import java.util.Scanner;

public class ReverseBits {
	public ReverseBits(Scanner sc){
		int iNum = sc.nextInt();
		int iCount = 31, iResNum = 0;
		while (iNum > 0) {
			iResNum = iResNum<<1;
			iResNum = iResNum | (iNum & 1);
			iNum = iNum >> 1;
			iCount--;
		}
		iResNum = iResNum <<iCount;
		System.out.println(iResNum);
		
	}
}
