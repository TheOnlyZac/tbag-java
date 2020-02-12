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
		String lowerStr = str.toLowerCase();
		if (lowerStr.startsWith("a ") || lowerStr.startsWith("an ")) {
			return str;
		}
		Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u'};
		return (Arrays.asList(vowels).contains(str.charAt(0)) ? "an " : "a ") + str;
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
}