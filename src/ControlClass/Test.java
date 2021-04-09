package ControlClass;

import EntityClass.DAO.PersonDAO;
import EntityClass.DAO.UserDAO;
import EntityClass.DAO.impl.PersonDAOImpl;
import EntityClass.DAO.impl.UserDAOImpl;
import EntityClass.VO.*;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        /*
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
        */

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

        /*
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
        */
        PersonDAO personDAO = new PersonDAOImpl();
        /*
        Boolean flag = personDAO.insertPerson(person);
        System.out.println(flag);

        Boolean flag = personDAO.deletePerson("kaiyi");
        System.out.println(flag);

        Person person1 = personDAO.changePersonPassword("kaiyi", "1234");
        System.out.println(person1);

        Person person1 = personDAO.changePersonEmail("kaiyi", "z.kaiyi@se18.qmul.ac.uk");
        System.out.println(person1);

        Person person2 = personDAO.changePersonTeleNo("kaiyi", "18910421646");
        System.out.println(person2);

        Person person1 = personDAO.queryByUserName("kaiyi");
        System.out.println(person1);
         */

        /*
        UserDAOImpl userDAO = new UserDAOImpl();

        Boolean flag = userDAO.insertUser(user);
        System.out.println(flag);

        Boolean flag = userDAO.deleteUser("kaiyi");
        System.out.println(flag);

        User user1 = userDAO.changeUserPassword("kaiyi", "1234");
        System.out.println(user1);

        user1 = userDAO.changeUserEmail("kaiyi", "z.kaiyi@se18.qmul.ac.uk");
        System.out.println(user1);

        user1 = userDAO.changeUserTeleNo("kaiyi", "18910421646");
        System.out.println(user1);

        user1 = userDAO.changeUserBalance("kaiyi", 100.00);
        System.out.println(user1);

        user1 = userDAO.queryByUserName("kaiyi");
        System.out.println(user1);
         */
    }
}
