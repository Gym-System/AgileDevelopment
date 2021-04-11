package EntityClass.VO;

import java.util.Date;

public class LiveSession extends Course {
    private Date startTime;
    private final String trainerName;
    private final String userName;

    public LiveSession(String subject, int length, Date startTime, String trainerName, String userName) {
        super(subject, length);
        this.startTime = startTime;
        this.trainerName = trainerName;
        this.userName = userName;
    }

    public LiveSession(long courseId, String subject, int length, int gift, double star, Date startTime, String trainerName, String userName) {
        super(courseId, subject, length, gift, star);
        this.startTime = startTime;
        this.trainerName = trainerName;
        this.userName = userName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String[] toStrArray() {
        String text = "" + super.getCourseId() + "," + super.getSubject() +  "," + super.getLength() + "," + super.getGift() + "," +
                super.getStar() + "," + startTime + "," + trainerName + "," + userName;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "LiveSession{" +
                "startTime=" + startTime +
                ", trainerName='" + trainerName + '\'' +
                ", userName='" + userName + '\'' +
                "} " + super.toString();
    }
}
