package EntityClass.VO;

import java.util.Objects;

/**
 * javadoc of PhyData class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class PhyData {
    private String userName;
    private double height = 0.0;
    private double weight = 0.0;
    private int experience = 0;
    private String interest = null;
    private double BFR = 0.0;

    /**
     * This constructor contains all params needed to make a instance of Person class.
     * @param userName The userName of a person
     */
    public PhyData(String userName) {
        this.userName = userName;
    }

    /**
     * This constructor contains all params needed to make a instance of Person class.
     * @param userName The userName of a person
     * @param height The height of a person
     * @param weight The weight of a person
     * @param experience The exercise experience pf a person
     * @param interest The exercise interest of a person
     * @param BFR The body fat rate of a person
     */
    public PhyData(String userName, double height, double weight, int experience, String interest, double BFR) {
        this.userName = userName;
        this.height = height;
        this.weight = weight;
        this.experience = experience;
        this.interest = interest;
        this.BFR = BFR;
    }

    /**
     * The getter method of userName
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * The getter method of height
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * The setter method of height
     * @param height The height of a person
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * The getter method of weight
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * The setter method of weight
     * @param weight The weight of a person
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * The getter method of experience
     * @return experience
     */
    public int getExperience() {
        return experience;
    }

    /**
     * The setter method of experience
     * @param experience The experience of a person
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * The getter method of interest
     * @return interest
     */
    public String getInterest() {
        return interest;
    }

    /**
     * The setter method of interest
     * @param interest The interest of a person
     */
    public void setInterest(String interest) {
        this.interest = interest;
    }

    /**
     * The getter method of BFR
     * @return BFR
     */
    public double getBFR() {
        return BFR;
    }

    /**
     * The setter method of BFR
     * @param BFR The BFR of a person
     */
    public void setBFR(double BFR) {
        this.BFR = BFR;
    }

    /**
     * This method calculate BMI of a person
     * @return BMI of a person
     */
    public double calBMI() {
        double BMI = weight / Math.pow(height/100, 2);
        return calBMI();
    }

    /**
     * This method organize instance variables of PhyData class into a string array
     * @return A string array contain instance variables of PhyData class
     */
    public String[] toStrArray() {
        String text = "" + userName + "," + height + "," + weight + "," + experience + "," +
                interest + "," + BFR;
        return text.split(",");
    }

    /**
     * This method organize instance variables of PhyData class into a readable way
     * @return A string contains instance variables of PhyData class
     */
    @Override
    public String toString() {
        return "PhyData{" +
                "userName='" + userName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", experience=" + experience +
                ", major='" + interest + '\'' +
                ", BFR=" + BFR +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhyData)) return false;
        PhyData phyData = (PhyData) o;
        return Double.compare(phyData.getHeight(), getHeight()) == 0 &&
                Double.compare(phyData.getWeight(), getWeight()) == 0 &&
                getExperience() == phyData.getExperience() &&
                Double.compare(phyData.getBFR(), getBFR()) == 0 &&
                Objects.equals(getUserName(), phyData.getUserName()) &&
                Objects.equals(getInterest(), phyData.getInterest());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getHeight(), getWeight(), getExperience(), getInterest(), getBFR());
    }
}
