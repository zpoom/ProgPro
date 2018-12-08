package gameboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import creatures.Bigo;
import creatures.Bigpom;
import creatures.Bigtu;
import creatures.Boat;
import creatures.Meeple;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import player.Player;

public class Game {
	public HBox hSpace;
	public static VBox vSpace;
	public static Map<Space,Set<Space> > AllAdj;
	public Set<Space> tmp;
	public static int turn;
	public static int playerAmount;
	private ArrayList<Space> startTile;
	public static int step = -1;
	public Thread t;
	protected ArrayList<Meeple> player1 , player2;
	private ArrayList<Space> riverTile,allTile;
	public Game(int player,ArrayList<Player> players) throws IOException {
		// 1 = water , 2 = wild , 3 = sand , 4 = mountain
		turn = 1;
		step = 0;
		this.playerAmount = player;
		player1 = new ArrayList<Meeple>();
		player2 = new ArrayList<Meeple>();
		riverTile = new ArrayList<Space>();
		allTile = new ArrayList<Space>();
		Meeple m1 = new Meeple(1);
		Meeple m2 = new Meeple(1);
		Meeple m3 = new Meeple(1);
		Meeple m4 = new Meeple(1);
		Meeple m5 = new Meeple(1);
		Meeple m6 = new Meeple(1);
		Meeple m7 = new Meeple(1);
		Meeple m8 = new Meeple(1);
		Meeple m9 = new Meeple(1);
		Meeple m10 = new Meeple(1);
		player1.add(m1);
		player1.add(m2);
		player1.add(m3);
		player1.add(m4);
		player1.add(m5);
		player1.add(m6);
		player1.add(m7);
		player1.add(m8);
		player1.add(m9);
		player1.add(m10);
		
		Meeple m11 = new Meeple(2);
		Meeple m12= new Meeple(2);
		Meeple m13 = new Meeple(2);
		Meeple m14 = new Meeple(2);
		Meeple m15 = new Meeple(2);
		Meeple m16 = new Meeple(2);
		Meeple m17 = new Meeple(2);
		Meeple m18 = new Meeple(2);
		Meeple m19 = new Meeple(2);
		Meeple m20 = new Meeple(2);
		
		player2.add(m11);
		player2.add(m12);
		player2.add(m13);
		player2.add(m14);
		player2.add(m15);
		player2.add(m16);
		player2.add(m17);
		player2.add(m18);
		player2.add(m19);
		player2.add(m20);
		Space A1 = new Space(1);
		
		A1.addObject(new Bigo(A1));
		
		Space A2 = new Space(1);
		Space A3 = new Space(1);
		Space A4 = new Space(1);
		Space A5 = new Space(1);
		Space A6 = new Space(1);
		Space A7 = new Space(1);
		Space A8 = new Space(1);
		Space A9 = new Space(1);
		Space A10 = new Space(1);
		Space A11 = new Space(1);
		Space A12 = new Space(1);
		
		
		Space A13 = new Space(1);
		Space A14 = new Space(1);
		Space A15 = new Space(1);
		Space A16 = new Space(1);
		Space A17 = new Space(1);

		A17.addObject(new Bigo(A17));
		
		Space A18 = new Space(1);
		Space A19 = new Space(1);
		Space A20 = new Space(3);
		Space A21 = new Space(2);
		Space A22 = new Space(3);
		Space A23 = new Space(2);
		Space A24 = new Space(1);
		Space A25 = new Space(1);
		Space A26 = new Space(1);
		Space A27 = new Space(1);
		Space A28 = new Space(2);
		Space A29 = new Space(4);
		Space A30 = new Space(3);
		Space A31 = new Space(4);
		Space A32 = new Space(3);
		Space A33 = new Space(1);
		// 1 = water , 2 = wild , 3 = sand , 4 = mountain
		Space A34 = new Space(1);
		Space A35 = new Space(1);
		Space A36 = new Space(3);
		Space A37 = new Space(2);
		Space A38 = new Space(2);
		Space A39 = new Space(3);
		Space A40 = new Space(3);
		Space A41 = new Space(2);
		Space A42 = new Space(2);
		
		
		
		Space A43 = new Space(2);
		Space A44 = new Space(1);
		Space A45 = new Space(1);
		Space A46 = new Space(3);
		Space A47 = new Space(4);
		Space A48 = new Space(4);
		//test

		Space A49 = new Space(1);

		A49.addObject(new Bigo(A49));
		
		Space A50 = new Space(4);
		Space A51 = new Space(3);
		Space A52 = new Space(3);
		Space A53 = new Space(1);
		Space A54 = new Space(1);
		Space A55 = new Space(3);
		Space A56 = new Space(2);
		Space A57 = new Space(2);
		Space A58 = new Space(2);
		Space A59 = new Space(3);
		Space A60 = new Space(2);
		Space A61 = new Space(4);
		Space A62 = new Space(3);
		Space A63 = new Space(1);
		Space A64 = new Space(1);
		Space A65 = new Space(1);
		
		
		Space A66 = new Space(2);
		Space A67 = new Space(4);
		Space A68 = new Space(3);
		Space A69 = new Space(4);
		Space A70 = new Space(2);
		Space A71 = new Space(1);
		Space A72 = new Space(1);
		Space A73 = new Space(1);
		Space A74 = new Space(1);
		Space A75 = new Space(3);
		Space A76 = new Space(2);
		Space A77 = new Space(2);
		Space A78 = new Space(3);
		Space A79 = new Space(1);
		Space A80 = new Space(1);
		Space A81 = new Space(1);

		A81.addObject(new Bigo(A81));
		
		Space A82 = new Space(1);
		Space A83 = new Space(1);
		Space A84 = new Space(1);
		Space A85 = new Space(1);
		Space A86 = new Space(1);
	
		Space A87 = new Space(1);
		Space A88 = new Space(1);
	
		Space A89 = new Space(1);
		Space A90 = new Space(1);
		Space A91 = new Space(1);
		Space A92 = new Space(1);
		Space A93 = new Space(1);
		Space A94 = new Space(1);
		Space A95 = new Space(1);
		Space A96 = new Space(1);
		Space A97 = new Space(1);

		A97.addObject(new Bigo(A97));
		//new way to collect all adjacent  geb nai game tan la gun
		AllAdj = new HashMap<Space,Set<Space>>();
		
		tmp = new HashSet<Space>(Arrays.asList(A2,A9,A10)) ;
		AllAdj.put(A1,tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A1,A3,A10,A9,A11)) ;
		AllAdj.put(A2, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A2,A4,A11,A12)) ;
		AllAdj.put(A3, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A3,A12,A13,A5)) ;
		AllAdj.put(A4, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A4,A13,A14,A6)) ;
		AllAdj.put(A5, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A5,A14,A15,A7)) ;
		AllAdj.put(A6, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A6,A15,A16,A8)) ;
		AllAdj.put(A7, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A7,A16,A17)) ;
		AllAdj.put(A8, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A1,A10,A18)) ;
		AllAdj.put(A9, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A1,A2,A9,A11,A18,A19)) ;
		AllAdj.put(A10, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A2,A3,A10,A12,A19,A20)) ;
		AllAdj.put(A11, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A3,A4,A11,A13,A20,A21)) ;
		AllAdj.put(A12, tmp);


		tmp = new HashSet<Space>(Arrays.asList(A4,A5,A12,A14,A21,A22)) ;
		AllAdj.put(A13, tmp);

		tmp = new HashSet<Space>(Arrays.asList(A5,A6,A13,A15,A22,A23)) ;
		AllAdj.put(A14, tmp);

		tmp = new HashSet<Space>(Arrays.asList(A6,A7,A14,A16,A23,A24)) ;
		AllAdj.put(A15, tmp);

		tmp = new HashSet<Space>(Arrays.asList(A7,A8,A15,A17,A24,A25)) ;
		AllAdj.put(A16, tmp);

		tmp = new HashSet<Space>(Arrays.asList(A8,A16,A25)) ;
		AllAdj.put(A17, tmp);

		tmp = new HashSet<Space>(Arrays.asList(A9,A10,A19,A26,A27)) ;
		AllAdj.put(A18, tmp);

		tmp = new HashSet<Space>(Arrays.asList(A10,A11,A18,A20,A27,A28)) ;
		AllAdj.put(A19, tmp);

		tmp = new HashSet<Space>(Arrays.asList(A11,A12,A19,A21,A28,A29)) ;
		AllAdj.put(A20, tmp);

		tmp = new HashSet<Space>(Arrays.asList(A12,A13,A20,A22,A29,A30)) ;
		AllAdj.put(A21, tmp);

		tmp = new HashSet<Space>(Arrays.asList(A13,A14,A21,A23,A30,A31)) ;
		AllAdj.put(A22, tmp);

		tmp = new HashSet<Space>(Arrays.asList(A14,A15,A22,A24,A31,A32)) ;
		AllAdj.put(A23, tmp);

		tmp = new HashSet<Space>(Arrays.asList(A15,A16,A23,A25,A32,A33)) ;
		AllAdj.put(A24, tmp);

		tmp = new HashSet<Space>(Arrays.asList(A16,A17,A24,A33,A34)) ;
		AllAdj.put(A25, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A18,A27,A35,A36)) ;
		AllAdj.put(A26, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A18,A19,A26,A28,A36,A37)) ;
		AllAdj.put(A27, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A19,A20,A27,A29,A37,A38)) ;
		AllAdj.put(A28, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A20,A21,A28,A30,A38,A39)) ;
		AllAdj.put(A29, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A21,A22,A29,A31,A39,A40)) ;
		AllAdj.put(A30, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A22,A23,A30,A32,A40,A41)) ;
		AllAdj.put(A31, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A23,A24,A31,A33,A41,A42)) ;
		AllAdj.put(A32, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A24,A25,A32,A34,A42,A43)) ;
		AllAdj.put(A33, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A25,A33,A43,A44)) ;
		AllAdj.put(A34, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A26,A36,A45)) ;
		AllAdj.put(A35, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A26,A27,A35,A37,A45,A46)) ;
		AllAdj.put(A36, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A27,A28,A36,A38,A46,A47)) ;
		AllAdj.put(A37, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A28,A29,A37,A39,A47,A48)) ;
		AllAdj.put(A38, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A29,A30,A38,A40,A48,A49)) ;
		AllAdj.put(A39, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A30,A31,A39,A41,A49,A50)) ;
		AllAdj.put(A40, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A31,A32,A40,A42,A50,A51)) ;
		AllAdj.put(A41, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A32,A33,A41,A43,A51,A52)) ;
		AllAdj.put(A42, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A33,A34,A42,A44,A52,A53)) ;
		AllAdj.put(A43, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A34,A43,A53)) ;
		AllAdj.put(A44, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A35,A36,A46,A54,A55)) ;
		AllAdj.put(A45, tmp);
		
		
		tmp = new HashSet<Space>(Arrays.asList(A36,A37,A45,A47,A55,A56)) ;
		AllAdj.put(A46, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A37,A38,A46,A48,A56,A57)) ;
		AllAdj.put(A47, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A38,A39,A47,A49,A57,A58)) ;
		AllAdj.put(A48, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A48,A39,A40,A50,A59,A58)) ;
		AllAdj.put(A49, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A51,A49,A40,A41,A59,A60)) ;
		AllAdj.put(A50, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A50,A41,A42,A52,A60,A61)) ;
		AllAdj.put(A51, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A51,A42,A43,A53,A61,A62)) ;
		AllAdj.put(A52, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A52,A43,A44,A62,A63)) ;
		AllAdj.put(A53, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A45,A55,A64)) ;
		AllAdj.put(A54, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A45,A46,A54,A56,A64,A65)) ;
		AllAdj.put(A55, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A55,A46,A47,A57,A65,A66)) ;
		AllAdj.put(A56, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A56,A47,A48,A58,A66,A67)) ;
		AllAdj.put(A57, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A57,A48,A49,A67,A68,A59)) ;
		AllAdj.put(A58, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A58,A49,A50,A60,A69,A68)) ;
		AllAdj.put(A59, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A59,A50,A51,A61,A69,A70)) ;
		AllAdj.put(A60, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A60,A51,A52,A62,A70,A71)) ;
		AllAdj.put(A61, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A61,A52,A53,A63,A71,A72)) ;
		AllAdj.put(A62, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A62,A53,A72)) ;
		AllAdj.put(A63, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A54,A55,A65,A73)) ;
		AllAdj.put(A64, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A64,A55,A56,A66,A73,A74)) ;
		AllAdj.put(A65, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A65,A56,A57,A67,A74,A75)) ;
		AllAdj.put(A66, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A66,A57,A58,A68,A75,A76)) ;
		AllAdj.put(A67, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A67,A58,A59,A69,A76,A77)) ;
		AllAdj.put(A68, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A68,A59,A60,A70,A77,A78)) ;
		AllAdj.put(A69, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A69,A60,A61,A71,A78,A79)) ;
		AllAdj.put(A70, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A70,A61,A62,A72,A79,A80)) ;
		AllAdj.put(A71, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A71,A62,A63,A80)) ;
		AllAdj.put(A72, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A81,A64,A65,A74,A82)) ;
		AllAdj.put(A73, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A73,A65,A66,A75,A82,A83)) ;
		AllAdj.put(A74, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A74,A66,A67,A76,A83,A84)) ;
		AllAdj.put(A75, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A75,A67,A68,A77,A84,A85)) ;
		AllAdj.put(A76, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A76,A68,A69,A78,A85,A86)) ;
		AllAdj.put(A77, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A77,A69,A70,A79,A86,A87)) ;
		AllAdj.put(A78, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A78,A70,A71,A80,A87,A88)) ;
		AllAdj.put(A79, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A79,A71,A72,A89,A88)) ;
		AllAdj.put(A80, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A73,A82,A90)) ;
		AllAdj.put(A81, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A81,A73,A74,A90,A83,A91)) ;
		AllAdj.put(A82, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A82,A74,A75,A84,A91,A92)) ;
		AllAdj.put(A83, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A83,A75,A76,A85,A92,A93)) ;
		AllAdj.put(A84, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A84,A76,A77,A86,A93,A94)) ;
		AllAdj.put(A85, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A85,A77,A78,A87,A94,A95)) ;
		AllAdj.put(A86, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A86,A78,A79,A88,A95,A96)) ;
		AllAdj.put(A87, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A87,A79,A80,A89,A96,A97)) ;
		AllAdj.put(A88, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A88,A80,A97)) ;
		AllAdj.put(A89, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A81,A82,A91)) ;
		AllAdj.put(A90, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A90,A82,A83,A92)) ;
		AllAdj.put(A91, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A91,A83,A84,A93)) ;
		AllAdj.put(A92, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A92,A84,A85,A94)) ;
		AllAdj.put(A93, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A93,A85,A86,A95)) ;
		AllAdj.put(A94, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A94,A86,A87,A96)) ;
		AllAdj.put(A95, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A95,A87,A88,A97)) ;
		AllAdj.put(A96, tmp);
		
		tmp = new HashSet<Space>(Arrays.asList(A96,A88,A89)) ;
		AllAdj.put(A97, tmp);
		
		
		//HBox temp = new HBox();
		//temp.getChildren().addAll(A54,A55,A56,A57,A58,A59,A60,A61,A62,A63);
		//hSpace.add(new HBox(A54,A55,A56,A57,A58,A59,A60,A61,A62,A63));
		/*
		temp = new HBox();
		temp.getChildren().addAll(A64,A65,A66,A67,A68,A69,A70,A71,A72);
		hSpace.add(temp);
		
		temp = new HBox();
		temp.getChildren().addAll(A73,A74,A75,A76,A77,A78,A79,A80);
		hSpace.add(temp);
		
		temp = new HBox();
		temp.getChildren().addAll(A81,A82,A83,A84,A85,A86,A87,A88,A89);
		hSpace.add(temp);
		
		temp = new HBox();
		temp.getChildren().addAll(A90,A91,A92,A93,A94,A95,A96,A97);
		hSpace.add(temp);*/
		double offY = Space.x/2;
		hSpace = new HBox();
		hSpace.getChildren().addAll(A1,A2,A3,A4,A5,A6,A7,A8);
		hSpace.setTranslateX(Space.x*Math.sqrt(3));
		vSpace = new VBox();
		vSpace.getChildren().addAll(hSpace);
		
		hSpace = new HBox();
		hSpace.getChildren().addAll(A9,A10,A11,A12,A13,A14,A15,A16,A17);
		hSpace.setTranslateX(Space.x*Math.sqrt(3)/2);
		hSpace.setTranslateY(-offY);
		vSpace.getChildren().addAll(hSpace);
		
		hSpace = new HBox();
		hSpace.getChildren().addAll(A18,A19,A20,A21,A22,A23,A24,A25);
		hSpace.setTranslateX(Space.x*Math.sqrt(3));
		hSpace.setTranslateY(-offY*2);
		vSpace.getChildren().addAll(hSpace);
		
		hSpace = new HBox();
		hSpace.getChildren().addAll(A26,A27,A28,A29,A30,A31,A32,A33,A34);
		hSpace.setTranslateX(Space.x*Math.sqrt(3)/2);
		hSpace.setTranslateY(-offY*3);
		vSpace.getChildren().addAll(hSpace);
		
		hSpace = new HBox();
		hSpace.getChildren().addAll(A35,A36,A37,A38,A39,A40,A41,A42,A43,A44);
		hSpace.setTranslateY(-offY*4);
		vSpace.getChildren().addAll(hSpace);
		
		hSpace = new HBox();
		hSpace.getChildren().addAll(A45,A46,A47,A48,A49,A50,A51,A52,A53);
		hSpace.setTranslateX(Space.x*Math.sqrt(3)/2);
		hSpace.setTranslateY(-offY*5);
		vSpace.getChildren().addAll(hSpace);
		
		hSpace = new HBox();
		hSpace.getChildren().addAll(A54,A55,A56,A57,A58,A59,A60,A61,A62,A63);
		hSpace.setTranslateY(-offY*6);
		vSpace.getChildren().addAll(hSpace);
		
		hSpace = new HBox();
		hSpace.getChildren().addAll(A64,A65,A66,A67,A68,A69,A70,A71,A72);
		hSpace.setTranslateX(Space.x*Math.sqrt(3)/2);
		hSpace.setTranslateY(-offY*7);
		vSpace.getChildren().addAll(hSpace);
		
		hSpace = new HBox();
		hSpace.getChildren().addAll(A73,A74,A75,A76,A77,A78,A79,A80);
		hSpace.setTranslateY(-offY*8);
		hSpace.setTranslateX(Space.x*Math.sqrt(3));
		vSpace.getChildren().addAll(hSpace);
		
		hSpace = new HBox();
		hSpace.getChildren().addAll(A81,A82,A83,A84,A85,A86,A87,A88,A89);
		hSpace.setTranslateX(Space.x*Math.sqrt(3)/2);
		hSpace.setTranslateY(-offY*9);
		vSpace.getChildren().addAll(hSpace);
		
		hSpace = new HBox();
		hSpace.getChildren().addAll(A90,A91,A92,A93,A94,A95,A96,A97);
		hSpace.setTranslateY(-offY*10);
		hSpace.setTranslateX(Space.x*Math.sqrt(3));
		vSpace.getChildren().addAll(hSpace);
		
		startTile = new ArrayList<Space>();
		
		
		startTile.add(A20);
		startTile.add(A21);
		startTile.add(A22);
		startTile.add(A23);
		startTile.add(A28);
		startTile.add(A29);
		startTile.add(A30);
		startTile.add(A31);
		startTile.add(A32);
		startTile.add(A36);
		startTile.add(A37);
		startTile.add(A38);
		startTile.add(A39);
		startTile.add(A40);
		startTile.add(A41);
		startTile.add(A42);
		startTile.add(A43);
		startTile.add(A46);
		startTile.add(A47);
		startTile.add(A48);
		startTile.add(A50);
		startTile.add(A51);
		startTile.add(A52);
		startTile.add(A55);
		startTile.add(A56);
		startTile.add(A57);
		startTile.add(A58);
		startTile.add(A59);
		startTile.add(A60);
		startTile.add(A61);
		startTile.add(A62);
		startTile.add(A66);
		startTile.add(A67);
		startTile.add(A68);
		startTile.add(A69);
		startTile.add(A70);
		startTile.add(A75);
		startTile.add(A76);
		startTile.add(A77);
		startTile.add(A78);
		
		riverTile.add(A1);
		riverTile.add(A2);
		riverTile.add(A3);
		riverTile.add(A4);
		riverTile.add(A5);
		riverTile.add(A6);
		riverTile.add(A7);
		riverTile.add(A8);
		riverTile.add(A9);
		riverTile.add(A10);
		riverTile.add(A11);
		riverTile.add(A12);
		riverTile.add(A13);
		riverTile.add(A14);
		riverTile.add(A15);
		riverTile.add(A16);
		riverTile.add(A17);
		riverTile.add(A18);
		riverTile.add(A19);
		riverTile.add(A24);
		riverTile.add(A25);
		riverTile.add(A26);
		riverTile.add(A27);
		riverTile.add(A33);
		riverTile.add(A34);
		riverTile.add(A35);
		riverTile.add(A44);
		riverTile.add(A45);
		riverTile.add(A53);
		riverTile.add(A54);
		riverTile.add(A63);
		riverTile.add(A64);
		riverTile.add(A65);
		riverTile.add(A49);
		riverTile.add(A71);
		riverTile.add(A72);
		riverTile.add(A73);
		riverTile.add(A74);
		riverTile.add(A79);
		riverTile.add(A80);
		riverTile.add(A81);
		riverTile.add(A82);
		riverTile.add(A83);
		riverTile.add(A84);
		riverTile.add(A85);
		riverTile.add(A86);
		riverTile.add(A87);
		riverTile.add(A88);
		riverTile.add(A89);
		riverTile.add(A90);
		riverTile.add(A91);
		riverTile.add(A92);
		riverTile.add(A93);
		riverTile.add(A94);
		riverTile.add(A95);
		riverTile.add(A96);
		riverTile.add(A97);
		riverTile.add(A86);
		allTile.addAll(riverTile);
		allTile.addAll(startTile);
	}
	public void randomPosition1() throws IOException {
		
		ArrayList<Space> temp = new ArrayList<Space>();
		temp.addAll(startTile);
		for(int i = 0 ; i< 10;i++) {
			Random rd = new Random();
			int idx = rd.nextInt(temp.size());
			temp.get(idx).addObject(player1.get(i));
			player1.get(i).setInit(temp.get(idx));
		}
		
	}
	public void randomPosition2() throws IOException {
		
		ArrayList<Space> temp = new ArrayList<Space>();
		temp.addAll(startTile);
		for(int i = 0 ; i< 10;i++) {
			Random rd = new Random();
			int idx = rd.nextInt(temp.size());
			temp.get(idx).addObject(player2.get(i));
			player2.get(i).setInit(temp.get(idx));
		}
		
	}
	public void start() {
		  t = new Thread(() -> {
			clearAllSpace();
			try {
				showMoveable();
				Thread.sleep(30000);
			} catch (InterruptedException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			clearAllSpace();
			try {
				showMoveable();
				Thread.sleep(30000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				
			}
			clearAllSpace();
			try {
				showMoveable();
				Thread.sleep(30000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			clearAllSpace();
			try {
				// Phase 2  destroy island
				Showdestroyable();
				Thread.sleep(300000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				moveMonster();
				Thread.sleep(300000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t.start();
	}
	public void clearAllSpace() {
		for(Space x : allTile) {
			x.bg.setStroke(Color.BLACK);
			x.setOnMouseClicked(event -> {});
		}
	}
	public void Showdestroyable() {
		boolean isAdjWater = false;
		if(Game.turn %2 == 1) {
		if(Game.turn<=16) {
			for(Space space : startTile) {
				if(space.type == 3) {
					for(Space sp : Game.AllAdj.get(space)) {
						if(sp.type==1) {
							space.bg.setStroke(Color.RED);
							space.setOnMouseClicked(evt -> {
								clearAllSpace();
								space.type = 1;
							
									try {
										space.update();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								
								space.eff.effect(3);
								t.interrupt();
							});
						break;
					}
				}
			}
			}
		}
		else if(Game.turn<=32) {
			for(Space space : startTile) {
				if(space.type == 2) {
					for(Space sp : Game.AllAdj.get(space)) {
						if(sp.type==1) {
							space.bg.setStroke(Color.RED);
							space.setOnMouseClicked(evt -> {
								clearAllSpace();
								space.type = 1;
							
									try {
										space.update();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								
								space.eff.effect(2);
								t.interrupt();
							});
						break;
					}
				}
			}
			}
		}
		else {
			for(Space space : startTile) {
				if(space.type == 4) {
					for(Space sp : Game.AllAdj.get(space)) {
						if(sp.type==1) {
							space.bg.setStroke(Color.RED);
							space.setOnMouseClicked(evt -> {
								clearAllSpace();
								space.type = 1;
							
									try {
										space.update();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								
								space.eff.effect(4);
								t.interrupt();
							});
						break;
					}
				}
			}
			}
		}
		}
		else {
			if(Game.turn<=16) {
				for(Space space : startTile) {
					if(space.type == 3) {
						for(Space sp : Game.AllAdj.get(space)) {
							if(sp.type==1) {
								space.bg.setStroke(Color.WHITE);
								space.setOnMouseClicked(evt -> {
									clearAllSpace();
									space.type = 1;
								
										try {
											space.update();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									
									space.eff.effect(3);
									t.interrupt();
								});
							break;
						}
					}
				}
				}
			}
			else if(Game.turn<=32) {
				for(Space space : startTile) {
					if(space.type == 2) {
						for(Space sp : Game.AllAdj.get(space)) {
							if(sp.type==1) {
								space.bg.setStroke(Color.WHITE);
								space.setOnMouseClicked(evt -> {
									clearAllSpace();
									space.type = 1;
								
										try {
											space.update();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									
									space.eff.effect(2);
									t.interrupt();
								});
							break;
						}
					}
				}
				}
			}
			else {
				for(Space space : startTile) {
					if(space.type == 4) {
						for(Space sp : Game.AllAdj.get(space)) {
							if(sp.type==1) {
								space.bg.setStroke(Color.WHITE);
								space.setOnMouseClicked(evt -> {
									clearAllSpace();
									space.type = 1;
								
										try {
											space.update();
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									
									space.eff.effect(4);
									t.interrupt();
								});
							break;
						}
					}
				}
				}
			}
			
			
		}
	}
	public void showMoveable() throws InterruptedException {
		if(Game.turn % 2 == 1) {
			// p1 turn
			for(Space space : allTile) {
				if(space.n1 > 0 || (space.n1 >= space.n2 && space.boat!=null)) {
					space.bg.setStroke(Color.RED);
					space.setOnMouseClicked(event -> {
						clearAllSpace();
						for(Space sp : Game.AllAdj.get(space)) {
							sp.bg.setStroke(Color.RED);
							sp.setOnMouseClicked(evt -> {
								clearAllSpace();
								// move to sp
								if(space.boat!=null) {
									// move boat
									try {
										space.boat.moveTo(sp);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								else {
									try {
										space.p1.get(0).moveTo(sp);
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										
									}
								}
								t.interrupt();
							});
						}
					});
				}
			}
		}
		else {
			// p2 turn
		}
	}
	public void randomPositionBoat() throws IOException{
		ArrayList<Space> temp = new ArrayList<Space>();
		temp.addAll(riverTile);
		int x = 0;
		while(x!=5) {
			Random rd = new Random();
			int idx = rd.nextInt(temp.size());
			if(temp.get(idx).boat != null) continue;
			temp.get(idx).addObject(new Boat(temp.get(idx)));
			x++;
		}
	}
	public void moveMonster() {
		clearAllSpace();
		if(Game.turn % 2 == 1) {
			for(Space space : allTile) {
				if(space.bigO || space.pom || space.tu) {
					boolean hasAdj = false;
					for(Space sp : Game.AllAdj.get(space)) {
						if(sp.type == 1 && (!sp.bigO && !sp.pom && !sp.tu)) {
							hasAdj = true;
						}
					}
					if(hasAdj) {
					space.bg.setStroke(Color.RED);
					space.setOnMouseClicked(event -> {
						clearAllSpace();
						for(Space sp : Game.AllAdj.get(space)) {
							if((!(sp.bigO || sp.pom || sp.tu)) && sp.type==1) {
								sp.bg.setStroke(Color.RED);
								sp.setOnMouseClicked(evt -> {
									clearAllSpace();
									if(space.bigO) {
										try {
											space.deleteObject(new Bigo(space));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										try {
											sp.addObject(new Bigo(sp));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									else if(space.pom) {
										try {
											space.deleteObject(new Bigpom(space));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										try {
											sp.addObject(new Bigpom(sp));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									else if(space.tu) {
										try {
											space.deleteObject(new Bigtu(space));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										try {
											sp.addObject(new Bigtu(sp));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								});
							}
							
						}
					});
				}
				}
			}
		}
		else {
			for(Space space : allTile) {
				if(space.bigO || space.pom || space.tu) {
					boolean hasAdj = false;
					for(Space sp : Game.AllAdj.get(space)) {
						if(sp.type == 1 && (!sp.bigO && !sp.pom && !sp.tu)) {
							hasAdj = true;
						}
					}
					if(hasAdj) {
					space.bg.setStroke(Color.WHITE);
					space.setOnMouseClicked(event -> {
						clearAllSpace();
						for(Space sp : Game.AllAdj.get(space)) {
							if((!(sp.bigO || sp.pom || sp.tu)) && sp.type==1) {
								sp.bg.setStroke(Color.WHITE);
								sp.setOnMouseClicked(evt -> {
									clearAllSpace();
									if(space.bigO) {
										try {
											space.deleteObject(new Bigo(space));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										try {
											sp.addObject(new Bigo(sp));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									else if(space.pom) {
										try {
											space.deleteObject(new Bigpom(space));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										try {
											sp.addObject(new Bigpom(sp));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									else if(space.tu) {
										try {
											space.deleteObject(new Bigtu(space));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										try {
											sp.addObject(new Bigtu(sp));
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								});
							}
							
						}
					});
				}
				}
			}
		}
	}
}
