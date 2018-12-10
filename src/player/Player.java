package player;

import java.util.ArrayList;

import creatures.Meeple;

public class Player {
	private String name;
	public ArrayList<Meeple> meeple;
	public int score;
	public Player(String name) {
		score = 0;
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}