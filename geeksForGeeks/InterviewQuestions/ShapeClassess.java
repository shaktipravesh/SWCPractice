package InterviewQuestions;

import java.util.Scanner;

public class ShapeClassess {

	public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);        
	        
	        float radius = Float.parseFloat(sc.nextLine());
	        Circle c1 = new Circle(radius);
	      	System.out.println(c1.getArea());   
	        
	        float width = sc.nextFloat();
	        float height = sc.nextFloat();
	        Rectangle r1 = new Rectangle(width, height);
	      	System.out.println(r1.getArea());
	      	sc.nextLine();
	        
	        radius = Float.parseFloat(sc.nextLine());
	        Circle c2 = new Circle(radius);
	      	System.out.println(c2.getArea());
	    
	        width = Float.parseFloat(sc.nextLine());
	        Square s1 = new Square(width);
	      	System.out.println(s1.getArea());
	        
	      	width = sc.nextFloat();
	        height = sc.nextFloat();
	        Rectangle r2 = new Rectangle(width, height);
	      	System.out.println(r2.getArea());
	        
	        sc.close();
	}

}
class Circle {
	double area;
	Circle(float radius){
		area = (3.14159265*radius*radius);
	}
	long getArea(){
		return (long) Math.ceil(area);
	}
}


class Rectangle {
	double area;
	Rectangle(float width, float height){
		area = width*height;
	}
	long getArea(){
		return (long) area;
	}
}

class Square {
	double area;
	Square(float width){
		area = width*width;
	}
	long getArea(){
		return (long) area;
	}
}

