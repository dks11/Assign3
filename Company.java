public class Company
{
	String name;
	String buisnessDomain;
    	String license;
    	int fiscalYear;
    	int branchCount;
    	Branch[] branchs;
  
    public Company(String name, String buisnessDomain, String license, int fiscalYear)
    {
	  this.name =name;
      this.buisnessDomain = buisnessDomain;
      this.license = license;
      this.fiscalYear = fiscalYear;
      branchCount = 0;
      branchs = new Branch[5];
    }
  
    public void addBranch(Branch branch)
    {
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
  
    public Branch[] getBranchs()
    {
		return branchs;
    }
  
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
  
  public String toString()
  {
	String output = "Company name: " + name + "\n + Domain: " + buisnessDomain + "\n + License: " + license
		+ "\n + Fiscal Year: " + fiscalYear;
	return output;
  }
}
