package plant;

import javafx.scene.image.ImageView;

public class Plant{

	String name;
	public double width;
	public double height;
	public ImageView imageView;
	public double x;
	public double y;
	public double growSpeed;
	public double nutrition;
	public double nutritionPerBite;
	
	public Plant(String name, double width,double height, ImageView imageView, double x, double y, double growSpeed, double nutrition, 
			double nutritionPerBite) {
		this.name = name;
		this.width = width;
		this.height = height;
		this.imageView = imageView;
		this.x = x;
		this.y = y;
		this.growSpeed = growSpeed;	
		this.nutrition = nutrition;
		this.imageView.setFitWidth(width);
		this.imageView.setFitHeight(height);
		this.nutritionPerBite = nutritionPerBite;
	}
	
	public double getNutritionPerBite() {
		return nutritionPerBite;
	}

	public boolean isTouched(double bugCenterX, double bugCenterY) {

		if ((bugCenterX > x) && (bugCenterX < (x + width) && (bugCenterY > y) && (bugCenterY < (y + height)))) {
			return true;
		} else {
			return false;
		}
	}
	
	public void shrink() {
		
		this.width -= 1;
		this.height -= 1;
		
		this.imageView.setFitWidth(this.width);
		this.imageView.setFitHeight(this.height);
		
	}
	
    public void grow() {
		
		this.width += growSpeed;
		this.height += growSpeed;
		
		this.imageView.setFitWidth(this.width);
		this.imageView.setFitHeight(this.height);
		
	}

	public double getNutrition() {
		return nutrition;
	}

	public void setNutrition(double nutrition) {
		this.nutrition = nutrition;
	}
	
	

	
	
}
