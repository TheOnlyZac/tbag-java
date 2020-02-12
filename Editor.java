import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

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
		
		BuildMenuBar();
		GenTestRooms();
		BuildStoryTree();
		BuildInspector();
		
		this.setVisible(true);
	}
	
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run()
			{
				Console.debugEnabled = true;
				new Editor();
			}
		});
	}
	
	private void BuildMenuBar()
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
	
	private void GenTestRooms()
	{
		// Create room tree list	
		Room alpha = new Room("Room Alpha");		
		alpha.addObject(new BaseObject("Tomato", "a big 'ol ripe tomato", "on a vine"));
		alpha.addObject(new Actor("Clown", "a scary looking clown guy", "across the room"));
		
		Room bravo = new Room("Room Bravo");		
		bravo.addObject(new BaseObject("Orange", "a sweet 'ol fresh orange", "in a bowl"));
		//Container table = new Container ("Table", "a mahogany table", "on the floor");
		
		
		rooms.add(alpha);
		rooms.add(bravo);
	}
	
	private void BuildStoryTree()
	{
		// Populate and draw frame
		JPanel treePanel = new JPanel();
		treePanel.setLayout(new GridLayout(0, 1));
		treePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//treePanel.setPreferredSize(new Dimension(150, 150));

		RefreshRoomTree();
		treePanel.add(tree);
		this.getContentPane().add(BorderLayout.WEST, treePanel);
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)
						tree.getLastSelectedPathComponent();
				
				// if nothing selected
				if (node == null) return;
				
				// retrieve node that was selected
				Object nodeInfo = node.getUserObject();
				
				// react to the node selection
				JOptionPane.showMessageDialog(null, nodeInfo);
			}
		});
	}
	
	private void RefreshRoomTree()
	{
		// create root node
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Rooms");
		
		for (Room room : rooms) {
			// create a node for each Room in the rooms list
			DefaultMutableTreeNode rNode = new DefaultMutableTreeNode(room.getName());
			rNode.setUserObject(room);
			root.add(rNode);
			
			// create a subnode under that room for each object in the room
			for (BaseObject obj : room) {
				DefaultMutableTreeNode objNode = new DefaultMutableTreeNode(obj.name());
				objNode.setUserObject(obj);
				rNode.add(objNode);
				
				// if the obj is a container, loop again
				/*if (obj instanceof java.lang.Iterable) {
					for (BaseObject content : obj) {
						DefaultMutableTreeNode cNode = new DefaultMutableTreeNode(content.name());
						cNode.setUserObject(content);
						objNode.add(cNode);
					}
				}*/
			}
		}

		// overwrite tree by passing in root node
		tree = new JTree(root);
	}
	
	private void BuildInspector()
	{
		// Populate and draw frame
		JPanel inspector = new JPanel();
		inspector.setLayout(new CardLayout());
		inspector.setBorder(new EmptyBorder(5, 5, 5, 5));
		//inspector.setPreferredSize(new Dimension(200, 200));
		inspector.setBackground(Color.white);
		
		inspector.add(new JLabel("Hello, world"));

		this.getContentPane().add(BorderLayout.EAST, inspector);
	}
}