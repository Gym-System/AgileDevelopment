package ControlClass;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class loginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink no_account;

    @FXML
    private Hyperlink forget_password;

    @FXML
    private Button login_button;

    @FXML
    private PasswordField login_password;

    @FXML
    private ImageView user_image;

    @FXML
    private ImageView lock_image;

    @FXML
    private TextField login_usename;

    @FXML
    void forget_password_click(ActionEvent event) {

    }

    @FXML
    void no_account_click(ActionEvent event) {

    }

    @FXML
    void login_button_submit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Complete login!");
        alert.show();
    }

    @FXML
    void initialize() {
        assert no_account != null : "fx:id=\"no_account\" was not injected: check your FXML file 'login.fxml'.";
        assert forget_password != null : "fx:id=\"forget_password\" was not injected: check your FXML file 'login.fxml'.";
        assert login_button != null : "fx:id=\"login_button\" was not injected: check your FXML file 'login.fxml'.";
        assert login_password != null : "fx:id=\"login_password\" was not injected: check your FXML file 'login.fxml'.";
        assert login_usename != null : "fx:id=\"login_usename\" was not injected: check your FXML file 'login.fxml'.";

    }

}