package player;

import java.util.ArrayList;

import creatures.Meeple;

public class Player {
	private String name;
	public ArrayList<Meeple> meeple;
	private int score;
	private int action;
	public Player(String name) {
		score = 0;
		this.name = name;
		action = 3;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	
}