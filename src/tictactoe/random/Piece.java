package tictactoe.random;

public enum Piece 
{
  X('x'),
  
  O('o');
  
  private final char charRepn;
  private int noOfAssignments;
  
  private Piece(char charRepn)
  {
	 this.charRepn = charRepn;
  }
  
  public char getCharRepn()
  {
	  return charRepn;
  }

  public int getNoOfAssignments() 
  {
	return noOfAssignments;
  }

   public void setNoOfAssignments(int noOfAssignments) 
   {
	 this.noOfAssignments = noOfAssignments;
   }
}
