package gameboard;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.layout.VBox;

public class Game {
	public VBox vBoxTest;
	public Game() {
		// 1 = water , 2 = wild , 3 = sand , 4 = mountain
		ArrayList<Space> tmp;
		Space A1 = new Space(1);
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
		Space A50 = new Space(1);
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
		Space A98 = new Space(1);
		Space A99 = new Space(1);

		tmp = (ArrayList<Space>) Arrays.asList(A2,A9,A10);
		A1.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A1,A3,A10,A9,A11);
		A2.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A2,A4,A11,A12);
		A3.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A3,A12,A13,A5);
		A4.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A4,A13,A14,A6);
		A5.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A5,A14,A15,A7);
		A6.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A6,A15,A16,A8);
		A7.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A7,A16,A17);
		A8.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A1,A10,A18);
		A9.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A1,A2,A9,A11,A18,A19);
		A10.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A2,A3,A10,A12,A19,A20);
		A11.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A3,A4,A11,A13,A20,A21);
		A12.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A4,A5,A12,A14,A21,A22);
		A13.addAdjacentSpace(tmp);

		tmp = (ArrayList<Space>) Arrays.asList(A5,A6,A13,A15,A22,A23);
		A14.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A6,A7,A14,A16,A23,A24);
		A15.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A7,A8,A15,A17,A24,A25);
		A16.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A8,A16,A25);
		A17.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A9,A10,A19,A26,A27);
		A18.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A10,A11,A18,A20,A27,A28);
		A19.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A11,A12,A19,A21,A28,A29);
		A20.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A12,A13,A20,A22,A29,A30);
		A21.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A13,A14,A21,A23,A30,A31);
		A22.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A14,A15,A22,A24,A31,A32);
		A23.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A15,A16,A23,A25,A32,A33);
		A24.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A16,A17,A24,A33,A34);
		A25.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A18,A27,A35,A36);
		A26.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A18,A19,A26,A28,A36,A37);
		A27.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A19,A20,A27,A29,A37,A38);
		A28.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A20,A21,A28,A30,A38,A39);
		A29.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A21,A22,A29,A31,A39,A40);
		A30.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A22,A23,A30,A32,A40,A41);
		A31.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A23,A24,A31,A33,A41,A42);
		A32.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A24,A25,A32,A34,A42,A43);
		A33.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A25,A33,A43,A44);
		A34.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A26,A36,A45);
		A35.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A26,A27,A35,A37,A45,A46);
		A36.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A27,A28,A36,A38,A46,A47);
		A37.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A28,A29,A37,A39,A47,A48);
		A38.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A29,A30,A38,A40,A48,A49);
		A39.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A30,A31,A39,A41,A49,A50);
		A40.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A31,A32,A40,A42,A50,A51);
		A41.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A32,A33,A41,A43,A51,A52);
		A42.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A33,A34,A42,A44,A52,A53);
		A43.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A34,A43,A53);
		A44.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A35,A36,A46,A54,A55);
		A45.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A36,A37,A45,A47,A55,A56);
		A46.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A37,A38,A46,A48,A56,A57);
		A47.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A38,A39,A47,A49,A57,A58);
		A48.addAdjacentSpace(tmp);
				
		//FIRST PART DONE
		tmp = (ArrayList<Space>) Arrays.asList(A48,A39,A40,A50,A59,A58);
		A49.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A51,A49,A40,A41,A59,A60);
		A50.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A50,A41,A42,A52,A60,A61);
		A51.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A51,A42,A43,A53,A61,A62);
		A52.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A52,A43,A44,A62,A63);
		A53.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A45,A55,A64);
		A54.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A45,A46,A54,A56,A64,A65);
		A55.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A55,A46,A47,A57,A65,A66);
		A56.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A56,A47,A48,A58,A66,A67);
		A57.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A57,A48,A49,A67,A58,A59);
		A58.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A58,A49,A50,A60,A69,A68);
		A59.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A59,A50,A51,A61,A69,A70);
		A60.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A60,A51,A52,A62,A70,A71);
		A61.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A61,A52,A53,A63,A71,A72);
		A62.addAdjacentSpace(tmp);

		tmp = (ArrayList<Space>) Arrays.asList(A62,A53,A72);
		A63.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A54,A55,A65,A73);
		A64.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A64,A55,A56,A66,A73,A74);
		A65.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A65,A56,A57,A67,A74,A75);
		A66.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A66,A57,A58,A68,A75,A76);
		A67.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A67,A58,A59,A69,A76,A77);
		A68.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>)Arrays.asList(A68,A59,A60,A70,A77,A78);
		A69.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A69,A60,A61,A71,A78,A79);
		A70.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A70,A61,A62,A72,A79,A80);
		A71.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A71,A62,A63,A80);
		A72.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A81,A64,A65,A74,A82);
		A73.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A73,A65,A66,A75,A82,A83);
		A74.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A74,A66,A67,A76,A83,A84);
		A75.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A75,A67,A68,A77,A84,A85);
		A76.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A76,A68,A69,A78,A85,A86);
		A77.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A77,A69,A70,A79,A86,A87);
		A78.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A78,A70,A71,A80,A87,A88);
		A79.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A79,A71,A72,A89,A88);
		A80.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A73,A82,A90);
		A81.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A81,A73,A74,A90,A83,A91);
		A82.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A82,A74,A75,A84,A91,A92);
		A83.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A83,A75,A76,A85,A92,A93);
		A84.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A84,A76,A77,A86,A93,A94);
		A85.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A85,A77,A78,A87,A94,A95);
		A86.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A86,A78,A79,A88,A95,A96);
		A87.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A87,A79,A80,A89,A96,A97);
		A88.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A88,A80,A97);
		A89.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A81,A82,A91);
		A90.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A90,A82,A83,A92);
		A91.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A91,A83,A84,A93);
		A92.addAdjacentSpace(tmp);

		tmp = (ArrayList<Space>) Arrays.asList(A92,A84,A85,A94);
		A93.addAdjacentSpace(tmp);
		
		tmp =(ArrayList<Space>)  Arrays.asList(A93,A85,A86,A95);
		A94.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A94,A86,A87,A96);
		A95.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A95,A87,A88,A97);
		A96.addAdjacentSpace(tmp);
		
		tmp = (ArrayList<Space>) Arrays.asList(A96,A98,A99);
		A97.addAdjacentSpace(tmp);
		
		//test ping
		vBoxTest.getChildren().addAll(A47,A49,A50,A80,A92,A98,A99);
	}
}
