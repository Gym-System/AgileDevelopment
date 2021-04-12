package EntityClass.VO;

import EntityClass.DAO.impl.HistoryDataDAOImpl;

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

    public void watchRecVideo(String userName, long courseId) {
        String type = "recorded";
        HistoryData historyData = new HistoryData(userName, type, courseId);
        HistoryDataDAOImpl historyDataDAO = new HistoryDataDAOImpl();
        historyDataDAO.insertHistoryData(historyData);
    }

    public void joinLiveSession(String userName, long courseId) {
        String type = "live";
        HistoryData historyData = new HistoryData(userName, type, courseId);
        HistoryDataDAOImpl historyDataDAO = new HistoryDataDAOImpl();
        historyDataDAO.insertHistoryData(historyData);
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
