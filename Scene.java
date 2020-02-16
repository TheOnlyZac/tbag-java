import java.util.Iterator;
import java.util.ArrayList;

public class Scene implements Iterable<BaseObject> {
	/**
	 * A Scene is the context for which Actors can interact with Objects
	 */

	private String name;
	private String description;
	private ArrayList<BaseObject> contents;

	// GETTERS and SETTERS
	public String getName()	{ return name; }
	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }
	public void setDescription(String desc) { this.description = desc; }

	// default place for new objects with no location
	public static Scene purgatory = new Scene("Purgatory");
	
	// Iterator
	public Iterator<BaseObject> iterator()
	{
		return this.contents.iterator();
	}
	
	// Constructor
	public Scene(String _name)
	{
		/**
		 * Initialize a new, empty room with the given name and description
		 * 
		 * @param name 	The name of the new room
		 */
		this.name = _name;
		this.contents = new ArrayList<BaseObject>();
	 }

	public String toString()
	{
		return String.format("%s", this.name);
	}

	public void addObject(BaseObject obj)
	{
		/**
		 * Add an object to the room. Fails if it's already present.
		 *
		 * @param obj    Object to remove
		 */
		//System.out.println("Adding " + obj.name() + " to Scene: " + this.getName());
		if (contents.contains(obj)) {
			// Object already in room, returning
			System.out.println("Failed: Scene already contains " + obj.name());
			return;
		}
		this.contents.add(obj);
		//Console.debug("Successfully added to room");
	}

	public void removeObject(BaseObject obj)
	{
		/**
		 * Remove an object form the room. Fails if it's not present.
		 *
		 * @param obj    Object to remove
		 */
		//System.out.println("Removing " + obj.name() + " from Scene: " + this.getName());
		if (!(contents.contains(obj))) {
			// Object not found in room, return
			System.out.println("Failed: Scene does not contain " + obj.name());
			return;
		}
		this.contents.remove(obj);
		//Console.debug("Successfully removed from Scene");
	}
}