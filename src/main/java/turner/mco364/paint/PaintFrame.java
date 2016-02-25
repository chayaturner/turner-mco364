package turner.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private static final long serialVersionUID = 1L; // default
	private JButton ovalButton, rectButton, fillButton, pencilButton;
	private JPanel buttonPanel;

	public PaintFrame() {
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		// a JPanel canvas
		Canvas canvas = new Canvas();
		container.add(canvas, BorderLayout.CENTER);

		buttonPanel = new JPanel();
		pencilButton = new JButton("Pencil Tool");
		ovalButton = new JButton("Oval tool");
		rectButton = new JButton("Rectangle tool");
		//fillButton = new JButton("Fill tool");
		buttonPanel.add(pencilButton);
		buttonPanel.add(ovalButton);
		buttonPanel.add(rectButton);
		//buttonPanel.add(fillButton);
		container.add(buttonPanel, BorderLayout.NORTH);

		ovalButton.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new OvalTool());
			}

		});

		rectButton.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new RectangleTool());

			}

		});

		pencilButton.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new PencilTool());
			}
		});

		setVisible(true);

	}

	public static void main(String[] args) {
		new PaintFrame();
	}

}
