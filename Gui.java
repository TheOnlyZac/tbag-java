import javax.swing.*;

class Gui {
	public static void main(String args[])
	{
		JFrame frame = new JFrame("TBAG GUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);

		JButton button = new JButton("Press");
		frame.getContentPane().add(button);
		frame.setVisible(true);
	}
}