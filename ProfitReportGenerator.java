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
			c1 = new Company(stdin.next(), stdin.next(), stdin.next(), stdin.nextInt()); 
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
        }
		
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		
		catch(NoSuchElementException e)
		{
			System.out.println("No such element");
		}

		while(stdin.hasNext())
		{
			Branch b1 = new Branch(stdin.next(), stdin.next());
			
			try
			{
			b1.calculateQuarterlyProfit(stdin.nextDouble(), stdin.nextDouble());
			b1.calculateQuarterlyProfit(stdin.nextDouble(), stdin.nextDouble());
			b1.calculateQuarterlyProfit(stdin.nextDouble(), stdin.nextDouble());
			b1.calculateQuarterlyProfit(stdin.nextDouble(), stdin.nextDouble());
			}
			catch(InvalidQuarterException e)
			{
				System.out.println("Invalid Quarter");
				return;
			}
			
			c1.addBranch(b1);
		}

		try
		{
			br.close();
		}

		catch(IOException e)
		{
			System.out.println("Failed to close reader");
		}
		
		catch(InputMismatchException e)
		{
			System.out.println("Wrong type of input");
        }
		
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		generateReportFile(c1,args[1]);
	}	

	private static void generateReportFile(Company company, String outputFileName)
	{
		FileWriter writer; 
		BufferedWriter bw; 
		
		try
		{
			writer = new FileWriter(outputFileName);
			bw = new BufferedWriter(writer);
			PrintWriter out = new PrintWriter(bw);
		}

		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Output File name not supplied");
			return;
		}
		
		catch(IOException e)
		{
			System.out.println("Problem Reading File");
			return;
		}			
	}
}
