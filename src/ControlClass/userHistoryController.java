package ControlClass;

import EntityClass.DAO.Impl.LiveSessionDAOImpl;
import EntityClass.DAO.Impl.RecVideoDAOImpl;
import EntityClass.DAO.Impl.WatchedVideoDAOImpl;

import EntityClass.VO.LiveSession;
import EntityClass.VO.RecVideo;
import EntityClass.VO.WatchedVideo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
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

    WatchedVideoDAOImpl watchedVideoDAO = new WatchedVideoDAOImpl();
    RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();

    @FXML
    public void userinfo_hyperlink(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_facorites_hyper.getScene().getWindow();
        new APP().jump(stage,"UserInfo");
    }

    @FXML
    void user_favorites_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_facorites_hyper.getScene().getWindow();
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
    void user_logout_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_history_hyper.getScene().getWindow();
        new APP().jump(stage,"login");

    }

    @FXML
    void click_find(MouseEvent event) {
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

        ArrayList<WatchedVideo> watchedVideos = watchedVideoDAO.queryByUserName(passValue.getValue());
        System.out.println(passValue.getValue());
        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
//        LiveSession liveSession = liveSessionDAO.q
//        turn_page.setPageCount((int) Math.ceil(watchedVideos.size()/10.0));

        //nothing enters, return whole list
        if (user_find_text.getText().equals("")) {
            turn_page.setPageCount((int) Math.ceil(watchedVideos.size()/10.0));
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int limit = 10;
                    if (param.intValue() == watchedVideos.size()/10) {
                        limit = watchedVideos.size()%10;
                    }

                    if(param.intValue() < watchedVideos.size()/10){
                        LiveSessionDAOImpl liveSessionDAO;
                        LiveSession liveSession;
                        RecVideoDAOImpl recVideoDAO;
                        RecVideo recVideo;
                        for (int i =0; i <limit; i++){
                            labelCategory[i].setText(watchedVideos.get(10 * param.intValue() + i).getType());
                            if (watchedVideos.get(10 * param.intValue() + i).getType().equals("live")) {
                                liveSessionDAO = new LiveSessionDAOImpl();
                                liveSession = liveSessionDAO.queryByCourseId(watchedVideos.get(10 * param.intValue() + i).getCourseId());
                                labelName[i].setText(liveSession.getSubject());
                                labelCoach[i].setText(liveSession.getTrainerName());
                                labelTime[i].setText(String.valueOf(liveSession.getStartTime()));
                            } else {
                                recVideoDAO = new RecVideoDAOImpl();
                                recVideo = recVideoDAO.queryByCourseId(watchedVideos.get(10 * param.intValue() + i).getCourseId());
                                labelName[i].setText(recVideo.getSubject());
                                labelCoach[i].setText(recVideo.getUserName());
                                labelTime[i].setText(String.valueOf(recVideo.getUploadedTime()));
                            }



                        }

                    } else {
                        LiveSessionDAOImpl liveSessionDAO;
                        LiveSession liveSession;
                        RecVideoDAOImpl recVideoDAO;
                        RecVideo recVideo;
                        for (int i =0; i <limit; i++){
                            labelCategory[i].setText(watchedVideos.get(10 * param.intValue() + i).getType());
                            if (watchedVideos.get(10 * param.intValue() + i).getType().equals("live")) {
                                liveSessionDAO = new LiveSessionDAOImpl();
                                liveSession = liveSessionDAO.queryByCourseId(watchedVideos.get(10 * param.intValue() + i).getCourseId());
                                labelName[i].setText(liveSession.getSubject());
                                labelCoach[i].setText(liveSession.getTrainerName());
                                labelTime[i].setText(String.valueOf(liveSession.getStartTime()));
                            } else {
                                recVideoDAO = new RecVideoDAOImpl();
                                recVideo = recVideoDAO.queryByCourseId(watchedVideos.get(10 * param.intValue() + i).getCourseId());
                                labelName[i].setText(recVideo.getSubject());
                                labelCoach[i].setText(recVideo.getUserName());
                                labelTime[i].setText(String.valueOf(recVideo.getUploadedTime()));
                            }
                        }
                        for (int i = limit; i<10; i++){
                            labelCategory[i].setText("");
                            labelName[i].setText("");
                            labelCoach[i].setText("");
                            labelTime[i].setText("");
                        }

                    }
                    return box;
                }
            });
        }

        RecVideo recVideos;
        LiveSession liveSessions;
        ArrayList<RecVideo> recVideoArrayList = new ArrayList<>();
        ArrayList<LiveSession> liivesessionArrayList = new ArrayList<>();
        for (WatchedVideo w: watchedVideos) {
            recVideos = recVideoDAO.queryByCourseId(w.getCourseId());
            liveSessions = liveSessionDAO.queryByCourseId(w.getCourseId());
            if (!user_find_text.getText().equals("") && !user_find_text.getText().equals("live") && !user_find_text.getText().equals("recorded")) {
                turn_page.setPageCount(1);
                turn_page.setPageFactory(new Callback<Integer, Node>() {
                    @Override
                    public Node call(Integer param) {
                        VBox box = new VBox();

                        for (int i = 0; i < 10;i++){
                            labelCategory[i].setText("");
                            labelName[i].setText("");
                            labelCoach[i].setText("");
                            labelTime[i].setText("");
                        }

                        return box;
                    }
                });
            }
        }

        for (WatchedVideo w: watchedVideos) {
            recVideos = recVideoDAO.queryByCourseId(w.getCourseId());
            liveSessions = liveSessionDAO.queryByCourseId(w.getCourseId());
            if (!user_find_text.getText().equals("") && user_find_text.getText().equals("recorded")) {
                ArrayList<WatchedVideo> watchedVideos1 = new ArrayList<>();
                RecVideo recVideo;
                for (WatchedVideo w2:watchedVideos) {
                    recVideoDAO = new RecVideoDAOImpl();
                    recVideo = recVideoDAO.queryByCourseId(w2.getCourseId());
                    if (user_find_text.getText().equals("recorded")){
                        watchedVideos1.add(w2);
                    }
                }

                turn_page.setPageCount((int) Math.ceil(watchedVideos1.size()/10.0));
                turn_page.setPageFactory(new Callback<Integer, Node>() {
                    @Override
                    public Node call(Integer param) {
                        VBox vbox = new VBox();
                        int limit = 10;
                        int record = 0;
                        if (param.intValue() == watchedVideos1.size()/10) {
                            limit = watchedVideos1.size()%10;
                        }

                        if(param.intValue() < watchedVideos1.size()/10){
                            RecVideoDAOImpl recVideoDAO;
                            RecVideo recVideo;
                            for (int i =0; i <limit; i++){
                                if (watchedVideos.get(10 * param.intValue() + i).getType().equals("recorded")) {
                                    labelCategory[i].setText(watchedVideos1.get(10 * param.intValue() + i).getType());
                                    recVideoDAO = new RecVideoDAOImpl();
                                    recVideo = recVideoDAO.queryByCourseId(watchedVideos1.get(10 * param.intValue() + i).getCourseId());
                                    labelName[i].setText(recVideo.getSubject());
                                    labelCoach[i].setText(recVideo.getUserName());
                                    labelTime[i].setText(String.valueOf(recVideo.getUploadedTime()));
                                    record += 1;
                                }
                            }
                        } else {
                            RecVideoDAOImpl recVideoDAO;
                            RecVideo recVideo;
                            for (int i =0; i <limit; i++){
                                if (watchedVideos.get(10 * param.intValue() + i).getType().equals("recorded")) {
                                    labelCategory[i].setText(watchedVideos1.get(10 * param.intValue() + i).getType());
                                    recVideoDAO = new RecVideoDAOImpl();
                                    recVideo = recVideoDAO.queryByCourseId(watchedVideos1.get(10 * param.intValue() + i).getCourseId());
                                    labelName[i].setText(recVideo.getSubject());
                                    labelCoach[i].setText(recVideo.getUserName());
                                    labelTime[i].setText(String.valueOf(recVideo.getUploadedTime()));
                                    record += 1;
                                }
                            }
                            for (int i = record; i<10; i++){
                                labelCategory[i].setText("");
                                labelName[i].setText("");
                                labelCoach[i].setText("");
                                labelTime[i].setText("");
                            }
                        }

                        return vbox;
                    }
                });

            }
            if (!user_find_text.getText().equals("") && user_find_text.getText().equals("live")){
                ArrayList<WatchedVideo> watchedVideos1 = new ArrayList<>();
                LiveSession liveSession;
                for (WatchedVideo w2:watchedVideos) {
                    liveSessionDAO = new LiveSessionDAOImpl();

                    liveSession = liveSessionDAO.queryByCourseId(w2.getCourseId());
                    if (user_find_text.getText().equals("live")){
                        watchedVideos1.add(w2);
                    }

                }

                turn_page.setPageCount((int) Math.ceil(watchedVideos1.size()/10.0));
                turn_page.setPageFactory(new Callback<Integer, Node>() {
                    @Override
                    public Node call(Integer param) {
                        VBox vbox = new VBox();
                        int limit = 10;
                        int record = 0;
                        if (param.intValue() == watchedVideos1.size()/10) {
                            limit = watchedVideos1.size()%10;
                        }

                        if(param.intValue() < watchedVideos1.size()/10){
                            LiveSessionDAOImpl liveSessionDAO;
                            LiveSession liveSession;
                            for (int i =0; i <limit; i++){
                                if (watchedVideos.get(10 * param.intValue() + i).getType().equals("live")) {
                                    labelCategory[record].setText(watchedVideos1.get(10 * param.intValue() + i).getType());
                                    liveSessionDAO = new LiveSessionDAOImpl();
                                    liveSession = liveSessionDAO.queryByCourseId(watchedVideos1.get(10 * param.intValue() + i).getCourseId());
                                    labelName[record].setText(liveSession.getSubject());
                                    labelCoach[record].setText(liveSession.getTrainerName());
                                    labelTime[record].setText(String.valueOf(liveSession.getStartTime()));
                                    record += 1;
                                }
                            }
                        } else {
                            LiveSessionDAOImpl liveSessionDAO;
                            LiveSession liveSession;
                            for (int i =0; i <limit; i++){
                                if (watchedVideos.get(10 * param.intValue() + i).getType().equals("live")) {
                                    labelCategory[record].setText(watchedVideos1.get(10 * param.intValue() + i).getType());
                                    liveSessionDAO = new LiveSessionDAOImpl();
                                    liveSession = liveSessionDAO.queryByCourseId(watchedVideos1.get(10 * param.intValue() + i).getCourseId());
                                    labelName[record].setText(liveSession.getSubject());
                                    labelCoach[record].setText(liveSession.getTrainerName());
                                    labelTime[record].setText(String.valueOf(liveSession.getStartTime()));
                                    record += 1;
                                }
                            }
                            for (int i = record; i<10; i++){
                                labelCategory[i].setText("");
                                labelName[i].setText("");
                                labelCoach[i].setText("");
                                labelTime[i].setText("");
                            }
                        }

                        return vbox;
                    }
                });
            }
        }

    }

    @FXML
    void click_turn_page(ActionEvent event) {

    }

    @FXML
    void click_check_yoga(MouseEvent event) {
        if (history_recording_check.isSelected() && !history_live_check.isSelected()) {
            System.out.println("11111111");
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

            ArrayList<WatchedVideo> watchedVideos = watchedVideoDAO.queryByUserName(passValue.getValue());
            turn_page.setPageCount((int) Math.ceil(watchedVideos.size()/10.0));
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox vbox = new VBox();
                    int limit = 10;
                    int record = 0;
                    if (param.intValue() == watchedVideos.size()/10) {
                        limit = watchedVideos.size()%10;
                    }

                    if(param.intValue() < watchedVideos.size()/10){
                        RecVideoDAOImpl recVideoDAO;
                        RecVideo recVideo;
                        for (int i =0; i <limit; i++){
                            if (watchedVideos.get(10 * param.intValue() + i).getType().equals("recorded")) {
                                labelCategory[record].setText(watchedVideos.get(10 * param.intValue() + i).getType());
                                recVideoDAO = new RecVideoDAOImpl();
                                recVideo = recVideoDAO.queryByCourseId(watchedVideos.get(10 * param.intValue() + i).getCourseId());
                                labelName[record].setText(recVideo.getSubject());
                                labelCoach[record].setText(recVideo.getUserName());
                                labelTime[record].setText(String.valueOf(recVideo.getUploadedTime()));
                                record += 1;
                            }
                        }
                    } else {
                        RecVideoDAOImpl recVideoDAO;
                        RecVideo recVideo;
                        for (int i =0; i <limit; i++){
                            if (watchedVideos.get(10 * param.intValue() + i).getType().equals("recorded")) {
                                labelCategory[record].setText(watchedVideos.get(10 * param.intValue() + i).getType());
                                recVideoDAO = new RecVideoDAOImpl();
                                recVideo = recVideoDAO.queryByCourseId(watchedVideos.get(10 * param.intValue() + i).getCourseId());
                                labelName[record].setText(recVideo.getSubject());
                                labelCoach[record].setText(recVideo.getUserName());
                                labelTime[record].setText(String.valueOf(recVideo.getUploadedTime()));
                                record += 1;
                            }
                        }
                        for (int i = record; i<10; i++){
                            labelCategory[i].setText("");
                            labelName[i].setText("");
                            labelCoach[i].setText("");
                            labelTime[i].setText("");
                        }
                    }

                    return vbox;
                }
            });
        }
        else if(!history_recording_check.isSelected() && !history_live_check.isSelected()) {
            click_find(event);
        } else{
            if (history_recording_check.isSelected()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("WARN");
                alert.setContentText("You can only choose one type");
                alert.setHeaderText("WARN");
                alert.showAndWait();
            }
        }


    }

    @FXML
    void click_check_strength(MouseEvent event) {
        if (history_live_check.isSelected() && !history_recording_check.isSelected()) {
            System.out.println("2222222");
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

            ArrayList<WatchedVideo> watchedVideos = watchedVideoDAO.queryByUserName(passValue.getValue());
            turn_page.setPageCount((int) Math.ceil(watchedVideos.size()/10.0));
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox vbox = new VBox();
                    int limit = 10;
                    int record = 0;
                    if (param.intValue() == watchedVideos.size()/10) {
                        limit = watchedVideos.size()%10;
                    }

                    if(param.intValue() < watchedVideos.size()/10){
                        LiveSessionDAOImpl liveSessionDAO;
                        LiveSession liveSession;
                        for (int i =0; i <limit; i++){
                            if (watchedVideos.get(10 * param.intValue() + i).getType().equals("live")) {
                                labelCategory[record].setText(watchedVideos.get(10 * param.intValue() + i).getType());
                                liveSessionDAO = new LiveSessionDAOImpl();
                                liveSession = liveSessionDAO.queryByCourseId(watchedVideos.get(10 * param.intValue() + i).getCourseId());
                                labelName[record].setText(liveSession.getSubject());
                                labelCoach[record].setText(liveSession.getTrainerName());
                                labelTime[record].setText(String.valueOf(liveSession.getStartTime()));
                                record += 1;
                            }
                        }
                    } else {
                        LiveSessionDAOImpl liveSessionDAO;
                        LiveSession liveSession;
                        for (int i =0; i <limit; i++){
                            if (watchedVideos.get(10 * param.intValue() + i).getType().equals("live")) {
                                labelCategory[record].setText(watchedVideos.get(10 * param.intValue() + i).getType());
                                liveSessionDAO = new LiveSessionDAOImpl();
                                liveSession = liveSessionDAO.queryByCourseId(watchedVideos.get(10 * param.intValue() + i).getCourseId());
                                labelName[record].setText(liveSession.getSubject());
                                labelCoach[record].setText(liveSession.getTrainerName());
                                labelTime[record].setText(String.valueOf(liveSession.getStartTime()));
                                record += 1;
                            }
                        }
                        for (int i = record; i<10; i++){
                            labelCategory[i].setText("");
                            labelName[i].setText("");
                            labelCoach[i].setText("");
                            labelTime[i].setText("");
                        }
                    }

                    return vbox;
                }
            });
        }
        else if (!history_recording_check.isSelected() && !history_live_check.isSelected()) {
            click_find(event);
        } else {
            if (history_live_check.isSelected()) {
                if (history_recording_check.isSelected()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("WARN");
                    alert.setContentText("You can only choose one type");
                    alert.setHeaderText("WARN");
                    alert.showAndWait();
                }
            }
        }
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

        ArrayList<WatchedVideo> watchedVideos = watchedVideoDAO.queryByUserName(passValue.getValue());


        turn_page.setPageCount((int) Math.ceil(watchedVideos.size()/10.0));
        turn_page.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                VBox vbox = new VBox();
                int limit = 10;
                if (param.intValue() == watchedVideos.size()/10) {
                    limit = watchedVideos.size()%10;
                }

                if(param.intValue() < watchedVideos.size()/10){
                    LiveSessionDAOImpl liveSessionDAO;
                    LiveSession liveSession;
                    RecVideoDAOImpl recVideoDAO;
                    RecVideo recVideo;
                    for (int i =0; i <limit; i++){
                        labelCategory[i].setText(watchedVideos.get(10 * param.intValue() + i).getType());
                        if (watchedVideos.get(10 * param.intValue() + i).getType().equals("live")) {
                            liveSessionDAO = new LiveSessionDAOImpl();
                            liveSession = liveSessionDAO.queryByCourseId(watchedVideos.get(10 * param.intValue() + i).getCourseId());
                            labelName[i].setText(liveSession.getSubject());
                            labelCoach[i].setText(liveSession.getTrainerName());
                            labelTime[i].setText(String.valueOf(liveSession.getStartTime()));
                        } else {
                            recVideoDAO = new RecVideoDAOImpl();
                            recVideo = recVideoDAO.queryByCourseId(watchedVideos.get(10 * param.intValue() + i).getCourseId());
                            labelName[i].setText(recVideo.getSubject());
                            labelCoach[i].setText(recVideo.getUserName());
                            labelTime[i].setText(String.valueOf(recVideo.getUploadedTime()));
                        }



                    }

                } else {
                    LiveSessionDAOImpl liveSessionDAO;
                    LiveSession liveSession;
                    RecVideoDAOImpl recVideoDAO;
                    RecVideo recVideo;
                    for (int i =0; i <limit; i++){
                        labelCategory[i].setText(watchedVideos.get(10 * param.intValue() + i).getType());
                        if (watchedVideos.get(10 * param.intValue() + i).getType().equals("live")) {
                            liveSessionDAO = new LiveSessionDAOImpl();
                            liveSession = liveSessionDAO.queryByCourseId(watchedVideos.get(10 * param.intValue() + i).getCourseId());
                            labelName[i].setText(liveSession.getSubject());
                            labelCoach[i].setText(liveSession.getTrainerName());
                            labelTime[i].setText(String.valueOf(liveSession.getStartTime()));
                        } else {
                            recVideoDAO = new RecVideoDAOImpl();
                            recVideo = recVideoDAO.queryByCourseId(watchedVideos.get(10 * param.intValue() + i).getCourseId());
                            labelName[i].setText(recVideo.getSubject());
                            labelCoach[i].setText(recVideo.getUserName());
                            labelTime[i].setText(String.valueOf(recVideo.getUploadedTime()));
                        }
                    }
                    for (int i = limit; i<10; i++){
                        labelCategory[i].setText("");
                        labelName[i].setText("");
                        labelCoach[i].setText("");
                        labelTime[i].setText("");
                    }

                }



                return vbox;
            }
        });
    }


}
