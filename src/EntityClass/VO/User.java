package EntityClass.VO;

import EntityClass.DAO.impl.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * javadoc of User class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class User extends Person {
    private double balance = 0.0;

    /**
     * This constructor contains major params needed to make a instance of User class.
     * @param userName The userName of a user
     * @param password The password of a user
     * @param email The email of a user
     */
    public User(String userName, String password, String email) {
        super(userName, password, email);
    }

    /**
     * This constructor contains all params needed to make a instance of User class.
     * @param userName The userName of a user
     * @param password The password of a user
     * @param email The email of a user
     * @param gender The gender of a user
     * @param telNo The telephone number of a user
     * @param doB The date of birth of a user
     */
    public User(String userName, String password, String email, String gender, String telNo, Date doB) {
        super(userName, password, email, gender, telNo, doB);
    }

    /**
     * This constructor contains all params needed to make a instance of User class.
     * @param userName The userName of a user
     * @param password The password of a user
     * @param email The email of a user
     * @param gender The gender of a user
     * @param telNo The telephone number of a user
     * @param doB The date of birth of a user
     * @param balance The balance of a user
     */
    public User(String userName, String password, String email, String gender, String telNo, Date doB, double balance) {
        super(userName, password, email, gender, telNo, doB);
        this.balance = balance;
    }

    /**
     * The getter method of balance
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * The setter method of balance
     * @param balance The balance of a user
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * This method create watched video history and recalculate view times of the video
     * @param courseId The ID of a course
     */
    public void watchRecVideo(long courseId) {
        String type = "recorded";
        WatchedVideo watchedVideo = new WatchedVideo(super.getUserName(), type, courseId);
        WatchedVideoDAOImpl watchedVideoDAO = new WatchedVideoDAOImpl();
        watchedVideoDAO.insertHistoryData(watchedVideo);

        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
        RecVideo recVideo = recVideoDAO.queryByCourseId(courseId);
        int viewTime = recVideo.getViewTime();
        recVideoDAO.changeRecVideoViewTime(courseId, viewTime + 1);
    }

    /**
     * This method create favorite video record
     * @param courseId The ID of a course
     */
    public void favoriteVideo(long courseId) {
        FavoriteVideo favoriteVideo = new FavoriteVideo(super.getUserName(), courseId);
        FavoriteVideoImpl favoriteVideoDao = new FavoriteVideoImpl();
        favoriteVideoDao.insertFavoriteVideo(favoriteVideo);
    }

    /**
     * This method create delete favorite video record
     * @param courseId The ID of a course
     */
    public void unFavoriteVideo(long courseId) {
        FavoriteVideoImpl favoriteVideoDAO = new FavoriteVideoImpl();
        favoriteVideoDAO.deleteFavoriteVideo(courseId);
    }

    /**
     * This method upgrade user to premier user and change the balance of the premier user
     * @param money This amount money the user recharged
     * @return A boolean value indicating whether the operation is succeed
     */
    public boolean recharge(double money) {
        if(money > 0) {
            UserDAOImpl userDAO = new UserDAOImpl();
            userDAO.deleteUser(super.getUserName());
            PremierUser premierUser = new PremierUser(super.getUserName(), super.getPassword(), super.getEmail(), super.getGender(), super.getTelNo(), super.getDoB());
            premierUser.setBalance(money);
            PersonDAOImpl personDAO = new PersonDAOImpl();
            personDAO.insertPerson(premierUser);

            return true;
        }
        else {
            return false;
        }
    }

    /**
     * User can send gift to a particular recorded video of a trainer
     * @param amount The amount of gift user would like to send
     * @param courseId The ID of a course
     */
    public void sendGift2RecVideo(int amount, long courseId) {
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
        RecVideo recVideo = recVideoDAO.queryByCourseId(courseId);
        int gift = recVideo.getGift() + amount;
        recVideoDAO.changeRecVideoGift(courseId, gift);

        UserDAOImpl userDAO = new UserDAOImpl();
        balance -= amount;
        userDAO.changeUserBalance(getUserName(), balance);
    }

    /**
     * User can rate a particular recorded video of a trainer
     * @param rate The value of rating
     * @param courseId The ID of a course
     */
    public void rateRecVideo(int rate, long courseId) {
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
        RecVideo recVideo = recVideoDAO.queryByCourseId(courseId);
        double star = recVideo.getStar();
        int rateTime = recVideo.getRateTime();
        star = (star * rateTime + rate) / (rateTime + 1);
        recVideoDAO.changeRecVideoStar(courseId, star);
        recVideoDAO.changeRecVideoRateTime(courseId, rateTime + 1);
    }

    /**
     * This method calculate the exercise time of a user according to duration, subject and course type
     * @param timeType What duration is considered
     * @param subject Which subject is considered
     * @param courseType Which course type is considered
     * @return The exercise time of a user according to duration, subject and course type
     * @throws ParseException
     */
    public int getExerciseTime(String timeType, String subject, String courseType) throws ParseException {
        int time = 0;
        WatchedVideoDAOImpl historyDataDAO = new WatchedVideoDAOImpl();
        ArrayList<WatchedVideo> watchedVideos = historyDataDAO.queryByUserName(getUserName());
        ArrayList<WatchedVideo> historyDatas1 = new ArrayList<>();

        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        LiveSession liveSession;
        RecVideo recVideo;

        if(timeType != null) {
            Date date1, date2;

            switch(timeType) {
                case "day":
                    calendar.add(Calendar.DATE,-1);
                    break;
                case "week":
                    calendar.add(Calendar.DATE,-7);
                    break;
                case "month":
                    calendar.add(Calendar.MONTH,-1);
                    break;
                case "year":
                    calendar.add(Calendar.MONTH,-12);
                    break;
            }

            date2 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(
                    new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).format(calendar.getTime()));

            for(WatchedVideo watchedVideo : watchedVideos) {
                if(watchedVideo.getType().equals("live")) {
                    liveSession = liveSessionDAO.queryByCourseId(watchedVideo.getCourseId());
                    date1 = liveSession.getStartTime();
                }
                else {
                    recVideo = recVideoDAO.queryByCourseId(watchedVideo.getCourseId());
                    date1 = recVideo.getUploadedTime();
                }
                if(date1.after(date2)) {
                    historyDatas1.add(watchedVideo);
                }
            }
            watchedVideos.clear();
            for(WatchedVideo watchedVideo :historyDatas1) {
                watchedVideos.add(watchedVideo);
            }
            historyDatas1.clear();
        }

        if(subject != null) {
            for(WatchedVideo watchedVideo : watchedVideos) {
                if (watchedVideo.getType().equals("live")) {
                    liveSession = liveSessionDAO.queryByCourseId(watchedVideo.getCourseId());
                    if (liveSession.getSubject().equals(subject)) {
                        historyDatas1.add(watchedVideo);
                    }
                }
                else {
                    recVideo = recVideoDAO.queryByCourseId(watchedVideo.getCourseId());
                    if (recVideo.getSubject().equals(subject)) {
                        historyDatas1.add(watchedVideo);
                    }
                }
            }
            watchedVideos.clear();
            for(WatchedVideo watchedVideo :historyDatas1) {
                watchedVideos.add(watchedVideo);
            }
            historyDatas1.clear();
        }

        if(courseType != null) {
            if(courseType.equals("live")) {
                for(WatchedVideo watchedVideo : watchedVideos) {
                    if(watchedVideo.getType().equals("live")) {
                        historyDatas1.add(watchedVideo);
                    }
                }
            }
            else {
                for(WatchedVideo watchedVideo : watchedVideos) {
                    if(watchedVideo.getType().equals("recorded")) {
                        historyDatas1.add(watchedVideo);
                    }
                }
            }
            watchedVideos.clear();
            for(WatchedVideo watchedVideo :historyDatas1) {
                watchedVideos.add(watchedVideo);
            }
            historyDatas1.clear();
        }

        time = calExerciseTime(watchedVideos);

        return time;
    }

    /**
     * This method is a helper function of public int getExerciseTime(String timeType, String subject, String courseType)
     * @param watchedVideos A array list of watchedVideo history
     * @return The exercise time of a user
     */
    public int calExerciseTime(ArrayList<WatchedVideo> watchedVideos) {
        int time = 0;
        LiveSession liveSession;
        RecVideo recVideo;
        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();

        for(WatchedVideo watchedVideo : watchedVideos) {
            if(watchedVideo.getType().equals("live")) {
                liveSession = liveSessionDAO.queryByCourseId(watchedVideo.getCourseId());
                time += liveSession.getLength();
            }
            else {
                recVideo = recVideoDAO.queryByCourseId(watchedVideo.getCourseId());
                time += recVideo.getLength();
            }
        }
        return time;
    }

    /**
     * This method organize instance variables of User class into a string array
     * @return A string array contain instance variables of User class
     */
    public String[] toStrArray() {
        String text = "" + super.getUserName() + "," + super.getPassword() + "," + super.getEmail() + "," +
                super.getGender() + "," + super.getTelNo() + "," + super.getDoB() + "," + balance;
        return text.split(",");
    }

    /**
     * This method organize instance variables of User class into a readable way
     * @return A string contains instance variables of User class
     */
    @Override
    public String toString() {
        return "User{" +
                "balance=" + balance +
                "} " + super.toString();
    }
}