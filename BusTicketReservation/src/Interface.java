import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interface {
    static List<Newaccount> accounts= new ArrayList<>();
    public static void menu() {
        System.out.println("********************** welcome to Chaitanya travels **********************"
                + "\n1.new account creating "
                + "\n2.Login into existing account"
                + "\n3.exit");

    }
    public static void openingmenudecision() {
        Scanner sc = new Scanner(System.in);
        boolean over = false;
        while (over != true) {
            menu();
            System.out.println("Entre your Choice");
            int Choice = sc.nextInt();
            switch (Choice) {
                case 1:
                    System.out.println("please entre your new account details");
                   Newaccount.addAccount();
                    break;
                case 2:
                    System.out.println("please entre your login details");
                    Loginaccount.check();
                    break;
                case 3:
                    over = true;
                    break;
                default:
                    System.out.println("please entre valid choice");
                    System.out.println();
            }

        }
    }


}
