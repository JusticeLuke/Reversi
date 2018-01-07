package main.board;

import java.util.Arrays;

import main.player.Player;

public class ReversiBoard {
	public static int[][] bufferBoard = new int[10][10];
	private int[] possibleMoves;
	private int score = 0;

	/**
	 * Constructor for the Reversi board. Sets game board to starting positions.
	 * 
	 * @param null Sets the game board to starting positions
	 */
	public ReversiBoard() {
		for (int i = 0; i < bufferBoard.length; i++) {
			Arrays.fill(bufferBoard[i], 4);
		}

		for (int x = 1; x < 9; x++) {
			for (int y = 1; y < 9; y++) {
				bufferBoard[x][y] = 0;
			}
		}
		// Set starting board
		bufferBoard[4][4] = 1;// X is 1
		bufferBoard[5][5] = 1;
		bufferBoard[4][5] = 2;// O is 2
		bufferBoard[5][4] = 2;

	}// ReversiBoard

	/**
	 * Prints the game board
	 * 
	 * @param null Prints the game board
	 */
	public void printBoard() {

		System.out.println("  1 2 3 4 5 6 7 8");

		for (int x = 1; x < 9; x++) {
			System.out.print(x);
			for (int y = 1; y < 9; y++) {

				if (bufferBoard[x][y] == 0) {
					System.out.print(" .");
				}// Print " ." for 0s || empty space

				if (bufferBoard[x][y] == 1) {
					System.out.print(" X");
				}// Print " X" for 1s || X player's spots

				if (bufferBoard[x][y] == 2) {
					System.out.print(" O");
				}// Print " O" for 2s || O player's spots

				if (bufferBoard[x][y] == 3) {
					System.out.print(" _");
				}// Print " _" for 3s || possible moves

			}// inner for loop
			System.out.println();
		}// outer for loop

	}// printBoard

	/**
	 * Cleans board and boardBuffer of possible moves after each players turn
	 * 
	 * @param null cleans board
	 */
	public void cleanBoard() {

		for (int x = 0; x < bufferBoard.length; x++) {
			for (int y = 0; y < bufferBoard[x].length; y++) {
				if (bufferBoard[x][y] == 3) {
					bufferBoard[x][y] = 0;
				}// Changes 3s to 0s

			}// inner for loop
		}// outer for loop

	}// cleanBoard

