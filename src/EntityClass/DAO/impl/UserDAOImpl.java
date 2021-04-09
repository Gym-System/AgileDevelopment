package EntityClass.DAO.impl;

import EntityClass.DAO.UserDAO;
import EntityClass.VO.Person;
import EntityClass.VO.User;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class UserDAOImpl implements UserDAO {
    private User user = null;
    // insert
    @Override
    public Boolean insertUser(User user) {
        boolean flag = false;
        File outFile = new File("user.csv");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));
            CsvWriter csvWriter = new CsvWriter(writer,',');
            csvWriter.writeRecord(user.toStrArray());
            csvWriter.close();
            flag = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    // delete
    @Override
    public Boolean deleteUser(String userName) {
        boolean flag = false;
        File inFile = new File("user.csv");
        try {
            String[] record = null;
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
            csvReader.close();

            File outFile = new File("user.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            CsvWriter csvWriter = new CsvWriter(writer,',');
            for (Iterator<String[]> iterator = records.iterator(); iterator.hasNext();) {
                csvWriter.writeRecord(iterator.next());
            }
            csvWriter.close();
            flag = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    // update
    @Override
    public User changeUserPassword(String userName, String password) {
        File inFile = new File("user.csv");
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
            csvReader.close();

            File outFile = new File("user.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            CsvWriter csvWriter = new CsvWriter(writer,',');
            for (Iterator<String[]> iterator = records.iterator(); iterator.hasNext();) {
                csvWriter.writeRecord(iterator.next());
            }
            csvWriter.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public User changeUserEmail(String userName, String email) {
        File inFile = new File("user.csv");
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
            csvReader.close();

            File outFile = new File("user.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            CsvWriter csvWriter = new CsvWriter(writer,',');
            for (Iterator<String[]> iterator = records.iterator(); iterator.hasNext();) {
                csvWriter.writeRecord(iterator.next());
            }
            csvWriter.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public User changeUserTeleNo(String userName, String teleNo) {
        File inFile = new File("user.csv");
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
            csvReader.close();

            File outFile = new File("user.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            CsvWriter csvWriter = new CsvWriter(writer,',');
            for (Iterator<String[]> iterator = records.iterator(); iterator.hasNext();) {
                csvWriter.writeRecord(iterator.next());
            }
            csvWriter.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public User changeUserBalance(String userName, Double balance) {
        File inFile = new File("user.csv");
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
            csvReader.close();

            File outFile = new File("user.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            CsvWriter csvWriter = new CsvWriter(writer,',');
            for (Iterator<String[]> iterator = records.iterator(); iterator.hasNext();) {
                csvWriter.writeRecord(iterator.next());
            }
            csvWriter.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    // select
    @Override
    public User queryByUserName(String userName) {
        File inFile = new File("user.csv");
        try {
            String[] inString;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                inString = csvReader.getValues();
                if(userName.equals(inString[0])) {
                    user = new User(inString[0], inString[1], inString[2], inString[3], inString[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(inString[5]),
                            Double.parseDouble(inString[6]));
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return user;
    }
}
