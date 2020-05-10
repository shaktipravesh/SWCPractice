package singletonPattern;

import java.util.HashSet;

public class SingletonPattern {

	public static void main(String[] args) {
		show s=show.getInstance();
	    show p=show.getInstance();

	    System.out.println( s.bookSeat("1A"));
	    System.out.println( p.bookSeat("1A"));
	    System.out.println( s.bookSeat("2A"));
	    System.out.println( p.bookSeat("2A"));

	}

}


class show
{
    ///*complete this line*/ show INSTANCE =new show();
    private static show INSTANCE = new show();
    /*declare the variable availableSeats*/
    private HashSet<String> availableSeats;

    public static show getInstance()
    {
        return INSTANCE;
    }

    ///*complete this line*/  show()
    private show()
    {
        availableSeats = new HashSet<String>();
        availableSeats.add("1A");
        availableSeats.add("2A");
    }

    /*
     * declare a function 
     * bookSeat(String seat)
     *  this function will return a boolean result after the follwing seat is removed.
     */
    boolean bookSeat(String seat){
    	if(availableSeats.contains(seat)) {
    		availableSeats.remove(seat);
    		return true;
    	}
		return false;
    	
    }
    
    
}