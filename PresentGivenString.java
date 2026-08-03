package Intermediate;

import java.util.Scanner;

public class PresentGivenString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a string to reverse:");
		String inputString = scanner.nextLine();
		
		String reversedString = new StringBuilder(inputString).reverse().toString();
		System.out.println("Reversed string:" + reversedString);
		
		scanner.close();
	}

}
