import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Game {
	/**
	 * Main game class, handles manipulation of game elements and logic
	 */
	
	public Map<Integer, BaseObject> elements; // maps all objects in the game to unique IDs
	public ArrayList<Scene> scenes; // stores all the scenes in the game
	public Console console;
	private SceneManager sceneManager;
	
	public Game()
	{
		elements = new HashMap<Integer, BaseObject>();
		console = new Console();
		scenes = new ArrayList<Scene>();
		sceneManager = new SceneManager(console);

		// LOBBY SCENE
		Scene lobby = new Scene("lobby",
				"a simple waiting room with beige walls",
				new Color(245, 245, 220), Color.black);

		Item debugSword = new Item("debug sword",
			"a mysterious sword made of light", "on the table", 4);

		Actor debugActor = new Actor("Alcyonis",
				"a night elf", "standing by the table");
		
		Container table = new Container("table",
				"a mahogany table", "on the floor", 100);
		
		lobby.addObject(table);
		table.addObject(debugSword);
		lobby.addObject(debugActor);
		AddScene(lobby);
		
		// OFFICE SCENE
		Scene office = new Scene("office", "a dimly lit workspace",
				Color.DARK_GRAY, Color.white);		
		
		Item papers = new Item("Papers",
				"a stack of paperwork", "on the desk", 1);
		
		Container desk = new Container("desk",
				"a simple wooden desk", "on the far side of the room", 50);
		
		office.addObject(papers);
		office.addObject(desk);
		AddScene(office);
		
		Portal door = new Portal("door", "an office door",
				"on the south wall", office);

		lobby.addObject(door);
		sceneManager.loadScene(lobby);

		console.printf("%xn says, \"It's dangerous to go alone, take this!\"",
				debugActor);
		console.printf("%xn gestures to %tn on the table.",
				debugActor, debugSword);
		//sceneManager.loadScene(office);

	}

	public static void main(String[] args)
	{
		Game game = new Game();
		
		// Check if debug mode enabled
		if (args.length > 0 && args[0].equals("-d")) {
			Console.debugEnabled = true;
			game.console.debug("Starting with debug mode enabled");
		}
		
	}
	
	private void AddScene(Scene scene)
	{
		/**
		 * Add a scene to the game
		 */
		scenes.add(scene);
	}
	
	private void AddObject(BaseObject obj)
	{
		/**
		 * Generate a random ID for an object and add it to the game
		 * elements array
		 * 
		 * @param obj 	The object to add
		 */
		// todo: make sure ID is unique before adding to the map
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
}
