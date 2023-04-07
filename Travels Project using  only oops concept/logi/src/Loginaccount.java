import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Loginaccount {
    static List<String> blockednumbers=new ArrayList<>();
    static String cpnumber;

    static String number1;
    public static void check(){
        Loginaccount login = new Loginaccount();
        boolean d=false;
        int i=0;
        while (d!=true ){
            if(!d){
                i++;
            }
            if(i>5){
                System.out.println("");
                System.out.println("your account is locked out");
                blockednumbers.add(cpnumber);
                break;
            }
            else {
                d = login.loginn();
            }
        }
        if(i<5) {
            if(blockednumbers.size()==0){
                Loginmenu.loginmenudecision();
            }
            for (int j = 0; j < blockednumbers.size(); j++) {
                if (!number1.equals(blockednumbers.get(j))) {
                    Loginmenu.loginmenudecision();
                }
            }
        }
    }
    public boolean loginn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("entre your phone number");
        String number=sc.nextLine();
        if (blockednumbers.size() != 0) {
            for (int j = 0; j < blockednumbers.size(); j++) {
                if (number.equals(blockednumbers.get(j))) {
                    System.out.println("your account is locked");
                    number1=number;
                    return true;
                }
            }
        }
        if(blockednumbers.size()>=0)
        {
            for (int i = 0; i < Interface.accounts.size(); i++) {
                if (Interface.accounts.get(i).getMobileNumber().equals(number)) {
                    cpnumber = Interface.accounts.get(i).getMobileNumber();
                    System.out.println("entre your password");
                    String password = sc.nextLine();
                    if (Interface.accounts.get(i).getPassword().equals(password)) {
                        cpnumber = Interface.accounts.get(i).getMobileNumber();
                        return true;
                    } else {
                        System.out.println("please entre correct password");
                    }
                }
            }
        }
        return false;
    }

}
