import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Game {
	/**
	 * Main game class, handles user input and logic
	 */
	
	// elements map stores all objects in the game with unique IDs
	public Map<Integer, BaseObject> elements;
	// rooms list stores all the rooms in the game
	public ArrayList<Room> rooms;
	
	public Game()
	{
		elements = new HashMap<Integer, BaseObject>();
		rooms = new ArrayList<Room>();

		// Create a new Lobby room
		Room lobby = new Room("Lobby");
		AddRoom(lobby);

		// Create Debug Sword test object
		Item debugSword = new Item("Debug Sword",
			"a mysterious sword made of light", "on the table", 2);
		Console.debug("Initialized debugSword as: " + debugSword.toString());
		lobby.addObject(debugSword);

		// Create character test object
		Actor debugActor = new Actor("Alcyonis", "a night elf", "standing by the table");
		Console.debug("Initialized debugActor as " + debugActor.toString());
		lobby.addObject(debugActor);

		debugActor.say("It's dangerous to go alone. Take this!");
		Console.log(String.format("%s gestures to %s on the table",
			debugActor.name(), Format.a(debugSword.description())));
		

		Room alpha = new Room("Room Alpha");		
		alpha.addObject(new Item("Tomato", "a big 'ol ripe tomato", "on a vine", 1));
		alpha.addObject(new Actor("Clown", "a scary looking clown guy", "across the room"));
		
		Room bravo = new Room("Room Bravo");		
		bravo.addObject(new BaseObject("Orange", "a sweet 'ol fresh orange", "in a bowl"));
		//Container table = new Container ("Table", "a mahogany table", "on the floor");
		
		AddRoom(alpha);
		AddRoom(bravo);
	}

	public static void main(String[] args)
	{
		// Check if debug mode enabled
		if (args.length > 0 && args[0].equals("-d")) {
			Console.debugEnabled = true;
			Console.debug("Starting with debug mode enabled");
		}
		Console.debugEnabled = true; // hardcode debugMode enabled
		
		Game game = new Game();

		while(true) {
			String txt = Console.input();
			//Console.log(txt);
			if (parseInput(txt) == -1) break;
		}

		Console.log("Thank you for playing Wing Commander!");
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
