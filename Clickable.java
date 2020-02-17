import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class Clickable extends JLabel {
	/**
	 * Utility class for Console to make elements interactable by
	 * clicking on them
	 */

	Console console;
	private BaseObject target;
	private JPopupMenu popup;
	
	public Clickable(Console c, String label, BaseObject obj)
	{
		console = c;
		this.target = obj;
		popup = new JPopupMenu();
		
		JMenuItem examine = new JMenuItem("examine");
		examine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				target.examine(console);
			}
		});
		
		popup.add(examine);
		
		setText(label);
		setFont(this.getFont().deriveFont(this.getFont().getStyle() | Font.BOLD));
		setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
            	showPopup(e);
            }

        });
	}
	
	void showPopup(MouseEvent e)
	{
		popup.show(e.getComponent(), e.getX(), e.getY());
	}
}
