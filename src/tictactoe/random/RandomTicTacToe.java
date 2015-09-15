package tictactoe.random;

import java.util.Random;

public class RandomTicTacToe 
{
   private char board[][]=new char[3][3];
   private Random random= new Random();
   
   public Result play(Piece piece)
   {
	   if(!doEmptyPositionsExist())
	   {
		   if(isWinner(piece.getCharRepn()))
		   {
			   if(piece==Piece.X)
			   {
				   return Result.X_WON;
			   }
			   else 
			   {
				   return Result.O_WON;
			   }
		   }
		   else
		   {
			   System.out.println("The current player is:"+piece.getCharRepn());
			   return Result.DRAW;
		   }
	   }
	   
	   int row = 0;
	   int column = 0;
	   
	  do
	  {
		  row = random.nextInt(3);
		  column = random.nextInt(3);
	  } while(board[row][column]!='\u0000');
	   
	   if(board[row][column]=='\u0000')
	   {
		   board[row][column]=piece.getCharRepn();
	   }
	   
	   if(piece==Piece.X)
	   {
		   if(isWinner(piece.getCharRepn()))
		   {
			   return Result.X_WON;
		   }
		   return play(Piece.O);
	   }
	   else
	   {
		   if(isWinner(piece.getCharRepn()))
		   {
			   return Result.O_WON;
		   }
		  return play(Piece.X);
	   }
   }
   
   public char[][] getFinalBoardConfiguration()
   {
	   return board;
   }
   
   private boolean doEmptyPositionsExist()
   {
	   for(int i=0;i<3;i++)
	   {
		   for(int j=0;j<3;j++)
		   {
			   if(board[i][j]=='\u0000')
			   {
				   return true;
			   }
		   }
	   }
	   
	   System.out.println("Board no longer empty");
	   return false;
   }
   
   private boolean isWinner(char pieceRepn)
   {
	   int countRow=0;
	   int countColumn=0;
	   int forwardDiagonal = 0;
	   
	   for(int i=0;i<3;i++)
	   {
		   countRow=0;
		   countColumn = 0;
		   
		   if(board[i][i]==pieceRepn)
		   {
			   forwardDiagonal++;
		   }
		   
		   for(int j=0;j<3;j++)
		   {
			   if(board[i][j]==pieceRepn)
			   {
				   countRow++;
				   if(countRow==3)
				   {
				     return true;
				   }
			   }
			   
			   if(board[j][i]==pieceRepn)
			   {
				   countColumn++;
				   if(countColumn==3)
				   {
				     return true;
				   } 
			   }
		    }
		   
		   if(forwardDiagonal==3)
		   {
			   return true;
		   }
	    }
	   
	   int backwardDiagonal=0;
	   int i=0,j=2;
	   while(i<3 && j>=0)
	   {
		   if(board[i][j]==pieceRepn)
		   {
			   backwardDiagonal++;
		   }
		   i++;
		   j--;
	   }
	   
	   if(backwardDiagonal==3)
	   {
		   return true;
	   }
	   
	   return false;
   }  
}