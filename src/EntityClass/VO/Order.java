package EntityClass.VO;

public class Order {
    private String userName;
    private long courseId;
    private double cost;

    public Order(long courseId, String userName, double cost) {
        this.userName = userName;
        this.courseId = courseId;
        this.cost = cost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String[] toStrArray() {
        String text = "" + courseId  + "," + userName + "," + cost;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "Order{" +
                "userName='" + userName + '\'' +
                ", courseId=" + courseId +
                ", cost=" + cost +
                '}';
    }
}
