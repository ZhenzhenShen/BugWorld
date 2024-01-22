import javafx.scene.image.ImageView;

public class Sun {
	ImageView imageView;
	double x;
	double y;
	
	public Sun(double x, double y) {
		this.imageView = new ImageView("sun1.png");
		imageView.setFitWidth(180);
		imageView.setFitHeight(180);
		this.x = x;
		this.y = y;
	}
}
