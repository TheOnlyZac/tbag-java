import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Editor {
	
	private static JFrame frame;
	
	public static void main(String args[])
	{

		// Create JFrame
		frame = new JFrame("TBAG GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);

		CreateMenuBar();

		// Item list
		DefaultListModel<BaseObject> objListModel = new DefaultListModel<BaseObject>();
		JList<BaseObject> objList = new JList<BaseObject>(objListModel);
		objListModel.addElement(new BaseObject("Test Object", "A test object"));
		objListModel.addElement(new Item("Test Item", "A fun item"));


		JPanel cardsPanel = new JPanel(new CardLayout());
		cardsPanel.add(objList);
		frame.getContentPane().add(cardsPanel);

		frame.setVisible(true);
	}
	
	static void CreateMenuBar()
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
		frame.getContentPane().add(BorderLayout.NORTH, menuBar);
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