import java.sql.*;
import java.util.Scanner;

public class Loginaccount {
    static String cpnumber="";
    static int wrongnum=0;
    static String blocknumber="";
    public static void check(){

        String d="empty";
        String e="";
        cpnumber="";

        while (!d.equals("nonempty" ) && !e.equals("blocked")){
            if(wrongnum>5){
                Loginaccount.blockednumberadder(blocknumber);
                wrongnum=0;
            }
            d = Loginaccount.loginn();
            if(d.equals("blocked")){
                e="blocked";
            }
            else if(d.equals("empty")){
                wrongnum++;
                System.out.println("please entre correct password and number");
            }
        }
        if(d.equals("nonempty")){
            Loginmenu.loginmenudecision();
        } else if (e.equals("blocked")) {
            Interface.openingmenudecision();
        }

    }
    public static String loginn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("entre your phone number");
        String number=sc.nextLine();
        String check=checkblocknumber(number);
        if(check.equals("no")){
            System.out.println("entre your password");
            String pass = sc.nextLine();
            cpnumber=sqlcheck(number,pass);
        }
        else if(check.equals("yes")){
            System.out.println("your account is blocked");
            return "blocked";
        }
        if(cpnumber!=""){
            return "nonempty";
        }
        return "empty";
    }
    public static String sqlcheck(String number,String pass){
        String phonenumber = "";
        String passwordd;
        String url = "jdbc:mysql://localhost:3306/ticket_booking";
        String username = "root";
        String password = "Chaitanya@098";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT Mobile_number,Password FROM accountdetails";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                phonenumber = rs.getString("Mobile_number");
                passwordd = rs.getString("Password");
                if(number.equals(phonenumber)){
                    blocknumber=number;
                    if(pass.equals(password)){
                        System.out.println("passed");
                        cpnumber=phonenumber;
                        return cpnumber;
                    }
                }
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cpnumber;
    }
    public static void blockednumberadder(String num){
        String url="jdbc:mysql://localhost:3306/ticket_booking";
        try{
            Connection con= DriverManager.getConnection(url,"root","Chaitanya@098");
            Statement st=con.createStatement();
            String sql="insert into blockednumber (phonenumber)"+"values(?)";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1,num);
            preparedStmt.execute();
            System.out.println("your account is blocked after giving 6 times of wrong details");
            con.close();
        } catch (SQLException e) {
            java.lang.System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public static String checkblocknumber(String phonenumber){
        String phonenumbersql="";
        String isthere="no";
        String url = "jdbc:mysql://localhost:3306/ticket_booking";
        String username = "root";
        String password = "Chaitanya@098";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT phonenumber FROM blockednumber";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                phonenumbersql = rs.getString("phonenumber");
                if(phonenumbersql.equals(phonenumber)){
                    isthere="yes";
                }
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isthere;
    }

}
