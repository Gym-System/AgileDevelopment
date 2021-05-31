package EntityClass.VO;

import EntityClass.DAO.impl.LiveSessionDAOImpl;
import EntityClass.DAO.impl.RecVideoDAOImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * javadoc of Trainer class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class Trainer extends Staff {
    private double salary = 0.0;
    private String label = "To be added";
    private String CV = "To be added";
    private double price = 300.0;

    /**
     * This constructor contains major params needed to make a instance of Trainer class.
     * @param userName The userName of a trainer
     * @param password The password of a trainer
     * @param email The email of a trainer
     */
    public Trainer(String userName, String password, String email) {
        super(userName, password, email);
    }

    /**
     * This constructor contains major params needed to make a instance of Trainer class.
     * @param userName The userName of a trainer
     * @param password The password of a trainer
     * @param email The email of a trainer
     * @param gender The gender of a trainer
     * @param telNo The telephone number of a trainer
     * @param doB The date of birth of a trainer
     * @param companyName Name of the company trainer is in
     */
    public Trainer(String userName, String password, String email, String gender, String telNo, Date doB, String companyName) {
        super(userName, password, email, gender, telNo, doB, companyName);
    }

    /**
     * This constructor contains all params needed to make a instance of Trainer class.
     * @param userName The userName of a trainer
     * @param password The password of a trainer
     * @param email The email of a trainer
     * @param gender The gender of a trainer
     * @param telNo The telephone number of a trainer
     * @param doB The date of birth of a trainer
     * @param companyName Name of the company trainer is in
     * @param salary The salary of a trainer
     * @param CV The cv of a trainer
     * @param price The price of a trainer's live session
     */
    public Trainer(String userName, String password, String email, String gender, String telNo, Date doB, String companyName, double salary, String CV, double price) {
        super(userName, password, email, gender, telNo, doB, companyName);
        this.salary = salary;
        this.CV = CV;
        this.price = price;
    }

    /**
     * This constructor contains all params needed to make a instance of Trainer class.
     * @param userName The userName of a trainer
     * @param password The password of a trainer
     * @param email The email of a trainer
     * @param gender The gender of a trainer
     * @param telNo The telephone number of a trainer
     * @param doB The date of birth of a trainer
     * @param companyName Name of the company trainer is in
     * @param salary The salary of a trainer
     * @param label The label of a trainer
     * @param CV The cv of a trainer
     * @param price The price of a trainer's live session
     */
    public Trainer(String userName, String password, String email, String gender, String telNo, Date doB, String companyName, double salary, String label, String CV, double price) {
        super(userName, password, email, gender, telNo, doB, companyName);
        this.salary = salary;
        this.label = label;
        this.CV = CV;
        this.price = price;
    }

    /**
     * The getter method of salary
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * The setter method of salary
     * @param salary The salary of a trainer
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * The getter method of label
     * @return label
     */
    public String[] getLabel() {
        return label.split(";");
    }

    /**
     * The setter method of label
     * @param label The label of a trainer
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * The getter method of CV
     * @return CV
     */
    public String getCV() {
        return CV;
    }

    /**
     * The setter method of CV
     * @param CV The CV of a trainer
     */
    public void setCV(String CV) {
        this.CV = CV;
    }

    /**
     * The getter method of price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * The setter method of price
     * @param price The price of a trainer's live session
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This method show trainer's calender
     * @return A array list of live sessions
     * @throws ParseException
     */
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

    /**
     * This method calculate total recorded time of a trainer
     * @return Total recorded time of a trainer
     * @throws ParseException
     */
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

    /**
     * This method calculate total live session time of a trainer
     * @return Total live session of a trainer
     * @throws ParseException
     */
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

    /**
     * This method calculate total gift a trainer get from lectures
     * @return total gift a trainer get from lectures
     * @throws ParseException
     */
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

    /**
     * This method organize instance variables of Trainer class into a string array
     * @return A string array contain instance variables of Trainer class
     */
    @Override
    public String[] toStrArray() {
        String text = "" + super.getUserName() + "," + super.getPassword() + "," + super.getEmail() + "," + super.getGender() + "," +
                super.getTelNo() + "," + super.getDoB() + "," + super.getCompanyName() + "," + salary + "," + label + "," + CV + "," + price;
        return text.split(",");
    }

    /**
     * This method organize instance variables of Trainer class into a readable way
     * @return A string contains instance variables of Trainer class
     */
    @Override
    public String toString() {
        return "Trainer{" +
                "salary=" + salary +
                ", label='" + label + '\'' +
                ", CV='" + CV + '\'' +
                ", price=" + price +
                "} " + super.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer)) return false;
        Trainer trainer = (Trainer) o;
        return Double.compare(trainer.getSalary(), getSalary()) == 0 &&
                Double.compare(trainer.getPrice(), getPrice()) == 0 &&
                Objects.equals(getLabel(), trainer.getLabel()) &&
                Objects.equals(getCV(), trainer.getCV());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSalary(), getLabel(), getCV(), getPrice());
    }
}