package Test;

import static org.junit.jupiter.api.Assertions.*;

import EntityClass.VO.*;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


class GymTest {

    @Test
    void testLogin() {
        Validation validation = new Validation();

        assertEquals(true,validation.loginValidation("lqc","20000130lqc"));
        assertEquals(false,validation.loginValidation("lqc","20000130"));//test incorrect password
        assertEquals(false,validation.loginValidation("l","20000130lqc"));//test incorrect username
        assertEquals(false,validation.loginValidation("","20000130lqc"));//test empty username
        assertEquals(false,validation.loginValidation("lqc",""));//test empty password

    }

    @Test
    void testRegister() throws ParseException {
        Validation validation = new Validation();

        assertEquals(true,validation.registerValidation("gym","190016760@qmul.ac.uk","male",
                "190016760Qmul","190016760Qmul", "2020-03-20","17732757918"));
        assertEquals(false,validation.registerValidation("gym","190016760qmul.ac.uk","male",
                "190016760Qmul","190016760Qmul", "2020-03-20","17732757918"));//test invalid email address
        assertEquals(false,validation.registerValidation("gym","190016760@qmul.ac.uk","boy",
                "190016760Qmul","190016760Qmul", "2020-03-20","17732757918"));//test incorrect gender choice
        assertEquals(false,validation.registerValidation("gym","190016760@qmul.ac.uk","male",
                "190016760mul","190016760Qmul", "2020-03-20","17732757918"));//test incorrect password pattern
        assertEquals(false,validation.registerValidation("gym","190016760@qmul.ac.uk","male",
                "190016760Qmul","190016760Qmu", "2020-03-20","17732757918"));//test incorrect confirm password
        assertEquals(false,validation.registerValidation("gym","190016760@qmul.ac.uk","male",
                "190016760Qmul","190016760Qmul", "2022-03-20","17732757918"));//test wrong birthdate
        assertEquals(false,validation.registerValidation("gym","190016760@qmul.ac.uk","male",
                "190016760Qmul","190016760Qmul", "2020-03-20","1773275791800"));//test incorrect telephone number
    }

    @Test
    void testUser() throws ParseException {
        User user = new User("kaiyi","1234","z.kaiyi@se18.qmul.ac.uk", "Male", "18910421646",
                new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse("Thu Nov 25 00:00:00 CST 1999"), 100);
        assertEquals("kaiyi",user.getUserName());
        assertEquals("1234",user.getPassword());
        assertEquals("z.kaiyi@se18.qmul.ac.uk",user.getEmail());
        assertEquals("Male",user.getGender());
        assertEquals("18910421646",user.getTelNo());
        assertEquals(new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse("Thu Nov 25 00:00:00 CST 1999"),user.getDoB());
        assertEquals(100,user.getBalance());
    }

    @Test
    void testPremierUser () throws ParseException {
        PremierUser premierUser = new PremierUser("kaiyi","1234","z.kaiyi@se18.qmul.ac.uk", "Male", "18910421646", new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse("Thu Nov 25 00:00:00 CST 1999"), 1000, 0);

        assertEquals("kaiyi",premierUser.getUserName());
        assertEquals("1234",premierUser.getPassword());
        assertEquals("z.kaiyi@se18.qmul.ac.uk",premierUser.getEmail());
        assertEquals("Male",premierUser.getGender());
        assertEquals("18910421646",premierUser.getTelNo());
        assertEquals(new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse("Thu Nov 25 00:00:00 CST 1999"),premierUser.getDoB());
        assertEquals(1000,premierUser.getBalance());
        assertEquals(0,premierUser.getUserType());
    }

    @Test
    void testTrainer() throws ParseException {
        Trainer trainer = new Trainer("kaiyi","123","zhaokaiyi@bupt.edu.cn","Male","18810282618", new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse("Thu Nov 25 00:00:00 CST 1999"), "London Fitness", 0.0, "I am couch from London Fitness!", 300.0);
        assertEquals("kaiyi",trainer.getUserName());
        assertEquals("123",trainer.getPassword());
        assertEquals("zhaokaiyi@bupt.edu.cn",trainer.getEmail());
        assertEquals("Male",trainer.getGender());
        assertEquals("18810282618",trainer.getTelNo());
        assertEquals(new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse("Thu Nov 25 00:00:00 CST 1999"),trainer.getDoB());
        assertEquals("London Fitness",trainer.getCompanyName());
        assertEquals(0.0,trainer.getSalary());
        assertEquals("I am couch from London Fitness!",trainer.getCV());
        assertEquals(300.0,trainer.getPrice());
    }

    @Test
    void testManeger() throws ParseException {
        Manager manager = new Manager("kaiyi","1234","z.kaiyi@se18.qmul.ac.uk","Male","18910421646", new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse("Thu Nov 25 00:00:00 CST 1999"), "London Fitness", 1);
        assertEquals("kaiyi",manager.getUserName());
        assertEquals("1234",manager.getPassword());
        assertEquals("z.kaiyi@se18.qmul.ac.uk",manager.getEmail());
        assertEquals("Male",manager.getGender());
        assertEquals("18910421646",manager.getTelNo());
        assertEquals(new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse("Thu Nov 25 00:00:00 CST 1999"),manager.getDoB());
        assertEquals(1,manager.getManagerType());
    }

    @Test
    void testRecvideo() throws ParseException {
        RecVideo recVideo = new RecVideo(1618238738772L,"Hiit",30,0,0.0,"kaiyi",new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse("Mon Apr 12 22:45:38 CST 2021"), 1, 0);
        assertEquals(1618238738772L,recVideo.getCourseId());
        assertEquals("Hiit",recVideo.getSubject());
        assertEquals(30,recVideo.getLength());
        assertEquals(0,recVideo.getGift());
        assertEquals(0.0,recVideo.getStar());
        assertEquals("kaiyi",recVideo.getUserName());
        assertEquals(new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse("Mon Apr 12 22:45:38 CST 2021"),recVideo.getUploadedTime());
        assertEquals(1,recVideo.getViewTime());
        assertEquals(0, recVideo.getRateTime());
    }

    @Test
    void testLivesession() throws ParseException {
        LiveSession liveSession = new LiveSession(1622184525927L,"Yoga",2,0,0.0, new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse("Fri May 28 10:00:00 CST 2021"), "kaiyi", "kaiyi");
        assertEquals(1622184525927L,liveSession.getCourseId());
        assertEquals("Yoga", liveSession.getSubject());
        assertEquals(2,liveSession.getLength());
        assertEquals(0,liveSession.getGift());
        assertEquals(0.0,liveSession.getStar());
        assertEquals(new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse("Fri May 28 10:00:00 CST 2021"),liveSession.getStartTime());
        assertEquals("kaiyi",liveSession.getTrainerName());
        assertEquals("kaiyi",liveSession.getUserName());
    }

}
