package EntityClass.VO;

import java.util.Date;

public class PremierUser extends User {
    private int userType = 1;

    public PremierUser(String userName, String password, String email) {
        super(userName, password, email);
    }

    public PremierUser(String userName, String password, String email, String gender, String telNo, Date doB) {
        super(userName, password, email, gender, telNo, doB);
    }

    public PremierUser(String userName, String password, String email, String gender, String telNo, Date doB, double balance, int userType) {
        super(userName, password, email, gender, telNo, doB, balance);
        this.userType = userType;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public double calDiscount(double price) {
        double discount = price * (1 - userType /10);

        return discount;
    }

    @Override
    public String[] toStrArray() {
        String text = "" + super.getUserName() + "," + super.getPassword() + "," + super.getEmail() + "," +
                super.getGender() + "," + super.getTelNo() + "," + super.getDoB() + "," + super.getBalance() + "," +
                userType;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "PremierUser{" +
                "userType=" + userType +
                "} " + super.toString();
    }
}
