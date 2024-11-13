import java.text.DecimalFormat;

public class Student extends Person{
    private int year;
    private double fee;
    private double feeSemester;

    DecimalFormat formatter = new DecimalFormat("#0.00");

    public Student(String name, String address, int year) {
        super(name, address);
        this.year = year;
        this.fee = 3000 + (year * 100);
        this.feeSemester = this.fee / 2;
    }

    public double getFeeSemester(){
        return this.feeSemester;
    }

    @Override
    public String toString() {
        return "name = " + this.getName() + ", address = " + this.getAddress() + ", year = " + this.year + ", fee = $" + formatter.format(this.fee);
    }
}