	/**
	 * Finds and returns the possible moves of the given player in an int array.
	 * 
	 * @param p
	 *            finds the possible moves of the given player
	 * @return possibleMoves returns an int array of the possible moves of the
	 *         given player
	 */
	public int[] possibleMoves(Player p) {
		int activePlayer = -1, otherPlayer = -1, up;
		boolean checking = true;

		if (p.getplayerNumber() == 1) {
			activePlayer = 1;
			otherPlayer = 2;
		}// Set player1 as active player
		if (p.getplayerNumber() == 2) {
			activePlayer = 2;
			otherPlayer = 1;
		}// Set player2 as active player

		for (int x = 0; x < bufferBoard.length; x++) {
			for (int y = 0; y < bufferBoard[x].length; y++) {

				checking = true;
				if (bufferBoard[x][y] == activePlayer) {

					up = 1;
					while (checking) {
						if (bufferBoard[x + up][y + up] == otherPlayer) {
							up++;
							if (bufferBoard[x + up][y + up] == 0) {
								bufferBoard[x + up][y + up] = 3;
							}
						} else {
							checking = false;
						}
					}// Checks upwards diagonal for a possible move

					checking = true;
					up = 1;
					while (checking) {
						if (bufferBoard[x][y + up] == otherPlayer) {
							up++;
							if (bufferBoard[x][y + up] == 0) {
								bufferBoard[x][y + up] = 3;
							}
						} else {
							checking = false;
						}
					}// Checks upwards diagonal for a possible move

					checking = true;
					up = 1;
					while (checking) {
						if (bufferBoard[x + up][y] == otherPlayer) {
							up++;
							if (bufferBoard[x + up][y] == 0) {
								bufferBoard[x + up][y] = 3;
							}
						} else {
							checking = false;
						}
					}// Checks upwards diagonal for a possible move

					checking = true;
					up = 1;
					while (checking) {
						if (bufferBoard[x - up][y - up] == otherPlayer) {
							up++;
							if (bufferBoard[x - up][y - up] == 0) {
								bufferBoard[x - up][y - up] = 3;
							}
						} else {
							checking = false;
						}
					}// Checks upwards diagonal for a possible move

					checking = true;
					up = 1;
					while (checking) {
						if (bufferBoard[x - up][y] == otherPlayer) {
							up++;
							if (bufferBoard[x - up][y] == 0) {
								bufferBoard[x - up][y] = 3;
							}
						} else {
							checking = false;
						}
					}// Checks upwards diagonal for a possible move

					checking = true;
					up = 1;
					while (checking) {
						if (bufferBoard[x][y - up] == otherPlayer) {
							up++;
							if (bufferBoard[x][y - up] == 0) {
								bufferBoard[x][y - up] = 3;
							}
						} else {
							checking = false;
						}
					}// Checks upwards diagonal for a possible move

					checking = true;
					up = 1;
					while (checking) {
						if (bufferBoard[x + up][y - up] == otherPlayer) {
							up++;
							if (bufferBoard[x + up][y - up] == 0) {
								bufferBoard[x + up][y - up] = 3;
							}
						} else {
							checking = false;
						}
					}// Checks upwards diagonal for a possible move

					checking = true;
					up = 1;
					while (checking) {
						if (bufferBoard[x - up][y + up] == otherPlayer) {
							up++;
							if (bufferBoard[x - up][y + up] == 0) {
								bufferBoard[x - up][y + up] = 3;
							}
						} else {
							checking = false;
						}
					}// Checks upwards diagonal for a possible move

				}// Reference point

			}// board inner for loop
		}// board outer for loop

		return possibleMoves;

	}// possibleMoves

	/**
	 * Makes a move
	 * 
	 * @param c
	 *            Player who is making the move
	 * @param x
	 *            x coordinate of the move
	 * @param y
	 *            y coordinate of the move
	 */
	public boolean makeMove(Player c, int x, int y) {

		if (x > 0 && y > 0 && x < 9 && y < 9) {
			if (bufferBoard[x][y] == 3) {
				bufferBoard[x][y] = c.getplayerNumber();
				changeSides(c, x, y);
				return true;
			} else {
				System.out
						.println("Invalid move. Only spots with underscores are valid");
				return false;
			}

		} else {
			System.out.println("Invalid move. Out of bounds");
			return false;
		}

	}// makeMove

