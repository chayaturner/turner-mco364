package turner.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {

	private static final long serialVersionUID = 1L; // default
	private JButton undoButton, redoButton;
	private JColorChooser colorChooser;
	private JPanel toolbar, northPanel;
	
	@Inject
	public PaintFrame(PaintProperties properties) {
		setTitle("Paint");
		setSize(1300, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		Injector injector = Guice.createInjector(new PaintModule());
		properties = injector.getInstance(PaintProperties.class);
		// a JPanel canvas
		final Canvas canvas = new Canvas(properties); //dependency injection - singleton
		container.add(canvas, BorderLayout.CENTER);

		toolbar = new JPanel();
		toolbar.setLayout(new GridLayout());
		northPanel = new JPanel();

		// Action listener for buttons
		ActionListener listener = new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				ToolButton button = (ToolButton) event.getSource();
				canvas.setTool(button.getTool());
			}
		};

		// buttons
		ToolButton buttons[] = new ToolButton[] {
				new ToolButton(new PencilTool(canvas.getProperties()), "/pencilIcon.png"),
				new ToolButton(new OvalTool(canvas.getProperties()), "/ovalIcon.png"),
				new ToolButton(new RectangleTool(canvas.getProperties()), "/rectangleIcon.png"),
				new ToolButton(new FillTool(canvas.getProperties()), "/fillIcon.png"),
				new ToolButton(new LineTool(canvas.getProperties()), "/lineIcon.png") };

		// add listener to all buttons
		for (ToolButton button : buttons) {
			toolbar.add(button);
			button.addActionListener(listener);
		}

		// Undo/Redo
		undoButton = new JButton(new ImageIcon("undoIcon.png"));
		undoButton.setBackground(Color.WHITE);
		redoButton = new JButton(new ImageIcon("redoIcon.png"));
		redoButton.setBackground(Color.WHITE);

		
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

		toolbar.add(undoButton);
		toolbar.add(redoButton);
		northPanel.add(toolbar);

		// Color Chooser
		colorChooser = new JColorChooser(Color.BLACK);
		colorChooser.setPreviewPanel(new JPanel());
		AbstractColorChooserPanel[] panels = colorChooser.getChooserPanels();
		for (AbstractColorChooserPanel p : panels) {
			if (!p.getDisplayName().equals("Swatches")) {
				colorChooser.removeChooserPanel(p);
			}
		}

		colorChooser.getSelectionModel().addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				Color newColor = colorChooser.getColor();
				canvas.getProperties().setColor(newColor);

			}
		});

		northPanel.add(colorChooser);
		container.add(northPanel, BorderLayout.NORTH);

		setVisible(true);

	}

	public static void main(String[] args) {
		
		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame frame = injector.getInstance(PaintFrame.class);
		//new PaintFrame(properties);
	}

}
