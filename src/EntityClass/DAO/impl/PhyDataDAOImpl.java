package EntityClass.DAO.impl;

import EntityClass.DAO.PersonDAO;
import EntityClass.DAO.PhyDataDAO;
import EntityClass.VO.PhyData;
import com.csvreader.CsvReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static EntityClass.DAO.impl.PersonDAOImpl.*;

public class PhyDataDAOImpl implements PhyDataDAO {
    private PhyData phyData;
    private String fileName = "phyData.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    // insert
    @Override
    public Boolean insertPhyData(PhyData phyData) {
        return insertInfo(filePath, phyData.toStrArray());
    }

    // delete
    @Override
    public Boolean deletePhyData(String userName) {
        return deleteInfo(userName, filePath);
    }

    // update
    @Override
    public PhyData changePhyDataHeight(String userName, double height) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[1] = String.valueOf(height);
                    phyData = new PhyData(record[0], Double.parseDouble(record[1]), Double.parseDouble(record[2]),
                            Integer.parseInt(record[3]), record[4], Double.parseDouble(record[5]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return phyData;
    }

    @Override
    public PhyData changePhyDataWeight(String userName, double weight) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[2] = String.valueOf(weight);
                    phyData = new PhyData(record[0], Double.parseDouble(record[1]), Double.parseDouble(record[2]),
                            Integer.parseInt(record[3]), record[4], Double.parseDouble(record[5]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return phyData;
    }

    @Override
    public PhyData changePhyDataExperience(String userName, int experience) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[3] = String.valueOf(experience);
                    phyData = new PhyData(record[0], Double.parseDouble(record[1]), Double.parseDouble(record[2]),
                            Integer.parseInt(record[3]), record[4], Double.parseDouble(record[5]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return phyData;
    }

    @Override
    public PhyData changePhyDataInterest(String userName, String interest) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[4] = interest;
                    phyData = new PhyData(record[0], Double.parseDouble(record[1]), Double.parseDouble(record[2]),
                            Integer.parseInt(record[3]), record[4], Double.parseDouble(record[5]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return phyData;
    }

    @Override
    public PhyData changePhyDataBFR(String userName, double BRF) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[5] = String.valueOf(BRF);
                    phyData = new PhyData(record[0], Double.parseDouble(record[1]), Double.parseDouble(record[2]),
                            Integer.parseInt(record[3]), record[4], Double.parseDouble(record[5]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return phyData;
    }

    // select
    @Override
    public PhyData queryByUserName(String userName) {
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[0])) {
                    phyData = new PhyData(record[0], Double.parseDouble(record[1]), Double.parseDouble(record[2]),
                            Integer.parseInt(record[3]), record[4], Double.parseDouble(record[5]));
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return phyData;
    }
}
