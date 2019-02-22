/**
This is the branch class which is part of a company
@author Dakota Staples
*/
public class Branch
{
	/**
	This is the branch ID
	*/
	private String branchId;
	
	/**
	This is the branch Location
	*/
	private String branchLocation;
	
	/**
	This is the array of profits
	*/
	private double[] quarterProfit;
	
	/**
	This is the count of how many quarters
	*/
	private int quarterCount;
  
	/**
	This is the constructor
	@param Id This is the id for the branch
	@param location This is the location of the branch
	*/
	public Branch(String Id, String location)
	{
       branchId = Id;
       branchLocation = location;
	   quarterProfit = new double[4];
	}
  
	/**
	This calculates the quarterly profit
	@param expense The expense
	@param revenue The revenue
	@throws InvalidQuarterException if the quarter is greater than 4
	*/
	public void calculateQuarterlyProfit(double expense, double revenue) throws InvalidQuarterException
	{
		if ( (quarterCount < 0) || (quarterCount > 3) )
		{
			throw new InvalidQuarterException("Invalid Quarter");
		}
		else
		{
			quarterProfit[quarterCount] = expense - revenue;
			quarterCount++;
		}
	}
  
	/**
	This gets the quarterly profit
	@param quarter The quarter
	@return the quarterly profit
	*/
	public double getQuarterlyProfit(int quarter)
	{
		return quarterProfit[quarter];
	}
  
	/**
	This gets the annual profit
	@return the annual profit
	*/
	public double getAnnualProfit()
	{
		double total = 0;
		
		for(int i = 0; i < 4; i++)
		{
		  total += quarterProfit[i];
		}
		return total;
	}
	/**
	This prints the info
	@return the info about the company
	*/
	  public String toString()
	  {
		return branchId + "," + branchLocation + "," + quarterProfit[0] + "," + quarterProfit[1] +
			"," + quarterProfit[2] + "," + quarterProfit[3];
	  }
}