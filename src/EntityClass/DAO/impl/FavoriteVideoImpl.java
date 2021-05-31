package EntityClass.DAO.impl;

import EntityClass.DAO.FavoriteVideoDAO;
import EntityClass.DAO.ToolDAO;
import EntityClass.VO.FavoriteVideo;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.*;
import java.util.ArrayList;

import static EntityClass.DAO.impl.PersonDAOImpl.recordToCsv;

/**
 * javadoc of FavoriteVideoImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class FavoriteVideoImpl implements ToolDAO, FavoriteVideoDAO {
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
            return insertInfo(favoriteVideo);
        }
        else {
            return false;
        }
    }

    /**
     * This method query a FavoriteVideo record by courseId and delete the record
     * @param favoriteVideo A FavoriteVideo class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteFavoriteVideo(FavoriteVideo favoriteVideo) {
        return deleteInfo(favoriteVideo);
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
     * This method insert a Object class into csv file
     *
     * @param obj A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertInfo(Object obj) {
        if(obj instanceof FavoriteVideo) {
            FavoriteVideo favoriteVideo = (FavoriteVideo) obj;
            boolean flag = false;
            File outFile = new File(filePath);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));
                CsvWriter csvWriter = new CsvWriter(writer,',');
                csvWriter.writeRecord(favoriteVideo.toStrArray());
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
        if(object instanceof FavoriteVideo) {
            FavoriteVideo favoriteVideo = (FavoriteVideo) object;
            Boolean flag = false;
            File inFile = new File(filePath);
            try {
                String[] record;
                ArrayList<String[]> records = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(inFile));
                CsvReader csvReader = new CsvReader(reader, ',');
                while(csvReader.readRecord()){
                    record = csvReader.getRawRecord().split(",");
                    if(favoriteVideo.getCourseId() == Long.parseLong(record[0])) {
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
