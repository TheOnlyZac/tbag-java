import javax.swing.*;
import java.awt.*;

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
		
		textPanel.setBackground(Color.BLACK);
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
		String s = "";
		for (Object b : blocks) {
			s += b.toString();
		}
		System.out.println(s);
		
		JLabel label = new JLabel();
		label.setText(s);
		label.setForeground(Color.white);
		
		textPanel.add(label);
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