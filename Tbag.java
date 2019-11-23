import java.util.Scanner;

class Tbag {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        BaseObject debugSword = new BaseObject("Debug Sword");
        Console.log("Initialized object as '" + debugSword.name + "'");

        while(true) {
            String txt = input.nextLine();
            Console.log(txt);
            if (txt == "exit") break;
        }

        input.close();
    }
}
