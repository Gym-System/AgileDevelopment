package ControlClass;

import EntityClass.DAO.impl.LiveSessionDAOImpl;
import EntityClass.VO.LiveSession;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class userLiveController implements Initializable {
        @FXML
        private Label cost1;

        @FXML
        private Label cost2;

        @FXML
        private Label cost3;
        @FXML
        private Label LiveName_trainer3_label2;

        @FXML
        private Label LiveName_trainer2_label1;

        @FXML
        private Pagination turn_page;

        @FXML
        private Label Live_trainer2_label;

        @FXML
        private Hyperlink user_calendar_hyper;

        @FXML
        private Button user_enterLive_button;

        @FXML
        private Hyperlink user_logout_hyper;

        @FXML
        private Label LiveName_trainer1_label;

        @FXML
        private ImageView logo;

        @FXML
        private Label user_enterLive_trainer;

        @FXML
        private ImageView user_livePic_yoga3;

        @FXML
        private Hyperlink user_live_hyper;

        @FXML
        private ImageView user_profile_pic;

        @FXML
        private CheckBox user_yoga_check;

        @FXML
        private Label user_enterLive_name;

        @FXML
        private Hyperlink user_recording_hyper;

        @FXML
        private Label Live_trainer1_label;

        @FXML
        private Label user_enterLive_time;

        @FXML
        private CheckBox user_hitt_check;

        @FXML
        private Button user_find_button;

        @FXML
        private ImageView user_livePic_strength2;

        @FXML
        private ImageView user_livePic_strength1;

        @FXML
        private Hyperlink user_BookLive_hyper2;

        @FXML
        private Hyperlink user_BookLive_hyper3;

        @FXML
        private Hyperlink user_facorites_hyper;

        @FXML
        private Hyperlink user_history_hyper;

        @FXML
        private TextField user_find_text;

        @FXML
        private CheckBox user_strength_check;

        @FXML
        private Label Live_trainer3_label;

        @FXML
        private Hyperlink user_BookLive_hyper1;

        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        ArrayList<LiveSession> liveSessions = liveSessionDAO.queryAll();

    @FXML
    public void user_favorites_click(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) user_facorites_hyper.getScene().getWindow();
        new APP().jump(stage,"user_favorites");
    }

    @FXML
    public void user_recording_click(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) user_recording_hyper.getScene().getWindow();
        new APP().jump(stage,"user_recording");
    }

    @FXML
    public void user_live_click(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) user_live_hyper.getScene().getWindow();
        new APP().jump(stage,"user_live");
    }

    @FXML
    public void user_calendar_click(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) user_calendar_hyper.getScene().getWindow();
        new APP().jump(stage,"user_calendar");
    }

    @FXML
    public void user_history_click(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) user_history_hyper.getScene().getWindow();
        new APP().jump(stage,"user_history");
    }

    @FXML
    public void user_logout_click(MouseEvent mouseEvent) {
    }

    public void click_find(MouseEvent mouseEvent) {
        ImageView[] imageViews = new ImageView[3];
        imageViews[0] = user_livePic_strength1;
        imageViews[1] = user_livePic_strength2;
        imageViews[2] = user_livePic_yoga3;

        Label[] labelLive = new Label[3];
        labelLive[0] = LiveName_trainer1_label;
        labelLive[1] = LiveName_trainer2_label1;
        labelLive[2] = LiveName_trainer3_label2;

        Label[] labelTrainer = new Label[3];
        labelTrainer[0] = Live_trainer1_label;
        labelTrainer[1] = Live_trainer2_label;
        labelTrainer[2] = Live_trainer3_label;

        Hyperlink[] hyperlinks = new Hyperlink[3];
        hyperlinks[0] = user_BookLive_hyper1;
        hyperlinks[1] = user_BookLive_hyper2;
        hyperlinks[2] = user_BookLive_hyper3;

        //nothing enters, return whole list
        if (user_find_text.getText().equals("")) {
            turn_page.setPageCount((int) Math.ceil(liveSessions.size()/3.0));
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int limit = 3;
                    if (param.intValue() == liveSessions.size()/3) {
                        limit = liveSessions.size()%3;
                    }

                    if(param.intValue() < liveSessions.size()/3){
                        for (int i =0; i <limit; i++){
                            labelLive[i].setText(liveSessions.get(3 * param.intValue() + i).getSubject());
                            labelTrainer[i].setText("Coach: " + liveSessions.get(3 * param.intValue() + i).getTrainerName());
                            hyperlinks[i].setText("Book Live Session");
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga2.jpg"));
                        }

                    } else {
                        for (int i =0; i <limit; i++){
                            labelLive[i].setText(liveSessions.get(3 * param.intValue() + i).getSubject());
                            labelTrainer[i].setText("Coach" + liveSessions.get(3 * param.intValue() + i).getTrainerName());
                            hyperlinks[i].setText("Book Live Session");
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga3.jpg"));
                        }
                        for (int i = limit; i<3; i++){
                            labelLive[i].setText("");
                            labelTrainer[i].setText("");
                            hyperlinks[i].setText("");
                            imageViews[i].setImage(null);
                            System.out.println(i+" test");
                        }

                    }
                    return box;
                }
            });
        }

        //if it doesn't type of viddeos, return nothing
        if (!user_find_text.getText().equals("") && liveSessionDAO.queryByTrainerName(user_find_text.getText()).size() ==0){
            turn_page.setPageCount(1);
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();

                    for (int i = 0; i < 3;i++){
                        labelLive[i].setText("");
                        labelTrainer[i].setText("");
                        hyperlinks[i].setText("");
                        imageViews[i].setImage(null);
                    }

                    return box;
                }
            });
        }

        //if it has type, then return this type of the video
        if (!user_find_text.getText().equals("") && liveSessionDAO.queryByTrainerName(user_find_text.getText()).size() >0) {

            ArrayList<LiveSession> liveSessionArrayList = liveSessionDAO.queryByTrainerName(user_find_text.getText());
            turn_page.setPageCount((int) Math.ceil(liveSessionArrayList.size()/3.0));
            System.out.println(liveSessionArrayList.size());
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();

                    int limit = 3;
                    if (param.intValue() == liveSessionArrayList.size()/3) {
                        limit = liveSessionArrayList.size()%3;
                    }

                    if(param.intValue() < liveSessionArrayList.size()/3){
                        for (int i =0; i <limit; i++){
                            labelLive[i].setText(liveSessions.get(3 * param.intValue() + i).getSubject());
                            labelTrainer[i].setText("Coach: " + liveSessions.get(3 * param.intValue() + i).getTrainerName());
                            hyperlinks[i].setText("Book Live Session");
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga2.jpg"));
                        }

                    } else {
                        for (int i =0; i <limit; i++){
                            labelLive[i].setText(liveSessions.get(3 * param.intValue() + i).getSubject());
                            labelTrainer[i].setText("Coach: " + liveSessions.get(3 * param.intValue() + i).getTrainerName());
                            hyperlinks[i].setText("Book Live Session");
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga2.jpg"));
                            System.out.println("test");
                        }
                        for (int i = limit; i<3; i++){
                            labelLive[i].setText("");
                            labelTrainer[i].setText("");
                            hyperlinks[i].setText("");
                            imageViews[i].setImage(null);
                            System.out.println(i+" test");
                        }

                    }


                    return box;
                }
            });
        }
    }

    public void click_turn_page(MouseEvent mouseEvent) {
    }

    public void click_check_yoga(MouseEvent mouseEvent) {
    }

    public void click_check_strength(MouseEvent mouseEvent) {
    }

    public void click_check_hitt(MouseEvent mouseEvent) {
    }

    public void click_BookLive1(MouseEvent mouseEvent) {
    }

    public void click_BookLive2(MouseEvent mouseEvent) {
    }

    public void click_BookLive3(MouseEvent mouseEvent) {
    }

    public void user_enterLive_click(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        show();
    }

    public void show() {
        ImageView[] imageViews = new ImageView[3];
        imageViews[0] = user_livePic_strength1;
        imageViews[1] = user_livePic_strength2;
        imageViews[2] = user_livePic_yoga3;

        Label[] labelLive = new Label[3];
        labelLive[0] = LiveName_trainer1_label;
        labelLive[1] = LiveName_trainer2_label1;
        labelLive[2] = LiveName_trainer3_label2;

        Label[] labelTrainer = new Label[3];
        labelTrainer[0] = Live_trainer1_label;
        labelTrainer[1] = Live_trainer2_label;
        labelTrainer[2] = Live_trainer3_label;

        Hyperlink[] hyperlinks = new Hyperlink[3];
        hyperlinks[0] = user_BookLive_hyper1;
        hyperlinks[1] = user_BookLive_hyper2;
        hyperlinks[2] = user_BookLive_hyper3;

        turn_page.setPageCount((int) Math.ceil(liveSessions.size()/3.0));

        turn_page.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                VBox box = new VBox();
                int limit = 3;
                if (param.intValue() == liveSessions.size()/3) {
                    limit = liveSessions.size()%3;
                }

                if(param.intValue() < liveSessions.size()/3){
                    for (int i =0; i <limit; i++){
                        labelLive[i].setText(liveSessions.get(3 * param.intValue() + i).getSubject());
                        labelTrainer[i].setText("Coach: " + liveSessions.get(3 * param.intValue() + i).getTrainerName());
                        hyperlinks[i].setText("Book Live Session");
                        imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga2.jpg"));
                    }

                } else {
                    for (int i =0; i <limit; i++){
                        labelLive[i].setText(liveSessions.get(3 * param.intValue() + i).getSubject());
                        labelTrainer[i].setText("Coach" + liveSessions.get(3 * param.intValue() + i).getTrainerName());
                        hyperlinks[i].setText("Book Live Session");
                        imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga3.jpg"));
                    }
                    for (int i = limit; i<3; i++){
                        labelLive[i].setText("");
                        labelTrainer[i].setText("");
                        hyperlinks[i].setText("");
                        imageViews[i].setImage(null);
                        System.out.println(i+" test");
                    }

                }


                return box;
            }
        });
    }
}
