package ControlClass;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import EntityClass.DAO.impl.ManagerDAOImpl;
import EntityClass.DAO.impl.PreUserDAOImpl;
import EntityClass.DAO.impl.TrainerDAOImpl;
import EntityClass.DAO.impl.UserDAOImpl;
import EntityClass.VO.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;

public class loginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button login_button;

    @FXML
    private ImageView user_image;

    @FXML
    private ToggleGroup login_type;

    @FXML
    private RadioButton type_user;

    @FXML
    private ImageView lock_image;

    @FXML
    private Hyperlink no_account;

    @FXML
    private Hyperlink forget_password;

    @FXML
    private PasswordField login_password;

    @FXML
    private RadioButton type_manager;

    @FXML
    private Label password2;

    @FXML
    private Label password1;

    @FXML
    private Label username2;

    @FXML
    private RadioButton type_trainer;

    @FXML
    private Label username1;

    @FXML
    private TextField login_usename;
//    public static passValue model = new passValue();
    @FXML
    void forget_password_click(ActionEvent event){
    }

    @FXML
    void no_account_click(MouseEvent event) throws IOException{
        Stage stage = (Stage) login_password.getScene().getWindow();
        new APP().jump(stage,"register");
    }

    @FXML
    void login_button_submit(ActionEvent event) throws IOException {
        if (type_user.isSelected()) {
            UserDAOImpl userDAO = new UserDAOImpl();
            PreUserDAOImpl preUserDAO = new PreUserDAOImpl();
            boolean flag = true;
            passValue.setValue(login_usename.getText());
            if (login_usename.getText().equals("")) {
                username1.setVisible(true);
                username2.setVisible(false);
                flag = false;
            } else {
                username1.setVisible(false);
                username2.setVisible(false);
            }
            if (login_password.getText().equals("")) {
                password1.setVisible(true);
                password2.setVisible(false);
                flag = false;
            } else {
                password1.setVisible(false);
            }
            if (flag) {
                if (userDAO.queryByUserName(login_usename.getText()) == null && preUserDAO.queryByUserName(login_usename.getText()) ==null) {
                    username2.setVisible(true);
                    username1.setVisible(false);
                } else {
                    String True_password2;
                    if(userDAO.queryByUserName(login_usename.getText())==null){
                        True_password2 = preUserDAO.queryByUserName(login_usename.getText()).getPassword();
                    }else{
                        True_password2 = userDAO.queryByUserName(login_usename.getText()).getPassword(); //get from UserDAO
                    }
                    if (login_password.getText().equals(True_password2)) {
                        Stage stage = (Stage) login_button.getScene().getWindow();
                        new APP().jump(stage, "userInfo");
                    } else {
                        password1.setVisible(false);
                        password2.setVisible(true);

                    }
                }


            }
        }
        else if (type_trainer.isSelected()){
            TrainerDAOImpl trainerDAO = new TrainerDAOImpl();
            boolean flag = true;
            passValue.setValue(login_usename.getText());
            if (login_usename.getText().equals("")) {
                username1.setVisible(true);
                username2.setVisible(false);
                flag = false;
            } else {
                username1.setVisible(false);
                username2.setVisible(false);
            }
            if (login_password.getText().equals("")) {
                password1.setVisible(true);
                password2.setVisible(false);
                flag = false;
            } else {
                password1.setVisible(false);
            }
            if (flag) {
                if (trainerDAO.queryByUserName(login_usename.getText()) == null) {
                    username2.setVisible(true);
                    username1.setVisible(false);
                } else {
                    String True_password = trainerDAO.queryByUserName(login_usename.getText()).getPassword(); //get from UserDAO
                    if (login_password.getText().equals(True_password)) {
                        Stage stage = (Stage) login_button.getScene().getWindow();
                        new APP().jump(stage, "trainer_portrait");
                    } else {
                        password1.setVisible(false);
                        password2.setVisible(true);

                    }
                }


            }
        }
        else if (type_manager.isSelected()){
            ManagerDAOImpl managerDAO = new ManagerDAOImpl();
            boolean flag = true;
            passValue.setValue(login_usename.getText());
            if (login_usename.getText().equals("")) {
                username1.setVisible(true);
                username2.setVisible(false);
                flag = false;
            } else {
                username1.setVisible(false);
                username2.setVisible(false);
            }
            if (login_password.getText().equals("")) {
                password1.setVisible(true);
                password2.setVisible(false);
                flag = false;
            } else {
                password1.setVisible(false);
            }
            if (flag) {
                if (managerDAO.queryByUserName(login_usename.getText()) == null) {
                    username2.setVisible(true);
                    username1.setVisible(false);
                } else {
                    String True_password = managerDAO.queryByUserName(login_usename.getText()).getPassword(); //get from UserDAO
                    if (login_password.getText().equals(True_password)) {
                        Stage stage = (Stage) login_button.getScene().getWindow();
                        new APP().jump(stage, "manage_user");
                    } else {
                        password1.setVisible(false);
                        password2.setVisible(true);

                    }
                }


            }
        }
        else{
            JOptionPane.showInternalMessageDialog(null, "Please select your role","Please select your role", JOptionPane.INFORMATION_MESSAGE);
        }

        }
    @FXML
    void initialize () {
        assert login_button != null : "fx:id=\"login_button\" was not injected: check your FXML file 'login.fxml'.";
        assert user_image != null : "fx:id=\"user_image\" was not injected: check your FXML file 'login.fxml'.";
        assert login_type != null : "fx:id=\"login_type\" was not injected: check your FXML file 'login.fxml'.";
        assert type_user != null : "fx:id=\"type_user\" was not injected: check your FXML file 'login.fxml'.";
        assert lock_image != null : "fx:id=\"lock_image\" was not injected: check your FXML file 'login.fxml'.";
        assert no_account != null : "fx:id=\"no_account\" was not injected: check your FXML file 'login.fxml'.";
        assert forget_password != null : "fx:id=\"forget_password\" was not injected: check your FXML file 'login.fxml'.";
        assert login_password != null : "fx:id=\"login_password\" was not injected: check your FXML file 'login.fxml'.";
        assert type_manager != null : "fx:id=\"type_manager\" was not injected: check your FXML file 'login.fxml'.";
        assert password2 != null : "fx:id=\"password2\" was not injected: check your FXML file 'login.fxml'.";
        assert password1 != null : "fx:id=\"password1\" was not injected: check your FXML file 'login.fxml'.";
        assert username2 != null : "fx:id=\"username2\" was not injected: check your FXML file 'login.fxml'.";
        assert type_trainer != null : "fx:id=\"type_trainer\" was not injected: check your FXML file 'login.fxml'.";
        assert username1 != null : "fx:id=\"username1\" was not injected: check your FXML file 'login.fxml'.";
        assert login_usename != null : "fx:id=\"login_usename\" was not injected: check your FXML file 'login.fxml'.";


    }
    }

