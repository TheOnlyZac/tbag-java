import java.util.concurrent.Callable;

public class Portal extends BaseObject {
	/**
	 * Used to move from scene to scene
	 */
	
	Scene sceneLink;
	
	public Portal(String name, String shortDesc, String longDesc, String loc, Scene scene)
	{
		super(name, shortDesc, longDesc, loc);
		sceneLink = scene;
	}
	
	public void Use(SceneManager sm)
	{
		sm.loadScene(sceneLink);
	}
}
