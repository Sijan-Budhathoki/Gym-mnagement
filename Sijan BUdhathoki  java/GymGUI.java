import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;

public class GymGUI {
    private ArrayList<GymMember> member = new ArrayList<GymMember>();
    private JFrame frame;
    private JPanel homePanel;
    private JTextField idTxt, nameTxt, locationTxt, phoneTxt, emailTxt, referralSourceTxt, paidAmountTxt, removalReasonTxt, trainerNameTxt;
    private JRadioButton maleButton, femaleButton, otherButton;
    private JButton addRegularMember, addPremiumMember, activateMembership, deactivateMembership, markAttendance, upgradePlan, calculateDiscount, revertMembership, payDueAmount, display, clear, saveToFile,readFromFile;
    private JComboBox<String> membershipYearCB, membershipMonthCB, membershipDayCB;
    private JComboBox<String> dobYearCB, dobMonthCB, dobDayCB;

    public GymGUI() {
        frame = new JFrame("Sijan Budhathoki");
        frame.setSize(900, 900);
        frame.setResizable(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Gym Membership  ", SwingConstants.CENTER);
        title.setBounds(600, 20, 300, 20);
        frame.add(title);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(60, 80, 100, 30);
        frame.add(idLabel);

        idTxt = new JTextField();
        idTxt.setBounds(90, 80, 200, 25);
        frame.add(idTxt);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(60, 120, 100, 30);
        frame.add(nameLabel);

        nameTxt = new JTextField();
        nameTxt.setBounds(100, 125, 200, 25);
        frame.add(nameTxt);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(60, 160, 200, 30);
        frame.add(emailLabel);

        emailTxt = new JTextField();
        emailTxt.setBounds(100, 165, 200, 25);
        frame.add(emailTxt);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(60, 195, 200, 30);
        frame.add(phoneLabel);

        phoneTxt = new JTextField();
        phoneTxt.setBounds(100, 200, 200, 25);
        frame.add(phoneTxt);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(60, 225, 200, 30);
        frame.add(genderLabel);

        maleButton = new JRadioButton("Male");
        maleButton.setBounds(125, 230, 80, 25);
        femaleButton = new JRadioButton("Female");
        femaleButton.setBounds(210, 230, 80, 25);
        otherButton = new JRadioButton("Other");
        otherButton.setBounds(295, 230, 80, 25);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderGroup.add(otherButton);

        frame.add(maleButton);
        frame.add(femaleButton);
        frame.add(otherButton);

        JLabel dobLabel = new JLabel("DOB:");
        dobLabel.setBounds(60, 250, 200, 30);
        frame.add(dobLabel);

        dobDayCB = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dobDayCB.addItem(String.valueOf(i));
        }
        dobDayCB.setBounds(125, 255, 80, 25);
        frame.add(dobDayCB);

        dobMonthCB = new JComboBox<>(new String[]{
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        });
        dobMonthCB.setBounds(215, 255, 80, 25);
        frame.add(dobMonthCB);

        dobYearCB = new JComboBox<>();
        for (int i = 1950; i <= 2025; i++) {
            dobYearCB.addItem(String.valueOf(i));
        }
        dobYearCB.setBounds(310, 255, 80, 25);
        frame.add(dobYearCB);

        JLabel membershipStartDate = new JLabel("Membership Start Date:");
        membershipStartDate.setBounds(60, 285, 200, 30);
        frame.add(membershipStartDate);

        membershipDayCB = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            membershipDayCB.addItem(String.valueOf(i));
        }
        membershipDayCB.setBounds(200, 290, 80, 25);
        frame.add(membershipDayCB);

        membershipMonthCB = new JComboBox<>(new String[]{
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        });
        membershipMonthCB.setBounds(290, 290, 100, 25);
        frame.add(membershipMonthCB);

        membershipYearCB = new JComboBox<>();
        for (int i = 1950; i <= 2025; i++) {
            membershipYearCB.addItem(String.valueOf(i));
        }
        membershipYearCB.setBounds(400, 290, 80, 25);
        frame.add(membershipYearCB);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(60, 320, 200, 30);
        frame.add(locationLabel);

        locationTxt = new JTextField();
        locationTxt.setBounds(125, 325, 200, 25);
        frame.add(locationTxt);

        JLabel planLabel = new JLabel("Plan:");
        planLabel.setBounds(60, 390, 200, 30);
        frame.add(planLabel);

        String[] plans = {"Basic", "Standard", "Deluxe"};
        JComboBox<String> planBox = new JComboBox<>(plans);
        planBox.setBounds(100, 390, 200, 30);
        frame.add(planBox);

        JLabel regularPrice = new JLabel("Regular Plan Price:");
        regularPrice.setBounds(60, 420, 200, 30);
        frame.add(regularPrice);

        JTextField regularPriceTxt = new JTextField();
        regularPriceTxt.setBounds(180, 420, 200, 30);
        frame.add(regularPriceTxt);
        regularPriceTxt.setEditable(false);

        JLabel premiumPrice = new JLabel("Premium Plan Price:");
        premiumPrice.setBounds(60, 450, 200, 30);
        frame.add(premiumPrice);
        

        JTextField premiumPriceTxt = new JTextField();
        premiumPriceTxt.setBounds(180, 455, 200, 30);
        frame.add(premiumPriceTxt);
        premiumPriceTxt.setEditable(false);
       

