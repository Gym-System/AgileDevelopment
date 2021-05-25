package EntityClass.VO;

import java.util.Date;

public class Course {
    private long courseId;
    private final int length;
    private int gift = 0;
    private double star = 0.0;
    private final String trainerName;

    public Course(int length, String trainerName) {
        this.setCourseId();
        this.length = length;
        this.trainerName = trainerName;
    }

    public Course(long courseId, int length, int gift, double star, String trainerName) {
        this.courseId = courseId;
        this.length = length;
        this.gift = gift;
        this.star = star;
        this.trainerName = trainerName;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId() {
        Date date = new Date();
        this.courseId = date.getTime();
    }

    public int getLength() {
        return length;
    }

    public int getGift() {
        return gift;
    }

    public void setGift(int gift) {
        this.gift = gift;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public String[] toStrArray() {
        String text = "" + courseId  + "," + length + "," + gift + "," + star + "," + trainerName;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", length=" + length +
                ", gift=" + gift +
                ", star=" + star +
                ", trainerName='" + trainerName + '\'' +
                '}';
    }
}
