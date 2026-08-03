package Intermediate;
import java.util.Scanner;

public class PalindromeString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nothing");
		String inputString = sc.nextLine();
		String reverseString = "";
		
		for (int i = inputString.length() -1; i>=0; i--) {
			reverseString += inputString.charAt(i);
		}
		if (inputString.equalsIgnoreCase(reverseString)) {
			System.out.println(inputString + "is a palindrome.");
		} else {
			System.out.println(inputString + "is not a palindrome.");
		}
	}

}
