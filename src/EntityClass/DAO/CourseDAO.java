package EntityClass.DAO;

import EntityClass.VO.Course;

import java.util.ArrayList;

/**
 * javadoc of CourseDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface CourseDAO {
    /**
     * This method insert a Course class into course.sv
     * @param course A Course class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertCourse(Course course);

    /**
     * This method query a course record by courseId and delete the record
     * @param courseId The ID of a course
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deleteCourse(long courseId);

    /**
     * This method query a course record by courseId and change the gift value of the record
     * @param courseId The ID of a course
     * @param gift The new gift value
     * @return A Course class after changing
     */
    Course changeCourseGift(long courseId, int gift);

    /**
     * This method query a course record by courseId and change the star value of the record
     * @param courseId The ID of a course
     * @param star The new star value
     * @return A Course class after changing
     */
    Course changeCourseStar(long courseId, double star);

    /**
     * This method query a course record by courseId
     * @param courseId The ID of a course
     * @return A Course class
     */
    Course queryByCourseId(long courseId);

    /**
     * This method query course records by subject
     * @param subject The subject of course
     * @return A array list of course class
     */
    ArrayList<Course> queryBySubject(String subject);

    /**
     * This method query all the course records
     * @return A array list of course class
     */
    ArrayList<Course> queryAll();

    /**
     * This method search file for the same object
     *
     * @param course A Course class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean searchSame(Object course);
}
