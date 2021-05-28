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

public class WatchedVideoDAOImpl implements WatchedVideoDAO {
    private WatchedVideo watchedVideo = null;
    public static final String fileFolder = "./src/Data/";
    private final String fileName = "watchedVideo.csv";
    private String filePath = fileFolder + fileName;

    @Override
    public Boolean insertHistoryData(WatchedVideo watchedVideo) {
        return insertInfo(filePath, watchedVideo.toStrArray());
    }

    @Override
    public Boolean deleteHistoryData(Long courseId) {
        return deleteInfo(courseId, filePath);
    }

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
}