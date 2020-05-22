package singletonDesign.com.sglp;

public class SingletonDesignPattern {

	public static void main(String[] args) {

		
		//Eager Singleton
		EagerSingleton eagerSingleton = EagerSingleton.getInstance();
		EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
		eagerSingleton.printInstance(eagerSingleton);
		eagerSingleton.printInstance(eagerSingleton1);
//		EagerSingleton eagerSingletonNew = new EagerSingleton();
//		eagerSingletonNew.printInstance(eagerSingletonNew);

		LazySingleton lazySingleton = LazySingleton.getInstance();
		LazySingleton lazySingleton1 = LazySingleton.getInstance();
		lazySingleton.printInstance(lazySingleton);
		lazySingleton1.printInstance(lazySingleton1);		
		
		LazySynchronizedSingleton lazySynchronizedSingleton = LazySynchronizedSingleton.getInstance();
		LazySynchronizedSingleton lazySynchronizedSingleton1 = LazySynchronizedSingleton.getInstance();
		lazySynchronizedSingleton.printInstance(lazySynchronizedSingleton);
		lazySynchronizedSingleton1.printInstance(lazySynchronizedSingleton1);	
	
		
		LazySynchronizedDoubleCheckSingleton lazySynchronizedDoubleCheckSingleton = LazySynchronizedDoubleCheckSingleton.getInstance();
		LazySynchronizedDoubleCheckSingleton lazySynchronizedDoubleCheckSingleton1 = LazySynchronizedDoubleCheckSingleton.getInstance();
		lazySynchronizedDoubleCheckSingleton.printInstance(lazySynchronizedDoubleCheckSingleton);
		lazySynchronizedDoubleCheckSingleton1.printInstance(lazySynchronizedDoubleCheckSingleton1);	

		EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
		enumSingleton.someMethod("Enum: ");
		System.out.println(enumSingleton);

		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				EagerSingleton eagerSingleton = EagerSingleton.getInstance();
				eagerSingleton.printInstance(eagerSingleton);
				LazySingleton lazySingleton = LazySingleton.getInstance();
				lazySingleton.printInstance(lazySingleton);
				LazySynchronizedSingleton lazySynchronizedSingleton = LazySynchronizedSingleton.getInstance();
				lazySynchronizedSingleton.printInstance(lazySynchronizedSingleton);

			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				EagerSingleton eagerSingleton = EagerSingleton.getInstance();
				eagerSingleton.printInstance(eagerSingleton);
				LazySingleton lazySingleton = LazySingleton.getInstance();
				lazySingleton.printInstance(lazySingleton);
				LazySynchronizedSingleton lazySynchronizedSingleton = LazySynchronizedSingleton.getInstance();
				lazySynchronizedSingleton.printInstance(lazySynchronizedSingleton);

			}
		});
		
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		
	
	}

}
