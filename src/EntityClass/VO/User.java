package EntityClass.VO;

import EntityClass.DAO.impl.HistoryDataDAOImpl;
import EntityClass.DAO.impl.LiveSessionDAOImpl;
import EntityClass.DAO.impl.RecVideoDAOImpl;
import EntityClass.DAO.impl.UserDAOImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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

    public int exerciseTime(String timeType) throws ParseException {
        int time = 0;
        HistoryDataDAOImpl historyDataDAO = new HistoryDataDAOImpl();
        ArrayList<HistoryData> historyDatas = historyDataDAO.queryByUserName(getUserName());

        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        LiveSession liveSession;
        RecVideo recVideo;

        Date date1, date2;

        if(timeType.equals("day")) {
            calendar.add(Calendar.DATE,-1);
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
                if(date1.before(date2)) {
                    historyDatas.remove(historyData);
                }
            }
        }
        else if(timeType.equals("week")) {
            calendar.add(Calendar.DATE,-7);
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
                if(date1.before(date2)) {
                    historyDatas.remove(historyData);
                }
            }
        }
        else if(timeType.equals("month")) {
            calendar.add(Calendar.MONTH,-1);
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
                if(date1.before(date2)) {
                    historyDatas.remove(historyData);
                }
            }
        }
        else if(timeType.equals("year")) {
            calendar.add(Calendar.MONTH,-12);
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
                if(date1.before(date2)) {
                    historyDatas.remove(historyData);
                }
            }
        }
        time = exerciseTime(historyDatas);

        return time;
    }

    public int exerciseTime(ArrayList<HistoryData> historyDatas) {
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