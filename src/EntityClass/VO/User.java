package EntityClass.VO;

import EntityClass.DAO.impl.HistoryDataDAOImpl;
import EntityClass.DAO.impl.RecVideoDAOImpl;
import EntityClass.DAO.impl.UserDAOImpl;

import java.util.Date;

public class User extends Person {
    private double balance = 0.0;

    public User(String userName, String password, String email) {
        super(userName, password, email);
    }

    public User(String userName, String password, String email, String gender, String telNo, Date doB) {
        super(userName, password, email, gender, telNo, doB);
    }

    public User(String userName, String password, String email, String gender, String telNo, Date doB, double balance) {
        super(userName, password, email, gender, telNo, doB);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void watchRecVideo(long courseId) {
        String type = "recorded";
        HistoryData historyData = new HistoryData(super.getUserName(), type, courseId);
        HistoryDataDAOImpl historyDataDAO = new HistoryDataDAOImpl();
        historyDataDAO.insertHistoryData(historyData);

        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
        RecVideo recVideo = recVideoDAO.queryByCourseId(courseId);
        int viewTime = recVideo.getViewTime();
        recVideoDAO.changeRecVideoViewTime(courseId, viewTime + 1);
    }

    public void joinLiveSession(long courseId) {
        String type = "live";
        HistoryData historyData = new HistoryData(super.getUserName(), type, courseId);
        HistoryDataDAOImpl historyDataDAO = new HistoryDataDAOImpl();
        historyDataDAO.insertHistoryData(historyData);
    }

    public void sendGift(int amount, long courseId) {
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
        RecVideo recVideo = recVideoDAO.queryByCourseId(courseId);
        int gift = recVideo.getGift() + amount;
        recVideoDAO.changeRecVideoGift(courseId, gift);

        UserDAOImpl userDAO = new UserDAOImpl();
        balance -= amount;
        userDAO.changeUserBalance(getUserName(), balance);
    }

    public void rateRecVideo(int rate, long courseId) {
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
        RecVideo recVideo = recVideoDAO.queryByCourseId(courseId);
        double star = recVideo.getStar();
        int rateTime = recVideo.getRateTime();
        star = (star * rateTime + rate) / (rateTime + 1);
        recVideoDAO.changeRecVideoStar(courseId, star);
        recVideoDAO.changeRecVideoRateTime(courseId, rateTime + 1);
    }

    public String[] toStrArray() {
        String text = "" + super.getUserName() + "," + super.getPassword() + "," + super.getEmail() + "," +
                super.getGender() + "," + super.getTelNo() + "," + super.getDoB() + "," + balance;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "User{" +
                "balance=" + balance +
                "} " + super.toString();
    }
}
