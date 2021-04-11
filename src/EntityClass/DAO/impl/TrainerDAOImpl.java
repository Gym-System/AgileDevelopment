package EntityClass.DAO.impl;

import EntityClass.DAO.TrainerDAO;
import EntityClass.VO.Staff;
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

public class TrainerDAOImpl implements TrainerDAO {
    private Trainer trainer = null;
    private final String fileName = "trainer.csv";

    @Override
    public Boolean insertTrainer(Trainer trainer) {
        return insertInfo(fileName, trainer.toStrArray());
    }

    @Override
    public Boolean deleteTrainer(String userName) {
        return deleteInfo(userName, fileName);
    }

    @Override
    public Trainer changeTrainerPassword(String userName, String password) {
        File inFile = new File(fileName);
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
                            record[6], Double.parseDouble(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, fileName);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }

    @Override
    public Trainer changeTrainerEmail(String userName, String email) {
        File inFile = new File(fileName);
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
                            record[6], Double.parseDouble(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, fileName);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }

    @Override
    public Trainer changeTrainerTeleNo(String userName, String teleNo) {
        File inFile = new File(fileName);
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
                            record[6], Double.parseDouble(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, fileName);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }

    @Override
    public Trainer changeTrainSalary(String userName, double salary) {
        File inFile = new File(fileName);
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
                            record[6], Double.parseDouble(record[7]));
                }
                records.add(record);
            }
            csvReader.close();
            recordToCsv(records, fileName);
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }

    @Override
    public Trainer queryByUserName(String userName) {
        File inFile = new File(fileName);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[0])) {
                    trainer = new Trainer(record[0], record[1], record[2], record[3], record[4],
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(record[5]),
                            record[6], Double.parseDouble(record[7]));
                }
            }
            csvReader.close();
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return trainer;
    }
}
