// Sorting intergers

import java.util.*;

public class BubbleSort
{
	public static void main(String[]args)
	{
	
	int [] list = { 10,  8,  6,  11,  7 };

	System.out.println("Before sort.");	
	printArray (list);
	System.out.println();

	int numItems = list.length;
      	boolean notSorted = true;
       
	while ( notSorted && (numItems >= 2) )
       	{
		notSorted = false;
           		for (int i = 0; i < numItems - 1; ++i)
           		{
	             		if ( list[i] > list[i+1] )
                 		{
	                  		swapArrayItems( list, i, i+1 );
		          		// a swap occurred so possibly not sorted
		          	notSorted = true;
                 		}
 	       		}
            		--numItems;
  	}

	System.out.println("After sort.");
	printArray (list);

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