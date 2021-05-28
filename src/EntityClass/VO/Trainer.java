package EntityClass.VO;

import EntityClass.DAO.impl.LiveSessionDAOImpl;
import EntityClass.DAO.impl.RecVideoDAOImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Trainer extends Staff {
    private double salary = 0.0;
    private String label = "To be added";
    private String CV = "To be added";

    public Trainer(String userName, String password, String email) {
        super(userName, password, email);
    }

    public Trainer(String userName, String password, String email, String gender, String telNo, Date doB, String companyName) {
        super(userName, password, email, gender, telNo, doB, companyName);
    }

    public Trainer(String userName, String password, String email, String gender, String telNo, Date doB, String companyName, double salary, String label, String CV) {
        super(userName, password, email, gender, telNo, doB, companyName);
        this.salary = salary;
        this.label = label;
        this.CV = CV;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String[] getLabel() {
        return label.split(";");
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public String getCVStrArray() {
        return CV;
    }

    public ArrayList<LiveSession> showCalender() throws ParseException {
        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        ArrayList<LiveSession> liveSessions = liveSessionDAO.queryByTrainerName(getUserName());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 1);
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

    public int getRecTime() throws ParseException {
        int recTime = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date now = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(
                new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).format(calendar.getTime()));
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
        ArrayList<RecVideo> recVideos = recVideoDAO.queryByTrainerName(getUserName());
        for(RecVideo recVideo:recVideos) {
            if(now.getYear() == recVideo.getUploadedTime().getYear() && now.getMonth() == recVideo.getUploadedTime().getMonth()) {
                recTime += recVideo.getLength();
            }
        }

        return recTime;
    }

    public int getLiveTime() throws ParseException {
        int liveTime = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date now = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(
                new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).format(calendar.getTime()));
        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        ArrayList<LiveSession> liveSessions = liveSessionDAO.queryByTrainerName(getUserName());
        for(LiveSession liveSession:liveSessions) {
            if(now.getYear() == liveSession.getStartTime().getYear() && now.getMonth() == liveSession.getStartTime().getMonth()) {
                liveTime += liveSession.getLength();
            }
        }

        return liveTime;
    }

    public int getGift() throws ParseException {
        int gift = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date now = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(
                new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).format(calendar.getTime()));
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
        ArrayList<RecVideo> recVideos = recVideoDAO.queryByTrainerName(getUserName());
        for(RecVideo recVideo:recVideos) {
            if(now.getYear() == recVideo.getUploadedTime().getYear() && now.getMonth() == recVideo.getUploadedTime().getMonth()) {
                gift += recVideo.getGift();
            }
        }

        calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        now = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).parse(
                new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK).format(calendar.getTime()));
        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        ArrayList<LiveSession> liveSessions = liveSessionDAO.queryByTrainerName(getUserName());
        for(LiveSession liveSession:liveSessions) {
            if(now.getYear() == liveSession.getStartTime().getYear() && now.getMonth() == liveSession.getStartTime().getMonth()) {
                gift += liveSession.getGift();
            }
        }

        return gift;
    }

    @Override
    public String[] toStrArray() {
        String text = "" + super.getUserName() + "," + super.getPassword() + "," + super.getEmail() + "," + super.getGender() + "," +
                super.getTelNo() + "," + super.getDoB() + "," + super.getCompanyName() + "," + salary + "," + label + "," + CV;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "salary=" + salary +
                ", label='" + label + '\'' +
                ", CV='" + CV + '\'' +
                "} " + super.toString();
    }
}
