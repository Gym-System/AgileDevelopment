package EntityClass.VO;

import java.util.Objects;

/**
 * javadoc of Regulation class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class Regulation {
    private int userType = 0;
    private double startMoney;
    private double endMoney;
    private double presentOff;

    /**
     * This constructor contains all params needed to make a instance of Regulation class.
     * @param userType  The user type of the regulation
     * @param startMoney The start money of the regulation
     * @param endMoney The end money of the regulation
     * @param presentOff The discount of the regulation
     */
    public Regulation(int userType, double startMoney, double endMoney, double presentOff) {
        this.userType = userType;
        this.startMoney = startMoney;
        this.endMoney = endMoney;
        this.presentOff = presentOff;
    }

    /**
     * The getter method of userType
     * @return userType
     */
    public int getUserType() {
        return userType;
    }

    /**
     * The setter method of userType
     * @param userType The userType of a regulation
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     * The getter method of startMoney
     * @return startMoney
     */
    public double getStartMoney() {
        return startMoney;
    }

    /**
     * The setter method of startMoney
     * @param startMoney The startMoney of a regulation
     */
    public void setStartMoney(double startMoney) {
        this.startMoney = startMoney;
    }

    /**
     * The getter method of endMoney
     * @return endMoney
     */
    public double getEndMoney() {
        return endMoney;
    }

    /**
     * The setter method of endMoney
     * @param endMoney The endMoney of a regulation
     */
    public void setEndMoney(double endMoney) {
        this.endMoney = endMoney;
    }

    /**
     * The getter method of presentOff
     * @return presentOff
     */
    public double getPresentOff() {
        return presentOff;
    }

    /**
     * The setter method of presentOff
     * @param presentOff The presentOff of a regulation
     */
    public void setPresentOff(double presentOff) {
        this.presentOff = presentOff;
    }

    /**
     * This method organize instance variables of Regulation class into a string array
     * @return A string array contain instance variables of Regulation class
     */
    public String[] toStrArray() {
        String text = "" + userType + "," + startMoney + "," + endMoney + "," + presentOff;
        return text.split(",");
    }

    /**
     * This method organize instance variables of Regulation class into a readable way
     * @return A string contains instance variables of Regulation class
     */
    @Override
    public String toString() {
        return "Regulation{" +
                "userType=" + userType +
                ", startMoney=" + startMoney +
                ", endMoney=" + endMoney +
                ", presentOff=" + presentOff +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Regulation)) return false;
        Regulation that = (Regulation) o;
        return getUserType() == that.getUserType() &&
                Double.compare(that.getStartMoney(), getStartMoney()) == 0 &&
                Double.compare(that.getEndMoney(), getEndMoney()) == 0 &&
                Double.compare(that.getPresentOff(), getPresentOff()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserType(), getStartMoney(), getEndMoney(), getPresentOff());
    }
}
