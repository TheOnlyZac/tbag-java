class Tbag {
	/**
	 * Main game class, handles user input and logic
	 */

	public static void main(String[] args)
	{
		Console.debugEnabled = true;

		BaseObject debugSword = new BaseObject("Debug Sword");
		Console.debug("Initialized object as '" + debugSword.getName() + "'");

		while(true) {
			String txt = Console.input();
			Console.log(txt);
			if (parseInput(txt) == -1) break;
		}
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
