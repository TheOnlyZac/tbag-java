import java.util.Scanner;

class Tbag {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        BaseObject debugSword = new BaseObject("Debug Sword");
        System.out.println("Initialized sword as '" + debugSword.name + "'");

        while(true) {
            String txt = input.nextLine();
            System.out.println(txt);
        }
    }
}
