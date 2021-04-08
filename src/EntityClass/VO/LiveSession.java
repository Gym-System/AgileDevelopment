package EntityClass.VO;

import java.util.Date;

public class LiveSession extends Course {
    private Date startTime;
    private final String trainerName;
    private final String userName;

    public LiveSession(String trainerName, String userName, Date startTime, String subject, String type, double length) {
        super(subject, type, length);
        this.trainerName = trainerName;
        this.userName = userName;
        this.startTime = startTime;
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
    public String toString() {
        return "LiveSession{" +
                "startTime=" + startTime +
                ", trainerName='" + trainerName + '\'' +
                ", userName='" + userName + '\'' +
                "} " + super.toString();
    }
}
