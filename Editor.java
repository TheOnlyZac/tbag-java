import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Editor extends JFrame {
	
	private Game game;
	
	private JSplitPane leftPane;
	private JSplitPane rightPane;
	
	private JMenuBar menuBar;
	private JToolBar toolbar;
	private JTree tree;
	private Inspector inspector;
	private JPanel explorer;
	
	// Editor class constructor
	public Editor()
	{
		// Create JFrame
		this.setTitle("TBAG Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		
		game = new Game();
		
		BuildMenuBar();
		BuildToolbar();
		BuildStoryTree();
		BuildInspector();
		BuildExplorer();

		rightPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				explorer, inspector);
		leftPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				tree, rightPane);

		this.getContentPane().add(leftPane);
		this.setVisible(true);
	}
	
	// Inspector subclass
	private class Inspector extends JPanel {
		
		private BaseObject focus;
		private Map<String, String> fields;
		
		public Inspector()
		{
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.setBackground(Color.white);
		
			fields = new HashMap<String, String>();
		}
		
		public void SetFocus(BaseObject obj)
		{
			focus = obj;

			fields.put("Type", String.format("%s", obj.getClass()));
			fields.put("Name", obj.name());
			fields.put("Description", obj.description());
			fields.put("Location", obj.location());
			
			DrawFields();
		}
		
		private void DrawFields()
		{
			this.removeAll();
			
			for (Map.Entry<String, String> entry : fields.entrySet()) {
				this.add(new JLabel(String.format("%s: %s",
						entry.getKey(), entry.getValue())));
			}
			
		}
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
		/**
		 * Show the "About" popup with information about the app
		 */
		String html = "<html><body width='%1s'><H1>TBAG: Text Based Adventure Game</h1>"
		+ "<p>A Java framework for creating text-based interactive stories.<br><br>"
		+ "<p>Created by Zac Krasnow.";
		int w = 300;

		JOptionPane.showMessageDialog(null, String.format(html, w, w));
	}
	
	private void BuildToolbar()
	{
		toolbar = new JToolBar();
		toolbar.add(new JButton("Start"));

		//this.getContentPane().add(BorderLayout.PAGE_START, toolbar);
		
	}
	
	private void BuildStoryTree()
	{
		/**
		 * Create the JTree that visualizes the room heirarchy
		 */		
		// Populate and draw frame
		JPanel treePanel = new JPanel();
		treePanel.setLayout(new BorderLayout());
		//treePanel.setPreferredSize(new Dimension(150, 150));

		RefreshRoomTree();
		treePanel.add(BorderLayout.CENTER, tree);
		
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
				if (nodeInfo instanceof BaseObject) inspector.SetFocus((BaseObject) nodeInfo);
			}
		});
		
		JButton addObjBtn = new JButton("+");
		treePanel.add(BorderLayout.SOUTH, addObjBtn);
	}
	
	private void RefreshRoomTree()
	{
		/**
		 * Refresh the JTree visualizing the room heirarchy
		 */		
		// create root node
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Rooms");
		
		for (Scene scene : game.scenes) {
			// create a node for each Scene in the scenes list
			DefaultMutableTreeNode rNode = new DefaultMutableTreeNode(scene.getName());
			rNode.setUserObject(scene);
			root.add(rNode);
			
			// create a subnode under that room for each object in the room
			for (BaseObject obj : scene) {
				DefaultMutableTreeNode objNode = new DefaultMutableTreeNode(obj.name());
				objNode.setUserObject(obj);
				rNode.add(objNode);
				
				// if the obj is a container, loop its contents
				if (obj instanceof Container) {
					for (Item item : (Container) obj) {
						DefaultMutableTreeNode cNode = new DefaultMutableTreeNode(item.name());
						cNode.setUserObject(item);
						objNode.add(cNode);
					}
				}
				
				// if the obj is an actor, loop their inventory
				if (obj instanceof Actor) {
					for (Item item : (Container) ((Actor) obj).inventory) {
						DefaultMutableTreeNode cNode = new DefaultMutableTreeNode(item.name());
						cNode.setUserObject(item);
						objNode.add(cNode);
					}
				}
			}
		}

		// overwrite tree by passing in root node
		tree = new JTree(root);
	}
	
	private void BuildInspector()
	{
		/**
		 * Build the inspector pane that shows info about the selected object
		 */
		inspector = new Inspector();
	}
	
	private void BuildExplorer()
	{
		/**
		 * Build the explorer the visualizes the room layout in the editor
		 */
		explorer = new JPanel();
		explorer.add(new JLabel("Explorer"));
	}
}