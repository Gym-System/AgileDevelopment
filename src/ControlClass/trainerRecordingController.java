package ControlClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;

public class trainerRecordingController {

    public javafx.scene.control.TextField text_upload;
    @FXML
    public Button button_cancel;
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

    @FXML
    private Button button_save;

    final FileChooser fileChooser = new FileChooser();
    private final Desktop desktop = Desktop.getDesktop();

    public trainerRecordingController() {
    }

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
    void user_calendar_click(MouseEvent event) {

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
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("视频","*.mp4")
                    );
            File file = fileChooser.showOpenDialog(stage);
//            System.out.println(file.getPath());
            if (file != null) {
                openFile(file);
            }
        });
    }

    private void openFile(File file) {
        EventQueue.invokeLater(() -> {
//            try {
//                desktop.open(file);
                text_upload.setText(file.getAbsolutePath());
//            } catch (IOException ex) {
//                Logger.getLogger(trainerRecordingController.
//                        class.getName()).
//                        log(Level.SEVERE, null, ex);
//            }
        });
    }


    @FXML
    public void DragOverEvent(DragEvent dragEvent) {

        if (dragEvent.getGestureSource() != text_upload){
            dragEvent.acceptTransferModes(TransferMode.ANY);
        }

    }

    @FXML
    public void DragDroppedEvent(DragEvent dragEvent) {
//        final Logger logger = Logger.getLogger(DragDroppedEvent.class);

        Dragboard dragboard = dragEvent.getDragboard();
        if (dragboard.hasFiles()){
            try {
                File file = dragboard.getFiles().get(0);
                if (file != null) {
                    text_upload.setText(file.getAbsolutePath());
                }
            }catch (Exception e){
//                logger.debug(e.toString());
                System.out.println("wrong");
            }
        }

    }

    @FXML
    public void save_click(MouseEvent mouseEvent) {
        Stage stage = (Stage) button_upload.getScene().getWindow();
        button_save.setOnAction((final ActionEvent e) -> {

            fileChooser.setInitialDirectory(new File("src/resource"));
            fileChooser.setInitialFileName(text_upload.getText());

            File file = fileChooser.showSaveDialog(stage);

            File f1 = new File(text_upload.getText());
            try {
                FileInputStream fin = new FileInputStream(f1);
                byte b[] = new byte[(int)f1.length()];
                fin.read(b);
                FileOutputStream fw = new FileOutputStream(new File("src/resource/1.mp4" ));
                fw.write(b);
                fw.flush();
                fw.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        });

        System.out.println(text_upload.getText());
    }

    @FXML
    public void cancel_click(MouseEvent mouseEvent) {
        text_upload.setText("");
    }
}

