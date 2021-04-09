package EntityClass.VO;

import java.util.Date;

public class Staff extends Person {
    private String companyName;

    public Staff(String userName, String password, String email) {
        super(userName, password, email);
    }

    public Staff(String userName, String password, String email, String gender, String telNo, Date doB, String companyName) {
        super(userName, password, email, gender, telNo, doB);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String[] toStrArray() {
        String text = "" + super.getUserName() + "," + super.getPassword() + "," + super.getEmail() + "," + super.getGender() + "," +
                super.getTelNo() + "," + super.getDoB()  + "," + companyName;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "Staff{" +
                "companyName='" + companyName + '\'' +
                "} " + super.toString();
    }
}
