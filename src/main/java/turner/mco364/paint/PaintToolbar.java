package turner.mco364.paint;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class PaintToolbar extends Container {

	private static final long serialVersionUID = 1L;

	private JColorChooser colorChooser;
	private JPanel buttonPanel;

	@Inject
	public PaintToolbar(final Canvas canvas, PaintProperties properties) {

		buttonPanel = new JPanel(new GridLayout());
		//setLayout(new GridLayout());
		setLayout(new FlowLayout());

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
			buttonPanel.add(button);
			button.addActionListener(listener);
		}

		// Undo/Redo
		JButton undoButton = new JButton();
		undoButton.setIcon(new ImageIcon(getClass().getResource("/undoIcon.png")));
		undoButton.setBackground(Color.WHITE);
		JButton redoButton = new JButton();
		redoButton.setIcon(new ImageIcon(getClass().getResource("/redoIcon.png")));
		redoButton.setBackground(Color.WHITE);

		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.undo();
			}

		});

		redoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.redo();
			}

		});

		buttonPanel.add(undoButton);
		buttonPanel.add(redoButton);

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
		
		
		add(buttonPanel);
		add(colorChooser);
	}
}
