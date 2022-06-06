/**
 * <p>Math Game</p> 
 * <p>Description: This program has lots of methods to  
 * show that Alex J Davison has learnt and understood ISD.
 * The program uses, case statements, if statements,  
 * while loop, for loop and other java tools.</p> 
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Alex J Davison</p>
 * @version 1.0
 * @see java.util.Scanner
 * @import java.util.*;
 * @import java.io.*;
 */

// Maths game

import java.util.*;
import java.io.*;

public class MathGame2
{
	/**
   	 * Main method of program.<br>
   	 * Execution starts here.
   	 * @param args String[] - any run-time arguments
   	 */

	public static void main(String[]args)
	{

	//delcare and intialize variables
	int attempts = 0;
	double numCorrect = 0;
	double ans = 0;
	String [] topTen = new String [5];
	int [] scores = new int [5];
	int stringNext = 0;
	int intNext = 0;
	String name;
	int option = 0;
	
	//load the past score values from a text file
	load(topTen, scores);
	
	// build an instance of Scanner, that is an object
	Scanner kybd = new Scanner(System.in);

	//request the players name
	System.out.println("Please enter your name: ");
	name = kybd.nextLine();
	
	//display the options for the player
	optionMenu( );

	//request the users options
	System.out.println("Please pick an option: ");
	option = kybd.nextInt();

	
	
		while (option != 5)
        	{
			
			//Switch statments to allow the program to continue		
			switch (option)
			{
			case 1:	//in case one increas number off attempts
				attempts++;
				
				//if statement to tell user whether they were correct or not and call test method
				if (testAddition ( )== true)
				{
					//Correct answer was given and number or correct answer was increased
					System.out.println("Correct");
					numCorrect++;
				}
				else
				{
					//inform user they were incorrect
					System.out.println("Incorrect");
				}	

				
				break;
			case 2: //print all the users current result
				System.out.println("The number of attempts was: " + attempts + ".");
				System.out.println("The number of current answers was: " + numCorrect + ".");
				
				//calaculate the perecentage
				ans = numCorrect/attempts*100;
				System.out.println("That as a percentage is: " + ans);
				break;
			case 3:	// if the users has made moremore than 10 attempts then the user may be consider for the top 5
				if (attempts > 10)
				{
					//calacate the perecentage of the user socre
					ans = numCorrect/attempts*100;
					//call the add method to add the user to the top 5
					intNext = add(scores, intNext, (int)Math.round(ans),topTen,name);
					//rest the ans to 0
					ans = 0;
					//sort the top 5 after adding the new player
					bubbleSort (scores,topTen);
					//request new player's name
					System.out.println("Please enter new players name: ");
					name = kybd.next();
				}
				else
				{
					//Player didn't make the top 5
					System.out.println("Sorry you didn't make the top ten.");
					//request new player's name
					System.out.println("Please enter new players name: ");
					name = kybd.next(); 
				}
				//rest all values to 0
				attempts = 0;
				numCorrect = 0;
				ans = 0; 					
				break;

			case 4: //print the top 5
				printArray(scores, topTen);
				break;
			default:
				//if anything eneter error appears
				System.out.println("Error, please pick an option between 1 and 5.");
			}
			
			//print all the menu options
			optionMenu( );			

			//requests selection
			System.out.println("Please pick an option: ");
			option = kybd.nextInt();
			
			//if the option is 5 then save the data of the top 5 to a file
			if(option == 5)
			{
				save(topTen,scores);
			}
            		
		
        	}

	
	
 	}
	
	/**
   	 * Test addition method that randomly creates two numbers between 1 and 20.
	 * Works out the answer.
	 * Asks the user if they know the answer and compares the users answer and computers.
	 * If the user gets thae answer correct then turn is returned, else false.
   	 * @return bollean - True or false of as to whether the user was correct.
   	 */
	
	//this is the test method
	public static boolean testAddition ( )
	{
		// build an instance of Scanner, that is an object
 		Scanner kybd = new Scanner(System.in);
		
		//makes a random from 0 and 20
		int num1 = (int)(Math.random() * 20) + 1;
		int num2 = (int)(Math.random() * 20) + 1;
		
		// stores the answer in a variable
		int num3 = num1 + num2;
		
		//set correct to false
		boolean correct = false;
		
		// print out the sum and asks the question to allow a input for users answer
		System.out.println(num1 + "+" + num2 + "=");
		System.out.println("What is the sum of the two numbers? ");
		int guess = kybd.nextInt();	
	
			//if the users guess the answer correct then set correct to true
			if ( guess == num3)
			{
				correct = true;
				
			}
		//returns correct variable from the method
		return correct;
				
			
	}
	
