package EntityClass.VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RecVideo extends Course {
    private Date uploadedTime;
    private int viewTime = 0;
    private int rateTime = 0;
    private final String subject;

    public RecVideo(String subject, int length, String trainerName) {
        super(length, trainerName);
        this.subject = subject;
        try {
            this.setUploadedTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public RecVideo(long courseId, String subject, int length, int gift, double star, String trainerName, Date uploadedTime, int viewTime, int rateTime) {
        super(courseId, length, gift, star, trainerName);
        this.subject = subject;
        this.uploadedTime = uploadedTime;
        this.viewTime = viewTime;
        this.rateTime = rateTime;
    }

    public Date getUploadedTime() {
        return uploadedTime;
    }

    public void setUploadedTime() throws ParseException {
        this.uploadedTime = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(
                new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).format(new Date()));
    }

    public int getViewTime() {
        return viewTime;
    }

    public void setViewTime(int viewTime) {
        this.viewTime = viewTime;
    }

    public int getRateTime() {
        return rateTime;
    }

    public void setRateTime(int rateTime) {
        this.rateTime = rateTime;
    }

    @Override
    public String[] toStrArray() {
        String text = "" + super.getCourseId() + "," + subject + "," + super.getLength() + "," + super.getGift() + "," +
                super.getStar() + "," + super.getTrainerName() + "," + uploadedTime + "," + viewTime + "," + rateTime;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "RecVideo{" +
                "uploadedTime=" + uploadedTime +
                ", viewTime=" + viewTime +
                ", rateTime=" + rateTime +
                ", subject='" + subject + '\'' +
                "} " + super.toString();
    }
}
