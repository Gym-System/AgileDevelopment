package ControlClass;

import EntityClass.DAO.RecVideoDAO;
import EntityClass.DAO.impl.LiveSessionDAOImpl;
import EntityClass.DAO.impl.RecVideoDAOImpl;
import EntityClass.VO.LiveSession;
import EntityClass.VO.RecVideo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class trainerHistoryController implements Initializable {

    @FXML
    private Label history_live5;

    @FXML
    private Label history_user8;

    @FXML
    private Label history_live6;

    @FXML
    private Label history_live3;

    @FXML
    private Label history_user6;

    @FXML
    private Label history_live4;

    @FXML
    private Label history_user7;

    @FXML
    private Label history_live1;

    @FXML
    private Label history_type7;

    @FXML
    private Label history_live2;

    @FXML
    private Label history_type8;

    @FXML
    private Label history_type5;

    @FXML
    private Pagination turn_page;

    @FXML
    private Label history_type6;

    @FXML
    private Hyperlink trainer_portrait_calendar;

    @FXML
    private TextField trainer_find_text;

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
    private Label history_time2;

    @FXML
    private Label history_time1;

    @FXML
    private Hyperlink trainer_portrait_portrait;

    @FXML
    private Label history_type3;

    @FXML
    private Label history_type4;

    @FXML
    private Label history_type1;

    @FXML
    private Label history_type2;

    @FXML
    private Hyperlink trainer_portrait_live;

    @FXML
    private Hyperlink trainer_logout_hyper;

    @FXML
    private ImageView trainer_portrait_info;

    @FXML
    private Label history_time8;

    @FXML
    private Label history_user1;

    @FXML
    private Button trainer_find_button;

    @FXML
    private Hyperlink trainer_portrait_upload;

    @FXML
    private Hyperlink trainer_portrait_history;

    @FXML
    private Label history_user4;

    @FXML
    private Label history_user5;

    @FXML
    private Label history_user2;

    @FXML
    private Label history_live7;

    @FXML
    private Label history_user3;

    @FXML
    private Label history_live8;

    LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
    RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();

    @FXML
    void trainer_portrait_portrait_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) history_time1.getScene().getWindow();
        new APP().jump(stage,"trainer_portrait");
    }

    @FXML
    void trainer_portrait_upload_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) history_time1.getScene().getWindow();
        new APP().jump(stage,"trainer_recording");
    }

    @FXML
    void trainer_portrait_live_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) history_time1.getScene().getWindow();
        new APP().jump(stage,"trainer_live");
    }

    @FXML
    void trainer_portrait_calendar_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) history_time1.getScene().getWindow();
        new APP().jump(stage,"tra_trainer_calendar");
    }

    @FXML
    void trainer_portrait_history_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) history_time1.getScene().getWindow();
        new APP().jump(stage,"trainer_history");
    }

    @FXML
    void trainer_portrait_info_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) history_time1.getScene().getWindow();
        new APP().jump(stage, "TrainerInfo");
    }

    @FXML
    void trainer_logout_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) history_time1.getScene().getWindow();
        new APP().jump(stage, "login");
    }


    @FXML
    void click_turn_page(ActionEvent event) {

    }

    @FXML
    void click_find(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        show();
    }

    public void show() {
        Label[] labelType = new Label[8];
        labelType[0] = history_live1;
        labelType[1] = history_live2;
        labelType[2] = history_live3;
        labelType[3] = history_live4;
        labelType[4] = history_live5;
        labelType[5] = history_live6;
        labelType[6] = history_live7;
        labelType[7] = history_live8;

        Label[] labelSubject = new Label[8];
        labelSubject[0] = history_type1;
        labelSubject[1] = history_type2;
        labelSubject[2] = history_type3;
        labelSubject[3] = history_type4;
        labelSubject[4] = history_type5;
        labelSubject[5] = history_type6;
        labelSubject[6] = history_type7;
        labelSubject[7] = history_type8;

        Label[] labelUser = new Label[8];
        labelUser[0] = history_user1;
        labelUser[1] = history_user2;
        labelUser[2] = history_user3;
        labelUser[3] = history_user4;
        labelUser[4] = history_user5;
        labelUser[5] = history_user6;
        labelUser[6] = history_user7;
        labelUser[7] = history_user8;

        Label[] labelTime = new Label[8];
        labelTime[0] = history_time1;
        labelTime[1] = history_time2;
        labelTime[2] = history_time3;
        labelTime[3] = history_time4;
        labelTime[4] = history_time5;
        labelTime[5] = history_time6;
        labelTime[6] = history_time7;
        labelTime[7] = history_time8;

        ArrayList<LiveSession> liveSessions = liveSessionDAO.queryAll();
        ArrayList<RecVideo> recVideos = recVideoDAO.queryAll();

        turn_page.setPageCount((int) Math.ceil(liveSessions.size() / 8.0));
        turn_page.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                VBox box = new VBox();
                int limit = 8;
                if (param.intValue() == liveSessions.size() / 8) {
                    limit = liveSessions.size() % 8;
                }

                if (param.intValue() < liveSessions.size() / 8) {
                    for (int i = 0; i < limit; i++) {
                        labelType[i].setText("live");
                        labelSubject[i].setText(liveSessions.get(8 * param.intValue() + i).getSubject());
                        labelUser[i].setText("User: "+liveSessions.get(8 * param.intValue() + i).getUserName());
                        labelTime[i].setText(String.valueOf(liveSessions.get(8 * param.intValue() + i).getStartTime()));
                    }

                } else {
                    for (int i = 0; i < limit; i++) {
                        labelType[i].setText("live");
                        labelSubject[i].setText(liveSessions.get(8 * param.intValue() + i).getSubject());
                        labelUser[i].setText("User: "+liveSessions.get(8 * param.intValue() + i).getUserName());
                        labelTime[i].setText(String.valueOf(liveSessions.get(8 * param.intValue() + i).getStartTime()));
                    }
                    for (int i = limit; i < 8; i++) {
                        labelType[i].setText("");
                        labelSubject[i].setText("");
                        labelUser[i].setText("");
                        labelTime[i].setText("");
                    }

                }
                return box;
            }

        });

    }
}