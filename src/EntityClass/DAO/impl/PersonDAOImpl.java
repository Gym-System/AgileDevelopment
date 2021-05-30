package EntityClass.DAO.impl;

import EntityClass.DAO.PersonDAO;
import EntityClass.VO.Person;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/**
 * javadoc of PersonDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class PersonDAOImpl implements PersonDAO {
    private Person person = null;
    public static final String fileFolder = "./src/Data/";
    private final String fileName = "person.csv";
    private String filePath = fileFolder + fileName;

    /**
     * This method insert a Person class into person.sv
     * @param person A Person class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertPerson(Person person) {
        return insertInfo(filePath, person.toStrArray());
    }

    /**
     * This method query a person record by userName and delete the record
     * @param userName The userName of a person
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deletePerson(String userName) {
        return deleteInfo(userName, filePath);
    }

    /**
     * This method query a person record by userName and change the password value of the record
     * @param userName The userName of a person
     * @param password The password value of a person
     * @return A Person class after changing
     */
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

    /**
     * This method query a person record by userName and change the email value of the record
     * @param userName The userName of a person
     * @param email The email value of a person
     * @return A Person class after changing
     */
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

    /**
     * This method query a person record by userName and change the telephone number of the record
     * @param userName The userName of a person
     * @param teleNo The telephone number of a person
     * @return A Person class after changing
     */
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

    /**
     * This method query a person record by user name
     * @param userName The userName of a person
     * @return A Person class
     */
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

    /**
     * This method query all the person records
     * @return A array list of person class
     */
    @Override
    public ArrayList<Person> queryAll() {
        File inFile = new File(filePath);
        ArrayList<Person> people = new ArrayList<>();
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                person = new Person(record[0], record[1], record[2], record[3], record[4],
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]));
                people.add(person);
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return people;
    }

    /**
     * This method is insert information into a file
     * @param fileName The name of a file
     * @param strings This records needed to be inserted
     * @return A boolean value indicating whether the operation is completed successfully
     */
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

    /**
     * This method overwrite all the information
     * @param records This records needed to be written
     * @param fileName The name of a file
     * @throws IOException
     */
    static void recordToCsv(ArrayList<String[]> records, String fileName) throws IOException {
        File outFile = new File(fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
        CsvWriter csvWriter = new CsvWriter(writer,',');
        for (Iterator<String[]> iterator = records.iterator(); iterator.hasNext();) {
            csvWriter.writeRecord(iterator.next());
        }
        csvWriter.close();
    }

    /**
     * This method delete a record from a file
     * @param userName The user name of a person
     * @param fileName The name of a file
     * @return A boolean value indicating whether the operation is completed successfully
     */
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
