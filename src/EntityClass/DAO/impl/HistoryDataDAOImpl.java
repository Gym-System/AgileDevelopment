package EntityClass.DAO.impl;

import EntityClass.DAO.HistoryDataDAO;
import EntityClass.VO.HistoryData;
import com.csvreader.CsvReader;
import static EntityClass.DAO.impl.PersonDAOImpl.insertInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HistoryDataDAOImpl implements HistoryDataDAO {
    private HistoryData historyData = null;
    public static final String fileFolder = "./src/Data/";
    private final String fileName = "historyData.csv";
    private String filePath = fileFolder + fileName;

    @Override
    public Boolean insertHistoryData(HistoryData historyData) {
        return insertInfo(filePath, historyData.toStrArray());
    }

    @Override
    public ArrayList<HistoryData> queryByUserName(String userName) {
        File inFile = new File(filePath);
        ArrayList<HistoryData> historyDatas = new ArrayList<>();
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[0])) {
                    historyData = new HistoryData(record[0], record[1], Long.parseLong(record[2]));
                    historyDatas.add(historyData);
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return historyDatas;
    }
}