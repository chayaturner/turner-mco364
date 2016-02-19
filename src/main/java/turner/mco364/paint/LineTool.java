package turner.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class LineTool implements Tool {

	private int x1, y1;
	private int x2, y2;

	public void mousePressed(Graphics g, int x, int y) {
		x1 = x;
		y1 = y;
		x2 = x; // so that it does't start at the default 0,0
		y2 = y;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.RED);
		g.drawLine(x1, y1, x, y);
	}

	public void mouseDragged(Graphics g, int x, int y) {
		x2 = x;
		y2 = y;
	}

	public void drawPreview(Graphics g) {
		g.setColor(Color.RED);
		g.drawLine(x1, y1, x2, y2);

	}

}