        JLabel trainerName = new JLabel("Trainer name:");
        trainerName.setBounds(60, 480, 200, 30);
        frame.add(trainerName);

        JTextField trainerNameTxt = new JTextField();
        trainerNameTxt.setBounds(140, 485, 240, 30);
        frame.add(trainerNameTxt);

        JLabel referSource = new JLabel("Refer Source:");
        referSource.setBounds(60, 510, 200, 30);
        frame.add(referSource);

        JTextField referSourceTxt = new JTextField();
        referSourceTxt.setBounds(140, 515, 240, 30);
        frame.add(referSourceTxt);

        JLabel paidAmount = new JLabel("Paid Amount:");
        paidAmount.setBounds(60, 540, 200, 30);
        frame.add(paidAmount);

        JTextField paidAmountTxt = new JTextField();
        paidAmountTxt.setBounds(140, 542, 240, 30);
        frame.add(paidAmountTxt);

        JLabel removalReason = new JLabel("Removal Reason:");
        removalReason.setBounds(60, 570, 200, 30);
        frame.add(removalReason);

        JTextField removalReasonTxt = new JTextField();
        removalReasonTxt.setBounds(160, 573, 220, 30);
        frame.add(removalReasonTxt);
        
        
        JLabel discountAmountLabel = new JLabel("Discount Amount:");
        discountAmountLabel.setBounds(60, 613, 200, 30);
        frame.add(discountAmountLabel);


       JTextField discountAmounttxt = new JTextField();
       discountAmounttxt.setBounds(160, 616, 220, 30);
       frame.add(discountAmounttxt);
       discountAmounttxt.setEditable(false);


        addRegularMember = new JButton("Add Regular Member");
        addRegularMember.setBounds(550, 80, 200, 30);
        frame.add(addRegularMember);

        addPremiumMember = new JButton("Add Premium Member");
        addPremiumMember.setBounds(550, 120, 200, 30);
        frame.add(addPremiumMember);

        activateMembership = new JButton("Activate Membership");
        activateMembership.setBounds(550, 160, 200, 30);
        frame.add(activateMembership);

        deactivateMembership = new JButton("Deactivate Membership");
        deactivateMembership.setBounds(550, 200, 200, 30);
        frame.add(deactivateMembership);

        markAttendance = new JButton("Mark Attendance");
        markAttendance.setBounds(550, 260, 200, 30);
        frame.add(markAttendance);

        upgradePlan = new JButton("Upgrade Plan");
        upgradePlan.setBounds(550, 300, 200, 30);
        frame.add(upgradePlan);
        
        revertMembership = new JButton("Revert Membership");
        revertMembership.setBounds(550, 380, 200, 30);
        frame.add(revertMembership);
        
        readFromFile = new JButton("Read From File");
        readFromFile.setBounds(650, 600, 200, 30);
        frame.add(readFromFile);


        payDueAmount = new JButton("Pay Due Amount");
        payDueAmount.setBounds(550, 440, 200, 30);
        frame.add(payDueAmount);

        display = new JButton("Display");
        display.setBounds(550, 480, 200, 30);
        frame.add(display);

        clear = new JButton("Clear");
        clear.setBounds(550, 520, 200, 30);
        frame.add(clear);

        saveToFile = new JButton("Save To File");
        saveToFile.setBounds(550, 560, 200, 30);
        frame.add(saveToFile);
        
        

        JCheckBox activeStatusCheckBox = new JCheckBox("Active");
        activeStatusCheckBox.setBounds(550, 600, 100, 30);
        frame.add(activeStatusCheckBox);
        
       calculateDiscount = new JButton("Calculate Discount");
       calculateDiscount.setBounds(650, 640, 200, 30);  // same X, Y is 40 pixels below
       frame.add(calculateDiscount);
        
        

        addRegularMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int ID = Integer.parseInt(idTxt.getText());
                    String name = nameTxt.getText();
                    String email = emailTxt.getText();
                    String phone = phoneTxt.getText();
                    String location = locationTxt.getText();
                    String DOB = dobDayCB.getSelectedItem() + "-" + dobYearCB.getSelectedItem() + "-" + dobMonthCB.getSelectedItem();

                    String membershipStartDate =
                            membershipDayCB.getSelectedItem() + "-" +
                            membershipMonthCB.getSelectedItem() + "-" +
                            membershipYearCB.getSelectedItem();

                    String gender = maleButton.isSelected() ? "Male" : "Female";
                    int attendance = 0;
                    double loyaltyPoints = 0.0;
                    boolean activeStatus = activeStatusCheckBox.isSelected();

