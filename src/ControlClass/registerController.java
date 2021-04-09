package ControlClass;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

import EntityClass.DAO.impl.UserDAOImpl;
import EntityClass.VO.Person;
import EntityClass.VO.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class registerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label username_label;

    @FXML
    private TextField name_register;

    @FXML
    private ToggleGroup gender;

    @FXML
    private PasswordField confirmpassword_register;

    @FXML
    private Hyperlink condition_register;

    @FXML
    private PasswordField password_register;

    @FXML
    private TextField telephone_number;

    @FXML
    private RadioButton female_register;

    @FXML
    private Button register_button;

    @FXML
    private DatePicker birthdate_register;

    @FXML
    private TextField email_address;

    @FXML
    private RadioButton male_register;

    @FXML
    private CheckBox accept_register;

    @FXML
    private Hyperlink haveaccount_register;

    @FXML
    private Label email_label;

    @FXML
    private Label gender_label;

    @FXML
    private Label confirm_label;

    @FXML
    private Label birth_label;

    @FXML
    private Label password_label;

    @FXML
    private Label TelNo_label;

    @FXML
    private Label userName_label;

    @FXML
    private Label accept_label;

    @FXML
    void register_button_submit(MouseEvent event) throws ParseException, IOException {
        String Flag = "True";

        UserDAOImpl userDAO = new UserDAOImpl();

        if (!(userDAO.queryByUserName(name_register.getText()) == null)){
            new APP().jump((Stage) userName_label.getScene().getWindow(),"login");
        }
        if (name_register.getText().equals("")) {
            userName_label.setVisible(true);
            Flag = "False";
        } else {
            userName_label.setVisible(false);
        }
        if (!email_address.getText().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$") || email_address.getText().equals("")){
            email_label.setVisible(true);

            Flag = "False";
        } else {
            email_label.setVisible(false);
        }
        if (!(male_register.isSelected() || female_register.isSelected())){
            gender_label.setVisible(true);
        }else {
            gender_label.setVisible(false);
        }
        if (!password_register.getText().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,}$") || password_register.getText().equals("")) {
        password_label.setVisible(true);
        Flag = "False";
        } else {
            password_label.setVisible(false);
        }
        if(!password_register.getText().equals(confirmpassword_register.getText()) || confirmpassword_register.getText().equals("")){
        confirm_label.setVisible(true);
        Flag = "False";
        } else {
            confirm_label.setVisible(false);
        }
        if(birthdate_register.getValue() == null ) {
        birth_label.setVisible(true);
        Flag = "False";

        } else {
            if (!birthdate_register.getValue().isBefore(LocalDate.now())) {
                birth_label.setVisible(true);
                Flag = "False";
            }else {
                birth_label.setVisible(false);
            }
        }
        if (!telephone_number.getText().matches("^(1[0-9])\\d{9}$") || telephone_number.getText().equals("")) {
            TelNo_label.setVisible(true);
            Flag = "False";
        } else {
            TelNo_label.setVisible(false);
        }
        if (!accept_register.isSelected()){
            accept_label.setVisible(true);
        } else {
            accept_label.setVisible(false);
        }

        if (Flag.equals("True")){
            User user = new User(name_register.getText(),password_register.getText(),email_address.getText(),male_register.getText(),telephone_number.getText(),
                    new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(birthdate_register.getValue())));
            userDAO.insertUser(user);
            System.out.println("User is created");
            new APP().jump((Stage) userName_label.getScene().getWindow(),"login");
        }


    }

    @FXML
    void this_condition(MouseEvent event) {

    }

    @FXML
    void have_account(MouseEvent event) throws IOException {
        Stage stage = (Stage) haveaccount_register.getScene().getWindow();
        new APP().jump(stage,"login");
    }

    @FXML
    void initialize() {
        assert name_register != null : "fx:id=\"name_register\" was not injected: check your FXML file 'register.fxml'.";
        assert gender != null : "fx:id=\"gender\" was not injected: check your FXML file 'register.fxml'.";
        assert confirmpassword_register != null : "fx:id=\"confirmpassword_register\" was not injected: check your FXML file 'register.fxml'.";
        assert condition_register != null : "fx:id=\"condition_register\" was not injected: check your FXML file 'register.fxml'.";
        assert password_register != null : "fx:id=\"password_register\" was not injected: check your FXML file 'register.fxml'.";
        assert telephone_number != null : "fx:id=\"telephone_number\" was not injected: check your FXML file 'register.fxml'.";
        assert female_register != null : "fx:id=\"female_register\" was not injected: check your FXML file 'register.fxml'.";
        assert register_button != null : "fx:id=\"register_button\" was not injected: check your FXML file 'register.fxml'.";
        assert birthdate_register != null : "fx:id=\"birthdate_register\" was not injected: check your FXML file 'register.fxml'.";
        assert email_address != null : "fx:id=\"email_address\" was not injected: check your FXML file 'register.fxml'.";
        assert male_register != null : "fx:id=\"male_register\" was not injected: check your FXML file 'register.fxml'.";
        assert accept_register != null : "fx:id=\"accept_register\" was not injected: check your FXML file 'register.fxml'.";
        assert haveaccount_register != null : "fx:id=\"haveaccount_register\" was not injected: check your FXML file 'register.fxml'.";

    }
}
