package ControlClass;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import EntityClass.VO.Person;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    void register_button_submit(MouseEvent event) {
        String Flag = "True";

        if (email_address.getText().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")){
            System.out.println("Your email address pattern is correct");
        } else {
            System.out.println("Your email address pattern is wrong");
        }
        if (password_register.getText().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,}$")){
            System.out.println("Your password pattern is correct");
        } else {
            System.out.println("Your password pattern is wrong");
        }
        if (birthdate_register.getValue().isAfter(LocalDate.now())){
            Flag = "False";
            System.out.println(birthdate_register.getValue());
        }
//        Person person = new Person(name_register,confirmpassword_register,email_address,male_register,telephone_number,birthdate_register);
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
