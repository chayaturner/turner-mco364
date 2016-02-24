package turner.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class OvalTool implements Tool {

	private int x1, y1;
	private int x2, y2;
	private int width, height;

	@Override
	public void mousePressed(Graphics g, int x, int y) {
		x1 = x;
		y1 = y;
		x2 = x;
		y2 = y;
		width = 0;
		height = 0;
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.RED);
		x2 = x;
		y2 = y;
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y1);
		g.drawOval(Math.min(x1, x2), Math.min(y1, y2), width, height);
	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		x2 = x;
		y2 = y;
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y1);
	}

	@Override
	public void drawPreview(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(Math.min(x1, x2), Math.min(y1, y2), width, height);
	}

}
