package EntityClass.VO;

import java.util.Date;

public class LiveSession extends Course {
    private Date startTime;
    private final String userName;

    public LiveSession(int length, Date startTime, String trainerName, String userName) {
        super(length, trainerName);
        this.startTime = startTime;
        this.userName = userName;
    }

    public LiveSession(long courseId, int length, int gift, double star, Date startTime, String trainerName, String userName) {
        super(courseId, length, gift, star, trainerName);
        this.startTime = startTime;
        this.userName = userName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String[] toStrArray() {
        String text = "" + super.getCourseId() + "," + super.getLength() + "," + super.getGift() + "," +
                super.getStar() + "," + startTime + "," + super.getTrainerName() + "," + userName;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "LiveSession{" +
                "startTime=" + startTime +
                ", userName='" + userName + '\'' +
                "} " + super.toString();
    }
}
