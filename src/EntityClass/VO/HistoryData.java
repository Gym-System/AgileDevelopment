package EntityClass.VO;

public class HistoryData {
    private String userName;
    private String type;
    private long courseId;

    public HistoryData(String userName, String type, long courseId) {
        this.userName = userName;
        this.type = type;
        this.courseId = courseId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String[] toStrArray() {
        String text = "" + userName + "," + type + "," + courseId;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "HistoryData{" +
                "userName='" + userName + '\'' +
                ", type='" + type + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}