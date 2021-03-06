package ControlClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import EntityClass.DAO.Impl.PhyDataDAOImpl;
import EntityClass.DAO.Impl.TrainerDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;

public class trainerEditInfoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink trainerInfo_upload;

    @FXML
    private ImageView trainerInfo_info;

    @FXML
    private TextField trainer_tel;

    @FXML
    private Button trainer_info_save;

    @FXML
    private Label trainer_salary;

    @FXML
    private TextField trainer_experience;

    @FXML
    private Hyperlink trainerInfo_live;

    @FXML
    private TextArea trainerInfo_cv;

    @FXML
    private TextField trainerInfo_label;

    @FXML
    private Button trainerInfo_photoWall_add;

    @FXML
    private TextField trainer_name;

    @FXML
    private Hyperlink trainerInfo_calendar;

    @FXML
    private Hyperlink trainerInfo_history;

    @FXML
    private Hyperlink trainerInfo_modify;

    @FXML
    private TextField trainer_price;

    @FXML
    private Label trainer_star4;

    @FXML
    private TextField trainer_email;

    @FXML
    private Hyperlink trainerInfo_portrait;

    @FXML
    private Label trainer_star1;

    @FXML
    private Label trainer_star3;

    @FXML
    private Label trainer_star2;

    @FXML
    private Label trainer_star11;

    @FXML
    private Label trainer_course3;

    @FXML
    private Label trainer_course4;

    @FXML
    private Label trainer_course1;

    @FXML
    private TextField trainer_major;

    @FXML
    private Label trainer_course2;

    @FXML
    void trainerInfo_portrait_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainerInfo_label.getScene().getWindow();
        new APP().jump(stage, "trainer_portrait");
    }

    @FXML
    void trainerInfo_upload_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) trainerInfo_label.getScene().getWindow();
        new APP().jump(stage, "trainer_recording");
    }

    @FXML
    void trainerInfo_live_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) trainerInfo_label.getScene().getWindow();
        new APP().jump(stage, "trainer_live");
    }

    @FXML
    void trainerInfo_calendar_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) trainerInfo_label.getScene().getWindow();
        new APP().jump(stage, "tra_trainer_calendar");
    }

    @FXML
    void trainerInfo_history_click(ActionEvent event) throws IOException {
        Stage stage = (Stage) trainerInfo_label.getScene().getWindow();
        new APP().jump(stage, "trainer_history");
    }

    @FXML
    void trainerInfo_info_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainerInfo_label.getScene().getWindow();
        new APP().jump(stage, "TrainerInfo");
    }

    @FXML
    void trainerInfo_modify_click(ActionEvent event) throws IOException {
        TrainerDAOImpl trainerDAO = new TrainerDAOImpl();
        if (!trainer_price.getText().equals("")){
            trainerDAO.changeTrainerPrice(passValue.getValue(),Double.parseDouble(trainer_price.getText()));
        }
        PhyDataDAOImpl phyDataDAO = new PhyDataDAOImpl();
        if(!trainer_major.getText().equals("")){
            phyDataDAO.changePhyDataInterest(passValue.getValue(),trainer_major.getText());
        }
        if(!trainer_tel.getText().equals("")){
            trainerDAO.changeTrainerTeleNo(passValue.getValue(),trainer_tel.getText());
        }
        if(!trainer_email.getText().equals("")){
            trainerDAO.changeTrainerEmail(passValue.getValue(),trainer_email.getText());
        }
        if(!trainer_experience.getText().equals("")){
            phyDataDAO.changePhyDataExperience(passValue.getValue(),Integer.parseInt(trainer_experience.getText()));
        }
        JOptionPane.showInternalMessageDialog(null, "Change successfully","Change successfully!", JOptionPane.INFORMATION_MESSAGE);
        Stage stage = (Stage) trainerInfo_label.getScene().getWindow();
        new APP().jump(stage, "TrainerInfo");
    }

    @FXML
    void trainerInfo_label_click(ActionEvent event) {

    }

    @FXML
    void trainerInfo_cv_click(ActionEvent event) {

    }

    @FXML
    void trainerInfo_photoWall_add_click(ActionEvent event) {

    }

    @FXML
    void Info_save(ActionEvent event) {
        System.out.println("Save successfully");
        String trainername = passValue.getValue();
        TrainerDAOImpl TrainerDAO = new TrainerDAOImpl();
        if(!trainerInfo_label.equals("")){
            TrainerDAO.changeTrainerLabel(trainername,trainerInfo_label.getText());
        }
        if(!trainerInfo_cv.equals("")){
            TrainerDAO.changeTrainerCV(trainername,trainerInfo_cv.getText());
        }
        JOptionPane.showInternalMessageDialog(null, "Change successfully","Change successfully!", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void initialize() {
        assert trainerInfo_upload != null : "fx:id=\"trainerInfo_upload\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainerInfo_info != null : "fx:id=\"trainerInfo_info\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_tel != null : "fx:id=\"trainer_tel\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_info_save != null : "fx:id=\"trainer_info_save\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_salary != null : "fx:id=\"trainer_salary\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_experience != null : "fx:id=\"trainer_experience\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainerInfo_live != null : "fx:id=\"trainerInfo_live\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainerInfo_cv != null : "fx:id=\"trainerInfo_cv\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainerInfo_label != null : "fx:id=\"trainerInfo_label\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainerInfo_photoWall_add != null : "fx:id=\"trainerInfo_photoWall_add\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_name != null : "fx:id=\"trainer_name\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainerInfo_calendar != null : "fx:id=\"trainerInfo_calendar\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainerInfo_history != null : "fx:id=\"trainerInfo_history\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainerInfo_modify != null : "fx:id=\"trainerInfo_modify\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_price != null : "fx:id=\"trainer_gender\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_star4 != null : "fx:id=\"trainer_star4\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_email != null : "fx:id=\"trainer_email\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainerInfo_portrait != null : "fx:id=\"trainerInfo_portrait\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_star1 != null : "fx:id=\"trainer_star1\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_star3 != null : "fx:id=\"trainer_star3\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_star2 != null : "fx:id=\"trainer_star2\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_star11 != null : "fx:id=\"trainer_star11\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_course3 != null : "fx:id=\"trainer_course3\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_course4 != null : "fx:id=\"trainer_course4\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_course1 != null : "fx:id=\"trainer_course1\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_major != null : "fx:id=\"trainer_major\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";
        assert trainer_course2 != null : "fx:id=\"trainer_course2\" was not injected: check your FXML file 'TrainerEditInfo.fxml'.";

    }
}
