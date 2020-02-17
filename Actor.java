class Actor extends BaseObject {
	/**
	 * Actors are living objects that can perform actions on objects and other
	 * actors.
	 */

	private Container inventory;

	public Actor(String name, String desc, String loc)
	{
		super(name, desc, loc);
		this.inventory = new Container(String.format("%s's inventory",
				this.name()), "a container with " + this.name()
				+ "'s belongings", "held by " + this.name());
	}
	
	public void Pickup(Item item)
	{
		/**
		 * Pickup an item and add it to the Actor's inventory
		 * 
		 * @param item 	Item to be picked up
		 */
		this.inventory.addObject(item);
	}
}