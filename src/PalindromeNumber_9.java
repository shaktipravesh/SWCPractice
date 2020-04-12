
public class PalindromeNumber_9 {
	public static void main(String[] args) {
		boolean isPalindrome = false;
		isPalindrome = isPalindrome(121);
	}
	
	public static boolean isPalindrome(int x) {
		boolean isPalindrome = true;
		if(x<0)
			return false;
		String inPutString = new String();
		while (x > 0) {
			inPutString = inPutString + x%10;
			x = x/10;
		}
		for(int i = 0, j = inPutString.length()-1; i<j;  i++, j--) {
			if(inPutString.charAt(i) != inPutString.charAt(j)) {
				isPalindrome = false;
				break;
			}
				
		}
        return isPalindrome;
    }
}
