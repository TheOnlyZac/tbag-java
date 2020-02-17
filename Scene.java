import java.util.Iterator;
import java.awt.Color;
import java.util.ArrayList;

public class Scene implements Iterable<BaseObject> {
	/**
	 * A Scene is the context for which Actors can interact with Objects
	 */

	private String name;
	private String description;
	private ArrayList<BaseObject> contents;
	
	public Color backgroundColor = Color.BLACK;
	public Color foregroundColor = Color.WHITE;

	// GETTERS and SETTERS
	public String getName()	{ return name; }
	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }
	public void setDescription(String desc) { this.description = desc; }

	// default place for new objects with no location
	public static Scene purgatory = new Scene("Purgatory", "an empty, boundless void");
	
	// Iterator
	public Iterator<BaseObject> iterator()
	{
		return this.contents.iterator();
	}
	
	// Constructor
	public Scene(String _name, String _desc)
	{
		/**
		 * Initialize a new, empty room with the given name and description
		 * 
		 * @param name 	The name of the new room
		 * @param desc	A brief description of the room (not the objects within)
		 */
		this.name = _name;
		this.description = _desc;
		this.contents = new ArrayList<BaseObject>();
	 }
	
	public Scene(String _name, String _desc, Color bgColor, Color fgColor)
	{
		/**
		 * Initialize a new, empty room with the given name, description,
		 * and color pallette (bg color and fg color)
		 * 
		 * @param name 	The name of the new room
		 * @param desc	A brief description of the room (not the objects within)
		 */
		this.name = _name;
		this.description = _desc;
		this.contents = new ArrayList<BaseObject>();
		
		this.backgroundColor = bgColor;
		this.foregroundColor = fgColor;		
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
	
	public void OnLoad(Console c)
	{
		c.print("You are in ", Format.the(this.getName()),
				". It is ", Format.a(this.getDescription()),
				this.getDescription(), ".");
		this.LookAround(c);
	}
	
	public void LookAround(Console c)
	{
		String result = "Looking around, you can see ";
		
		for (int i = 0; i < contents.size(); i++) {
			if (i == contents.size() - 1) result += " and %ad.";
			else result += "%ad, ";
		}
		c.printf(result, contents.toArray(new BaseObject[contents.size()]));
	}
}