package main;

import main.board.ReversiBoard;
import main.player.Player;
import main.player.type.ComputerPlayer;
import main.player.type.HumanPlayer;
import java.util.Scanner;

public class Driver {

	/**
	 * @param args
	 *            main method
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		ReversiBoard reversi = new ReversiBoard();
		Player human = null, computer = null, human2 = null, computer2 = null;
		boolean running = true;

		int player = 1;
		String player1 = input.next();
		String player2 = input.next();

		/*-------------------------------------*/
		if (player1.equalsIgnoreCase("human")) {
			human = new HumanPlayer(player);
			player++;
		} else if (player1.equalsIgnoreCase("randomcomputerplayer")) {
			computer = new ComputerPlayer(player);
			player++;
		} else {
			System.out
					.println("Invalid format: [\"human\"-or-\"randomComputerPlayer\"] [\"human\"-or-\"randomComputerPlayer\"]");
			System.exit(0);
		}// Sets player1

		if (player2.equalsIgnoreCase("human")) {
			human2 = new HumanPlayer(player);
		} else if (player2.equalsIgnoreCase("randomcomputerplayer")) {
			computer2 = new ComputerPlayer(player);
		} else {
			System.out
					.println("Invalid format: [\"human\"-or-\"randomComputerPlayer\"] [\"human\"-or-\"randomComputerPlayer\"]");
			System.exit(0);
		}// Sets player2

		int x = -1, y = -1;
		Player player1st = null, player2nd = null;
		if (human != null) {
			player1st = human;
			if (human2 != null) {
				player2nd = human2;
			} else if (computer2 != null) {
				player2nd = computer2;
			}
		} else if (computer != null) {
			player1st = computer;
			if (human2 != null) {
				player2nd = human2;
			} else if (computer2 != null) {
				player2nd = computer2;
			}
		}// Sets player1 as human or computer and player2 as a human or computer

		/*--------------------------------------*/

		int count = 2;
		Player activePlayer = null, inactivePlayer = null;

		// Game is running
		System.out.println("Welcome to Reversi!");
		while (running) {

			if (count % 2 == 0) {
				activePlayer = player1st;
				inactivePlayer = player2nd;
			} else {
				activePlayer = player2nd;
				inactivePlayer = player1st;
			}// Alternates who the activePlayer is based on turn

			reversi.possibleMoves(activePlayer);
			reversi.printBoard();
			boolean noMoves = false;
			if (activePlayer.getMoves().length() == 0) {
				System.out.println();
				System.out.println("There are no moves for player"
						+ activePlayer.getplayerNumber() + " to make");
				System.out.println();
				noMoves = true;
				
				reversi.cleanBoard();
				reversi.possibleMoves(inactivePlayer);
				if(inactivePlayer.getMoves().length() == 0){
					System.out.println("Game is Over:");
					System.out.println("Player1 score: " + reversi.getScore(player1st));
					System.out.println("Player2 score: " + reversi.getScore(player2nd));
					System.exit(0);
				}
			}
			
			if (!noMoves) {
				// Accepts and check player move
				System.out.println();
				System.out.println("Make a move Player"
						+ activePlayer.getplayerNumber() + ": [row] [col]");
				if (activePlayer.getType().equals("computer")) {
					String str = activePlayer.RandomMove();
					x = Integer.parseInt(str.substring(0,1));
					y = Integer.parseInt(str.substring(1));
					reversi.makeMove(activePlayer, x, y);
				}

				if (activePlayer.getType().equals("human")) {
					boolean invalid = true;
					boolean moveMade = true;
					do {
						while (invalid) {
							try {
								x = Integer.parseInt(input.next());
								y = Integer.parseInt(input.next());
								invalid = false;
							} catch (Exception e) {
								System.out
										.println("Invalid input please try again: [row] [col]");
							}// try and catch statements
						}
						moveMade = reversi.makeMove(activePlayer, x, y);
						invalid = true;
					} while (!moveMade);

				}

			}// if statement
			reversi.cleanBoard();
			count++;
		}//While game is runnung
		
	}// main
}
