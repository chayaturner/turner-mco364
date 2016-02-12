package turner.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class PaintFrame extends JFrame {

	private static final long serialVersionUID = 1L; //default

	public PaintFrame() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		// a JPanel canvas
		Canvas canvas = new Canvas();
		container.add(canvas, BorderLayout.CENTER);

		setVisible(true);

	}

	public static void main(String[] args) {
		new PaintFrame();
	}

}
