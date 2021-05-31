package EntityClass.VO;

import java.util.Objects;

/**
 * javadoc of WatchedVideo class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class WatchedVideo {
    private String userName;
    private String type;
    private long courseId;

    /**
     * This constructor contains all params needed to make a instance of Person WatchedVideo.
     * @param userName The userName of a person
     * @param type Which type the course is
     * @param courseId The ID of a course
     */
    public WatchedVideo(String userName, String type, long courseId) {
        this.userName = userName;
        this.type = type;
        this.courseId = courseId;
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
     * The getter method of type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * The setter method of type
     * @param type Which type the course is
     */
    public void setType(String type) {
        this.type = type;
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
     * This method organize instance variables of WatchedVideo class into a string array
     * @return A string array contain instance variables of WatchedVideo class
     */
    public String[] toStrArray() {
        String text = "" + userName + "," + type + "," + courseId;
        return text.split(",");
    }

    /**
     * This method organize instance variables of WatchedVideo class into a readable way
     * @return A string contains instance variables of WatchedVideo class
     */
    @Override
    public String toString() {
        return "WatchedVideo{" +
                "userName='" + userName + '\'' +
                ", type='" + type + '\'' +
                ", courseId=" + courseId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WatchedVideo)) return false;
        WatchedVideo that = (WatchedVideo) o;
        return getCourseId() == that.getCourseId() &&
                Objects.equals(getUserName(), that.getUserName()) &&
                Objects.equals(getType(), that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getType(), getCourseId());
    }
}