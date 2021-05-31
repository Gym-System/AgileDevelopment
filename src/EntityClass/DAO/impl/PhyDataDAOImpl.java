package EntityClass.DAO.impl;

import EntityClass.DAO.PhyDataDAO;
import EntityClass.VO.PhyData;
import com.csvreader.CsvReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static EntityClass.DAO.impl.PersonDAOImpl.*;

/**
 * javadoc of PhyDataDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class PhyDataDAOImpl implements PhyDataDAO {
    private PhyData phyData;
    private String fileName = "phyData.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    /**
     * This method insert a PhyData class into phyData.sv
     * @param phyData A PhyData class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertPhyData(PhyData phyData) {
        return insertInfo(filePath, phyData.toStrArray());
    }

    /**
     * This method query a phyData record by userName and delete the record
     * @param userName The userName of a person
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deletePhyData(String userName) {
        return deleteInfo(userName, filePath);
    }

    /**
     * This method query a person record by userName and change the height value of the record
     * @param userName The userName of a person
     * @param height The height value of a person
     * @return A PhyData class after changing
     */
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

    /**
     * This method query a person record by userName and change the weight value of the record
     * @param userName The userName of a person
     * @param weight The weight value of a person
     * @return A PhyData class after changing
     */
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

    /**
     * This method query a person record by userName and change the experience value of the record
     * @param userName The userName of a person
     * @param experience The experience value of a person
     * @return A PhyData class after changing
     */
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

    /**
     * This method query a person record by userName and change the interest value of the record
     * @param userName The userName of a person
     * @param interest The interest value of a person
     * @return A PhyData class after changing
     */
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

    /**
     * This method query a person record by userName and change the BRF value of the record
     * @param userName The userName of a person
     * @param BRF The BRF value of a person
     * @return A PhyData class after changing
     */
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

    /**
     * This method query a PhyData record by user name
     * @param userName The userName of a person
     * @return A PhyData class
     */
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

    /**
     * This method query all the PhyData records
     * @return A array list of PhyData class
     */
    @Override
    public ArrayList<PhyData> queryAll() {
        File inFile = new File(filePath);
        ArrayList<PhyData> phyDatas = new ArrayList<>();
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                phyData = new PhyData(record[0], Double.parseDouble(record[1]), Double.parseDouble(record[2]),
                        Integer.parseInt(record[3]), record[4], Double.parseDouble(record[5]));
                phyDatas.add(phyData);
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return phyDatas;
    }
}
