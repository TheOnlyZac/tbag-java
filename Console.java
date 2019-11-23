import java.util.Date;
import java.text.SimpleDateFormat;

class Console {
    
    static Boolean debugEnabled = false;

    public Console(boolean d)
    {
        Console.debugEnabled = d;
        log("Initialized new console.");
        debug("Debug mode enabled");
    }

    public static void log(String text)
    {
        System.out.println(text);
    }

    public static void debug(String text)
    {
        if (debugEnabled) {
            String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
            System.out.println(timestamp + ": " + text);
        }
    }
}