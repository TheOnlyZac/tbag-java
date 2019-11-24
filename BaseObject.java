class BaseObject {
	/**
	 * BaseObject is the primitive for all object types in the game
	 */

	private String name;
	private String description;
	private Room location;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String desc)
	{
		this.description = desc;
	}

	public BaseObject(String name, String desc)
	{
		/**
		 * Initialize a new BaseObject with the given name and description
		 * 
		 * @param name  The name of the object
		 * @param desc 	A brief description of the object
		 */
		this.name = name;
		this.description = desc;
	}

	public BaseObject(String name)
	{
		/**
		 * Initialize a new BaseObject with the given name and a boilerplate
		 * description
		 * 
		 * @param name  The name of the object
		 */
		this.name = name;
		this.description = "a " + this.getClass() + " called '" + this.name + "'";
	}

	public String toString()
	{
		return this.name + " (" + this.description + ")";
	}

	public void moveTo(Room room)
	{
		/**
		 * Removes the object from its current room and adds it to the given
		 * room.
		 * 
		 * @param room 	Destination room
		 */
		this.location.removeObject(this);
		room.addObject(this);
		this.location = room;
	}
	
}
