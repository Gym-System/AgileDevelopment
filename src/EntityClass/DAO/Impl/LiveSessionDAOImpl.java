package EntityClass.DAO.Impl;

import EntityClass.DAO.LiveSessionDAO;
import EntityClass.DAO.ToolDAO;
import EntityClass.VO.LiveSession;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import static EntityClass.DAO.Impl.PersonDAOImpl.recordToCsv;

/**
 * javadoc of LiveSessionDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class LiveSessionDAOImpl implements ToolDAO, LiveSessionDAO {
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
        return insertInfo(liveSession);
    }

    /**
     * This method query a LiveSession record by courseId and delete the record
     * @param liveSession A LiveSession class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteLiveSession(LiveSession liveSession) {
        return deleteInfo(liveSession);
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

    /**
     * This method insert a Object class into csv file
     *
     * @param obj A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertInfo(Object obj) {
        if(obj instanceof LiveSession) {
            LiveSession liveSession = (LiveSession) obj;
            boolean flag = false;
            File outFile = new File(filePath);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));
                CsvWriter csvWriter = new CsvWriter(writer,',');
                csvWriter.writeRecord(liveSession.toStrArray());
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
     * @param object A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteInfo(Object object) {
        if(object instanceof LiveSession) {
            LiveSession liveSession = (LiveSession) object;
            Boolean flag = false;
            File inFile = new File(filePath);
            try {
                String[] record;
                ArrayList<String[]> records = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(inFile));
                CsvReader csvReader = new CsvReader(reader, ',');
                while(csvReader.readRecord()){
                    record = csvReader.getRawRecord().split(",");
                    if(liveSession.getCourseId() == Long.parseLong(record[0])) {
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
     * @param liveSession A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean searchSame(Object liveSession) {
        LiveSession liveSessionExist = null;
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                liveSessionExist = new LiveSession(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                        Integer.parseInt(record[3]), Double.parseDouble(record[4]),
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                        record[6], record[7]);
                if(liveSession.equals(liveSessionExist)) {
                    return true;
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
