
/**
This represents a company
@author Dakota Staples
*/
public class Company
{
	/**
	This is the company name
	*/
	String name;
	
	/**
	This is the company domain
	*/
	String buisnessDomain;
	
	/**
	This is the license number
	*/
    String license;
	
	/**
	This is the fiscal Year
	*/
    int fiscalYear;
	
	/**
	This is the branch count
	*/
    int branchCount;
	
	/**
	This is the array of branchs
	*/
    Branch[] branchs;
  
  
	/**
	This is the constructor
	@param name This is the company name
	@param buisnessDomain This is the company domain
	@param license This is the license number
	@param int fiscalYear This is the fiscal Year
	*/
    public Company(String name, String buisnessDomain, String license, int fiscalYear)
    {
	  this.name =name;
      this.buisnessDomain = buisnessDomain;
      this.license = license;
      this.fiscalYear = fiscalYear;
      branchCount = 0;
      branchs = new Branch[5];
    }
  
	/** This adds a new branch to the array
	@param branch The branch to addBranch
	*/
    public void addBranch(Branch branch)
    {
		//doubles the array if full
        if(branchCount == branchs.length)
        {
          Branch[] tempArray = new Branch[branchs.length * 2];
			
		    for(int i = 0; i < branchCount; i++)
		    {
			    tempArray[i] = branchs[i];
		    }

		  branchs = tempArray;
        }
    
        branchs[branchCount] = branch;
        branchCount++;
    }
  
	/** 
	Returns the branchs array
	@return The branchs array
	*/
    public Branch[] getBranchs()
    {
		return branchs;
    }
  
	/**
	This gets the profit totals as a String
	@return The formatted profit totals
	*/
    public String getProfitTotals()
    {
		String output = "";
	    for(int i = 0; i < branchCount; i++)
	    {
		    for(int j = 0; j < branchs.length; j ++)
		    {
		   	    output += branchs[i].getQuarterlyProfit(j) + "\t";
		    }
			System.out.println("\n");
		    	output += branchs[i].getAnnualProfit() + "\t";
	    }
		return output;
    }
  
  /**
  returns the company info
  @return The company info
  */
  public String toString()
  {
	String output = "Company name: " + name + "\n + Domain: " + buisnessDomain + "\n + License: " + license
		+ "\n + Fiscal Year: " + fiscalYear;
	return output;
  }
}
