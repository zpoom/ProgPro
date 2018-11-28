package character;

public class Medic extends Character implements CharacterAbility {
	@Override
	public void killVirus() {
		currentTown.setVirusAmount(0);
	}
}
