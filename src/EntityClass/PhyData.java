package EntityClass;

public class PhyData {
    private final String userName;
    private double height;
    private double weight;
    private int experience;
    private String major;
    private double BFR;

    public PhyData(String userName, double height, double weight, int experience, String major, double BFR) {
        this.userName = userName;
        this.height = height;
        this.weight = weight;
        this.experience = experience;
        this.major = major;
        this.BFR = BFR;
    }

    public String getUserName() {
        return userName;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getBFR() {
        return BFR;
    }

    public void setBFR(double BFR) {
        this.BFR = BFR;
    }

    @Override
    public String toString() {
        return "PhyData{" +
                "userName='" + userName + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", experience=" + experience +
                ", major='" + major + '\'' +
                ", BFR=" + BFR +
                '}';
    }
}
