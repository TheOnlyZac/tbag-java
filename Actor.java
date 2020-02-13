import java.util.ArrayList;

class Actor extends BaseObject {
	/**
	 * Actors are living objects that can perform actions on objects and other
	 * actors.
	 */

	private Container inventory;

	public Actor(String name, String desc, String loc)
	{
		super(name, desc, loc);
		inventory = new Container(String.format("%s's Inventory",this.name()),
				"a worn leather backpack", "held by " + this.name());
	}
}