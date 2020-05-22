package singletonDesign.com.sglp;

public class LazySynchronizedDoubleCheckSingleton {
	private static volatile LazySynchronizedDoubleCheckSingleton instance = null;

	// private constructor
	private LazySynchronizedDoubleCheckSingleton() {
		System.out.println("LazySynchronizedDoubleCheckSingleton instance created");
	}

	public static LazySynchronizedDoubleCheckSingleton getInstance() {
		if (instance == null) {
			synchronized (LazySynchronizedDoubleCheckSingleton.class) {
				// Double check
				if (instance == null) {
					instance = new LazySynchronizedDoubleCheckSingleton();
				}
			}
		}
		return instance;
	}

	public void printInstance(LazySynchronizedDoubleCheckSingleton instance) {
		System.out.println(instance);
	}

}
