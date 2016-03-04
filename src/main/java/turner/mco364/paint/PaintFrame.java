package turner.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintFrame extends JFrame {

	private static final long serialVersionUID = 1L; // default
	//private JButton ovalButton, rectButton, fillButton, pencilButton, lineButton, undoButton, redoButton;
	//private JPanel buttonPanel;
	private JColorChooser colorChooser;
	//private Color color;

	public PaintFrame() {
		setTitle("Paint");
		setSize(800, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		
		// a JPanel canvas
		final Canvas canvas = new Canvas();
		container.add(canvas, BorderLayout.CENTER);

		JPanel toolbar = new JPanel();
		container.add(toolbar, BorderLayout.NORTH);
		
		//Action listener for buttons
		ActionListener listener = new ActionListener(){
			
			public void actionPerformed(ActionEvent event){
				ToolButton button = (ToolButton) event.getSource();
				canvas.setTool(button.getTool());
			}
		};
		
		//buttons
		ToolButton buttons[] = new ToolButton[] {
				new ToolButton(new PencilTool(canvas.getProperties()),"/pencilIcon.png"),
				new ToolButton(new OvalTool(canvas.getProperties()), "/ovalIcon.png"),
				new ToolButton(new RectangleTool(canvas.getProperties()), "/rectangleIcon.png"),
				new ToolButton(new FillTool(canvas.getProperties()), "/fillIcon.png"),
				new ToolButton(new LineTool(canvas.getProperties()), "/lineIcon.png"),
		};
		
				//undoButton = new ToolButton(new UndoTool(canvas.getProperties()), "/undoIcon.png");
				//redoButton = new ToolButton(new RedoTool(canvas.getProperties()), "/redoIcon.png");
		
		
		//add listener to all buttons
		for(ToolButton button : buttons){
			toolbar.add(button);
			button.addActionListener(listener);
		}

		
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
				//color = newColor;
				//canvas.setColor(color);
				canvas.getProperties().setColor(newColor);
				
			}
		});


		/*

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

		 */
		
		setVisible(true);

	}

	public static void main(String[] args) {
		new PaintFrame();
	}

}
