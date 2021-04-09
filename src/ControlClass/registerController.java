package ControlClass;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class registerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    void register_button_submit(ActionEvent event) {

    }

    @FXML
    void this_condition(ActionEvent event) {

    }

    @FXML
    void have_account(ActionEvent event) {

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
