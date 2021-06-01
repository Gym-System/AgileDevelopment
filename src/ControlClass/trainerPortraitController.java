package ControlClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import EntityClass.DAO.Impl.TrainerDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class trainerPortraitController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane label_grid;

    @FXML
    private Text trainer_portrait_name;

    @FXML
    private Label recName_hitt2_label;

    @FXML
    private ImageView user_recPic_hitt2;

    @FXML
    private ImageView user_recPic_yoga1;

    @FXML
    private Hyperlink trainer_logout_hyper;

    @FXML
    private Hyperlink trainer_portrait_recEnter_yoga1_hyper1;

    @FXML
    private ImageView user_recPic_yoga2;

    @FXML
    private Hyperlink trainer_portrait_calendar;

    @FXML
    private Label recDur_hitt2_label;

    @FXML
    private Label trainer_portrait_recDur_yoga2_label;

    @FXML
    private Hyperlink trainer_portrait_portrait;

    @FXML
    private Label recCoa_strenght2_label;

    @FXML
    private Label trainer_portrait_recCoa_yoga1_label;

    @FXML
    private Label trainer_portrait_recName_yoga2_label;

    @FXML
    private ImageView user_recPic_strength1;

    @FXML
    private Hyperlink trainer_portrait_user_recEnter_hyper4;

    @FXML
    private Label recDur_strength1_label;

    @FXML
    private Label trainer_portrait_recName_yoga1_label1;

    @FXML
    private Label recCoa_hitt2_label;

    @FXML
    private TextArea trainer_portrait_text;

    @FXML
    private Label recName_hitt1_label;

    @FXML
    private Hyperlink trainer_portrait_live;

    @FXML
    private Label recName_strength2_label;

    @FXML
    private ImageView trainer_portrait_pic2;

    @FXML
    private ImageView user_recPic_strength2;

    @FXML
    private Label trainer_portrait_recCoa_yoga2_label;

    @FXML
    private ImageView trainer_portrait_pic3;

    @FXML
    private Label recCoa_hitt1_label;

    @FXML
    private ImageView trainer_portrait_pic1;

    @FXML
    private Label recDur_strength2_label;

    @FXML
    private ImageView trainer_portrait_info;

    @FXML
    private Hyperlink trainer_portrait_user_recEnter_hyper5111;

    @FXML
    private Label trainer_portrait_recDur_yoga1_label;

    @FXML
    private Pagination trainer_recording_display;

    @FXML
    private Hyperlink trainer_portrait_recEnter_yoga2_hyper1;

    @FXML
    private Hyperlink trainer_portrait_user_recEnter_hyper31;

    @FXML
    private Label trainer_portrait_label3;

    @FXML
    private Label recCoa_strenght1_label;

    @FXML
    private Label trainer_portrait_label2;

    @FXML
    private Label trainer_portrait_label5;

    @FXML
    private ImageView user_recPic_hitt1;

    @FXML
    private Label trainer_portrait_label4;

    @FXML
    private Label recDur_hitt1_label;

    @FXML
    private Hyperlink trainer_portrait_upload;

    @FXML
    private Hyperlink trainer_portrait_bookLiveSession;

    @FXML
    private Label recName_strength1_label;

    @FXML
    private Label trainer_portrait_label1;

    @FXML
    private Hyperlink trainer_portrait_history;

    @FXML
    private Hyperlink user_recEnter_hyper611;

    @FXML
    void trainer_portrait_portrait_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) trainer_logout_hyper.getScene().getWindow();
        new APP().jump(stage, "trainer_portrait");
    }

    @FXML
    void trainer_portrait_upload_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) trainer_logout_hyper.getScene().getWindow();
        new APP().jump(stage, "trainer_recording");
    }

    @FXML
    void trainer_portrait_live_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) trainer_logout_hyper.getScene().getWindow();
        new APP().jump(stage, "trainer_live");
    }

    @FXML
    void trainer_portrait_calendar_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) trainer_logout_hyper.getScene().getWindow();
        new APP().jump(stage, "tra_trainer_calendar");
    }

    @FXML
    void trainer_portrait_history_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) trainer_logout_hyper.getScene().getWindow();
        new APP().jump(stage, "trainer_history");
    }


    @FXML
    void trainer_portrait_bookLiveSession_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_logout_hyper.getScene().getWindow();
        new APP().jump(stage, "tra_trainer_calendar");

    }

    @FXML
    void click_turn_page(ActionEvent event) {

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
    void trainer_logout_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_logout_hyper.getScene().getWindow();
        new APP().jump(stage, "login");
    }

    @FXML
    void initialize() {
        assert trainer_portrait_name != null : "fx:id=\"trainer_portrait_name\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert recName_hitt2_label != null : "fx:id=\"recName_hitt2_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert user_recPic_hitt2 != null : "fx:id=\"user_recPic_hitt2\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert user_recPic_yoga1 != null : "fx:id=\"user_recPic_yoga1\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_recEnter_yoga1_hyper1 != null : "fx:id=\"trainer_portrait_recEnter_yoga1_hyper1\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert user_recPic_yoga2 != null : "fx:id=\"user_recPic_yoga2\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_calendar != null : "fx:id=\"trainer_portrait_calendar\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert recDur_hitt2_label != null : "fx:id=\"recDur_hitt2_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_recDur_yoga2_label != null : "fx:id=\"trainer_portrait_recDur_yoga2_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_portrait != null : "fx:id=\"trainer_portrait_portrait\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert recCoa_strenght2_label != null : "fx:id=\"recCoa_strenght2_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert label_grid != null : "fx:id=\"label_grid\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_recCoa_yoga1_label != null : "fx:id=\"trainer_portrait_recCoa_yoga1_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_recName_yoga2_label != null : "fx:id=\"trainer_portrait_recName_yoga2_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert user_recPic_strength1 != null : "fx:id=\"user_recPic_strength1\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_user_recEnter_hyper4 != null : "fx:id=\"trainer_portrait_user_recEnter_hyper4\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert recDur_strength1_label != null : "fx:id=\"recDur_strength1_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_recName_yoga1_label1 != null : "fx:id=\"trainer_portrait_recName_yoga1_label1\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert recCoa_hitt2_label != null : "fx:id=\"recCoa_hitt2_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_text != null : "fx:id=\"trainer_portrait_text\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert recName_hitt1_label != null : "fx:id=\"recName_hitt1_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_live != null : "fx:id=\"trainer_portrait_live\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert recName_strength2_label != null : "fx:id=\"recName_strength2_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_pic2 != null : "fx:id=\"trainer_portrait_pic2\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert user_recPic_strength2 != null : "fx:id=\"user_recPic_strength2\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_recCoa_yoga2_label != null : "fx:id=\"trainer_portrait_recCoa_yoga2_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_pic3 != null : "fx:id=\"trainer_portrait_pic3\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_logout_hyper != null : "fx:id=\"trainer_logout_hyper\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert recCoa_hitt1_label != null : "fx:id=\"recCoa_hitt1_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_pic1 != null : "fx:id=\"trainer_portrait_pic1\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert recDur_strength2_label != null : "fx:id=\"recDur_strength2_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_info != null : "fx:id=\"trainer_portrait_info\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_user_recEnter_hyper5111 != null : "fx:id=\"trainer_portrait_user_recEnter_hyper5111\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_recDur_yoga1_label != null : "fx:id=\"trainer_portrait_recDur_yoga1_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_recording_display != null : "fx:id=\"trainer_recording_display\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_recEnter_yoga2_hyper1 != null : "fx:id=\"trainer_portrait_recEnter_yoga2_hyper1\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_user_recEnter_hyper31 != null : "fx:id=\"trainer_portrait_user_recEnter_hyper31\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert recCoa_strenght1_label != null : "fx:id=\"recCoa_strenght1_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert user_recPic_hitt1 != null : "fx:id=\"user_recPic_hitt1\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert recDur_hitt1_label != null : "fx:id=\"recDur_hitt1_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_upload != null : "fx:id=\"trainer_portrait_upload\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_bookLiveSession != null : "fx:id=\"trainer_portrait_bookLiveSession\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert recName_strength1_label != null : "fx:id=\"recName_strength1_label\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert trainer_portrait_history != null : "fx:id=\"trainer_portrait_history\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        assert user_recEnter_hyper611 != null : "fx:id=\"user_recEnter_hyper611\" was not injected: check your FXML file 'trainer_portrait.fxml'.";
        TrainerDAOImpl TrainerDAO = new TrainerDAOImpl();
        trainer_portrait_name.setText(TrainerDAO.queryByUserName("kaiyi").getUserName());
        passValue.setTrainerName(trainer_portrait_name.getText());
        String [] str = new String [5];
        str=TrainerDAO.queryByUserName(passValue.getValue()).getLabel();
        int count=0;
        for (String Trainerlabel:str){
            Label textlabel = new Label();
            textlabel.setText(Trainerlabel);
            textlabel.setBackground(new Background(new BackgroundFill(Color.GRAY,null,null)));
            textlabel.setFont(Font.font(30));
            textlabel.setTextFill(Color.WHITE);
            label_grid.add(textlabel,count,0);
            count++;
        }
        trainer_portrait_text.setText(TrainerDAO.queryByUserName(passValue.getValue()).getCV());

    }

    public void trainer_portrait_info_click(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) trainer_logout_hyper.getScene().getWindow();
        new APP().jump(stage, "TrainerInfo");
    }

    public void trainer_portrait_info_click2(MouseEvent mouseEvent) {
    }

    public void trainer_portrait_info_click1(MouseEvent mouseEvent) {
    }

    public void trainer_portrait_info_click3(MouseEvent mouseEvent) {
    }
}
