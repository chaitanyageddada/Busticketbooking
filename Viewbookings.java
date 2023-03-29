import java.util.List;
import java.util.Map;

public class Viewbookings {
    public static void printticcket() {
        if(Ticketbooking.Bookedtickets.size()==0){
            System.out.println("There are No Bookings");
        }
        else {
            for (Map.Entry<String, List<Ticketbooking>> a : Ticketbooking.Bookedtickets.entrySet()) {
                if (a.getKey().equals(Loginaccount.cpnumber)) {
                    for (int i = 0; i < a.getValue().size(); i++) {
                        System.out.println("****"+(i+1)+"ticket****");
                        System.out.println("******************************************************************");
                        System.out.println("**   NAME OF PASSANGER      |   GENDER   |  AGE  |   FARE   ******");
                        System.out.println("******************************************************************");
                        for (int j = 0; j < a.getValue().get(i).getDetails().size(); j++) {

                            System.out.println("**   " + (i+1) + ".)" + a.getValue().get(i).getDetails().get(j).getFullName() + "             " + a.getValue().get(i).getDetails().get(j).getGender() + "        " + a.getValue().get(i).getDetails().get(j).getAge() + "        **");

                        }
                        System.out.println("");
                        System.out.println("YOUR DATE OF TRAVEL IS "+a.getValue().get(i).getDate()+" --------------------------------");
                        System.out.println("");
                        System.out.println("YOU ARE TRAVELLING FROM "+a.getValue().get(i).getSource()+" TO "+a.getValue().get(i).getDestination()+"---------------------------------------");
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println("**********************************************TOTAL = "+Faregenerator.faregenerator()+"********");
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println("******************************************************************");
                        System.out.println("*******************************************************************\n");
                    }

                }
            }
        }

    }
    public static void currentticket(){
        Ticketbooking b = null;
        for (Map.Entry<String, List<Ticketbooking>> a : Ticketbooking.Bookedtickets.entrySet()) {
            if (a.getKey().equals(Loginaccount.cpnumber)) {
                b= a.getValue().get(a.getValue().size()-1);
                    System.out.println("******************************************************************");
                    System.out.println("**   NAME OF PASSANGER      |   GENDER   |  AGE  |   FARE   ******");
                    System.out.println("******************************************************************");
                    for (int j = 0; j < a.getValue().get(a.getValue().size()-1).getDetails().size(); j++) {

                        System.out.println("**   " + (j+1) + ".)" + a.getValue().get(a.getValue().size()-1).getDetails().get(j).getFullName() + "             " + a.getValue().get(a.getValue().size()-1).getDetails().get(j).getGender() + "        " + a.getValue().get(a.getValue().size()-1).getDetails().get(j).getAge() + "        **");

                    }
                    System.out.println("");
                    System.out.println("YOUR DATE OF TRAVEL IS "+a.getValue().get(a.getValue().size()-1).getDate()+" --------------------------------");
                    System.out.println("");
                    System.out.println("YOU ARE TRAVELLING FROM "+a.getValue().get(a.getValue().size()-1).getSource()+" TO "+a.getValue().get(a.getValue().size()-1).getDestination()+"---------------------------------------");
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("**********************************************TOTAL = "+Faregenerator.faregenerator()+"********");
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("******************************************************************");
                    System.out.println("*******************************************************************\n");
                }

            }
        }
    }

