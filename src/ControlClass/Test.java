package ControlClass;

import EntityClass.*;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        Person person = null;
        try {
            person = new Person("kaiyi",
                    "123",
                    "zhaokaiyi@bupt.edu.cn",
                    "Male",
                    "18810282618",
                    new SimpleDateFormat("yyyy-MM-dd").parse("1999-11-25"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(person);

        User user = null;
        try {
            user = new User("kaiyi",
                    "123",
                    "zhaokaiyi@bupt.edu.cn",
                    "Male",
                    "18810282618",
                    new SimpleDateFormat("yyyy-MM-dd").parse("1999-11-25"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(user);

        Staff staff = null;
        try {
            staff = new Staff("kaiyi",
                    "123",
                    "zhaokaiyi@bupt.edu.cn",
                    "Male",
                    "18810282618",
                    new SimpleDateFormat("yyyy-MM-dd").parse("1999-11-25"),
                    "London Fitness");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(staff);

        Trainer trainer = null;
        try {
            trainer = new Trainer("kaiyi",
                    "123",
                    "zhaokaiyi@bupt.edu.cn",
                    "Male",
                    "18810282618",
                    new SimpleDateFormat("yyyy-MM-dd").parse("1999-11-25"),
                    "London Fitness");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(trainer);

        Manager manager = null;
        try {
            manager = new Manager("kaiyi",
                    "123",
                    "zhaokaiyi@bupt.edu.cn",
                    "Male",
                    "18810282618",
                    new SimpleDateFormat("yyyy-MM-dd").parse("1999-11-25"),
                    "London Fitness");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(manager);

        PremierUser premierUser = null;
        try {
            premierUser = new PremierUser("kaiyi",
                    "123",
                    "zhaokaiyi@bupt.edu.cn",
                    "Male",
                    "18810282618",
                    new SimpleDateFormat("yyyy-MM-dd").parse("1999-11-25"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(premierUser);

        PhyData phyData = new PhyData("kaiyi",
                    186.0,
                    83.4,
                    3,
                    "Strength",
                    20.0);
        System.out.println(phyData);

        Course course = new Course("Strength", "live", 30.0);
        System.out.println(course);

        LiveSession liveSession = null;

        try {
             liveSession = new LiveSession("kaiyi1",
                    "kaiyi2",
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-04-02 17:15:00"),
                    "Strength",
                    "Live",
                    30.0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(liveSession);

        RecVideo recVideo = null;

        try {
            recVideo = new RecVideo("kaiyi1",
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-04-02 17:15:00"),
                    "Strength",
                    "Live",
                    30.0);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(recVideo);

        File outFile = new File("person.csv");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            CsvWriter cwriter = new CsvWriter(writer,',');
            for(int i=0; i<5; i++) {
                cwriter.writeRecord(person.toStrArray());
            }
            cwriter.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File inFile = new File("person.csv");
        try {
            String[] inString;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader creader = new CsvReader(reader, ',');
            while(creader.readRecord()){
                inString = creader.getValues();
                Person person2 = new Person(inString[0], inString[1], inString[2], inString[3], inString[4],
                        new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(inString[5]));
                System.out.println(person2);
            }
            creader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
