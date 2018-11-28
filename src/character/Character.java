package character;
import java.util.ArrayList;

import card.Card;
import main.Game;
import town.Town;

public class Character {
	private String playerName;
	protected Town currentTown ;
	private ArrayList<Card> currentCards;
	
	public void giveCard(Card card) {
		return;
	}
	public void foundVaccine(ArrayList<Card> cards) {
		return;
	}
	public void setPlayerName(String name) {
		this.playerName = name;
	}
	public void setCurrentTown(Town town) {
		
	}
	public ArrayList<Card> getCurrentCards(){
		return this.currentCards;
	}
	public void useCard(Card card) {
		
	}
	public void killVirus() {
		currentTown.addVirusAmount(-1);
	}
	public void buildStation() {
		Game.researchStation.add(this.currentTown);
	}
}
