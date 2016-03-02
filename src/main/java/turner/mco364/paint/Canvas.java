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

public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;

	private Stack<BufferedImage> undo; // stack to save images before undo
	private Stack<BufferedImage> redo;
	private BufferedImage buffer;
	private Tool tool;
	private Color color;

	public Canvas() {
		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		color = Color.BLACK; // default color
		tool = new PencilTool(color); // default tool is pencil

		this.addMouseListener(new MouseListener() {

			// mouse pressed and released
			@Override
			public void mouseClicked(MouseEvent event) {

			}

			@Override
			public void mouseEntered(MouseEvent event) {

			}

			@Override
			public void mouseExited(MouseEvent event) {

			}

			// when you hold down mouse
			@Override
			public void mousePressed(MouseEvent event) {
				// put event onto undo stack
				undo.push(drawCopy(buffer));
				// get the graphics from the image.
				tool.mousePressed(buffer.getGraphics(), event.getX(), event.getY());
				repaint(); // will call paintComponent method
			}

			@Override
			public void mouseReleased(MouseEvent event) {

				tool.mouseReleased(buffer.getGraphics(), event.getX(), event.getY());
				repaint();
			}

		});

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent event) {
				tool.mouseDragged(buffer.getGraphics(), event.getX(), event.getY());
				tool.drawPreview(getGraphics());
				repaint();
			}

			@Override
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

	public void setColor(Color color) {
		this.color = color;
	}

	public BufferedImage getBuffer() {
		return buffer;
	}

}
