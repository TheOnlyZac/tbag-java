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
		log("Initialized new console.");
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

	public static void print(String text)
	{
		/**
		 * Print a line of text to the console, no frills.
		 * 
		 * @param text  The text to be printed
		 */
		System.out.println(text);
	}

	public static void log(String text)
	{
		/**
		 * Formats a string and displays it in the message log, line by line
		 * 
		 * @param text  The text to be displayed
		 */
		for (String s : text.split("\n")) {
			Console.print(">" + s);
		}
	}

	public static void say(String speaker, String text)
	{
		/**
		 * Displays the text as a line of dialogue spoken by the speaker
		 * 
		 * @param speaker 	The name of the thing doing the speaking
		 * @param text 		The message to be spoken
		 */
		Console.log(String.format("%s says \"%s\"", speaker, text));
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
			Console.print(">>" + timestamp() + " " + s);
		}
	}
}