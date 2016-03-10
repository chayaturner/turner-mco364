package turner.mco364.paint;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolButton extends JButton {

	private static final long serialVersionUID = 1L;

	private Tool tool;

	public ToolButton(Tool tool, String iconName) {
		this.tool = tool;
		setBackground(Color.WHITE);
		this.setIcon(new ImageIcon(getClass().getResource(iconName))); // from
																		// resources
																		// directory
		// this.setIcon(new ImageIcon(iconName));
	}

	public Tool getTool() {
		return tool;
	}
}
