import java.util.ArrayList;

class Actor extends BaseObject {
	/**
	 * Actors are living objects that can perform actions on objects and other
	 * actors.
	 */

	private String name;
	private ArrayList<BaseObject> inventory;

	public Actor(String name, String desc)
	{
		super(name, desc);
		inventory = new ArrayList<BaseObject>();
	}

	public void pickup(Item item)
	{
		item.getLocation().removeObject(item);
		inventory.add(item);
	}
}