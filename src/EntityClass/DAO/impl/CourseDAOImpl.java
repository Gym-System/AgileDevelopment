package EntityClass.DAO.impl;

import EntityClass.DAO.CourseDAO;
import EntityClass.DAO.ToolDAO;
import EntityClass.VO.Course;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.*;
import java.util.ArrayList;

import static EntityClass.DAO.impl.PersonDAOImpl.recordToCsv;

/**
 * javadoc of CourseDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class CourseDAOImpl implements ToolDAO, CourseDAO {
    private Course course = null;
    private final String fileName = "course.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    /**
     * This method insert a Course class into course.sv
     * @param course A Course class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertCourse(Course course) {
        if(!searchSame(course)) {
            return insertInfo(course);
        }
        else {
            return false;
        }
    }

    /**
     * This method query a course record by courseId and delete the record
     * @param course A Course class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteCourse(Course course) {
        return deleteInfo(course);
    }

    /**
     * This method query a course record by courseId and change the gift value of the record
     * @param courseId The ID of a course
     * @param gift The new gift value
     * @return A Course class after changing
     */
    @Override
    public Course changeCourseGift(long courseId, int gift) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(courseId == Long.parseLong(record[0])) {
                    record[3] = String.valueOf(gift);
                    course = new Course(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return course;
    }

    /**
     * This method query a course record by courseId and change the star value of the record
     * @param courseId The ID of a course
     * @param star The new star value
     * @return A Course class after changing
     */
    @Override
    public Course changeCourseStar(long courseId, double star) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(courseId == Long.parseLong(record[0])) {
                    record[4] = String.valueOf(star);
                    course = new Course(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return course;
    }

    /**
     * This method query a course record by courseId
     * @param courseId The ID of a course
     * @return A Course class
     */
    @Override
    public Course queryByCourseId(long courseId) {
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(courseId == Long.parseLong(record[0])) {
                    course = new Course(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]));
                    break;
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return course;
    }

    /**
     * This method query course records by subject
     * @param subject The subject of course
     * @return A array list of course class
     */
    @Override
    public ArrayList<Course> queryBySubject(String subject) {
        ArrayList<Course> courses = new ArrayList<>();
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(subject.equals(record[1])) {
                    course = new Course(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]));
                    courses.add(course);
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return courses;
    }

    /**
     * This method query all the course records
     * @return A array list of course class
     */
    @Override
    public ArrayList<Course> queryAll() {
        ArrayList<Course> courses = new ArrayList<>();
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                course = new Course(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                        Integer.parseInt(record[3]), Double.parseDouble(record[4]));
                courses.add(course);
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return courses;
    }

    /**
     * This method insert a Object class into csv file
     *
     * @param obj A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertInfo(Object obj) {
        if(obj instanceof Course) {
            Course course = (Course) obj;
            boolean flag = false;
            File outFile = new File(filePath);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));
                CsvWriter csvWriter = new CsvWriter(writer,',');
                csvWriter.writeRecord(course.toStrArray());
                csvWriter.close();
                flag = true;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return flag;
        }
        else {
            return false;
        }
    }

    /**
     * This method query a object record and delete the record
     *
     * @param obj A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteInfo(Object obj) {
        if(obj instanceof Course) {
            Course course = (Course) obj;
            Boolean flag = false;
            File inFile = new File(filePath);
            try {
                String[] record;
                ArrayList<String[]> records = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(inFile));
                CsvReader csvReader = new CsvReader(reader, ',');
                while(csvReader.readRecord()){
                    record = csvReader.getRawRecord().split(",");
                    if(course.getCourseId() == Long.parseLong(record[0])) {
                        continue;
                    }
                    assert records != null;
                    records.add(record);
                }
                csvReader.close();
                recordToCsv(records, filePath);
                flag = true;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return flag;
        }
        else {
            return false;
        }
    }

    /**
     * This method search file for the same object
     *
     * @param course A Course class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean searchSame(Object course) {
        Course courseExist = null;
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                courseExist = new Course(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                        Integer.parseInt(record[3]), Double.parseDouble(record[4]));
                if(course.equals(courseExist)) {
                    return true;
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}