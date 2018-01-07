package main.player.type;

import main.board.ReversiBoard;
import main.player.Player;
import java.util.Random;

public class ComputerPlayer extends Player {

	public ComputerPlayer(int x) {
		super(x);
		type = "computer";
	}

	/**
	 * Returns type
	 * 
	 * @return type returns the type of player
	 */
	public String getType() {
		return type;
	}

	

	/**
	 * Picks a random move for the computer to perform
	 * 
	 */
	public String RandomMove() {
		String str = getMoves();
		Random r = new Random();
		int lng = str.length();
		lng = lng / 2;

		int start = r.nextInt(lng)+1;
		int i, j;
	
		i = Integer.parseInt(str.substring(start*2-2,start*2-1));
		j = Integer.parseInt(str.substring(start*2-1,start*2));
		String output = i+""+j;
		return output;

	}// RandomMove

}
