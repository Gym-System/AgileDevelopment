package EntityClass.DAO.Impl;

import EntityClass.DAO.PreUserDAO;
import EntityClass.DAO.ToolDAO;
import EntityClass.VO.PremierUser;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import static EntityClass.DAO.Impl.PersonDAOImpl.recordToCsv;

/**
 * javadoc of PreUserDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class PreUserDAOImpl implements ToolDAO, PreUserDAO {
    private PremierUser premierUser = null;
    private final String fileName = "preUser.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    /**
     * This method insert a PremierUser class into premierUser.sv
     * @param premierUser A PremierUser class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertPreUser(PremierUser premierUser) {
        if(!searchSame(premierUser)) {
            return insertInfo(premierUser);
        }
        else {
            return false;
        }
    }

    /**
     * This method query a premierUser record by userName and delete the record
     * @param premierUser A PremierUser class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deletePreUser(PremierUser premierUser) {
        return deleteInfo(premierUser);
    }

    /**
     * This method query a premierUser record by userName and change the password value of the record
     * @param userName The userName of a premierUser
     * @param password The password value of a premierUser
     * @return A PremierUser class after changing
     */
    @Override
    public PremierUser changePreUserPassword(String userName, String password) {
        File inFile = new File(filePath);
        try {
            String[] record;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[1] = password;
                    premierUser = new PremierUser(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            Double.parseDouble(record[6]), Integer.parseInt(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return premierUser;
    }

    /** This method query a premierUser record by userName and change the email value of the record
     * @param userName The userName of a premierUser
     * @param email The email value of a premierUser
     * @return A PremierUser class after changing
     */
    @Override
    public PremierUser changePreUserEmail(String userName, String email) {
        File inFile = new File(filePath);
        try {
            String[] record;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[2] = email;
                    premierUser = new PremierUser(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            Double.parseDouble(record[6]), Integer.parseInt(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return premierUser;
    }

    /**
     * This method query a premierUser record by userName and change the telephone number of the record
     * @param userName The userName of a premierUser
     * @param teleNo The telephone number of a premierUser
     * @return A PremierUser class after changing
     */
    @Override
    public PremierUser changePreUserTeleNo(String userName, String teleNo) {
        File inFile = new File(filePath);
        try {
            String[] record;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[4] = teleNo;
                    premierUser = new PremierUser(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            Double.parseDouble(record[6]), Integer.parseInt(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return premierUser;
    }

    /**
     * This method query a premierUser record by userName and change the telephone number of the record
     * @param userName The userName of a premierUser
     * @param balance The balance of a premierUser
     * @return A PremierUser class after changing
     */
    @Override
    public PremierUser changePreUserBalance(String userName, Double balance) {
        File inFile = new File(filePath);
        try {
            String[] record;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[6] = balance.toString();
                    premierUser = new PremierUser(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            Double.parseDouble(record[6]), Integer.parseInt(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return premierUser;
    }

    /**
     * This method query a premierUser record by userName and change the telephone number of the record
     * @param userName The userName of a premierUser
     * @param userType The userType of a premierUser
     * @return A PremierUser class after changing
     */
    @Override
    public PremierUser changePreUserType(String userName, int userType) {
        File inFile = new File(filePath);
        try {
            String[] record;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[7] = String.valueOf(userType);
                    premierUser = new PremierUser(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            Double.parseDouble(record[6]), Integer.parseInt(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return premierUser;
    }

    /**
     * This method query a premierUser record by user name
     * @param userName The userName of a person
     * @return A PremierUser class
     */
    @Override
    public PremierUser queryByUserName(String userName) {
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[0])) {
                    premierUser = new PremierUser(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            Double.parseDouble(record[6]), Integer.parseInt(record[7]));
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return premierUser;
    }

    /**
     * This method query all the premierUser records
     * @return A array list of PremierUser class
     */
    @Override
    public ArrayList<PremierUser> queryAll() {
        File inFile = new File(filePath);
        ArrayList<PremierUser> premierUsers = new ArrayList<>();
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                premierUser = new PremierUser(record[0], record[1], record[2], record[3], record[4],
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                        Double.parseDouble(record[6]), Integer.parseInt(record[7]));
                premierUsers.add(premierUser);
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return premierUsers;
    }

    /**
     * This method insert a Object class into csv file
     *
     * @param obj A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertInfo(Object obj) {
        if(obj instanceof PremierUser) {
            PremierUser premierUser = (PremierUser) obj;
            boolean flag = false;
            File outFile = new File(filePath);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));
                CsvWriter csvWriter = new CsvWriter(writer,',');
                csvWriter.writeRecord(premierUser.toStrArray());
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
        if(object instanceof PremierUser) {
            PremierUser premierUser = (PremierUser) object;
            Boolean flag = false;
            File inFile = new File(filePath);
            try {
                String[] record;
                ArrayList<String[]> records = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(inFile));
                CsvReader csvReader = new CsvReader(reader, ',');
                while(csvReader.readRecord()){
                    record = csvReader.getRawRecord().split(",");
                    if(premierUser.getUserName().equals(record[0])) {
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
     * @param preUser A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean searchSame(Object preUser) {
        PremierUser premierUserExist = null;
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                premierUserExist = new PremierUser(record[0], record[1], record[2], record[3], record[4],
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                        Double.parseDouble(record[6]), Integer.parseInt(record[7]));
                if(preUser.equals(premierUserExist)) {
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
