package EntityClass.DAO.impl;

import EntityClass.DAO.LiveSessionDAO;
import EntityClass.VO.LiveSession;
import com.csvreader.CsvReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import static EntityClass.DAO.impl.CourseDAOImpl.deleteInfo;
import static EntityClass.DAO.impl.PersonDAOImpl.insertInfo;
import static EntityClass.DAO.impl.PersonDAOImpl.recordToCsv;

/**
 * javadoc of LiveSessionDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class LiveSessionDAOImpl implements LiveSessionDAO {
    private LiveSession liveSession;
    private final String fileName = "liveSession.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    /**
     * This method insert a LiveSession class into liveSession.sv
     * @param liveSession A LiveSession class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertLiveSession(LiveSession liveSession) {
        return insertInfo(filePath, liveSession.toStrArray());
    }

    /**
     * This method query a LiveSession record by courseId and delete the record
     * @param courseId The ID of a LiveSession
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteLiveSession(long courseId) {
        return deleteInfo(courseId, filePath);
    }

    /**
     * This method query a LiveSession record by courseId and change the gift value of the record
     * @param courseId The ID of a LiveSession
     * @param gift The new gift value
     * @return A LiveSession class after changing
     */
    @Override
    public LiveSession changeLiveSessionGift(long courseId, int gift) {
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
                    liveSession = new LiveSession(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]),
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], record[7]);
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return liveSession;
    }

    /**
     * This method query a LiveSession record by courseId and change the star value of the record
     * @param courseId The ID of a LiveSession
     * @param star The new star value
     * @return A LiveSession class after changing
     */
    @Override
    public LiveSession changeLiveSessionStar(long courseId, double star) {
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
                    liveSession = new LiveSession(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]),
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], record[7]);
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return liveSession;
    }

    /**
     * This method query a LiveSession record by courseId and change the startTime value of the record
     * @param courseId The ID of a LiveSession
     * @param startTime The new startTime value
     * @return A LiveSession class after changing
     */
    @Override
    public LiveSession changeLiveSessionStartTime(long courseId, String startTime) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(courseId == Long.parseLong(record[0])) {
                    record[5] = String.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime));
                    liveSession = new LiveSession(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]),
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], record[7]);
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return liveSession;
    }

    /**
     * This method query a LiveSession record by courseId
     * @param courseId The ID of a LiveSession
     * @return A LiveSession class
     */
    @Override
    public LiveSession queryByCourseId(long courseId) {
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(courseId == Long.parseLong(record[0])) {
                    liveSession = new LiveSession(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]),
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], record[7]);
                    break;
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return liveSession;
    }

    /**
     * This method query LiveSession records by trainer name
     * @param trainerName The trainer name of LiveSession
     * @return A array list of LiveSession class
     */
    @Override
    public ArrayList<LiveSession> queryByTrainerName(String trainerName) {
        ArrayList<LiveSession> liveSessions = new ArrayList<>();
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(trainerName.equals(record[6])) {
                    liveSession = new LiveSession(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]),
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], record[7]);
                    liveSessions.add(liveSession);
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return liveSessions;
    }

    /**
     * This method query LiveSession records by user name
     * @param userName The user name of LiveSession
     * @return A array list of LiveSession class
     */
    @Override
    public ArrayList<LiveSession> queryByUserName(String userName) {
        ArrayList<LiveSession> liveSessions = new ArrayList<>();
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[7])) {
                    liveSession = new LiveSession(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]),
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], record[7]);
                    liveSessions.add(liveSession);
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return liveSessions;
    }

    /**
     * This method query all LiveSession records
     * @return A array list of LiveSession class
     */
    @Override
    public ArrayList<LiveSession> queryAll() {
        ArrayList<LiveSession> liveSessions = new ArrayList<>();
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                liveSession = new LiveSession(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                        Integer.parseInt(record[3]), Double.parseDouble(record[4]),
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                        record[6], record[7]);
                liveSessions.add(liveSession);
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return liveSessions;
    }
}
