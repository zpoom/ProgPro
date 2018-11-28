package character;
import main.Game;
import town.Town;
public class Medic extends Character implements CharacterAbility {
	@Override
	public void killVirus() {
		currentTown.setVirusAmount(0);
	}
	@Override
	public void move(Town town) {
		super.move(town);
		if(currentTown.getColor() == 1) {
			if(Game.isFoundBlueVaccine) {
				killVirus();
			}
		}
		else if(currentTown.getColor() == 2) {
			if(Game.isFoundYellowVaccine) {
				killVirus();
			}
		}
		else if(currentTown.getColor() == 3) {
			if(Game.isFoundBlackVaccine) {
				killVirus();
			}
		}
		else if(currentTown.getColor() == 4) {
			if(Game.isFoundRedVaccine) {
				killVirus();
			}
		}
	}
}
