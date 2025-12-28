/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args) {
    	System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String s) {
		int len = s.length();
		if (len == 0) {
			return true;
		}
		if (len == 1) {
			return true;
		}
		char firstCh = s.charAt(0);
		char lastCh = s.charAt(len - 1);
		if (firstCh != lastCh) {
			return false;
		}
		return isPalindrome(s.substring(1, len - 1));
    }
}