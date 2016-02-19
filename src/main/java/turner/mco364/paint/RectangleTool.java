package turner.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class RectangleTool implements Tool {

	private int x1, y1;
	private int x2, y2;

	@Override
	public void mousePressed(Graphics g, int x, int y) {
		x1 = x;
		y1 = y;
		x2 = x;
		y2 = y;

	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.RED);
		g.drawLine(x1, y1, x, y1);
		g.drawLine(x1, y1, x1, y);
		g.drawLine(x1, y, x, y);
		g.drawLine(x, y1, x, y);
	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		x2 = x;
		y2 = y;
	}

	@Override
	public void drawPreview(Graphics g) {
		g.setColor(Color.RED);
		g.drawLine(x1, y1, x2, y1);
		g.drawLine(x1, y1, x1, y2);
		g.drawLine(x1, y2, x2, y2);
		g.drawLine(x2, y1, x2, y2);
	}

}