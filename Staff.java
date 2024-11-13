public class Staff extends Person{
    private int yearsOfService;

    public Staff(String name, String address, int yearsOfService){
        super(name, address);
        this.yearsOfService = yearsOfService;
    }
}
