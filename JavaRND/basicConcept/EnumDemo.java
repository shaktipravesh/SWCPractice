package basicConcept;

class EnumDemo { 
    public enum Day { MON, 
                      TUE, 
                      WED, 
                      THU, 
                      FRI, 
                      SAT, 
                      SUN } 
    public enum Month { JAN, 
                        FEB, 
                        MAR, 
                        APR, 
                        MAY, 
                        JUN, 
                        JULY } 
    public static void main(String[] args) 
    { 
        // Comparing two enum members which are from different enum type 
        // using == operator 
        //System.out.println(Month.JAN == Day.MON); 
  
        // Comparing two enum members which are from different enum type 
        // using .equals() method 
        System.out.println(Month.JAN.equals(Day.MON)); 
    } 
} 