package ControlClass;
import EntityClass.DAO.LiveSessionDAO;
import EntityClass.DAO.impl.*;
import EntityClass.VO.WatchedVideo;
import EntityClass.VO.LiveSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class userInfoController {

    @FXML
    private ImageView userInfo_info;

    @FXML
    private Hyperlink user_logout_hyper;

    @FXML
    private Label birthday;

    @FXML
    private Hyperlink userInfo_live;

    @FXML
    private Label gender;

    @FXML
    private Label level;

    @FXML
    private Label totalTime;

    @FXML
    private Label weight;

    @FXML
    private Hyperlink userInfo_history;

    @FXML
    private Hyperlink userInfo_calendar;

    @FXML
    private Label balance;

    @FXML
    private Hyperlink userInfo_favorates;

    @FXML
    private Hyperlink userInfo_recording;

    @FXML
    private Label name;

    @FXML
    private Label email;

    @FXML
    private Hyperlink userInfo_modify;

    @FXML
    private Label height;

    @FXML
    private Label bmi;

    


    @FXML
    void initialize() throws ParseException {
        String username = passValue.getValue();
        UserDAOImpl userDAO = new UserDAOImpl();
        PhyDataDAOImpl phyDataDAO = new PhyDataDAOImpl();
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
        LiveSessionDAO liveSessionDAO = new LiveSessionDAOImpl();
        PreUserDAOImpl preUserDAO = new PreUserDAOImpl();
        name.setText(username);
        gender.setText(userDAO.queryByUserName(username).getGender());
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
        String date = formatter.format(userDAO.queryByUserName(username).getDoB());
        birthday.setText(date);
        email.setText(userDAO.queryByUserName(username).getEmail());
        if(preUserDAO.queryByUserName(username)==null){
            level.setText(" Not a member!");
        }else{
            level.setText(Integer.toString(preUserDAO.queryByUserName(username).getUserType()));
        }
        balance.setText(Double.toString(userDAO.queryByUserName(username).getBalance()));
        weight.setText(Double.toString(phyDataDAO.queryByUserName(username).getWeight())+" kg");
        height.setText(Double.toString(phyDataDAO.queryByUserName(username).getHeight())+" cm");
        double result=(10000*phyDataDAO.queryByUserName(username).getWeight())/(phyDataDAO.queryByUserName(username).getHeight()*phyDataDAO.queryByUserName(username).getHeight());
        int middlevalue = (int)(result*100);
        double newresult=middlevalue/100.0;
        bmi.setText(Double.toString(newresult));
        ArrayList<LiveSession> liveSessions = liveSessionDAO.queryByUserName(username);
        int time1 = 0;
        int time2 = 0;
        if(liveSessions.isEmpty()) {
            time1=0;
        }
        else{
            for(LiveSession liveSession1:liveSessions) {
                time1=time1+liveSession1.getLength();
            }
        }

        WatchedVideoDAOImpl historyDataDAO = new WatchedVideoDAOImpl();
        ArrayList<WatchedVideo> HISTORY = historyDataDAO.queryByUserName(username);
        time2 = userDAO.queryByUserName(username).getExerciseTime(null,null,null);
        totalTime.setText(Integer.toString(time1+time2)+" min");

    }

    public void userInfo_live_click(javafx.event.ActionEvent actionEvent) {
    }

    public void userInfo_favorates_click(ActionEvent actionEvent) {
    }

    public void userInfo_modify_click(ActionEvent actionEvent) {
    }

    public void userInfo_recording_click(ActionEvent actionEvent) {
    }

    public void userInfo_calendar_click(ActionEvent actionEvent) {
    }

    public void userInfo_history_click(ActionEvent actionEvent) {
    }

    public void userInfo_info_click(MouseEvent mouseEvent) {
    }

    public void userinfo_vip_click(ActionEvent actionEvent) {
    }
}

