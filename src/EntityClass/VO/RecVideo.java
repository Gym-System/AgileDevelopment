package EntityClass.VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/**
 * javadoc of RecVideo class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class RecVideo extends Course {
    private final String trainerName;
    private Date uploadedTime;
    private int viewTime = 0;
    private int rateTime = 0;

    /**
     * This constructor contains major params needed to make a instance of RecVideo class.
     * @param subject The subject of the recorded video
     * @param length The length of the recorded video last
     * @param trainerName Who is the trainer of the recorded video
     */
    public RecVideo(String subject, int length, String trainerName) {
        super(subject, length);
        this.trainerName = trainerName;
        try {
            this.setUploadedTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * This constructor contains all params needed to make a instance of RecVideo class.
     * @param courseId The ID of the recorded video
     * @param subject The subject of the recorded video
     * @param length The length of the recorded video last
     * @param gift How many gifts dose the recorded video get
     * @param star How many star dose the recorded video get (between 0 and 5)
     * @param trainerName Who is the trainer of the recorded video
     * @param uploadedTime When dose the recorded video uploads
     * @param viewTime How many times did the recorded video view
     * @param rateTime How many times did the recorded video rate
     */
    public RecVideo(long courseId, String subject, int length, int gift, double star, String trainerName, Date uploadedTime, int viewTime, int rateTime) {
        super(courseId, subject, length, gift, star);
        this.trainerName = trainerName;
        this.uploadedTime = uploadedTime;
        this.viewTime = viewTime;
        this.rateTime = rateTime;
    }

    /**
     * The getter method of userName
     * @return userName
     */
    public String getUserName() {
        return trainerName;
    }

    /**
     * The getter method of uploadedTime
     * @return uploadedTime
     */
    public Date getUploadedTime() {
        return uploadedTime;
    }

    /**
     * The setter method of uploadedTime
     */
    public void setUploadedTime() throws ParseException {
        this.uploadedTime = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(
                new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).format(new Date()));
    }

    /**
     * The getter method of viewTime
     * @return viewTime
     */
    public int getViewTime() {
        return viewTime;
    }

    /**
     * The setter method of viewTime
     * @param viewTime How many times did the recorded video view
     */
    public void setViewTime(int viewTime) {
        this.viewTime = viewTime;
    }

    /**
     * The getter method of rateTime
     * @return rateTime
     */
    public int getRateTime() {
        return rateTime;
    }

    /**
     * The setter method of rateTime
     * @param rateTime How many times did the recorded video rate
     */
    public void setRateTime(int rateTime) {
        this.rateTime = rateTime;
    }

    /**
     * This method organize instance variables of RecVideo class into a string array
     * @return A string array contain instance variables of RecVideo class
     */
    @Override
    public String[] toStrArray() {
        String text = "" + super.getCourseId() + "," + super.getSubject() + "," + super.getLength() + "," + super.getGift() + "," +
                super.getStar() + "," + trainerName + "," + uploadedTime + "," + viewTime + "," + rateTime;
        return text.split(",");
    }

    /**
     * This method organize instance variables of RecVideo class into a readable way
     * @return A string contains instance variables of RecVideo class
     */
    @Override
    public String toString() {
        return "RecVideo{" +
                "trainerName='" + trainerName + '\'' +
                ", uploadedTime=" + uploadedTime +
                ", viewTime=" + viewTime +
                ", rateTime=" + rateTime +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecVideo)) return false;
        if (!super.equals(o)) return false;
        RecVideo recVideo = (RecVideo) o;
        return getViewTime() == recVideo.getViewTime() &&
                getRateTime() == recVideo.getRateTime() &&
                Objects.equals(trainerName, recVideo.trainerName) &&
                Objects.equals(getUploadedTime(), recVideo.getUploadedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trainerName, getUploadedTime(), getViewTime(), getRateTime());
    }
}
