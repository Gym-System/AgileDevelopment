package ControlClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import EntityClass.DAO.UserDAO;
import EntityClass.DAO.impl.UserDAOImpl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;

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
    void forget_password_click(ActionEvent event){
    }

    @FXML
    void no_account_click(ActionEvent event) throws IOException{
        Stage stage = (Stage) login_button.getScene().getWindow();
        new APP().jump(stage,"register");
    }

    @FXML
    void login_button_submit(ActionEvent event) throws IOException {
        UserDAOImpl userDAO = new UserDAOImpl();
        if(login_usename.getText().equals("")){
            JOptionPane.showMessageDialog(null, "The username cannot be empty", "Username is null", JOptionPane.ERROR_MESSAGE);
        }
        else if(login_password.getText().equals("")){
            JOptionPane.showMessageDialog(null, "The password cannot be empty", "Password is null", JOptionPane.ERROR_MESSAGE);
        }
        else {
            String True_password= userDAO.queryByUserName(login_usename.getText()).getPassword(); //get from UserDAO
            if(login_password.getText().equals(True_password))
            {
                Stage stage = (Stage) login_button.getScene().getWindow();
                new APP().jump(stage,"12");
            }
            else{
                JOptionPane.showMessageDialog(null, "Please enter the correct password", "Password is wrong", JOptionPane.ERROR_MESSAGE);
            }

        }



    }

    @FXML
    void initialize() {
        assert no_account != null : "fx:id=\"no_account\" was not injected: check your FXML file 'login.fxml'.";
        assert forget_password != null : "fx:id=\"forget_password\" was not injected: check your FXML file 'login.fxml'.";
        assert login_button != null : "fx:id=\"login_button\" was not injected: check your FXML file 'login.fxml'.";
        assert login_password != null : "fx:id=\"login_password\" was not injected: check your FXML file 'login.fxml'.";
        assert login_usename != null : "fx:id=\"login_usename\" was not injected: check your FXML file 'login.fxml'.";

    }

    @FXML
    public void getUsername(ActionEvent actionEvent) {


    }
}
