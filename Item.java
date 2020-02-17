class Item extends BaseObject {
	/**
	 * Items can be picked up and stored inside containers
	 */
	
	private int size;

	public Item(String name, String shortDesc, String longDesc, String loc, int size)
	{
		super(name, shortDesc, longDesc, loc);

		this.size = size;
	}
	
	public int size()
	{
		return this.size;
	}
}