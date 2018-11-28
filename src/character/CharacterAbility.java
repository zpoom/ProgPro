package character;
import java.util.ArrayList;

import card.Card;
import town.Town;

public interface CharacterAbility {
	public void giveCard(Card card);
	public void foundVaccine(ArrayList<Card> cards);
	public void setPlayerName(String name);
	public void setCurrentTown(Town town);
	public ArrayList<Card> getCurrentCards();
	public void useCard(Card card);
	public void killVirus();
	public void buildStation();
	public void move(Town town);
}
