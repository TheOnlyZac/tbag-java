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
		 * otherwise returns "a"
		 */
		String lowerStr = str.toLowerCase();

		Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u'};
		return (Arrays.asList(vowels).contains(str.charAt(0)) ? "an " : "a ");
	}
	
	public static String a(BaseObject obj)
	{
		/**
		 * Returns "an [name]" if the object's name starts with a vowel, 
		 * otherwise returns "a [name]"
		 */
		return Format.a(obj.name());
	}

	public static String A(String str)
	{
		/** 
		 * Returns "An [str]" if the string starts with a vowel, 
		 * otherwise returns "A [str]"
		 */
		String aStr = Format.a(str);
		return aStr.substring(0, 1).toUpperCase() + aStr.substring(1);
	}

	public static String A(BaseObject obj)
	{
		/** 
		 * Returns "An [name]" if the object's name starts with a vowel, 
		 * otherwise returns "A [name]"
		 */
		String aStr = Format.a(obj);
		return aStr.substring(0, 1).toUpperCase() + aStr.substring(1);
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