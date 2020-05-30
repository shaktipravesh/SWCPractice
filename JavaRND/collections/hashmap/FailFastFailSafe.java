package collections.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafe {
	public static void main(String[] args) {
		FailFastExample failFastExample = new FailFastExample();
		failFastExample.failFastPutExample();
		failFastExample.failFastRemoveExample();
	}
}


class FailFastExample { 
    public void failFastPutExample() 
    { 
        Map<String, String> cityCode = new HashMap<String, String>(); 
        cityCode.put("Delhi", "India"); 
        cityCode.put("Moscow", "Russia"); 
        cityCode.put("New York", "USA"); 
  
        Iterator<String> iterator = cityCode.keySet().iterator(); 
  
        while (iterator.hasNext()) { 
        	cityCode.put("Istanbul", "Turkey"); 
            System.out.println(cityCode.get(iterator.next())); 
  
            // adding an element to Map 
            // exception will be thrown on next call 
            // of next() method. 
            try {
				cityCode.put("Istanbul", "Turkey");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				continue;
			} 
        } 
    } 
    
    public void failFastRemoveExample() 
    { 
        ArrayList<Integer> al = new ArrayList<>(); 
        al.add(1); 
        al.add(2); 
        al.add(3); 
        al.add(4); 
        al.add(5); 
  
        Iterator<Integer> itr = al.iterator(); 
        while (itr.hasNext()) { 
            if (itr.next() == 2) { 
                // will not throw Exception 
                itr.remove(); 
            } 
        } 
  
        System.out.println(al); 
  
        itr = al.iterator(); 
        while (itr.hasNext()) { 
            if (itr.next() == 3) { 
                // will throw Exception on 
                // next call of next() method 
                al.remove(3); 
            } 
        } 
    }
} 


class FailSafe { 
    public static void main(String args[]) 
    { 
        CopyOnWriteArrayList<Integer> list 
            = new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 3, 5, 8 }); 
        Iterator<Integer> itr = list.iterator(); 
        while (itr.hasNext()) { 
            Integer no = (Integer)itr.next(); 
            System.out.println(no); 
            if (no == 8) 
  
                // This will not print, 
                // hence it has created separate copy 
                list.add(14); 
        } 
    } 
} 


class FailSafeItr { 
    public static void main(String[] args) 
    { 
  
        // Creating a ConcurrentHashMap 
        ConcurrentHashMap<String, Integer> map 
            = new ConcurrentHashMap<String, Integer>(); 
  
        map.put("ONE", 1); 
        map.put("TWO", 2); 
        map.put("THREE", 3); 
        map.put("FOUR", 4); 
        
        HashMap<String, Integer> mapHMap = new HashMap<String, Integer>(); 
        mapHMap.put("ONE", 1); 
        mapHMap.put("TWO", 2); 
        mapHMap.put("SEVEN", 7); 
        mapHMap.put("THREE", 3); 
        mapHMap.put("FOUR", 4); 
        
        // Getting an Iterator from map 
        Iterator<String> it = map.keySet().iterator(); 
  
        while (it.hasNext()) { 
            String key = (String)it.next(); 
            System.out.println(key + " : " + map.get(key)); 
  
            // This will reflect in iterator. 
            // Hence, it has not created separate copy 
            map.put("SEVEN", 7); 
        } 
    } 
} 