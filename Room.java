import java.util.ArrayList;

class Room {
	/**
	 * A Room is the context for which Actors can interact with Objects
	 */

	 private String name;
	 private ArrayList<BaseObject> contents;

	 public Room(String name)
	 {
		/**
		 * Initialize a new, empty room
		 * 
		 * @param name 	The name of the new room
		 */
		this.name = name;
		this.contents = new ArrayList<BaseObject>();
	 }

	 public void addObject(BaseObject obj)
	 {
		 /**
		  * Add an object to the room. Fails if it's already present.
		  *
		  * @param obj    Object to remove
		  */
		 Console.debug("Adding " + obj.getName() + " to " + this.name);
		 if (contents.contains(obj)) {
			 // Object already in room, returning
			 Console.debug("Failed: Room already contains " + obj.getName());
			 return;
		 }
		 this.contents.add(obj);
	 }

	 public void removeObject(BaseObject obj)
	 {
		/**
		 * Remove an object form the room. Fails if it's not present.
		 *
		 * @param obj    Object to remove
		 */
		 if (!(contents.contains(obj))) {
			// Object not found in room, return
			Console.debug("Failed: Room does not contain " + obj.getName());
			return;
		 }
		 this.contents.remove(obj);
	 }
}