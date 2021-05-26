package ControlClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class userFavoritesController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label favName4_label;

    @FXML
    private Label favTime3_label;

    @FXML
    private ImageView userFav1_pic;

    @FXML
    private Pagination turn_page;

    @FXML
    private Label favTime1_label;

    @FXML
    private Hyperlink user_calendar_hyper;

    @FXML
    private Label favName1_label;

    @FXML
    private Label favCoa2_label;

    @FXML
    private Hyperlink favEnter2_hyper;

    @FXML
    private Hyperlink user_logout_hyper;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView userFav2_pic;

    @FXML
    private Hyperlink user_live_hyper;

    @FXML
    private ImageView user_profile_pic;

    @FXML
    private Label favName3_label;

    @FXML
    private CheckBox user_yoga_check;

    @FXML
    private Hyperlink user_recording_hyper;

    @FXML
    private Label favTime2_label;

    @FXML
    private Hyperlink favEnter4_hyper;

    @FXML
    private Label favTime4_label;

    @FXML
    private ImageView userFav3_pic;

    @FXML
    private CheckBox user_hitt_check;

    @FXML
    private Button user_find_button;

    @FXML
    private Label favCoa4_label;

    @FXML
    private Hyperlink favEnter1_hyper;

    @FXML
    private Label favCoa3_label;

    @FXML
    private Label favName2_label;

    @FXML
    private Hyperlink user_favorites_hyper;

    @FXML
    private Hyperlink user_history_hyper;

    @FXML
    private TextField user_find_text;

    @FXML
    private CheckBox user_strength_check;

    @FXML
    private Hyperlink favEnter3_hyper;

    @FXML
    private ImageView userFav4_pic;

    @FXML
    private Label favCoa1_label;

    @FXML
    void user_favorites_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_favorites_hyper.getScene().getWindow();
        new APP().jump(stage,"user_favorites");
    }

    @FXML
    void user_recording_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_recording_hyper.getScene().getWindow();
        new APP().jump(stage,"user_recording");
    }

    @FXML
    void user_live_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_live_hyper.getScene().getWindow();
        new APP().jump(stage,"user_live");
    }

    @FXML
    void user_calendar_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_calendar_hyper.getScene().getWindow();
        new APP().jump(stage,"user_calendar");
    }

    @FXML
    void user_history_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_history_hyper.getScene().getWindow();
        new APP().jump(stage,"user_history");
    }

    @FXML
    void user_logout_click(MouseEvent event) {

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
    void ebebeb(ActionEvent event) {

    }

    @FXML
    void click_enterrec4(ActionEvent event) {

    }

    @FXML
    void d0d0d0(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
