public class Branch
{
	private String branchId;
	private String branchLocation;
	private double[] quarterProfit;
	private int quarterCount;
  
	public Branch(String Id, String location)
	{
       branchId = Id;
       branchLocation = location;
	}
  
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
  
	public double getQuarterlyProfit(int quarter)
	{
		return quarterProfit[quarter];
	}
  
	public double getAnnualProfit()
	{
		double total = 0;
		
		for(int i = 0; i < 4; i++)
		{
		  total += quarterProfit[i];
		}
		return total;
	}
  
	  public String toString()
	  {
		return branchId + "\t" + branchLocation + "\t" + quarterProfit[0] + "\t" + quarterProfit[1] +
			"\t" + quarterProfit[2] + "\t" + quarterProfit[3];
	  }
}