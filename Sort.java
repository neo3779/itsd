// Sorting intergers

import java.util.*;

public class Sort
{
	public static void main(String[]args)
	{
	

	
	} 

	 public static int findPosBig ( int [] sublist, int numItems )
	 {      
	
		// check if biggest by considering other elements
        	int posBiggest = 0;      
        	
		for (int i=1; i < numItems; i++)
        	{
            		if ( sublist[i] > sublist[posBiggest] )
            		{
                		posBiggest = i;
            		}
        	}
        return posBiggest;        
	} 

} 