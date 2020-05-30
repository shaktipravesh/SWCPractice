package oopsConcept.inheritance;

import java.util.jar.Attributes.Name;

class Writer 
{ 
    public  static void write() 
    { 
        System.out.println("Writing..."); 
    } 
    public  void read() 
    { 
        System.out.println("Reading..."); 
    } 
} 
class Author extends Writer 
{ 
    public  static void write() 
    { 
        System.out.println("Writing book"); 
    } 
    public  void read() 
    { 
        System.out.println("Reading Book..."); 
    } 
} 
  
public class staticOverLoading extends Author 
{ 
    public  static void write() 
    { 
        System.out.println("Writing code"); 
    } 
  
    public  void read() 
    { 
        System.out.println("Reading Code..."); 
    } 
    
    public static void main(String[] args) 
    { 
        Author a = new staticOverLoading(); 
        a.write(); 
        a.read();
        staticOverLoading b = new staticOverLoading();
        b.name();
        b.nameLaterall();
        
        Person p = new Kid();   
        p.whoAmI();  
        p.whoAreYou();  
        
        
        {
        Integer c = 128, f = 128; 
        System.out.println(c == f); 
  
        Integer e = 100, d = 100; 
        System.out.println(e == d); 
        }
        
    } 
    
    public void nameLaterall() {
    	String s1 = "geeksforgeeks"; 
        String s2 = "geeksforgeeks"; 
        if (s1 == s2)  
            System.out.println("Equal"); 
        else
            System.out.println("Not equal"); 
	}
    
    public void name() {
    	String s1 = new String("geeksforgeeks"); 
        String s2 = new String("geeksforgeeks"); 
        if (s1 == s2)  
            System.out.println("Equal"); 
        else
            System.out.println("Not equal"); 
	}
} 



class Person  
{  
    private void who() 
    { 
        System.out.println("Inside private method Person(who)"); 
    } 
   
    public static void whoAmI() 
    { 
        System.out.println("Inside static method, Person(whoAmI)"); 
    } 
   
    public void whoAreYou() 
    { 
        who(); 
        System.out.println("Inside virtual method, Person(whoAreYou)"); 
    } 
} 
  
class Kid extends Person 
{  
    private void who() 
    { 
        System.out.println("Kid(who)"); 
    } 
   
    public static void whoAmI() 
    { 
        System.out.println("Kid(whoAmI)"); 
    } 
   
    public void whoAreYou() 
    { 
        who(); 
        System.out.println("Kid(whoAreYou)"); 
    } 
} 
class Gfg 
{ 
    public static void main(String args[])  
    { 
        Person p = new Kid();   
        p.whoAmI();  
        p.whoAreYou();  
    } 
} 