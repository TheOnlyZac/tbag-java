import java.util.HashMap;

class BaseObject {
	/**
	 * BaseObject is the primitive for all object types in the game
	 */

	private String name;
	private String description;
	private String location;
	
	private HashMap<String, Runnable> actions;

	// Getters and Setters
	public String name()
	{
		return this.name;
	}
	
	public void name(String n)
	{
		this.name = n;
	}

	public String description()
	{
		return this.description;
	}

	public void description(String desc)
	{
		this.description = desc;
	}

	public String location()
	{
		return location;
	}
	
	public void location(String loc)
	{
		this.location = loc;
	}

	public BaseObject(String name, String desc, String loc)
	{
		/**
		 * Initialize a new BaseObject with the given name and description
		 * 
		 * @param name 	The name of the object
		 * @param desc 	A brief description of the object
		 * @param 		Where the object is in space
		 */
		this.name = name;
		this.description = desc;
		this.location = loc;
		
		this.actions = new HashMap<String, Runnable>();

		this.addAction("examine", () -> {
			 System.out.println(String.format("%s: %s %s.",
					this.name, this.description, this.location));
		});
	}

	public BaseObject(String name)
	{
		/**
		 * Initialize a new BaseObject with the given name and a default
		 * description
		 * 
		 * @param name  The name of the object
		 */
		this.name = name;
		this.description = "a thing";
		this.location = "nearby";
	}

	@Override
	public String toString()
	{
		return String.format("%s", this.name);
	}
	
	public void addAction(String name, Runnable action)
	{
		this.actions.put(name, action);
	}
	
	public void runAction(String name)
	{
		this.actions.get(name).run();
	}

	/* public void say(String msg)
	{
		/**
		 * Makes the object say the given message as dialogue
		 * 
		 * @param msg 	Message to be spoken
		 */
		/* Console.print(Format.say(this.name, msg));
	} */
}
