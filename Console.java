import javax.swing.*;

import javafx.scene.layout.Border;

import java.awt.*;
import java.util.ArrayList;

class Console extends JFrame {
	/**
	 * The Console handles writing text to the screen.
	 */
	
	public static Boolean debugEnabled = true;
	
	private JPanel textPanel;

	public Console()
	{
		/**
		 * Initialize a new Console instance.
		 * 
		 * @param d     Debug mode enabled?
		 */
		// Create JFrame
		setTitle("TBAG Console");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		
		textPanel = new JPanel();
		
		BoxLayout boxLayout = new BoxLayout(textPanel, BoxLayout.Y_AXIS);
		textPanel.setLayout(boxLayout);
		getContentPane().add(textPanel);
		
		//textPanel.setBackground(Color.BLACK);
		setVisible(true);
		
		debug("Initialized new console (debug mode enabled).");
		
	}

	public void print(Object... blocks)
	{
		/**
		 * Take a sequence of objects and print them to the console as a string
		 * in order.
		 * 
		 * @param blocks  The elements that compose the string
		 */
		
		// Create a new JPanel for the new line of text output
		JPanel line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.setAlignmentX(Component.LEFT_ALIGNMENT);
		//line.setBorder(BorderFactory.createLineBorder(Color.black));
		//line.setBackground(Color.black);
		
		// for each block in the sequence...
		for (Object b : blocks) {
			if (b instanceof BaseObject) {
				// if it is a baseObject, create a new clickable and add it to the panel
				Clickable c = new Clickable(((BaseObject) b).name(), (BaseObject) b);
				line.add(c);
			} else {
				// if it is anything else, simply add it as a string on a JLabel
				JLabel label = new JLabel();
				//label.setForeground(Color.white);
				label.setText(b.toString());
				
				line.add(label);
			}
		}
		
		textPanel.add(line);
		
		revalidate();
	}
	
	public void printf(String fstring, Object... blocks)
	{
		String[] split = fstring.split("%");
		
		JPanel line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		Clickable c;
		int i = 0;
		int j = 0;
		for (String s : split) {
			if (j == 0) {
				line.add(new JLabel(s));
				j++;
				continue;
			}
			
			BaseObject curr = (BaseObject) blocks[i];
			
			String partA = s.substring(0, 1);
			String partB = s.substring(1);
			
			switch(partA.charAt(0)) {
				case 'a':
					c = new Clickable(Format.a(curr.name()), curr);
					break;
				case 'o':
					c = new Clickable(curr.name(), curr);
				default:
					c = new Clickable(curr.name(), curr);
					break;
			}
			line.add(c);
			line.add(new JLabel(partB));
			i++;
			j++;
		}
		
		textPanel.add(line);
		revalidate();
	}
	
	public void debug(String text)
	{
		/**
		 * Formats a debug message with a timestamp, and displays it in the 
		 * message log. Will only print the message if debug mode is enabled.
		 * 
		 * @param text  The message to be displayed
		 */
		if (!debugEnabled) return;
		for (String s : text.split("\n")) {
			this.print(">>>", Format.timestamp(), " ", s);
		}
	}
}