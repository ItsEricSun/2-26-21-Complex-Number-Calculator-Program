
public class ComplexNumber implements Number {
	double r;
	double i;

	ComplexNumber(double r, double i){
		this.r = r;
		this.i = i;
	}

	@Override
	public Number add(Number num) {
		double r2;
		double i2;
		r2 = r + ((ComplexNumber)num).r;
		i2 = i + ((ComplexNumber)num).i;
		ComplexNumber cn = new ComplexNumber(r2, i2);
		return cn;
	}

	@Override
	public Number subtract(Number num) {
		double r2;
		double i2;
		r2 = r - ((ComplexNumber)num).r;
		i2 = i - ((ComplexNumber)num).i;
		ComplexNumber cn = new ComplexNumber(r2, i2);
		return cn;
	}

	@Override
	public Number multiply(Number num) {
		double r2;
		double i2;
		r2 = r * ((ComplexNumber)num).r - i * ((ComplexNumber)num).i;
		i2 = r * ((ComplexNumber)num).i + ((ComplexNumber)num).r * i;
		ComplexNumber cn = new ComplexNumber(r2, i2);
		return cn;
	}

	@Override
	public Number divide(Number num) {
		double r2;
		double i2;
		double divide = ((ComplexNumber)num).r * ((ComplexNumber)num).r + ((ComplexNumber)num).i * ((ComplexNumber)num).i;
		ComplexNumber conjugate = new ComplexNumber(((ComplexNumber)num).r, -((ComplexNumber)num).i);
		Number numerator = this.multiply(conjugate);
		r2 = ((ComplexNumber)numerator).r / divide;
		i2 = ((ComplexNumber)numerator).i / divide;
		ComplexNumber cn = new ComplexNumber(r2, i2);
		return cn;
	}
}
