package basicConcept;

public class DeadCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void howToDoInJava_method1() {
		System.out.println("how to do");
		return;
		System.out.println("in java");
	}

	public void howToDoInJava_method2() {
		System.out.println("how to do");
		if (true) {
			return;
		}
		System.out.println("in java");
	}

	public void howToDoInJava_method3() {
		System.out.println("how to do");
		while (true) {
			return;
		}
		System.out.println("in java");
	}

}

class IdentifyProblemsInCode {

	public void howToDoInJava_method1() {
		System.out.println("how to do");
		return;
		System.out.println("in java");
	}

	public void howToDoInJava_method2() {
		System.out.println("how to do");
		if (true) {
			return;
		}
		System.out.println("in java");
	}

	public void howToDoInJava_method3() {
		System.out.println("how to do");
		while (true) {
			return;
		}
		System.out.println("in java");
	}

	public void howToDoInJava_method21() {
		System.out.println("how to do");

		if (true) {
			return;
		} else {
			return;
		}

		System.out.println("in java");
	}
}