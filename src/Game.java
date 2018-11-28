import java.util.ArrayList;

public class Game {
	public static int redVirus;
	public static int blueVirus;
	public static int blackVirus;
	public static int yellowVirus;
	public static ArrayList<Town> researchStation;
	public static Town Bu1,Bu2,Bu3,Bu4,Bu5,Bu6,Bu7,Bu8,Bu9,Bu10,Bu11,Bu12,Bu13,Ye1,Ye2,Ye3,Ye4,Ye5,Ye6,
						Ye7,Ye8,Ye9,Ye10,Ye11,Ye12,Ye13,Bk1,Bk2,Bk3,Bk4,Bk5,Bk6,Bk7,Bk8,Bk9,Bk10,Bk11,Bk12,Bk13
						,Rd1,Rd2,Rd3,Rd4,Rd5,Rd6,Rd7,Rd8,Rd9,Rd10,Rd11,Rd12,Rd13;
	public Game() {
		Game.blackVirus = 24;
		Game.blueVirus = 24;
		Game.redVirus = 24;
		Game.yellowVirus = 24;
		researchStation = new ArrayList<Town>();
		// 1 = Blue ; 2 = Yellow ; 3 = Black; 4 = Red;
		Town Bu1 = new Town("Blue1",1);
		Town Bu2 = new Town("Blue2",1);
		Town Bu3 = new Town("Blue3",1);
		Town Bu4 = new Town("Blue4",1);
		Town Bu5 = new Town("Blue5",1);
		Town Bu6 = new Town("Blue6",1);
		Town Bu7 = new Town("Blue7",1);
		Town Bu8 = new Town("Blue8",1);
		Town Bu9 = new Town("Blue9",1);
		Town Bu10 = new Town("Blue10",1);
		Town Bu11 = new Town("Blue11",1);
		Town Bu12 = new Town("Blue12",1);
		Town Bu13 = new Town("Blue13",1);
		//next is yellow
		Town Ye1 = new Town("Yellow1",2);
		Town Ye2 = new Town("Yellow2",2);
		Town Ye3 = new Town("Yellow3",2);
		Town Ye4 = new Town("Yellow4",2);
		Town Ye5 = new Town("Yellow5",2);
		Town Ye6 = new Town("Yellow6",2);
		Town Ye7 = new Town("Yellow7",2);
		Town Ye8 = new Town("Yellow8",2);
		Town Ye9 = new Town("Yellow9",2);
		Town Ye10 = new Town("Yellow10",2);
		Town Ye11 = new Town("Yellow11",2);
		Town Ye12= new Town("Yellow12",2);
		Town Ye13 = new Town("Yellow13",2);
		//next is Black
		Town Bk1 = new Town("Black1",3);
		Town Bk2 = new Town("Black2",3);
		Town Bk3 = new Town("Black3",3);
		Town Bk4 = new Town("Black4",3);
		Town Bk5 = new Town("Black5",3);
		Town Bk6 = new Town("Black6",3);
		Town Bk7 = new Town("Black7",3);
		Town Bk8 = new Town("Black8",3);
		Town Bk9 = new Town("Black9",3);
		Town Bk10 = new Town("Blac10",3);
		Town Bk11 = new Town("Black11",3);
		Town Bk12 = new Town("Black12",3);
		Town Bk13 = new Town("Black13",3);
		//last is red
		Town Rd1 = new Town("Red1",4);
		Town Rd2 = new Town("Red2",4);
		Town Rd3 = new Town("Red3",4);
		Town Rd4 = new Town("Red4",4);
		Town Rd5 = new Town("Red5",4);
		Town Rd6 = new Town("Red6",4);
		Town Rd7 = new Town("Red7",4);
		Town Rd8 = new Town("Red8",4);
		Town Rd9 = new Town("Red9",4);
		Town Rd10 = new Town("Red10",4);
		Town Rd11 = new Town("Red11",4);
		Town Rd12 = new Town("Red12",4);
		Town Rd13 = new Town("Red13",4);
		//add adjacent Town for each town;
		//Bu1.setAdjacentTown([Bu2,Bu3]); 
		//I can not set any AdjacentTown
		//hope u can fix it
		
	}
}
