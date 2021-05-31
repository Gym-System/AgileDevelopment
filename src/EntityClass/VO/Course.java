package EntityClass.VO;

import java.util.Date;
import java.util.Objects;

/**
 * javadoc of Course class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class Course {
    private long courseId = 0;
    private String subject = null;
    private int length = 0;
    private int gift = 0;
    private double star = 0.0;

    /**
     * This constructor contains major params needed to make a instance of Course class.
     * @param courseId The ID of the course
     */
    public Course(long courseId) {
        this.courseId = courseId;
    }

    /**
     * This constructor contains major params needed to make a instance of Course class.
     * @param subject The subject of the course
     * @param length The length of the course last
     */
    public Course(String subject, int length) {
        this.setCourseId();
        this.subject = subject;
        this.length = length;
    }

    /**
     * This constructor contains all params needed to make a instance of Course class.
     * @param courseId The ID of the course
     * @param subject The subject of the course
     * @param length The length of the course last
     * @param gift How many gifts dose the course get
     * @param star How many star dose the course get (between 0 and 5)
     */
    public Course(long courseId, String subject, int length, int gift, double star) {
        this.courseId = courseId;
        this.subject = subject;
        this.length = length;
        this.gift = gift;
        this.star = star;
    }

    /**
     * The getter method of courseId
     * @return courseId
     */
    public long getCourseId() {
        return courseId;
    }

    /**
     * The setter method of courseId
     */
    public void setCourseId() {
        Date date = new Date();
        this.courseId = date.getTime();
    }

    /**
     * The getter method of subject
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * The setter method of length
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * The getter method of gift
     * @return gift
     */
    public int getGift() {
        return gift;
    }

    /**
     * The setter method of length
     * @param gift Number of gift the course has
     */
    public void setGift(int gift) {
        this.gift = gift;
    }

    /**
     * The getter method of gift
     * @return gift
     */
    public double getStar() {
        return star;
    }

    /**
     * The setter method of star
     * @param star Number of star the course has
     */
    public void setStar(double star) {
        this.star = star;
    }

    /**
     * This method organize instance variables of Course class into a string array
     * @return A string array contain instance variables of Course class
     */
    public String[] toStrArray() {
        String text = "" + courseId  + "," + subject + "," + length + "," + gift + "," + star;
        return text.split(",");
    }

    /**
     * This method organize instance variables of Course class into a readable way
     * @return A string contains instance variables of Course class
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getCourseId() == course.getCourseId() &&
                getLength() == course.getLength() &&
                getGift() == course.getGift() &&
                Double.compare(course.getStar(), getStar()) == 0 &&
                Objects.equals(getSubject(), course.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseId(), getSubject(), getLength(), getGift(), getStar());
    }
}