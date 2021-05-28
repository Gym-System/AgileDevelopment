package ControlClass;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import EntityClass.DAO.impl.TrainerDAOImpl;
import EntityClass.DAO.impl.UserDAOImpl;
import EntityClass.VO.LiveSession;
import EntityClass.VO.Trainer;
import EntityClass.VO.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class trainerCalendarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label status18;

    @FXML
    private Button book33;

    @FXML
    private Button book39;

    @FXML
    private Label status210;

    @FXML
    private Button book37;

    @FXML
    private Label status010;

    @FXML
    private Label status10;

    @FXML
    private Label status12;

    @FXML
    private Label status56;

    @FXML
    private Button book31;

    @FXML
    private Label status58;

    @FXML
    private Label status16;

    @FXML
    private Button book411;

    @FXML
    private Button book211;

    @FXML
    private Label status50;

    @FXML
    private Label status52;

    @FXML
    private Button book611;

    @FXML
    private ImageView logo;

    @FXML
    private Button book011;

    @FXML
    private Button book01;

    @FXML
    private Label status28;

    @FXML
    private Button book43;

    @FXML
    private Hyperlink userInfo_live;

    @FXML
    private Button book49;

    @FXML
    private Button book03;

    @FXML
    private Button book47;

    @FXML
    private Label status20;

    @FXML
    private Label status22;

    @FXML
    private Label status66;

    @FXML
    private Button book41;

    @FXML
    private Label status68;

    @FXML
    private Hyperlink userInfo_history;

    @FXML
    private Label status26;

    @FXML
    private Label trainer_calendar_1;

    @FXML
    private Label trainer_calendar_2;

    @FXML
    private Label trainer_calendar_3;

    @FXML
    private Label trainer_calendar_4;

    @FXML
    private Label status60;

    @FXML
    private Label trainer_calendar_5;

    @FXML
    private Hyperlink userInfo_favorates;

    @FXML
    private Label trainer_calendar_6;

    @FXML
    private Label status62;

    @FXML
    private Label status610;

    @FXML
    private Button book09;

    @FXML
    private Button book07;

    @FXML
    private Label status410;

    @FXML
    private Label trainer_price;

    @FXML
    private Button book13;

    @FXML
    private Button book57;

    @FXML
    private Button book11;

    @FXML
    private Button book17;

    @FXML
    private Label status110;

    @FXML
    private Button book59;

    @FXML
    private Label trainer_calendar_7;

    @FXML
    private Label status32;

    @FXML
    private Button book53;

    @FXML
    private Label status36;

    @FXML
    private Label status38;

    @FXML
    private Button book51;

    @FXML
    private Label trainer_calendar_time21;

    @FXML
    private Hyperlink userInfo_calendar;

    @FXML
    private Button book311;

    @FXML
    private Button book111;

    @FXML
    private Button book511;

    @FXML
    private Label status30;

    @FXML
    private Hyperlink user_logout_hyper;

    @FXML
    private Button book19;

    @FXML
    private ImageView userInfo_info;

    @FXML
    private Button book23;

    @FXML
    private Button book67;

    @FXML
    private Label status06;

    @FXML
    private Label status08;

    @FXML
    private Button book21;

    @FXML
    private Label trainer_calendar_time1;

    @FXML
    private Button book27;

    @FXML
    private Label trainer_calendar_time2;

    @FXML
    private Label trainer_calendar_time3;

    @FXML
    private Button book69;

    @FXML
    private Label status42;

    @FXML
    private Label status00;

    @FXML
    private Label status46;

    @FXML
    private Label status02;

    @FXML
    private Button book63;

    @FXML
    private Button book61;

    @FXML
    private Label status48;

    @FXML
    private Label status40;

    @FXML
    private Hyperlink userInfo_recording;

    @FXML
    private Label trainer_calendar_time4;

    @FXML
    private Label status510;

    @FXML
    private Label trainer_calendar_time5;

    @FXML
    private Label trainer_calendar_time6;

    @FXML
    private Label status310;

    @FXML
    private Label trainer_calendar_time7;

    @FXML
    private Button book29;

    @FXML
    void userInfo_favorates_click(ActionEvent event) {

    }

    @FXML
    void userInfo_recording_click(ActionEvent event) {

    }

    @FXML
    void userInfo_live_click(ActionEvent event) {

    }

    @FXML
    void userInfo_calendar_click(ActionEvent event) {

    }

    @FXML
    void userInfo_history_click(ActionEvent event) {

    }

    @FXML
    void userInfo_info_click(ActionEvent event) {

    }

    @FXML
    void user_logout_click(ActionEvent event) {

    }

    @FXML
    void click_book01(MouseEvent event) throws ParseException {
        status00.setText("Not Available");
        status00.setTextFill(Color.RED);
        status00.setFont(Font.font("Comic Sans MS"));
        book01.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 1 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 08:00:00:000";
        Date bookDate = df2.parse(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);

    }

    @FXML
    void click_book09(MouseEvent event) throws ParseException {
        status08.setText("Not Available");
        status08.setTextFill(Color.RED);
        status08.setFont(Font.font("Comic Sans MS"));
        book09.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 1 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 16:00:00:000";
        Date bookDate = df2.parse(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book23(MouseEvent event) throws ParseException {
        status22.setText("Not Available");
        status22.setTextFill(Color.RED);
        status22.setFont(Font.font("Comic Sans MS"));
        book23.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 3 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 10:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }


    @FXML
    void click_book13(MouseEvent event) throws ParseException {
        status12.setText("Not Available");
        status12.setTextFill(Color.RED);
        status12.setFont(Font.font("Comic Sans MS"));
        book13.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 2 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 10:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book53(MouseEvent event) throws ParseException {
        status52.setText("Not Available");
        status52.setTextFill(Color.RED);
        status52.setFont(Font.font("Comic Sans MS"));
        book53.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 6 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 10:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book69(MouseEvent event) throws ParseException {
        status68.setText("Not Available");
        status68.setTextFill(Color.RED);
        status68.setFont(Font.font("Comic Sans MS"));
        book69.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 7 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 16:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book67(MouseEvent event) throws ParseException {
        status66.setText("Not Available");
        status66.setTextFill(Color.RED);
        status66.setFont(Font.font("Comic Sans MS"));
        book67.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 7 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 14:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book33(MouseEvent event) throws ParseException {
        status32.setText("Not Available");
        status32.setTextFill(Color.RED);
        status32.setFont(Font.font("Comic Sans MS"));
        book33.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 4 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 10:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);

    }

    @FXML
    void click_book39(MouseEvent event) throws ParseException {
        status38.setText("Not Available");
        status38.setTextFill(Color.RED);
        status38.setFont(Font.font("Comic Sans MS"));
        book39.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 4 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 16:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book03(MouseEvent event) throws ParseException {
        status02.setText("Not Available");
        status02.setTextFill(Color.RED);
        status02.setFont(Font.font("Comic Sans MS"));
        book03.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 1 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 10:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book07(MouseEvent event) throws ParseException {
        status06.setText("Not Available");
        status06.setTextFill(Color.RED);
        status06.setFont(Font.font("Comic Sans MS"));
        book07.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 1 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 14:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book011(MouseEvent event) throws ParseException {
        status010.setText("Not Available");
        status010.setTextFill(Color.RED);
        status010.setFont(Font.font("Comic Sans MS"));
        book011.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 1 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 18:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book11(MouseEvent event) throws ParseException {
        status10.setText("Not Available");
        status10.setTextFill(Color.RED);
        status10.setFont(Font.font("Comic Sans MS"));
        book11.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 2 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 08:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }


    @FXML
    void click_book17(MouseEvent event) throws ParseException {
        status16.setText("Not Available");
        status16.setTextFill(Color.RED);
        status16.setFont(Font.font("Comic Sans MS"));
        book17.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 2 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 14:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book111(MouseEvent event) throws ParseException {
        status110.setText("Not Available");
        status110.setTextFill(Color.RED);
        status110.setFont(Font.font("Comic Sans MS"));
        book111.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 2 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 18:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book19(MouseEvent event) throws ParseException {
        status18.setText("Not Available");
        status18.setTextFill(Color.RED);
        status18.setFont(Font.font("Comic Sans MS"));
        book19.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 2 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 16:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book21(MouseEvent event) throws ParseException {
        status20.setText("Not Available");
        status20.setTextFill(Color.RED);
        status20.setFont(Font.font("Comic Sans MS"));
        book21.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 3 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 08:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book211(MouseEvent event) throws ParseException {
        status210.setText("Not Available");
        status210.setTextFill(Color.RED);
        status210.setFont(Font.font("Comic Sans MS"));
        book211.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 3 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 18:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book27(MouseEvent event) throws ParseException {
        status26.setText("Not Available");
        status26.setTextFill(Color.RED);
        status26.setFont(Font.font("Comic Sans MS"));
        book27.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 3 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 14:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book29(MouseEvent event) throws ParseException {
        status28.setText("Not Available");
        status28.setTextFill(Color.RED);
        status28.setFont(Font.font("Comic Sans MS"));
        book29.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 3 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 16:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book31(MouseEvent event) throws ParseException {
        status30.setText("Not Available");
        status30.setTextFill(Color.RED);
        status30.setFont(Font.font("Comic Sans MS"));
        book31.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 4 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 08:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book311(MouseEvent event) throws ParseException {
        status310.setText("Not Available");
        status310.setTextFill(Color.RED);
        status310.setFont(Font.font("Comic Sans MS"));
        book311.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 4 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 18:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book41(MouseEvent event) throws ParseException {
        status40.setText("Not Available");
        status40.setTextFill(Color.RED);
        status40.setFont(Font.font("Comic Sans MS"));
        book41.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 5 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 08:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book43(MouseEvent event) throws ParseException {
        status42.setText("Not Available");
        status42.setTextFill(Color.RED);
        status42.setFont(Font.font("Comic Sans MS"));
        book43.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 5 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 10:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book49(MouseEvent event) throws ParseException {
        status48.setText("Not Available");
        status48.setTextFill(Color.RED);
        status48.setFont(Font.font("Comic Sans MS"));
        book49.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 5 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 16:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book63(MouseEvent event) throws ParseException {
        status62.setText("Not Available");
        status62.setTextFill(Color.RED);
        status62.setFont(Font.font("Comic Sans MS"));
        book63.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 7 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 10:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book37(MouseEvent event) throws ParseException {
        status36.setText("Not Available");
        status36.setTextFill(Color.RED);
        status36.setFont(Font.font("Comic Sans MS"));
        book37.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 4 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 14:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book47(MouseEvent event) throws ParseException {
        status46.setText("Not Available");
        status46.setTextFill(Color.RED);
        status46.setFont(Font.font("Comic Sans MS"));
        book47.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 5 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 14:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book411(MouseEvent event) throws ParseException {
        status410.setText("Not Available");
        status410.setTextFill(Color.RED);
        status410.setFont(Font.font("Comic Sans MS"));
        book411.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 5 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 18:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book57(MouseEvent event) throws ParseException {
        status56.setText("Not Available");
        status56.setTextFill(Color.RED);
        status56.setFont(Font.font("Comic Sans MS"));
        book57.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 6 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 14:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book59(MouseEvent event) throws ParseException {
        status58.setText("Not Available");
        status58.setTextFill(Color.RED);
        status58.setFont(Font.font("Comic Sans MS"));
        book59.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 6 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 16:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book511(MouseEvent event) throws ParseException {
        status510.setText("Not Available");
        status510.setTextFill(Color.RED);
        status510.setFont(Font.font("Comic Sans MS"));
        book511.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 6 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 18:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book61(MouseEvent event) throws ParseException {
        status60.setText("Not Available");
        status60.setTextFill(Color.RED);
        status60.setFont(Font.font("Comic Sans MS"));
        book61.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 7 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 08:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book51(MouseEvent event) throws ParseException {
        status50.setText("Not Available");
        status50.setTextFill(Color.RED);
        status50.setFont(Font.font("Comic Sans MS"));
        book51.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 6 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 08:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }

    @FXML
    void click_book611(MouseEvent event) throws ParseException {
        status610.setText("Not Available");
        status610.setTextFill(Color.RED);
        status610.setFont(Font.font("Comic Sans MS"));
        book611.setVisible(false);
        UserDAOImpl UserDAO = new UserDAOImpl();
        Date date = new Date();
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        String day = df1.format(new Date(date.getTime() + 7 * 24 * 60 * 60 * 1000));
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = day + " 18:00:00:000";
        Date bookDate = df2.parse(time);
        System.out.println(time);
        UserDAO.queryByUserName(passValue.getValue()).bookLiveSession("kaiyi", bookDate);
    }


    @FXML
    void initialize() throws ParseException {
        assert status18 != null : "fx:id=\"status18\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book33 != null : "fx:id=\"book33\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book39 != null : "fx:id=\"book39\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status210 != null : "fx:id=\"status210\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book37 != null : "fx:id=\"book37\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status010 != null : "fx:id=\"status010\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status10 != null : "fx:id=\"status10\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status12 != null : "fx:id=\"status12\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status56 != null : "fx:id=\"status56\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book31 != null : "fx:id=\"book31\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status58 != null : "fx:id=\"status58\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status16 != null : "fx:id=\"status16\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book411 != null : "fx:id=\"book411\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book211 != null : "fx:id=\"book211\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status50 != null : "fx:id=\"status50\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status52 != null : "fx:id=\"status52\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book611 != null : "fx:id=\"book611\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book011 != null : "fx:id=\"book011\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book01 != null : "fx:id=\"book01\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status28 != null : "fx:id=\"status28\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book43 != null : "fx:id=\"book43\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert userInfo_live != null : "fx:id=\"userInfo_live\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book49 != null : "fx:id=\"book49\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book03 != null : "fx:id=\"book03\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book47 != null : "fx:id=\"book47\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status20 != null : "fx:id=\"status20\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status22 != null : "fx:id=\"status22\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status66 != null : "fx:id=\"status66\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book41 != null : "fx:id=\"book41\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status68 != null : "fx:id=\"status68\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert userInfo_history != null : "fx:id=\"userInfo_history\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status26 != null : "fx:id=\"status26\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_1 != null : "fx:id=\"trainer_calendar_1\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_2 != null : "fx:id=\"trainer_calendar_2\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_3 != null : "fx:id=\"trainer_calendar_3\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_4 != null : "fx:id=\"trainer_calendar_4\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status60 != null : "fx:id=\"status60\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_5 != null : "fx:id=\"trainer_calendar_5\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert userInfo_favorates != null : "fx:id=\"userInfo_favorates\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_6 != null : "fx:id=\"trainer_calendar_6\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status62 != null : "fx:id=\"status62\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status610 != null : "fx:id=\"status610\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book09 != null : "fx:id=\"book09\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book07 != null : "fx:id=\"book07\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status410 != null : "fx:id=\"status410\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_price != null : "fx:id=\"trainer_price\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book13 != null : "fx:id=\"book13\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book57 != null : "fx:id=\"book57\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book11 != null : "fx:id=\"book11\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book17 != null : "fx:id=\"book17\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status110 != null : "fx:id=\"status110\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book59 != null : "fx:id=\"book59\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_7 != null : "fx:id=\"trainer_calendar_7\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status32 != null : "fx:id=\"status32\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book53 != null : "fx:id=\"book53\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status36 != null : "fx:id=\"status36\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status38 != null : "fx:id=\"status38\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book51 != null : "fx:id=\"book51\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_time21 != null : "fx:id=\"trainer_calendar_time21\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert userInfo_calendar != null : "fx:id=\"userInfo_calendar\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book311 != null : "fx:id=\"book311\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book111 != null : "fx:id=\"book111\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book511 != null : "fx:id=\"book511\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status30 != null : "fx:id=\"status30\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert user_logout_hyper != null : "fx:id=\"user_logout_hyper\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book19 != null : "fx:id=\"book19\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert userInfo_info != null : "fx:id=\"userInfo_info\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book23 != null : "fx:id=\"book23\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book67 != null : "fx:id=\"book67\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status06 != null : "fx:id=\"status06\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status08 != null : "fx:id=\"status08\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book21 != null : "fx:id=\"book21\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_time1 != null : "fx:id=\"trainer_calendar_time1\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book27 != null : "fx:id=\"book27\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_time2 != null : "fx:id=\"trainer_calendar_time2\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_time3 != null : "fx:id=\"trainer_calendar_time3\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book69 != null : "fx:id=\"book69\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status42 != null : "fx:id=\"status42\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status00 != null : "fx:id=\"status00\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status46 != null : "fx:id=\"status46\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status02 != null : "fx:id=\"status02\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book63 != null : "fx:id=\"book63\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book61 != null : "fx:id=\"book61\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status48 != null : "fx:id=\"status48\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status40 != null : "fx:id=\"status40\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert userInfo_recording != null : "fx:id=\"userInfo_recording\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_time4 != null : "fx:id=\"trainer_calendar_time4\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status510 != null : "fx:id=\"status510\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_time5 != null : "fx:id=\"trainer_calendar_time5\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_time6 != null : "fx:id=\"trainer_calendar_time6\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert status310 != null : "fx:id=\"status310\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert trainer_calendar_time7 != null : "fx:id=\"trainer_calendar_time7\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        assert book29 != null : "fx:id=\"book29\" was not injected: check your FXML file 'trainer_calendar.fxml'.";
        Label[] status = new Label[35];
        Button[] book = new Button[35];
        status[0]=status00;
        status[1]=status10;
        status[2]=status20;
        status[3]=status30;
        status[4]=status40;
        status[5]=status50;
        status[6]=status60;
        status[7]=status02;
        status[8]=status12;
        status[9]=status22;
        status[10]=status32;
        status[11]=status42;
        status[12]=status52;
        status[13]=status62;
        status[14]=status06;
        status[15]=status16;
        status[16]=status26;
        status[17]=status36;
        status[18]=status46;
        status[19]=status56;
        status[20]=status66;
        status[21]=status08;
        status[22]=status18;
        status[23]=status28;
        status[24]=status38;
        status[25]=status48;
        status[26]=status58;
        status[27]=status68;
        status[28]=status010;
        status[29]=status110;
        status[30]=status210;
        status[31]=status310;
        status[32]=status410;
        status[33]=status510;
        status[34]=status610;
        book[0]=book01;
        book[1]=book11;
        book[2]=book21;
        book[3]=book31;
        book[4]=book41;
        book[5]=book51;
        book[6]=book61;
        book[7]=book03;
        book[8]=book13;
        book[9]=book23;
        book[10]=book33;
        book[11]=book43;
        book[12]=book53;
        book[13]=book63;
        book[14]=book07;
        book[15]=book17;
        book[16]=book27;
        book[17]=book37;
        book[18]=book47;
        book[19]=book57;
        book[20]=book67;
        book[21]=book09;
        book[22]=book19;
        book[23]=book29;
        book[24]=book39;
        book[25]=book49;
        book[26]=book59;
        book[27]=book69;
        book[28]=book011;
        book[29]=book111;
        book[30]=book211;
        book[31]=book311;
        book[32]=book411;
        book[33]=book511;
        book[34]=book611;
        Date d = new Date();
        Date date1 = new Date(d.getTime() + 1 * 24 * 60 * 60 * 1000);
        Date date2 = new Date(d.getTime() + 2 * 24 * 60 * 60 * 1000);
        Date date3 = new Date(d.getTime() + 3 * 24 * 60 * 60 * 1000);
        Date date4 = new Date(d.getTime() + 4 * 24 * 60 * 60 * 1000);
        Date date5 = new Date(d.getTime() + 5 * 24 * 60 * 60 * 1000);
        Date date6 = new Date(d.getTime() + 6 * 24 * 60 * 60 * 1000);
        Date date7 = new Date(d.getTime() + 7 * 24 * 60 * 60 * 1000);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        trainer_calendar_1.setText(df.format(date1));
        trainer_calendar_2.setText(df.format(date2));
        trainer_calendar_3.setText(df.format(date3));
        trainer_calendar_4.setText(df.format(date4));
        trainer_calendar_5.setText(df.format(date5));
        trainer_calendar_6.setText(df.format(date6));
        trainer_calendar_7.setText(df.format(date7));
        Trainer trainer;
        TrainerDAOImpl TrainerDAO = new TrainerDAOImpl();
        trainer = TrainerDAO.queryByUserName(passValue.getValue());
        trainer_calendar_time21.setText(trainer.getUserName()+"'s Time Table");
        ArrayList<LiveSession> recent = new ArrayList<LiveSession>();
        recent = trainer.showCalender();
        for (LiveSession liveSession : recent) {
            long courseid = liveSession.getCourseId();
            System.out.println(liveSession.getStartTime());
            int i = 0;
            if (liveSession.getStartTime().getHours() == 8) {
                i = 0;
            } else if (liveSession.getStartTime().getHours() == 10) {
                i = 1;
            } else if (liveSession.getStartTime().getHours() == 12) {
                i = 2;
            } else if (liveSession.getStartTime().getHours() == 14) {
                i = 3;
            } else if (liveSession.getStartTime().getHours() == 16) {
                i = 4;
            } else if (liveSession.getStartTime().getHours() == 18) {
                i = 5;
            }

            int j = 0;
            if (liveSession.getStartTime().getDay() == date1.getDay()) {
                j = 1;
            }
            if (liveSession.getStartTime().getDay() == date2.getDay()) {
                j = 2;
            }
            if (liveSession.getStartTime().getDay() == date3.getDay()) {
                j = 3;
            }
            if (liveSession.getStartTime().getDay() == date4.getDay()) {
                j = 4;
            }
            if (liveSession.getStartTime().getDay() == date5.getDay()) {
                j = 5;
            }
            if (liveSession.getStartTime().getDay() == date6.getDay()) {
                j = 6;
            }
            if (liveSession.getStartTime().getDay() == date7.getDay()) {
                j = 7;
            }
            int count = 7*i+j-1;
            status[count].setText("Not Available");
            status[count].setTextFill(Color.RED);
            status[count].setFont(Font.font("Comic Sans MS"));
            book[count].setVisible(false);

        }
    }
}
