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

public class FavoriteVideoImpl implements FavoriteVideoDAO {
    private FavoriteVideo favoriteVideo = null;
    public static final String fileFolder = "./src/Data/";
    private final String fileName = "favoriteVideo.csv";
    private String filePath = fileFolder + fileName;

    @Override
    public Boolean insertHistoryData(FavoriteVideo favoriteVideo) {
        return insertInfo(filePath, favoriteVideo.toStrArray());
    }

    @Override
    public Boolean deleteHistoryData(Long courseId) {
        return deleteInfo(courseId, filePath);
    }

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
                if(userName.equals(record[0])) {
                    favoriteVideo = new FavoriteVideo(record[0], Long.parseLong(record[1]));
                    favoriteVideos.add(favoriteVideo);
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return favoriteVideos;
    }
}
