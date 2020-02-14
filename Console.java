import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

final class Console {
	/**
	 * The Console handles writing text to the screen.
	 */
	
	static Boolean debugEnabled = false;

	private Console()
	{
		/**
		 * Initialize a new Console instance.
		 * 
		 * @param d     Debug mode enabled?
		 */
		print("Initialized new console.");
		debug("Debug mode enabled");
	}

	public static String input()
	{
		/**
		 * Prompts the user for input and returns the full line written
		 */
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		return text;
	}

	private static String timestamp()
	{
		/**
		 * Get the current time formatted as HH:mm:ss.
		 */
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	public static void print(Object... blocks)
	{
		/**
		 * Print a line of text to the console, no frills.
		 * 
		 * @param text  The text to be printed
		 */
		String s = "";
		for (Object b : blocks) {
			s += b.toString();
		}
		System.out.println(s);
	}

	public static void debug(String text)
	{
		/**
		 * Formats a debug message with a timestamp, and displays it in the 
		 * message log. Will only print the message if debug mode is enabled.
		 * 
		 * @param text  The message to be displayed
		 */
		if (!debugEnabled) return;
		for (String s : text.split("\n")) {
			Console.print(">>>" + timestamp() + " " + s);
		}
	}
}