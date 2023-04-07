import java.util.*;

public class PassangerDetails {
    private String FullName;
    private  String Gender;
    private String Age;
    
    
    
    


//    static Map<String,ArrayList<PassangerDetails>> allpassangerdetails=new HashMap<>();

    public PassangerDetails() {
    }

    public PassangerDetails(String fullName, String gender, String age) {
        FullName = fullName;
        Gender = gender;
        Age = age;
    }


    public static List<PassangerDetails> listdetails(String num){
        Scanner sc=new Scanner(System.in);
        List<PassangerDetails> detailsofpassangers=new ArrayList<>();

                for(int i=0;i<Integer.parseInt(num);i++){

                    System.out.println("please entre "+(i+1)+" passanger details");
                    String fullname=sc.nextLine();

                    System.out.println("please entre "+(i+1)+" gender details");
                    String gender=sc.nextLine();
                    gender=maleorfemale(gender);

                    System.out.println("please entre "+(i+1)+" age details");
                    String age=sc.nextLine();
                    age=agecheck(age);

                    PassangerDetails person=new PassangerDetails(fullname,gender,age);
                    detailsofpassangers.add(person);
                }
        return detailsofpassangers;
        
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
