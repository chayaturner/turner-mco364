package turner.mco364.paint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage buffer;
	private Tool tool;

	public Canvas() {
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		// tool = new PencilTool();
		tool = new LineTool();

		this.addMouseListener(new MouseListener() {

			// mouse pressed and released
			public void mouseClicked(MouseEvent event) {

			}

			public void mouseEntered(MouseEvent event) {

			}

			public void mouseExited(MouseEvent event) {

			}

			// when you hold down mouse
			public void mousePressed(MouseEvent event) {
				// get the graphics from the image.

				tool.mousePressed(buffer.getGraphics(), event.getX(), event.getY());
				repaint(); // will call paintComponent method
			}

			public void mouseReleased(MouseEvent event) {

				tool.mouseReleased(buffer.getGraphics(), event.getX(), event.getY());
				repaint();
			}

		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				tool.mouseDragged(buffer.getGraphics(), event.getX(), event.getY());
				tool.drawPreview(getGraphics());
				repaint();
			}

			public void mouseMoved(MouseEvent event) {

			}

		});

	}

	// when you call repaint, the OS calls paintComponent

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g);

	}
}
