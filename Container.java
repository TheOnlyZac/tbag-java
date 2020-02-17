import java.util.ArrayList;
import java.util.Iterator;

class Container extends BaseObject implements Iterable<Item> {
	/**
	 * Contains are iterable objects that store other objects
	 */

	private ArrayList<Item> contents;
	private int capacity;
	private int currWeight;
	
	// Iterator
	public Iterator<Item> iterator()
	{
		return this.contents.iterator();
	}
	
	public Container(String name, String desc, String loc)
	{
		/**
		 * Initialize a new empty container
		 */
		super(name, desc, loc);
		this.contents = new ArrayList<Item>();
	}
	
	public int add(Item item)
	{
		/**
		 * Insert the given item into the container if there is room for it.
		 * If the item's size is too big for the remaining capacity of the
		 * container, it will fail and return -1. Otherwise, it will succeed
		 * and return 1.
		 * 
		 * @param 	item 	The item to be added
		 * @return 			0 if successful, -1 if failed
		 */
		
		if (this.currWeight + item.size() > this.capacity) {
			System.out.println(String.format("Error adding %s to %s: Too big for container",
					item.name(), this.name()));
			return -1; // operation failed
		}
		
		this.contents.add(item);
		this.currWeight += item.size();
		return 0; // operation completed successfully
	}
	
	public int remove(Item item)
	{
		/**
		 * Attempt to remove the given item from this container. If the item
		 * is not found, return -1 and fail. Otherwise, it will return 1.
		 * 
		 * @param 	item 	The item to be removed
		 * @return 			0 if successful, -1 if failed
		 */
		try {
			this.contents.remove(contents.indexOf(item));
			this.currWeight -= item.size();
			return 0; // operation completed successfully
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(String.format("Error removing %s from %s: Item Not Found",
					item.name(), this.name()));
			return -1; // operation failed
		}
	}
	
	public boolean contains(Item item)
	{
		return this.contents.contains(item);
	}

}