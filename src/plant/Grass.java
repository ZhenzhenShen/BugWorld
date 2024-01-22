package plant;

import javafx.scene.image.ImageView;

public class Grass extends Plant {

	public Grass(double x, double y) {
		super("Grass",200,100,new ImageView("grass1.png"), x, y, 0.02,300,5);

	}
}
