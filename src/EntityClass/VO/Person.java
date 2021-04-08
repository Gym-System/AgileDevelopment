package EntityClass.VO;

import java.util.Date;

public class Person {
    private final String userName;
    private String password;
    private String email;
    private String gender;
    private String telNo;
    private Date DoB;

    public Person(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Person(String userName, String password, String email, String gender, String telNo, Date doB) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.telNo = telNo;
        DoB = doB;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date doB) {
        DoB = doB;
    }

    public String[] toStrArray() {
        String text = "" + userName + "," + password + "," + email + "," + gender + "," + telNo + "," + DoB;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", telNo='" + telNo + '\'' +
                ", DoB=" + DoB +
                '}';
    }
}