                    if (name.isEmpty() || phone.isEmpty() || location.isEmpty() || email.isEmpty() || !activeStatus) {
                        JOptionPane.showMessageDialog(frame, " Sorry the details were left empty.", "Empty Fields", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    for (GymMember gym : member) {
                        if (gym.getID() == ID) {
                            JOptionPane.showMessageDialog(frame, "Member already exists no need to add again..", "Dublicate ID", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }

                    RegularMember reg = new RegularMember(ID, name, location, phone, email, gender, DOB, membershipStartDate, attendance, loyaltyPoints, activeStatus);
                    member.add(reg);

                    String message = "Regular membar added successfully!\n\n" + "ID:" + ID + "\n" + "Email:" + email + "\n" + "Phone" + phone + "\n" + "Location:" + location + "\n" + "DOB" + DOB + "\n" + "gender:" + gender + "\n" + "MembershipStartDate:" + membershipStartDate + "\n" + "Attendance" + attendance + "\n" + "Loyalty Points:" + loyaltyPoints + "\n" + "Active Status:" + (activeStatus ? "Active" : "inactive");
                    JOptionPane.showMessageDialog(frame, message, "Successful", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter the correct values.", "Invalid input", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        //For the premium button
        addPremiumMember.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            
        {
            try{
                int ID = Integer.parseInt(idTxt.getText());
                String name = nameTxt.getText();
                String email = emailTxt.getText();
                String phone = phoneTxt.getText();
                String location = locationTxt.getText();
                String DOB = dobDayCB.getSelectedItem() + "-" + dobYearCB.getSelectedItem() + "-" + dobMonthCB.getSelectedItem();
                String membershipStartDate = membershipDayCB.getSelectedItem()  + "-" +  membershipMonthCB.getSelectedItem() + "-" + membershipYearCB.getSelectedItem();
                String gender = maleButton.isSelected() ? "Male" : "Female";
                int attendance = 0;
                double loyaltyPoints = 0.0;
                boolean activeStatus = activeStatusCheckBox.isSelected();
                
                if(name.isEmpty() || phone.isEmpty() || location.isEmpty() || email.isEmpty() || !activeStatus) {
                  JOptionPane.showMessageDialog(frame,"Please do not leave the box empty.", "Empty Fields", JOptionPane.WARNING_MESSAGE);
                  return;
                }
               //for the dublicate id 
                for(GymMember gym : member) {
                    if(gym.getID() == ID) {
                        JOptionPane.showMessageDialog(frame, "The Member ID is not available.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                //Premium Member adding them
                PremiumMember pre = new PremiumMember(ID,name,location,phone,email,gender,DOB,membershipStartDate,attendance,loyaltyPoints,activeStatus);
                member.add(pre);
                //now showing the details of the premium member
                  String message = "Successfully Added as Premium Member!\n\n"
                  + "ID: " + ID + "\n"
                  + "Full name: " + name + "\n"
                  + "Email: " + email + "\n"
                  + "Phone: " + phone + "\n"
                  + "Location: " + location + "\n"
                  + "DOB: " + DOB + "\n"
                  + "Gender: " + gender + "\n"
                  + "Membership Start Date: " + membershipStartDate + "\n"
                  + "Attendance: " + attendance + "\n"
                  + "Loyalty Points: " + loyaltyPoints + "\n"
                  + "Active Status: " + (activeStatus ? "Active" : "Inactive");
              
                 JOptionPane.showMessageDialog(frame, message, "Successful", JOptionPane.INFORMATION_MESSAGE);
                }
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Enter correct values.",
                 "INPUT INVALID", JOptionPane.WARNING_MESSAGE);

                
            }
          }
        });
        
          
        //MARK ATTENDANCE ACTION LISTENER
        markAttendance.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String input = JOptionPane.showInputDialog(
                frame,
                "Please enter your member ID",
                "Mark Attendance",
                JOptionPane.QUESTION_MESSAGE
                );
           
            //check
            if(input == null){
                return;
            }
           
            //check for empty input
            if(input.isEmpty()){
                JOptionPane.showMessageDialog(frame, "ID is mandatoryly should be filled  be filled", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }
           
            try{
                int ID = Integer.parseInt(input);
               
                //id number must be positive
                if(ID <=0){
                    JOptionPane.showMessageDialog(frame, "Positive value should be given for the member ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    return;
                }
               
                //
                GymMember gym = null;
                for(GymMember g : member){
                    if(g.getID() == ID){
                        gym = g;
                        break;
                    }
                }
               
                if(gym == null){
                    JOptionPane.showMessageDialog(frame, "The entered ID doesn't exit", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
               
               
               
                //record attendance
                gym.markAttendance();
                int updatedAttendance = gym.getAttendance();
                double updatedLoyaltyPoints = gym.getLoyaltyPoints();
                boolean activeStatus = gym.getActiveStatus();
               
                String update = "Attendance is stored successfully  for selected  member ID: " + ID + "\n\n" + "Active Status: " + (activeStatus ? "Active" : "Inactive") + "\n" + "Total Attendance: " + updatedAttendance + "\n" + "Loyalty Points: " + updatedLoyaltyPoints;
               
                JOptionPane.showMessageDialog(frame, update, "Attendance Recorded", JOptionPane.INFORMATION_MESSAGE);
               
            }
           
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Numeric value is needed.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }
            }
        });
       
        //DISPLAY ACTION LISTENER fOR REGULAR MEMBER
        display.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //display info
                JFrame displayFrame = new JFrame("Member Information");
                displayFrame.setSize(400, 400);
               
               
                //text area
                JTextArea infoDisplay = new JTextArea();
                infoDisplay.setEditable(false);
               
                //check if empty
                if(member.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "The member list is currently empty", "Empty List", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
               
                else{
                    StringBuilder build = new StringBuilder();
                    for(GymMember gym : member){
                        build.append("ID: ").append(gym.getID()).append("\n");
                        build.append("Full name: ").append(gym.getName()).append("\n");
                        build.append("Email: ").append(gym.getEmail()).append("\n");
                        build.append("Phone: ").append(gym.getPhone()).append("\n");
                        build.append("Location: ").append(gym.getLocation()).append("\n");
                        build.append("Gender: ").append(gym.getGender()).append("\n");
                        build.append("DOB: ").append(gym.getDOB()).append("\n");
                        build.append("Membership Start Date: ").append(gym.getMembershipStartDate()).append("\n");
                        build.append("Attendance: ").append(gym.getAttendance()).append("\n");
                        build.append("Loyalty Points: ").append(gym.getLoyaltyPoints()).append("\n");
                        build.append("Active Status: ").append(gym.getActiveStatus()).append("\n");
                       
                        if(gym instanceof RegularMember){
                            build.append("Member Status: Regular Member");
                        }
                       
                        else if(gym instanceof PremiumMember){
                            build.append("Member Status: Premium Member");
                
                     }
                        }
                    infoDisplay.setText(build.toString());
                }
                displayFrame.setVisible(true);
            }
        });
        // To ACTIVATE MEMBERSHIP  using ACTION LISTENER
        activateMembership.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String input = JOptionPane.showInputDialog(frame, "Should be entered  member ID", "Activate Membership", JOptionPane.QUESTION_MESSAGE);
               
                //To know the user has canceled the dialog
                if (input == null) {
                    return;
                }
               
                // For empty box 
                if (input.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Fill the information vacend box", " Input Invalid", JOptionPane.WARNING_MESSAGE);
                    return;
                }
               
                //Exception handeling
                try{
                    int ID = Integer.parseInt(input);
                   
                    //if the user enters negative number
                    if(ID <= 0){
                        JOptionPane.showMessageDialog(frame, " The Member ID should be positive +", " Input Invalid", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                   
                    GymMember gym = null;
                    for (GymMember g : member){
                        if (g.getID() == ID) {
                            gym = g;
                            break;
                        }
                    }
                   
                    //if the entered ID doesn'e exist
                    if (gym == null){
                        JOptionPane.showMessageDialog(frame, "The input ID doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                   
                    //ACTIVATE THE MEMBERSHIP
                    if (!gym.getActiveStatus()) {
                        gym.activeMembership();
                        JOptionPane.showMessageDialog(frame, "Membership for ID" + " " + ID + " " + "is active.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "Membership for ID" + " " + ID + " " + "is already active.", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
               
                catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a numeric value.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
       
       
        //DEACTIVATE MEMBERSHIP ACTION LISTENER
        deactivateMembership.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String input = JOptionPane.showInputDialog(frame, " Enter your member ID", "Membership Deactivate", JOptionPane.QUESTION_MESSAGE);
               
                //check if user canceled the dialog
                if (input == null){
                    return;
                }
               
                //check if the box is empty
                if(input.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "The required information should be filled anyhow", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    return;
                }
               
                //handling the exception 
                try{
                    int ID = Integer.parseInt(input);
                   
                    //if user enters negative number
                    if(ID <=0){
                        JOptionPane.showMessageDialog(frame, "Member ID should be positive+.", "Input Invalid", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                   
                    GymMember gym = null;
                    for(GymMember g : member){
                        if (g.getID() == ID){
                            gym = g;
                            break;
                        }
                    }
                   
                    //if the entered ID doesn't exist
                    if(gym == null){
                        JOptionPane.showMessageDialog(frame, "The entered ID doesn't exist.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                   
                    //DEACTIVATE MEMBERSHIP
                    if(gym.getActiveStatus()){
                        gym.deactiveMembership();
                        JOptionPane.showMessageDialog(frame, "Membership for ID" + " " + ID + " " + "Now been deactivated.", "Successful", JOptionPane.INFORMATION_MESSAGE);
                    }
                   
                    else{
                        JOptionPane.showMessageDialog(frame, "Membership for ID" + " " + ID + " " + "is already deactivated.", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
               
                catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Numeric value should be entered.", "Input Input", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
   
       
          //MEMBERSHIP  Reset
           revertMembership.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            String input = JOptionPane.showInputDialog(frame,"Enter your member ID", "Membership Reset", JOptionPane.QUESTION_MESSAGE);
               
            //check if user canceled the dialog
            if (input == null){
                    return;
            }
               
            //making sure if the box is empty
            if(input.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Fill the required information user.", "Input Invalid", JOptionPane.WARNING_MESSAGE);
                    return;
            }
               
            //exception being handeled
            try{//5
                    int ID = Integer.parseInt(input);
                   
                //if  enters negative number or value 
                if(ID <=0){
                        JOptionPane.showMessageDialog(frame, "Member ID nust be positive.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                   
                GymMember gym = null;
                for(GymMember g : member){
                        if (g.getID() == ID){
                            gym = g;
                            break;
                        }
                    }
                   
                //if the absent ad is not in the data
                if(gym == null){
                        JOptionPane.showMessageDialog(frame, "Entered ID doesn't exist.!!!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                   
                //membership  bring resetted
                    if(gym instanceof RegularMember){
                        String removalReason = JOptionPane.showInputDialog(frame, "Please enter your removal reason.", "Reason FOR REMOVAL", JOptionPane.QUESTION_MESSAGE);
                   
                   
                    //makeing sure the user has not left the removal empty or canceled it
                    if(removalReason == null || removalReason.isEmpty()){
                        JOptionPane.showMessageDialog(frame, "Necessary information should be filled.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                   
                    ((RegularMember) gym).revertRegularMember(removalReason);
                    gym.resetMemberShip();
                    JOptionPane.showMessageDialog(frame, "Membership for Regular Member ID" + " " + ID + " " + "has been reset." + "\n" + "Removal Reason: " + " " + removalReason, "Success", JOptionPane.INFORMATION_MESSAGE);
                }
               
                else if(gym instanceof PremiumMember){
                    ((PremiumMember)gym).revertPremiumMember();
                    gym.resetMemberShip();
                    JOptionPane.showMessageDialog(frame, "Membership for Premium Member ID" + " " + ID + " " + "has been reset.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
       
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }
        }
    });
       
       
        //UPGRADE PLAN ACTION LISTENER
        upgradePlan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(frame, "Please enter your member ID", "Upgrade Plan", JOptionPane.QUESTION_MESSAGE);
           
            //check if user canceled the dialog
            if(input == null){
                return;
            }
           
            //check if the box is empty
            if(input.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please fill in the necessary information.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }
           
            //exception handling
            try{//5
                int ID = Integer.parseInt(input);
               
                //if user enters negative number
                if(ID <=0){
                    JOptionPane.showMessageDialog(frame, "Member ID must be positive.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    return;
                }
               
                GymMember gym = null;
                for (GymMember g : member){
                    if (g.getID() == ID){
                        gym = g;
                        break;
                    }
                }
               
                //if the ID doesn't exist
                if(gym == null){
                        JOptionPane.showMessageDialog(frame, "The entered ID doesn't exist.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }
               
                //the member is a regular member making sure
                if(!(gym instanceof RegularMember)){
                    JOptionPane.showMessageDialog(frame, "Plan upgrades are available only for regular members.", "Invalid Member Type.", JOptionPane.WARNING_MESSAGE);
                    return;
                }
               
                //conforming  eligibility for upgrade
                RegularMember regularMember = (RegularMember) gym;
                if(!regularMember.getisEligibleForUpgrade()){
                    JOptionPane.showMessageDialog(frame, "Member is not eligible for an upgrade yet due to unsatisfactory attendance." + " " + "\n" + "Required attendance: " + " " + regularMember.getAttendance(), "Not eligible", JOptionPane.WARNING_MESSAGE);
                    return;
                }
               
                //directing user for choosing new plan
                String [] plans = {"Basic", "Standard", "Deluxe"};
                String newPlan = (String) JOptionPane.showInputDialog(frame, "Select your new plan: ", "Select Plan", JOptionPane.QUESTION_MESSAGE, null, plans, plans[0]);
           
           
            // canceled plan or didn't select making sure
            if(newPlan == null){
                JOptionPane.showMessageDialog(frame, "No plan selected.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }
           
            // Plan upgrading
            String result = regularMember.upgradePlan(newPlan);
            if(result.startsWith("Plan upgrade successfully")){
                JOptionPane.showMessageDialog(frame, "Membership for ID" + " " + ID + " " + "had been upgraded to" + " " + newPlan + ".\nPrice: " + " " + regularMember.getPrice(), "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(frame, result, "Upgrade Failed", JOptionPane.WARNING_MESSAGE);
            }
        }
       
            catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
           
        }
        }
    });

    //PAY DUE AMOUNT ACTION LISTENER
    payDueAmount.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            String input = JOptionPane.showInputDialog(frame, "Please enter your member ID", "Pay Due Amount", JOptionPane.WARNING_MESSAGE);
           
            //check if user canceled the dialog
            if(input == null){
                return;
            }
           
            //check if the box is empty
            if(input.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please fill in the necessary information.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }
           
            //exception handling
            try{
                int ID = Integer.parseInt(input);
               
                //if user enters negative number
                if(ID <= 0){
                    JOptionPane.showMessageDialog(frame, "Member ID must be positive.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    return;
                }
               
                GymMember gym = null;
                for (GymMember g : member){
                    if (g.getID() == ID){
                        gym = g;
                        break;
                    }
                }
               
                //if ID doesn't exist
                if (gym == null){
                    JOptionPane.showMessageDialog(frame, "The entered ID doesn't exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
               
                //check if the member is premium member
                if(!(gym instanceof PremiumMember)){
                    JOptionPane.showMessageDialog(frame,"Payment is available only for premium member.", "Invalid Member Type", JOptionPane.WARNING_MESSAGE);
                    return;
                }
               
                //calculate due amouny
                PremiumMember premiumMember = (PremiumMember) gym;
                double premiumCharge =  premiumMember.getPremiumCharge();
                double paidAmount = premiumMember.getPaidAmount();
                double dueAmount =  premiumCharge - paidAmount;
               
                if (dueAmount <= 0){
                    JOptionPane.showMessageDialog(frame, "No due amount remaining for ID " + " " + ID + ".", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
               
                //for payment amount
                String paymentInput = JOptionPane.showInputDialog(frame, "Enter payment amount (Due: " + dueAmount + "):", "Payment Amount", JOptionPane.QUESTION_MESSAGE);
               
                //check if user cancelef the payment dialog
                if(paymentInput == null){
                    return;
                }
               
                //check if the payment input is empty
                if(paymentInput.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Please fill all the required imformation.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    return;
                }
               
                //validate and process payment
                try{
                    double paymentAmount = Double.parseDouble(paymentInput);
                   
                    if(paymentAmount <= 0){
                        JOptionPane.showMessageDialog(frame, "Payment amount must be positive.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                   
                    if (paymentAmount > dueAmount){
                        JOptionPane.showMessageDialog(frame, "Payment amount cannot exceed due amount (" + dueAmount + ").", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                   
                    //Update payment
                    premiumMember.payDueAmount(paymentAmount);
                    double newPaidAmount = premiumMember.getPaidAmount();
                    boolean isFullPayment = premiumMember.getisFullPayment();
                    double discountAmount = premiumMember.getDiscountAmount();
                    double remainingAmount = premiumCharge - newPaidAmount;
                   
                    String message = "Payment successful for ID " + " " + ID + ":\n" + "Paid Amount: " + " " + newPaidAmount + "\n" + "Remaining Amount: " + " " + remainingAmount + "\n" + "Full Payment Amount: " + " " + (isFullPayment ?  "Yes" : "No");
                   
                    if (isFullPayment){
                        message += "\n Discount Amount: " + " " + discountAmount;
                    }
                   
                    JOptionPane.showMessageDialog(frame, message, "Payment Success", JOptionPane.INFORMATION_MESSAGE);
                }
               
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Please enter a valid numeric payment amount.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                }
            }
           
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }
        }
    });
//removing action listener
    clear.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to clear all the information?", "Confirm Clear", JOptionPane.YES_OPTION);
            if(confirm == JOptionPane.YES_OPTION){
       
            //clear text field
            idTxt.setText("");
            nameTxt.setText("");
            emailTxt.setText("");
            phoneTxt.setText("");
            locationTxt.setText("");
            referralSourceTxt.setText("");
            paidAmountTxt.setText("");
            removalReasonTxt.setText("");
            trainerNameTxt.setText("");
            regularPriceTxt.setText("");
            premiumPriceTxt.setText("");
            discountAmounttxt.setText("");
           
            //reset combo box
            dobDayCB.setSelectedIndex(0);
            dobMonthCB.setSelectedIndex(0);
            dobYearCB.setSelectedIndex(0);
            membershipDayCB.setSelectedIndex(0);
            membershipMonthCB.setSelectedIndex(0);
            membershipYearCB.setSelectedIndex(0);
            planBox.setSelectedIndex(0);
           
            //deslect radio button
            genderGroup.clearSelection();
            genderGroup.clearSelection();
           
            //uncheck check box
            activeStatusCheckBox.setSelected(false);
           
            //display message
            JOptionPane.showMessageDialog(frame, "All information has been cleared.", "Clear Successful", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    });
   
    //SAVE TO FILE ACTION LISTENER
    saveToFile.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            int confirm = JOptionPane.showConfirmDialog(frame, "Are you aure you want to save all members to file?", "Confirm Save", JOptionPane.YES_NO_OPTION);
           
            if(confirm == JOptionPane.YES_OPTION){
                try(PrintWriter writer = new PrintWriter("member.txt")){
                    for(GymMember member: member){
                        String memberData = member.getID() + "," + member.getName() + "," + member.getLocation() + "," + member.getPhone() + "," + member.getEmail() + "," + member.getGender() + "," + member.getDOB() + "," + member.getMembershipStartDate() + "," + member.getAttendance() + "," + member.getLoyaltyPoints() + "," + member.getActiveStatus();
                       
                        if(member instanceof RegularMember){
                            RegularMember regularMember = (RegularMember) member;
                            memberData += ",Regular," + regularMember.getplan() + "," + regularMember.getPrice() + "," + regularMember.removalReason();
                        }
                        else if(member instanceof PremiumMember){
                            PremiumMember premiumMember = (PremiumMember) member;
                            memberData += ",Premium" + premiumMember.getPersonalTrainer() + "," + premiumMember.getPaidAmount() + "," + premiumMember.getisFullPayment() + "," + premiumMember.getDiscountAmount();
                        }
                       
                        writer.println(memberData);
                    }
                   
                    JOptionPane.showMessageDialog(frame, "Members saved successfully.", "Save Successful", JOptionPane.INFORMATION_MESSAGE);
                }
               
                catch (FileNotFoundException ex){
                    JOptionPane.showMessageDialog(frame, "Members unable to save to file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
               
                catch(Exception ex){
                    JOptionPane.showMessageDialog(frame, "An unexpected error occurred while saving.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    });
    //DISPLAY ACTION LISTENER
    display.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            String input = JOptionPane.showInputDialog(frame, "Please enter your member ID", "Display Member", JOptionPane.QUESTION_MESSAGE);
           
            //check if user canceled the dialog
            if(input == null){
                return;
            }
           
            //check if the box is empty
            if(input.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Please fill in the necessary information.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }
           
            //exception handling
            try{
                int ID = Integer.parseInt(input);
               
                //if user enters negative number
                if(ID <= 0){
                    JOptionPane.showMessageDialog(frame, "Member ID must be positive.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    return;
                }
               
                GymMember gym = null;
                for (GymMember g : member){
                    if (g.getID() == ID){
                        gym = g;
                        break;
                    }
                }
               
                //if ID doesn't exist
                if (gym == null){
                    JOptionPane.showMessageDialog(frame, "The entered ID doesn't exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
               
                //DISPLAY MEMBER INFO
                StringBuilder message = new StringBuilder();
                message.append("Member Details for ID").append(ID).append(":\n\n");
               
               
                //use displayMemberInformations output
                message.append("ID: ").append(gym.getID()).append("\n");
                message.append("Name: ").append(gym.getName()).append("\n");
                message.append("Location: ").append(gym.getLocation()).append("\n");
                message.append("Phone: ").append(gym.getPhone()).append("\n");
                message.append("Email: ").append(gym.getEmail()).append("\n");
                message.append("Gender: ").append(gym.getGender()).append("\n");
                message.append("DOB: ").append(gym.getDOB()).append("\n");
                message.append("Membership Start Date: ").append(gym.getMembershipStartDate()).append("\n");
                message.append("Attendance: ").append(gym.getAttendance()).append("\n");
                message.append("Loyalty Points: ").append(gym.getLoyaltyPoints()).append("\n");
                message.append("Active Status: ").append(gym.getActiveStatus() ? "Active" : "Inactive").append("\n");
               
               
                if(gym instanceof RegularMember){
                    RegularMember regularMember = (RegularMember) gym;
                    message.append("Plan: ").append(regularMember.getplan()).append("\n");
                    message.append("Price: ").append(regularMember.getPrice()).append("\n");
                   
                    if(!regularMember.removalReason().isEmpty()){
                        message.append("Removal Reason: ").append(regularMember.removalReason()).append("\n");
                    }
                }
               
                else if(gym instanceof PremiumMember){
                    PremiumMember premiumMember = (PremiumMember) gym;
                    message.append("Personal Trainer: ").append(premiumMember.getPersonalTrainer()).append("\n");
                    message.append("Paid Amount: ").append(premiumMember.getPaidAmount()).append("\n");
                    message.append("Full Payment Status: ").append(premiumMember.getisFullPayment()).append("\n");
                   
                    double remainingAmount = premiumMember.getPremiumCharge()- premiumMember.getPaidAmount();
                    message.append("Remaining Amount: ").append(remainingAmount).append("\n");
                   
                    if(premiumMember.getisFullPayment()){
                        message.append("Discount Amount: ").append(premiumMember.getDiscountAmount()).append("\n");
                    }
                }
               
                JOptionPane.showMessageDialog(frame, message.toString(), "Member Information", JOptionPane.INFORMATION_MESSAGE);
            }
           
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }
        }
    });

// SAVE TO FILE ACTION LISTENER
    saveToFile.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int confirm = JOptionPane.showConfirmDialog(frame,
                "Are you sure you want to save all members to file?",
                "Confirm Save", JOptionPane.YES_NO_OPTION);
           
            if (confirm == JOptionPane.YES_OPTION) {
                try (PrintWriter writer = new PrintWriter("member.txt")) {
                    // Write header row with increased widths for better spacing
                    String header = String.format("%-5s %-20s %-20s %-15s %-20s %-25s %-15s %-15s %-15s %20s %-15s %-20s %-20s %-20s\n",
                        "ID", "Name", "Location", "Phone", "Email", "Membership Start Date",
                        "Plan", "Price", "Attendance", "Loyalty Points", "Active Status",
                        "Full Payment", "Discount Amount", "Net Amount Paid");
                    writer.print(header);
                    writer.println("-".repeat(270));
                   
                    // Write member data
                    for (GymMember member : member) {
                        String plan = "N/A";
                        String price = "N/A";
                        String fullPayment = "N/A";
                        String discountAmount = "N/A";
                        String netAmountPaid = "N/A";
                       
                        if (member instanceof RegularMember) {
                            RegularMember regularMember = (RegularMember) member;
                            plan = regularMember.getplan();
                            price = String.format("%.2f", regularMember.getPrice());
                        } else if (member instanceof PremiumMember) {
                            PremiumMember premiumMember = (PremiumMember) member;
                            fullPayment = String.valueOf(premiumMember.getisFullPayment());
                            discountAmount = String.format("%.2f", premiumMember.getDiscountAmount());
                            netAmountPaid = String.format("%.2f", premiumMember.getPaidAmount());
                            plan = "Premium";
                        }
                       
                       
                        String name = member.getName().length() > 20 ? member.getName().substring(0, 17) + "..." : member.getName();
                        String location = member.getLocation().length() > 20 ? member.getLocation().substring(0, 17) + "..." : member.getLocation();
                        String phone = member.getPhone().length() > 15 ? member.getPhone().substring(0, 12) + "..." : member.getPhone();
                        String email = member.getEmail().length() > 30 ? member.getEmail().substring(0, 27) + "..." : member.getEmail();
                        String membershipStartDate = member.getMembershipStartDate().length() > 25 ? member.getMembershipStartDate().substring(0, 22) + "..." : member.getMembershipStartDate();

                        String memberData = String.format("%-5d %-20s %-20s %-15s %-20s %-25s %-15s %-15s %-15d %20.2f %-15s %-20s %-20s %-20s\n",
                            member.getID(),
                            name,
                            location,
                            phone,
                            email,
                            membershipStartDate,
                            plan,
                            price,
                            member.getAttendance(),
                            member.getLoyaltyPoints(),
                            String.valueOf(member.getActiveStatus()),
                            fullPayment,
                            discountAmount,
                            netAmountPaid);
                       
                        writer.print(memberData);
                    }
                   
                    JOptionPane.showMessageDialog(frame, "Members saved successfully.",
                                                "Save Successful", JOptionPane.INFORMATION_MESSAGE);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(frame, "Members unable to save to file.",
                                                "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "An unexpected error occurred while saving.",
                                                "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    });


    //READ FROM FILE ACTION LISTENER
    readFromFile.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to load members from the file?", "Confirm Load", JOptionPane.YES_NO_OPTION);
           
            if(confirm == JOptionPane.YES_OPTION){
                try(BufferedReader reader = new BufferedReader(new FileReader("member.txt"))){
                    //clear existing member to avoid duplicates
                    member.clear();
                    String line;
                    int loadedCount = 0;
                    while ((line = reader.readLine()) != null){
                        System.out.println(" " + line);
                       
                        String[] data = line.split(",");
                       
                        //makes sure only mimium fields are required
                        if (data.length >= 11){
                            int ID =Integer.parseInt(data[0]);
                            String name = data[1].replace(";", ",");
                            String location = data[2].replace(";", ",");
                            String phone = data[3].replace(";", ",");
                            String email = data[4].replace(";", ",");
                            String gender = data[5].replace(";", ",");
                            String DOB = data[6].replace(";", ",");
                            String membershipStartDate = data[7].replace(";", ",");
                           
                            int attendance =data[8].isEmpty() ? 0 : Integer.parseInt(data[8]);
                            double loyaltyPoints =data[9].isEmpty() ? 0 : Double.parseDouble(data[9]);
                            boolean activeStatus =data[10].isEmpty() ? false : Boolean.parseBoolean(data[10]);
                           
                            if (data[11].equals("Regular") || data.length >= 15){
                                String plan = data [12];
                                double price =data[13].isEmpty() ? 0 : Double.parseDouble(data[13]);
                                String removalReason = data[14].replace(";", ",");
                                RegularMember regularMember = new RegularMember( ID, name, location, phone, email, gender, DOB, membershipStartDate, attendance, loyaltyPoints, activeStatus);
                                //regularMember.plan = plan;
                                //regularMember.price = price;
                                //regularMember.removalReason = removalReason;
                                member.add(regularMember);
                                loadedCount++;
                            }
                            else if (data[11].equals("Premium") || data.length >= 16){
                                String peronalTrainer = data [12];
                                double paidAmount = Double.parseDouble(data[13]);
                                boolean isFullPayment = Boolean.parseBoolean(data[14]);
                                double discountAmount = Double.parseDouble(data[15]);
                                PremiumMember premiumMember = new PremiumMember(ID, name, location, phone, email, gender, DOB, membershipStartDate, attendance, loyaltyPoints, activeStatus);
                                //premiumMember.personalTrainer = personalTrainer;
                                //premiumMember.paidAmount = paidAmount;
                                //premiumMember.isFullPayment = isFullPayment;
                                //premiumMember.discountAmount = discountAmount;
                                member.add(premiumMember);
                                loadedCount++;
                            }
                        }
                    }
                   
                    JOptionPane.showMessageDialog(frame, "Member(s) loaded successfully.", "Load Successful", JOptionPane.INFORMATION_MESSAGE);
                }
                catch(FileNotFoundException ex){
                    JOptionPane.showMessageDialog(frame, "File not found. Please save data first.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Invalid data format in file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(frame, "An unexpected error occurred while loading.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    });
   
   
   

   
   
    // CALCULATE DISCOUNT ACTION LISTENER
    calculateDiscount.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = JOptionPane.showInputDialog(frame, "Please enter your member ID",
                "Calculate Discount", JOptionPane.QUESTION_MESSAGE);

            // Check if user canceled the dialog
            if (input == null) {
                return;
            }

            // Check if the box is empty
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in the necessary information.",
                    "Invalid Input", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Exception handling
            try {
                int ID = Integer.parseInt(input);

                // If user enters negative number
                if (ID <= 0) {
                    JOptionPane.showMessageDialog(frame, "Member ID must be positive.",
                        "Invalid Input", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                GymMember gym = null;
                for (GymMember g : member) {
                    if (g.getID() == ID) {
                        gym = g;
                        break;
                    }
                }

                // If the entered ID doesn't exist
                if (gym == null) {
                    JOptionPane.showMessageDialog(frame, "The entered ID doesn't exist.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Check if the member is a PremiumMember
                if (!(gym instanceof PremiumMember)) {
                    JOptionPane.showMessageDialog(frame, "Discount calculation is available only for premium members.",
                        "Invalid Member Type", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                PremiumMember premiumMember = (PremiumMember) gym;
                double premiumCharge = premiumMember.getPremiumCharge();
                double paidAmount = premiumMember.getPaidAmount();
                boolean isFullPayment = premiumMember.getisFullPayment();
                double currentDiscount = premiumMember.getDiscountAmount();

                // Calculate discount only if full payment is made and no discount has been applied yet
                if (isFullPayment && currentDiscount == 0.0) {
                    double discount = premiumCharge * 0.10; // 10% discount
                    //premiumMember.setDiscountAmount(discount);
                    String message = "Discount calculated for ID " + " " + ID + ":\n" +
                        "Original Charge: " + premiumCharge + "\n" +
                        "Discount Amount: " + String.format("%.2f", discount) + "\n" +
                        "New Net Amount: " + String.format("%.2f", (premiumCharge - discount));
                    JOptionPane.showMessageDialog(frame, message, "Discount Calculated", JOptionPane.INFORMATION_MESSAGE);
                } else if (!isFullPayment) {
                    JOptionPane.showMessageDialog(frame, ID + " " + "is not eligible to calculate discount amount since full payment is due.",
                        "Not Eligible", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Discount has already been applied for ID " + " " + ID + ".\n" +
                        "Current Discount: " + String.format("%.2f", currentDiscount),
                        "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric ID.",
                    "Invalid Input", JOptionPane.WARNING_MESSAGE);
            }
        }
    });
    
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GymGUI();
    }
}