	/**
   	 * Prints out a menu that says. 1. Try an addition test, 2. Results, 3. New player, 4. Top five players and 5. Quit.
	 */

	//method to print the menu options
	public static void optionMenu( )
	{
		System.out.println("1. Try an addition test");
		System.out.println("2. Results");
		System.out.println("3. New player");
		System.out.println("4. Top five players");
		System.out.println("5. Quit");

	}
	
	/**
   	 * Print array method, Prints all the values in two arrays.
	 * Loops through the arrays and prints all the values for the length of the array.
   	 * @param myIntArray int - Array of int that is printed.
   	 * @param myStringArray String - Array of String that is printed.
   	 */

	//method to print all the values in a array 
	public static void printArray (int [] myIntArray, String [] myStringArray)
    	{

		//loop to print all values in an array that is past through it
		for (int row = 0; row < myIntArray.length; ++row)
		{
			System.out.printf("%-15s %-15d", myStringArray[row], myIntArray[row]);
			System.out.println();
		}
		
	
	}

	/**
   	 * Add method to add an String value to and int array.
	 * Checks to see if the array is full or not.
	 * If array not full, add item to array.
	 * Else print message.
	 * Return Next postion to be written to.
   	 * @param myArray String[] - Array of int to be checked.
   	 * @param next int[] - The next position to be written to in the array.
   	 * @param newData int - The new number to be consider to be added.
   	 * @return int - The next Position to be written to in the array.
   	 */

	//method to add strings to an array
	public static int add(String [] myArray, int next, String newData)
	{
  		// make sure array not full
		if (next < myArray.length) 
		{	
			//adds new data and add one to counter past ing and cofrims addition
			myArray[next] = newData;
			next++;
			System.out.println(newData + " added");
  		}
		else
			//confirms that array is full
			System.out.println("array full");
  		
		//returns counter
		return next;
	}
	
	/**
   	 * Add method to add an int value to and int array.
	 * Checks to see if the array is full or not.
	 * If array not full, add item to array.
	 * Else print message.
	 * Return Next postion to be written to.
   	 * @param myArray int [] - Array of int to be checked.
   	 * @param next int - The next position to be written to in the array.
   	 * @param newData int - The new number to be consider to be added.
   	 * @return int - The next Position to be written to in the array.
   	 */

	//method to add ints to an array
	public static int add(int[] myArray, int next, int newData)
	{
  		// make sure array not full
		if (next < myArray.length) 
		{	
			//adds new data and add one to counter past ing and cofrims addition
			myArray[next] = newData;
			next++;
			System.out.println(newData + " added");
  		}
		else
			//confirms that array is full
			System.out.println("array full");
  		
		//returns counter
		return next;
	}
	
	/**
   	 * Add method to add a bigger number to an array and a string.
	 * Checks to see if the array is full or not.
	 * If array not full, add item to array.
	 * If array full, is number being added bigger than that of the last number in the array.
	 * Then detele last int and string of the two arrays and add the new values to them.
	 * Else print message.
	 * Return Next postion to be written to.
   	 * @param myArray1 int [] - Array of int to be checked.
   	 * @param next int - The next position to be written to in the array.
   	 * @param newData int - The new number to be consider to be added.
   	 * @param myArray2 String[] - The string array to be updated as well.
   	 * @param name String - The new string value to be added.
	 * @return int - The next Position to be written to in the array.
   	 */

	//method to add ints to an array for topfive
	public static int add(int[] myArray1, int next, int newData, String [] myArray2, String name)
	{
  		// make sure array not full
		if (next < myArray1.length) 
		{	
			//call add method for names, adds new data and add one to counter past ing and cofrims addition
			add(myArray2, next, name);
			myArray1[next] = newData;
			next++;
			System.out.println(newData + " added");
  		}
		else if (newData > myArray1[myArray1.length-1])
		{
			//deletes data if the value being added is high than the last in the top5,call add method for names, adds new data and add one to counter past ing and cofrims addition
			next = remove(myArray1,next,next-1);
			myArray1[next] = newData;
			next++;
			System.out.println(newData + " added");
			next = remove(myArray2,next,next-1);
			add(myArray2, next, name);
				
		}
		else
		{
			//confirm not making the top five
			System.out.println("your not in the top five");
  		}
		
		//returns counter
		return next;
	}

	/**
   	 * Bubble sort method, order an int array.
	 * The bubble sort also sorts a string arry to the same order as the int array.
   	 * @param list int[] - The array of ints to be sorted.
   	 * @param list2 String[] - The array of strings to be sorted along side the ints.
   	 */

