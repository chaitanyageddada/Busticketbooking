import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Ticketbooking {
    private String Source;
    private String Destination;
    private String Date;
    private String NumberOfPassengers;

    static int Serialno;
    private List<PassangerDetails> Details;

    static List<Ticketbooking> tickets=new ArrayList<>();


    public Ticketbooking() {

    }
    public Ticketbooking(String source, String destination, String date, String numberOfPassengers,List listdetails) {
        Source = source;
        Destination = destination;
        Date = date;
        NumberOfPassengers = numberOfPassengers;
        Details=listdetails;
    }
    public static void booking() {
        Scanner sc = new Scanner(System.in);

        System.out.println("entre yours source destination");
        String sourcedestination = destination();

        System.out.println("entre yours to destination");
        String todestination = destination();

        System.out.println("entre yours Date of travel");
        String dateoftravel =checker();

        String numberofpassengers=Ticketbooking.setNumberOfPassengers(nmpassengers());

        List<PassangerDetails> pass=PassangerDetails.listdetails(numberofpassengers);

        Ticketbooking ticket= new Ticketbooking(sourcedestination,todestination,dateoftravel,numberofpassengers,pass);

        tickets.add(ticket);

        Viewbookings.currentticket();
        String a=yesorno();
        if(a.equals("yes")){
            updatesql(sourcedestination,todestination,dateoftravel,numberofpassengers,Loginaccount.cpnumber,String.valueOf(Viewbookings.fare));
            for(int i=0;i<Ticketbooking.tickets.get(0).getDetails().size();i++){
                String FullName=Ticketbooking.tickets.get(0).getDetails().get(i).getFullName();
                String Gender=Ticketbooking.tickets.get(0).getDetails().get(i).getGender();
                String Age=Ticketbooking.tickets.get(0).getDetails().get(i).getAge();
                PassangerDetails.updatesql(FullName,Gender,Age,Integer.parseInt(PassangerDetails.returnsql()));
            }
        }
    }
    public static void updatesql(String sourcedestination,String todestination,String dateoftravel,String numberOfPassengers,String phonenumber, String fare){
        String url="jdbc:mysql://localhost:3306/ticket_booking";
        try{
            Connection con= DriverManager.getConnection(url,"root","Chaitanya@098");
            Statement st=con.createStatement();
            String sql="insert into ticketbooking (Source,Destination,Date,Numberofpassangers,Phonenumber,Fare)"+"values(?,?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setString(1,sourcedestination);
            preparedStmt.setString(2,todestination);
            preparedStmt.setString(3,dateoftravel);
            preparedStmt.setString(4,numberOfPassengers);
            preparedStmt.setString(5,phonenumber);
            preparedStmt.setString(6,fare);
            preparedStmt.execute();
            con.close();
        } catch (SQLException e) {
            java.lang.System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void setSerialno(int serialno) {
        Serialno = serialno;
    }

    public static String delectotnot(){
        Scanner sc=new Scanner(System.in);
        String to="";
        Boolean d=false;
        System.out.println("1.yes\n 2.no");
        while (d!=true){
            System.out.println("entre your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("YOUR TICKET IS SUCCESSFULLY DELECTED");
                    d=true;
                    to="yes";
                    break;
                case 2:
                    System.out.println("YOU HAVE OPTIONED FOR NOT DELECTING TICKET");
                    d=true;
                    break;
                default:
                    System.out.println("entre correct choice");
            }
        }
        return to;
    }
    public static void cancelticket(){
        int num=Integer.parseInt(numchecker());

        String url="jdbc:mysql://localhost:3306/ticket_booking";
        try{
            Connection con= DriverManager.getConnection(url,"root","Chaitanya@098");
            Statement st=con.createStatement();
            String sql="delete from ticketbooking where num=(?) ";
            PreparedStatement preparedStmt = con.prepareStatement(sql);
            preparedStmt.setInt(1,num);
            preparedStmt.execute();
            String sql1="delete from passangersdetails where num=(?) ";
            PreparedStatement preparedStmt1 = con.prepareStatement(sql1);
            preparedStmt1.setInt(1,num);
            preparedStmt1.execute();
            con.close();
        } catch (SQLException e) {
            java.lang.System.err.println("Got an exception!");
            e.printStackTrace();
            System.out.println(e);
        }

    }
    public static String numchecker(){
        Scanner sc=new Scanner(System.in);
        System.out.println("entre the ticket you want to cancel");
        String num=sc.nextLine();
        try{
            int a=Integer.parseInt(num);
        }
        catch (Exception a){
            System.out.println("entre correct option");
            num=numchecker();
        }
        return num;
    }
    public static String yesorno(){
        Scanner sc=new Scanner(System.in);
        String to="";
        System.out.println("Do you want to book ticket");
        Boolean d=false;
        System.out.println("1.yes\n 2.no");
        while (d!=true){
            System.out.println("entre your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("YOUR TICKET IS SUCCESSFULLY BOOKED");
                    d=true;
                    to="yes";
                    break;
                case 2:
                    System.out.println("YOUR TICKET IS SUCCESSFULLY CANCELLED");
                    d=true;
                    break;
                default:
                    System.out.println("entre correct choice");
            }
        }
        return to;
    }
    public static void fromdestination() {
        System.out.println("\n1.Delhi"
                + "\n2.Orissa"
                + "\n3.Andhrapradesh" + "\n4.Tamilnadu" + "\n5.Gujarat");
    }
    public static String destination(){
        Scanner sc=new Scanner(System.in);
        Ticketbooking.fromdestination();
        String to="";
        Boolean d=false;
        while (d!=true){
            System.out.println("entre your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    to="Delhi";
                    d=true;
                    break;
                case 2:
                    to= "Orissa";
                    d=true;
                    break;
                case 3:
                    to= "Andhrapradesh";
                    d=true;
                    break;
                case 4:
                    to= "Tamilnadu";
                    d=true;
                    break;
                case 5:
                    to= "Gujarat";
                    d=true;
                default:
                    System.out.println("entre correct distination");
            }
        }
        return to;
    }
    public static String checker(){
        Scanner sc= new Scanner(System.in);
        System.out.println("please entre the date in this formate (dd/mm/yy)");
        String date=sc.nextLine();

        try{
            int day=Integer.parseInt(date.substring(0,2));
        }
        catch (Exception day){
            System.out.println("please entre correct formate");
            date=checker();
        }
        try{
            int month=Integer.parseInt(date.substring(3,5));
        }
        catch (Exception month){
            System.out.println("please entre correct formate");
            date=checker();
        }
        try{
            int year=Integer.parseInt(date.substring(6));
        }
        catch (Exception year){
            System.out.println("please entre correct formate");
            date=checker();
        }
        Date dt= new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY");
        int cyear=Integer.parseInt(sdf.format(dt));
        int gyear=Integer.parseInt(date.substring(6));
        int day=Integer.parseInt(date.substring(0,2));
        int month=Integer.parseInt(date.substring(3,5));

        if(date.substring(0,2).length()>2 || date.substring(3,5).length()>2 || day>31 || month>12){
            System.out.println("please entre correct date or month");
            date=checker();
        }
        if(date.substring(6).length()>4||date.substring(6).length()<4 || gyear<cyear){
            System.out.println("please entre correcr year");
            date=checker();
        }
        return date;
    }

    public static String setNumberOfPassengers(String numberOfPassengers) {
        String passengers = "0";
        boolean d=false;
        while(d!=true){
            try {
                int num=Integer.parseInt(numberOfPassengers);
            }
            catch (Exception num){
                System.out.println("please entre correct number of passangers");
                numberOfPassengers=setNumberOfPassengers(nmpassengers());
            }
            d=true;
        }

        int num=Integer.parseInt(numberOfPassengers);
        if(num>=1 &&num<=4 ){
            passengers = numberOfPassengers;
        }
        else{
            System.out.println("max number of tickets can be booked is 4");
            setNumberOfPassengers(nmpassengers());
        }
        return passengers;

    }
    public static String nmpassengers(){
        Scanner sc=new Scanner(System.in);
        System.out.println("entre the number of passengers ");
        String numberofpassangers = sc.nextLine();
        return numberofpassangers;
    }

    public String getSource() {
        return Source;
    }

    public String getDestination() {
        return Destination;
    }

    public String getDate() {
        return Date;
    }

    public String getNumberOfPassengers() {
        return NumberOfPassengers;
    }

    public List<PassangerDetails> getDetails() {
        return Details;
    }
}
