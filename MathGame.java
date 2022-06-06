// 

import java.util.*;

public class MathGame
{
	public static void main(String[]args)
	{
	
	int attempts = 0;
	double numCorrect = 0;
	double ans = 0;
	String [] topTen = new String [5];
	int [] scores = new int [5];
	int stringNext = 0;
	int intNext = 0;
	String name;
	int option = 0;
	
	// build an instance of Scanner, that is an object
 	
	Scanner kybd = new Scanner(System.in);
	System.out.println("Please enter your name: ");
	name = kybd.nextLine();
	optionMenu( );
	System.out.println("Please pick an option: ");
	option = kybd.nextInt();
	
		while (option != 5)
        	{
			
			//Switch statments to allow selection of message		

			switch (option)
			{
			case 1:	attempts++;
				
				if (testAddition ( )== true)
				{
					System.out.println("Correct");
					numCorrect++;
				}
				else
				{
					System.out.println("Incorrect");
				}	

				
				break;
			case 2: System.out.println("The number of attempts was: " + attempts + ".");
				System.out.println("The number of current answers was: " + numCorrect + ".");
				ans = numCorrect/attempts*100;
				System.out.println("That as a percentage is: " + ans);
				break;
			case 3:	if (attempts > 10)
				{
				ans = numCorrect/attempts*100;
				intNext = add(scores, intNext, (int)Math.round(ans),topTen,name);
				ans = 0;
				bubbleSort (scores,topTen);
				System.out.println("Please enter new players name: ");
				name = kybd.next();
				}
				else
				{
				System.out.println("Sorry you didn't make the top ten.");
				System.out.println("Please enter new players name: ");
				name = kybd.next(); 
				}
				attempts = 0;
				numCorrect = 0;
				ans = 0; 					
				break;

			case 4: printArray(scores, topTen);
				break;
			default:
				System.out.println("Error");
			}
			
			optionMenu( );			

			//requests selection

			System.out.println("Please pick an option: ");
			option = kybd.nextInt();
            		
		
        	}

	
	
 	}
		
	
	public static boolean testAddition ( )
	{
		// build an instance of Scanner, that is an object
 	
		Scanner kybd = new Scanner(System.in);
		
		int num1 = (int)(Math.random() * 20) + 1;
		int num2 = (int)(Math.random() * 20) + 1;
		int num3 = num1 + num2;
		boolean correct = false;
		
		System.out.println(num1 + "+" + num2 + "=");
		System.out.println("What is the sum of the two numbers? ");
		int guess = kybd.nextInt();	
	
			if ( guess == num3)
			{
				correct = true;
				
			}
		return correct;
				
			
	}
	
	public static void optionMenu( )
	{
		System.out.println("1. Try an addition test");
		System.out.println("2. Results");
		System.out.println("3. New player");
		System.out.println("4. Top five players");
		System.out.println("5. Quit");

	}
	
	//method to print all the values in a array 
	public static void printArray (int [] myIntArray, String [] myStringArray)
    	{

		for (int row = 0; row < myIntArray.length; ++row)
		{
			System.out.printf("%-15s %-15d", myStringArray[row], myIntArray[row]);
		System.out.println();
		}
		
	
	}

	public static int add(String [] myArray, int next, String newData)
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
	
	public static int add(int[] myArray1, int next, int newData, String [] myArray2, String name)
	{
  		// make sure array not full
		if (next < myArray1.length) 
		{	
			add(myArray2, next, name);
			myArray1[next] = newData;
			next++;
			System.out.println(newData + " added");
  		}
		else if (newData > myArray1[myArray1.length-1])
		{
			next = remove(myArray1,next,next-1);
			myArray1[next] = newData;
			next++;
			System.out.println(newData + " added");
			next = remove(myArray2,next,next-1);
			add(myArray2, next, name);
				
		}
		else
		{
			System.out.println("your not in the top five");
  		}
		return next;
	}

	public static void bubbleSort (int [] list, String [] list2)
	{
	
	int numItems = list.length;
      	boolean notSorted = true;
       
		while ( notSorted && (numItems >= 2) )
       		{
			notSorted = false;
           			for (int i = 0; i < numItems - 1; ++i)
           			{
	             			if ( list[i] < list[i+1] )
                 			{
	                  			swapArrayItems( list, i, i+1 );
						swapArrayItems( list2, i, i+1 );
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
	
	public static void swapArrayItems ( String [] list, int pos1, int pos2 )
 	{
        String temp = list[pos1];
        list[pos1] = list[pos2];
        list[pos2] = temp;
	
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

	public static int remove(String[] myArray, int next, int pos)
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
} 