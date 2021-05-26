package ControlClass;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class userCalendarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label trainer_calendar_Sat;

    @FXML
    private Rectangle rec57;

    @FXML
    private Hyperlink user_calendar_hyper;

    @FXML
    private Label trainer_calendar_time41;

    @FXML
    private Label trainer_calendar_Fri;

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
    private Label trainer_calendar_Thu;

    @FXML
    private Rectangle rec23;

    @FXML
    private Rectangle rec01;

    @FXML
    private Label trainer_calendar_time1;

    @FXML
    private Label trainer_calendar_Tue;

    @FXML
    private Rectangle rec00;

    @FXML
    private Rectangle rec22;

    @FXML
    private Label trainer_calendar_time2;

    @FXML
    private Rectangle rec47;

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
    private Label trainer_calendar_Wed;

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
    private Label trainer_calendar_Sun;

    @FXML
    private Label trainer_calendar_Mon;

    @FXML
    void user_favorites_click(ActionEvent event) {

    }

    @FXML
    void user_recording_click(ActionEvent event) {

    }

    @FXML
    void user_live_click(ActionEvent event) {

    }

    @FXML
    void user_calendar_click(ActionEvent event) {

    }

    @FXML
    void user_history_click(ActionEvent event) {

    }

    @FXML
    void user_logout_click(ActionEvent event) {

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
    void initialize() {
        assert trainer_calendar_Sat != null : "fx:id=\"trainer_calendar_Sat\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert rec57 != null : "fx:id=\"rec57\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_calendar_hyper != null : "fx:id=\"user_calendar_hyper\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time41 != null : "fx:id=\"trainer_calendar_time41\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_Fri != null : "fx:id=\"trainer_calendar_Fri\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_favorites_hyper != null : "fx:id=\"user_favorites_hyper\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_logout_hyper != null : "fx:id=\"user_logout_hyper\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_live_hyper != null : "fx:id=\"user_live_hyper\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_profile_pic != null : "fx:id=\"user_profile_pic\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert user_recording_hyper != null : "fx:id=\"user_recording_hyper\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_Thu != null : "fx:id=\"trainer_calendar_Thu\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert rec23 != null : "fx:id=\"rec23\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert rec01 != null : "fx:id=\"rec01\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time1 != null : "fx:id=\"trainer_calendar_time1\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_Tue != null : "fx:id=\"trainer_calendar_Tue\" was not injected: check your FXML file 'user_calendar.fxml'.";
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
        assert trainer_calendar_Wed != null : "fx:id=\"trainer_calendar_Wed\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert delete23 != null : "fx:id=\"delete23\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time4 != null : "fx:id=\"trainer_calendar_time4\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time5 != null : "fx:id=\"trainer_calendar_time5\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time6 != null : "fx:id=\"trainer_calendar_time6\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_time7 != null : "fx:id=\"trainer_calendar_time7\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_Sun != null : "fx:id=\"trainer_calendar_Sun\" was not injected: check your FXML file 'user_calendar.fxml'.";
        assert trainer_calendar_Mon != null : "fx:id=\"trainer_calendar_Mon\" was not injected: check your FXML file 'user_calendar.fxml'.";

    }
}
