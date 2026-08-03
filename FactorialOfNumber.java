package Intermediate;

import java.util.Scanner;

public class FactorialOfNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter a number to find its factorial:");
		int num = sc. nextInt();
		long factorial =1 ;
		
		for(int i = 1; i<= num; i++) {
			factorial *=i;
		}
		System.out.printf("Factorial of %d = %d\n", num, factorial);
	}

}
