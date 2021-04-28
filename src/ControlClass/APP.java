package ControlClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class APP extends javafx.application.Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(getClass().getResource("../fxml/user_recording_video.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/user_recording_video.fxml"));
        Scene scene = new Scene(root, 1350, 807);
//        passValue.setStage(primaryStage);
//        System.out.println(passValue.getStage());
        primaryStage.setScene(scene);

//        passValue.setStage(primaryStage);

        primaryStage.show();



    }



    public void jump(Stage stage,String path) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/"+path+".fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
