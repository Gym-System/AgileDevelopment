package EntityClass.DAO.impl;

import EntityClass.DAO.ManagerDAO;
import EntityClass.VO.Manager;
import com.csvreader.CsvReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import static EntityClass.DAO.impl.PersonDAOImpl.*;

/**
 * javadoc of ManagerDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class ManagerDAOImpl implements ManagerDAO {
    private Manager manager = null;
    private final String fileName = "manager.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    /**
     * This method insert a Manager class into manager.sv
     * @param manager A Manager class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertManager(Manager manager) {
        if(!searchSame(manager)) {
            return insertInfo(filePath, manager.toStrArray());
        }
        else {
            return false;
        }
    }

    /**
     * This method query a manager record by userName and delete the record
     * @param userName The userName of a manager
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteManager(String userName) {
        return deleteInfo(userName, filePath);
    }

    /**
     * This method query a manager record by userName and change the password value of the record
     * @param userName The userName of a manager
     * @param password The password value of a manager
     * @return A Manager class after changing
     */
    @Override
    public Manager changeManagerPassword(String userName, String password) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[1] = password;
                    manager = new Manager(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Integer.parseInt(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, fileName);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return manager;
    }

    /**
     * This method query a manager record by userName and change the email value of the record
     * @param userName The userName of a manager
     * @param email The email value of a manager
     * @return A Manager class after changing
     */
    @Override
    public Manager changeManagerEmail(String userName, String email) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[2] = email;
                    manager = new Manager(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Integer.parseInt(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return manager;
    }

    /**
     * This method query a manager record by userName and change the telephone number of the record
     * @param userName The userName of a manager
     * @param teleNo The telephone number of a manager
     * @return A Manager class after changing
     */
    @Override
    public Manager changeManagerTeleNo(String userName, String teleNo) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[4] = teleNo;
                    manager = new Manager(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Integer.parseInt(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return manager;
    }

    /**
     * This method query a manager record by userName and change the manager type of the record
     * @param userName The userName of a manager
     * @param managerType The manager type of a manager
     * @return A Manager class after changing
     */
    @Override
    public Manager changeManagerType(String userName, int managerType) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[7] = String.valueOf(managerType);
                    manager = new Manager(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Integer.parseInt(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return manager;
    }

    /**
     * This method query a manager record by user name
     * @param userName The userName of a manager
     * @return A Manager class
     */
    @Override
    public Manager queryByUserName(String userName) {
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[0])) {
                    manager = new Manager(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Integer.parseInt(record[7]));
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return manager;
    }

    /**
     * This method query all the manager records
     * @return A array list of manager class
     */
    @Override
    public ArrayList<Manager> queryAll() {
        File inFile = new File(filePath);
        ArrayList<Manager> managers = new ArrayList<>();
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                manager = new Manager(record[0], record[1], record[2], record[3], record[4],
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                        record[6], Integer.parseInt(record[7]));
                managers.add(manager);
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return managers;
    }

    /**
     * This method search file for the same object
     *
     * @param manager A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean searchSame(Object manager) {
        Manager managerExist = null;
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                managerExist = new Manager(record[0], record[1], record[2], record[3], record[4],
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                        record[6], Integer.parseInt(record[7]));
                if(manager.equals(managerExist)) {
                    return true;
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}