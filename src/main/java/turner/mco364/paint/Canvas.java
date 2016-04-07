package turner.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;

	private static int HEIGHT = 1380;
	private static int WIDTH = 750;
	private Stack<BufferedImage> undo; // stack to save images before undo
	private Stack<BufferedImage> redo; // stack to redo images
	private BufferedImage buffer;
	private Tool tool;
	private PaintProperties properties; // singleton

	@Inject
	public Canvas(PaintProperties paintProperties) {

		properties = paintProperties;
		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();
		buffer = new BufferedImage(HEIGHT, WIDTH, BufferedImage.TYPE_INT_ARGB);
		properties = new PaintProperties(WIDTH, HEIGHT, buffer, Color.BLACK);
		tool = new PencilTool(properties); // default tool

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
				// put event onto undo stack
				undo.push(drawCopy(buffer));
				// get the graphics from the image.
				tool.mousePressed(buffer.createGraphics(), event.getX(), event.getY());
				repaint(); // will call paintComponent method
			}

			public void mouseReleased(MouseEvent event) {

				tool.mouseReleased(buffer.createGraphics(), event.getX(), event.getY());
				repaint();
			}

		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				tool.mouseDragged(buffer.createGraphics(), event.getX(), event.getY());
				//tool.drawPreview(getGraphics());
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
		
		Graphics2D g2D = (Graphics2D) g;
		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g2D);

	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	private BufferedImage drawCopy(BufferedImage buffer) {
		BufferedImage newImage = new BufferedImage(buffer.getWidth(), buffer.getHeight(), buffer.getType());
		Graphics2D g2d = newImage.createGraphics();
		g2d.drawImage(buffer, 0, 0, null);
		return newImage;
	}

	public void undo() {
		if (!undo.isEmpty()) {
			redo.push(drawCopy(buffer));

			buffer = undo.pop();
			repaint();
		}
	}

	public void redo() {
		if (!redo.isEmpty()) {
			undo.push(drawCopy(buffer));
			buffer = redo.pop();
			repaint();
		}
	}

	// public void setColor(Color color) {
	// this.color = color;
	// }

	public BufferedImage getBuffer() {
		return buffer;
	}

	public PaintProperties getProperties() {
		return properties;
	}

}
