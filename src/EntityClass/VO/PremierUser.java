package EntityClass.VO;

import EntityClass.DAO.Impl.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * javadoc of PremierUser class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class PremierUser extends User {
    private int userType = 1;

    /**
     * This constructor contains major params needed to make a instance of Person class.
     * @param userName The userName of a person
     */
    public PremierUser(String userName) {
        super(userName);
    }

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
        Regulation regulation = new RegulationDAOImpl().queryByUserType(getUserType());

        return price * (100 - regulation.getPresentOff()) / 100;
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

        if (expend < 5000) {
            type = (int) (expend/1000);
        }
        else {
            type = 5;
        }

        ArrayList<Regulation> regulations = new RegulationDAOImpl().queryAll();
        for(Regulation regulation:regulations) {
            if(expend >= regulation.getStartMoney() && expend < regulation.getEndMoney()) {
                type = regulation.getUserType();
            }
        }

        setUserType(type);
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
        calUserType();

        boolean flag = false;
        double cost = calDiscount(trainer.getPrice());
        if(getBalance() > cost) {
            flag = true;
            setBalance(getBalance() - cost);
            new PreUserDAOImpl().changePreUserBalance(super.getUserName(), getBalance());

            LiveSession liveSession = new LiveSession(null, 2, startTime, trainer.getUserName(), getUserName());
            LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
            liveSessionDAO.insertLiveSession(liveSession);

            Order order = new Order(liveSession.getCourseId(), super.getUserName(), cost);
            new OrderDAOImpl().insertOrder(order);
        }

        return flag;
    }

    /**
     * User cancel booked live session
     * @param liveSession A LiveSession class
     */
    public void cancelLiveSession(LiveSession liveSession) {
        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        liveSessionDAO.deleteLiveSession(liveSession);

        setBalance(getBalance() + new OrderDAOImpl().queryByCourseId(liveSession.getCourseId()).getCost());
        new PreUserDAOImpl().changePreUserBalance(super.getUserName(), getBalance());

        new OrderDAOImpl().deleteOrder(new Order(liveSession.getCourseId()));
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
        new PreUserDAOImpl().changePreUserBalance(super.getUserName(),getBalance());

        return true;
    }

    /**
     * User can send gift to a particular recorded video of a trainer
     *
     * @param amount   The amount of gift user would like to send
     * @param courseId The ID of a course
     */
    @Override
    public Boolean sendGift2RecVideo(int amount, long courseId) {
        double cost = amount * 10;
        if(getBalance() >= cost) {
            RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
            RecVideo recVideo = recVideoDAO.queryByCourseId(courseId);
            int gift = recVideo.getGift() + amount;
            recVideoDAO.changeRecVideoGift(courseId, gift);

            PreUserDAOImpl preUserDAO = new PreUserDAOImpl();
            setBalance(getBalance() - cost);
            preUserDAO.changePreUserBalance(getUserName(), getBalance());

            return true;
        }
        else{
            return false;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PremierUser)) return false;
        if (!super.equals(o)) return false;
        PremierUser that = (PremierUser) o;
        return getUserType() == that.getUserType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUserType());
    }
}