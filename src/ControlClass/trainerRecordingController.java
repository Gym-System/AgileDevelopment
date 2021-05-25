package ControlClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class trainerRecordingController {

    @FXML
    private Hyperlink trainer_portrait_hyper;

    @FXML
    private Hyperlink trainer_calendar_hyper;

    @FXML
    private Hyperlink trainer_live_hyper;

    @FXML
    private Hyperlink trainer_logout_hyper;

    @FXML
    private Hyperlink trainer_upload_hyper;

    @FXML
    private Hyperlink trainer_rules_hyper;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView trainer_profile_pic;

    @FXML
    private Button button_upload;

    final FileChooser fileChooser = new FileChooser();
    private final Desktop desktop = Desktop.getDesktop();
    @FXML
    void user_favorites_click(ActionEvent event) {

    }

    @FXML
    void user_recording_click(ActionEvent event) {

    }

    @FXML
    void user_live_click(ActionEvent event) {

    }

    @FXML
    void user_calendar_click(ActionEvent event) {

    }

    @FXML
    void user_history_click(ActionEvent event) {

    }

    @FXML
    void user_logout_click(ActionEvent event) {

    }

    public void user_favorites_click(MouseEvent mouseEvent) {
    }


    public void upload_click(MouseEvent mouseEvent) {
        Stage stage = (Stage) button_upload.getScene().getWindow();
        button_upload.setOnAction((final ActionEvent e) -> {
            File file = fileChooser.showOpenDialog(stage);
            System.out.println(file.getPath());
            if (file != null) {
                openFile(file);
            }
        });
    }

    private void openFile(File file) {
        EventQueue.invokeLater(() -> {
            try {
                desktop.open(file);
            } catch (IOException ex) {
                Logger.getLogger(trainerRecordingController.
                        class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        });
    }
}

