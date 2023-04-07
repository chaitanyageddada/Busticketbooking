import java.sql.*;
import java.util.*;

public class PassangerDetails {
    private String FullName;
    private  String Gender;
    private String Age;


    public PassangerDetails() {
    }

    public PassangerDetails(int Serialno,String fullName, String gender, String age) {
        Serialno=Ticketbooking.Serialno;
        FullName = fullName;
        Gender = gender;
        Age = age;
    }


    public static List<PassangerDetails> listdetails(String num){
        Scanner sc=new Scanner(System.in);
        List<PassangerDetails> detailsofpassangers=new ArrayList<>();
                for(int i=0;i<Integer.parseInt(num);i++){
                    System.out.println("please entre "+(i+1)+" passanger name details");
                    String fullname=sc.nextLine();

                    System.out.println("please entre "+(i+1)+" gender details");
                    String gender=sc.nextLine();
                    gender=maleorfemale(gender);

                    System.out.println("please entre "+(i+1)+" age details");
                    String age=sc.nextLine();
                    age=agecheck(age);
                    PassangerDetails person=new PassangerDetails(Ticketbooking.Serialno,fullname,gender,age);
                    detailsofpassangers.add(person);
                }
        return detailsofpassangers;
        
    }

    public static String returnsql(){
        List<String> data=new ArrayList<>();
            String num = "";
            String url = "jdbc:mysql://localhost:3306/ticket_booking";
            String username = "root";
            String password = "Chaitanya@098";
            try {
                Connection conn = DriverManager.getConnection(url, username, password);

                String sql = "SELECT num FROM ticketbooking where Phonenumber=(?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,Loginaccount.cpnumber);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    num = rs.getString("num");
                }
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return num;
    }
    public static void updatesql(String FullName,String Gender,String Age,int num){
        String url="jdbc:mysql://localhost:3306/ticket_booking";
        try{
            Connection con= DriverManager.getConnection(url,"root","Chaitanya@098");
            Statement st=con.createStatement();
            String sql="insert into passangersdetails (Fullname,Gender,Age,num)"+"values(?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1,FullName);
            preparedStmt.setString(2,Gender);
            preparedStmt.setString(3,Age);
            preparedStmt.setInt(4,num);
            preparedStmt.execute();
            con.close();
        } catch (SQLException e) {
            java.lang.System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e);
        }
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

    public static String agecheck(String age){
        String agecopy=age;
        try{
            int a=Integer.parseInt(agecopy);
        }
        catch (Exception a){
            agecopy=agecheck(agecalling());
        }
        if(Integer.parseInt(agecopy)<1){
            agecopy=agecalling();
        }
        return agecopy;
    }
    public static String agecalling(){
        System.out.println("please entre age correctly");
        Scanner sc= new Scanner(System.in);
        String age=sc.nextLine();
        return age;
    }


    public String getFullName() {
        return FullName;
    }

    public String getGender() {
        return Gender;
    }

    public String getAge() {
        return Age;
    }

}
