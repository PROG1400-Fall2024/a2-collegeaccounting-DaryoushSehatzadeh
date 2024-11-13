public class Student extends Person{
    private int year;
    private int fee;

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

    public int getFee(){
        return this.fee;
    }

    @Override
    public String toString() {
        return "name = " + this.getName() + ", address = " + this.getAddress() + ", year = " + this.getYear() + ", fee = $" + this.getFee();
    }
}
