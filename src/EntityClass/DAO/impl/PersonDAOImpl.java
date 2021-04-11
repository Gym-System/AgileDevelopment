package EntityClass.DAO.impl;

import EntityClass.DAO.PersonDAO;
import EntityClass.VO.Person;
import EntityClass.VO.PremierUser;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class PersonDAOImpl implements PersonDAO {
    private Person person = null;
    public static final String fileFolder = "./src/Data/";
    private final String fileName = "person.csv";
    private String filePath = fileFolder + fileName;

    // insert
    @Override
    public Boolean insertPerson(Person person) {
        return insertInfo(filePath, person.toStrArray());
    }

    // delete
    @Override
    public Boolean deletePerson(String userName) {
        return deleteInfo(userName, filePath);
    }

    // update
    @Override
    public Person changePersonPassword(String userName, String password) {
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
                    person = new Person(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return person;
    }

    @Override
    public Person changePersonEmail(String userName, String email) {
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
                    person = new Person(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return person;
    }

    @Override
    public Person changePersonTeleNo(String userName, String teleNo) {
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
                    person = new Person(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return person;
    }

    // select
    @Override
    public Person queryByUserName(String userName) {
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[0])) {
                    person = new Person(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]));
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return person;
    }

    // help function
    static Boolean insertInfo(String fileName, String[] strings) {
        boolean flag = false;
        File outFile = new File(fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));
            CsvWriter csvWriter = new CsvWriter(writer,',');
            csvWriter.writeRecord(strings);
            csvWriter.close();
            flag = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    static void recordToCsv(ArrayList<String[]> records, String fileName) throws IOException {
        File outFile = new File(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
        CsvWriter csvWriter = new CsvWriter(writer,',');
        for (Iterator<String[]> iterator = records.iterator(); iterator.hasNext();) {
            csvWriter.writeRecord(iterator.next());
        }
        csvWriter.close();
    }

    static Boolean deleteInfo(String userName, String fileName) {
        Boolean flag = false;
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
            csvReader.close();
            recordToCsv(records, fileName);
            flag = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}
