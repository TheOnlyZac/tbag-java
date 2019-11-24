class BaseObject {
	/**
	 * BaseObject is the primitive for all object types in the game
	 */

	private String name;
	private Room location;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public BaseObject(String name)
	{
		/**
		 * Initialize a new BaseObject with no special properties.
		 * 
		 * @param name  The name of the object
		 */
		this.name = name;
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
