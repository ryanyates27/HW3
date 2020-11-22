package HW3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Polynomial 
{
	LinkedList<Term> polynomial;
	
	public Polynomial() 
	{
		polynomial = new LinkedList<Term>();
	}
	
	public Polynomial(LinkedList<Term> anyPoly, Term term) 
	{
		anyPoly.add(term);
	}
	
	public Polynomial(Polynomial polynomial) 
	{
		this.polynomial = polynomial.polynomial;
	}
	
	public void addPolynomial(Polynomial test2) 
	{
		Polynomial polySum = new Polynomial();
		
		ArrayList<Term> removedTerm = new ArrayList<>();
		
		for(int i = 0; i < this.polynomial.size(); i++) 
		{ 
			for(int j = 0; j < polynomial.size(); j++) 
			{
				
				if(this.polynomial.get(i).getExponent() == polynomial.get(j).getExponent()) 
				{
					
					Term sumTerm = new Term(this.polynomial.get(i).getCoefficient() + polynomial.get(j).getCoefficient(),
							this.polynomial.get(i).getExponent());
					
					removedTerm.add(this.polynomial.get(i));
					removedTerm.add(polynomial.get(j));
							
					polySum.polynomial.add(sumTerm);
				} 
			}
			polySum.polynomial.add(this.polynomial.get(i));
		}
		
		polySum.polynomial.addAll(polynomial);
		
		polySum.polynomial.removeAll(removedTerm);
		
		polySum.orderPoly();
		
		System.out.println("Sum of polynomials: " + polySum.toString());
		
	}
	
	public void addTerm(Term addedTerm) 
	{
		
		for(int i = 0; i < polynomial.size(); i++) 
		{
			if(polynomial.get(i).getExponent() == addedTerm.getExponent()) 
			{
				
				addedTerm.setCoefficient(polynomial.get(i).getCoefficient() + addedTerm.getCoefficient()); 
				polynomial.remove(i);
			}
		}
		polynomial.add(addedTerm);
		orderPoly();
	}
	
	public void orderPoly() 
	{
		Term[] terms = new Term[polynomial.size()];

		for(int i = 0; i < polynomial.size(); i++) 
		{
			terms[i] = polynomial.get(i);
		}
		polynomial.clear();
		Arrays.sort(terms, Collections.reverseOrder());
		polynomial.addAll(Arrays.asList(terms));
	}
	
	public void parseTerms(String input) 
	{
		polynomial.clear();
		ArrayList<String> stringTerms = new ArrayList<>(Arrays.asList(input.split(" ")));
		ArrayList<Term> termsToSort = new ArrayList<>();
		Term term;
		
		if(input.equals("x") || input.equals("+x")) 
		{
			term = new Term(1, 1);
			addTerm(term);
		} 
		
		else if(input.equals("-x")) 
		{
			term = new Term(-1, 1);
			addTerm(term);
		} 
		
		else 
		{

			for(int i = 0; i < stringTerms.size(); i++) 
			{
				
				if(stringTerms.contains("+")) 
				{
					stringTerms.remove("+");
					
				} else if(stringTerms.get(i).equals("-")) 
				{
					
					int negativeOp = stringTerms.indexOf("-");
					stringTerms.set(negativeOp + 1, "-" + stringTerms.get(negativeOp + 1));		
					stringTerms.remove(negativeOp);
				}
						
				Term termFromArrayList = new Term(stringTerms.get(i));
				termsToSort.add(termFromArrayList);
			}
		
			Collections.sort(termsToSort, Collections.reverseOrder());
			polynomial.addAll(termsToSort);
		}
	}
	
	public Term remove(int index) 
	{
		return polynomial.remove(index);
	}
	
	public Term getTerm(int index) 
	{
		return polynomial.get(index);
	}
	
	public int getNumTerms() 
	{
		return polynomial.size();
	}
	
	public void clear() 
	{
		this.polynomial.clear();
	}
	
	public String toString() 
	{
		StringBuilder returnString = new StringBuilder();
	
		for(int i = 0; i < this.polynomial.size(); i++ ) 
		{
			
			if(i == 0) 
			{
				returnString.append(polynomial.get(0));
				continue;
			
			} 
			
			else if(this.polynomial.get(i).getCoefficient() < 0) 
			{
				returnString.append(polynomial.get(i));
				
			} 
			
			else if (this.polynomial.get(i).getCoefficient() > 0) 
			{
				returnString.append("+" + polynomial.get(i));
			}
		}
		return returnString.toString(); 
	}

	public void add(Polynomial equation3) {
		// TODO Auto-generated method stub
		
	}

	public void addPolynomial(Term term) {
		// TODO Auto-generated method stub
		
	}
	
}
