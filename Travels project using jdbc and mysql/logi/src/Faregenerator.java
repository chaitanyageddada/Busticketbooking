import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Faregenerator {
    static HashMap<String, Integer> routs = new HashMap<>();
    public static void setrouts() {
        routs.put("DelhiOrissa", 100);
        routs.put("DelhiAndhrapradesh", 400);
        routs.put("DelhiTamilnadu", 500);
        routs.put("DelhiGujarat", 100);
        routs.put("OrissaAndhrapradesh", 100);
        routs.put("OrissaTamilnadu", 200);
        routs.put("OrissaGujarat", 400);
        routs.put("AndhrapradeshTamilnadu", 200);
        routs.put("AndhrapradeshGujarat", 500);
        routs.put("TamilnaduGujarat", 400);
    }
    public static int faregenerator() {
        setrouts();
        int fare = 0;
        for (int i=0;i<Ticketbooking.tickets.size();i++) {
                        String source = Ticketbooking.tickets.get(i).getSource();
                        String to = Ticketbooking.tickets.get(i).getDestination();
                        String n = String.valueOf(checkforweekfare(Ticketbooking.tickets.get(i).getDate()));
                        int passangers = Integer.parseInt(Ticketbooking.tickets.get(i).getNumberOfPassengers());
                        fare = fareforrout(source + to, passangers) + Integer.parseInt(n);
                        if (fare == 0) {
                            fare = fareforrout(source + to, passangers) + Integer.parseInt(n);
                        }
                        return fare;
        }
        return fare;
    }

    public static int fareforrout(String sourceto, int passangers) {
        int fare = 0;
        for (Map.Entry<String, Integer> a : Faregenerator.routs.entrySet()) {
            if (a.getKey().equals(sourceto)) {
                fare = passangers * a.getValue();
                return fare;
            }
        }
        return fare;
    }
    public static int checkforweekfare(String date){
        int fare=0;
        Calendar c=Calendar.getInstance();
        int day=Integer.parseInt(date.substring(0,2));
        int month=Integer.parseInt(date.substring(3,5));
        int year=Integer.parseInt(date.substring(6));
        c.set(year,month,day);
        int n=c.get(c.DAY_OF_WEEK);
        if(n==1||n==7){
            fare=fare+112;
        }
        return fare;
    }
}
