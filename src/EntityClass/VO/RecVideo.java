package EntityClass.VO;

import java.util.Date;

public class RecVideo extends Course {
    private final String trainerName;
    private Date uploadedTime;
    private int viewTime = 0;

    public RecVideo(String trainerName, Date uploadedTime, String subject, String type, double length) {
        super(subject, type, length);
        this.trainerName = trainerName;
        this.uploadedTime = uploadedTime;
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
    public String toString() {
        return "RecVideo{" +
                "trainerName='" + trainerName + '\'' +
                ", uploadedTime=" + uploadedTime +
                ", viewTime=" + viewTime +
                "} " + super.toString();
    }
}
