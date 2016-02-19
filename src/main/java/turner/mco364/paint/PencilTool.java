package turner.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class PencilTool implements Tool {

	private int lastX;
	private int lastY;

	public void mousePressed(Graphics g, int x, int y) {
		lastX = x;
		lastY = y;
		g.setColor(Color.RED);
		g.fillOval(x, y, 1, 1);
	}

	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	public void mouseDragged(Graphics g, int x, int y) {
		g.setColor(Color.RED);
		g.drawLine(lastX, lastY, x, y);
		lastX = x;
		lastY = y;
	}

	public void drawPreview(Graphics g) {

	}

}
