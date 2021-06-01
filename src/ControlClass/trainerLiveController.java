package ControlClass;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import EntityClass.DAO.Impl.LiveSessionDAOImpl;
import EntityClass.VO.LiveSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class trainerLiveController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button trainer_enterLive_button3;

    @FXML
    private Label trainer_enterLive_name8;

    @FXML
    private Button trainer_enterLive_button4;

    @FXML
    private Button trainer_enterLive_button5;

    @FXML
    private Button trainer_enterLive_button6;

    @FXML
    private Button trainer_enterLive_button1;

    @FXML
    private Hyperlink trainer_upload_hyper;

    @FXML
    private Pagination turn_page;

    @FXML
    private Button trainer_enterLive_button2;

    @FXML
    private Label trainer_enterLive_name1;

    @FXML
    private Label trainer_enterLive_name2;

    @FXML
    private Label trainer_enterLive_name3;

    @FXML
    private Label trainer_enterLive_name4;

    @FXML
    private Label trainer_enterLive_name5;

    @FXML
    private Label trainer_enterLive_name6;

    @FXML
    private Label trainer_enterLive_name7;

    @FXML
    private Hyperlink trainer_live_hyper;

    @FXML
    private ImageView logo;

    @FXML
    private Label trainer_enterLive_time1;

    @FXML
    private CheckBox user_yoga_check;

    @FXML
    private Label trainer_enterLive_time2;

    @FXML
    private Hyperlink trainer_portrait_hyper;

    @FXML
    private Label trainer_enterLive_time3;

    @FXML
    private Label trainer_enterLive_time4;

    @FXML
    private Label trainer_enterLive_time5;

    @FXML
    private Label trainer_enterLive_time6;

    @FXML
    private Label trainer_enterLive_time7;

    @FXML
    private Hyperlink trainer_logout_hyper;

    @FXML
    private Label trainer_enterLive_time8;

    @FXML
    private CheckBox user_hitt_check;

    @FXML
    private Button user_find_button;

    @FXML
    private ImageView trainer_profile_pic;

    @FXML
    private ToolBar toolbar2;

    @FXML
    private Hyperlink trainer_calendar_hyper;

    @FXML
    private ToolBar toolbar1;

    @FXML
    private TextField user_find_text;

    @FXML
    private CheckBox user_strength_check;

    @FXML
    private Hyperlink trainer_history_hyper;

    @FXML
    private ToolBar toolbar8;

    @FXML
    private ToolBar toolbar7;

    @FXML
    private ToolBar toolbar4;

    @FXML
    private Button trainer_enterLive_button7;

    @FXML
    private ToolBar toolbar3;

    @FXML
    private Button trainer_enterLive_button8;

    @FXML
    private ToolBar toolbar6;

    @FXML
    private ToolBar toolbar5;

    LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();

    @FXML
    void trainerInfo_info_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"TrainerInfo");
    }
    @FXML
    void trainer_portrait_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"trainer_portrait");
    }

    @FXML
    void trainer_upload_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"trainer_recording");
    }

    @FXML
    void trainer_live_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"trainer_live");
    }

    @FXML
    void trainer_calendar_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"tra_trainer_calendar");
    }

    @FXML
    void trainer_history_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"trainer_history");
    }

    @FXML
    void user_logout_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"login");
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
    void trainer_startLive_click1(ActionEvent event) {

    }

    @FXML
    void trainer_startLive_click2(ActionEvent event) {

    }

    @FXML
    void trainer_startLive_click3(ActionEvent event) {

    }

    @FXML
    void trainer_startLive_click4(ActionEvent event) {

    }

    @FXML
    void trainer_startLive_click5(ActionEvent event) {

    }

    @FXML
    void trainer_startLive_click6(ActionEvent event) {

    }

    @FXML
    void trainer_startLive_click7(ActionEvent event) {

    }

    @FXML
    void trainer_startLive_click8(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        show();
    }

    public void show() {
        Label[] labelType = new Label[8];
        labelType[0] = trainer_enterLive_name1;
        labelType[1] = trainer_enterLive_name2;
        labelType[2] = trainer_enterLive_name3;
        labelType[3] = trainer_enterLive_name4;
        labelType[4] = trainer_enterLive_name5;
        labelType[5] = trainer_enterLive_name6;
        labelType[6] = trainer_enterLive_name7;
        labelType[7] = trainer_enterLive_name8;

        Label[] labelTime = new Label[8];
        labelTime[0] =trainer_enterLive_time1;
        labelTime[1] =trainer_enterLive_time2;
        labelTime[2] =trainer_enterLive_time3;
        labelTime[3] =trainer_enterLive_time4;
        labelTime[4] =trainer_enterLive_time5;
        labelTime[5] =trainer_enterLive_time6;
        labelTime[6] =trainer_enterLive_time7;
        labelTime[7] =trainer_enterLive_time8;

        ArrayList<LiveSession> liveSessions = liveSessionDAO.queryByTrainerName("kaiyi");
        turn_page.setPageCount((int) Math.ceil(liveSessions.size()/8.0));
        turn_page.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                VBox vBox = new VBox();
                int limit = 8;
                if (param.intValue() == liveSessions.size()/8) {
                    limit = liveSessions.size()%8;
                }

                if(param.intValue() < liveSessions.size()/8){
                    for (int i =0; i <limit; i++){
                        labelType[i].setText(liveSessions.get(8 * param.intValue() + i).getSubject());
                        labelTime[i].setText(String.valueOf(liveSessions.get(8 * param.intValue() + i).getStartTime()));

                    }

                } else {
                    for (int i =0; i <limit; i++){
                        labelType[i].setText(liveSessions.get(8 * param.intValue() + i).getSubject());
                        labelTime[i].setText(String.valueOf(liveSessions.get(8 * param.intValue() + i).getStartTime()));
                    }
                    for (int i = limit; i<8; i++){
                        labelType[i].setText("");
                        labelTime[i].setText("");
                    }

                }
                return vBox;
            }
        });
    }
}
