package EntityClass.DAO.impl;

import EntityClass.DAO.CourseDAO;
import EntityClass.VO.Course;
import com.csvreader.CsvReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static EntityClass.DAO.impl.PersonDAOImpl.insertInfo;
import static EntityClass.DAO.impl.PersonDAOImpl.recordToCsv;

public class CourseDAOImpl implements CourseDAO {
    private Course course = null;
    private final String fileName = "course.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    // insert
    @Override
    public Boolean insertCourse(Course course) {
        return insertInfo(filePath, course.toStrArray());
    }

    // delete
    @Override
    public Boolean deleteCourse(long courseId) {
        return deleteInfo(courseId, filePath);
    }

    // update
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

    // select
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
                }
                courses.add(course);
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return courses;
    }

    // helper function
    static Boolean deleteInfo(long courseId, String fileName) {
        Boolean flag = false;
        File inFile = new File(fileName);
        try {
            String[] record;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(courseId == Long.parseLong(record[0])) {
                    continue;
                }
                assert records != null;
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, fileName);
            flag = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}