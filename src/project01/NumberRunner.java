import java.util.*;

public class NumberRunner 
{
	public static void main(String[]args)
	{
		Scanner input = new Scanner(System.in);
		int numer;
		int denom;
		int[] rationalSplit = new int[2];
		RationalNumber rn = new RationalNumber();
		RationalNumber rn2 = new RationalNumber();

		System.out.println("please enter two rational numbers");
		String rational = input.nextLine();
		String rational2 = input.nextLine();
		
		rationalSplit = rn.parseRational(rational);
		numer = rationalSplit[0];
		denom = rationalSplit[1];
		rn = new RationalNumber(numer, denom);
		
		rationalSplit = rn2.parseRational(rational2);
		numer = rationalSplit[0];
		denom = rationalSplit[1];
		rn2 = new RationalNumber(numer,denom);

		if (denom == 0)
		{
			System.out.println("Cannot divide by zero, please enter a new value for the denominator");
			denom = input.nextInt();

			while(denom == 0)
			{
				System.out.println("Cannot divide by zero, please enter a new value for the denominator");
				denom = input.nextInt();
			}
			rn.setDenominator(denom);
		}	

		System.out.println(rn);
		System.out.println(RationalNumber.rationalAddition(rational, rational2));
		System.out.println(rn.rationalAddition(rn2));
		System.out.println(rn.rationalSubtraction(rn2));
		System.out.println(rn.rationalMultiplication(rn2));
		System.out.println(rn.rationalDivision(rn2));
		System.out.println(rn.equals(rn2));
		System.out.println(rn.compareTo(rn2));

		input.close();
	}
}
