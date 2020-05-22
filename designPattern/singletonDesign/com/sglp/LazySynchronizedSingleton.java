package singletonDesign.com.sglp;

public class LazySynchronizedSingleton {
	private static volatile LazySynchronizedSingleton instance = null;

	// private constructor
	private LazySynchronizedSingleton() {
		System.out.println("LazySynchronizedSingleton instance created");
	}

	public static LazySynchronizedSingleton getInstance() {
		if (instance == null) {
			synchronized (LazySynchronizedSingleton.class) {
				instance = new LazySynchronizedSingleton();
			}
		}
		return instance;
	}
	
	public void printInstance(LazySynchronizedSingleton instance) {
		System.out.println(instance);
	}

}