import java.util.Scanner;

class Tbag {
    /**
     * Main game class, handles user input and logic
     */

    public static void main(String[] args)
    {
        Console.debugEnabled = true;
        Scanner input = new Scanner(System.in);

        BaseObject debugSword = new BaseObject("Debug Sword");
        Console.debug("Initialized object as '" + debugSword.name + "'");

        while(true) {
            String txt = input.nextLine();
            Console.log(txt);
            if (txt == "exit") break;
        }

        input.close();
    }
}
