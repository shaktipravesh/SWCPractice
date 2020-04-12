import java.util.HashMap;
import java.util.Scanner;

public class DayOfTheWeek {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> dateDayHMap = new HashMap<Integer, String>();
        HashMap<Integer, Integer> monthDayHMap = new HashMap<Integer, Integer>();
        createDateDayHMap(dateDayHMap);
        createMonthDayHMap(monthDayHMap);
        
		int iTestCt = 0;
		iTestCt = sc.nextInt();
		for(int iTemp = 1; iTemp <= iTestCt; iTemp++){
			int iYear = 0, iMonth = 0, iDate = 0, iTotalDays = 0;
			String Day = new String();
			
			
			iDate = sc.nextInt();
			iMonth = sc.nextInt();
			iYear = sc.nextInt();
			iTotalDays += daysFromYear(iYear);
			iTotalDays += daysFromMonth(iYear, iMonth, monthDayHMap);
			iTotalDays += iDate;
			Day = dateDayHMap.get(iTotalDays%7);
			System.out.println(Day);
		}

	}

	private static int daysFromMonth(int iYear, int iMonth, HashMap<Integer, Integer> monthDayHMap) {
		int iDays = 0;
		for(int i = 1; i < iMonth; i++) {
			iDays += monthDayHMap.get(i);
		}
		if(iYear%4==0 && iMonth > 2) {
			iDays += 1;
		}
		return iDays;
	}
	
	private static void createMonthDayHMap(HashMap<Integer, Integer> monthDayHMap) {
		monthDayHMap.put(1, 31);
		monthDayHMap.put(2, 28);
		monthDayHMap.put(3, 31);
		monthDayHMap.put(4, 30);
		monthDayHMap.put(5, 31);
		monthDayHMap.put(6, 30);
		monthDayHMap.put(7, 31);
		monthDayHMap.put(8, 31);
		monthDayHMap.put(9, 30);
		monthDayHMap.put(10, 31);
		monthDayHMap.put(11, 30);
		monthDayHMap.put(12, 31);
	}

	private static int daysFromYear(int iYear) {
		
		return (365*(iYear - 1900) + (iYear-1900-1)/4);
	}

	private static void createDateDayHMap(HashMap<Integer, String> dateDayHMap) {
		dateDayHMap.put(1, "Monday");
		dateDayHMap.put(2, "Tuesday");
		dateDayHMap.put(3, "Wednesday");
		dateDayHMap.put(4, "Thursday");
		dateDayHMap.put(5, "Friday");
		dateDayHMap.put(6, "Saturday");
		dateDayHMap.put(0, "Sunday");
	}

}
