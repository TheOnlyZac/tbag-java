class Item extends BaseObject {
	/**
	 * Items can be picked up and stored inside containers
	 */
	
	private int size;

	public Item(String name, String desc, String loc, int size)
	{
		super(name, desc, loc);

		this.size = size;
	}
	
	public int size()
	{
		return this.size;
	}
}