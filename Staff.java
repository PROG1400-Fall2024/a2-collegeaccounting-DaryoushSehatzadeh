import java.text.DecimalFormat;

public class Staff extends Person{
    private int yearsOfService;
    private double pay;
    private double payPeriod;

    DecimalFormat formatter = new DecimalFormat("#0.00");

    public Staff(String name, String address, int yearsOfService){
        super(name, address);
        this.yearsOfService = yearsOfService;
        this.pay = 50000 + (500 * yearsOfService);
        this.payPeriod = this.pay / 26;
    }

    public double getPayPeriod(){
        return this.payPeriod;
    }

    @Override
    public String toString() {
        return "name = " + this.getName() + ", address = " + this.getAddress() + ", year = " + this.yearsOfService + ", pay = $" + formatter.format(this.pay);
    }
}
