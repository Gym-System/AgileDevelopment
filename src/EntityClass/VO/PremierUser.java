package EntityClass.VO;

import EntityClass.DAO.PreUserDAO;
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

public class PremierUser extends User {
    private int userType = 1;

    public PremierUser(String userName, String password, String email) {
        super(userName, password, email);
    }

    public PremierUser(String userName, String password, String email, String gender, String telNo, Date doB) {
        super(userName, password, email, gender, telNo, doB);
    }

    public PremierUser(String userName, String password, String email, String gender, String telNo, Date doB, double balance, int userType) {
        super(userName, password, email, gender, telNo, doB, balance);
        this.userType = userType;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public double calDiscount(double price) {
        calUserType();
        double discount = price * (1 - userType /10);

        return discount;
    }

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

    public void watchLiveSession(long courseId) {
        String type = "live";
        WatchedVideo watchedVideo = new WatchedVideo(super.getUserName(), type, courseId);
        WatchedVideoDAOImpl historyDataDAO = new WatchedVideoDAOImpl();
        historyDataDAO.insertHistoryData(watchedVideo);
    }

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

    public void cancelLiveSession(long courseId) {
        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        liveSessionDAO.deleteLiveSession(courseId);

        new OrderDAOImpl().deleteOrder(courseId);
    }

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

    @Override
    public String[] toStrArray() {
        String text = "" + super.getUserName() + "," + super.getPassword() + "," + super.getEmail() + "," +
                super.getGender() + "," + super.getTelNo() + "," + super.getDoB() + "," + super.getBalance() + "," +
                userType;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "PremierUser{" +
                "userType=" + userType +
                "} " + super.toString();
    }
}