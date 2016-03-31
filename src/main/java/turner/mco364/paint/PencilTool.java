package turner.mco364.paint;

import java.awt.Graphics2D;

public class PencilTool extends Tool {

	private int lastX;
	private int lastY;

	public PencilTool(PaintProperties properties) {
		super(properties);
	}

	@Override
	public void mousePressed(Graphics2D g, int x, int y) {
		lastX = x;
		lastY = y;
		g.setColor(properties.getColor());
		g.setStroke(properties.getStroke());
		g.fillOval(x, y, 1, 1);
	}

	@Override
	public void mouseReleased(Graphics2D g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.setStroke(properties.getStroke());
		g.drawLine(lastX, lastY, x, y);
		lastX = x;
		lastY = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {

	}


}
