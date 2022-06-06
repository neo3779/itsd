// Sorting intergers

import java.util.*;

public class BubbleSortFour
{
	static int comparisonsCount = 0;
	static int swapCount = 0;

	public static void main(String[]args)
	{
	
	int [] list = { 10,  8,  6,  11,  7 };
	int [] list2 = { 1,  2,  3,  4,  5,  6,  7,  8 };
	int [] list3 = { 8,  7,  6,  5,  4,  3,  2,  1 };
	int [] list4 = { 6,  2,  7,  3,  1,  8,  5,  4 };	

	System.out.println("Before sort.");	
	printArray (list);
	bubbleSort (list);
	System.out.println("After sort.");
	printArray (list);
	System.out.println("Number of times comparison was made was: " + comparisonsCount);
	System.out.println("The number of time a swap occured was: " + swapCount);

	System.out.println("Before sort.");	
	printArray (list2);
	bubbleSort (list2);
	System.out.println("After sort.");
	printArray (list2);
	System.out.println("Number of times comparison was made was: " + comparisonsCount);
	System.out.println("The number of time a swap occured was: " + swapCount);

	System.out.println("Before sort.");	
	printArray (list3);
	bubbleSort (list3);
	System.out.println("After sort.");
	printArray (list3);
	System.out.println("Number of times comparison was made was: " + comparisonsCount);
	System.out.println("The number of time a swap occured was: " + swapCount);

	System.out.println("Before sort.");	
	printArray (list4);
	bubbleSort (list4);
	System.out.println("After sort.");
	printArray (list4);
	System.out.println("Number of times comparison was made was: " + comparisonsCount);
	System.out.println("The number of time a swap occured was: " + swapCount);

	}
	
	public static void bubbleSort (int [] list)
	{
	swapCount = 0;
	comparisonsCount = 0;
	int numItems = list.length;
      	boolean notSorted = true;
       
		while ( notSorted && (numItems >= 2) )
       		{
			notSorted = false;
           			for (int i = 0; i < numItems - 1; ++i)
           			{
				comparisonsCount++;
	             			if ( list[i] > list[i+1] )
                 			{
	                  			swapArrayItems( list, i, i+1 );
		          			// a swap occurred so possibly not sorted
		          			notSorted = true;
                 			}
 	       			}
            			--numItems;
  		}
	}

	public static void swapArrayItems ( int [] list, int pos1, int pos2 )
 	{
        int temp = list[pos1];
        list[pos1] = list[pos2];
        list[pos2] = temp;
	swapCount++;
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