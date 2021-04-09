package ControlClass;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class APP extends javafx.application.Application{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("../fxml/register.fxml"));
        Scene scene = new Scene(root, 1350, 807);
        stage.setScene(scene);
        stage.show();
    }
}
