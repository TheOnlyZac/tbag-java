class BaseObject {
	/**
	 * BaseObject is the primitive for all object types in the game
	 */

	private String name;
	private String description;
	private String location;
	
	private Room room;

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

	public void moveTo(Room newRoom)
	{
		/**
		 * Removes the object from its current Room and adds it to the 
		 * given Room.
		 * 
		 * @param room 	Destination room
		 */
		this.room.removeObject(this);
		newRoom.addObject(this);
		this.room = newRoom;
	}

	public void say(String msg)
	{
		/**
		 * Makes the object say the given message as dialogue
		 * 
		 * @param msg 	Message to be spoken
		 */
		Console.say(this.name, msg);
	}
}
