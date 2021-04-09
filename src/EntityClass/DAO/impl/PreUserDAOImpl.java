package EntityClass.DAO.impl;

import EntityClass.DAO.PreUserDAO;
import EntityClass.VO.PremierUser;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

import static EntityClass.DAO.impl.PersonDAOImpl.insertInfo;

public class PreUserDAOImpl implements PreUserDAO {
    PremierUser premierUser = null;
    String fileName = "preUser.csv";
    // insert
    @Override
    public Boolean insertPreUser(PremierUser premierUser) {
        return insertInfo(fileName, premierUser.toStrArray());
    }

    // delete
    @Override
    public Boolean deletePreUser(String userName) {
        boolean flag = false;
        File inFile = new File(fileName);
        try {
            String[] record;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    continue;
                }
                assert records != null;
                records.add(record);
            }
            PersonDAOImpl.recordToCsv(records, fileName);
            flag = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    // update
    @Override
    public PremierUser changePreUserPassword(String userName, String password) {
        File inFile = new File(fileName);
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
            PersonDAOImpl.recordToCsv(records, fileName);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return premierUser;
    }

    @Override
    public PremierUser changePreUserEmail(String userName, String email) {
        File inFile = new File(fileName);
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
            PersonDAOImpl.recordToCsv(records, fileName);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return premierUser;
    }

    @Override
    public PremierUser changePreUserTeleNo(String userName, String teleNo) {
        File inFile = new File(fileName);
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
            PersonDAOImpl.recordToCsv(records, fileName);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return premierUser;
    }

    @Override
    public PremierUser changePreUserBalance(String userName, Double balance) {
        File inFile = new File(fileName);
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
            PersonDAOImpl.recordToCsv(records, fileName);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return premierUser;
    }

    @Override
    public PremierUser changePreUserType(String userName, int userType) {
        File inFile = new File(fileName);
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
            PersonDAOImpl.recordToCsv(records, fileName);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return premierUser;
    }

    // select
    @Override
    public PremierUser queryByUserName(String userName) {
        File inFile = new File(fileName);
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
}
