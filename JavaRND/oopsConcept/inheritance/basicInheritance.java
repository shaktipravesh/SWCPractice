package oopsConcept.inheritance;

class ByCycle{
	int gear;
	int speed;
	public ByCycle(int gear, int speed) {
		this.gear = gear;
		this.speed = speed; 
	}
	public void speedUp(int increment) {
		speed += increment;
	}
	public void applyBrake(int decrement) {
		gear -= decrement;
	}
	public String toString() {
		return ("No of gears in Cycle are " + gear 
                +"\n"
                + "Speed of bicycle is " + speed); 
	}
}

class MyBike extends ByCycle{

	int tyreThickNess;
	public void setTyreThickNess(int tyreThickNess) {
		this.tyreThickNess = tyreThickNess;
	}
	public int getTyreThickNess() {
		return tyreThickNess;
	}
	public MyBike(int gear, int speed, int tyreThickNess) {
		super(gear, speed);
		this.tyreThickNess = tyreThickNess;
	}
	public String toString() {
		return super.toString() + "\n" + "Tye thickness of My CYcle is " + tyreThickNess;
	}
	
}


public class basicInheritance {

	public static void main(String[] args) {
		ByCycle yourBike = new ByCycle(6, 25);
		MyBike myBike = new MyBike(3, 20, 4);
		System.out.println(myBike.toString());
		System.out.println(yourBike.toString());
		myBike.speedUp(3);
		System.out.println(myBike.toString());
		System.out.println(yourBike.toString());
	}

}
