package launcher;

import java.util.Scanner;

/**
 * Below class Writes a program for tick tack toe.
 * This class assumes it a normal tick tack toe with 3*3 matrix as 
 * nothing specifically has been mentioned in the question about it's size
 * The time complexity of this algorithm will be O(3*3) = O(9) which is equivalent to O(1)
 * */
public class Launcher {
	
@SuppressWarnings("resource")
public static void main(String[] args) throws Exception {

	String[][] moves = new String[3][3] ;
	//populating the available moves
	moves[0][0] = "0,0";moves[0][1] = "0,1";moves[0][2] = "0,2";
	moves[1][0] = "1,0";moves[1][1] = "1,1";moves[1][2] = "1,2";
	moves[2][0] = "2,0";moves[2][1] = "2,1";moves[2][2] = "2,2";
	
	System.out.println(checkWinner( moves));
}

 @SuppressWarnings("resource")
static String checkWinner(String[][] moves) throws Exception{
	int currentPlayer = 1;
	int count =0;
	while(count < 9) {
		System.out.println("PLAYER"+currentPlayer+"::Please enter from the below available moves in the same comma separated format");
	 
	    
	    for(int row =0 ;row < 3; row++) {
	    	for(int column =0 ;column < 3; column++) {
	    		if(!moves[row][column].equalsIgnoreCase("P1")
	    				&& !moves[row][column].equalsIgnoreCase("P2")) {
	    			System.out.println(row+","+column);
	    		}
	    		
		    }
	    }
	    
	    @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
	    String userInput = scan.nextLine();
	    String[] rowAndColumn = userInput.split(",");
	    try {
	    int rowVal = Integer.parseInt(rowAndColumn[0]);
	    int colVal = Integer.parseInt(rowAndColumn[1]);
	    // check for invalid move
	    if(rowAndColumn.length !=2 || rowVal < 0 || rowVal > 2 || colVal < 0 || colVal > 2 ) {
	    	throw new Exception("Please Enter Value in Required Format");
	    }
	    // check for already taken move
	    if(moves[rowVal][colVal].equalsIgnoreCase("P1") || moves[rowVal][colVal].equalsIgnoreCase("P2")) {
	    	throw new Exception("This Move is Already Taken");
	    }
	    moves[rowVal][colVal] = "P"+currentPlayer;
	    boolean isWinner = checkMoves(rowVal,colVal,moves,moves[rowVal][colVal]);
	    if(isWinner) {
	    	return moves[rowVal][colVal]+" has Won";
	    	
	    }
	   
	    } catch(Exception exception) {
	    	throw new Exception(exception.getMessage());
	    }
	  
	    
		currentPlayer = currentPlayer==1?2:1;
		count++;
	}
	return "NO PLAYER WON" ;
}

/*
 * This method checks the current move of current player to find out whether it is a winning move
 */
private static boolean checkMoves(int rowVal, int colVal, String[][] moves,String currentPlayer) {
	
	/*
	 * Checks for row win
	 */
	if(moves[rowVal][0].equalsIgnoreCase(currentPlayer) 
			&& moves[rowVal][1].equalsIgnoreCase(currentPlayer) && moves[rowVal][2].equalsIgnoreCase(currentPlayer)) {
		return  true;
	} 
	
	/*
	 * Checks for column win
	 */
	if(moves[0][colVal].equalsIgnoreCase(currentPlayer) 
			&& moves[1][colVal].equalsIgnoreCase(currentPlayer) && moves[2][colVal].equalsIgnoreCase(currentPlayer)) {
		return  true;
	} 
	/*
	 * Checks for diagonal win
	 */
	if((rowVal == 0 && colVal == 0) || (rowVal == 1 && colVal == 1)|| (rowVal == 2 && colVal == 2) ) {
		if(moves[0][0].equalsIgnoreCase(currentPlayer) 
				&& moves[1][1].equalsIgnoreCase(currentPlayer) && moves[2][2].equalsIgnoreCase(currentPlayer)) {
			return  true;
		}
	}
	
	/*
	 * Checks for diagonal win
	 */
	if((rowVal == 0 && colVal == 2) || (rowVal == 1 && colVal == 1)|| (rowVal == 2 && colVal == 0) ) {
	if(moves[0][2].equalsIgnoreCase(currentPlayer) 
			&& moves[1][1].equalsIgnoreCase(currentPlayer) && moves[2][0].equalsIgnoreCase(currentPlayer)) {
		return  true;
	}
	}

return false;
}



 
}

