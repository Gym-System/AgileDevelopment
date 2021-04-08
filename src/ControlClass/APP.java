package ControlClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class APP extends javafx.application.Application{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));

//        Image image=new Image("../resource/login.png");
//        pane.getChildren().add(new ImageView(image));


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
