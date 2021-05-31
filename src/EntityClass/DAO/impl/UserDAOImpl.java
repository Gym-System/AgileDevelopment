package EntityClass.DAO.impl;

import EntityClass.DAO.UserDAO;
import EntityClass.VO.User;
import com.csvreader.CsvReader;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import static EntityClass.DAO.impl.PersonDAOImpl.deleteInfo;
import static EntityClass.DAO.impl.PersonDAOImpl.insertInfo;

/**
 * javadoc of PreUserDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class UserDAOImpl implements UserDAO {
    private User user = null;
    private final String fileName = "user.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    /**
     * This method insert a User class into user.sv
     * @param user A User class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertUser(User user) {
        return insertInfo(filePath, user.toStrArray());
    }

    /**
     * This method query a user record by userName and delete the record
     * @param userName The userName of a user
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteUser(String userName) {
        return deleteInfo(userName, filePath);
    }

    /**
     * This method query a user record by userName and change the password value of the record
     * @param userName The userName of a user
     * @param password The password value of a user
     * @return A User class after changing
     */
    @Override
    public User changeUserPassword(String userName, String password) {
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
                    user = new User(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            Double.parseDouble(record[6]));
                }
                records.add(record);
            }
            PersonDAOImpl.recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    /** This method query a user record by userName and change the email value of the record
     * @param userName The userName of a user
     * @param email The email value of a user
     * @return A User class after changing
     */
    @Override
    public User changeUserEmail(String userName, String email) {
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
                    user = new User(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            Double.parseDouble(record[6]));
                }
                records.add(record);
            }
            PersonDAOImpl.recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    /**
     * This method query a user record by userName and change the telephone number of the record
     * @param userName The userName of a user
     * @param teleNo The telephone number of a user
     * @return A User class after changing
     */
    @Override
    public User changeUserTeleNo(String userName, String teleNo) {
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
                    user = new User(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            Double.parseDouble(record[6]));
                }
                records.add(record);
            }
            PersonDAOImpl.recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    /**
     * This method query a user record by userName and change the telephone number of the record
     * @param userName The userName of a user
     * @param balance The balance of a user
     * @return A User class after changing
     */
    @Override
    public User changeUserBalance(String userName, Double balance) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[6] = balance.toString();
                    user = new User(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            Double.parseDouble(record[6]));
                }
                records.add(record);
            }
            PersonDAOImpl.recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    /**
     * This method query a user record by user name
     * @param userName The userName of a user
     * @return A User class
     */
    @Override
    public User queryByUserName(String userName) {
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[0])) {
                    user = new User(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            Double.parseDouble(record[6]));
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    /**
     * This method query all the user records
     * @return A array list of user class
     */
    @Override
    public ArrayList<User> queryAll() {
        File inFile = new File(filePath);
        ArrayList<User> users = new ArrayList<>();
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                user = new User(record[0], record[1], record[2], record[3], record[4],
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                        Double.parseDouble(record[6]));
                users.add(user);
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return users;
    }
}
