import java.util.Arrays;

final class Format {
	/**
	 * Format is a utility class that handles formatting text
	 */

	public static String a(String str)
	{
		/** 
		 * Returns "an [str]" if str starts with a vowel, 
		 * otherwise returns "a [str]"
		 */
		Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u'};
		return Arrays.asList(vowels).contains(str.charAt(0)) ? "an " + str : "a " + str;
	}
	
	public static String a(BaseObject obj)
	{
		/**
		 * Returns "an [name]" if the object's name starts with a vowel, 
		 * otherwise returns "a [name]"
		 */
		return Format.a(obj.getName());
	}

	public static String A(String str)
	{
		/** 
		 * Calls Format.a(String str) and capitalizes the output
		 */
		return Format.a(str).toUpperCase();
	}

	public static String A(BaseObject obj)
	{
		/** 
		 * Calls Format.a(Baseobject obj) and capitalizes the output
		 */
		return Format.a(obj).toUpperCase();
	}
}