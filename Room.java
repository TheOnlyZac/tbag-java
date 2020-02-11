import java.util.Iterator;
import java.util.ArrayList;

public class Room implements Iterable<BaseObject> {
	/**
	 * A Room is the context for which Actors can interact with Objects
	 */

	private String name;
	private String description;
	private ArrayList<BaseObject> contents;

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}
	public void setDescription(String desc)
	{
		this.description = desc;
	}

	public static Room purgatory = new Room("Purgatory", "a space that exists nowehre");
	
	public Iterator<BaseObject> iterator()
	{
		return this.contents.iterator();
	}
	
	public Room(String _name, String _desc)
	{
		/**
		 * Initialize a new, empty room with the given name and description
		 * 
		 * @param name 	The name of the new room
		 */
		this.name = _name;
		this.description = _desc;
		this.contents = new ArrayList<BaseObject>();
	 }

	public void addObject(BaseObject obj)
	{
		/**
		 * Add an object to the room. Fails if it's already present.
		 *
		 * @param obj    Object to remove
		 */
		Console.debug("Adding " + obj.getName() + " to Room: " + this.getName());
		if (contents.contains(obj)) {
			// Object already in room, returning
			Console.debug("Failed: Room already contains " + obj.getName());
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
		Console.debug("Removing " + obj.getName() + " from Room: " + this.getName());
		if (!(contents.contains(obj))) {
			// Object not found in room, return
			Console.debug("Failed: Room does not contain " + obj.getName());
			return;
		}
		this.contents.remove(obj);
		//Console.debug("Successfully removed from Room");
	}
}