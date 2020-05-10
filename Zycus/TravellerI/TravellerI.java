package TravellerI;
import java.util.HashMap;
import java.util.Scanner;

public class TravellerI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
        Scanner in = new Scanner(System.in);
        
        // Declare the variable
        int a;
        
        // Read the variable from STDIN
        HashMap<String, Integer> cityIndex = new HashMap<String, Integer>();
        HashMap<Integer, String> indexCity = new HashMap<Integer, String>();
        cityIndex.put("MyStart", 0);
        a = in.nextInt();
        int[][] aCityNet = new int [a+2][a+2];
        for(int i = 0; i < a; i++) {
        	String strFrom = in.next();
        	String strTo = in.next();
        	if(!cityIndex.containsKey(strFrom)) {
        		
        		indexCity.put(cityIndex.size(), strFrom);
        		cityIndex.put(strFrom, cityIndex.size());
        	}
        	if(!cityIndex.containsKey(strTo)) {
        		indexCity.put(cityIndex.size(), strTo);
        		cityIndex.put(strTo, cityIndex.size());
        	}
        	aCityNet[cityIndex.get(strFrom)][0]++;
        	aCityNet[cityIndex.get(strFrom)][aCityNet[cityIndex.get(strFrom)][0]] = cityIndex.get(strTo);
        }
        int startCity = cityIndex.get(in.next());
        int[] aTravelList = new int[a+2];
        int[] aVisitedCity = new int[a+2];
        aVisitedCity[startCity] = 1;
        aTravelList[0]++;
        aTravelList[aTravelList[0]] = startCity;
        aTravelList = getTravellingOrder(aCityNet, startCity, a, aTravelList, aVisitedCity);
        for(int i = 1; i <= aTravelList[0]; i++) {
        	System.out.println(indexCity.get(aTravelList[i]));
        }
        in.close();
        //System.out.println(a);
   }

	private static int[] getTravellingOrder(int[][] aCityNet, int startCity, int a, int[] aTravelList, int[] aVisitedCity) {

		
		for(int i = 1; i <= aCityNet[startCity][0]; i++) {
			int iCity = aCityNet[startCity][i];
			if(aVisitedCity[iCity] == 0) {
				aTravelList[0]++;
				aTravelList[aTravelList[0]] = iCity;
				aVisitedCity[iCity] = 1;
				aTravelList = getTravellingOrder(aCityNet, iCity, a, aTravelList, aVisitedCity);
			}
		}
		return aTravelList;
	}
}
