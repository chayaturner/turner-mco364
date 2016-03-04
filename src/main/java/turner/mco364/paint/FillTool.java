package turner.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class FillTool extends Tool {

	public FillTool(PaintProperties properties){
		super(properties);
	}
	
	private BufferedImage image;
	private Color color;

	public void mousePressed(Graphics g, int x, int y) {
		fill(x, y);
	}

	private void fill(int x, int y) {
		Queue<Point> points = new LinkedList<Point>();

		int sourceColor = image.getRGB(x, y);
		int targetColor = color.getRGB();

		if (sourceColor != targetColor) {
			points.add(new Point(x, y));

			while (!points.isEmpty()) {
				Point p = points.remove();
				x = (int) p.getX();
				y = (int) p.getY();
				if (x > 0 && y > 0 && x < image.getWidth() && y < image.getHeight()
						&& image.getRGB(x, y) == sourceColor) {
					image.setRGB(x, y, targetColor);

					points.add(new Point(x - 1, y));
					points.add(new Point(x + 1, y));
					points.add(new Point(x, y - 1));
					points.add(new Point(x, y + 1));
				}
			}
		}
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

}
