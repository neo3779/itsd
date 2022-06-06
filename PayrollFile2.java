import java.util.Scanner;
import java.io.*;

public class PayrollFile2
{
  	public static void main(String[] args)
  	{
	
	String name;
	double hourlyPay;
	int hoursWorked;

	// build an instance of Scanner, that is an object
 	
	Scanner kybd = new Scanner(System.in);

	try {
 	Scanner inFile = new Scanner(new File("Payroll.txt"));

		while (inFile.hasNext())
		{
  			name = inFile.next();
  			hourlyPay = inFile.nextDouble();
  			System.out.println("Hours worked by "+name+"?");
  			hoursWorked = kybd.nextInt();
  			double pay = hourlyPay * hoursWorked;
  			System.out.println("Pay is " + pay);
		}
	inFile.close();
	}
	catch(IOException e) {
   	System.out.println("Error reading from file");
	}


	

	}
}
