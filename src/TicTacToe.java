import java.util.Scanner;

public class TicTacToe{	
	private char[][] board;
	private char player; // 'X' or 'O'
	private String test;
	
	public TicTacToe() {
		player = 'X';
		board = new char[3][3];
		board[0][0] = ' ';
		board[0][1] = ' ';
		board[0][2] = ' ';
		board[1][0] = ' ';
		board[1][1] = ' ';
		board[1][2] = ' ';
		board[2][0] = ' ';
		board[2][1] = ' ';
		board[2][2] = ' ';
	}
	
	/* 
	 * If s represents a valid move, add the current player's symbol to the board and return true.
	 * Otherwise return false.
	 */
	public boolean play(String playerInput) {
		/* Step 2: Fill in here with your own
		* play logic, and replace the return with you
		* own.
		*/ 
		switch(playerInput) {
		case "A1":
			if (board[0][0]==' ') {
				board[0][0] = player;
				return true;
			}
			else {
				System.out.println("This squares is occupied. Try again.\n");
				return false;
			}
		case "A2":
			if (board[0][1]==' ') {
				board[0][1] = player;
				return true;
			}
			else {
				System.out.println("This squares is occupied. Try again.\n");
				return false;
			}		
		case "A3":
			if (board[0][2]==' ') {
				board[0][2] = player;
				return true;
			}
			else {
				System.out.println("This squares is occupied. Try again.\n");
				return false;
			}	
		case "B1":
			if (board[1][0]==' ') {
				board[1][0] = player;
				return true;
			}
			else {
				System.out.println("This squares is occupied. Try again.\n");
				return false;
			}
		case "B2":
			if (board[1][1]==' ') {
				board[1][1] = player;
				return true;
			}
			else {
				System.out.println("This squares is occupied. Try again.\n");
				return false;
			}
		case "B3":
			if (board[1][2]==' ') {
				board[1][2] = player;
				return true;
			}
			else {
				System.out.println("This squares is occupied. Try again.\n");
				return false;
			}
		case "C1":
			if (board[2][0]==' ') {
				board[2][0] = player;
				return true;
			}
			else {
				System.out.println("This squares is occupied. Try again.\n");
				return false;
			}
		case "C2":
			if (board[2][1]==' ') {
				board[2][1] = player;
				return true;
			}
			else {
				System.out.println("This squares is occupied. Try again.\n");
				return false;
			}
		case "C3":
			if (board[2][2]==' ') {
				board[2][2] = player;
				return true;
			}
			else {
				System.out.println("This squares is occupied. Try again.\n");
				return false;
			}
		default:
			System.out.println("Invalid Input. Try again.\n");
			return false;
		}

	}
	
	/*
	 * Switches the current player from X to O, or O to X.
	 */
	public void switchTurn() {
		// Step 3: Fill in with your code to toggle between
		// 'X' and 'O'
		if (player == 'X') {
			player = 'O';
		}
		else {
			player = 'X';
		}
		
	}
	
	/*
	 * Returns true if the current player has won the game.
	 * Three in a row, column or either diagonal.
	 * Otherwise, return false.
	 */
	public boolean won() {
		/* Step 5: Fill in the code for the won method. This method
        * should return true if the current player has 3 in-a-row 
		* in any row, column or diagonal. Otherwise, return false.
		*/
		if ((board[0][0] == player && board[0][1] == player && board [0][2] == player) ||
			(board[1][0] == player && board[1][1] == player && board [1][2] == player) ||
			(board[2][0] == player && board[2][1] == player && board [2][2] == player) ||
			
			(board[0][0] == player && board[1][0] == player && board [2][0] == player) ||
			(board[0][1] == player && board[1][1] == player && board [2][1] == player) ||
			(board[0][2] == player && board[1][2] == player && board [2][2] == player) ||
			
			(board[0][0] == player && board[1][1] == player && board [2][2] == player) ||
			(board[0][2] == player && board[1][1] == player && board [2][0] == player)) 
			{
			return true;
		}
		else {
			
			return false;
		}
	}
	
	/*
	 * Returns true if there are no places left to move
	 */
	public boolean stalemate() {	
		if (board[0][0] != ' ' && board[0][1] != ' ' && board [0][2] != ' ' &&
			board[1][0] != ' ' && board[1][1] != ' ' && board [1][2] != ' ' &&
			board[2][0] != ' ' && board[2][1] != ' ' && board [2][2] != ' ')
			{
			return true;
		}
		else {
			return false;
		}
	}
	
	public char getPlayer() {
		return player;
	}
	
	public void print() {
		System.out.println();
		System.out.println("\t  1 2 3");
		System.out.println();
		System.out.println("\tA "+board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
		System.out.println("\t  -----");
		System.out.println("\tB "+board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
		System.out.println("\t  "+"-----");
		System.out.println("\tC "+board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
		System.out.println();
	}
	
	public static void main(String[] args) {

	       Scanner in = new Scanner(System.in);
	       TicTacToe game = new TicTacToe();
	       System.out.println("Welcome to Tic-tac-toe");
	       System.out.println("Enter coordinates for your move following the X and O prompts");
	       
	       while(!game.stalemate()) 
	       {
	              game.print();
	              System.out.print(game.getPlayer() + ":");

	              //Loop while the method play does not return true when given their move.
	              //Body of loop should ask for a different move
	              while(!game.play(in.next()))
	              {
	                    System.out.println("Illegal move. Enter your move.");
	                    System.out.print(game.getPlayer() + ":");
	               }
	              //If the game is won, call break;
	              if(game.won())
	                  break;

	              //Switch the turn
	              game.switchTurn();

	        }
	        game.print();
	        if(game.won())
	        {
	             System.out.println("Player "+game.getPlayer()+" Wins!!!!");
	        } 
	        else 
	        {
	             System.out.println("Stalemate");
	        }
	}
	
}