import java.util.HashMap;
import java.util.concurrent.*;

class BaseObject {
	/**
	 * BaseObject is the primitive for all object types in the game
	 */

	private String name;
	private String shortDesc;
	private String longDesc;
	private String location;
	private String flavorText = null;

	// Getters and Setters
	public String name()
	{
		return this.name;
	}
	
	public void name(String n)
	{
		this.name = n;
	}

	public String shortDesc()
	{
		return this.shortDesc;
	}

	public void shortDesc(String desc)
	{
		this.shortDesc = desc;
	}
	
	public String longDesc()
	{
		return this.longDesc;
	}
	
	public void longDesc(String desc)
	{
		this.longDesc = desc;
	}

	public String location()
	{
		return location;
	}
	
	public void location(String loc)
	{
		this.location = loc;
	}
	public String flavorText()
	{
		return this.flavorText;
	}
	public void flavorText(String txt)
	{
		this.flavorText = txt;
	}

	public BaseObject(String name, String desc, String loc)
	{
		/**
		 * Initialize a new BaseObject with the given name and shortDesc.
		 * 
		 * @param name 	The name of the object
		 * @param desc 	A brief shortDesc of the object
		 * @param loc	A shortDesc of where the object is in space
		 */
		this.name = name;
		this.shortDesc = desc;
		this.longDesc = desc;
		this.location = loc;
	}

	public BaseObject(String name, String shortd, String longd, String loc)
	{
		/**
		 * Initialize a new BaseObject with the given name and shortDesc.
		 * 
		 * @param name 	The name of the object
		 * @param desc 	A brief shortDesc of the object
		 * @param loc	A shortDesc of where the object is in space
		 */
		this.name = name;
		this.shortDesc = shortd;
		this.longDesc = longd;
		this.location = loc;
	}

	@Override
	public String toString()
	{
		return String.format("%s", this.name);
	}
	
	public void examine(Console c)
	{
    	c.printf("%tn is %as %xs.",
    			this, this.longDesc(), this.location());
    	if (this.flavorText != null)
    		c.printf(flavorText);
	}

	/* public void say(String msg)
	{
		/**
		 * Makes the object say the given message as dialogue
		 * 
		 * @param msg 	Message to be spoken
		 */
		/* Console.print(Format.say(this.name, msg));
	} */
}
