import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

final class Format {
	/**
	 * Utility class that handles making text look nice
	 */

	public static String timestamp()
	{
		/**
		 * Get the current time formatted as HH:mm:ss.
		 */		
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
	
	public static String stripPrefix(String str)
	{
		if (str.startsWith("a ")) return str.substring(2);
		else if (str.startsWith("an ")) return str.substring(3);
		else if (str.startsWith("the ")) return str.substring(4);
		else return str;
	}

	public static String a(String str, Boolean justA)
	{
		/** 
		 * Returns "an str" if str starts with a vowel, 
		 * "a str" if not, and the string as-is if it already starts with a/an
		 * 
		 * @param str 	String to prefix with a/an
		 * @param justA Whether to return JUST a/an, or the full string w prefix
		 */
		String lowerStr = stripPrefix(str.toLowerCase());
		
		Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u'};
		String aStr = Arrays.asList(vowels).contains(str.charAt(0)) ? "an " : "a ";
		return justA ? aStr : aStr + str;
	}
	
	public static String a(String str)
	{
		return a(str, false);
	}
	
	public static String a(BaseObject obj)
	{
		/**
		 * Returns "an name" if the object's name starts with a vowel, 
		 * otherwise returns "a name"
		 */		
		return Format.a(obj.name());
	}

	public static String A(String str)
	{
		/** 
		 * Returns "An str" if the string starts with a vowel, 
		 * otherwise returns "A str"
		 */		
		String aStr = Format.a(str);
		return aStr.substring(0, 1).toUpperCase();
	}

	public static String A(BaseObject obj)
	{
		/** 
		 * Returns "An name" if the object's name starts with a vowel, 
		 * otherwise returns "A name"
		 */		
		String aStr = Format.a(obj);
		return aStr.substring(0, 1).toUpperCase();
	}

	public static String the(String str)
	{
		/**
		 * Returns "the str" or "The str" if the string doesn't
		 * already start the the/The. Otherwise, returns the string as is.
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