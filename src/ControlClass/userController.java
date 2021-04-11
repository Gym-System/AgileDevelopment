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

public class userController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label recName_yoga1_label1;

    @FXML
    private Label recDur_yoga2_label;

    @FXML
    private Label recName_hitt2_label;

    @FXML
    private Pagination turn_page;

    @FXML
    private ImageView user_recPic_hitt2;

    @FXML
    private ImageView user_recPic_yoga1;

    @FXML
    private Hyperlink user_calendar_hyper;

    @FXML
    private ImageView user_recPic_yoga2;

    @FXML
    private Hyperlink recEnter_yoga1_hyper1;

    @FXML
    private Hyperlink recEnter_yoga2_hyper1;

    @FXML
    private Label recDur_hitt2_label;

    @FXML
    private Label recName_yoga2_label;

    @FXML
    private Hyperlink user_logout_hyper;

    @FXML
    private Label recCoa_strenght2_label;

    @FXML
    private ImageView logo;

    @FXML
    private Label recCoa_yoga1_label;

    @FXML
    private ImageView user_recPic_strength1;

    @FXML
    private Hyperlink user_live_hyper;

    @FXML
    private ImageView user_profile_pic;

    @FXML
    private Label recDur_strength1_label;

    @FXML
    private Label recCoa_hitt2_label;

    @FXML
    private CheckBox user_yoga_check;

    @FXML
    private Label recName_hitt1_label;

    @FXML
    private Hyperlink user_recording_hyper;

    @FXML
    private Hyperlink user_recEnter_hyper31;

    @FXML
    private Label recName_strength2_label;

    @FXML
    private ImageView user_recPic_strength2;

    @FXML
    private Hyperlink user_recEnter_hyper4;

    @FXML
    private Label recCoa_hitt1_label;

    @FXML
    private Label recDur_strength2_label;

    @FXML
    private CheckBox user_hitt_check;

    @FXML
    private Button user_find_button;

    @FXML
    private Label recDur_yoga1_label;

    @FXML
    private Hyperlink user_facorites_hyper;

    @FXML
    private Hyperlink user_history_hyper;

    @FXML
    private TextField user_find_text;

    @FXML
    private CheckBox user_strength_check;

    @FXML
    private Label recCoa_strenght1_label;

    @FXML
    private Label recCoa_yoga2_label;

    @FXML
    private ImageView user_recPic_hitt1;

    @FXML
    private Hyperlink user_recEnter_hyper5111;

    @FXML
    private Label recDur_hitt1_label;

    @FXML
    private Label recName_strength1_label;

    @FXML
    private Hyperlink user_recEnter_hyper611;

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
    void click_check_hitt(ActionEvent event) {

    }

    @FXML
    void click_enterrec1(ActionEvent event) {

    }

    @FXML
    void click_enterrec2(ActionEvent event) {

    }

    @FXML
    void click_enterrec3(ActionEvent event) {

    }

    @FXML
    void click_enterrec4(ActionEvent event) {

    }

    @FXML
    void click_enterrec5(ActionEvent event) {

    }

    @FXML
    void click_enterrec6(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert recName_yoga1_label1 != null : "fx:id=\"recName_yoga1_label1\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recDur_yoga2_label != null : "fx:id=\"recDur_yoga2_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recName_hitt2_label != null : "fx:id=\"recName_hitt2_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert turn_page != null : "fx:id=\"turn_page\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_recPic_hitt2 != null : "fx:id=\"user_recPic_hitt2\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_recPic_yoga1 != null : "fx:id=\"user_recPic_yoga1\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_calendar_hyper != null : "fx:id=\"user_calendar_hyper\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_recPic_yoga2 != null : "fx:id=\"user_recPic_yoga2\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recEnter_yoga1_hyper1 != null : "fx:id=\"recEnter_yoga1_hyper1\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recEnter_yoga2_hyper1 != null : "fx:id=\"recEnter_yoga2_hyper1\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recDur_hitt2_label != null : "fx:id=\"recDur_hitt2_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recName_yoga2_label != null : "fx:id=\"recName_yoga2_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_logout_hyper != null : "fx:id=\"user_logout_hyper\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recCoa_strenght2_label != null : "fx:id=\"recCoa_strenght2_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recCoa_yoga1_label != null : "fx:id=\"recCoa_yoga1_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_recPic_strength1 != null : "fx:id=\"user_recPic_strength1\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_live_hyper != null : "fx:id=\"user_live_hyper\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_profile_pic != null : "fx:id=\"user_profile_pic\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recDur_strength1_label != null : "fx:id=\"recDur_strength1_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recCoa_hitt2_label != null : "fx:id=\"recCoa_hitt2_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_yoga_check != null : "fx:id=\"user_yoga_check\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recName_hitt1_label != null : "fx:id=\"recName_hitt1_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_recording_hyper != null : "fx:id=\"user_recording_hyper\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_recEnter_hyper31 != null : "fx:id=\"user_recEnter_hyper31\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recName_strength2_label != null : "fx:id=\"recName_strength2_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_recPic_strength2 != null : "fx:id=\"user_recPic_strength2\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_recEnter_hyper4 != null : "fx:id=\"user_recEnter_hyper4\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recCoa_hitt1_label != null : "fx:id=\"recCoa_hitt1_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recDur_strength2_label != null : "fx:id=\"recDur_strength2_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_hitt_check != null : "fx:id=\"user_hitt_check\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_find_button != null : "fx:id=\"user_find_button\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recDur_yoga1_label != null : "fx:id=\"recDur_yoga1_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_facorites_hyper != null : "fx:id=\"user_facorites_hyper\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_history_hyper != null : "fx:id=\"user_history_hyper\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_find_text != null : "fx:id=\"user_find_text\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_strength_check != null : "fx:id=\"user_strength_check\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recCoa_strenght1_label != null : "fx:id=\"recCoa_strenght1_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recCoa_yoga2_label != null : "fx:id=\"recCoa_yoga2_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_recPic_hitt1 != null : "fx:id=\"user_recPic_hitt1\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_recEnter_hyper5111 != null : "fx:id=\"user_recEnter_hyper5111\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recDur_hitt1_label != null : "fx:id=\"recDur_hitt1_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert recName_strength1_label != null : "fx:id=\"recName_strength1_label\" was not injected: check your FXML file 'user_recording.fxml'.";
        assert user_recEnter_hyper611 != null : "fx:id=\"user_recEnter_hyper611\" was not injected: check your FXML file 'user_recording.fxml'.";

    }
}
