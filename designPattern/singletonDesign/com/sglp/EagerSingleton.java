package singletonDesign.com.sglp;

public class EagerSingleton {
	
	private static volatile EagerSingleton instance = new EagerSingleton();

	// this will restrict to access through new, ad you have to directly access the class.. 
	// private constructor
	private EagerSingleton() {
	}

	//public enable to access this method from anywhere.
	// static help to access without using new creation method
	public static EagerSingleton getInstance() {
		return instance;
	}
	
	public void printInstance(EagerSingleton instance) {
		System.out.println(instance);
	}
}
