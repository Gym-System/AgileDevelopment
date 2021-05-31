package EntityClass.DAO.impl;

import EntityClass.DAO.FavoriteVideoDAO;
import EntityClass.VO.FavoriteVideo;
import com.csvreader.CsvReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static EntityClass.DAO.impl.CourseDAOImpl.deleteInfo;
import static EntityClass.DAO.impl.PersonDAOImpl.insertInfo;

/**
 * javadoc of FavoriteVideoImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class FavoriteVideoImpl implements FavoriteVideoDAO {
    private FavoriteVideo favoriteVideo = null;
    public static final String fileFolder = "./src/Data/";
    private final String fileName = "favoriteVideo.csv";
    private String filePath = fileFolder + fileName;

    /**
     * This method insert a FavoriteVideo class into favoriteVideo.sv
     * @param favoriteVideo A FavoriteVideo class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertFavoriteVideo(FavoriteVideo favoriteVideo) {
        if(!searchSame(favoriteVideo)) {
            return insertInfo(filePath, favoriteVideo.toStrArray());
        }
        else {
            return false;
        }
    }

    /**
     * This method query a FavoriteVideo record by courseId and delete the record
     * @param courseId The ID of a FavoriteVideo
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteFavoriteVideo(Long courseId) {
        return deleteInfo(courseId, filePath);
    }

    /**
     * This method query a FavoriteVideo record by userName
     * @param userName The userName in a record
     * @return A array list of FavoriteVideo class
     */
    @Override
    public ArrayList<FavoriteVideo> queryByUserName(String userName) {
        File inFile = new File(filePath);
        ArrayList<FavoriteVideo> favoriteVideos = new ArrayList<>();
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[1])) {
                    favoriteVideo = new FavoriteVideo(Long.parseLong(record[0]), record[1]);
                    favoriteVideos.add(favoriteVideo);
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return favoriteVideos;
    }

    /**
     * This method search file for the same object
     *
     * @param favoriteVideo A FavoriteVideo class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean searchSame(Object favoriteVideo) {
        FavoriteVideo favoriteVideoExist = null;
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                favoriteVideoExist = new FavoriteVideo(Long.parseLong(record[0]), record[1]);
                if(favoriteVideo.equals(favoriteVideoExist)) {
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
