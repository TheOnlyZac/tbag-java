import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor extends JFrame {
	
	public Editor()
	{
		// Create JFrame
		this.setTitle("TBAG Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		
		CreateMenuBar();

		// Room tree list	
		Room testRoom = new Room("RoomyRoom", "A test room to store objects");		
		testRoom.addObject(new BaseObject("Tomato", "a big 'ol ripe tomato"));
		

		// Populate and draw frame
		JPanel cardsPanel = new JPanel(new CardLayout());
		//cardsPanel.add(/*todo*/);
		this.getContentPane().add(cardsPanel);
		
		this.setVisible(true);
	}
	
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run()
			{
				new Editor();
			}
		});
	}
	
	private void CreateMenuBar()
	{
		/**
		 * Create the menubar on the editor window
		 */
		
		JMenuBar menuBar = new JMenuBar();

		// File Menu
		JMenu fileMenu = new JMenu("File");

		JMenuItem mOpen = new JMenuItem("Open");
		fileMenu.add(mOpen);

		JMenuItem mSaveAs = new JMenuItem("Save as...");
		fileMenu.add(mSaveAs);

		JSeparator jSep = new JSeparator();
		fileMenu.add(jSep);

		JMenuItem mExit = new JMenuItem("Exit");
		mExit.addActionListener((event) -> System.exit(0));
		fileMenu.add(mExit);

		menuBar.add(fileMenu);
		
		// Help Menu
		JMenu helpMenu = new JMenu("Help");

		JMenuItem mAbout = new JMenuItem("About");
		mAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutPopup();
			}
		});
		helpMenu.add(mAbout);

		menuBar.add(helpMenu);

		// Add elements to main JFrame and set visibility
		this.getContentPane().add(BorderLayout.NORTH, menuBar);
	}

	static void AboutPopup()
	{
		String html = "<html><body width='%1s'><H1>TBAG: Text Based Adventure Game</h1>"
		+ "<p>A Java framework for creating text-based interactive stories.<br><br>"
		+ "<p>Created by Zac Krasnow.";
		int w = 300;

		JOptionPane.showMessageDialog(null, String.format(html, w, w));
	}
}