package main.player;

import main.board.ReversiBoard;

public abstract class Player {
	public String type;
	private int playerNumber;
	
	public Player(int x){
		playerNumber = x;
	}
	
	/**
	 * Returns the score of the player provided
	 * 
	 * @param p the player whose score is returned
	 * @return score return the score of the player provided
	 */
	public String getType(){
		return type;
	}//getType
	
	public int getplayerNumber(){
		return playerNumber;
	}//getPlayerNumber
	
	public int getOtherPlayerNumber(){
		if(playerNumber == 1){
			return 2;
		}else{
			return 1;
		}
	}//getOtherPlayerNumber
	
	/**
	 * overridden method
	 */
	public String RandomMove(){
		return null;
	}
	
	/**
	 * Returns a string of possible moves.
	 * 
	 * @return pickMoveString Returns a string of possible moves
	 */
	public String getMoves() {

		int[][] board = ReversiBoard.getBoard();
		String pickMoveString = "";

		for (int x = 1; x < 9; x++) {
			for (int y = 1; y < 9; y++) {
				if (board[x][y] == 3) {
					pickMoveString += x;
					pickMoveString += y;
				}// if statement

			}// inner for loop
		}// outer for loop

		return pickMoveString;
	}// pickMove
}
