package EntityClass.DAO.impl;

import EntityClass.DAO.WatchedVideoDAO;
import EntityClass.VO.WatchedVideo;
import com.csvreader.CsvReader;

import static EntityClass.DAO.impl.PersonDAOImpl.insertInfo;
import static EntityClass.DAO.impl.CourseDAOImpl.deleteInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * javadoc of PreUserDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class WatchedVideoDAOImpl implements WatchedVideoDAO {
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
            return insertInfo(filePath, watchedVideo.toStrArray());
        }
        else {
            return false;
        }
    }

    /**
     * This method query a watchedVideo record by courseId and delete the record
     * @param courseId The ID of a watchedVideo
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteHistoryData(Long courseId) {
        return deleteInfo(courseId, filePath);
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