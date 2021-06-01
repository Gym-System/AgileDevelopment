package EntityClass.DAO.Impl;

import EntityClass.DAO.RegulationDAO;
import EntityClass.DAO.ToolDAO;
import EntityClass.VO.Regulation;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.*;
import java.util.ArrayList;

import static EntityClass.DAO.Impl.PersonDAOImpl.recordToCsv;

public class RegulationDAOImpl implements ToolDAO, RegulationDAO {
    private Regulation regulation = null;
    private final String fileName = "regulation.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    /**
     * This method insert a Regulation class into regulation.sv
     *
     * @param regulation A Regulation class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertRegulation(Regulation regulation) {
        if(queryByUserType(regulation.getUserType()) != null) {
            deleteRegulation(regulation);
        }
        return insertInfo(regulation);
    }

    /**
     * This method query a Regulation record by userType and delete the record
     *
     * @param regulation A Regulation class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteRegulation(Regulation regulation) {
        return deleteInfo(regulation);
    }

    /**
     * This method query a regulation record by user type
     *
     * @param userType The user type of regulation
     * @return A Regulation class
     */
    @Override
    public Regulation queryByUserType(int userType) {
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userType == Integer.parseInt(record[0])) {
                    regulation = new Regulation(Integer.parseInt(record[0]), Double.parseDouble(record[1]), Double.parseDouble(record[2]), Double.parseDouble(record[3]));
                    break;
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return regulation;
    }

    /**
     * This method query all the regulation records
     *
     * @return A array list of regulation class
     */
    @Override
    public ArrayList<Regulation> queryAll() {
        ArrayList<Regulation> regulations = new ArrayList<>();
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                regulation = new Regulation(Integer.parseInt(record[0]), Double.parseDouble(record[1]), Double.parseDouble(record[2]), Double.parseDouble(record[3]));
                regulations.add(regulation);
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return regulations;
    }

    /**
     * This method insert a Object class into csv file
     *
     * @param obj A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertInfo(Object obj) {
        if(obj instanceof Regulation) {
            Regulation course = (Regulation) obj;
            boolean flag = false;
            File outFile = new File(filePath);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));
                CsvWriter csvWriter = new CsvWriter(writer,',');
                csvWriter.writeRecord(course.toStrArray());
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
        if(object instanceof Regulation) {
            Regulation regulation = (Regulation) object;
            Boolean flag = false;
            File inFile = new File(filePath);
            try {
                String[] record;
                ArrayList<String[]> records = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(inFile));
                CsvReader csvReader = new CsvReader(reader, ',');
                while(csvReader.readRecord()){
                    record = csvReader.getRawRecord().split(",");
                    if(regulation.getUserType() == Integer.parseInt(record[0])) {
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
     * @param regulation A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean searchSame(Object regulation) {
        Regulation regulationExist = null;
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                regulationExist = new Regulation(Integer.parseInt(record[0]), Double.parseDouble(record[1]), Double.parseDouble(record[2]), Double.parseDouble(record[3]));
                if(regulation.equals(regulationExist)) {
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