import java.util.Scanner;

public class Loginmenu {
    public void loginmenuview() {
        System.out.println("********************** welcome to Chaitanya travels **********************"
                + "\n1.Do you want to book ticket "
                + "\n2.view your bokkings"
                +"\n3.To Cancel your ticket"
                + "\n3.exit");
    }
    public static void loginmenudecision(){
        boolean returntomenu = false;
        Scanner sc = new Scanner(System.in);
        Loginmenu menu=new Loginmenu();

        while (returntomenu != true) {
            menu.loginmenuview();
            System.out.println("entre your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("please entre the from and to destination");
                    Ticketbooking.booking();
                    break;
                case 2:
                    System.out.println("to view your bookings");
                    Viewbookings.printticcket();
                    break;
                case 3:
                    System.out.println("to cancel your ticket");
                    Ticketbooking.cancelticket();
                    break;
                case 4:
                    returntomenu=true;
            }
        }
    }
}
