// Sorting intergers

import java.util.*;

public class SelectSort
{
	public static void main(String[]args)
	{

	int [] myList = { 10,  8,  6,  11,  7 };
	int comparisonsCount = 0;
	
	System.out.println("Before sort.");	
	printArray (myList);
	System.out.println();

	// For i = n downto 2
	for (int i = myList.length; i >= 2; --i)
	{
		// Find the position of the largest item in the sublist 
        	// of the first i items from the list
	   	int posBig = findPosBig( myList, i ); 
	   	
		// Swap the largest item with the ith item; i.e. item at position i -1
	   	swapArrayItems( myList, i-1, posBig ); 
	}
	
	System.out.println("After sort.");
	printArray (myList);
	System.out.println("Number of times comparison was made was: " + comparisonsCount);

	} 

	public static int findPosBig ( int [] sublist, int numItems )
	{      
	
		// check if biggest by considering other elements
        	int posBiggest = 0;      
        	
		for (int i=1; i < numItems; i++)
        	{
		comparisonsCount ++;
            		if ( sublist[i] > sublist[posBiggest] )
            		{
                		posBiggest = i;
            		}
        	}
        return posBiggest;        
	}
	
	public static void swapArrayItems ( int [] list, int pos1, int pos2 )
 	{
        	int temp = list[pos1];
        	list[pos1] = list[pos2];
        	list[pos2] = temp;
 	}
	
	//method to print all the values in a array 
	public static void printArray (int [] theArray)
    	{
        	System.out.println("The array has the following data:") ;
        	// output the array
        		
		//prints all the values
		for(int i=0; i < theArray.length; i++)
        		{
            		System.out.print(theArray[i] + "  ");
        		}
        	
		System.out.println();        
    	}

} 