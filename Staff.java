import java.text.DecimalFormat;

public class Staff extends Person{
    private int yearsOfService;
    private double pay;

    DecimalFormat formatter = new DecimalFormat("#0.00");

    public Staff(String name, String address, int yearsOfService){
        super(name, address);
        this.yearsOfService = yearsOfService;
        this.pay = 50000 + (500 * yearsOfService);
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public int getYearsOfService(){
        return this.yearsOfService;
    }

    public double getPay(){
        return this.pay;
    }

    @Override
    public String toString() {
        return "name = " + this.getName() + ", address = " + this.getAddress() + ", year = " + this.getYearsOfService() + ", pay = $" + formatter.format(this.getPay());
    }
}
