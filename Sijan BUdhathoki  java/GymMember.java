//parent class abstract
public abstract class GymMember {
    //Following Attributes
    protected String name;
    protected String email;
    protected String phone;
    protected int ID;
    protected String location;
    protected String gender;
    protected int attendance;
    protected String membershipStartDate;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    protected String DOB;

    //The constructors are as follows
    public GymMember(int ID, String name,String location , String phone, String email,String gender, String DOB,String membershipStartDate,
    int attendance,double loyaltyPoints, boolean activeStatus){
        this.ID=ID;
        this.name=name;
        this.location=location;
        this.phone=phone;
        this.email=email;
        this.gender=gender;
        this.DOB=DOB;
        this.membershipStartDate=membershipStartDate;
        this.attendance=0;
        this.loyaltyPoints=0;
        this. activeStatus=false;
    }

    //the accessor method are as follows
    public String getName (){
        return this .name;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhone(){
        return this.phone;
    }
    public int getID(){
        return this.ID;
    }
    public String getLocation(){
        return this.location;
    }
    public String getGender(){
        return this.gender;
    }
    public int getAttendance(){
        return this.attendance;
    }
    public String getMembershipStartDate(){
        return this.membershipStartDate;
    }
    public double getLoyaltyPoints(){
        return this.loyaltyPoints;
    }
    public boolean getActiveStatus(){
        return this.activeStatus;
    }
    public String getDOB(){
        return this.DOB;
    }

    //the abstract method
    public abstract void markAttendance();

    //regular method
    public void deactiveMembership(){
        activeStatus=false;
    }
    public void activeMembership(){
        activeStatus=true;
    }
    public void resetMemberShip(){
        activeStatus=false;
        attendance=0;
        loyaltyPoints=0;
    }

    //displaying method
    public void displayMemberInformation(){
        System.out.println("ID: " + ID );
        System.out.println("name: " + name);
        System.out.println("location: " + location);
        System.out.println("phone: " + phone);
        System.out.println("email : " + email);
        System.out.println("gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("membershipStartDate : " + membershipStartDate);
        System.out.println("attendance: "+ attendance);
        System.out.println("loyaltyPoints: " + loyaltyPoints);
        System.out.println("activeStatus:"+ activeStatus);
    }
}
