import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Game {
	/**
	 * Main game class, handles user input and logic
	 */
	
	public Map<Integer, BaseObject> elements; // elements map stores all objects in the game with unique IDs
	public ArrayList<Room> rooms; // rooms list stores all the rooms in the game
	
	public Console console;
	
	
	public Game()
	{
		elements = new HashMap<Integer, BaseObject>();
		rooms = new ArrayList<Room>();
		console = new Console();

		Room lobby = new Room("Lobby");

		Item debugSword = new Item("Debug Sword",
			"a mysterious sword made of light", "on the table", 2);

		Actor debugActor = new Actor("Alcyonis", "a night elf", "standing by the table");


		lobby.addObject(debugSword);
		lobby.addObject(debugActor);
		AddRoom(lobby);

		console.print(Format.say(debugActor.name(), "It's dangerous to go alone. Take this!"));
		console.print(debugActor, " gestures to ",
				Format.a(debugSword.description()), " on the table");
		

		Room alpha = new Room("Room Alpha");		
		
		alpha.addObject(new Item("Tomato", "a big 'ol ripe tomato", "on a vine", 1));
		alpha.addObject(new Actor("Clown", "a scary looking clown guy", "across the room"));
		AddRoom(alpha);
		
		Room bravo = new Room("Room Bravo");	
		
		bravo.addObject(new BaseObject("Orange", "a sweet 'ol fresh orange", "in a bowl"));
		bravo.addObject(new Container ("Table", "a mahogany table", "on the floor"));
		AddRoom(bravo);



	}

	public static void main(String[] args)
	{
		Game game = new Game();
		
		// Check if debug mode enabled
		if (args.length > 0 && args[0].equals("-d")) {
			Console.debugEnabled = true;
			game.console.debug("Starting with debug mode enabled");
		}
		Console.debugEnabled = true; // hardcode debugMode enabled
		
	}
	
	private void AddRoom(Room room)
	{
		/**
		 * 
		 */
		rooms.add(room);
	}
	
	private void AddObject(BaseObject obj)
	{
		/**
		 * Generate a random ID for an object and add it to the game elements array
		 * 
		 * @param obj 	The object to add
		 */
		// todo: make sure ID isn't already in hashmap before adding
		elements.put(genId(), obj);
	}
	
	private Integer genId()
	{
		/**
		 * Generate a random 4-digit integer ID
		 */
		Random r = new Random();
		return r.nextInt((9999 - 1000) + 1) + 1;
	}
	

	private static int parseInput(String text)
	{
		// todo: move input parser into Console class
		String[] words = text.split(" ");
		if (words[0].equals("exit")) return -1;
		return 0;

	}
}
