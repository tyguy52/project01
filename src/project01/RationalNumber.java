public class RationalNumber
{
	private int numerator;
	private int denominator;

	public RationalNumber(int numerator, int denominator)
	{
		this.numerator = numerator;

		try
		{
			if(denominator == 0)
				throw new Exception();
			this.denominator = denominator;
		}
		catch(Exception e)
		{
			System.err.println("Exception: Cannot divide by zero");
		}
	}

	public RationalNumber(int i)
	{
		this.numerator = i;
		this.denominator = 1;
	}

	public RationalNumber()
	{

	}

	public int[] parseRational(String s)
	{
		if(s.indexOf("/") == -1)
			s += "/1";
		int[] rational = new int[2];
		String[] rationalParse =s.split("/");

		numerator = Integer.parseInt(rationalParse[0]);
		denominator = Integer.parseInt(rationalParse[1]);

		rational[0] = numerator;
		rational[1] = denominator;

		return rational;

	}

	public int getNumerator()
	{
		return numerator;
	}

	public int getDenominator()
	{
		return denominator;
	}

	public void setNumeratior(int numerator)
	{
		this.numerator = numerator;
	}

	public void setDenominator(int denominator)
	{
		try
		{
			if(denominator == 0)
				throw new Exception();
			this.denominator = denominator;
		}
		catch(Exception e)
		{
			System.err.println("Exception: Cannot divide by zero");
		}
	}

	public String toString()
	{	
		int GCD = GCD(numerator, denominator);
		String rationalString = "";
		if(numerator == 0)
			rationalString = Integer.toString(numerator);
		else if(numerator%denominator == 0)
			rationalString = Integer.toString(numerator/denominator);
		else
		{
		rationalString = (numerator/GCD) + "/" + (denominator/GCD);
		if(denominator < 0)
			rationalString = (numerator*-1) + "/" + (denominator*-1);
		}
		return rationalString;
	}

	public static int GCD(int l, int n)
	{
		return n == 0 ? l : GCD(n, l%n);
	}
	
	public boolean equals(RationalNumber rn)
	{
		if(numerator/denominator == rn.numerator/rn.denominator)
			return true;
		else
			return false;
	}
	
	public int compareTo(RationalNumber rn)
	{
		int value = 0;
		if(numerator/denominator > rn.numerator/denominator)
			value = 1;
		else if(numerator/denominator == rn.numerator/rn.denominator)
			value = 0;
		else if(numerator/denominator < rn.numerator/rn.denominator)
			value = -1;
		
		return value;
	}
	
	public static RationalNumber rationalAddition(String s1, String s2)
	{
		RationalNumber rn = new RationalNumber();
		int[] rational1 = new int[2];
		int[] rational2 = new int[2];
		
		rational1 = rn.parseRational(s1);
		rational2 = rn.parseRational(s2);
		
		int numer1 = rational1[0];
		int numer2 = rational2[0];
		int denom1 = rational1[1];
		int denom2 = rational2[1];
		
		if(denom1 == denom2)
			rn = new RationalNumber((numer1+numer2),denom1);
		else
		{
			int numer3 = numer1*denom2;
			int numer4 = numer2*denom1;
			int denom3 = denom1*denom2;
			
			rn = new RationalNumber((numer3+numer4), denom3);
		}
		
		return rn;
	}

	public RationalNumber rationalAddition(RationalNumber n)
	{
		RationalNumber rn = new RationalNumber();
		
		if(n.denominator == denominator)
			rn = new RationalNumber((n.numerator+numerator), denominator);
		else
		{
			int denom = n.denominator*denominator;
			int numer1 = n.numerator*denominator;
			int numer2 = numerator*n.denominator;
			
			rn = new RationalNumber((numer1+numer2), denom);
		}
		return rn;
				
	}
	
	public static RationalNumber rationalSubtraction(String s1, String s2)
	{
		RationalNumber rn = new RationalNumber();
		int[] rational1 = new int[2];
		int[] rational2 = new int[2];
		
		rational1 = rn.parseRational(s1);
		rational2 = rn.parseRational(s2);
		
		int numer1 = rational1[0];
		int numer2 = rational2[0];
		int denom1 = rational1[1];
		int denom2 = rational2[1];
		
		if(denom1 == denom2)
			rn = new RationalNumber((numer1-numer2),denom1);
		else
		{
			int numer3 = numer1*denom2;
			int numer4 = numer2*denom1;
			int denom3 = denom1*denom2;
			
			rn = new RationalNumber((numer3-numer4), denom3);
		}	
		return rn;
	}

	public RationalNumber rationalSubtraction(RationalNumber n)
	{
		RationalNumber rn = new RationalNumber();
		
		if(n.denominator == denominator)
			rn = new RationalNumber((n.numerator-numerator), denominator);
		else
		{
			int denom = n.denominator*denominator;
			int numer1 = n.numerator*denominator;
			int numer2 = numerator*n.denominator;
			
			rn = new RationalNumber((numer1-numer2), denom);
		}
		return rn;
	}
	
	public static RationalNumber rationalMultiplication(String s1, String s2)
	{
		RationalNumber rn = new RationalNumber();
		int[] rational1 = new int[2];
		int[] rational2 = new int[2];
		
		rational1 = rn.parseRational(s1);
		rational2 = rn.parseRational(s2);
		
		int numer1 = rational1[0];
		int numer2 = rational2[0];
		int denom1 = rational1[1];
		int denom2 = rational2[1];

		rn = new RationalNumber((numer1*numer2),(denom1*denom2));
		
		return rn;
	}

	public RationalNumber rationalMultiplication(RationalNumber n)
	{
		RationalNumber rn = new RationalNumber();
		
		rn = new RationalNumber(n.numerator*numerator, n.denominator*denominator);
		return rn;
	}
	
	
	public static RationalNumber rationalDivision(String s1, String s2)
	{
		RationalNumber rn = new RationalNumber();
		int[] rational1 = new int[2];
		int[] rational2 = new int[2];
		
		rational1 = rn.parseRational(s1);
		rational2 = rn.parseRational(s2);
		
		int numer1 = rational1[0];
		int numer2 = rational2[0];
		int denom1 = rational1[1];
		int denom2 = rational2[1];
		
		rn = new RationalNumber((numer1*denom2), (numer2*denom1));
			
		return rn;
	}

	public RationalNumber rationalDivision(RationalNumber n)
	{
		RationalNumber rn = new RationalNumber();
		
		rn = new RationalNumber((n.numerator*denominator), n.denominator*numerator);
		
		return rn;
	}
	
}
