package ControlClass;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import EntityClass.DAO.impl.LiveSessionDAOImpl;
import EntityClass.DAO.impl.PreUserDAOImpl;
import EntityClass.DAO.impl.UserDAOImpl;
import EntityClass.VO.LiveSession;
import EntityClass.VO.PremierUser;
import EntityClass.VO.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class userCalendarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label user_calendar_7;

    @FXML
    private Rectangle rec57;

    @FXML
    private Hyperlink user_calendar_hyper;

    @FXML
    private Label trainer_calendar_time41;

    @FXML
    private Label user_calendar_6;

    @FXML
    private Hyperlink user_favorites_hyper;

    @FXML
    private Hyperlink user_logout_hyper;

    @FXML
    private ImageView logo;

    @FXML
    private Hyperlink user_live_hyper;

    @FXML
    private ImageView user_profile_pic;

    @FXML
    private Hyperlink user_recording_hyper;

    @FXML
    private Label user_calendar_5;

    @FXML
    private Rectangle rec23;

    @FXML
    private Rectangle rec01;

    @FXML
    private Label trainer_calendar_time1;

    @FXML
    private Label user_calendar_3;

    @FXML
    private Rectangle rec00;

    @FXML
    private Rectangle rec22;

    @FXML
    private Label trainer_calendar_time2;

    @FXML
    private Rectangle rec47;

    @FXML
    private
    GridPane user_grid;

    @FXML
    private Label trainer_calendar_time3;

    @FXML
    private Rectangle rec46;

    @FXML
    private Label status00;

    @FXML
    private Label status22;

    @FXML
    private Label status46;

    @FXML
    private Pagination turn_page2;

    @FXML
    private Hyperlink user_history_hyper;

    @FXML
    private Pagination turn_page1;

    @FXML
    private Button delete47;

    @FXML
    private Label user_calendar_4;

    @FXML
    private Button delete23;

    @FXML
    private Label trainer_calendar_time4;

    @FXML
    private Label trainer_calendar_time5;

    @FXML
    private Label trainer_calendar_time6;

    @FXML
    private Label trainer_calendar_time7;

    @FXML
    private Label user_calendar_1;

    @FXML
    private Label user_calendar_2;

    @FXML
    void user_favorites_click(ActionEvent event) throws IOException {
        Stage stage = (Stage)user_calendar_2.getScene().getWindow();
        new APP().jump(stage, "user_favorites");
    }

    @FXML
    void user_recording_click(ActionEvent event) throws IOException {
        Stage stage = (Stage)user_calendar_2.getScene().getWindow();
        new APP().jump(stage, "user_recording");
    }

    @FXML
    void user_live_click(ActionEvent event) throws IOException {
        Stage stage = (Stage)user_calendar_2.getScene().getWindow();
        new APP().jump(stage, "user_live");
    }

    @FXML
    void user_calendar_click(ActionEvent event) throws IOException {
        Stage stage = (Stage)user_calendar_2.getScene().getWindow();
        new APP().jump(stage, "user_calendar");
    }

    @FXML
    void user_history_click(ActionEvent event) throws IOException {
        Stage stage = (Stage)user_calendar_2.getScene().getWindow();
        new APP().jump(stage, "user_history");
    }

    @FXML
    void user_logout_click(ActionEvent event) throws IOException {
        Stage stage = (Stage)user_calendar_2.getScene().getWindow();
        new APP().jump(stage, "login");
    }

    @FXML
    void click_turn_page(ActionEvent event) {

    }


    @FXML
    void click_enter26(ActionEvent event) {

    }

    @FXML
    void click_enter24(ActionEvent event) {

    }

    @FXML
    void initialize() throws ParseException {
        assert user_calendar_7 != null : "fx:id=\"trainer_calendar_Sat\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert rec57 != null : "fx:id=\"rec57\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_calendar_hyper != null : "fx:id=\"user_calendar_hyper\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time41 != null : "fx:id=\"trainer_calendar_time41\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_calendar_6 != null : "fx:id=\"trainer_calendar_Fri\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_favorites_hyper != null : "fx:id=\"user_favorites_hyper\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_logout_hyper != null : "fx:id=\"user_logout_hyper\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_live_hyper != null : "fx:id=\"user_live_hyper\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_profile_pic != null : "fx:id=\"user_profile_pic\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_recording_hyper != null : "fx:id=\"user_recording_hyper\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_calendar_5 != null : "fx:id=\"trainer_calendar_Thu\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert rec23 != null : "fx:id=\"rec23\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert rec01 != null : "fx:id=\"rec01\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time1 != null : "fx:id=\"trainer_calendar_time1\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_calendar_3 != null : "fx:id=\"trainer_calendar_Tue\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert rec00 != null : "fx:id=\"rec00\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert rec22 != null : "fx:id=\"rec22\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time2 != null : "fx:id=\"trainer_calendar_time2\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert rec47 != null : "fx:id=\"rec47\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time3 != null : "fx:id=\"trainer_calendar_time3\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert rec46 != null : "fx:id=\"rec46\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert status00 != null : "fx:id=\"status00\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert status22 != null : "fx:id=\"status22\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert status46 != null : "fx:id=\"status46\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert turn_page2 != null : "fx:id=\"turn_page2\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_history_hyper != null : "fx:id=\"user_history_hyper\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert turn_page1 != null : "fx:id=\"turn_page1\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert delete47 != null : "fx:id=\"delete47\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_calendar_4 != null : "fx:id=\"trainer_calendar_Wed\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert delete23 != null : "fx:id=\"delete23\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time4 != null : "fx:id=\"trainer_calendar_time4\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time5 != null : "fx:id=\"trainer_calendar_time5\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time6 != null : "fx:id=\"trainer_calendar_time6\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time7 != null : "fx:id=\"trainer_calendar_time7\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_calendar_1 != null : "fx:id=\"trainer_calendar_Sun\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_calendar_2 != null : "fx:id=\"trainer_calendar_Mon\" was not injected: check your FXML file 'user_calendar.fxml'.";

        Date d=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        user_calendar_1.setText(df.format(new Date(d.getTime() )));
        user_calendar_2.setText(df.format(new Date(d.getTime() + 1 * 24 * 60 * 60 * 1000)));
        user_calendar_3.setText(df.format(new Date(d.getTime() + 2 * 24 * 60 * 60 * 1000)));
        user_calendar_4.setText(df.format(new Date(d.getTime() + 3 * 24 * 60 * 60 * 1000)));
        user_calendar_5.setText(df.format(new Date(d.getTime() + 4 * 24 * 60 * 60 * 1000)));
        user_calendar_6.setText(df.format(new Date(d.getTime() + 5 * 24 * 60 * 60 * 1000)));
        user_calendar_7.setText(df.format(new Date(d.getTime() + 6 * 24 * 60 * 60 * 1000)));
        PremierUser user;
        PreUserDAOImpl UserDAO = new PreUserDAOImpl();
        user=UserDAO.queryByUserName(passValue.getValue());
        ArrayList<LiveSession> recent = new ArrayList<LiveSession>();
        recent=user.showCalender();
        for (LiveSession liveSession:recent) {
            long courseid=liveSession.getCourseId();
            System.out.println(liveSession.getStartTime().getHours());
            int i = 0;
            if(liveSession.getStartTime().getHours()==8){
                 i=0;
            }
            else if(liveSession.getStartTime().getHours()==10){
                 i=2;
            }
            else if(liveSession.getStartTime().getHours()==12){
                 i=4;
            }
            else if(liveSession.getStartTime().getHours()==14){
                 i=6;
            }
            else if(liveSession.getStartTime().getHours()==16){
                 i=8;
            }
            else if(liveSession.getStartTime().getHours()==18){
                 i=10;
            }
            int j =0;
            Date date = new Date();
            Date date2= new Date(date.getTime()+1 * 24 * 60 * 60 * 1000);
            Date date3= new Date(date.getTime()+2 * 24 * 60 * 60 * 1000);
            Date date4= new Date(date.getTime()+3 * 24 * 60 * 60 * 1000);
            Date date5= new Date(date.getTime()+4 * 24 * 60 * 60 * 1000);
            Date date6= new Date(date.getTime()+5 * 24 * 60 * 60 * 1000);
            Date date7= new Date(date.getTime()+6 * 24 * 60 * 60 * 1000);
            if (liveSession.getStartTime().getDay()==date.getDay()){
                j=0;
            }
            if (liveSession.getStartTime().getDay()==date2.getDay()){
                j=1;
            }
            if (liveSession.getStartTime().getDay()==date3.getDay()){
                j=2;
            }
            if (liveSession.getStartTime().getDay()==date4.getDay()){
                j=3;
            }
            if (liveSession.getStartTime().getDay()==date5.getDay()){
                j=4;
            }
            if (liveSession.getStartTime().getDay()==date6.getDay()){
                j=5;
            }
            if (liveSession.getStartTime().getDay()==date7.getDay()){
                j=6;
            }
            Label label = new Label(liveSession.getTrainerName()+"-live");
            label.setFont(Font.font("Comic Sans MS",16));
            label.setTextFill(Color.MEDIUMSEAGREEN);
            user_grid.add(label,j,i);
            Button button = new Button("delete");
            button.setFont(Font.font("Comic Sans MS"));
            button.setOnMouseClicked(e -> {
                label.setVisible(false);
                button.setVisible(false);
                user.cancelLiveSession(courseid);
            });
            user_grid.add(button,j,(i+1));

        }

    }
}
