package EntityClass.VO;

import EntityClass.DAO.impl.HistoryDataDAOImpl;
import EntityClass.DAO.impl.LiveSessionDAOImpl;
import EntityClass.DAO.impl.RecVideoDAOImpl;
import EntityClass.DAO.impl.UserDAOImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public int getExerciseTime(String timeType, String subject, String courseType) throws ParseException {
        int time = 0;
        HistoryDataDAOImpl historyDataDAO = new HistoryDataDAOImpl();
        ArrayList<HistoryData> historyDatas = historyDataDAO.queryByUserName(getUserName());
        ArrayList<HistoryData> historyDatas1 = new ArrayList<>();

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

            for(HistoryData historyData:historyDatas) {
                if(historyData.getType().equals("live")) {
                    liveSession = liveSessionDAO.queryByCourseId(historyData.getCourseId());
                    date1 = liveSession.getStartTime();
                }
                else {
                    recVideo = recVideoDAO.queryByCourseId(historyData.getCourseId());
                    date1 = recVideo.getUploadedTime();
                }
                if(date1.after(date2)) {
                    historyDatas1.add(historyData);
                }
            }
            historyDatas.clear();
            for(HistoryData historyData:historyDatas1) {
                historyDatas.add(historyData);
            }
            historyDatas1.clear();
        }

        if(subject != null) {
            for(HistoryData historyData:historyDatas) {
                if (historyData.getType().equals("live")) {
                    liveSession = liveSessionDAO.queryByCourseId(historyData.getCourseId());
                    if (liveSession.getSubject().equals(subject)) {
                        historyDatas1.add(historyData);
                    }
                } else {
                    recVideo = recVideoDAO.queryByCourseId(historyData.getCourseId());
                    if (recVideo.getSubject().equals(subject)) {
                        historyDatas1.add(historyData);
                    }
                }
            }
            historyDatas.clear();
            for(HistoryData historyData:historyDatas1) {
                historyDatas.add(historyData);
            }
            historyDatas1.clear();
        }

        if(courseType != null) {
            if(courseType.equals("live")) {
                for(HistoryData historyData:historyDatas) {
                    if(historyData.getType().equals("live")) {
                        historyDatas1.add(historyData);
                    }
                }
            }
            else {
                for(HistoryData historyData:historyDatas) {
                    if(historyData.getType().equals("recorded")) {
                        historyDatas1.add(historyData);
                    }
                }
            }
            historyDatas.clear();
            for(HistoryData historyData:historyDatas1) {
                historyDatas.add(historyData);
            }
            historyDatas1.clear();
        }

        time = calExerciseTime(historyDatas);

        return time;
    }

    // helper function
    public int calExerciseTime(ArrayList<HistoryData> historyDatas) {
        int time = 0;
        LiveSession liveSession;
        RecVideo recVideo;
        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();

        for(HistoryData historyData:historyDatas) {
            if(historyData.getType().equals("live")) {
                liveSession = liveSessionDAO.queryByCourseId(historyData.getCourseId());
                time += liveSession.getLength();
            }
            else {
                recVideo = recVideoDAO.queryByCourseId(historyData.getCourseId());
                time += recVideo.getLength();
            }
        }
        return time;
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