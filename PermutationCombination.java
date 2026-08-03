package Intermediate;
import java.util.Scanner;
public class PermutationCombination {

	public static int fact(int num) {
		int fact =1, i;
		for(i =1; i<= num; i++) {
		fact = fact*i;
	}
	    return fact;
	}
    public static void main(String args[]) {
    	int n, r;
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Enter a value of n :");
    	n =scanner.nextInt();
    	System.out.print("Enter a value of r: ");
    	r= scanner.nextInt();
    	
    	System.out.println("NCR is" + (fact(n)/(fact(n-r)*fact(r))));
    	System.out.println("NCR is" + (fact(n)/(fact(n-r))));
    	
    	
    }
}

