package constructor;

public class ShadowingOftatisFunctions {

	public static void main(String[] args) {
        A a = new B(); 
        a.fun(); // prints A.fun(); 
  
        B b = new B(); 
        b.fun(); // prints B.fun() 
  
        A c = new A(); 
        c.fun();


	}

}

// Parent class 
class A { 
    void fun() 
    { 
        System.out.println("A.fun()"); 
    } 
} 
  
// B is inheriting A 
// Base class 
class B extends A { 
    void fun() 
    { 
        System.out.println("B.fun()"); 
    } 
} 
  
