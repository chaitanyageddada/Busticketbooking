import java.sql.*;

public class Viewbookings {
    static int fare=0;
    public static void ticketbookingsql(){
         String source;
         String destination;
         String date;
         int num;
         String faree;
         String passangername;
         String gender;
         String age;
        String url = "jdbc:mysql://localhost:3306/ticket_booking";
        String username = "root";
        String password = "Chaitanya@098";
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT Source,Destination,Date,num,Fare FROM ticketbooking where Phonenumber =(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,Loginaccount.cpnumber);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                source = rs.getString("Source");
                destination = rs.getString("Destination");
                date=rs.getString("Date");
                num=rs.getInt("num");
                faree=rs.getString("Fare");
                String sql1 = "SELECT Fullname,Gender,Age FROM passangersdetails where num =(?)";
                PreparedStatement pstmt1 = conn.prepareStatement(sql1);
                pstmt1.setInt(1, num);
                ResultSet rs1 = pstmt1.executeQuery();
                System.out.println("TiCKET NUMBER "+num);
                System.out.println("******************************************************************");
                System.out.println("**   NAME OF PASSANGER      |   GENDER   |  AGE  ******");
                System.out.println("******************************************************************");
                while(rs1.next()){
                    passangername=rs1.getString("Fullname");
                    gender=rs1.getString("Gender");
                    age=rs1.getString("Age");
                    System.out.println("**   "  + passangername + "             " + gender + "        " + age + "        **");
                }
                System.out.println("");
                System.out.println("YOUR DATE OF TRAVEL IS "+date+" --------------------------------");
                System.out.println("");
                System.out.println("YOU ARE TRAVELLING FROM "+source+" TO "+destination+"---------------------------------------");
                System.out.println("-------------------------------------------------------------------");
                System.out.println("**********************************************TOTAL = "+faree+"********");
                System.out.println("--------------------------------------------------------------------");
                System.out.println("******************************************************************");
                System.out.println("*******************************************************************\n");

            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void currentticket(){
        fare=Faregenerator.faregenerator();
        for (int i=0;i<Ticketbooking.tickets.size();i++) {
                    System.out.println("******************************************************************");
                    System.out.println("**   NAME OF PASSANGER      |   GENDER   |  AGE  |   FARE   ******");
                    System.out.println("******************************************************************");
                    for (int j = 0; j<Ticketbooking.tickets.get(i).getDetails().size(); j++) {

                        System.out.println("**   " + (j+1) + ".)" + Ticketbooking.tickets.get(i).getDetails().get(j).getFullName() + "             " + Ticketbooking.tickets.get(i).getDetails().get(j).getGender()  + "        " + Ticketbooking.tickets.get(i).getDetails().get(j).getAge() + "        **");

                    }
                    System.out.println("");
                    System.out.println("YOUR DATE OF TRAVEL IS "+Ticketbooking.tickets.get(i).getDate() +" --------------------------------");
                    System.out.println("");
                    System.out.println("YOU ARE TRAVELLING FROM "+Ticketbooking.tickets.get(i).getSource()+" TO "+Ticketbooking.tickets.get(i).getDestination()+"---------------------------------------");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("**********************************************TOTAL = "+fare+"********");
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("******************************************************************");
                    System.out.println("*******************************************************************\n");

            }
        }
    }

