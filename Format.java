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

	public static String a(String str)
	{
		/** 
		 * Returns "an str" if str starts with a vowel, 
		 * "a str" if not, and the string as-is if it already starts with a/an
		 */		
		String lowerStr = str.toLowerCase();
		if (lowerStr.startsWith("a ") || lowerStr.startsWith("an "))
			return str;
		
		Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u'};
		return (Arrays.asList(vowels).contains(str.charAt(0)) ? "an " + str : "a " + str);
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