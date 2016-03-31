package turner.mco364.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class LineTool extends Tool {

	private int x1, y1;
	private int x2, y2;

	public LineTool(PaintProperties properties) {
		super(properties);

	}


	@Override
	public void mousePressed(Graphics2D g, int x, int y) {
		x1 = x;
		y1 = y;
		x2 = x; // so that it does't start at the default 0,0
		y2 = y;
	}

	@Override
	public void mouseReleased(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.drawLine(x1, y1, x, y);
	}

	@Override
	public void mouseDragged(Graphics2D g, int x, int y) {
		x2 = x;
		y2 = y;
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
		g.drawLine(x1, y1, x2, y2);

	}

}
