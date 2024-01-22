package plant;

import javafx.scene.image.ImageView;

public class Flower extends Plant{

	public Flower(double x, double y) {
		super("Flower",150,150,new ImageView("flower6.png"), x, y, 0.01,500,5);

	}
}
