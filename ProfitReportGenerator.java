import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class ProfitReportGenerator
{
	public static void main(String[] args) throws MissingFileNameArgumentException
	{
		Company c1 = null;
		Scanner stdin = null;
		FileReader reader;
		BufferedReader br = null;
		try
		{
			
			if(args.length == 0)
			{
				throw new MissingFileNameArgumentException("Missing Input and Output File Name");
			}
			
			if(args.length == 1)
			{
				throw new MissingFileNameArgumentException("Missing Input File Name");
			}
		
			reader = new FileReader(args[0]);
			br = new BufferedReader(reader);
			stdin = new Scanner(br);
			c1 = new Company(stdin.nextLine(), stdin.nextLine(), stdin.nextLine(), stdin.nextInt()); 
			stdin.nextLine();
		}
		
		catch(MissingFileNameArgumentException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		
		catch(InputMismatchException e)
		{
			System.out.println("Wrong type of input");
			return;
        }
		
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		
		catch(NoSuchElementException e)
		{
			System.out.println("No such element");
			return;
		}

		while(stdin.hasNext())
		{
			String temp = stdin.nextLine();	
			Scanner scan = new Scanner(temp);
			scan.useDelimiter(",");
			Branch b1;
			try
			{
				b1 = new Branch(scan.next(), scan.next());
			
			
				b1.calculateQuarterlyProfit(scan.nextDouble(), scan.nextDouble());
				b1.calculateQuarterlyProfit(scan.nextDouble(), scan.nextDouble());
				b1.calculateQuarterlyProfit(scan.nextDouble(), scan.nextDouble());
				b1.calculateQuarterlyProfit(scan.nextDouble(), scan.nextDouble());
				
				c1.addBranch(b1);
			}
			catch(InputMismatchException e)
			{
				System.out.println("Wrong type of input");
				return;
			}
			catch(InvalidQuarterException e)
			{
				System.out.println("Invalid Quarter");
				return;
			}
			catch(NoSuchElementException e)
			{
				System.out.println("No such element");
				return;
			}
			
			catch(NullPointerException e)
			{
				System.out.println("Null Pointer");
				return;
			}
		}

		try
		{
			br.close();
		}

		catch(IOException e)
		{
			System.out.println("Failed to close reader");
		}

		generateReportFile(c1,args[1]);
	}	

	private static void generateReportFile(Company company, String outputFileName)
	{
		FileWriter writer; 
		BufferedWriter bw; 
		PrintWriter out;
		
		try
		{
			writer = new FileWriter(outputFileName);
			bw = new BufferedWriter(writer);
			out = new PrintWriter(bw);
		}

		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Output File name not supplied");
			return;
		}
		
		catch(IOException e)
		{
			System.out.println("Problem Opening Writer");
			return;
		}			
		out.println(company);
		out.println(company.getBranchs()[0] + "\n" + company.getBranchs()[1] + "\n" +
			company.getBranchs()[2] + "\n" + company.getBranchs()[3] + "\n");

	}
}
