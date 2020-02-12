import java.util.ArrayList;
import java.util.Iterator;

class Container extends BaseObject implements Iterable<BaseObject> {
	/**
	 * Contains are iterable objects that store other objects
	 */

	private ArrayList<BaseObject> contents;
	
	// Iterator
	public Iterator<BaseObject> iterator()
	{
		return this.contents.iterator();
	}
	
	public Container(String name, String desc, String loc)
	{
		/**
		 * Initialize a new empty container
		 */
		super(name, desc, loc);
		this.contents = new ArrayList<BaseObject>();
	}

}