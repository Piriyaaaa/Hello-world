package Intermediate;

public class AddComplexNumbers {
	double real;
	double imag;
	
	
	public AddComplexNumbers(double real, double imag) {
		this.real = real;
		this.imag = imag;
		
	}
	public static AddComplexNumbers add(AddComplexNumbers n1, AddComplexNumbers n2) {
		return new AddComplexNumbers(n1.real + n2.real, n1.imag + n2.imag);
		
	}
	public static void main(String[] args) {
		AddComplexNumbers n1 = new AddComplexNumbers(2.3, 4.5);
		AddComplexNumbers n2 = new AddComplexNumbers(3.4, 5.0);
		AddComplexNumbers result = add(n1, n2);
		System.out.printf("sum = %.1f + %.1fi", result.real, result.imag);
	}

}
