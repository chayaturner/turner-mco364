package turner.mco364.paint;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.google.inject.Singleton;

@Singleton
public class PaintProperties {

	private int width; // of the canvas
	private int height; // of the canvas
	private BufferedImage image;
	private Color color;
	private int weight; // of the drawing line
	private boolean fill;

	public PaintProperties() {
		this.width = 1300;
		this.height = 750;
		image = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_ARGB);
		this.color = Color.BLACK;
		this.weight = 1;
		this.fill = false;

	}

	public PaintProperties(int WIDTH, int HEIGHT, BufferedImage image, Color color) {
		this.width = WIDTH;
		this.height = HEIGHT;
		this.image = image;
		this.color = color;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public BufferedImage getImage() {
		return image;
	}

	public Color getColor() {
		return color;
	}

	public int getWeight() {
		return weight;
	}

	public boolean isFill() {
		return fill;
	}

}
