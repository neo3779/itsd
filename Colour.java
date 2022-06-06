// Finding fav colour

import java.util.*;

public class Colour
{
	public static void main(String[]args)
	{
	
	//Initialize variables
	String [] colours = {"Red", "Blue", "Green", "Yellow", "Papaya Whip"};
	int [] coloursCount = new int [5];
	int input = 0, count = 0, favouriteColour = 0, big = 0;

	//Build an instance of Scanner, that is an object
 	
	Scanner kybd = new Scanner(System.in);
	

	//called method to show list of colours
	selection(colours);	
	
	//Request a valid selection from the list
	do
	{
	System.out.println("Please enter your choice [1-5]:");
	input = kybd.nextInt();
	}while((input <0) || (input >5));

	// loop to keep asking unit the input is zero
	while(input != 0) 
	{
	
	//increase counters for selected colour and overall counter
	selection(colours);	
	coloursCount [input - 1]++;
	count++;

		//Request a valid selection from the list
		do
		{
		System.out.println("Please enter your choice [1-5]:");
		input = kybd.nextInt();
		}while((input <0) || (input >5));
	}
	
	// loop to find the colour that has been selected the most
	for (int i = 0; i < coloursCount.length; i++)
	{
		
		//check the value of the biggest against others
		if(coloursCount[i] > big)
		{
		big = coloursCount[i];
		favouriteColour = i;
		}
	}
	

	//Print outs the result.
	System.out.println("The favourite colour was " + colours[favouriteColour] + " out of " + (count) + " people.");

	}
	
	// method to print the list for the selection.
	public static void selection(String colours [] )
	{
	System.out.println("Which is your favourite colour?");
	System.out.println("1. " + colours[0]);
	System.out.println("2. " + colours[1]);
	System.out.println("3. " + colours[2]);
	System.out.println("4. " + colours[3]);
	System.out.println("5. " + colours[4]);
	System.out.println("0. To Exit");
	
	} 
} 