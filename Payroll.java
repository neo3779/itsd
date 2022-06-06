//Progam for trying 2d arrays

import java.util.*;

public class Payroll
{
	public static void main(String[]args)
	{
	
	String [] headingArray 	= {"Name", "Employee number", "Department", "Salary"};
	String [] namesArray = {"Pete","Cathy","Graham","Claude","Dave"};
	int[][] numArray = {
	{437, 6, 25000},
  	{525, 4, 60000},
  	{214, 3, 40000},
  	{639, 4, 35000},
  	{309, 5, 15000}
	};
	
	printRowInfo(headingArray);
	System.out.println();
	printArray (numArray,namesArray);
	System.out.println();
	bigArray (numArray,namesArray,0);
	
	

	}

	public static void printRowInfo(String[] theArray)
	{
		for (int i = 0; i < theArray.length; ++i)
   		{
  			System.out.printf("%-16s", theArray[i]);
		}
	
    	
	}
       
	//method to print all the values in a array 
	public static void printArray (int [] [] my2DArray, String [] myarray)
    	{

		for (int row = 0; row < my2DArray.length; ++row)
		{
			System.out.printf("%-15s %-15d %-15d %-15d", myarray[row], my2DArray[row][0], my2DArray[row][1], my2DArray[row][2]);
		System.out.println();
		}
		
	
	}

	public static void bigArray (int [] [] my2DArray, String [] myarray,int col)
	{
	
		int big = my2DArray[0][col];
		int index = 0;		

		for (int row = 0;row < my2DArray.length;++row)
  		{
		
				//check the value of the biggest against others
				if(my2DArray[row][col] > big)
				{
					big = my2DArray[row] [col];
					index = row;
				}
		}
		System.out.printf("%-15s %-15d %-15d %-15d",myarray[index], my2DArray[index][0], my2DArray[index][1], my2DArray[index][2]);
	}

	
}
