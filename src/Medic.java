
public class Medic extends Character {
	@Override
	public void killVirus() {
		currentTown.setVirusAmount(0);
	}
}
