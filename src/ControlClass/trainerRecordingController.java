package ControlClass;

import EntityClass.VO.RecVideo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class trainerRecordingController implements Initializable {

    public javafx.scene.control.TextField text_upload;
    @FXML
    public Button button_cancel;
    @FXML
    public Label trainername_text;
    @FXML
    public ChoiceBox choicebox_type;
    @FXML
    public TextField length_text;
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
//    passValue passValue = new passValue();



//    @FXML
//    void user_favorites_click(ActionEvent event) {
//
//    }

    @FXML
    public void user_favorites_click(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"trainer_portrait");
    }

    @FXML
    void user_recording_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"trainer_recording");
    }

    @FXML
    void user_live_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"trainer_live");
    }

    @FXML
    void user_calendar_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"tra_trainer_calendar");
    }

    @FXML
    void user_history_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"trainer_history");
    }

    @FXML
    void user_logout_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_portrait_hyper.getScene().getWindow();
        new APP().jump(stage,"login");
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
    public void save_click(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) button_upload.getScene().getWindow();

        choicebox_type.setItems(FXCollections.observableArrayList(
                "Yoga", "Hiit", "Strength")
        );
        final String[] greetings = new String[] { "Yoga", "Hiit", "Strength"};

        final String[] type = {""};
        final String[] length = {""};
        final int[] index = new int[1];

        choicebox_type.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val, Number new_val) ->{
                    type[0] = greetings[new_val.intValue()];
                    System.out.println(greetings[new_val.intValue()]);
                }
        );

        button_save.setOnAction((final ActionEvent e) -> {

            RecVideo recVideo = new RecVideo(type[0],Integer.parseInt(length_text.getText()),passValue.getTrainerName());
            System.out.println("11111111");

            fileChooser.setInitialDirectory(new File("src/BoundaryClass/Resource/Video"));
            fileChooser.setInitialFileName(String.valueOf(recVideo.getCourseId()));

            File file = fileChooser.showSaveDialog(stage);
            System.out.println(file+"测试");

            File f1 = new File(text_upload.getText());
            try {
                FileInputStream fin = new FileInputStream(f1);
                byte b[] = new byte[(int)f1.length()];
                fin.read(b);
                FileOutputStream fw = new FileOutputStream(new File("src/BoundaryClass/Resource/Video/"+ recVideo.getCourseId() +".mp4" ));
                fw.write(b);
                fw.flush();
                fw.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                new APP().jump(stage,"trainer_portrait");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });


//        System.out.println(recVideo.getCourseId());
    }

    @FXML
    public void cancel_click(MouseEvent mouseEvent) {
        text_upload.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String trainerName = passValue.getValue();
        passValue.setTrainerName(trainerName);
        trainername_text.setText(passValue.getTrainerName());
        choicebox_type.setItems(FXCollections.observableArrayList(
                "Yoga", "Hiit", "Strength")
        );
//        final String[] greetings = new String[] { "Yoga", "Hiit", "Strength"};
//
//        final String[] type = {""};
//        final String[] length = {""};
//        final int[] index = new int[1];
//
//        choicebox_type.getSelectionModel().selectedIndexProperty().addListener(
//                (ObservableValue<? extends Number> ov,
//                 Number old_val, Number new_val) ->{
//                    type[0] = greetings[new_val.intValue()];
//                    System.out.println(greetings[new_val.intValue()]);
//                }
//        );
//
//
//        RecVideo recVideo = new RecVideo(type[0],Integer.parseInt(length_text.getText()),passValue.getTrainerName());
//        passValue.setUploadCourseID(String.valueOf(recVideo.getCourseId()));

//        RecVideo recVideo = new RecVideo()

    }
}

