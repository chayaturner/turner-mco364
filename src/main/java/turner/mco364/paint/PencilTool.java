package turner.mco364.paint;

import java.awt.Graphics2D;

public class PencilTool extends Tool {

	private int lastX;
	private int lastY;

	public PencilTool(CanvasRepaintManager manager, PaintProperties properties) {
		super(manager, properties);
	}

	@Override
	public void mousePressed(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.setStroke(properties.getStroke());
		g.fillOval(x, y, 1, 1);
		manager.repaint(x, y, x+1, y+1); //Corresponding to the fillOval
		lastX = x;
		lastY = y;
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
		manager.repaint(x, y, lastX, lastY);
		lastX = x;
		lastY = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {

	}


}
