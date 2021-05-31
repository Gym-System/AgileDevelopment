package ControlClass;
import EntityClass.DAO.LiveSessionDAO;
import EntityClass.DAO.impl.*;
import EntityClass.VO.PhyData;
import EntityClass.VO.WatchedVideo;
import EntityClass.VO.LiveSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;

public class userInfoController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField user_info_recharge_money;

    @FXML
    private URL location;

    @FXML
    private Label birthday;

    @FXML
    private Label user_info_myOrder_type1;

    @FXML
    private Label user_info_myOrder_type3;

    @FXML
    private Label user_info_myOrder_type2;

    @FXML
    private Label gender;

    @FXML
    private Label user_info_myOrder_trainer2;

    @FXML
    private Label user_info_myOrder_trainer1;

    @FXML
    private Label user_info_myOrder_live3;

    @FXML
    private Label user_info_myOrder_trainer4;

    @FXML
    private Label user_info_myOrder_live2;

    @FXML
    private Label user_info_myOrder_trainer3;

    @FXML
    private Label user_info_myOrder_live4;

    @FXML
    private Label user_info_myOrder_live1;

    @FXML
    private Hyperlink userInfo_calendar;

    @FXML
    private Label balance;

    @FXML
    private Hyperlink user_logout_hyper;

    @FXML
    private Hyperlink userinfo_vip;

    @FXML
    private Label email;

    @FXML
    private TextField height;

    @FXML
    private ImageView userInfo_info;

    @FXML
    private Hyperlink userInfo_live;

    @FXML
    private Label level;

    @FXML
    private Label totalTime;

    @FXML
    private TextField weight;

    @FXML
    private Hyperlink userInfo_history;

    @FXML
    private Hyperlink userInfo_favorates;

    @FXML
    private Hyperlink userInfo_recording;

    @FXML
    private Label name;

    @FXML
    private Label user_info_myOrder_price1;

    @FXML
    private Label user_info_myOrder_price2;

    @FXML
    private Label user_info_myOrder_time3;

    @FXML
    private Label user_info_myOrder_time4;

    @FXML
    private Label user_info_myOrder_time1;

    @FXML
    private Label user_info_myOrder_time2;

    @FXML
    private Label user_info_myOrder_type4;

    @FXML
    private Hyperlink userInfo_modify;

    @FXML
    private Label user_info_myOrder_price3;

    @FXML
    private Label bmi;

    @FXML
    private Label user_info_myOrder_price4;





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
        if(preUserDAO.queryByUserName(username)!=null){
            balance.setText(Double.toString(preUserDAO.queryByUserName(username).getBalance()));
        }else{
            balance.setText("0.00");
        }
        if(phyDataDAO.queryByUserName(username)==null){
            weight.setText(null);
        }else{
            weight.setText(Double.toString(phyDataDAO.queryByUserName(username).getWeight()));
        }

        if(phyDataDAO.queryByUserName(username)==null){
            height.setText(null);
        }else{
            height.setText(Double.toString(phyDataDAO.queryByUserName(username).getHeight()));
        }
        if(phyDataDAO.queryByUserName(username)==null||phyDataDAO.queryByUserName(username)==null)
        {
            bmi.setText(null);
        }else{
            double result=(10000*phyDataDAO.queryByUserName(username).getWeight())/(phyDataDAO.queryByUserName(username).getHeight()*phyDataDAO.queryByUserName(username).getHeight());
            int middlevalue = (int)(result*100);
            double newresult=middlevalue/100.0;
            bmi.setText(Double.toString(newresult));
        }
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

    public void userInfo_live_click(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) level.getScene().getWindow();
        new APP().jump(stage, "user_live");
    }

    public void userInfo_favorates_click(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) level.getScene().getWindow();
        new APP().jump(stage, "user_favorites");
    }

    public void userInfo_modify_click(ActionEvent actionEvent) throws IOException {
        PhyDataDAOImpl phyDataDAO = new PhyDataDAOImpl();
        PhyData phyData = new PhyData(passValue.getValue(),Double.parseDouble(height.getText()),Double.parseDouble(weight.getText()),0,null,0);
        phyDataDAO.insertPhyData(phyData);
        JOptionPane.showInternalMessageDialog(null, "Change successfully","Change successfully", JOptionPane.INFORMATION_MESSAGE);
        Stage stage = (Stage) level.getScene().getWindow();
        new APP().jump(stage, "UserInfo");
    }

    public void userInfo_recording_click(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) level.getScene().getWindow();
        new APP().jump(stage, "user_recording");
    }

    public void userInfo_calendar_click(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) level.getScene().getWindow();
        new APP().jump(stage, "user_calendar");
    }

    public void userInfo_history_click(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) level.getScene().getWindow();
        new APP().jump(stage, "user_history");
    }

    public void userInfo_info_click(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) level.getScene().getWindow();
        new APP().jump(stage, "userInfo");
    }


    public void user_logout_click(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) level.getScene().getWindow();
        new APP().jump(stage, "login");
    }

    @FXML
    void userInfo_info_click(ActionEvent event) {

    }

    @FXML
    void user_logout_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) level.getScene().getWindow();
        new APP().jump(stage, "login");
    }

    @FXML
    void user_info_recharge_money_click(ActionEvent event) {

    }

    @FXML
    void user_info_recharge_ok_click(ActionEvent event) {
        UserDAOImpl userDAO = new UserDAOImpl();
        PreUserDAOImpl preUserDAO = new PreUserDAOImpl();
        try{
            Double money=Double.parseDouble(user_info_recharge_money.getText());
        }catch (Exception e){
            JOptionPane.showInternalMessageDialog(null, "Please check the input!","Please check the input", JOptionPane.ERROR_MESSAGE);
        }
        if (preUserDAO.queryByUserName(passValue.getValue())==null){
            System.out.println("ififififif"+user_info_recharge_money.getText());
            userDAO.queryByUserName(passValue.getValue()).recharge(Double.parseDouble(user_info_recharge_money.getText()));
            JOptionPane.showInternalMessageDialog(null, "Recharge successfully","Recharge successfully", JOptionPane.INFORMATION_MESSAGE);
        }else{
            System.out.println("elseelseelse"+user_info_recharge_money.getText());
            preUserDAO.queryByUserName(passValue.getValue()).recharge(Double.parseDouble(user_info_recharge_money.getText()));
            JOptionPane.showInternalMessageDialog(null, "Recharge successfully","Recharge successfully", JOptionPane.INFORMATION_MESSAGE);
        }

    }


}

