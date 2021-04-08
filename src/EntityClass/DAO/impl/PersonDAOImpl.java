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

public class PersonDAOImpl implements PersonDAO {
    private Person person = null;

    // insert
    @Override
    public Boolean insertPerson(Person person) {
        boolean flag = false;
        File outFile = new File("person.csv");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));
            CsvWriter csvWriter = new CsvWriter(writer,',');
            csvWriter.writeRecord(person.toStrArray());
            csvWriter.close();
            flag = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    // delete
    @Override
    public Boolean deletePerson(String userName) {
        Boolean flag = false;
        File inFile = new File("person.csv");
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

            File outFile = new File("person.csv");
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
    public Person changePersonPassword(String userName, String password) {
        File inFile = new File("person.csv");
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

            File outFile = new File("person.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            CsvWriter csvWriter = new CsvWriter(writer,',');
            for (Iterator<String[]> iterator = records.iterator(); iterator.hasNext();) {
                csvWriter.writeRecord(iterator.next());
            }
            csvWriter.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return person;
    }

    @Override
    public Person changePersonEmail(String userName, String email) {
        File inFile = new File("person.csv");
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

            File outFile = new File("person.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            CsvWriter csvWriter = new CsvWriter(writer,',');
            for (Iterator<String[]> iterator = records.iterator(); iterator.hasNext();) {
                csvWriter.writeRecord(iterator.next());
            }
            csvWriter.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return person;
    }

    @Override
    public Person changePersonTeleNo(String userName, String teleNo) {
        File inFile = new File("person.csv");
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

            File outFile = new File("person.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            CsvWriter csvWriter = new CsvWriter(writer,',');
            for (Iterator<String[]> iterator = records.iterator(); iterator.hasNext();) {
                csvWriter.writeRecord(iterator.next());
            }
            csvWriter.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return person;
    }

    // select
    @Override
    public Person queryByUserName(String userName) {
        File inFile = new File("person.csv");
        try {
            String[] inString;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                inString = csvReader.getValues();
                if(userName.equals(inString[0])) {
                    person = new Person(inString[0], inString[1], inString[2], inString[3], inString[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(inString[5]));
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return person;
    }
}
