package EntityClass.DAO.impl;

import EntityClass.DAO.TrainerDAO;
import EntityClass.VO.Trainer;
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
 * javadoc of TrainerDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class TrainerDAOImpl implements TrainerDAO {
    private Trainer trainer = null;
    private final String fileName = "trainer.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    /**
     * This method insert a Trainer class into trainer.sv
     * @param trainer A Trainer class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertTrainer(Trainer trainer) {
        return insertInfo(filePath, trainer.toStrArray());
    }

    /**
     * This method query a trainer record by userName and delete the record
     * @param userName The userName of a trainer
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteTrainer(String userName) {
        return deleteInfo(userName, filePath);
    }

    /**
     * This method query a trainer record by userName and change the password value of the record
     * @param userName The userName of a trainer
     * @param password The password value of a trainer
     * @return A Trainer class after changing
     */
    @Override
    public Trainer changeTrainerPassword(String userName, String password) {
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
                    trainer = new Trainer(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Double.parseDouble(record[7]), record[8], record[9], Double.parseDouble(record[10]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }

    /**
     * This method query a trainer record by userName and change the email value of the record
     * @param userName The userName of a trainer
     * @param email The email value of a trainer
     * @return A Trainer class after changing
     */
    @Override
    public Trainer changeTrainerEmail(String userName, String email) {
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
                    trainer = new Trainer(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Double.parseDouble(record[7]), record[8], record[9], Double.parseDouble(record[10]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }

    /**
     * This method query a trainer record by userName and change the telephone number of the record
     * @param userName The userName of a trainer
     * @param teleNo The telephone number of a trainer
     * @return A Trainer class after changing
     */
    @Override
    public Trainer changeTrainerTeleNo(String userName, String teleNo) {
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
                    trainer = new Trainer(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Double.parseDouble(record[7]), record[8], record[9], Double.parseDouble(record[10]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }

    /**
     * This method query a trainer record by userName and change the telephone number of the record
     * @param userName The userName of a trainer
     * @param salary The salary of a trainer
     * @return A Trainer class after changing
     */
    @Override
    public Trainer changeTrainerSalary(String userName, double salary) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[7] = String.valueOf(salary);
                    trainer = new Trainer(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Double.parseDouble(record[7]), record[8], record[9], Double.parseDouble(record[10]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }

    /**
     * This method query a trainer record by userName and change the telephone number of the record
     * @param userName The userName of a trainer
     * @param label The label of a trainer
     * @return A Trainer class after changing
     */
    @Override
    public Trainer changeTrainerLabel(String userName, String label) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[8] = label;
                    trainer = new Trainer(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Double.parseDouble(record[7]), record[8], record[9], Double.parseDouble(record[10]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }

    /**
     * This method query a trainer record by userName and change the telephone number of the record
     * @param userName The userName of a trainer
     * @param CV The CV of a trainer
     * @return A Trainer class after changing
     */
    @Override
    public Trainer changeTrainerCV(String userName, String CV) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[9] = CV;
                    trainer = new Trainer(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Double.parseDouble(record[7]), record[8], record[9], Double.parseDouble(record[10]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }

    /**
     * This method query a trainer record by userName and change the telephone number of the record
     * @param userName The userName of a trainer
     * @param price The price of a trainer
     * @return A Trainer class after changing
     */
    @Override
    public Trainer changeTrainerPrice(String userName, double price) {
        File inFile = new File(filePath);
        try {
            String[] record = null;
            ArrayList<String[]> records = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getRawRecord().split(",");
                if(userName.equals(record[0])) {
                    record[10] = String.valueOf(price);
                    trainer = new Trainer(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Double.parseDouble(record[7]), record[8], record[9], Double.parseDouble(record[10]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, filePath);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }

    /**
     * This method query a trainer record by user name
     * @param userName The userName of a trainer
     * @return A Trainer class
     */
    @Override
    public Trainer queryByUserName(String userName) {
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[0])) {
                    trainer = new Trainer(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Double.parseDouble(record[7]), record[8], record[9], Double.parseDouble(record[10]));
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }

    /**
     * This method query all the trainer records
     * @return A array list of Trainer class
     */
    @Override
    public ArrayList<Trainer> queryAll() {
        File inFile = new File(filePath);
        ArrayList<Trainer> trainers = new ArrayList<>();
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                trainer = new Trainer(record[0], record[1], record[2], record[3], record[4],
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                        record[6], Double.parseDouble(record[7]), record[8], record[9], Double.parseDouble(record[10]));
                trainers.add(trainer);
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainers;
    }
}
