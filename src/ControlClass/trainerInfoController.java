package ControlClass;

import java.net.URL;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.ResourceBundle;

import EntityClass.DAO.impl.LiveSessionDAOImpl;
import EntityClass.DAO.impl.PhyDataDAOImpl;
import EntityClass.DAO.impl.TrainerDAOImpl;
import EntityClass.VO.LiveSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;

public class trainerInfoController {

    @FXML
    private Hyperlink trainerInfo_upload;

    @FXML
    private Label trainer_height;

    @FXML
    private ImageView trainerInfo_info;

    @FXML
    private Hyperlink trainerInfo_details;

    @FXML
    private Label trainer_weight;

    @FXML
    private Hyperlink trainerInfo_calendar;

    @FXML
    private Hyperlink trainerInfo_history;

    @FXML
    private Hyperlink trainerInfo_modify;

    @FXML
    private Label trainer_gender;

    @FXML
    private Label trainer_experience;

    @FXML
    private Label trainer_star4;

    @FXML
    private Label trainer_email;

    @FXML
    private Hyperlink trainerInfo_portrait;

    @FXML
    private Hyperlink trainerInfo_live;

    @FXML
    private Label trainer_star1;

    @FXML
    private Label trainer_star3;

    @FXML
    private Label trainer_star2;

    @FXML
    private Label trainer_star11;

    @FXML
    private Label trainer_name;

    private ArrayList<Label> trainer_courses = new ArrayList<>();

    private ArrayList<Label> trainer_stars= new ArrayList<>();
    @FXML
    private Label trainer_course3;

    @FXML
    private Label trainer_course4;

    @FXML
    private Label trainer_course1;

    @FXML
    private Label trainer_major;

    @FXML
    private Label trainer_course2;

    @FXML
    void trainerInfo_portrait_click(ActionEvent event) {

    }

    @FXML
    void trainerInfo_upload_click(ActionEvent event) {

    }

    @FXML
    void trainerInfo_live_click(ActionEvent event) {

    }

    @FXML
    void trainerInfo_calendar_click(ActionEvent event) {

    }

    @FXML
    void trainerInfo_history_click(ActionEvent event) {

    }

    @FXML
    void trainerInfo_info_click(ActionEvent event) {

    }

    @FXML
    void trainerInfo_modify_click(ActionEvent event) {

    }

    @FXML
    void trainerInfo_details_click(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert trainerInfo_upload != null : "fx:id=\"trainerInfo_upload\" was not injected: check your FXML file 'TrainerInfo.fxml'.";
        assert trainerInfo_history != null : "fx:id=\"trainerInfo_history\" was not injected: check your FXML file 'TrainerInfo.fxml'.";
        assert trainerInfo_modify != null : "fx:id=\"trainerInfo_modify\" was not injected: check your FXML file 'TrainerInfo.fxml'.";
        assert trainerInfo_info != null : "fx:id=\"trainerInfo_info\" was not injected: check your FXML file 'TrainerInfo.fxml'.";
        assert trainerInfo_details != null : "fx:id=\"trainerInfo_details\" was not injected: check your FXML file 'TrainerInfo.fxml'.";
        assert trainerInfo_portrait != null : "fx:id=\"trainerInfo_portrait\" was not injected: check your FXML file 'TrainerInfo.fxml'.";
        assert trainerInfo_live != null : "fx:id=\"trainerInfo_live\" was not injected: check your FXML file 'TrainerInfo.fxml'.";
        assert trainerInfo_calendar != null : "fx:id=\"trainerInfo_calendar\" was not injected: check your FXML file 'TrainerInfo.fxml'.";
        String trainername = passValue.getValue();
        TrainerDAOImpl trainerDAO = new TrainerDAOImpl();
        PhyDataDAOImpl phyDataDAO = new PhyDataDAOImpl();
        trainer_name.setText(trainerDAO.queryByUserName(trainername).getUserName());
        trainer_gender.setText(trainerDAO.queryByUserName(trainername).getGender());
        trainer_major.setText(phyDataDAO.queryByUserName(trainername).getInterest());
        trainer_email.setText(trainerDAO.queryByUserName(trainername).getEmail());
        trainer_weight.setText(Double.toString(phyDataDAO.queryByUserName(trainername).getWeight())+" kg");
        trainer_height.setText(Double.toString(phyDataDAO.queryByUserName(trainername).getHeight())+" cm");
        trainer_experience.setText(Integer.toString(phyDataDAO.queryByUserName(trainername).getExperience()));
        int i=1;
        LiveSessionDAOImpl liveSessionDAO = new LiveSessionDAOImpl();
        ArrayList<LiveSession> live = liveSessionDAO.queryByTrainerName("kaiyi1");//接口存在问题
        trainer_courses.add(trainer_course1);
        trainer_courses.add(trainer_course2);
        trainer_courses.add(trainer_course3);
        trainer_courses.add(trainer_course4);
        trainer_stars.add(trainer_star1);
        trainer_stars.add(trainer_star2);
        trainer_stars.add(trainer_star3);
        trainer_stars.add(trainer_star4);
        System.out.println(live);
        for(i=0;i<=3;i++){
            if(trainer_courses.get(i)==null){
                break;
            }
            else{
                trainer_courses.get(i).setText(live.get(i).getSubject());
                trainer_stars.get(i).setText(Double.toString(live.get(i).getStar()));
            }


        }

    }
}
