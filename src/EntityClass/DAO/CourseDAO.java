package EntityClass.DAO;

import EntityClass.VO.Course;

import java.util.ArrayList;

public interface CourseDAO {
    // insert
    Boolean insertCourse(Course course);

    // delete
    Boolean deleteCourse(long courseId);

    // update
    Course changeCourseGift(long courseId, int gift);
    Course changeCourseStar(long courseId, double star);

    // select
    ArrayList<Course> queryBySubject(String subject);
}
