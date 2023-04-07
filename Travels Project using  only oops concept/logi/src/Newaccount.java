import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Newaccount {
    private static java.lang.System System;
    private String FirstName;
    private String LastName;
    private  String Gender;
    private String EmailId;
    private String MobileNumber;
    private String Password;

    public Newaccount(){

    }

    public Newaccount(String firstName, String lastName, String gender, String emailId, String mobileNumber, String password) {
        FirstName = firstName;
        LastName = lastName;
        Gender = gender;
        EmailId = emailId;
        MobileNumber = mobileNumber;
        Password = password;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public String getPassword() {
        return Password;
    }
    public static void addAccount()  {
        Scanner sc = new Scanner(System.in);

        System.out.println("entre first name");
        String firstname = sc.nextLine();

        System.out.println("entre last name");
        String lastname = sc.nextLine();

        System.out.println("entre gender");
        String gender = sc.nextLine();
        maleorfemale(gender);

        String EmailId = emailidcheck();

        System.out.println("entre the phonenumber");

        String mobilenumber=moblienumbers(sc.nextLine());

        String password=passwordcheck();

        Newaccount name = new Newaccount(firstname, lastname, gender, EmailId, mobilenumber, password);

        Interface.accounts.add(name);

        System.out.println("------------------------------Account has Scuccesfully Created-----------------------------------");

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

        Matcher key=pass.matcher(phonenumber);
        if(key.matches()){
            return phonenumber;
        }
        else{
            phonenumber=moblienumbers(asker());
        }
        return phonenumber;
    }
    public static String asker(){
        System.out.println("you have entred invalid number please entre number correctly");
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
