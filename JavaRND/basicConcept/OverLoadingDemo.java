package basicConcept;

class Demo {
	public void show(int x) {
		System.out.println("In int" + x);
	}

	public void show(String s) {
		System.out.println("In String" + s);
	}

	public void show(byte b) {
		System.out.println("In byte" + b);
	}

	public void show(boolean b) {
		System.out.println("In boolean" + b);
	}
}

class OverLoadingDemo {
	public static void main(String[] args) {
		byte a = 25;
		boolean b = true;
		// obj.show(b);
		Demo obj = new Demo();

		obj.show(a); // it will go to
		// byte argument
		obj.show("hello"); // String
		obj.show(250); // Int
		obj.show('A'); // Since char is
		// not available, so the datatype
		// higher than char in terms of
		// range is int.
		obj.show("A"); // String
		// obj.show(7.5); // since float datatype
// is not available and so it's higher 
// datatype, so at this step their 
// will be an error. 
		OverLoadingDemo.main("Geek");
	}

	// Overloaded main methods
	public static void main(String arg1) {
		System.out.println("Hi, " + arg1);
		OverLoadingDemo.main("Dear Geek", "My Geek");
	}

	public static void main(String arg1, String arg2) {
		System.out.println("Hi, " + arg1 + ", " + arg2);
	}
}