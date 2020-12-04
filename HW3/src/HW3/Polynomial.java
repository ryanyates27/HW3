package HW3;

import java.util.Collections;
import java.util.LinkedList;

public class Polynomial 
{
	LinkedList<Term> poly;
	Term term = new Term();
	
	
	public Polynomial()
	{
		poly = new LinkedList<Term>();
	}
	
	public Polynomial(LinkedList aPoly, Term term)
	{
		aPoly.add(term);
	}
	
	public Polynomial(Polynomial polyn)
	{
//		poly = new LinkedList<Term>();
//		
//		if(polyn.getPoly() != null && polyn.getPoly().size() != 0)
//		{
//		for(Term t: polyn.getPoly())
//		{
//			this.poly.add(t);
//		}
//		}
		
		poly = polyn.getPoly();
	}
	
	public boolean addTerm(Term t)
	{
		boolean testAdd = false;
		for(Term term1: poly)
		{
			if(term1.getExponent() == t.getExponent())
			{
				testAdd = true;
				term1.setExponent(term1.getExponent() + t.getExponent());
			}
		}
		
		if(testAdd != true)
		{
			poly.add(t);
		}
		Collections.sort(poly); //uses compareTo method
		
		return true;
	}
	
	public LinkedList<Term> getPoly()
	{
		return poly;
	}

	public Term getTerm(int i) 
	{
		Term returnedTerm = poly.get(i);
		return returnedTerm;
		
	}

	public int getNumTerms() 
	{
		return poly.size();
	}

	public void addPolynomial(Polynomial test2) 
	{
		for(Term t: test2.getPoly())
		{
			this.addTerm(t);
		}
		
	}

	public void clear() 
	{
		poly.clear();
	}
	
	public String toString()
	{
		if(poly.size() == 0)
		{
			return "0";
		}
		String str = "";
		for(Term t : poly)
		{
			str += t.toString();
			if(poly.indexOf(t) == 0)
			{
				str = str.substring(1);
			}
		}
		return str;
	}
	
}
