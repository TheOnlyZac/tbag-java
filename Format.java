import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

final class Format {
	/**
	 * Format is a utility class that handles formatting text
	 */

	public static String timestamp()
	{
		/**
		 * Get the current time formatted as HH:mm:ss.
		 */
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	public static String a(String str)
	{
		/** 
		 * Returns "an" if str starts with a vowel, 
		 * "a" if not, and "" if it already starts with a/an
		 */
		String lowerStr = str.toLowerCase();
		if (lowerStr.startsWith("a ") || lowerStr.startsWith("an "))
			return "";
		
		Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u'};
		return (Arrays.asList(vowels).contains(str.charAt(0)) ? "an " : "a ");
	}
	
	public static String a(BaseObject obj)
	{
		/**
		 * Returns "an" if the object's name starts with a vowel, 
		 * otherwise returns "a"
		 */
		return Format.a(obj.name());
	}

	public static String A(String str)
	{
		/** 
		 * Returns "An" if the string starts with a vowel, 
		 * otherwise returns "A"
		 */
		String aStr = Format.a(str);
		return aStr.substring(0, 1).toUpperCase();
	}

	public static String A(BaseObject obj)
	{
		/** 
		 * Returns "An" if the object's name starts with a vowel, 
		 * otherwise returns "A"
		 */
		String aStr = Format.a(obj);
		return aStr.substring(0, 1).toUpperCase();
	}

	public static String the(String str)
	{
		/**
		 * Returns "the [str] or "The [str]" if the string doesn't
		 * already start the "the". Otherwise, returns the string as is.
		 */
		if (str.startsWith("the ")) return str;
		else if (str.startsWith("The ")) return str;
		else if (str.toLowerCase().charAt(0) == str.charAt(0)) return "the " + str;
		else return "The " + str.toLowerCase();
	}

	public static String say(String speaker, String text)
	{
		/**
		 * Displays the text as a line of dialogue spoken by the speaker
		 * 
		 * @param speaker 	The name of the thing doing the speaking
		 * @param text 		The message to be spoken
		 */
		return String.format("%s says \"%s\"", speaker, text);
	}
}