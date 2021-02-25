
public class Fraction implements Number {
	int n;
	int d;
	int whole = 0;
	boolean one = false;
	boolean zero = false;
	boolean wholezero = false;
	boolean negative = false;

	Fraction(int n, int d){
		this.n = n;
		this.d = d;
	}

	@Override
	public Number add(Number num) {
		int n2;
		int d2;
		int tempD1 = d;
		n = n * ((Fraction)num).d;
		d = d * ((Fraction)num).d;
		((Fraction)num).n = ((Fraction)num).n * tempD1;
		((Fraction)num).d = ((Fraction)num).d * tempD1;
		n2 = n + ((Fraction)num).n;
		d2 = d;
		Fraction f = new Fraction(n2, d2);
		f.setWhole();
		f.simplify();
		if(f.whole == 0 && f.negative) {
			f.n = -f.n;
		}
		return f;
	}

	@Override
	public Number subtract(Number num) {
		int n2;
		int d2;
		int tempD1 = d;
		n = n * ((Fraction)num).d;
		d = d * ((Fraction)num).d;
		((Fraction)num).n = ((Fraction)num).n * tempD1;
		((Fraction)num).d = ((Fraction)num).d * tempD1;
		n2 = n - ((Fraction)num).n;
		d2 = d;
		Fraction f = new Fraction(n2, d2);
		f.setWhole();
		f.simplify();
		if(f.whole == 0 && f.negative) {
			f.n = -f.n;
		}
		return f;
	}

	@Override
	public Number multiply(Number num) {
		int n2;
		int d2;
		n2 = n * ((Fraction)num).n;
		d2 = d * ((Fraction)num).d;
		Fraction f = new Fraction(n2, d2);
		f.setWhole();
		f.simplify();
		if(f.whole == 0 && f.negative) {
			f.n = -f.n;
		}
		return f;
	}

	@Override
	public Number divide(Number num) {
		int n2;
		int d2;
		n2 = n * ((Fraction)num).d;
		d2 = d * ((Fraction)num).n;
		Fraction f = new Fraction(n2, d2);
		f.setWhole();
		f.simplify();
		if(f.whole == 0 && f.negative) {
			f.n = -f.n;
		}
		return f;
	}

	void setWhole() {
		int temp = n * d;
		if(temp < 0) {
			negative = true;
		}
		if(n < 0) n = -n;
		if(d < 0) d = -d;
		if(n > d) {
			whole = n / d;
			n = n - whole * d;
		}
		if(negative) {
			whole = -whole;
		}
	}

	void simplify() {
		int gcf = n;
		while(gcf > 1) {
			if(n % gcf == 0 && d % gcf == 0) {
				n = n / gcf;
				d = d / gcf;
				break;
			} else {
				gcf = gcf - 1;
			}
		}
		if(n == 1 && d == 1) {
			one = true;
		} else if(whole == 0 && n == 0) {
			wholezero = true;
		} else if(n == 0) {
			zero = true;
		}
	}
}
