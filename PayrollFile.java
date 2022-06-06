import java.util.Scanner;
import java.io.*;

public class PayrollFile
{
  	public static void main(String[] args)
  	{
      	
	// declare variables
  	String name;
  	double hourlyPay;
  	int hoursWorked;

  	Scanner kybd = new Scanner(System.in);
  	
	try
  	{
    		
		PrintWriter pw = new PrintWriter("Payroll.txt");
    		
		//request data to be written to file
		System.out.println("Name? (type 'exit' to finish)");
    		name = kybd.next();


		while (!name.equals("exit"))
    		{
      			
			
			System.out.println("Hourly pay? ");
      			hourlyPay = kybd.nextDouble();
      			

			pw.print(name + " ");
      			pw.printf("%6.2f", hourlyPay);
      			pw.println();

      			System.out.println("Name? (type 'exit' to finish)");
      			name = kybd.next();
    		}
    		
		
		pw.close();
  	
	}
		
		catch(IOException e)
	{	
		
		System.out.println("Error handling file");
	}
	}
}
