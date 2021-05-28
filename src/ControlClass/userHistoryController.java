package ControlClass;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class userHistoryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label history_name1_strength;

    @FXML
    private Label history_name2_yoga;

    @FXML
    private Hyperlink user_recording_hyper;

    @FXML
    private Label history_trainer2;

    @FXML
    private Pagination turn_page;

    @FXML
    private CheckBox history_live_check;

    @FXML
    private Button user_find_button;

    @FXML
    private Hyperlink user_calendar_hyper;

    @FXML
    private Label history_trainer1;

    @FXML
    private Hyperlink user_facorites_hyper;

    @FXML
    private Hyperlink user_history_hyper;

    @FXML
    private TextField user_find_text;

    @FXML
    private Label history_category_live;

    @FXML
    private Label history_time2;

    @FXML
    private Label history_time1;

    @FXML
    private Hyperlink user_logout_hyper;

    @FXML
    private ImageView logo;

    @FXML
    private Label history_category_recording;

    @FXML
    private Hyperlink user_live_hyper;

    @FXML
    private ImageView user_profile_pic;

    @FXML
    private CheckBox history_recording_check;

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
    void click_find(ActionEvent event) {

    }

    @FXML
    void click_turn_page(ActionEvent event) {

    }

    @FXML
    void click_check_yoga(ActionEvent event) {

    }

    @FXML
    void click_check_strength(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert history_name1_strength != null : "fx:id=\"history_name1_strength\" was not injected: check your FXML file 'user_history.fxml'.";
        assert history_name2_yoga != null : "fx:id=\"history_name2_yoga\" was not injected: check your FXML file 'user_history.fxml'.";
        assert user_recording_hyper != null : "fx:id=\"user_recording_hyper\" was not injected: check your FXML file 'user_history.fxml'.";
        assert history_trainer2 != null : "fx:id=\"history_trainer2\" was not injected: check your FXML file 'user_history.fxml'.";
        assert turn_page != null : "fx:id=\"turn_page\" was not injected: check your FXML file 'user_history.fxml'.";
        assert history_live_check != null : "fx:id=\"history_live_check\" was not injected: check your FXML file 'user_history.fxml'.";
        assert user_find_button != null : "fx:id=\"user_find_button\" was not injected: check your FXML file 'user_history.fxml'.";
        assert user_calendar_hyper != null : "fx:id=\"user_calendar_hyper\" was not injected: check your FXML file 'user_history.fxml'.";
        assert history_trainer1 != null : "fx:id=\"history_trainer1\" was not injected: check your FXML file 'user_history.fxml'.";
        assert user_facorites_hyper != null : "fx:id=\"user_facorites_hyper\" was not injected: check your FXML file 'user_history.fxml'.";
        assert user_history_hyper != null : "fx:id=\"user_history_hyper\" was not injected: check your FXML file 'user_history.fxml'.";
        assert user_find_text != null : "fx:id=\"user_find_text\" was not injected: check your FXML file 'user_history.fxml'.";
        assert history_category_live != null : "fx:id=\"history_category_live\" was not injected: check your FXML file 'user_history.fxml'.";
        assert history_time2 != null : "fx:id=\"history_time2\" was not injected: check your FXML file 'user_history.fxml'.";
        assert history_time1 != null : "fx:id=\"history_time1\" was not injected: check your FXML file 'user_history.fxml'.";
        assert user_logout_hyper != null : "fx:id=\"user_logout_hyper\" was not injected: check your FXML file 'user_history.fxml'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file 'user_history.fxml'.";
        assert history_category_recording != null : "fx:id=\"history_category_recording\" was not injected: check your FXML file 'user_history.fxml'.";
        assert user_live_hyper != null : "fx:id=\"user_live_hyper\" was not injected: check your FXML file 'user_history.fxml'.";
        assert user_profile_pic != null : "fx:id=\"user_profile_pic\" was not injected: check your FXML file 'user_history.fxml'.";
        assert history_recording_check != null : "fx:id=\"history_recording_check\" was not injected: check your FXML file 'user_history.fxml'.";

    }
}
