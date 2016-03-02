package turner.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintFrame extends JFrame {

	private static final long serialVersionUID = 1L; // default
	private JButton ovalButton, rectButton, fillButton, pencilButton, undoButton, redoButton;
	private JPanel buttonPanel;
	private JColorChooser colorChooser;
	private Color color;

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
		fillButton = new JButton("Fill tool");
		undoButton = new JButton("Undo");
		redoButton = new JButton("Redo");

		colorChooser = new JColorChooser(Color.BLACK);
		colorChooser.setPreviewPanel(new JPanel());
		AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
		for (AbstractColorChooserPanel p : panels) {
			if (!p.getDisplayName().equals("Swatches")) {
				colorChooser.removeChooserPanel(p);
			}
		}

		colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Color newColor = colorChooser.getColor();
				color = newColor;
				canvas.setColor(color);
			}
		});

		ovalButton.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new OvalTool(color));
			}

		});

		rectButton.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new RectangleTool(color));

			}

		});

		pencilButton.addActionListener(new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new PencilTool(color));
			}
		});

		fillButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				canvas.setTool(new FillTool(canvas.getBuffer(), color));
			}

		});

		undoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.undo();
			}

		});

		redoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.redo();
			}

		});

		buttonPanel.add(pencilButton);
		buttonPanel.add(ovalButton);
		buttonPanel.add(rectButton);
		buttonPanel.add(fillButton);
		buttonPanel.add(undoButton);
		buttonPanel.add(redoButton);
		buttonPanel.add(colorChooser);
		container.add(buttonPanel, BorderLayout.NORTH);

		setVisible(true);

	}

	public static void main(String[] args) {
		new PaintFrame();
	}

}
