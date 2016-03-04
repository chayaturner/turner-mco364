package turner.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class PencilTool extends Tool {

	private int lastX;
	private int lastY;
	
	public PencilTool(PaintProperties properties) {
		super(properties);
	}
	
	@Override
	public void mousePressed(Graphics g, int x, int y) {
		lastX = x;
		lastY = y;
		g.setColor(properties.getColor());
		g.fillOval(x, y, 1, 1);
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		g.setColor(properties.getColor());
		g.drawLine(lastX, lastY, x, y);
		lastX = x;
		lastY = y;
	}

	@Override
	public void drawPreview(Graphics g) {

	}

	//public void setColor(Color color) {
	//	this.color = color;
	//}

}
