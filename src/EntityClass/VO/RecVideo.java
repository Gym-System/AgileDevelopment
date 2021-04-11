package EntityClass.VO;

import java.util.Date;

public class RecVideo extends Course {
    private final String trainerName;
    private Date uploadedTime;
    private int viewTime = 0;

    public RecVideo(String subject, int length, String trainerName, Date uploadedTime) {
        super(subject, length);
        this.trainerName = trainerName;
        this.uploadedTime = uploadedTime;
    }

    public RecVideo(long courseId, String subject, int length, int gift, double star, String trainerName, Date uploadedTime, int viewTime) {
        super(courseId, subject, length, gift, star);
        this.trainerName = trainerName;
        this.uploadedTime = uploadedTime;
        this.viewTime = viewTime;
    }

    public String getUserName() {
        return trainerName;
    }

    public Date getUploadedTime() {
        return uploadedTime;
    }

    public void setUploadedTime(Date uploadedTime) {
        this.uploadedTime = uploadedTime;
    }

    public int getViewTime() {
        return viewTime;
    }

    public void setViewTime(int viewTime) {
        this.viewTime = viewTime;
    }

    @Override
    public String[] toStrArray() {
        String text = "" + super.getSubject() + "," + super.getLength() + "," + super.getGift() + "," +
                super.getStar() + "," + trainerName + "," + uploadedTime + "," + viewTime;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "RecVideo{" +
                "trainerName='" + trainerName + '\'' +
                ", uploadedTime=" + uploadedTime +
                ", viewTime=" + viewTime +
                "} " + super.toString();
    }
}
