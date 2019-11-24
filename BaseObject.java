class BaseObject {
	/**
	 * BaseObject is the primitive for all object types in the game
	 */

	private String name;
	private String description;
	private Room location = Room.purgatory;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }
	public void setDescription(String desc) { this.description = desc; }

	public Room getLocation() { return location; }

	public BaseObject(String name, String desc)
	{
		/**
		 * Initialize a new BaseObject with the given name and description
		 * 
		 * @param name 	The name of the object
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
		this.description = "a " + this.getClass();
	}

	public String toString()
	{
		return String.format("%s (%s) in %s",
			this.name, this.description, this.location.getName());
	}

	public void moveTo(Room newLocation)
	{
		/**
		 * Removes the object from its current Room and adds it to the 
		 * given Room.
		 * 
		 * @param room 	Destination room
		 */
		this.location.removeObject(this);
		newLocation.addObject(this);
		this.location = newLocation;
	}
}
