package singletonDesign.com.sglp;

public class LazySingleton {
	private static volatile LazySingleton instance = null;

	// private constructor
	private LazySingleton() {
		System.out.println("LazySingleton instance created");
	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	public void printInstance(LazySingleton instance) {
		System.out.println(instance);
	}
}
