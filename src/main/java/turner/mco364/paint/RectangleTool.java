package turner.mco364.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class RectangleTool extends Tool {
	
	private int x1, y1;
	private int x2, y2;

	
	public RectangleTool(PaintProperties properties) {
		super(properties);
	}
	

	@Override
	public void mousePressed(Graphics2D g, int x, int y) {
		x1 = x;
		y1 = y;
		x2 = x;
		y2 = y;

	}

	@Override
	public void mouseReleased(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.drawLine(x1, y1, x, y1);
		g.drawLine(x1, y1, x1, y);
		g.drawLine(x1, y, x, y);
		g.drawLine(x, y1, x, y);
	}

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {
		x2 = x;
		y2 = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
		g.drawLine(x1, y1, x2, y1);
		g.drawLine(x1, y1, x1, y2);
		g.drawLine(x1, y2, x2, y2);
		g.drawLine(x2, y1, x2, y2);
	}

	//public void setColor(Color color) {
	//	this.color = color;
	//}
}