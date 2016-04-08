package turner.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import org.junit.Test;
import org.mockito.Mockito;

public class LineToolTest {

	@Test
	public void testMouseReleased(){
		
		PaintProperties properties = Mockito.mock(PaintProperties.class); //mock properties
		Mockito.when(properties.getColor()).thenReturn(Color.RED);
		
		LineTool tool = new LineTool(properties);
		
		Graphics2D g = Mockito.mock(Graphics2D.class); //mocks graphics class
		
		tool.mousePressed(g, 3, 7);
		tool.mouseReleased(g, 11, 13);
		
		//check to make sure that g.drawLine(3, 7, 11, 13) was called
		Mockito.verify(g).setColor(Color.RED);
		//if your code setColor more than once, do this instead:
		//Mockito.verify(g, Mockito.atLeastOnce()).setColor(Color.RED);
		Mockito.verify(g).drawLine(3, 7, 11, 13);
		
	}
	
	@Test
	public void testDrawPreview(){
		
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);
		
		LineTool tool = new LineTool(properties);
		
		Graphics2D g = Mockito.mock(Graphics2D.class);
		
		tool.mousePressed(g, 6, 1);
		tool.mouseDragged(g, 9, 7);
		tool.drawPreview(g);
		
		Mockito.verify(g).setColor(Color.RED);
		Mockito.verify(g).drawLine(6, 1, 9, 7);
		
	}
	
}
