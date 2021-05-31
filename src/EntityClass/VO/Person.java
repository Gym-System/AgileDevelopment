package EntityClass.VO;

import java.util.Date;

/**
 * javadoc of Person class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class Person {
    private final String userName;
    private String password;
    private String email;
    private String gender;
    private String telNo;
    private Date DoB;

    /**
     * This constructor contains major params needed to make a instance of Person class.
     * @param userName The userName of a person
     * @param password The password of a person
     * @param email The email of a person
     */
    public Person(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    /**
     * This constructor contains all params needed to make a instance of Person class.
     * @param userName The userName of a person
     * @param password The password of a person
     * @param email The email of a person
     * @param gender The gender of a person
     * @param telNo The telephone number of a person
     * @param doB The date of birth of a person
     */
    public Person(String userName, String password, String email, String gender, String telNo, Date doB) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.telNo = telNo;
        DoB = doB;
    }

    /**
     * The getter method of userName
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * The getter method of password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * The setter method of password
     * @param password The password of a person
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * The getter method of email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * The setter method of email
     * @param email The email of a person
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * The getter method of gender
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * The setter method of gender
     * @param gender The gender of a person
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * The getter method of telNo
     * @return telNo
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * The setter method of telNo
     * @param telNo he telephone number of a person
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /**
     * The getter method of DoB
     * @return DoB
     */
    public Date getDoB() {
        return DoB;
    }

    /**
     * The setter method of doB
     * @param doB The date of birth of a person
     */
    public void setDoB(Date doB) {
        DoB = doB;
    }

    /**
     * This method organize instance variables of Person class into a string array
     * @return A string array contain instance variables of Person class
     */
    public String[] toStrArray() {
        String text = "" + userName + "," + password + "," + email + "," + gender + "," + telNo + "," + DoB;
        return text.split(",");
    }

    /**
     * This method organize instance variables of Person class into a readable way
     * @return A string contains instance variables of Person class
     */
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