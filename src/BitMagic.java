import java.util.Scanner;

public class BitMagic {

	public static void main(String[] args) {

		BinaryNumtoDecimal();
		//Powerof2();
		// toggleBit();

	}

	private static void BinaryNumtoDecimal() {
		Scanner sc = new Scanner(System.in);
		
		int iTestCt = 0;
		iTestCt = sc.nextInt();;
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			String iBinaryNum = new String();
			int iDecimalValue = 0;
			iBinaryNum = sc.next();
			for (int i = 0; i < iBinaryNum.length(); i++) {
				if(iBinaryNum.charAt(i) == '1') {
					iDecimalValue = iDecimalValue | (1<< i);
				}
			}
			System.out.println(iDecimalValue);
		}
		
	}

	private static void Powerof2() {

		Scanner sc = new Scanner(System.in);
		
		int iTestCt = 0;
		iTestCt = sc.nextInt();;
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
		    long iNum = 0;
		    iNum =  sc.nextLong();
		    if(iNum > 0)
	            iNum = 3;
		    while(iNum > 0){
		        if((iNum & 1) == 1){
		            iNum = iNum >> 1;
		            break;
		        }
		        iNum = iNum >> 1;
		    }
		    if(iNum > 0)
		        System.out.println("NO");
		    else
		        System.out.println("YES");
		}
		sc.close();

	}

	private static void toggleBit() {
		int iNum = 916, iFrom = 4, iTo = 4, iPrefix = 0, iToggle = 0;
		// cin >> iNum >> iFrom >> iTo;
		for (int i = 0; i < iTo; i++) {
			if (i < iFrom - 1) {
				iPrefix = iPrefix | ((iNum & 1) << i);
			} else {
				int iBit = (iNum & 1);
				iBit = iBit ^ 1;
				iBit = iBit << i;
				// cout << iBit <<endl;
				iToggle = iToggle | iBit;
				// cout << iToggle <<endl;
			}
			iNum = iNum >> 1;
		}
		// cout << endl << iNum <<endl;
		iNum = iNum << iTo;
		// cout << iNum <<endl;
		// iToggle = iToggle << (iFrom-1);

		// cout << iPrefix <<endl;
		// cout << iToggle <<endl;
		iNum = iNum | iToggle;
		iNum = iNum | iPrefix;
		// cout << iNum <<endl<<endl<<endl;

	}

}
