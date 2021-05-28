package EntityClass.VO;

public class FavoriteVideo {
    private String userName;
    private long courseId;

    public FavoriteVideo(String userName, long courseId) {
        this.userName = userName;
        this.courseId = courseId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String[] toStrArray() {
        String text = "" + userName + "," + courseId;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "FavoriteVideo{" +
                "userName='" + userName + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
