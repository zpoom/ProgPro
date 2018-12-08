package creatures;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import gameboard.Space;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Bigo extends Monster{
	public ImageView dragon;
	public Bigo(Space init) throws IOException {
		super(init);
		move = 1;
		InputStream BigO = Files.newInputStream(Paths.get("res/dragon.png"));
		Image enternamebg = new Image(BigO);
		BigO.close();
		dragon = new ImageView(enternamebg);
		dragon.setFitHeight(50);
		dragon.setFitWidth(50);
		
	}
}
