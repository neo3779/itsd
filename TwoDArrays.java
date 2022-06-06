//Progam for trying 2d arrays

import java.util.*;

public class TwoDArrays
{
	public static void main(String[]args)
	{
		
	String[][] foodArray = {
	{"pears", "apples", "plums"},
  	{ "fish", "beef", "chicken", "lamb"},
  	{ "milk", "cheese"},
  	{ "peas", "celery", "onions", "swede", "carrots"},
  	{ "bread", "cereal"}
	};

	int[][] numArray = {
	{437, 6, 25000},
  	{525, 4, 60000},
  	{214, 3, 40000},
  	{639, 4, 35000},
  	{309, 5, 15000}
	};
	
	printArray(foodArray);
	System.out.println(" ");
	printRowInfo(foodArray[4]);
	System.out.println(" ");
	System.out.println(" ");
	printArray(numArray);
	System.out.println("");
	printRowInfo(numArray [3]);
	System.out.println("");
	System.out.println("");
	printColInfo(numArray,2);

	}

	//method to print all the values in a array 
	public static void printArray (String [] [] my2DArray)
    	{
		for (int row = 0; row < my2DArray.length; ++row)
		{
  			for (int col = 0; col<my2DArray[row].length; ++col)
  			{
     				System.out.printf("%8s",my2DArray[row][col]);
  			}
  		System.out.println();
		}
	}
       
	public static void printRowInfo(String[] theArray)
	{
		for (int i = 0; i < theArray.length; ++i)
   		{
  			System.out.printf("%8s", theArray[i]);
		}
	
    	
	}
	
	//method to print all the values in a array 
	public static void printArray (int [] [] my2DArray)
    	{
		for (int row = 0; row < my2DArray.length; ++row)
		{
  			for (int col = 0; col<my2DArray[row].length; ++col)
  			{
     				System.out.printf("%8s",my2DArray[row][col]);
  			}
  		System.out.println();
		}
	}
       
	public static void printRowInfo(int[] theArray)
	{
		for (int i = 0; i < theArray.length; ++i)
   		{
  			System.out.printf("%8d", theArray[i]);
		}
	
    	
	}
	
	public static void printColInfo(int[][] the2DArray, int col)
	{ 
  		for (int row = 0;row < the2DArray.length;++row)
  		{
    			System.out.printf("%8d", the2DArray[row][col]);
			System.out.println("");
  		}
	}
	
}
