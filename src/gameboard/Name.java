package gameboard;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Name extends StackPane {
	public Name(String name,int p) {
		LinearGradient gradient;
		if(p==1) {
			gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[] {
				new Stop(0,Color.RED),
				new Stop(0.1,Color.BLACK),
				new Stop(0.9,Color.BLACK),
				new Stop(1,Color.RED)
			});
		}
		else {
			gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, new Stop[] {
				new Stop(0,Color.WHITE),
				new Stop(0.1,Color.BLACK),
				new Stop(0.9,Color.BLACK),
				new Stop(1,Color.WHITE)
			});
		}
		Rectangle bg = new Rectangle(200,30);
		bg.setOpacity(0.4);
		
		Text text = new Text(name);
		if(p==1) text.setFill(Color.RED);
		else text.setFill(Color.WHITE);
		text.setFont(Font.font("", FontWeight.SEMI_BOLD,22));
		
		setAlignment(Pos.CENTER);
		getChildren().addAll(bg,text);
		
		setOnMouseEntered(event -> {
			bg.setFill(gradient);
			if(p==1) text.setFill(Color.WHITE);
			else text.setFill(Color.RED);
		});
		
		setOnMouseExited(event -> {
			bg.setFill(Color.BLACK);
			if(p==1) text.setFill(Color.RED);
			else text.setFill(Color.WHITE);
		});
		
		setOnMousePressed(event -> {
			bg.setFill(Color.DARKVIOLET);
		});
		
		setOnMouseReleased(event -> {
			bg.setFill(gradient);
		});
	}
}
