import java.util.ArrayList;

public interface CharacterAbility {
	public void giveCard();
	public void foundVaccine();
	public void setPlayerName(String name);
	public void setCurrentTown(Town town);
	public ArrayList<Card> getCurrentCards();
	public void useCard(Card card);
	public void killVirus();
	public void buildStation();
}
