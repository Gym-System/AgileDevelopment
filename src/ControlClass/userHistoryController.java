package ControlClass;

import EntityClass.DAO.impl.HistoryDataDAOImpl;
import EntityClass.VO.HistoryData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class userHistoryController implements Initializable {

    @FXML
    private Pagination turn_page;

    @FXML
    private Hyperlink user_calendar_hyper;

    @FXML
    private Label history_time7;

    @FXML
    private Label history_time6;

    @FXML
    private Label history_time5;

    @FXML
    private Label history_time4;

    @FXML
    private Label history_time3;

    @FXML
    private Label history_name9;

    @FXML
    private Label history_time2;

    @FXML
    private Label history_name8;

    @FXML
    private Label history_time1;

    @FXML
    private Label history_name7;

    @FXML
    private Label history_name6;

    @FXML
    private ImageView logo;

    @FXML
    private Hyperlink user_live_hyper;

    @FXML
    private ImageView user_profile_pic;

    @FXML
    private Label history_trainer5;

    @FXML
    private Label history_category_type8;

    @FXML
    private Label history_trainer4;

    @FXML
    private Label history_category_type9;

    @FXML
    private Label history_trainer3;

    @FXML
    private Label history_trainer2;

    @FXML
    private Label history_trainer9;

    @FXML
    private Label history_trainer8;

    @FXML
    private Label history_trainer7;

    @FXML
    private Label history_category_type10;

    @FXML
    private Label history_trainer6;

    @FXML
    private Label history_name5;

    @FXML
    private CheckBox history_live_check;

    @FXML
    private Label history_category_type1;

    @FXML
    private Label history_name4;

    @FXML
    private Label history_category_type2;

    @FXML
    private Label history_name3;

    @FXML
    private Label history_name2;

    @FXML
    private Label history_category_type3;

    @FXML
    private Label history_name1;

    @FXML
    private Label history_trainer1;

    @FXML
    private Label history_category_type4;

    @FXML
    private Label history_category_type5;

    @FXML
    private Label history_category_type6;

    @FXML
    private Label history_time9;

    @FXML
    private Label history_category_type7;

    @FXML
    private Label history_time8;

    @FXML
    private Label history_trainer10;

    @FXML
    private Hyperlink user_facorites_hyper;

    @FXML
    private Label history_name10;

    @FXML
    private Label history_time10;

    @FXML
    private Hyperlink user_logout_hyper;

    @FXML
    private Hyperlink user_recording_hyper;

    @FXML
    private Button user_find_button;

    @FXML
    private Hyperlink user_history_hyper;

    @FXML
    private TextField user_find_text;

    @FXML
    private CheckBox history_recording_check;

    HistoryDataDAOImpl historyDataDAO = new HistoryDataDAOImpl();


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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        show();
    }

    public void show() {
        Label[] labelCategory = new Label[10];
        labelCategory[0] = history_category_type1;
        labelCategory[1] = history_category_type2;
        labelCategory[2] = history_category_type3;
        labelCategory[3] = history_category_type4;
        labelCategory[4] = history_category_type5;
        labelCategory[5] = history_category_type6;
        labelCategory[6] = history_category_type7;
        labelCategory[7] = history_category_type8;
        labelCategory[8] = history_category_type9;
        labelCategory[9] = history_category_type10;

        Label[] labelName = new Label[10];
        labelName[0] = history_name1;
        labelName[1] = history_name2;
        labelName[2] = history_name3;
        labelName[3] = history_name4;
        labelName[4] = history_name5;
        labelName[5] = history_name6;
        labelName[6] = history_name7;
        labelName[7] = history_name8;
        labelName[8] = history_name9;
        labelName[9] = history_name10;

        Label[] labelCoach = new Label[10];
        labelCoach[0] = history_trainer1;
        labelCoach[1] = history_trainer2;
        labelCoach[2] = history_trainer3;
        labelCoach[3] = history_trainer4;
        labelCoach[4] = history_trainer5;
        labelCoach[5] = history_trainer6;
        labelCoach[6] = history_trainer7;
        labelCoach[7] = history_trainer8;
        labelCoach[8] = history_trainer9;
        labelCoach[9] = history_trainer10;

        Label[] labelTime = new Label[10];
        labelTime[0] = history_time1;
        labelTime[1] = history_time2;
        labelTime[2] = history_time3;
        labelTime[3] = history_time4;
        labelTime[4] = history_time5;
        labelTime[5] = history_time6;
        labelTime[6] = history_time7;
        labelTime[7] = history_time8;
        labelTime[8] = history_time9;
        labelTime[9] = history_time10;

        ArrayList<HistoryData> historyData = historyDataDAO.queryByUserName("kaiyi");

    }
}
