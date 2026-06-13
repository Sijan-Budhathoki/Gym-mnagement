//inherit
public class RegularMember extends GymMember {
    //the private attributes are as follows
    private double price;
    private String plan;
    private String removalReason;
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String referralSource;

    //the constructors are as follows
    public RegularMember(int ID, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate,
                         int attendance, double loyaltyPoints, boolean activeStatus) {
        super(ID, name, location, phone, email, gender, DOB, membershipStartDate, attendance, loyaltyPoints, activeStatus);
        this.attendanceLimit = 30;
        this.isEligibleForUpgrade = false;
        this.removalReason = "";
        this.referralSource = referralSource;
        this.plan = "basic";
        this.price = 6500;
    }

    //the accessor method 
    public String getplan() {
        return this.plan;
    }

    public double getPrice() {
        return this.price;
    }

    public String getreferralSource() {
        return this.referralSource;
    }

    public String removalReason() {
        return this.removalReason;
    }

    public int getattendanceLimit() {
        return this.attendanceLimit;
    }

    public boolean getisEligibleForUpgrade() {
        return this.isEligibleForUpgrade;
    }

    @Override
    public void markAttendance() {
        attendance++;
        loyaltyPoints += 5;
        if (attendance >= attendanceLimit) {
            isEligibleForUpgrade = true;
        }
    }

    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic": return 6500;
            case "standard": return 12500;
            case "deluxe": return 18500;
            default: return -1;
        }
    }

    //Resetting a member  if  a member quits
    public void revertRegularMember(String removalReason) {
        resetMemberShip(); //this is the parent class
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    //upgrading the plans
    public String upgradePlan(String newPlan) {
        if (!isEligibleForUpgrade) {
            return " The member is unable to get upgarde cause of low requirement";
        }

        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) {
            return "The plan is invalid";
        }

        if (this.plan.equalsIgnoreCase(newPlan)) {
            return "Member is  already the part of the plan";
        }

        this.plan = newPlan;
        this.price = newPrice;
        return "Successful Plan Upgraded" + newPlan;
    }

    @Override
    public void displayMemberInformation() {
        super.displayMemberInformation(); //parents class display method
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason : " + removalReason);
        }
    }
}
