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
		 * Initialize a new BaseObject with the given name and description.
		 * 
		 * @param name 	The name of the object
		 * @param desc 	A brief description of the object
		 * @param loc	A description of where the object is in space
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
		/**
		 * Add the given action to the list of the Object's possible actions.
		 * 
		 * @param action 	The action to be stored in the actions array
		 */
		this.actions.put(action.name, action);
	}

	public String RunAction(String name)
	{
		/**
		 * Run the action stored under the given name in the actions array.
		 * 
		 * @param name 	The name of the action to be run
		 */
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
