package test;

import org.junit.Assert;
import org.junit.Test;

import tictactoe.random.Piece;
import tictactoe.random.RandomTicTacToe;
import tictactoe.random.Result;

public class TicTacToeTest 
{
	 @Test
	 public void testRandomTicTacToe()
	  {
		 RandomTicTacToe randomTicTacToe = new RandomTicTacToe();
		 Result result = randomTicTacToe.play(Piece.X);
		 Assert.assertTrue("result:not expected",result==Result.DRAW || result==Result.O_WON || result==Result.X_WON); 
		 System.out.println("The result is:" + result);
		 char[][] finalBoard=randomTicTacToe.getFinalBoardConfiguration();
		 for(int i=0;i<3;i++)
		 {
			 for(int j=0;j<3;j++)
			 {
				 System.out.print(finalBoard[i][j]);
			 }
			 System.out.println();
		 }
	  }
}
