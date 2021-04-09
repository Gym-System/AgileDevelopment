package EntityClass.VO;

import java.util.Date;

public class Trainer extends Staff {
    private double salary = 0.0;

    public Trainer(String userName, String password, String email) {
        super(userName, password, email);
    }

    public Trainer(String userName, String password, String email, String gender, String telNo, Date doB, String companyName) {
        super(userName, password, email, gender, telNo, doB, companyName);
    }

    public Trainer(String userName, String password, String email, String gender, String telNo, Date doB, String companyName, double salary) {
        super(userName, password, email, gender, telNo, doB, companyName);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String[] toStrArray() {
        String text = "" + super.getUserName() + "," + super.getPassword() + "," + super.getEmail() + "," + super.getGender() + "," +
                super.getTelNo() + "," + super.getDoB() + "," + super.getCompanyName() + "," + salary;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "salary=" + salary +
                "} " + super.toString();
    }
}
