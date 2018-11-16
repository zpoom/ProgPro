import java.util.ArrayList;

public class Game {
	public static int redVirus;
	public static int blueVirus;
	public static int blackVirus;
	public static int yellowVirus;
	public static ArrayList<Town> researchStation;
	
	public Game() {
		Game.blackVirus = 24;
		Game.blueVirus = 24;
		Game.redVirus = 24;
		Game.yellowVirus = 24;
		researchStation = new ArrayList<Town>();
	}
}
