
public class SceneManager {
	/**
	 * Handles the loading and inialization of scenes within the game
	 */
	
	public Scene activeScene;
	
	Console console;

	public SceneManager(Console c)
	{
		this.console = c;
	}
	
	public void loadScene(Scene s)
	{
		/**
		 * Load the given scene into the active console window
		 * 
		 * @param s 	The scene to be loaded
		 */		
		this.activeScene = s;
		console.debug("Loading scene " + s.toString() + "...");
		console.setBackground(s.backgroundColor);
		console.setForeground(s.foregroundColor);
		s.OnLoad(console);
	}
}
