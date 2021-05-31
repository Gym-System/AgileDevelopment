package EntityClass.DAO.impl;

import EntityClass.DAO.StaffDAO;
import EntityClass.VO.Staff;
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
 * javadoc of PersonDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class StaffDAOImpl implements StaffDAO {
    private Staff staff = null;
    private final String fileName = "staff.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    /**
     * This method insert a Staff class into staff.sv
     * @param staff A Staff class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertStaff(Staff staff) {
        if(!searchSame(staff)) {
            return insertInfo(filePath, staff.toStrArray());
        }
        else {
            return false;
        }
    }

    /**
     * This method query a staff record by userName and delete the record
     * @param userName The userName of a staff
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteStaff(String userName) {
        return deleteInfo(userName, filePath);
    }

    /**
     * This method query a staff record by userName and change the password value of the record
     * @param userName The userName of a staff
     * @param password The password value of a staff
     * @return A Staff class after changing
     */
    @Override
    public Staff changeStaffPassword(String userName, String password) {
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
                    staff = new Staff(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6]);
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return staff;
    }

    /**
     * This method query a staff record by userName and change the email value of the record
     * @param userName The userName of a staff
     * @param email The email value of a staff
     * @return A Staff class after changing
     */
    @Override
    public Staff changeStaffEmail(String userName, String email) {
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
                    staff = new Staff(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6]);
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return staff;
    }

    /**
     * This method query a staff record by userName and change the telephone number of the record
     * @param userName The userName of a staff
     * @param teleNo The telephone number of a staff
     * @return A Staff class after changing
     */
    @Override
    public Staff changeStaffTeleNo(String userName, String teleNo) {
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
                    staff = new Staff(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6]);
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return staff;
    }

    /**
     * This method query a staff record by user name
     * @param userName The userName of a staff
     * @return A Staff class
     */
    @Override
    public Staff queryByUserName(String userName) {
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[0])) {
                    staff = new Staff(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6]);
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return staff;
    }

    /**
     * This method query all the staff records
     * @return A array list of Staff class
     */
    @Override
    public ArrayList<Staff> queryAll() {
        File inFile = new File(filePath);
        ArrayList<Staff> staffs = new ArrayList<>();
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                staff = new Staff(record[0], record[1], record[2], record[3], record[4],
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                        record[6]);
                staffs.add(staff);
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return staffs;
    }

    /**
     * This method search file for the same object
     *
     * @param staff A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean searchSame(Object staff) {
        Staff staffExist = null;
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                staffExist = new Staff(record[0], record[1], record[2], record[3], record[4],
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                        record[6]);
                if(staff.equals(staffExist)) {
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
