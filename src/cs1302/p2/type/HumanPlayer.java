package main.player.type;

import main.player.Player;

public class HumanPlayer extends Player{
	
	public HumanPlayer(int x){
		super(x);
		type = "human";
	}
	public String getType(){
		return type;
	}
	
}