	//method to do a bubble sort
	public static void bubbleSort (int [] list, String [] list2)
	{
	
	//declare variable and intialize
	int numItems = list.length;
      	boolean notSorted = true;
       
		//loop to go thourgh all the elements 
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
	
	/**
   	 * Swap method, to swap two int items around in an array.
   	 * @param list int - The array of ints for items to be swaped.
   	 * @param pos1 int - The first position of the first item.
	 * @param pos2 int - The second position of the second item.
   	 */

	//Method to swap to int elements
	public static void swapArrayItems ( int [] list, int pos1, int pos2 )
 	{
        int temp = list[pos1];
        list[pos1] = list[pos2];
        list[pos2] = temp;
 	}
	
	/**
   	 * Swap method, to swap two string items around in an array.
   	 * @param list String - The array of strings for items to be swaped.
   	 * @param pos1 int - The first position of the first item.
	 * @param pos2 int - The second position of the second item.
   	 */

	//Method to swap to string elements
	public static void swapArrayItems ( String [] list, int pos1, int pos2 )
 	{
        String temp = list[pos1];
        list[pos1] = list[pos2];
        list[pos2] = temp;
 	}

	/**
   	 * Remove method to remove a int value from a array.
	 * Checks for Vaild postion, then loops to fill gap.
   	 * If not a vaild postion then prints postion number inputted with "not valid position".
	 * Return next postion to be written to.
   	 * @param myArray int[] - The array of ints for an item to be deleted.
   	 * @param next int - The next position to be written to.
	 * @param pos int - The position to be deleted.
	 * @return int - The next Position to be written to in the array.
   	 */

	//remove and int element from and array
	public static int remove(int[] myArray, int next, int pos)
	{
 		// position valid?
		if (pos >= 0 && pos < next) 
  		{
         		System.out.println(myArray[pos]+ " deleted"); 
    		 	// decrease number in list by 1
			next--; 
				
				//fill gap
				for (int i=pos; i<(next); i++) 
					myArray[i] = myArray[i+1]; 	 
  		}
  		else
		{
   			//Print if not a valid postion
			System.out.println(pos + " not a valid position");
		}
		// new size of list
		return next;  
	}
	
	/**
   	 * Remove method to remove a string from an array.
   	 * Checks for Vaild postion, then loops to fill gap.
   	 * If not a vaild postion then prints postion number inputted with "not valid position".
	 * Return next postion to be written to.
   	 * @param myArray String[] - The array of strings for an item to be deleted.
   	 * @param next int - The next position to be written to.
	 * @param pos int - The position to be deleted.
	 * @return int - The next Position to be written to in the array.
   	 */
	
	//method to remove name from top five
	public static int remove(String[] myArray, int next, int pos)
	{
 		// position valid?
		if (pos >= 0 && pos < next) 
  		{
         		System.out.println(myArray[pos]+ " deleted"); 
    		 	// decrease number in list by 1
			next--; 
				
				//fill gap
				for (int i=pos; i<(next); i++) 
				{
					myArray[i] = myArray[i+1];
				} 	 
  		}
  		else
   		{
			//Print if not a valid postion
			System.out.println(pos + " not a valid position");
		}
		// new size of list
		return next;  
	}
	
	/**
   	 * Saves the string and int values to a file called Score.txt.
   	 * Has exception built in for error handeling.
   	 * Loop through, writes all the the string and int numbers.
   	 * @param myArray String[] - The array to store the names.
   	 * @param myArray2 int[] - The array to store the scores.
   	 */

	//save the top five into a text file
	public static void save(String [] myArray, int [] myArray2)
	{
		//execption cather, if the file can't be written due to format
		try
  		{
    			//print values to file
			PrintWriter ts = new PrintWriter("Score.txt");
		
			//loop to write all the vaules
			for (int i = 0; i < myArray.length; i++)
    			{
      				//write all the elements to file
				ts.println(myArray[i] + "  " + myArray2[i]);
    			}
		//close file
		ts.close();
  	
		}
			catch(IOException e)
		{	
			//print if error occurs
			System.out.println("Error handling file");
		}
	
	}
	
	/**
   	 * Loads the saved string and int values from a file called Score.txt.
   	 * Has exception built in for error handeling.
   	 * Loop through, reading all the the sting and int numbers.
   	 * @param myArray String[] - The array to store the names.
   	 * @param myArray2 int[] - The array to store the scores.
   	 */

	//Load the top 5 from a file
	public static void load(String [] myArray, int [] myArray2)
	{
	
		try 
		{
		//save to file
 		Scanner inFile = new Scanner(new File("Score.txt"));
			
			//loop thorugh to write all elements
			for (int i = 0; i < 5; i++)
			{
				//write to file
				myArray[i] = inFile.next();
				myArray2[i] = inFile.nextInt();
	
			}
		//close file
		inFile.close();
		}
		catch(IOException e) 
		{
			//print if error occurs
   			System.out.println("Error reading from file");
		}
	}
	


} 