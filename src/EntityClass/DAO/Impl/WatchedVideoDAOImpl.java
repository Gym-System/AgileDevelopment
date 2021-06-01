package EntityClass.DAO.Impl;

import EntityClass.DAO.ToolDAO;
import EntityClass.DAO.WatchedVideoDAO;
import EntityClass.VO.WatchedVideo;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import static EntityClass.DAO.Impl.PersonDAOImpl.recordToCsv;

import java.io.*;
import java.util.ArrayList;

/**
 * javadoc of PreUserDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class WatchedVideoDAOImpl implements ToolDAO, WatchedVideoDAO {
    private WatchedVideo watchedVideo = null;
    public static final String fileFolder = "./src/Data/";
    private final String fileName = "watchedVideo.csv";
    private String filePath = fileFolder + fileName;

    /**
     * This method insert a WatchedVideo class into watchedVideo.sv
     * @param watchedVideo A WatchedVideo class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertHistoryData(WatchedVideo watchedVideo) {
        if(!searchSame(watchedVideo)) {
            return insertInfo(watchedVideo);
        }
        else {
            return false;
        }
    }

    /**
     * This method query a watchedVideo record by courseId and delete the record
     * @param watchedVideo A WatchedVideo class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteHistoryData(WatchedVideo watchedVideo) {
        return deleteInfo(watchedVideo);
    }

    /**
     * This method query a course record by userName
     * @param userName The name of a user
     * @return A array list of WatchedVideo classes
     */
    @Override
    public ArrayList<WatchedVideo> queryByUserName(String userName) {
        File inFile = new File(filePath);
        ArrayList<WatchedVideo> watchedVideos = new ArrayList<>();
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[0])) {
                    watchedVideo = new WatchedVideo(record[0], record[1], Long.parseLong(record[2]));
                    watchedVideos.add(watchedVideo);
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return watchedVideos;
    }

    /**
     * This method insert a Object class into csv file
     *
     * @param obj A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertInfo(Object obj) {
        if(obj instanceof WatchedVideo) {
            WatchedVideo watchedVideo = (WatchedVideo) obj;
            boolean flag = false;
            File outFile = new File(filePath);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));
                CsvWriter csvWriter = new CsvWriter(writer,',');
                csvWriter.writeRecord(watchedVideo.toStrArray());
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
        if(object instanceof WatchedVideo) {
            WatchedVideo watchedVideo = (WatchedVideo) object;
            Boolean flag = false;
            File inFile = new File(filePath);
            try {
                String[] record;
                ArrayList<String[]> records = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(inFile));
                CsvReader csvReader = new CsvReader(reader, ',');
                while(csvReader.readRecord()){
                    record = csvReader.getRawRecord().split(",");
                    if(watchedVideo.getUserName().equals(record[0])) {
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
     * @param watchVideo A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean searchSame(Object watchVideo) {
        WatchedVideo watchedVideoExist = null;
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                watchedVideoExist = new WatchedVideo(record[0], record[1], Long.parseLong(record[2]));
                if(watchVideo.equals(watchedVideoExist)) {
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