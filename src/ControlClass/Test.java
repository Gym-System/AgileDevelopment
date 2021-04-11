package ControlClass;

import EntityClass.DAO.PersonDAO;
import EntityClass.DAO.impl.*;
import EntityClass.VO.*;

import java.text.ParseException;

public class Test {
    public static void main(String[] args) throws ParseException {
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

        Course course = new Course("Strength", "live", 30.0);
        System.out.println(course);

        LiveSession liveSession = null;

        Course course = new Course("Hiit", 30);
        System.out.println(course);

        RecVideo recVideo;

        recVideo = new RecVideo("Hiit",
                30,
                "kaiyi");
        System.out.println(recVideo);

        LiveSession liveSession = null;
        try {
            liveSession = new LiveSession("Hiit",
                    30,
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-05-01 17:15:00"),
                    "kaiyi1",
                    "kaiyi2");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(liveSession);

        PhyData phyData = new PhyData("kaiyi",
                186.0,
                83.4,
                3,
                "Strength",
                20.0);
        System.out.println(phyData);
        */

        /*
        PersonDAO personDAO = new PersonDAOImpl();

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

        /*
        PreUserDAOImpl preUserDAO = new PreUserDAOImpl();

        Boolean flag = preUserDAO.insertPreUser(premierUser);
        System.out.println(flag);

        Boolean flag = preUserDAO.deletePreUser("kaiyi");
        System.out.println(flag);

        User premierUser1 = preUserDAO.changePreUserPassword("kaiyi", "1234");
        System.out.println(premierUser1);

        premierUser1 = preUserDAO.changePreUserEmail("kaiyi", "z.kaiyi@se18.qmul.ac.uk");
        System.out.println(premierUser1);

        premierUser1 = preUserDAO.changePreUserTeleNo("kaiyi", "18910421646");
        System.out.println(premierUser1);

        premierUser1 = preUserDAO.changePreUserBalance("kaiyi", 100.00);
        System.out.println(premierUser1);

        premierUser1 = preUserDAO.queryByUserName("kaiyi");
        System.out.println(premierUser1);

        premierUser1 = preUserDAO.changePreUserType("kaiyi", 1);
        System.out.println(premierUser1);
         */

        /*
        StaffDAO staffDAO = new StaffDAOImpl();

        Boolean flag = staffDAO.insertStaff(staff);
        System.out.println(flag);

        Boolean flag = staffDAO.deleteStaff("kaiyi");
        System.out.println(flag);

        Staff staff1 = staffDAO.changeStaffPassword("kaiyi", "1234");
        System.out.println(staff1);

        Staff staff1 = staffDAO.changeStaffEmail("kaiyi", "z.kaiyi@se18.qmul.ac.uk");
        System.out.println(staff1);

        Staff staff1 = staffDAO.changeStaffTeleNo("kaiyi", "18910421646");
        System.out.println(staff1);

        Staff staff1 = staffDAO.queryByUserName("kaiyi");
        System.out.println(staff1);
        */

        /*
        TrainerDAOImpl trainerDAO = new TrainerDAOImpl();

        Boolean flag = trainerDAO.insertTrainer(trainer);
        System.out.println(flag);

        Boolean flag = trainerDAO.deleteTrainer("kaiyi");
        System.out.println(flag);

        Trainer trainer1 = trainerDAO.changeTrainerPassword("kaiyi", "1234");
        System.out.println(trainer1);

        trainer1 = trainerDAO.changeTrainerEmail("kaiyi", "z.kaiyi@se18.qmul.ac.uk");
        System.out.println(trainer1);

        trainer1 = trainerDAO.changeTrainerTeleNo("kaiyi", "18910421646");
        System.out.println(trainer1);

        trainer1 = trainerDAO.changeTrainSalary("kaiyi", 10000.0);
        System.out.println(trainer1);

        trainer1 = trainerDAO.queryByUserName("kaiyi");
        System.out.println(trainer1);
         */

        /*
        ManagerDAOImpl managerDAO = new ManagerDAOImpl();

        Boolean flag = managerDAO.insertManager(manager);
        System.out.println(flag);

        Boolean flag = managerDAO.deleteManager("kaiyi");
        System.out.println(flag);

        Manager manager1 = managerDAO.changeManagerPassword("kaiyi", "1234");
        System.out.println(manager1);

        manager1 = managerDAO.changeManagerEmail("kaiyi", "z.kaiyi@se18.qmul.ac.uk");
        System.out.println(manager1);

        manager1 = managerDAO.changeManagerTeleNo("kaiyi", "18910421646");
        System.out.println(manager1);

        manager1 = managerDAO.changeManagerType("kaiyi", 1);
        System.out.println(manager1);

        manager1 = managerDAO.queryByUserName("kaiyi");
        System.out.println(manager1);
         */

        /*
        CourseDAOImpl courseDAO = new CourseDAOImpl();

        Boolean flag = courseDAO.insertCourse(course);
        System.out.println(flag);

        Boolean flag = courseDAO.deleteCourse(course.setCourseId());
        System.out.println(flag);

        Course course1 = courseDAO.changeCourseGift(course.getCourseId(), 10);
        System.out.println(course1);

        course1 = courseDAO.changeCourseStar(course.getCourseId(), 5.0);
        System.out.println(course1);

        ArrayList<Course> courses;
        courses = courseDAO.queryBySubject("Hiit");
        for(Course course:courses) {
            System.out.println(course);
        }
        */

        /*
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();

        Boolean flag = recVideoDAO.insertRecVideo(recVideo);
        System.out.println(flag);

        flag = recVideoDAO.deleteRecVideo(recVideo.getCourseId());
        System.out.println(flag);

        RecVideo recVideo1 = recVideoDAO.changeRecVideoGift(recVideo.getCourseId(), 10);
        System.out.println(recVideo1);

        recVideo1 = recVideoDAO.changeRecVideoStar(recVideo.getCourseId(), 5.0);
        System.out.println(recVideo1);

        recVideo1 = recVideoDAO.changeRecVideoViewTime(recVideo.getCourseId(), 1);
        System.out.println(recVideo1);

        ArrayList<RecVideo> recVideos;
        recVideos = recVideoDAO.queryBySubject("Hiit");
        for(RecVideo recVideo1:recVideos) {
            System.out.println(recVideo1);
        }

        recVideos = recVideoDAO.queryByTrainerName("kaiyi");
        for(RecVideo recVideo1:recVideos) {
            System.out.println(recVideo1);
        }
         */

        /*
        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();

        Boolean flag = liveSessionDAO.insertLiveSession(liveSession);
        System.out.println(flag);

        flag = liveSessionDAO.deleteLiveSession(liveSession.getCourseId());
        System.out.println(flag);

        LiveSession liveSession1 = liveSessionDAO.changeLiveSessionGift(liveSession.getCourseId(), 10);
        System.out.println(liveSession1);

        liveSession1 = liveSessionDAO.changeLiveSessionStar(liveSession.getCourseId(), 5.0);
        System.out.println(liveSession1);

        liveSession1 = liveSessionDAO.changeLiveSessionStartTime(liveSession.getCourseId(), "2021-05-01 17:30:00");
        System.out.println(liveSession1);

        ArrayList<LiveSession> liveSessions;
        liveSessions = liveSessionDAO.queryByTrainerName("kaiyi1");
        for(LiveSession liveSession1:liveSessions) {
            System.out.println(liveSession1);
        }

        liveSessions = liveSessionDAO.queryByUserName("kaiyi2");
        for(LiveSession liveSession1:liveSessions) {
            System.out.println(liveSession1);
        }
        */

        /*
        PhyDataDAOImpl phyDataDAO= new PhyDataDAOImpl();

        Boolean flag = phyDataDAO.insertPhyData(phyData);
        System.out.println(flag);

        flag = phyDataDAO.deletePhyData(phyData.getUserName());
        System.out.println(flag);

        PhyData phyData1 = phyDataDAO.changePhyDataHeight(phyData.getUserName(), 190.0);
        System.out.println(phyData1);

        phyData1 = phyDataDAO.changePhyDataWeight(phyData.getUserName(), 80.0);
        System.out.println(phyData1);

        phyData1 = phyDataDAO.changePhyDataExperience(phyData.getUserName(), 5);
        System.out.println(phyData1);

        phyData1 = phyDataDAO.changePhyDataInterest(phyData.getUserName(), "Boxing");
        System.out.println(phyData1);

        phyData1 = phyDataDAO.changePhyDataBFR(phyData.getUserName(), 18.0);
        System.out.println(phyData1);

        phyData1 = phyDataDAO.queryByUserName(phyData.getUserName());
        System.out.println(phyData1);
         */
    }
}