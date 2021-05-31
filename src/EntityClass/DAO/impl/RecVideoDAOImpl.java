package EntityClass.DAO.impl;

import EntityClass.DAO.RecVideoDAO;
import EntityClass.DAO.ToolDAO;
import EntityClass.VO.RecVideo;
import com.csvreader.CsvReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import static EntityClass.DAO.impl.PersonDAOImpl.recordToCsv;

/**
 * javadoc of RecVideoDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class RecVideoDAOImpl implements ToolDAO, RecVideoDAO {
    private RecVideo recVideo = null;
    private final String fileName = "recVideo.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    /**
     * This method insert a RecVideo class into recVideo.sv
     * @param recVideo A RecVideo class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertRecVideo(RecVideo recVideo) {
        if(!searchSame(recVideo)) {
            return insertInfo(recVideo);
        }
        else {
            return false;
        }
    }

    /**
     * This method query a recVideo record by courseId and delete the record
     * @param recVideo A RecVideo class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteRecVideo(RecVideo recVideo) {
        return deleteInfo(recVideo);
    }

    /**
     * This method query a recVideo record by courseId and change the gift value of the record
     * @param courseId The ID of a recVideo
     * @param gift The new gift value
     * @return A RecVideo class after changing
     */
    @Override
    public RecVideo changeRecVideoGift(long courseId, int gift) {
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
                    recVideo = new RecVideo(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]), record[5],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[6]),
                            Integer.parseInt(record[7]), Integer.parseInt(record[8]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return recVideo;
    }

    /**
     * This method query a recVideo record by courseId and change the star value of the record
     * @param courseId The ID of a recVideo
     * @param star The new star value
     * @return A RecVideo class after changing
     */
    @Override
    public RecVideo changeRecVideoStar(long courseId, double star) {
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
                    recVideo = new RecVideo(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]), record[5],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[6]),
                            Integer.parseInt(record[7]), Integer.parseInt(record[8]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return recVideo;
    }

    /**
     * This method query a recVideo record by courseId and change the viewTime of the record
     * @param courseId The ID of a recVideo
     * @param viewTime How much time did the recorded video viewed
     * @return A RecVideo class after changing
     */
    @Override
    public RecVideo changeRecVideoViewTime(long courseId, int viewTime) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(courseId == Long.parseLong(record[0])) {
                    record[7] = String.valueOf(viewTime);
                    recVideo = new RecVideo(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]), record[5],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[6]),
                            Integer.parseInt(record[7]), Integer.parseInt(record[8]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return recVideo;
    }

    /**
     * This method query a recVideo record by courseId and change the star value of the record
     * @param courseId The ID of a recVideo
     * @param rateTime How much time did the recorded video rated
     * @return A RecVideo class after changing
     */
    @Override
    public RecVideo changeRecVideoRateTime(long courseId, int rateTime) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(courseId == Long.parseLong(record[0])) {
                    record[8] = String.valueOf(rateTime);
                    recVideo = new RecVideo(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]), record[5],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[6]),
                            Integer.parseInt(record[7]), Integer.parseInt(record[8]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return recVideo;
    }

    /**
     * This method query a recVideo record by courseId
     * @param courseId The ID of a recVideo
     * @return A RecVideo class
     */
    @Override
    public RecVideo queryByCourseId(long courseId) {
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(courseId == Long.parseLong(record[0])) {
                    recVideo = new RecVideo(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]), record[5],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[6]),
                            Integer.parseInt(record[7]), Integer.parseInt(record[8]));
                    break;
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return recVideo;
    }

    /**
     * This method query recVideo records by trainerName
     * @param trainerName The trainerName of recVideo
     * @return A array list of RecVideo class
     */
    @Override
    public ArrayList<RecVideo> queryByTrainerName(String trainerName) {
        ArrayList<RecVideo> recVideos = new ArrayList<>();
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(trainerName.equals(record[5])) {
                    recVideo = new RecVideo(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]), record[5],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[6]),
                            Integer.parseInt(record[7]), Integer.parseInt(record[8]));
                    recVideos.add(recVideo);
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return recVideos;
    }

    /**
     * This method query recVideo records by subject
     * @param subject The subject of recVideo
     * @return A array list of RecVideo class
     */
    @Override
    public ArrayList<RecVideo> queryBySubject(String subject) {
        ArrayList<RecVideo> recVideos = new ArrayList<>();
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(subject.equals(record[1])) {
                    recVideo = new RecVideo(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                            Integer.parseInt(record[3]), Double.parseDouble(record[4]), record[5],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[6]),
                            Integer.parseInt(record[7]), Integer.parseInt(record[8]));
                    recVideos.add(recVideo);
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return recVideos;
    }

    /**
     * This method query all the recVideo records
     * @return A array list of RecVideo class
     */
    @Override
    public ArrayList<RecVideo> queryAll() {
        ArrayList<RecVideo> recVideos = new ArrayList<>();
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                recVideo = new RecVideo(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                        Integer.parseInt(record[3]), Double.parseDouble(record[4]), record[5],
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[6]),
                        Integer.parseInt(record[7]), Integer.parseInt(record[8]));
                recVideos.add(recVideo);
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return recVideos;
    }

    /**
     * This method insert a Object class into csv file
     *
     * @param obj A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertInfo(Object obj) {
        if(obj instanceof RecVideo) {
            RecVideo recVideo = (RecVideo) obj;
            Boolean flag = false;
            File inFile = new File(filePath);
            try {
                String[] record;
                ArrayList<String[]> records = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(inFile));
                CsvReader csvReader = new CsvReader(reader, ',');
                while(csvReader.readRecord()){
                    record = csvReader.getRawRecord().split(",");
                    if(recVideo.getCourseId() == Long.parseLong(record[0])) {
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
     * This method query a object record and delete the record
     *
     * @param object A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteInfo(Object object) {
        return null;
    }

    /**
     * This method search file for the same object
     *
     * @param recVideo A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean searchSame(Object recVideo) {
        RecVideo recVideoExist = null;
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                recVideoExist = new RecVideo(Long.parseLong(record[0]), record[1], Integer.parseInt(record[2]),
                        Integer.parseInt(record[3]), Double.parseDouble(record[4]), record[5],
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[6]),
                        Integer.parseInt(record[7]), Integer.parseInt(record[8]));
                if(recVideo.equals(recVideoExist)) {
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
