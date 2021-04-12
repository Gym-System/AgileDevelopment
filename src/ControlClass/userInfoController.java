package ControlClass;
import EntityClass.DAO.LiveSessionDAO;
import EntityClass.DAO.UserDAO;
import EntityClass.DAO.impl.*;
import EntityClass.VO.LiveSession;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class userInfoController {

    @FXML
    private Label birthday;

    @FXML
    private Label gender;

    @FXML
    private Label city;

    @FXML
    private Label level;

    @FXML
    private Label totalTime;

    @FXML
    private Label weight;

    @FXML
    private Label balance;

    @FXML
    private Label name;

    @FXML
    private Label ID;

    @FXML
    private Label email;

    @FXML
    private Label height;

    @FXML
    private Label bmi;

    @FXML
    private Label energy;

    @FXML
    void initialize() {
        String username = passValue.getValue();
        UserDAOImpl userDAO = new UserDAOImpl();
        PhyDataDAOImpl phyDataDAO = new PhyDataDAOImpl();
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
        LiveSessionDAO liveSessionDAO = new LiveSessionDAOImpl();
        PreUserDAOImpl preUserDAO = new PreUserDAOImpl();
        name.setText( userDAO.queryByUserName(username).getUserName());
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
        bmi.setText(Double.toString(result));
        ArrayList<LiveSession> liveSessions = liveSessionDAO.queryByUserName("aaa");
        int time1 = 0;
        System.out.println(liveSessions);
//        if(liveSessions.isEmpty()) {
//            totalTime.setText(String.valueOf(time1));
//        }
//        else{
//            for(LiveSession liveSession1:liveSessions) {
//                time1=time1+liveSession1.getLength();
//            }
//            totalTime.setText(String.valueOf(time1));
//        }



    }
}

