package ControlClass;

import EntityClass.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import com.google.gson.*;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

        String json = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(person);
            json = "{\"" + person.getUserName() + "\":" + json + "}";
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            FileUtils.writeStringToFile(new File("person.json"), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
