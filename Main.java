import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    //Helper functions

    //Warning message function
    public static void warningMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    //String input function
    public static String stringInput(String message){
        String input = "";

        while(true){
            input = JOptionPane.showInputDialog(null, message);

            if (!Objects.equals(input, "")){
                return input;
            }
            //If name is blank, display error
            warningMessage("Please enter valid information.");
        }
    }

    //Int input function
    public static int intInput(String message, int min, int max){
        int input;
        while(true){
            try {
                input = Integer.parseInt(JOptionPane.showInputDialog(null, message));
                if (input >= min && input <= max){
                    return input;
                }
            }
            //If not an int, display error
            catch(Exception e){
                warningMessage("Please enter valid information.");
            }
        }
    }

    //Generate report function
    public static String generateReport(ArrayList<Student> students, ArrayList<Staff> staff){
        StringBuilder report = new StringBuilder("Students: [Total:" + students.size() + "]\n");
        double studentFees = 0, staffPay = 0, studentTermFees = studentFees/2, staffPayPeriod = staffPay/26;

        for (Student student : students){
            int count = 1;
            report.append(count).append(". ").append(student.toString()).append("\n");
            studentFees += student.getFee();
            count++;
        }

        report.append("\nStaff: [Total:").append(staff.size()).append("]\n");

        for (Staff staffMember : staff){
            int count = 1;
            report.append(count).append(". ").append(staffMember.toString()).append("\n");
            staffPay += staffMember.getPay();
            count++;
        }

        report.append("\n\nResults:\nOutgoing: $").append(staffPayPeriod)
                .append("\nIncoming: $").append(studentTermFees)
                .append("\nTotal: $").append(studentTermFees - staffPayPeriod);

        return report.toString();
    }

    public static void main(String[] args) {
        //Initialize Variables
        String report;
        String[] options = {"Student", "Staff", "Finish"};
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Staff> staff = new ArrayList<Staff>();

        while (true) {
            //Reset variables
            int userChoice;
            String name = "";
            String address = "";
            int year, yearsOfService;

            //Choose Staff or Student
            userChoice = JOptionPane.showOptionDialog(null, "Select Student or Staff.",
                    "Accounting App", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                    options, options[0]);


            //If student (option[0]) is chosen
            if (userChoice == 0) {

                //Input student info
                name = stringInput("Enter Student Name");
                address = stringInput("Enter Student Address");
                year = intInput("Enter Student Year (1-4)",1,4);

                //Create Student
                try {
                    students.add(new Student(name,address,year));

                } catch (Exception e) {
                    warningMessage("Could not create Student. Please try again.");
                }
            } else if (userChoice == 1) {

                //Input student info
                name = stringInput("Enter Staff Name");
                address = stringInput("Enter Staff Address");
                yearsOfService = intInput("Enter Staff Years of Service (1-29)",1,29);

                //Create Student
                try {
                    staff.add(new Staff(name,address,yearsOfService));
                } catch (Exception e) {
                    warningMessage("Could not create Staff. Please try again.");
                }
            } else {
                break;
            }
            //Output report
        }
    }
}
