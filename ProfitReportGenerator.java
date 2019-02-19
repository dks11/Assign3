import java.io.*;
import java.util.Scanner;

public class ProfitReportGenerator
{
	public static void main(String[] args)
	{
		Company c1;
		Scanner stdin;
		FileReader reader;
		BufferedReader br;
		try
		{
			reader = new FileReader(args[0]);
			br = new BufferedReader(reader);
			stdin = new Scanner(br);
			c1 = new Company(stdin.next(), stdin.next(), stdin.next(), stdin.nextInt()); 
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e.getMessage());
			return;
		}

		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Input File name not entered");
			return;
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
	}	

	private void generateReportFile(Company company, String outputFileName)
	{
		FileWriter writer; 
		BufferedWriter bw; 
		
		try
		{
			writer = new FileWriter(“outputFileName”);
			bw = new BufferedWriter(writer);
			PrintWriter out = new PrintWriter(bw);
		}

		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Output File name not supplied");
			return():
		}

		
		
		
			
	}
}
