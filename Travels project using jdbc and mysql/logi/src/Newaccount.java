import java.sql.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Newaccount {
    private static java.lang.System System;
    public static void addAccount()  {
        Scanner sc = new Scanner(System.in);

        System.out.println("entre first name");
        String firstname = sc.nextLine();

        System.out.println("entre last name");
        String lastname = sc.nextLine();

        System.out.println("entre gender");
        String gender = sc.nextLine();
        maleorfemale(gender);

        String emailId = emailidcheck();

        System.out.println("entre the phonenumber");

        String mobilenumber=moblienumbers(sc.nextLine());

        String password=passwordcheck();

        Newaccount.sqldatataker(firstname,lastname,gender,emailId,mobilenumber,password);

        System.out.println("------------------------------Account has Scuccesfully Created-----------------------------------");

    }
    public static void sqldatataker(String firstName,String lastname,String gender,String emailId,String mobilenumber,String password ){
        String url="jdbc:mysql://localhost:3306/ticket_booking";
        try{
            Connection con= DriverManager.getConnection(url,"root","Chaitanya@098");
            Statement st=con.createStatement();
            String sql="insert into accountdetails (Firstname,Lastname,Gender,Emailid,Mobile_number,Password)"+"values(?,?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1,firstName);
            preparedStmt.setString(2,lastname);
            preparedStmt.setString(3,gender);
            preparedStmt.setString(4,emailId);
            preparedStmt.setString(5,mobilenumber);
            preparedStmt.setString(6,password);
            preparedStmt.execute();
            System.out.println("insert completc");
            con.close();
        } catch (SQLException e) {
            java.lang.System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public static String phonenumberchecker(String  mobilenumber){
        String isthere="";
        String url="jdbc:mysql://localhost:3306/ticket_booking";
        try{
            Connection con= DriverManager.getConnection(url,"root","Chaitanya@098");
            Statement st=con.createStatement();
            String sql="select Phonenumber from ticketbooking where Phonenumber=(?)";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1,mobilenumber);
            ResultSet rs= preparedStmt.executeQuery();
            while(rs.next()){
                isthere="phonenumber already exits";

                return isthere;
            }
            con.close();
        } catch (SQLException e) {
            java.lang.System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e);
        }
        return isthere;
    }
    public static String emailidcheck(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Entre the Email id");
        String email=sc.nextLine();
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null){
            System.out.println("please entre correct emailid");
            email=emailidcheck();
        }
        Matcher m = pat.matcher(email);
        if(!m.matches()){
            System.out.println("Email id should be given like having  '@' && '.'&& 'com'");
            email=emailidcheck();
        }

        return email;
    }
    public static String passwordcheck(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Entre the Password");
        String password=sc.nextLine();
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            password=passwordcheck();
        }
        Matcher m = p.matcher(password);
        if(!m.matches()){
            System.out.println("Please entre 1 special key, 1 Uppercasing letter, 1 number, min 8 digit password and max 20 digit password");
            password=passwordcheck();
        }
        return password;
    }
    public static String moblienumbers(String phonenumber)  {
        Scanner sc = new Scanner(System.in);
        Pattern pass=Pattern.compile("\\d{10}");
        String a=phonenumberchecker(phonenumber);


        Matcher key=pass.matcher(phonenumber);
        if(a.equals("phonenumber already exits")){
            System.out.println("number already exits");
            System.out.println("Entre new number ");
            phonenumber=moblienumbers(asker());

        }
        else if(key.matches()){
            return phonenumber;
        }
        else{
            System.out.println("you have entred invalid number please entre number correctly");
            phonenumber=moblienumbers(asker());
        }
        return phonenumber;
    }
    public static String asker(){

        Scanner sc= new Scanner(System.in);
        String phonenumber=sc.nextLine();
        return phonenumber;
    }
    public static String maleorfemale(String gender){
        String Gender=gender.toLowerCase();
        if(Gender.equals("male")||Gender.equals("female")){
            return gender;
        }
        else{
            maleorfemale(gendercalling());
        }
        return gender;
    }
    public static String gendercalling(){
        Scanner sc=new Scanner(System.in);
        System.out.println("please entre gender Correctly");
        String gender=sc.nextLine();
        return gender;
    }

}
