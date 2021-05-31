package EntityClass.VO;

import java.util.Date;
import java.util.Objects;

/**
 * javadoc of LiveSession class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class LiveSession extends Course {
    private Date startTime;
    private String trainerName = null;
    private String userName = null;

    /**
     * This constructor contains major params needed to make a instance of Course class.
     * @param courseId The ID of the course
     */
    public LiveSession(long courseId) {
        super(courseId);
    }

    /**
     * This constructor contains major params needed to make a instance of LiveSession class.
     * @param subject The subject of the live session
     * @param length The length of the live session last
     * @param startTime When does the live session begin
     * @param trainerName Who is the trainer of the live session
     * @param userName Who will be taught by trainer in the live session
     */
    public LiveSession(String subject, int length, Date startTime, String trainerName, String userName) {
        super(subject, length);
        this.startTime = startTime;
        this.trainerName = trainerName;
        this.userName = userName;
    }

    /**
     * This constructor contains all params needed to make a instance of LiveSession class.
     * @param courseId The ID of the live session
     * @param subject The subject of the live session
     * @param length The length of the live session last
     * @param gift How many gifts dose the live session get
     * @param star How many star dose the live session get (between 0 and 5)
     * @param startTime When does the live session begin
     * @param trainerName Who is the trainer of the live session
     * @param userName Who will be taught by trainer in the live session
     */
    public LiveSession(long courseId, String subject, int length, int gift, double star, Date startTime, String trainerName, String userName) {
        super(courseId, subject, length, gift, star);
        this.startTime = startTime;
        this.trainerName = trainerName;
        this.userName = userName;
    }

    /**
     * The getter method of startTime
     * @return startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * The setter method of startTime
     * @param startTime When does the live session begin
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * The getter method of trainerName
     * @return trainerName
     */
    public String getTrainerName() {
        return trainerName;
    }

    /**
     * The getter method of userName
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method organize instance variables of LiveSession class into a string array
     * @return A string array contain instance variables of LiveSession class
     */
    @Override
    public String[] toStrArray() {
        String text = "" + super.getCourseId() + "," + super.getSubject() +  "," + super.getLength() + "," + super.getGift() + "," +
                super.getStar() + "," + startTime + "," + trainerName + "," + userName;
        return text.split(",");
    }

    /**
     * This method organize instance variables of LiveSession class into a readable way
     * @return A string contains instance variables of LiveSession class
     */
    @Override
    public String toString() {
        return "LiveSession{" +
                "startTime=" + startTime +
                ", trainerName='" + trainerName + '\'' +
                ", userName='" + userName + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LiveSession)) return false;
        if (!super.equals(o)) return false;
        LiveSession that = (LiveSession) o;
        return Objects.equals(getStartTime(), that.getStartTime()) &&
                Objects.equals(getTrainerName(), that.getTrainerName()) &&
                Objects.equals(getUserName(), that.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStartTime(), getTrainerName(), getUserName());
    }
}
