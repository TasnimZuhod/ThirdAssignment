package com.example.tictactoe_a;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

public class Tic extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tic);
	}

		  private char[][] board;
		  private int whoseturn;
		  private String[] players;
		  int movesmade;
		  final static private char[] pieces = {'X','O'};
		  static int index;
		  static String flag;

		  public Tic(String player1, String player2) {

		    board = new char[3][3];
		    for (int i=0;i < 3; i++)
		      for (int j=0; j < 3; j++)
		        board[i][j] = '_';
		    whoseturn = 0;
		    movesmade = 0;
		    players = new String[2];
		    players[0] = player1;
		    players[1] = player2;
		    
		    index = 0;
		    flag = "";
		    
		  }

		  public boolean move(int row, int column) {

		    if ( (board[row][column] == '_') ) {
		      board[row][column] = pieces[whoseturn];
		      movesmade++;
		      return true;
		    }
		    else
		      return false;
		  }

		  public void changeturn() {
		    whoseturn = (whoseturn + 1) % 2;
		  }

		  // Returns the current player's name.
		  public String getCurrentPlayer() {
		    return players[whoseturn];
		  }

		  // Returns a character signifying the winner.
		  public char winner() {

			// Check in a row.
		    for (int i=0; i<3; i++)
		      if (SameArray(board[i]) && board[i][0] != '_'){
		    	  flag = "row";
		    	  index = i;
		    	  return board[i][0];
		        }

			// Check in a column.
		    for (int i=0; i<3; i++)
		      if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i]) && board[0][i] != '_'){
		    	  flag = "col";
		    	  index = i;
		    	  return board[0][i];
		    	  }

			// Checks forward diagonal.
		    if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2])){
		    	flag = "fordiag";
		    	return board[0][0];
		    }

			// Checks backward diagonal.
		    if ((board[2][0] == board[1][1]) && (board[1][1] == board[0][2])){
		    	flag = "backdiag";
		    	return board[2][0];
		    }

		    if (movesmade == 9)
		      return 'T';

		    return '_';

		  }

		  // Checks to see if all the characters in a single character array are
		  // the same.
		  private static boolean SameArray(char[] word) {

		    char check = word[0];
		    for (int i=1; i<word.length; i++)
		      if (check != word[i])
		        return false;
		    return true;
		  }

		  // Returns the player who's playing piece is the character x.
		  public String whosePiece(char x) {
		    for (int i=0; i<2; i++)
		      if (x == pieces[i])
		        return players[i];
		    return "Dummy";
		  }
		
	}


