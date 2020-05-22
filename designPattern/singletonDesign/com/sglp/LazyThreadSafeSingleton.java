package singletonDesign.com.sglp;

public class LazyThreadSafeSingleton {
	private static volatile LazyThreadSafeSingleton instance = null;

	// private constructor
	private LazyThreadSafeSingleton() {
		System.out.println("LazyThreadSafeSingleton instance created");
	}

	/*
	 * A thread safe singleton in created so that singleton property is maintained
	 * even in multithreaded environment. To make a singleton class thread-safe,
	 * getInstance() method is made synchronized so that multiple threads can’t
	 * access it simultaneously.
	 */
	synchronized public static LazyThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new LazyThreadSafeSingleton();
		}
		return instance;
	}

	public void printInstance(LazyThreadSafeSingleton instance) {
		System.out.println(instance);
	}

}