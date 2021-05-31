package EntityClass.VO;

import java.util.Objects;

/**
 * javadoc of FavoriteVideo class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class FavoriteVideo {
    private String userName;
    private long courseId;

    /**
     * This constructor contains all params needed to make a instance of FavoriteVideo class.
     * @param userName Indicate which user liked a video
     * @param courseId Indicate the ID of the course the use liked
     */
    public FavoriteVideo(long courseId, String userName) {
        this.userName = userName;
        this.courseId = courseId;
    }

    /**
     * The getter method of getUserName
     * @return getUserName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * The setter method of userName
     * @param userName Indicate which user liked a video
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * The getter method of course
     * @return courseId
     */
    public long getCourseId() {
        return courseId;
    }

    /**
     * The setter method of courseId
     * @param courseId Indicate the ID of the course the use liked
     */
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    /**
     * This method organize instance variables of FavoriteVideo class into a string array
     * @return A string array contain instance variables of FavoriteVideo class
     */
    public String[] toStrArray() {
        String text = "" + courseId + "," + userName ;
        return text.split(",");
    }

    /**
     * This method organize instance variables of FavoriteVideo class into a readable way
     * @return A string contains instance variables of FavoriteVideo class
     */
    @Override
    public String toString() {
        return "FavoriteVideo{" +
                "userName='" + userName + '\'' +
                ", courseId=" + courseId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoriteVideo)) return false;
        FavoriteVideo that = (FavoriteVideo) o;
        return getCourseId() == that.getCourseId() &&
                Objects.equals(getUserName(), that.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getCourseId());
    }
}