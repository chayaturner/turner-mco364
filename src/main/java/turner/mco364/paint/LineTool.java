package turner.mco364.paint;

import java.awt.Graphics2D;
import java.util.logging.Logger;

public class LineTool extends Tool {

	private static final Logger LOG = Logger.getLogger(LineTool.class.getName());

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

		String logMsg = String.format("x1 = %d y1=%d x2=%d y2=%d", x1, y1, x2, y2);
		LOG.info(logMsg);
	}

}
