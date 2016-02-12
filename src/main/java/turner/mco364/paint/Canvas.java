package turner.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private static final long serialVersionUID = 1L; //default
	
	private BufferedImage buffer;

	public Canvas() {

		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

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
				Graphics g = buffer.getGraphics();
				g.setColor(Color.RED);
				g.fillOval(event.getX(), event.getY(), 5, 5);

				repaint(); // will call paintComponent method

			}

			public void mouseReleased(MouseEvent event) {

			}

		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				Graphics g = buffer.getGraphics();
				g.setColor(Color.RED);
				g.fillOval(event.getX(), event.getY(), 10, 10);

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
	}

}
