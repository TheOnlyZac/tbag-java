class Tbag {
	/**
	 * Main game class, handles user input and logic
	 */

	public static void main(String[] args)
	{
		// Check if debug mode enabled
		if (args.length > 0 && args[0].equals("-d")) {
			Console.debugEnabled = true;
			Console.debug("Starting with debug mode enabled");
		}

		// Create a new Lobby room
		Room lobby = new Room("the lobby", "a waiting room with beige walls");

		// Create Debug Sword test object
		Item debugSword = new Item("Debug Sword",
			"a mysterious sword made of light");
		Console.debug("Initialized debugSword as: " + debugSword.toString());

		// Create character test obbject
		Actor debugActor = new Actor("Alcyonis", "a night elf");
		Console.debug("Initialized debugActor as " + debugActor.toString());

		// Move the Debug Sword into the Lobby
		debugSword.moveTo(lobby);
		debugActor.moveTo(lobby);

		debugActor.say("It's dangerous to go alone. Take this!");
		Console.log(String.format("%s gestures to %s on the table",
			debugActor.getName(), Format.a(debugSword.getDescription())));

		while(true) {
			String txt = Console.input();
			//Console.log(txt);
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
