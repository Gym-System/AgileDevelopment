package EntityClass.VO;

/**
 * javadoc of Order class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class Order {
    private String userName;
    private long courseId;
    private double cost;

    /**
     * This constructor contains all params needed to make a instance of Person class.
     * @param courseId The ID of a course
     * @param userName The userName of a person
     * @param cost The amount of money the course cost
     */
    public Order(long courseId, String userName, double cost) {
        this.userName = userName;
        this.courseId = courseId;
        this.cost = cost;
    }

    /**
     * The getter method of userName
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * The setter method of userName
     * @param userName The userName of a person
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * The getter method of courseId
     * @return courseId
     */
    public long getCourseId() {
        return courseId;
    }

    /**
     * The setter method of courseId
     * @param courseId The ID of a course
     */
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    /**
     * The getter method of cost
     * @return cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * The setter method of cost
     * @param cost The amount of money the course cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * This method organize instance variables of Order class into a string array
     * @return A string array contain instance variables of Order class
     */
    public String[] toStrArray() {
        String text = "" + courseId  + "," + userName + "," + cost;
        return text.split(",");
    }

    /**
     * This method organize instance variables of Order class into a readable way
     * @return A string contains instance variables of Order class
     */
    @Override
    public String toString() {
        return "Order{" +
                "userName='" + userName + '\'' +
                ", courseId=" + courseId +
                ", cost=" + cost +
                '}';
    }
}
