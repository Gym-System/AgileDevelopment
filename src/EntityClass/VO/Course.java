package EntityClass.VO;

import java.util.Arrays;

public class Course {
    private static int courseId = 0;
    private String subject;
    private String type;
    private double length;
    private int gift = 0;
    private String[] comment = null;
    private double star = 0.0;

    public Course(String subject, String type, double length) {
        this.courseId += 1;
        this.subject = subject;
        this.type = type;
        this.length = length;
    }

    public static int getCourseId() {
        return courseId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getGift() {
        return gift;
    }

    public void setGift(int gift) {
        this.gift = gift;
    }

    public String[] getComment() {
        return comment;
    }

    public void setComment(String[] comment) {
        this.comment = comment;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "Course{" +
                "subject='" + subject + '\'' +
                ", type='" + type + '\'' +
                ", length=" + length +
                ", gift=" + gift +
                ", comment=" + Arrays.toString(comment) +
                ", star=" + star +
                '}';
    }
}
