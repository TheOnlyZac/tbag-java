import java.util.ArrayList;

class Actor extends BaseObject {
	/**
	 * Actors are living objects that can perform actions on objects and other
	 * actors.
	 */

	private ArrayList<BaseObject> inventory;

	public Actor(String name, String desc, String loc)
	{
		super(name, desc, loc);
		inventory = new ArrayList<BaseObject>();
	}
}