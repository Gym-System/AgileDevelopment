package EntityClass.VO;

import java.util.Date;

public class Course {
    private long courseId;
    private final String subject;
    private final int length;
    private int gift = 0;
    private double star = 0.0;

    public Course(String subject, int length) {
        this.setCourseId();
        this.subject = subject;
        this.length = length;
    }

    public Course(long courseId, String subject, int length, int gift, double star) {
        this.courseId = courseId;
        this.subject = subject;
        this.length = length;
        this.gift = gift;
        this.star = star;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId() {
        Date date = new Date();
        this.courseId = date.getTime();
    }

    public String getSubject() {
        return subject;
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

    public String[] toStrArray() {
        String text = "" + courseId  + "," + subject + "," + length + "," + gift + "," + star;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", subject='" + subject + '\'' +
                ", length=" + length +
                ", gift=" + gift +
                ", star=" + star +
                '}';
    }
}
