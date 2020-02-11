import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Editor extends JFrame {
	
	private JMenuBar menuBar;
	private JTree tree;
	
	private ArrayList<Room> rooms;
	
	public Editor()
	{
		// Create JFrame
		this.setTitle("TBAG Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		
		rooms = new ArrayList<Room>();
		
		CreateMenuBar();
		CreateRoomTree();		

		// Populate and draw frame
		JPanel cardsPanel = new JPanel(new CardLayout());
		cardsPanel.add(tree);
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
		
		menuBar = new JMenuBar();

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
	
	private void CreateRoomTree()
	{
		// Create room tree list	
		Room alpha = new Room("Room Alpha", "The first of two test rooms");		
		alpha.addObject(new BaseObject("Tomato", "a big 'ol ripe tomato"));
		
		Room bravo = new Room("Room Bravo", "The second of two test rooms");		
		bravo.addObject(new BaseObject("Orange", "a sweet 'ol fresh orange"));
		
		rooms.add(alpha);
		rooms.add(bravo);
		
		// create root node
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Rooms");
		
		// refresh rooms
		RefreshRoomTree(root);
		
		// create tree by passing in root node
		tree = new JTree(root);
		add(tree);
	}
	
	private void RefreshRoomTree(DefaultMutableTreeNode root)
	{
		for (Room room : rooms)
		{
			// create a node for each Room in the rooms list
			DefaultMutableTreeNode rNode = new DefaultMutableTreeNode(room.getName());
			root.add(rNode);
			
			// create a subnode under that room for each object in the room
			for (BaseObject obj : room)
			{
				DefaultMutableTreeNode objNode = new DefaultMutableTreeNode(obj.getName());
				rNode.add(objNode);
			}
		}
	}
}