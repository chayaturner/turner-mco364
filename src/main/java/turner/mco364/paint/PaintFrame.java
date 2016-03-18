package turner.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {

	private static final long serialVersionUID = 1L; // default

	@Inject
	public PaintFrame(Canvas canvas, PaintToolbar toolbar) {

		setTitle("Paint");
		setSize(1380, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		// set up JPanel canvas
		container.add(canvas, BorderLayout.CENTER);

		// set up toolbar
		container.add(toolbar, BorderLayout.NORTH);

		setVisible(true);

	}

	public static void main(String[] args) {

		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame frame = injector.getInstance(PaintFrame.class);
		// new PaintFrame(properties);
	}

}
