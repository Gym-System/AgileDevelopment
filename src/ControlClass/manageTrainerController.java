package ControlClass;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import EntityClass.DAO.impl.TrainerDAOImpl;
import EntityClass.VO.Trainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class manageTrainerController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label email1_mt;

    @FXML
    private Hyperlink regu_mt;

    @FXML
    private TextField text_find_mt;

    @FXML
    private Button button_delete_mt;

    @FXML
    private Hyperlink trainer_hyplink_mt;

    @FXML
    private TextField add_email_mt;

    @FXML
    private Label password2_mt;

    @FXML
    private Label password4_mt;

    @FXML
    private Hyperlink out_hyplink_mt;

    @FXML
    private Label name3_mt;

    @FXML
    private Label email3_mt;

    @FXML
    private CheckBox box4_mt;

    @FXML
    private Pagination turn_page_mt;

    @FXML
    private Hyperlink income_hyplink_mt;

    @FXML
    private Label password_mt;

    @FXML
    private CheckBox box2_mt;

    @FXML
    private TextField add_password_mt;

    @FXML
    private Label email2_mt;

    @FXML
    private Label name1_mt;

    @FXML
    private Label password1_mt;

    @FXML
    private Label password3_mt;

    @FXML
    private Label email_mt;

    @FXML
    private Hyperlink user_hyplink_mt;

    @FXML
    private TextField add_name_mt;

    @FXML
    private Label name_mt;

    @FXML
    private Label name2_mt;

    @FXML
    private Label email4_mt;

    @FXML
    private Button add_trainer_mt;

    @FXML
    private Label name4_mt;

    @FXML
    private Button button_find_mt;

    @FXML
    private CheckBox box3_mt;

    @FXML
    private CheckBox box1_mt;

    TrainerDAOImpl trainerDAO = new TrainerDAOImpl();
    ArrayList<Trainer> trainers = trainerDAO.queryAll();

    @FXML
    void click_user_hyplink_mt(MouseEvent event) throws IOException {
        Stage stage = (Stage) income_hyplink_mt.getScene().getWindow();
        new APP().jump(stage,"manage_user");
    }

    @FXML
    void click_trainer_hyplink_mt(MouseEvent event) throws IOException {
        Stage stage = (Stage) income_hyplink_mt.getScene().getWindow();
        new APP().jump(stage,"manage_trainer");
    }

    @FXML
    void click_income_hyplink_mt(MouseEvent event) throws IOException {
        Stage stage = (Stage) income_hyplink_mt.getScene().getWindow();
        new APP().jump(stage,"manage_income");

    }

    @FXML
    void click_regu_hyplink_mt(MouseEvent event) throws IOException {
        Stage stage = (Stage) income_hyplink_mt.getScene().getWindow();
        new APP().jump(stage,"manage_regulation");
    }

    @FXML
    void click_out_hyplink_mt(MouseEvent event) throws IOException {
        Stage stage = (Stage) income_hyplink_mt.getScene().getWindow();
        new APP().jump(stage,"login");
    }

    @FXML
    void click_add_trainer_mt(MouseEvent event) {
        if (add_name_mt.getText().equals("") || add_email_mt.getText().equals("") || add_password_mt.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("WARN");
            alert.setContentText("You can only choose one subject");
            alert.setHeaderText("WARN");
            alert.showAndWait();
        } else {
            Label[] names = new Label[4];
            names[0] = name1_mt;
            names[1] = name2_mt;
            names[2] = name3_mt;
            names[3] = name4_mt;
            Label[] emails = new Label[4];
            emails[0] = email1_mt;
            emails[1] = email2_mt;
            emails[2] = email3_mt;
            emails[3] = email4_mt;
            Label[] passwords = new Label[4];
            passwords[0] = password1_mt;
            passwords[1] = password2_mt;
            passwords[2] = password3_mt;
            passwords[3] = password4_mt;
            CheckBox[] checkBoxes = new CheckBox[4];
            checkBoxes[0] = box1_mt;
            checkBoxes[1] = box2_mt;
            checkBoxes[2] = box3_mt;
            checkBoxes[3] = box4_mt;

            boolean flag = true;

            if (add_name_mt.getText().equals("") || !add_email_mt.getText().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$") || !add_password_mt.getText().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,}$")) {
                flag = false;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("WARN");
                if (add_name_mt.getText().equals("")) {
                    alert.setHeaderText("You must enter not empty name");
                }
                if (!add_email_mt.getText().matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")){
                    alert.setHeaderText("You must enter a properly formatted email address");
                }
                if (!add_password_mt.getText().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,}$")){
                    alert.setHeaderText("Passwords should be at least an 8-digit combination of uppercase and lowercase letters and numbers");
                }

                alert.showAndWait();
            }

            if (flag == true) {
                trainerDAO.insertTrainer(new Trainer(add_name_mt.getText(),add_password_mt.getText(),add_email_mt.getText(),"Male","11111111111",new Date(),"London Fitness"));
                ArrayList<Trainer> trainers1 = trainerDAO.queryAll();

                turn_page_mt.setPageCount((int) Math.ceil(trainers1.size()/4.0));
                turn_page_mt.setPageFactory(new Callback<Integer, Node>() {
                    @Override
                    public Node call(Integer param) {
                        VBox box = new VBox();
                        int limit = 4;
                        if (param.intValue() == trainers1.size()/4) {
                            limit = trainers1.size()%4;
                        }

                        if(param.intValue() < trainers.size()/4){
                            for (int i =0; i <limit; i++){
                                names[i].setText(trainers1.get(4 * param.intValue() + i).getUserName());
                                emails[i].setText(trainers1.get(4 * param.intValue() + i).getEmail());
                                passwords[i].setText(trainers1.get(4 * param.intValue() + i).getPassword());
                                checkBoxes[i].setVisible(true);
                            }

                        } else {
                            for (int i =0; i <limit; i++){
                                names[i].setText(trainers1.get(4 * param.intValue() + i).getUserName());
                                emails[i].setText(trainers1.get(4 * param.intValue() + i).getEmail());
                                passwords[i].setText(trainers1.get(4 * param.intValue() + i).getPassword());
                                checkBoxes[i].setVisible(true);
                            }
                            for (int i = limit; i<4; i++){
                                names[i].setText("");
                                emails[i].setText("");
                                passwords[i].setText("");
                                checkBoxes[i].setVisible(false);
                            }

                        }
                        return box;
                    }
                });

                add_name_mt.setText("");
                add_password_mt.setText("");
                add_email_mt.setText("");
            }

        }

    }

    @FXML
    void click_find_mt(MouseEvent event) {
        Label[] names = new Label[4];
        names[0] = name1_mt;
        names[1] = name2_mt;
        names[2] = name3_mt;
        names[3] = name4_mt;
        Label[] emails = new Label[4];
        emails[0] = email1_mt;
        emails[1] = email2_mt;
        emails[2] = email3_mt;
        emails[3] = email4_mt;
        Label[] passwords = new Label[4];
        passwords[0] = password1_mt;
        passwords[1] = password2_mt;
        passwords[2] = password3_mt;
        passwords[3] = password4_mt;
        CheckBox[] checkBoxes = new CheckBox[4];
        checkBoxes[0] = box1_mt;
        checkBoxes[1] = box2_mt;
        checkBoxes[2] = box3_mt;
        checkBoxes[3] = box4_mt;

        ArrayList<Trainer> trainers1 = trainerDAO.queryAll();

        if (text_find_mt.getText().equals("")){
            turn_page_mt.setPageCount((int) Math.ceil(trainers1.size()/4.0));
            turn_page_mt.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int limit = 4;
                    if (param.intValue() == trainers1.size() / 4) {
                        limit = trainers1.size() % 4;
                    }

                    if (param.intValue() < trainers1.size() /4) {
                        for (int i = 0; i < limit; i++) {
                            names[i].setText(trainers1.get(4 * param.intValue() + i).getUserName());
                            emails[i].setText(trainers1.get(4 * param.intValue() + i).getEmail());
                            passwords[i].setText(trainers1.get(4 * param.intValue() + i).getPassword());
                            checkBoxes[i].setVisible(true);
                        }

                    } else {
                        for (int i =0; i <limit; i++){
                            names[i].setText(trainers1.get(4 * param.intValue() + i).getUserName());
                            emails[i].setText(trainers1.get(4 * param.intValue() + i).getEmail());
                            passwords[i].setText(trainers1.get(4 * param.intValue() + i).getPassword());
                            checkBoxes[i].setVisible(true);
                        }
                        for (int i = limit; i < 4; i++) {
                            names[i].setText("");
                            emails[i].setText("");
                            passwords[i].setText("");
                            checkBoxes[i].setVisible(false);
                        }

                    }
                    return box;
                }});
        }

        if (!trainerDAO.queryByUserName(text_find_mt.getText()).getUserName().equals(text_find_mt.getText()) && !text_find_mt.getText().equals("")){
            System.out.println("not same");
            turn_page_mt.setPageCount(1);
            turn_page_mt.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    for (int i = 0; i < 4; i++) {
                        names[i].setText("");
                        emails[i].setText("");
                        passwords[i].setText("");
                        checkBoxes[i].setVisible(false);
                    }
                    return box;
                }
            });
        }

        if (!text_find_mt.getText().equals("") && trainerDAO.queryByUserName(text_find_mt.getText()).getUserName().equals(text_find_mt.getText())){
            turn_page_mt.setPageCount(1);
            turn_page_mt.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int limit = 4;
                    if (param.intValue() == 1 / 4) {
                        limit = 1 % 4;
                    }

                    if (param.intValue() < limit) {
                        for (int i = 0; i < limit; i++) {
                            names[i].setText(trainerDAO.queryByUserName(text_find_mt.getText()).getUserName());
                            emails[i].setText(trainerDAO.queryByUserName(text_find_mt.getText()).getEmail());
                            passwords[i].setText(trainerDAO.queryByUserName(text_find_mt.getText()).getPassword());
                            checkBoxes[i].setVisible(true);
                        }
                        for (int i = limit; i < 4; i++) {
                            names[i].setText("");
                            emails[i].setText("");
                            passwords[i].setText("");
                            checkBoxes[i].setVisible(false);
                        }
                    }

                    return box;
                }


            });
        }
    }

    @FXML
    void click_delete_mt(MouseEvent event) {
        int pageIndex = turn_page_mt.getCurrentPageIndex();
        CheckBox[] checkBoxes = new CheckBox[4];
        checkBoxes[0] = box1_mt;
        checkBoxes[1] = box2_mt;
        checkBoxes[2] = box3_mt;
        checkBoxes[3] = box4_mt;
        ArrayList<Trainer> trainers2 = trainerDAO.queryAll();

        for (int i = 0; i<4; i++){
            System.out.println(checkBoxes[i].isSelected() + "no." +i);
            if (checkBoxes[i].isSelected()){
                int index = (pageIndex * 4 + i + 1);
                System.out.println("第几项 被选中" + index);
                trainerDAO.deleteTrainer(new Trainer(trainers2.get(index-1).getUserName()));
                trainers2.remove(index-1);
                click_find_mt(event);
                checkBoxes[i].setSelected(false);

            }
        }


    }

    @FXML
    void click_turn_page_mt(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        show();
    }

    public void show() {
        Label[] names = new Label[4];
        names[0] = name1_mt;
        names[1] = name2_mt;
        names[2] = name3_mt;
        names[3] = name4_mt;
        Label[] emails = new Label[4];
        emails[0] = email1_mt;
        emails[1] = email2_mt;
        emails[2] = email3_mt;
        emails[3] = email4_mt;
        Label[] passwords = new Label[4];
        passwords[0] = password1_mt;
        passwords[1] = password2_mt;
        passwords[2] = password3_mt;
        passwords[3] = password4_mt;
        CheckBox[] checkBoxes = new CheckBox[4];
        checkBoxes[0] = box1_mt;
        checkBoxes[1] = box2_mt;
        checkBoxes[2] = box3_mt;
        checkBoxes[3] = box4_mt;

        turn_page_mt.setPageCount((int) Math.ceil(trainers.size()/4.0));
        turn_page_mt.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                VBox box = new VBox();
                int limit = 4;
                if (param.intValue() == trainers.size()/4) {
                    limit = trainers.size()%4;
                }

                if(param.intValue() < trainers.size()/4){
                    for (int i =0; i <limit; i++){
                        names[i].setText(trainers.get(4 * param.intValue() + i).getUserName());
                        emails[i].setText(trainers.get(4 * param.intValue() + i).getEmail());
                        passwords[i].setText(trainers.get(4 * param.intValue() + i).getPassword());
                        checkBoxes[i].setVisible(true);
                    }

                } else {
                    for (int i =0; i <limit; i++){
                        names[i].setText(trainers.get(4 * param.intValue() + i).getUserName());
                        emails[i].setText(trainers.get(4 * param.intValue() + i).getEmail());
                        passwords[i].setText(trainers.get(4 * param.intValue() + i).getPassword());
                        checkBoxes[i].setVisible(true);
                    }
                    for (int i = limit; i<4; i++){
                        names[i].setText("");
                        emails[i].setText("");
                        passwords[i].setText("");
                        checkBoxes[i].setVisible(false);
                    }

                }
                return box;
            }
        });
    }
}
