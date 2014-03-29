package project01;

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
		
		System.out.println("please enter a rational number");
		String rational = input.next();
		rationalSplit = rn.parseRational(rational);
		numer = rationalSplit[0];
		denom = rationalSplit[1];
		
		if(denom == 1)
			rn = new RationalNumber(numer);
		else
			rn = new RationalNumber(numer, denom);
			

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
		System.out.println(RationalNumber.rationalAddition(13, 13.4));

		input.close();
	}
}