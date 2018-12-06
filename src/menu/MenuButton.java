package menu;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MenuButton extends StackPane {
	private Text text;
	public Rectangle bg;
	public MenuButton(String name) {
		text = new Text(name);
		text.getFont();
		text.setFont(Font.font("Papyrus",25));
		text.setFill(Color.WHITE);
		text.setTranslateX(20);
		text.setTranslateY(4);
		
		bg = new Rectangle(250,30);
		bg.setOpacity(0.6);
		bg.setFill(Color.BLACK);
		bg.setEffect(new GaussianBlur(5));
		
		
		this.setOnMouseEntered(event -> {
			bg.setTranslateX(10);
			bg.setFill(Color.WHITE);
			text.setFill(Color.BLACK);
		});
		
		this.setOnMouseExited(event -> {
			bg.setTranslateX(0);
			bg.setFill(Color.BLACK);
			text.setFill(Color.WHITE);
		});
		
		DropShadow drop = new DropShadow(50, Color.WHITE);
		drop.setInput(new Glow());
		
		this.setOnMousePressed(event -> setEffect(drop));
		this.setOnMouseReleased(event -> setEffect(null));
		setAlignment(Pos.CENTER_LEFT);
		setRotate(-0.5);
		getChildren().addAll(bg,text);
	}
}
