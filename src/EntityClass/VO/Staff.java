package EntityClass.VO;

import java.util.Date;

/**
 * javadoc of Staff class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class Staff extends Person {
    private String companyName;

    /**
     * This constructor contains major params needed to make a instance of Staff class.
     * @param userName The userName of a staff
     * @param password The password of a staff
     * @param email The email of a staff
     */
    public Staff(String userName, String password, String email) {
        super(userName, password, email);
    }

    /**
     * This constructor contains all params needed to make a instance of Staff class.
     * @param userName The userName of a staff
     * @param password The password of a staff
     * @param email The email of a staff
     * @param gender The gender of a staff
     * @param telNo The telephone number of a staff
     * @param doB The date of birth of a staff
     * @param companyName Name of the company staff is in
     */
    public Staff(String userName, String password, String email, String gender, String telNo, Date doB, String companyName) {
        super(userName, password, email, gender, telNo, doB);
        this.companyName = companyName;
    }

    /**
     * The getter method of companyName
     * @return companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * The setter method of companyName
     * @param companyName Name of the company staff is in
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * This method organize instance variables of Staff class into a string array
     * @return A string array contain instance variables of Staff class
     */
    @Override
    public String[] toStrArray() {
        String text = "" + super.getUserName() + "," + super.getPassword() + "," + super.getEmail() + "," + super.getGender() + "," +
                super.getTelNo() + "," + super.getDoB()  + "," + companyName;
        return text.split(",");
    }

    /**
     * This method organize instance variables of Staff class into a readable way
     * @return A string contains instance variables of Staff class
     */
    @Override
    public String toString() {
        return "Staff{" +
                "companyName='" + companyName + '\'' +
                "} " + super.toString();
    }
}
