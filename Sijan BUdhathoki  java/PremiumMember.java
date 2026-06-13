public class PremiumMember extends GymMember {
    //the attributes
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    private String personalTrainer;
    private final double premiumCharge;

    //consturctors
    public PremiumMember(int ID, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate,
                         int attendance, double loyaltyPoints, boolean activeStatus) {
        super(ID, name, location, phone, email, gender, DOB, membershipStartDate, attendance, loyaltyPoints, activeStatus);
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.premiumCharge = 50000;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    //accessor method
    public double getPaidAmount() {
        return paidAmount;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public boolean getisFullPayment() {
        return isFullPayment;
    }

    public double getPremiumCharge() {
        return premiumCharge;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public void markAttendance() {
        this.attendance++;
        this.loyaltyPoints += 5;
    }

    //method to pay due amount 
    public String payDueAmount(double amount) {
        if (isFullPayment) {
            return "Payment is completed";
        }
        if (paidAmount + amount > premiumCharge) {
            return "Error:Exceeds premium charge";
        }
        paidAmount += amount;
        double remainingAmount = premiumCharge - paidAmount;
        isFullPayment = paidAmount == premiumCharge;
        return "Payment successful .Remaining amount:" + remainingAmount;
    }

    //method to calculate discount as follows
    public String calculateDiscount() {
        if (isFullPayment) {
            discountAmount = 0.1 * premiumCharge;
            return "Discount applied :" + discountAmount;
        }
        return "No discount applied as full payment is not payed yet ";
    }

    //method to revert the member
    public void revertPremiumMember() {
        super.resetMemberShip();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    //display method
    @Override
    public void displayMemberInformation() {
        super.displayMemberInformation();
        System.out.println("Personal Trainer:" + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment Status :" + isFullPayment);
        double remainingAmount = premiumCharge - paidAmount;
        System.out.println("Remaining Amount:" + remainingAmount);
        if (isFullPayment) {
            System.out.println("Discount Amount:" + discountAmount);
        }
    }
}
