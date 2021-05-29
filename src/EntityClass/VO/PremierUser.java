package EntityClass.VO;

import EntityClass.DAO.impl.OrderDAOImpl;
import EntityClass.DAO.impl.PreUserDAOImpl;
import EntityClass.DAO.impl.WatchedVideoDAOImpl;
import EntityClass.DAO.impl.LiveSessionDAOImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * javadoc of PremierUser class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class PremierUser extends User {
    private int userType = 1;

    /**
     * This constructor contains major params needed to make a instance of PremierUser class.
     * @param userName The userName of a user
     * @param password The password of a user
     * @param email The email of a user
     */
    public PremierUser(String userName, String password, String email) {
        super(userName, password, email);
    }

    /**
     * This constructor contains all params needed to make a instance of PremierUser class.
     * @param userName The userName of a user
     * @param password The password of a user
     * @param email The email of a user
     * @param gender The gender of a user
     * @param telNo The telephone number of a user
     * @param doB The date of birth of a user
     */
    public PremierUser(String userName, String password, String email, String gender, String telNo, Date doB) {
        super(userName, password, email, gender, telNo, doB);
    }

    /**
     * This constructor contains all params needed to make a instance of PremierUser class.
     * @param userName The userName of a user
     * @param password The password of a user
     * @param email The email of a user
     * @param gender The gender of a user
     * @param telNo The telephone number of a user
     * @param doB The date of birth of a user
     * @param balance The balance of a user
     * @param userType The leve of premier the user is in
     */
    public PremierUser(String userName, String password, String email, String gender, String telNo, Date doB, double balance, int userType) {
        super(userName, password, email, gender, telNo, doB, balance);
        this.userType = userType;
    }

    /**
     * The getter method of userType
     * @return userType
     */
    public int getUserType() {
        return userType;
    }

    /**
     * The setter method of userType
     * @param userType The userType of a user
     */
    public void setUserType(int userType) {
        this.userType = userType;
    }

    /**
     * This method calculate the real price according to the userType
     * @param price The price of a live session
     * @return The discount price according to the userType
     */
    public double calDiscount(double price) {
        calUserType();
        double discount = price * (1 - userType /10);

        return discount;
    }

    /**
     * This method calculate the userType according to the how many courses did the user buy
     */
    public void calUserType() {
        int type;
        double expend = 0.0;
        ArrayList<Order> orders = new OrderDAOImpl().queryByUserName(super.getUserName());
        for(Order order:orders) {
            expend += order.getCost();
        }

        if (expend < 50000) {
            type = (int) (expend/10000);
            setUserType(type);
        }
        else {
            type = 5;
            setUserType(type);
        }
        new PreUserDAOImpl().changePreUserType(super.getUserName(), type);
    }

    /**
     * This method create watched video history
     * @param courseId The ID of a course
     */
    public void watchLiveSession(long courseId) {
        String type = "live";
        WatchedVideo watchedVideo = new WatchedVideo(super.getUserName(), type, courseId);
        WatchedVideoDAOImpl watchedVideoDAO = new WatchedVideoDAOImpl();
        watchedVideoDAO.insertHistoryData(watchedVideo);
    }

    /**
     * User book live session with a trainer and create order
     * @param trainer Trainer class
     * @param startTime The time the live session started
     * @return A boolean value indicating whether the operation succeed
     */
    public boolean bookLiveSession(Trainer trainer, Date startTime) {
        boolean flag = false;

        if(getBalance() > calDiscount(trainer.getPrice())) {
            flag = true;
            setBalance(getBalance() - calDiscount(trainer.getPrice()));

            LiveSession liveSession = new LiveSession(null, 2, startTime, trainer.getUserName(), getUserName());
            LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
            liveSessionDAO.insertLiveSession(liveSession);

            Order order = new Order(liveSession.getCourseId(), super.getUserName(), calDiscount(trainer.getPrice()));
            new OrderDAOImpl().insertOrder(order);
        }

        return flag;
    }

    /**
     * User cancel booked live session
     * @param courseId The ID of a course
     */
    public void cancelLiveSession(long courseId) {
        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        liveSessionDAO.deleteLiveSession(courseId);

        new OrderDAOImpl().deleteOrder(courseId);
    }

    /**
     * This method show user's calender
     * @return A array list of live sessions
     * @throws ParseException
     */
    public ArrayList<LiveSession> showCalender() throws ParseException {
        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        ArrayList<LiveSession> liveSessions = liveSessionDAO.queryByUserName(getUserName());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date startTime = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(
                new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).format(calendar.getTime()));
        calendar.add(Calendar.DATE, 7);
        Date endTime = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(
                new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).format(calendar.getTime()));

        ArrayList<LiveSession> liveSessions1 = new ArrayList<LiveSession>();

        for (LiveSession liveSession:liveSessions) {
            if(liveSession.getStartTime().after(startTime) && liveSession.getStartTime().before(endTime)) {
                liveSessions1.add(liveSession);
            }
        }

        return liveSessions1;
    }

    /**
     * This method change the balance of the premier user
     * @param money This amount money the user recharged
     * @return A boolean value indicating whether the operation is succeed
     */
    @Override
    public boolean recharge(double money) {
        setBalance(getBalance() + money);
        new PreUserDAOImpl().changePreUserBalance(super.getUserName(),getBalance() + money);

        return true;
    }

    /**
     * This method organize instance variables of PremierUser class into a string array
     * @return A string array contain instance variables of PremierUser class
     */
    @Override
    public String[] toStrArray() {
        String text = "" + super.getUserName() + "," + super.getPassword() + "," + super.getEmail() + "," +
                super.getGender() + "," + super.getTelNo() + "," + super.getDoB() + "," + super.getBalance() + "," +
                userType;
        return text.split(",");
    }

    /**
     * This method organize instance variables of PremierUser class into a readable way
     * @return A string contains instance variables of PremierUser class
     */
    @Override
    public String toString() {
        return "PremierUser{" +
                "userType=" + userType +
                "} " + super.toString();
    }
}