import java.util.*;

public class ComplexNumberCalculator {
	static Scanner sc;
	static Number input1;
	static Number input2;

	public static void main(String[] args) throws InputMismatchException {
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("Enter in number for the corresponding option for the two inputs");
				System.out.println("1. Fraction");
				System.out.println("2. Complex Number");
				int option = sc.nextInt();
				if(option < 1 || option > 2) {
					System.out.println("Make sure input is between 1 and 2");
					continue;
				}
				if(option == 1) inputFraction();
				else inputComplexNumber();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is an integer");
			}
		}
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("Enter in number for the corresponding option for operation");
				System.out.println("1. Add");
				System.out.println("2. Subtract");
				System.out.println("3. Multiply");
				System.out.println("4. Divide");
				int option = sc.nextInt();
				if(option < 1 || option > 4) {
					System.out.println("Make sure input is between 1 and 4");
					continue;
				}
				if(option == 1) add();
				else if(option == 2) subtract();
				else if(option == 3) multiply();
				else divide();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is an integer");
			}
		}
		sc.close();
		System.out.println("Program ended");
		return;
	}

	public static void inputFraction() throws InputMismatchException {
		int n;
		int d;
		for(int i = 1; i < 3; i++) {
			while(true) {
				sc = new Scanner(System.in);
				try {
					System.out.println("Enter the integer numerator for fraction #" + i);
					n = sc.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Make sure input is an integer");
				}
			}
			while(true) {
				sc = new Scanner(System.in);
				try {
					System.out.println("Enter the integer denominator for fraction #" + i);
					d = sc.nextInt();
					if(d == 0) {
						System.out.println("Make sure input is not 0");
						continue;
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("Make sure input is an integer");
				}
			}
			if(i == 1) {
				input1 = new Fraction(n, d);
			} else {
				input2 = new Fraction(n, d);
			}
		}
	}

	public static void inputComplexNumber() throws InputMismatchException {
		double r;
		double i;
		for(int j = 1; j < 3; j++) {
			while(true) {
				sc = new Scanner(System.in);
				try {
					System.out.println("Enter the real decimal part for complex number #" + j);
					r = sc.nextDouble();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Make sure input is a decimal");
				}
			}
			while(true) {
				sc = new Scanner(System.in);
				try {
					System.out.println("Enter the imaginary decimal part for complex number #" + j);
					i = sc.nextDouble();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Make sure input is a decimal");
				}
			}
			if(j == 1) {
				input1 = new ComplexNumber(r, i);
			} else {
				input2 = new ComplexNumber(r, i);
			}
		}
	}

	public static void add() {
		if(input1 instanceof Fraction) {
			Number f = input1.add(input2);
			printOutFraction(f); 
		} else {
			Number cn = input1.add(input2);
			printOutComplexNumber(cn);
		}
	}

	public static void subtract() {
		if(input1 instanceof Fraction) {
			Number f = input1.subtract(input2);
			printOutFraction(f); 
		} else {
			Number cn = input1.subtract(input2);
			printOutComplexNumber(cn);
		}
	}

	public static void multiply() {
		if(input1 instanceof Fraction) {
			Number f = input1.multiply(input2);
			printOutFraction(f); 
		} else {
			Number cn = input1.multiply(input2);
			printOutComplexNumber(cn);
		}
	}

	public static void divide() {
		if(input1 instanceof Fraction) {
			Number f = input1.divide(input2);
			printOutFraction(f); 
		} else {
			Number cn = input1.divide(input2);
			printOutComplexNumber(cn);
		}
	}

	public static void printOutFraction(Number f) {
		if(((Fraction)f).one) {
			System.out.println("The result is: 1");
		} else if(((Fraction)f).zero) {
			System.out.println("The result is: " + ((Fraction)f).whole);
		} else if(((Fraction)f).wholezero) {
			System.out.println("The result is: 0");
		} else if(((Fraction)f).whole == 0) {
			System.out.println("The result is: " + ((Fraction)f).n + "/" + ((Fraction)f).d);
		} else {
			System.out.println("The result is: " + ((Fraction)f).whole + " " + ((Fraction)f).n + "/" + ((Fraction)f).d);
		} 
	}

	public static void printOutComplexNumber(Number cn) {
		if(((ComplexNumber)cn).r == 0 && ((ComplexNumber)cn).i == 0){
			System.out.println("The result is: 0");
		} else if(((ComplexNumber)cn).r == 0) {
			System.out.println("The result is: " + ((ComplexNumber)cn).i + "i");
		} else if(((ComplexNumber)cn).i == 0) {
			System.out.println("The result is: " + ((ComplexNumber)cn).r);
		} else {
			if(((ComplexNumber)cn).i > 0) {
				System.out.println("The result is: " + ((ComplexNumber)cn).r + "+" + ((ComplexNumber)cn).i + "i");
			} else {
				System.out.println("The result is: " + ((ComplexNumber)cn).r + ((ComplexNumber)cn).i + "i");
			}
		}
	}
}
