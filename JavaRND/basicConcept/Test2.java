package basicConcept;

//file name: Main.java 

class Complex { 
 private double re, im;     
 public String toString() { 
     return "(" + re + " + " + im + "i)"; 
 } 
 Complex(Complex c) { 
     re = c.re; 
     im = c.im; 
 } 
} 

public class Test2 { 
 public static void main(String[] args) { 
     Complex c1 = new Complex(); 
     Complex c2 = new Complex(c1); 
     System.out.println(c2); 
 } 
}