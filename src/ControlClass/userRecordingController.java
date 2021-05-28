package ControlClass;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import EntityClass.DAO.impl.RecVideoDAOImpl;
import EntityClass.VO.RecVideo;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class userRecordingController implements Initializable {

    public Label recCoa_hitt2_label;
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

    RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
    ArrayList<RecVideo> recVideos = recVideoDAO.queryAll();

    @FXML
    void user_favorites_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_facorites_hyper.getScene().getWindow();
        new APP().jump(stage, "user_favorites");
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
    void click_find(MouseEvent event) {
        ImageView[] imageViews = new ImageView[6];
        imageViews[0] = user_recPic_yoga1;
        imageViews[1] = user_recPic_yoga2;
        imageViews[2] = user_recPic_hitt1;
        imageViews[3] = user_recPic_hitt2;
        imageViews[4] = user_recPic_strength1;
        imageViews[5] = user_recPic_strength2;

        Label[] labelName = new Label[6];
        labelName[0] = recName_yoga1_label1;
        labelName[1] = recName_yoga2_label;
        labelName[2] = recName_hitt1_label;
        labelName[3] = recName_hitt2_label;
        labelName[4] = recName_strength1_label;
        labelName[5] = recName_strength2_label;

        Label[] labelDur = new Label[6];
        labelDur[0] = recDur_yoga1_label;
        labelDur[1] = recDur_yoga2_label;
        labelDur[2] = recDur_hitt1_label;
        labelDur[3] = recDur_hitt2_label;
        labelDur[4] = recDur_strength1_label;
        labelDur[5] = recDur_strength2_label;

        Label[] labelCoa = new Label[6];
        labelCoa[0] = recCoa_yoga1_label;
        labelCoa[1] = recCoa_yoga2_label;
        labelCoa[2] = recCoa_hitt1_label;
        labelCoa[3] = recCoa_hitt2_label;
        labelCoa[4] = recCoa_strenght1_label;
        labelCoa[5] = recCoa_strenght2_label;

        //nothing enters, return whole list
        if (user_find_text.getText().equals("")) {
            turn_page.setPageCount((int) Math.ceil(recVideos.size()/6.0));
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int limit = 6;
                    if (param.intValue() == recVideos.size()/6) {
                        limit = recVideos.size()%6;
                    }

                    if(param.intValue() < recVideos.size()/6){
                        for (int i =0; i <limit; i++){
                            labelName[i].setText(recVideos.get(6 * param.intValue() + i).getSubject());
                            labelDur[i].setText("Duration: " + String.valueOf(recVideos.get(6 * param.intValue() + i).getLength()));
                            labelCoa[i].setText(recVideos.get(6 * param.intValue() + i).getUserName());
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga2.jpg"));
                        }

                    } else {
                        for (int i =0; i <limit; i++){
                            labelName[i].setText(recVideos.get(6 * param.intValue() + i).getSubject());
                            labelDur[i].setText("Duration: " + String.valueOf(recVideos.get(6 * param.intValue() + i).getLength()));
                            labelCoa[i].setText(recVideos.get(6 * param.intValue() + i).getUserName());
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga3.jpg"));
                        }
                        for (int i = limit; i<6; i++){
                            labelName[i].setText("");
                            labelDur[i].setText("");
                            labelCoa[i].setText("");
                            imageViews[i].setImage(null);
                            System.out.println(i+" test");
                        }

                    }
                    return box;
                }
            });
        }
        //if it doesn't type of viddeos, return nothing
        if (!user_find_text.getText().equals("") && recVideoDAO.queryBySubject(user_find_text.getText()).size() ==0){
            turn_page.setPageCount(1);
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();

                    for (int i = 0; i < 6;i++){
                        labelCoa[i].setText("");
                        labelDur[i].setText("");
                        labelName[i].setText("");
                        imageViews[i].setImage(null);
                    }

                    return box;
                }
            });
        }
        //if it has type, then return this type of the video
        if (!user_find_text.getText().equals("") && recVideoDAO.queryBySubject(user_find_text.getText()).size() >0) {

            ArrayList<RecVideo> recVideoArrayList = recVideoDAO.queryBySubject(user_find_text.getText());
            turn_page.setPageCount((int) Math.ceil(recVideoArrayList.size()/6.0));
            System.out.println(recVideoArrayList.size());
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();

                    int limit = 6;
                    if (param.intValue() == recVideoArrayList.size()/6) {
                        limit = recVideoArrayList.size()%6;
                    }

                    if(param.intValue() < recVideoArrayList.size()/6){
                        for (int i =0; i <limit; i++){
                            labelName[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getSubject());
                            labelDur[i].setText("Duration: " + String.valueOf(recVideoArrayList.get(6 * param.intValue() + i).getLength()));
                            labelCoa[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getUserName());
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga2.jpg"));
                        }

                    } else {
                        for (int i =0; i <limit; i++){
                            labelName[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getSubject());
                            labelDur[i].setText("Duration: " + String.valueOf(recVideoArrayList.get(6 * param.intValue() + i).getLength()));
                            labelCoa[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getUserName());
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga3.jpg"));
                            System.out.println("test");
                        }
                        for (int i = limit; i<6; i++){
                            labelName[i].setText("");
                            labelDur[i].setText("");
                            labelCoa[i].setText("");
                            imageViews[i].setImage(null);
                            System.out.println(i+" test");
                        }

                    }


                    return box;
                }
            });
        }
    }

    @FXML
    void click_turn_page(ActionEvent event) {

    }


    @FXML
    void click_check_yoga(MouseEvent event) {
        if (user_yoga_check.isSelected()){
            ImageView[] imageViews = new ImageView[6];
            imageViews[0] = user_recPic_yoga1;
            imageViews[1] = user_recPic_yoga2;
            imageViews[2] = user_recPic_hitt1;
            imageViews[3] = user_recPic_hitt2;
            imageViews[4] = user_recPic_strength1;
            imageViews[5] = user_recPic_strength2;

            Label[] labelName = new Label[6];
            labelName[0] = recName_yoga1_label1;
            labelName[1] = recName_yoga2_label;
            labelName[2] = recName_hitt1_label;
            labelName[3] = recName_hitt2_label;
            labelName[4] = recName_strength1_label;
            labelName[5] = recName_strength2_label;

            Label[] labelDur = new Label[6];
            labelDur[0] = recDur_yoga1_label;
            labelDur[1] = recDur_yoga2_label;
            labelDur[2] = recDur_hitt1_label;
            labelDur[3] = recDur_hitt2_label;
            labelDur[4] = recDur_strength1_label;
            labelDur[5] = recDur_strength2_label;

            Label[] labelCoa = new Label[6];
            labelCoa[0] = recCoa_yoga1_label;
            labelCoa[1] = recCoa_yoga2_label;
            labelCoa[2] = recCoa_hitt1_label;
            labelCoa[3] = recCoa_hitt2_label;
            labelCoa[4] = recCoa_strenght1_label;
            labelCoa[5] = recCoa_strenght2_label;

            System.out.println(user_yoga_check.getText());

            ArrayList<RecVideo> recVideoArrayList = recVideoDAO.queryBySubject(user_yoga_check.getText());
            turn_page.setPageCount((int) Math.ceil(recVideoArrayList.size()/6.0));
            System.out.println(recVideoArrayList.size());
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();

                    int limit = 6;
                    if (param.intValue() == recVideoArrayList.size()/6) {
                        limit = recVideoArrayList.size()%6;
                    }

                    if(param.intValue() < recVideoArrayList.size()/6){
                        for (int i =0; i <limit; i++){
                            labelName[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getSubject());
                            labelDur[i].setText("Duration: " + String.valueOf(recVideoArrayList.get(6 * param.intValue() + i).getLength()));
                            labelCoa[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getUserName());
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga2.jpg"));
                        }

                    } else {
                        for (int i =0; i <limit; i++){
                            labelName[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getSubject());
                            labelDur[i].setText("Duration: " + String.valueOf(recVideoArrayList.get(6 * param.intValue() + i).getLength()));
                            labelCoa[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getUserName());
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga3.jpg"));
                            System.out.println("test");
                        }
                        for (int i = limit; i<6; i++){
                            labelName[i].setText("");
                            labelDur[i].setText("");
                            labelCoa[i].setText("");
                            imageViews[i].setImage(null);
                            System.out.println(i+" test");
                        }

                    }


                    return box;
                }
            });
        }
    }

    @FXML
    void click_check_strength(MouseEvent event) {
        if (user_strength_check.isSelected()){
            ImageView[] imageViews = new ImageView[6];
            imageViews[0] = user_recPic_yoga1;
            imageViews[1] = user_recPic_yoga2;
            imageViews[2] = user_recPic_hitt1;
            imageViews[3] = user_recPic_hitt2;
            imageViews[4] = user_recPic_strength1;
            imageViews[5] = user_recPic_strength2;

            Label[] labelName = new Label[6];
            labelName[0] = recName_yoga1_label1;
            labelName[1] = recName_yoga2_label;
            labelName[2] = recName_hitt1_label;
            labelName[3] = recName_hitt2_label;
            labelName[4] = recName_strength1_label;
            labelName[5] = recName_strength2_label;

            Label[] labelDur = new Label[6];
            labelDur[0] = recDur_yoga1_label;
            labelDur[1] = recDur_yoga2_label;
            labelDur[2] = recDur_hitt1_label;
            labelDur[3] = recDur_hitt2_label;
            labelDur[4] = recDur_strength1_label;
            labelDur[5] = recDur_strength2_label;

            Label[] labelCoa = new Label[6];
            labelCoa[0] = recCoa_yoga1_label;
            labelCoa[1] = recCoa_yoga2_label;
            labelCoa[2] = recCoa_hitt1_label;
            labelCoa[3] = recCoa_hitt2_label;
            labelCoa[4] = recCoa_strenght1_label;
            labelCoa[5] = recCoa_strenght2_label;


            ArrayList<RecVideo> recVideoArrayList = recVideoDAO.queryBySubject(user_strength_check.getText());
            turn_page.setPageCount((int) Math.ceil(recVideoArrayList.size()/6.0));
            System.out.println(recVideoArrayList.size());
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();

                    int limit = 6;
                    if (param.intValue() == recVideoArrayList.size()/6) {
                        limit = recVideoArrayList.size()%6;
                    }

                    if(param.intValue() < recVideoArrayList.size()/6){
                        for (int i =0; i <limit; i++){
                            labelName[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getSubject());
                            labelDur[i].setText("Duration: " + String.valueOf(recVideoArrayList.get(6 * param.intValue() + i).getLength()));
                            labelCoa[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getUserName());
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga2.jpg"));
                        }

                    } else {
                        for (int i =0; i <limit; i++){
                            labelName[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getSubject());
                            labelDur[i].setText("Duration: " + String.valueOf(recVideoArrayList.get(6 * param.intValue() + i).getLength()));
                            labelCoa[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getUserName());
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga3.jpg"));
                            System.out.println("strength");
                        }
                        for (int i = limit; i<6; i++){
                            labelName[i].setText("");
                            labelDur[i].setText("");
                            labelCoa[i].setText("");
                            imageViews[i].setImage(null);
                            System.out.println(i+" strength");
                        }

                    }


                    return box;
                }
            });
        }
    }

    @FXML
    void click_check_hitt(MouseEvent event) {
        if (user_hitt_check.isSelected()){
            ImageView[] imageViews = new ImageView[6];
            imageViews[0] = user_recPic_yoga1;
            imageViews[1] = user_recPic_yoga2;
            imageViews[2] = user_recPic_hitt1;
            imageViews[3] = user_recPic_hitt2;
            imageViews[4] = user_recPic_strength1;
            imageViews[5] = user_recPic_strength2;

            Label[] labelName = new Label[6];
            labelName[0] = recName_yoga1_label1;
            labelName[1] = recName_yoga2_label;
            labelName[2] = recName_hitt1_label;
            labelName[3] = recName_hitt2_label;
            labelName[4] = recName_strength1_label;
            labelName[5] = recName_strength2_label;

            Label[] labelDur = new Label[6];
            labelDur[0] = recDur_yoga1_label;
            labelDur[1] = recDur_yoga2_label;
            labelDur[2] = recDur_hitt1_label;
            labelDur[3] = recDur_hitt2_label;
            labelDur[4] = recDur_strength1_label;
            labelDur[5] = recDur_strength2_label;

            Label[] labelCoa = new Label[6];
            labelCoa[0] = recCoa_yoga1_label;
            labelCoa[1] = recCoa_yoga2_label;
            labelCoa[2] = recCoa_hitt1_label;
            labelCoa[3] = recCoa_hitt2_label;
            labelCoa[4] = recCoa_strenght1_label;
            labelCoa[5] = recCoa_strenght2_label;

            System.out.println(user_yoga_check.getText());

            ArrayList<RecVideo> recVideoArrayList = recVideoDAO.queryBySubject(user_hitt_check.getText());
            turn_page.setPageCount((int) Math.ceil(recVideoArrayList.size()/6.0));
            System.out.println(recVideoArrayList.size());
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();

                    int limit = 6;
                    if (param.intValue() == recVideoArrayList.size()/6) {
                        limit = recVideoArrayList.size()%6;
                    }

                    if(param.intValue() < recVideoArrayList.size()/6){
                        for (int i =0; i <limit; i++){
                            labelName[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getSubject());
                            labelDur[i].setText("Duration: " + String.valueOf(recVideoArrayList.get(6 * param.intValue() + i).getLength()));
                            labelCoa[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getUserName());
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga2.jpg"));
                        }

                    } else {
                        for (int i =0; i <limit; i++){
                            labelName[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getSubject());
                            labelDur[i].setText("Duration: " + String.valueOf(recVideoArrayList.get(6 * param.intValue() + i).getLength()));
                            labelCoa[i].setText(recVideoArrayList.get(6 * param.intValue() + i).getUserName());
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga3.jpg"));
                            System.out.println("test");
                        }
                        for (int i = limit; i<6; i++){
                            labelName[i].setText("");
                            labelDur[i].setText("");
                            labelCoa[i].setText("");
                            imageViews[i].setImage(null);
                            System.out.println(i+" test");
                        }

                    }


                    return box;
                }
            });
        }
    }

    @FXML
    void click_enterrec1(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_find_button.getScene().getWindow();
        new APP().jump(stage,"user_recording_video");
    }

    @FXML
    void click_enterrec2(ActionEvent event) throws IOException {

    }

    @FXML
    void click_enterrec3(ActionEvent event) throws IOException {

    }

    @FXML
    void click_enterrec4(ActionEvent event) throws IOException {

    }

    @FXML
    void click_enterrec5(ActionEvent event) throws IOException {

    }

    @FXML
    void click_enterrec6(ActionEvent event) throws IOException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

       show();
    }

    public void show(){

        ImageView[] imageViews = new ImageView[6];
        imageViews[0] = user_recPic_yoga1;
        imageViews[1] = user_recPic_yoga2;
        imageViews[2] = user_recPic_hitt1;
        imageViews[3] = user_recPic_hitt2;
        imageViews[4] = user_recPic_strength1;
        imageViews[5] = user_recPic_strength2;

        Label[] labelName = new Label[6];
        labelName[0] = recName_yoga1_label1;
        labelName[1] = recName_yoga2_label;
        labelName[2] = recName_hitt1_label;
        labelName[3] = recName_hitt2_label;
        labelName[4] = recName_strength1_label;
        labelName[5] = recName_strength2_label;

        Label[] labelDur = new Label[6];
        labelDur[0] = recDur_yoga1_label;
        labelDur[1] = recDur_yoga2_label;
        labelDur[2] = recDur_hitt1_label;
        labelDur[3] = recDur_hitt2_label;
        labelDur[4] = recDur_strength1_label;
        labelDur[5] = recDur_strength2_label;

        Label[] labelCoa = new Label[6];
        labelCoa[0] = recCoa_yoga1_label;
        labelCoa[1] = recCoa_yoga2_label;
        labelCoa[2] = recCoa_hitt1_label;
        labelCoa[3] = recCoa_hitt2_label;
        labelCoa[4] = recCoa_strenght1_label;
        labelCoa[5] = recCoa_strenght2_label;

        System.out.println(user_recPic_yoga1.getImage());
//        user_recPic_yoga1.setImage(new Image("resource/yoga3.jpg"));

        turn_page.setPageCount((int) Math.ceil(recVideos.size()/6.0));

        turn_page.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                VBox box = new VBox();
                int limit = 6;
                if (param.intValue() == recVideos.size()/6) {
                    limit = recVideos.size()%6;
                }

                if(param.intValue() < recVideos.size()/6){
                    for (int i =0; i <limit; i++){
                        labelName[i].setText(recVideos.get(6 * param.intValue() + i).getSubject());
                        labelDur[i].setText("Duration: " + String.valueOf(recVideos.get(6 * param.intValue() + i).getLength()));
                        labelCoa[i].setText(recVideos.get(6 * param.intValue() + i).getUserName());
                        imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga2.jpg"));
                    }

                } else {
                    for (int i =0; i <limit; i++){
                        labelName[i].setText(recVideos.get(6 * param.intValue() + i).getSubject());
                        labelDur[i].setText("Duration: " + String.valueOf(recVideos.get(6 * param.intValue() + i).getLength()));
                        labelCoa[i].setText(recVideos.get(6 * param.intValue() + i).getUserName());
                        imageViews[i].setImage(new Image("BoundaryClass/Resource/yoga3.jpg"));
                    }
                    for (int i = limit; i<6; i++){
                        labelName[i].setText("");
                        labelDur[i].setText("");
                        labelCoa[i].setText("");
                        imageViews[i].setImage(null);
                        System.out.println(i+" test");
                    }

                }
                return box;
            }
        });
    }

}
