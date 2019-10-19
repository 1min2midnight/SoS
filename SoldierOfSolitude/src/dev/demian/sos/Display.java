package dev.demian.sos;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {

	//containers
		private JFrame frame;
		private Canvas canvas;
		//-------
		private String title;
		private int width;
		private int height;
		
		//constructor
		public Display(String t, int w, int h)
		{
			
			title = t;
			width = w;
			height= h;
			
			createDisplay();

		}
		
	

		//creates a display and sets all of its properties

		private void createDisplay() 
		{
			
			frame = new JFrame(title);
			frame.setSize(width, height);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			
			//screen appears in center
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			canvas = new Canvas();
			canvas.setPreferredSize(new Dimension (width,height));
			canvas.setMaximumSize(new Dimension (width,height));
			canvas.setMinimumSize(new Dimension (width,height));
			canvas.setFocusable(false);
			
			frame.add(canvas);
			frame.pack();
			
		}
		//allows canvas to be accessed
		public Canvas getCanvas() {
			return canvas;
			
		}
		//allows jframe to be accessed
		public JFrame getJFrame() {
			
			return frame;
		}
		
}
