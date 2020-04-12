package InterviewQuestions;

public class PasswordCreation {

	public static void main(String[] args) {

		String a = new String();
		String b = new String();
		String password = new String();
		a = "cat";
		b = "rabbit";
		password = CreatePassword(a, b);
	}

	private static String CreatePassword(String a, String b) {
		String resPassword= new String();
		for(int i = 0, j = 0; i < a.length() || i < b.length(); i++){
			if( i < a.length() && i < b.length()) {
				resPassword += a.charAt(i);
				resPassword += b.charAt(i);
			} else if (i < a.length()) {
				resPassword += a.charAt(i);
			} else if (i < b.length()) {
				resPassword += b.charAt(i);
			}
		}
		System.out.println(resPassword);
		return resPassword;
	}

}
