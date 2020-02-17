import java.util.HashMap;
import java.util.concurrent.*;

class BaseObject {
	/**
	 * BaseObject is the primitive for all object types in the game
	 */

	private String name;
	private String description;
	private String location;
	
	private HashMap<String, Action> actions;
	

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
		
		this.actions = new HashMap<String, Action>();

		
		AddAction(new Action("examine", new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "test callable";
			}
			
		}));
	}

	@Override
	public String toString()
	{
		return String.format("%s", this.name);
	}
	
	public void AddAction(Action action)
	{
		this.actions.put(action.name, action);
	}

	public String RunAction(String name)
	{
		try {
			return this.actions.get(name).run();
		} catch (Exception exception) {
			System.out.println("error doing action");
			return String.format("Exception %s while running action %s in %s",
					exception.toString(), name, this.name());
		}
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
