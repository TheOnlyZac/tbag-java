class Tbag {
	/**
	 * Main game class, handles user input and logic
	 */

	public static void main(String[] args)
	{
		if (args.length > 0 && args[0].equals("-d")) {
			Console.debugEnabled = true;
			Console.debug("Starting with debug mode enabled");
		}

		Room lobby = new Room("Lobby");

		BaseObject debugSword = new BaseObject("Debug Sword",
			"a mysterious sword made of light");
		Console.debug("Initialized debugSword as: " + debugSword.toString());

		debugSword.moveTo(lobby);

		Console.debug(debugSword.toString());

		while(true) {
			String txt = Console.input();
			Console.log(txt);
			if (parseInput(txt) == -1) break;
		}

		Console.log("Thank you for playing Wing Commander!");
	}

	private static int parseInput(String text)
	{
		/**
		 * Parse the entered text into a more convenient datatype
		 */
		String[] words = text.split(" ");
		if (words[0].equals("exit")) return -1;
		return 0;

	}
}
