package HW3;

import java.util.Scanner;

public class Menu 
{
	public static void main(String[] args)
	{
		Polynomial equation = new Polynomial();
		Polynomial equation3 = new Polynomial();
		int choice;
		Scanner input = new Scanner(System.in);
		
		do
		{
		System.out.println("1.) Edit the first polynomial");
		System.out.println("2.) Edit the second polynomial");
		System.out.println("3.) Display the result");
		System.out.println("4.) Exit");

		choice = input.nextInt();
		
			switch(choice) 
			{
				case 1:
						int choiceOne;
						
						System.out.println("1.) Build new Poly");
						System.out.println("2.) Clear equation");
						System.out.println("3.) Modify existing Poly");
						choiceOne = input.nextInt();
					
						switch(choiceOne) 
						{
						
							case 1: 
									Polynomial equation1 = new Polynomial();
									System.out.println("First Poly:");
									System.out.println("Highest Degree: ");
									int degree = input.nextInt();
									for(int i = 0; i < degree; i++)
									{
										int coef;
										int expo;
										System.out.println("Coefficient:"); 
										coef = input.nextInt();
										System.out.println("Exponent:"); 
										expo = input.nextInt();
										equation1.addPolynomial(new Term(coef,expo));
									}
									equation = equation1;
									System.out.println(equation1);
									break;
									
							case 2: 
									equation.clear();
									System.out.println("Cleared");
									break;
									
							case 3: 
									int coef;
									int expo;
									System.out.println("Coefficient:"); 
									coef = input.nextInt();
									System.out.println("Exponent:"); 
									expo = input.nextInt();
									equation.addPolynomial(new Term(coef,expo));	
									break;
									
									default: 
									break;
						}
				break;
				
				case 2:
					
					int choiceTwo;
					System.out.println("1.) Build new Poly");
					System.out.println("2.) Clear equation");
					System.out.println("3.) Modify existing Poly");
					choiceTwo = input.nextInt();
					
					switch(choiceTwo)
					{
					
						case 1: 
								Polynomial equation2 = new Polynomial();
								System.out.println("Second Poly:");
								System.out.println("Highest Degree: ");
								int degree = input.nextInt();
								for(int i = 0; i < degree; i++)
								{
									int coef;
									int expo;
									System.out.println("Coefficient:"); 
									coef = input.nextInt();
									System.out.println("Exponent:"); 
									expo = input.nextInt();
									equation2.addPolynomial(new Term(coef,expo));
								}
								equation3 = equation2;
								System.out.println(equation2);
								break;
								
						case 2:
								equation.clear();
								System.out.println("Cleared");
								break;
							
						case 3:  
								int coef;
								int expo;
								System.out.println("Coefficient:"); 
								coef = input.nextInt();
								System.out.println("Exponent:"); 
								expo = input.nextInt();
								equation.addPolynomial(new Term(coef,expo));	
								
								break;
					}
					
				case 3:
					if(choice == 3)
					{
						equation.addPolynomial(equation3);
						System.out.println(equation);
						System.out.println("+");
						System.out.println(equation3);
						System.out.println("is equal to");
						System.out.println(equation.toString());
					}
				case 4:
					System.out.println("exited");
					System.exit(0);
					break;		
		}
		
		}while(choice != 4);
	}
}
