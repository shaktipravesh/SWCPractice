package basicConcept;

public class CreateClassWithoutNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoClass objNew = new DemoClass();
		objNew.nonStaticMethod();
		
		try {
			Class ref = Class.forName("DemoClass");
			DemoClass objWithoutNew = (DemoClass) ref.newInstance();
			objWithoutNew.nonStaticMethod();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class DemoClass{
    private static void staticMethod() 
    { 
        //Can be called by null reference 
        System.out.println("static method, can be called by null reference"); 
          
    } 
          
    public void nonStaticMethod() 
    { 
        //Can not be called by null reference 
        System.out.print(" Non-static method- "); 
        System.out.println("cannot be called by null reference"); 
          
    } 	
}