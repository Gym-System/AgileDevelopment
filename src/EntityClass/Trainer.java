package EntityClass;

import java.util.Date;

public class Trainer extends Staff {
    private double salary = 0.0;

    public Trainer(String userName, String password, String email) {
        super(userName, password, email);
    }

    public Trainer(String userName, String password, String email, String gender, String telNo, Date doB, String companyName) {
        super(userName, password, email, gender, telNo, doB, companyName);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "salary=" + salary +
                "} " + super.toString();
    }
}
