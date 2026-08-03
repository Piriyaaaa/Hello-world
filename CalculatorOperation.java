package Intermediate;

public class CalculatorOperation {
	public double add(double a, double b) {
		return a+b;
	}
	public double subtract(double a, double b) {
		return a-b;
	}
	public double multiply(double a, double b) {
		return a*b;
	}
	public double divide(double a, double b) {
		if (b == 0) {
		
		throw new ArithmeticException("Cannot devide by zero");
	}
	return a/b;
	}
	public static void main(String[] args) {
		CalculatorOperation calculator = new CalculatorOperation();
		
		double num1 = 10;
		double num2=5;
		
		System.out.println("addition:" + calculator.add(num1, num2));
		System.out.println("substraction:" + calculator.subtract(num1, num2));
		System.out.println("multiplication:" + calculator.multiply(num1, num2));
		System.out.println("division" + calculator.divide(num1, num2));
	}
	

}
	
