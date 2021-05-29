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

    @FXML
    void trainer_portrait_hyper(MouseEvent event){

    }

//    @FXML
//    void user_favorites_click(ActionEvent event) {
//
//    }

    @FXML
    void user_recording_click(MouseEvent event) {

    }

    @FXML
    void user_live_click(MouseEvent event) {

    }

    @FXML
    void user_calendar_click(MouseEvent event) {

    }

    @FXML
    void user_history_click(MouseEvent event) {

    }

    @FXML
    void user_logout_click(MouseEvent event) {

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

        final String[] greetings = new String[] { "Yoga", "Hiit", "Strength"};

        final int[] index = new int[1];
        choicebox_type.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov,
                    Number old_val, Number new_val) ->{
                    System.out.println(greetings[new_val.intValue()]);
                }
        );


        button_save.setOnAction((final ActionEvent e) -> {

            fileChooser.setInitialDirectory(new File("src/BoundaryClass/Resource"));
            fileChooser.setInitialFileName(text_upload.getText());

            File file = fileChooser.showSaveDialog(stage);

            File f1 = new File(text_upload.getText());
            try {
                FileInputStream fin = new FileInputStream(f1);
                byte b[] = new byte[(int)f1.length()];
                fin.read(b);
                FileOutputStream fw = new FileOutputStream(new File("src/BoundaryClass/Resource/1.mp4" ));
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String trainerName = passValue.getValue();
        passValue.setTrainerName(trainerName);
        trainername_text.setText(passValue.getTrainerName());
        choicebox_type.setItems(FXCollections.observableArrayList(
                "Yoga", "Hiit", "Strength")
        );
        final String[] greetings = new String[] { "Yoga", "Hiit", "Strength"};


        final String[] length = {""};
        final int[] index = new int[1];
//        choicebox_type.getSelectionModel().selectedIndexProperty().addListener((ov,oldv,newv)->{
//            length[0] = greetings[newv.intValue()];
//
//        });
        choicebox_type.getSelectionModel().selectedIndexProperty()
                .addListener(new ChangeListener<Number>() {
                    public void changed(ObservableValue ov, Number value, Number new_value) {
                        index[0] = new_value.intValue();
                    }
                });



        length_text.getText();

//        RecVideo recVideo = new RecVideo()

    }
}

