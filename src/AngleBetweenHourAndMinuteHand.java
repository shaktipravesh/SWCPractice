import java.util.Scanner;

public class AngleBetweenHourAndMinuteHand {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iHour = 0, iMinute = 0;
			float fHourAngle = 0, fMinuteAngle = 0;
			iHour = sc.nextInt();
			iMinute = sc.nextInt();
			fHourAngle = iHour*30 + 30*((float) iMinute/60);
			fMinuteAngle = 6*iMinute;
			if(fMinuteAngle > fHourAngle) {
				if((fMinuteAngle- fHourAngle) > 180) {
					System.out.println((int)(360-(fMinuteAngle- fHourAngle)));
				} else {
					System.out.println((int)(fMinuteAngle- fHourAngle));
				}
			} else {
				if((fHourAngle - fMinuteAngle) > 180) {
					System.out.println((int)(360-(fHourAngle - fMinuteAngle)));
				} else {
					System.out.println((int)(fHourAngle - fMinuteAngle));
				}				
			}
			
		}

	}

}
