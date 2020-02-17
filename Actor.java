class Actor extends BaseObject {
	/**
	 * Actors are living objects that can perform actions on objects and other
	 * actors.
	 */

	public Container inventory;

	public Actor(String name, String desc, String loc)
	{
		super(name, desc, loc);
		this.inventory = new Container(String.format("%s's inventory",
				this.name()), "a container with " + this.name()
				+ "'s belongings", "held by " + this.name(), 10);
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
	
	public void say(Console c, String s, BaseObject... blocks)
	{
		BaseObject[] thisArr = {this};
		BaseObject[] blocksFinal = new BaseObject[blocks.length + 1];
		System.arraycopy(thisArr, 0, blocksFinal, 0, 1);
		System.arraycopy(blocks, 0, blocksFinal, 1, blocks.length);
		
		c.printf("%xn " + String.format(" says \"%s\"", s), blocksFinal);
	}
	
	@Override
	public void examine(Console c)
	{
    	c.printf("That is %xn, %as %xs.",
    			this, this.description(), this.location());
	}
}