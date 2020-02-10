import java.util.ArrayList;

class Container extends BaseObject {
	/**
	 * Contains store other objects
	 */

	private ArrayList<BaseObject> contents;
	
	public Container(String name)
	{
		/**
		 * Initialize a new empty container
		 */
		super(name);
		this.contents = new ArrayList<BaseObject>();
	}

}