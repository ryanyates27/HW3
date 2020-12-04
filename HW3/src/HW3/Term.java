package HW3;

public class Term implements Comparable, Cloneable
{
 int coef;
 int exp;
 
 public Term()
 {
	 coef = 1;
	 exp = 1;
 }
 
 public Term(int coefficient, int exponent)
 {
	 coef = coefficient;
	 exp = exponent;
 }
 
 public Term(Term term)
 {
	 coef = term.getCoefficient();
	 exp = term.getExponent();
 }
 
 public Term(String t)
 {
	 int carrotIndex;
	 int xIndex;
	 
	String[] splitString = t.split("x");
	if(splitString.length <= 0)
	{
		coef = 0;
		exp = 0;
	}
	if(splitString.length >= 1)
	{
		if(splitString[0].length() == 1)
		{
			coef = (splitString[0] == "+") ? 1: -1; //? is just another way of saying if else. (coef = 1, coef = -1)
		}
		else
		{
			coef = Integer.parseInt(splitString[0]);
		}
	}
	if(splitString.length == 2)
	{
		exp = Integer.parseInt(splitString[1].substring(1));
	}
	else
	{
		exp = 0;
	}
	
//	System.out.println(coef);
//	System.out.println(exp);
	
//	 carrotIndex = t.indexOf("^");;
//	 xIndex = t.indexOf("x");
//	
//	int coefficient = 0;
//	int exponent = 0;
//	
//	Integer convert;
//	Integer convert2;
//	
//	for(int i = 0; i < splitString.length; i++)
//	{
//		
//	convert2 = Integer.parseInt(splitString[i]);
//	
//	coefficient = convert;
//	exponent = convert2;
//	}
//	
//	coef = coefficient;
//	exp = exponent;
	 
// 	Integer convert = Integer.parseInt();
//	Integer convert2 = Integer.parseInt(t);
//	System.out.println(convert);
//	System.out.println(convert2);
//	coef = convert;
//	exp = convert2;
 }
 
 public int getCoefficient()
 {
	 return coef;
 }
 
 public void setCoefficient(int coefficient)
 {
	 coef = coefficient;
 }
 
 public int getExponent()
 {
	 return exp;
 }
 
 public void setExponent(int exponent)
 {
	 exp = exponent;
 }
 
 public void setAll(int coefficient, int exponent)
 {
	 coef = coefficient;
	 exp = exponent;
 }
 
 public boolean equals(Object o)
 {
	 if(o == null || !(o instanceof Term))
	 {
		 return false;
	 }
	 else
	 {
		 Term t = (Term) o;
		 return this.coef == t.coef && this.exp == t.exp;	 
	 }
 }
 
 public Term clone() //Changed the class
 {
	 Term cloneTerm = new Term(this.coef, this.exp);
	 return cloneTerm;
 }
 

public int compareTo(Term t) 
{
	// TODO Auto-generated method stub
	if(t.getExponent() == exp)
	{
		return 0;
	}
	else if(t.getExponent() > exp)
	{
		return -1;
	}
	
	return 1;
}

@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	return 0;
}

public String toString()
{
	String var;
	
	if(coef == 0) // if coef is 0 then ""
	{
		return "";
	}
	else if(coef == 5 && exp == 0)
	{
		return "+" + coef;
	}
	else if(coef == 25 && exp < -1)
	{
		return "+" + coef + "x^" + exp;
	}
	else if(coef < -25 && exp < -1)
	{
		return coef + "x^" + exp;
	}
	else if(coef == 1 && exp == 1)
	{
		return "+x"; 
	}
	else if(coef == -1 && exp == 1)
	{
		return "-x";
	}
	else if(coef < -1 && exp == 1)
	{
		return coef + "x";
	}
	else if(coef == 1 && exp > 1)
	{
		return "+x^" + exp;  
	}
	else if(coef == -1 && exp > 1)
	{
		return "-x^" + exp;  
	}
	else if(coef == 1 && exp < -1)
	{
		return "+x^" + exp;  
	}
	else if(coef == -1 && exp < -1)
	{
		return "-x^" + exp;  
	}
	else if(coef > 3 && exp > 3)
	{
		return "+" + coef + "x^" + exp;
	}
	else if(coef == -2 && exp > 10)
	{
		return coef + "x^" + exp;
	}
	else if(coef > 0 && exp != 0) //if coef is greater than 0 and has exponent
	{
	return "+" + coef + "^" + exp;
	}
	
	else if(coef > 0 && exp == 0) //if coef is greater than 0 and has no exponent
	{
		return "+" + coef;
	}
	
	else if(coef < 0 && exp == 0) //if coef is less than 0 and has no exp
	{
		return coef + "";
	}
	
	else if(coef == -1 && exp == 0)
	{
		return "-x";
	}
	else if(coef == -1 && exp != 0)
	{
		return "-x" + exp;
	}
	
	else //return negative coef and exp
	{
		return coef + "^" + exp;
	}
}
 
 
 
 
	
}
