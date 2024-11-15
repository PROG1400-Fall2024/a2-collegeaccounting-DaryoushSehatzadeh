import javax.swing.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    //HELPER FUNCTIONS

    //Warning message function
    public static void warningMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    //String input function
    public static String stringInput(String message){
        while(true){
            String input = JOptionPane.showInputDialog(null, message);

            if (Objects.equals(input, "")) {//If name is blank, display error
                warningMessage("Please enter valid information.");
            } else return input;
        }
    }

    //Int input function
    public static Integer intInput(String message, int min, int max){
        while(true){
            String userString = JOptionPane.showInputDialog(null, message);
            if (userString == null) return null;
            else {
                try {
                    int userStringToInt = Integer.parseInt(userString);
                    if (userStringToInt >= min && userStringToInt <= max) {
                        return userStringToInt;
                    }
                    warningMessage("Please enter valid information.");
                }
                //If not an int, display error
                catch (Exception e) {
                    warningMessage("Please enter valid information.");
                }
            }
        }
    }

    //Generate report function
    public static String generateReport(ArrayList<Student> students, ArrayList<Staff> staff){
        StringBuilder report = new StringBuilder("Students: [Total:" + students.size() + "]\n");
        double studentFees = 0, staffPay = 0;
        DecimalFormat formatter = new DecimalFormat("#0.00");

        int count = 1;
        for (Student student : students){
            report.append(count).append(". ").append(student.toString()).append("\n");
            studentFees += student.getFeeSemester();
            count++;
        }

        report.append("\nStaff: [Total:").append(staff.size()).append("]\n");

        count = 1;
        for (Staff staffMember : staff){

            report.append(count).append(". ").append(staffMember.toString()).append("\n");
            staffPay += staffMember.getPayPeriod();
            count++;
        }

        report.append("\n\nResults:\nOutgoing: $").append(formatter.format(staffPay))
                .append("\nIncoming: $").append(formatter.format(studentFees))
                .append("\nTotal: $").append(formatter.format((studentFees - staffPay)));

        return report.toString();
    }

    public static void main(String[] args) {
        //Initialize Variables
        String[] options = {"Student", "Staff", "Finish"};
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Staff> staff = new ArrayList<Staff>();

        //MAIN PROGRAM LOOP, USER MUST MANUALLY EXIT
        while (true) {
            //Reset variables on each loop
            int userChoice;
            String name = "";
            String address = "";
            Integer year, yearsOfService;

            //User chooses Staff or Student
            userChoice = JOptionPane.showOptionDialog(null, "Select Student or Staff.",
                    "Accounting App", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    options, options[0]);


            //If Student option is chosen
            if (userChoice == 0) {

                //Input student info
                name = stringInput("Enter Student Name");
                if (name == null) continue; //Cancel current loop and restart if user presses exit or cancel

                address = stringInput("Enter Student Address");
                if (address == null) continue;

                year = intInput("Enter Student Year (1-4)",1,4);
                if (year == null) continue;

                //Create Student & add to Student Arraylist
                try {
                    students.add(new Student(name,address,year));

                } catch (Exception e) {
                    warningMessage("Could not create Student. Please try again.");
                }

            //If Staff option is chosen
            } else if (userChoice == 1) {

                //Input student info
                name = stringInput("Enter Staff Name");
                if (name == null) continue;

                address = stringInput("Enter Staff Address");
                if (address == null) continue;

                yearsOfService = intInput("Enter Staff Years of Service (1-29)",1,29);
                if (yearsOfService == null) continue;

                //Create Staff & add to Staff Arraylist
                try {
                    staff.add(new Staff(name,address,yearsOfService));
                } catch (Exception e) {
                    warningMessage("Could not create Staff. Please try again.");
                }

            //If user chooses to end the loop
            } else {
                break;
            }
        }
        //Output report
        JOptionPane.showMessageDialog(null, generateReport(students, staff), "Report", JOptionPane.INFORMATION_MESSAGE);
    }
}
