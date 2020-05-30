package basicConcept;

//filename Main.java 
class Point {
	protected int x, y;

	public Point(int _x, int _y) {
		x = _x;
		y = _y;
	}
}

public class OutputClass {

	int i = 20;
	OutputClass(int x){
		i = x;
	}
	public static void main(String args[]) {
		Point p = new Point(10, 20);
		System.out.println("x = " + p.x + ", y = " + p.y);
		OutputClass otptCl = new OutputClass(10);
		System.out.println(otptCl.i);
	}
}