package EntityClass.VO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RecVideo extends Course {
    private final String trainerName;
    private Date uploadedTime;
    private int viewTime = 0;
    private int rateTime = 0;

    public RecVideo(String subject, int length, String trainerName) {
        super(subject, length);
        this.trainerName = trainerName;
        try {
            this.setUploadedTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public RecVideo(long courseId, String subject, int length, int gift, double star, String trainerName, Date uploadedTime, int viewTime, int rateTime) {
        super(courseId, subject, length, gift, star);
        this.trainerName = trainerName;
        this.uploadedTime = uploadedTime;
        this.viewTime = viewTime;
        this.rateTime = rateTime;
    }

    public String getUserName() {
        return trainerName;
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
        String text = "" + super.getCourseId() + "," + super.getSubject() + "," + super.getLength() + "," + super.getGift() + "," +
                super.getStar() + "," + trainerName + "," + uploadedTime + "," + viewTime + "," + rateTime;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "RecVideo{" +
                "trainerName='" + trainerName + '\'' +
                ", uploadedTime=" + uploadedTime +
                ", viewTime=" + viewTime +
                ", rateTime=" + rateTime +
                "} " + super.toString();
    }
}