	/**
	 * Switches the affiliation of a square from O to X or O to X between the
	 * newest move and other squares of the same affiliation
	 * 
	 * @param c
	 *            refers to the active player
	 * @param x
	 *            refers to the x coordinate
	 * @param y
	 *            refers to the y coordinate
	 */
	public void changeSides(Player c, int x, int y) {

		int up = 1, i, j,y2,x2;
		boolean checking = true;
		while (checking) {
			if (bufferBoard[x + up][y + up] == c.getOtherPlayerNumber()) {
				up++;
				if (bufferBoard[x + up][y + up] == c.getplayerNumber()) {
					i = x + up;
					j = y + up;
					
					x2 = x;
					y2 = y;
					while (i > x2 && j > y2) {
						bufferBoard[x2][y2] = c.getplayerNumber();
						x2++;
						y2++;
					}

				}
			} else {
				checking = false;
			}
		}// Checks upwards diagonal for switches

		up = 1;
		checking = true;
		while (checking) {
			if (bufferBoard[x - up][y - up] == c.getOtherPlayerNumber()) {
				up++;
				if (bufferBoard[x - up][y - up] == c.getplayerNumber()) {
					i = x - up;
					j = y - up;
					
					x2 = x;
					y2 = y;
					while (i < x2 && j < y2) {
						bufferBoard[x2][y2] = c.getplayerNumber();
						x2--;
						y2--;
					}

				}
			} else {
				checking = false;
			}
		}// Checks upwards diagonal for switches

		up = 1;
		checking = true;
		while (checking) {
			if (bufferBoard[x + up][y - up] == c.getOtherPlayerNumber()) {
				up++;
				if (bufferBoard[x + up][y - up] == c.getplayerNumber()) {
					i = x + up;
					j = y - up;
					
					x2 = x;
					y2 = y;
					while (i > x2 && j < y2) {
						bufferBoard[x2][y2] = c.getplayerNumber();
						x2++;
						y2--;
					}

				}
			} else {
				checking = false;
			}
		}// Checks upwards diagonal for switches

		up = 1;
		checking = true;
		while (checking) {
			if (bufferBoard[x - up][y + up] == c.getOtherPlayerNumber()) {
				up++;
				if (bufferBoard[x - up][y + up] == c.getplayerNumber()) {
					i = x - up;
					j = y + up;
					y2 = y;
					x2 = x;
					while (i < x2 && j > y2) {
						bufferBoard[x2][y2] = c.getplayerNumber();
						x2--;
						y2++;
					}

				}
			} else {
				checking = false;
			}
		}// Checks upwards diagonal for switches

		up = 1;
		checking = true;
		while (checking) {
			if (bufferBoard[x - up][y] == c.getOtherPlayerNumber()) {
				up++;
				if (bufferBoard[x - up][y] == c.getplayerNumber()) {
					i = x - up;
					x2 = x;
					while (i < x2) {
						bufferBoard[x2][y] = c.getplayerNumber();
						x2--;
					}

				}
			} else {
				checking = false;
			}
		}// Checks upwards diagonal for switches

		up = 1;
		checking = true;
		while (checking) {
			if (bufferBoard[x][y - up] == c.getOtherPlayerNumber()) {
				up++;
				if (bufferBoard[x][y - up] == c.getplayerNumber()) {
					j = y - up;
					y2= y;
					while (j < y2) {
						bufferBoard[x][y2] = c.getplayerNumber();
						y2--;
					}

				}
			} else {
				checking = false;
			}
		}// Checks

		up = 1;
		checking = true;
		while (checking) {
			if (bufferBoard[x + up][y] == c.getOtherPlayerNumber()) {
				up++;
				if (bufferBoard[x + up][y] == c.getplayerNumber()) {
					i = x + up;
					x2 = x;
					while (i > x2) {
						bufferBoard[x2][y] = c.getplayerNumber();
						x2++;
					}

				}
			} else {
				checking = false;
			}
		}// Checks adjacent right spaces to flip

		up = 1;
		checking = true;
		while (checking) {
			if (bufferBoard[x][y + up] == c.getOtherPlayerNumber()) {
				up++;
				if (bufferBoard[x][y + up] == c.getplayerNumber()) {
					j = y + up;
					y2 = y;
					while (j > y2) {
						bufferBoard[x][y2] = c.getplayerNumber();
						y2++;
					}

				}
			} else {
				checking = false;
			}
		}// Checks upwards diagonal for switches

	}// ChangeSides

	/**
	 * Returns the score of the player provided
	 * 
	 * @param p
	 *            the player whose score is returned
	 * @return score return the score of the player provided
	 */
	public int getScore(Player p) {
		score = 0;
		for (int x = 0; x < bufferBoard.length; x++) {
			for (int y = 0; y < bufferBoard[x].length; y++) {
				
				if (p.getplayerNumber() == bufferBoard[x][y]) {
					score++;
				}
			}//inner for loop
		}//outer for loop
		
		return score;
	}// getScore

	/**
	 * Returns a copy of the board
	 * 
	 * @return boardCopy return a copy of the board
	 */
	public static int[][] getBoard() {

		int[][] boardCopy = new int[10][10];

		for (int x = 0; x < bufferBoard.length; x++) {
			for (int y = 0; y < bufferBoard[x].length; y++) {
				boardCopy[x][y] = bufferBoard[x][y];
			}// Inner for loop
		}// Outer for loop

		return boardCopy;

	}// getBoard
}
