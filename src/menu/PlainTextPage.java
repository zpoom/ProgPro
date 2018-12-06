package menu;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlainTextPage extends StackPane {
		public PlainTextPage(String data) {
			Rectangle bg = new Rectangle(1000,500);
			bg.setFill(Color.BLACK);
			bg.setOpacity(0.8);
			
			Text text = new Text(data);
			text.setFont(Font.font("Papyrus", 20));
			text.setFill(Color.WHITE);
			
			setTranslateY(90);
			setPrefSize(1000, 500);
			setAlignment(Pos.CENTER);
			getChildren().addAll(bg,text);
		}
	}

