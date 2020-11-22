package HW3;

public class Term implements Comparable<Term>, Cloneable {
	
	private int coefficient;
	private int exponent;
	public Object polynomial;
	
	public Term() 
	{
		this.coefficient = 0;
		this.exponent = 0;
	}
	
	public Term(int coeff, int exp) 
	{
		this.coefficient = coeff;
		this.exponent = exp;
	}
	
	public Term(String stringTerm) 
	{
		
		if(stringTerm.equals("x") || stringTerm.equals("+x")) 
		{
			this.coefficient = 1;
			this.exponent = 1;
		} 
		
		else if(stringTerm.equals("-x")) 
		{
			this.coefficient = -1;
			this.exponent = 1;
		} 
		
		else if(stringTerm.contains("x") && !stringTerm.contains("x^"))
		{
				String coef = stringTerm.replaceAll("[x]", "");
				this.coefficient = Integer.parseInt(coef);
				this.exponent = 1;
		} 
		
		else if (stringTerm.contains("x^")) 
		{
				String[] inputString = stringTerm.split("\\^");
				String coef = inputString[0];
			
				if(coef.equals("x")) 
				{
					this.coefficient = 1;
				} 
				
				else 
				{
					this.coefficient = Integer.parseInt(coef.replaceAll("[x]", ""));
				}
			
				this.exponent = Integer.parseInt(inputString[1]);
		} 
		
		else 
		{
				this.coefficient = Integer.parseInt(stringTerm);
		}
	}
	
	
	public Term(Term term) 
	{
		this.coefficient = term.getCoefficient();
		this.exponent = term.getExponent();
	}
	
	
	public Term plus(Term other) 
	{
		Term sumTerm = new Term();
		
		if(other.getExponent() == this.exponent) 
		{
			sumTerm.setCoefficient(other.getCoefficient() + this.coefficient);
			sumTerm.setExponent(this.exponent);
		} 
		
		else 
		{
			System.out.println("Cannot add Terms with different exponents");
		}
		
		return sumTerm;
	}
	
	public Term sumOf(Term A, Term B) 
	{
		Term sumTerm = new Term();
		
		if(A.getExponent() == B.getExponent()) 
		{
			sumTerm.setCoefficient(A.getCoefficient() + B.getCoefficient());
			sumTerm.setExponent(A.getExponent());
		} 
		
		else 
		{
			System.out.println("Cannot add Terms with different exponents");
		}
		
		return sumTerm;
	}
	
	public int getCoefficient() 
	{
		return coefficient;
	}
	
	public void setCoefficient(int coefficient) 
	{
		this.coefficient = coefficient;
	}
	
	public int getExponent() 
	{
		return exponent;
	}
	
	public void setExponent(int exponent) 
	{
		this.exponent = exponent;
	}
	
	public void setAll(int coeff, int exp) 
	{
		this.coefficient = coeff;
		this.exponent = exp;
	}
	
	
	@Override
	public int compareTo(Term term) 
	{
		
		int compareResult;
		
		if(this.exponent < term.getExponent()) 
		{
			compareResult = -1;
		} 
		
		else if (this.exponent > term.getExponent()) 
		{
			compareResult = 1;
		} 
		
		else 
		{
			compareResult = 0;
		}
		
		return compareResult;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) 
        {
            return false;
        }
        if (obj.getClass() != this.getClass()) 
        {
            return false;
        }
        
        final Term that = (Term) obj;
        
        if (this.exponent != that.getExponent()) 
        {
            return false;
        }
        
        if (this.coefficient != that.getCoefficient()) 
        {
            return false;
        }
        return true;
    }
    
	@Override 
	protected Object clone() throws CloneNotSupportedException 
	{
	    return super.clone();
	}
	
	@Override
	public String toString() 
	{
		
		String result;
		if(this.coefficient == 0) 
		{
			result = "";	
		} 
		
		else if(this.exponent == 1 && this.coefficient == 1) 
		{
			result = "x";		
		} 
		
		else if(this.exponent == 1 && this.coefficient == -1) 
		{
			result = "-" + "x";
		} 
		
		else if (this.exponent == 0 && this.coefficient > 0) 
		{
			result = this.coefficient + "";
		} 
		
		else if (this.exponent == 0 && this.coefficient < 0) 
		{
			result = this.coefficient + "";	
		} 
		
		else if(this.exponent == 1 && this.coefficient > 0) 
		{
			result = this.coefficient + "x";
		} 
		
		else if(this.exponent == 1 && this.coefficient < 0) 
		{
			result = this.coefficient + "x";		
		} 
		
		else 
		{
			result = this.coefficient + "x^" + this.exponent;
		}
		
		return result;
	}
	

}