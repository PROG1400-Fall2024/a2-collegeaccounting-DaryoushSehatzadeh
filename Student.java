import java.text.DecimalFormat;

public class Student extends Person{
    private int year;
    private double fee;

    DecimalFormat formatter = new DecimalFormat("#0.00");

    public Student(String name, String address, int year) {
        super(name, address);
        this.year = year;
        this.fee = 3000 + (year * 100);
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public int getYear(){
        return this.year;
    }

    public double getFee(){
        return this.fee;
    }

    @Override
    public String toString() {
        return "name = " + this.getName() + ", address = " + this.getAddress() + ", year = " + this.getYear() + ", fee = $" + formatter.format(this.getFee());
    }
}
