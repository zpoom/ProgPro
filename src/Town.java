import java.util.ArrayList;

public class Town {
	private String name;
	private int color;
	// 1 = Blue ; 2 = Yellow ; 3 = Black; 4 = Red;
	private ArrayList<Town> adjacentTowns;
	private int virusAmount;
	public boolean isReseachStationHere;
	Town(String name, int color){
		this.name = name;
		this.color = color;
		virusAmount = 0;
	}
	public int getVirusAmount() {
		return virusAmount;
	}
	public void setVirusAmount(int c) {
		if(c>3) {
			this.virusAmount = 3;
		}
		this.virusAmount = c;
	}
	public int addVirusAmount(int c) {
		int outbreakmove = 0;
		if(c+this.virusAmount>3) {
			this.virusAmount = 3;
			outbreakmove = outBreak();
			return outbreakmove ;
			//return number of outbreak 
		}
		this.virusAmount = this.virusAmount + c;
		return 0;
	}
	
	public int outBreak() {
		int outbreakcount = 1;
		for(int i = 0; i<adjacentTowns.size();i++) {
			outbreakcount+=(adjacentTowns.get(i).addVirusAmount(1));
		}
		return outbreakcount;
	}
	
	public void setAdjacentTown(ArrayList<Town> towns){
		this.adjacentTowns = towns;  
	}
	public void addAdjacentTown(Town town) {
		adjacentTowns.add(town);
		//when u build a research station
		// may be we won't use this method because 
		// we add research station to Game.researchStation |ping->"Agreed"
	}
	public ArrayList<Town> getAdjacentTown(){
		return this.adjacentTowns;
	}
}
