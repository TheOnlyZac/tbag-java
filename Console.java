import java.util.Date;
import java.text.SimpleDateFormat;

final class Console {
    /**
     * The Console handles writing text to the screen.
     */
    
    static Boolean debugEnabled = false;

    private Console()
    {
        /**
         * Initialize a new Console instance.
         * 
         * @param d Debug mode enabled?
         */
        log("Initialized new console.");
        debug("Debug mode enabled");
    }

    private static String timestamp()
    {
        /**
         * Get the current time formatted as HH:mm:ss.
         */
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void print(String text)
    {
        /**
         * Simply print a line of text to the console, no frills.
         * 
         * @param text  The text to be printed
         */
        System.out.println(text);
    }

    public static void log(String text)
    {
        /**
         * Formats a string and displays it in the message log.
         * 
         * @param text  The text to be displayed
         */
        Console.print(">" + text);
    }

    public static void debug(String text)
    {
        /**
         * Formats a debug message with a double prefix and timestamp, and
         * displays it in the mesasge log. Will only print the message if
         * debug mode is enabbled.
         * 
         * @param text  The message to be displayed
         */
        if (debugEnabled) Console.print(">>" + timestamp() + ": " + text);
    }
}