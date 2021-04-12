package ControlClass;

import java.awt.event.ActionEvent;
import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.scene.control.Hyperlink;
        import javafx.scene.image.ImageView;

public class trainerInfoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink trainerInfo_upload;

    @FXML
    private Hyperlink trainerInfo_history;

    @FXML
    private Hyperlink trainerInfo_modify;

    @FXML
    private ImageView trainerInfo_info;

    @FXML
    private Hyperlink trainerInfo_details;

    @FXML
    private Hyperlink trainerInfo_portrait;

    @FXML
    private Hyperlink trainerInfo_live;

    @FXML
    private Hyperlink trainerInfo_calendar;

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

    }
}
