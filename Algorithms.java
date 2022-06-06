// List Algorithms and Search Algorithms

import java.util.*;

public class Algorithms
{
	static int comparisonsCount = 0;
	public static void main(String[]args)
	{
	
	int [] myList = new int [5];
	int [] unsorted = {6, 2, 8,  5, 1, 3};
	int [] sorted = {1, 2, 3, 5, 6,  8};
	
	int next = 0;

	printList(myList,next);
	next = add(myList,next,1);
	next = add(myList,next,2);
	next = add(myList,next,3);
	next = add(myList,next,4);
	next = add(myList,next,5);
	printList(myList,next);
	next = add(myList,next,6);
	next = remove(myList,next,0);
	next = remove(myList,next,0);
	next = remove(myList,next,0);
	next = remove(myList,next,0);
	next = remove(myList,next,0);
	printList(myList,next);
	next = remove(myList,next,0);
	next = add(myList,next,46);
	next = add(myList,next,49);
	next = add(myList,next,10);
	next = add(myList,next,19);
	next = add(myList,next,21);
	printList(myList,next);
	System.out.println ("The linear search for number 10 is at index " + linearSearch(myList,next,10));
	bubbleSort(myList);
	printList(myList,next);
	System.out.println ("The linear sort search of sorted numbers for 10 is at index " + linearSearchSorted(myList,next,10));
	System.out.println ("The binary sort search for number 3 is at index " + binarySearch(unsorted,next,10));
	next = 6;
	printList(unsorted,next);
	System.out.println ("The linear search for number 3 is at index " + linearSearch(unsorted,next,3)+ ". There was " + comparisonsCount + " comparisons done." );
	System.out.println ("The binary sort search for number 3 is at index " + binarySearch(unsorted,next,3) + ". There was " + comparisonsCount + " comparisons done." );
    	System.out.println ("The linear sort search of sorted numbers for 3 is at index " + linearSearchSorted(unsorted,next,3) + ". There was " + comparisonsCount + " comparisons done." );
	printList(sorted,next);
	System.out.println ("The linear search for number 3 is at index " + linearSearch(sorted,next,3)+ ". There was " + comparisonsCount + " comparisons done." );
	System.out.println ("The binary sort search for number 3 is at index " + binarySearch(sorted,next,3) + ". There was " + comparisonsCount + " comparisons done." );
    	System.out.println ("The linear sort search of sorted numbers for 3 is at index " + linearSearchSorted(sorted,next,3) + ". There was " + comparisonsCount + " comparisons done." );
	}	

	public static void printList(int[] myArray, int next)
	{
		System.out.println("List follows: ");
		for (int i=0; i < next; i++)
  		{ 
		System.out.println(i+": "+ myArray[i]);
		}
	}

	public static int add(int[] myArray, int next, int newData)
	{
  		// make sure array not full
		if (next < myArray.length) 
		{	
			myArray[next] = newData;
			next++;
			System.out.println(newData + " added");
  		}
		else
			System.out.println("array full");
  		return next;
	}

	public static int remove(int[] myArray, int next, int pos)
	{
 		 // position valid?
		if (pos >= 0 && pos < next) 
  		{
         		System.out.println(myArray[pos]+ " deleted"); 
    		 	next--; // decrease number in list by 1
				
				for (int i=pos; i<(next); i++) //fill gap
					myArray[i] = myArray[i+1]; 	 
  		}
  		else
   			System.out.println(pos + " not a valid position");
		return next;  // new size of list
	}

	public static int linearSearch(int[] myArray, int next, int searchV)
	{
		comparisonsCount = 0;
		for (int i=0; i < next; i++)
  		{	
		comparisonsCount++;
			if (myArray[i] == searchV)
				return i;	// return the position
  		}
	return -1;	  // this indicates not found
	}
	
	public static int linearSearchSorted(int[] myArray, int next, int searchV)
	{
		comparisonsCount = 0;
		for (int i=0; i<next; ++i)
  		{
		comparisonsCount++;
    			if (myArray[i] == searchV)
				return i;   // search value found
	  		else if (myArray[i] > searchV)
				return -1;  // search value not in list
		}
	return -1;  // search value not in list
	}
	
	public static int binarySearch(int[] myArray, int next, int searchV)
	{
  		int low = 0;
  		int high = next - 1;
  		comparisonsCount = 0;

		while (high >= low)
  		{
		comparisonsCount++;
			int mid = (low + high)/2;
			
			if (searchV < myArray[mid])
			high = mid - 1;
			else if (searchV > myArray[mid])
				low = mid + 1;
			else // found it!  
				return mid;
		}
	return -1;  // search value not in list
	}
	
	public static void bubbleSort (int [] list)
	{
	
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
	}

	public static void swapArrayItems ( int [] list, int pos1, int pos2 )
 	{
        int temp = list[pos1];
        list[pos1] = list[pos2];
        list[pos2] = temp;
	
 	}


} 