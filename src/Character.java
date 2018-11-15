import java.util.ArrayList;

public class Character {
	private String playerName;
	protected Town currentTown ;
	private ArrayList<Card> currentCards;
	
	public void giveCard(Card card) {
		
	}
	public void foundVaccine(ArrayList<Card> cards) {
		
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
		
	}
}
