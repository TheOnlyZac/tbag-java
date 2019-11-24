import java.util.Scanner;

class Tbag {
	/**
	 * Main game class, handles user input and logic
	 */

	public static void main(String[] args)
	{
		Console.debugEnabled = true;
		Scanner input = new Scanner(System.in);

		BaseObject debugSword = new BaseObject("Debug Sword");
		Console.debug("Initialized object as '" + debugSword.getName() + "'");

		while(true) {
			String txt = input.nextLine();
			Console.log(txt);
			if (parseInput(txt) == -1) break;
		}

		input.close();
	}

	private static int parseInput(String text)
	{
		String[] words = text.split(" ");
		if (words[0].equals("exit")) return -1;
		return 0;

	}
}
