import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
This is the viewer class which prints out the report
@author Dakota Staples
*/
public class ProfitReportViewer {
    
	/**
	This is the main method, it prints the report out using other methods, it catchs multiple exceptions
	@param args The command Line arguments
	@throws MissingFileNameArgumentException If the file name is missing
	*/
	public static void main(String[] args) throws MissingFileNameArgumentException {
		Branch b1;
		Company c1;
        try {
            if (args.length == 0) {
                throw new MissingFileNameArgumentException("Missing Input File Name");
            }
			File f1 = new File(args[0]);
            Scanner stdin = new Scanner(f1); 
			//Printing the header
			printReportHeader(stdin.next(), stdin.next(), stdin.next(), stdin.nextInt());
			//Printing the branches data and values
			while(stdin.hasNext())
			{
				printBranchProfit(stdin.next(), stdin.next(),
					stdin.nextDouble(),stdin.nextDouble(),stdin.nextDouble(),stdin.nextDouble(),
					stdin.nextDouble());
			}
			
			
        }
		// Catching exceptions below, Missing file name, index out of bounds, no such element, and io exception
        catch (MissingFileNameArgumentException e) {
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Output File name not supplied");
		}
		
		catch(NoSuchElementException e)
		{
			System.out.println("No such element");
		}
        catch (IOException e) {
            System.out.println("Problem Reading File");
        }
    }    
    
    
    /**
     * This method prints the company's information part of the profit report
     * plus the header for the quarterly profit details of the company branches.
     * @param name Company name
     * @param domain Business domain of the company
     * @param license License number of the company
     * @param fiscalYear Profit report fiscal year
     */
    private static void printReportHeader(String name, String domain, String license, int fiscalYear) {
        
        System.out.println();
        System.out.println("\t\t\t\t\t\tCompany name: " + name);
        System.out.println("\t\t\t\t\t\tDomain: " + domain); 
        System.out.println("\t\t\t\t\t\tLicense: " + license);
        System.out.println("\t\t\t\t\t\tFiscal Year: " + fiscalYear);
        System.out.println("\n");
        System.out.println("\t\t\t\t\t\t\tProfit Report\n\n");
        String format = "%-15s %-15s %15s %15s %15s %15s %20s";
        System.out.format(format,"Branch ID", "Location", "Quarter 1", "Quarter 2", 
                            "Quarter 3", "Quarter 4", "Annual Profit");
        printSeparatorLine();
    }
    
    
    /**
     * This method prints the profit report line for a given company branch.
     * It is also used to print the totals line at the end of the report.
     * @param brnId - represents branch id
     * @param brnLocation - represents branch location
     * @param q1Profit - represents the profit for the first quarter
     * @param q2Profit - represents the profit for the second quarter
     * @param q3Profit - represents the profit for the third quarter
     * @param q4Profit represents the profit for the fourht quarter
     * @param annualProfit - represents the total profit for the whole year
     */
    private static void printBranchProfit(String brnId, String brnLocation, double q1Profit, 
                                          double q2Profit, double q3Profit, 
                                          double q4Profit, double annualProfit ) {
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
	formatter.setMinimumFractionDigits(2);
        formatter.setMinimumIntegerDigits(1);
        System.out.println();
        
        String format = "%-15s %-15s %15s %15s %15s %15s %20s";
        System.out.format(format, brnId, brnLocation, formatter.format(q1Profit), 
                          formatter.format(q2Profit), formatter.format(q3Profit),
                          formatter.format(q4Profit), formatter.format(annualProfit));    
    }
    
    
    /**
     * Reusable separator line print method.
     */
    private static void printSeparatorLine() {
        System.out.print("\n----------------------------------------------------------" +
                            "----------------------------------------------------------");        
    }
    
}
