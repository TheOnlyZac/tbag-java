import javax.swing.*;

import javafx.scene.layout.Border;

import java.awt.*;
import java.util.ArrayList;

class Console extends JFrame {
	/**
	 * The Console handles writing text to the screen.
	 */
	
	public static Boolean debugEnabled = false;
	
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
		setSize(700, 400);
		
		textPanel = new JPanel();
		
		textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
		textPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		textPanel.setBackground(new Color(0,0,0,0));
		getContentPane().add(textPanel);
		
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
		//textPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		// for each block in the sequence...
		for (Object b : blocks) {
			if (b instanceof BaseObject) {
				// if it is a baseObject, create a new Clickable and add it to the panel
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
	
	public void printf(String fstring, BaseObject... blocks)
	{
		/**
		 * Take a string and substitute each %xy block with the given
		 * BaseObjects in the blocks sequence formed as below:
		 * 
		 * x = the string prefix
		 * 	a: a/an
		 * 	t: the
		 * 	x: no prefix
		 * 
		 * y = formatted version of the object
		 * 	n: name of the given object
		 * 	d: description of the given object
		 * 
		 * @param fstring 	The string to format
		 * @param blocks 	The BaseObjects to insert int the string
		 */		
		String[] split = fstring.split("%"); // split string at % delimiter
		
		if (blocks.length != split.length - 1) {
			// if the number of delimiters != the number of blocks,
			// default to printing the unformatted string
			this.debug("Cannot format string, sub and block count mismatch");
			this.print(fstring);
		}
		
		// create a new JPanel for the new line of text
		JPanel line = new JPanel();
		line.setLayout(new BoxLayout(line, BoxLayout.X_AXIS));
		line.setAlignmentX(Component.LEFT_ALIGNMENT);
		//line.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		
		Clickable c; // new clickable to insert into the line
		int i = 0; // current block counter
		int j = 0; // loop counter
		
		for (String s : split) {
			// always insert the first split string as a label, no clickable
			if (j == 0) {
				if (s.length() != 0) line.add(new JLabel(s));
				j++;
				continue;
			}
			
			// store the current BaseObject as curr
			BaseObject curr = blocks[i];
			
			String partA = s.substring(0, 2); // part a = substitution
			String partB = s.substring(2); // part b = the string following
			String sub; //
			String title; //
			
			// substitute the title
			switch(partA.charAt(1)) {
				case 'n':
					title = curr.name();
					break;
				case 'd':
					title = curr.description();
					break;
				default:
					title = curr.name();
					break;
			};
			
			// substitute the prefix
			switch(partA.charAt(0)) {
				case 'a':
					sub = Format.a(title);
					break;
				case 't':
					sub = Format.the(title);
					break;
				case 'x':
					sub = title;
					break;
				default:
					sub = title;
					break;
			};
			
			c = new Clickable(sub, curr);
			//c.setBorder(BorderFactory.createLineBorder(Color.black));
			
			line.add(c);
			line.add(new JLabel(partB));
			
			i++; // increment block counter
			j++; // increment loop counter
		}
		
		textPanel.add(line);
		revalidate();
	}
	
	public void debug(String text)
	{
		/**
		 * Formats a debug message with a timestamp, and displays it in the 
		 * message log. Will only print the message if the debugEnabled
		 * flag is set true
		 * 
		 * @param text  The message to be displayed
		 */		
		if (!debugEnabled) return;
		for (String s : text.split("\n")) {
			this.print(">>>", Format.timestamp(), " ", s);
		}
	}
}