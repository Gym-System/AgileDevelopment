package ControlClass;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import EntityClass.DAO.Impl.UserDAOImpl;
import EntityClass.VO.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;

public class manageUserController  {


    public GridPane userInfo_gridpane;
    Label name0 = new Label();
    Label name1 = new Label();
    Label name2 = new Label();
    Label name3 = new Label();
    Label name4 = new Label();
    Label email0 = new Label();
    Label email1 = new Label();
    Label email2 = new Label();
    Label email3 = new Label();
    Label email4 = new Label();
    Label password0 = new Label();
    Label password1 = new Label();
    Label password2 = new Label();
    Label password3 = new Label();
    Label password4 = new Label();
    Label[] names = new Label[5];
    Label[] emails = new Label[5];
    Label[] passwords = new Label[5];
    CheckBox[] checkBoxes = new CheckBox[5];



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label email1_mu;

    @FXML
    private TextField text_find_mu;

    @FXML
    private Hyperlink trainer_hyplink_mu;

    @FXML
    private Label email3_mu;

    @FXML
    private Label name2_mu;

    @FXML
    private Hyperlink regu_mu;

    @FXML
    private Pagination turn_page;

    @FXML
    private Button button_delete_mu;

    @FXML
    private Label password2_mu;

    @FXML
    private Label password4_mu;

    @FXML
    private Hyperlink out_hyplink_mu;

    @FXML
    private Hyperlink income_hyplink_mu;

    @FXML
    private Label name3_mu;

    @FXML
    private Label email5_mu;

    @FXML
    private Label name5_mu;

    @FXML
    private CheckBox box4_mu;

    @FXML
    private CheckBox box2_mu;

    @FXML
    private Label email2_mu;

    @FXML
    private Label name1_mu;

    @FXML
    private Label password_mu;

    @FXML
    private Label password1_mu;

    @FXML
    private Label password3_mu;

    @FXML
    private Label password5_mu;

    @FXML
    private Label email_mu;

    @FXML
    private Hyperlink user_hyplink_mu;

    @FXML
    private Label name4_mu;

    @FXML
    private Label email4_mu;

    @FXML
    private CheckBox box5_mu;

    @FXML
    private Button button_find_mu;

    @FXML
    private Label name_mu;

    @FXML
    private CheckBox box1_mu;

    @FXML
    private CheckBox box3_mu;

    UserDAOImpl userDAO = new UserDAOImpl();
    ArrayList<User> users = userDAO.queryAll();

    @FXML
    void click_user_hyplink_mu(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_hyplink_mu.getScene().getWindow();
        new APP().jump(stage,"manage_user");

    }

    @FXML
    void click_trainer_hyplink_mu(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_hyplink_mu.getScene().getWindow();
        new APP().jump(stage,"manage_trainer");
    }

    @FXML
    void click_income_hyplink_mu(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_hyplink_mu.getScene().getWindow();
        new APP().jump(stage,"manage_income");
    }

    @FXML
    void click_regu_hyplink_mu(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_hyplink_mu.getScene().getWindow();
        new APP().jump(stage,"manage_regulation");
    }

    @FXML
    void click_out_hyplink_mu(MouseEvent event) throws IOException {
        Stage stage = (Stage) trainer_hyplink_mu.getScene().getWindow();
        new APP().jump(stage,"login");
    }

    @FXML
    void click_find_mu(MouseEvent event) {

        names[0] = name1_mu;
        names[1] = name2_mu;
        names[2] = name3_mu;
        names[3] = name4_mu;
        names[4] = name5_mu;
        emails[0] = email1_mu;
        emails[1] = email2_mu;
        emails[2] = email3_mu;
        emails[3] = email4_mu;
        emails[4] = email5_mu;
        passwords[0] = password1_mu;
        passwords[1] = password2_mu;
        passwords[2] = password3_mu;
        passwords[3] = password4_mu;
        passwords[4] = password5_mu;

        CheckBox[] checkBoxes = new CheckBox[5];
        checkBoxes[0] = box1_mu;
        checkBoxes[1] = box2_mu;
        checkBoxes[2] = box3_mu;
        checkBoxes[3] = box4_mu;
        checkBoxes[4] = box5_mu;
        //What if nothing is entered and all user information is returned
        if (text_find_mu.getText().equals("")){
            turn_page.setPageCount((int) Math.ceil(users.size()/5.0));
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int limit = 5;
                    if (param.intValue() == users.size() / 5) {
                        limit = users.size() % 5;
                    }

                    if (param.intValue() < users.size() /5) {
                        for (int i = 0; i < limit; i++) {
                            names[i].setText(users.get(5 * param.intValue() + i).getUserName());
                            emails[i].setText(users.get(5 * param.intValue() + i).getEmail());
                            passwords[i].setText(users.get(5 * param.intValue() + i).getPassword());
                            checkBoxes[i].setVisible(true);
                        }

                    } else {
                        for (int i =0; i <limit; i++){
                            names[i].setText(users.get(5 * param.intValue() + i).getUserName());
                            emails[i].setText(users.get(5 * param.intValue() + i).getEmail());
                            passwords[i].setText(users.get(5 * param.intValue() + i).getPassword());
                            checkBoxes[i].setVisible(true);
                        }
                        for (int i = limit; i < 5; i++) {
                            names[i].setText("");
                            emails[i].setText("");
                            passwords[i].setText("");
                            checkBoxes[i].setVisible(false);
                        }

                    }
                    return box;
                }});
        }
        //If the user name is not found, no message is returned
        if (!userDAO.queryByUserName(text_find_mu.getText()).getUserName().equals(text_find_mu.getText()) && !text_find_mu.getText().equals("")){
            System.out.println("not same");
            turn_page.setPageCount(1);
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    for (int i = 0; i < 5; i++) {

                        names[i].setText("");
                        emails[i].setText("");
                        passwords[i].setText("");
                        checkBoxes[i].setVisible(false);
                    }
                    return box;
                }
            });
        }
        //If a user name is queried, the user information is returned
        if (!text_find_mu.getText().equals("") && userDAO.queryByUserName(text_find_mu.getText()).getUserName().equals(text_find_mu.getText())){
            turn_page.setPageCount(1);
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int limit = 5;
                    if (param.intValue() == 1 / 5) {
                        limit = 1 % 5;
                    }

                    if (param.intValue() < limit) {
                        for (int i = 0; i < limit; i++) {
                            names[i].setText(userDAO.queryByUserName(text_find_mu.getText()).getUserName());
                            emails[i].setText(userDAO.queryByUserName(text_find_mu.getText()).getEmail());
                            passwords[i].setText(userDAO.queryByUserName(text_find_mu.getText()).getPassword());
                            checkBoxes[i].setVisible(true);
                        }
                        for (int i = limit; i < 5; i++) {
                            names[i].setText("");
                            emails[i].setText("");
                            passwords[i].setText("");
                            checkBoxes[i].setVisible(false);
                        }
                    }
//                else {
//
//
//                }
                    return box;
                }


            });
        }


    }


    @FXML
    void click_delete_mu(MouseEvent event) {
//        checkBoxes[0] = box1_mu;
//        checkBoxes[1] = box2_mu;
//        checkBoxes[2] = box3_mu;
//        checkBoxes[3] = box4_mu;
//        checkBoxes[4] = box5_mu;
//        for (int i = 0; i<5; i++){
//            System.out.println(checkBoxes[i].isSelected() + "no." +i);
//            deleteRow(userInfo_gridpane,i);
//        }
////        System.out.println(box1_mu.isSelected());       //true when is selected
//        System.out.println(turn_page.getCurrentPageIndex());
        int pageIndex = turn_page.getCurrentPageIndex();
        checkBoxes[0] = box1_mu;
        checkBoxes[1] = box2_mu;
        checkBoxes[2] = box3_mu;
        checkBoxes[3] = box4_mu;
        checkBoxes[4] = box5_mu;
        for (int i = 0; i<5; i++){
            System.out.println(checkBoxes[i].isSelected() + "no." +i);
            if (checkBoxes[i].isSelected()){
                int index = (pageIndex * 5 + i + 1);
                System.out.println("第几项 被选中" + index);
                userDAO.deleteUser(new User(users.get(index-1).getUserName()));
                users.remove(index-1);
                click_find_mu(event);
                checkBoxes[i].setSelected(false);
            }
        }

    }

    @FXML
    void click_turn_page(ActionEvent event) {

    }

    @FXML
    void initialize() {

//        UserDAOImpl userDAO = new UserDAOImpl();
        ArrayList<User> users = userDAO.queryAll();
        turn_page.setPageCount((int) Math.ceil(users.size()/5.0));
        for (User user:users){
            user.getUserName();
        }
        names[0] = name1_mu;
        names[1] = name2_mu;
        names[2] = name3_mu;
        names[3] = name4_mu;
        names[4] = name5_mu;
        emails[0] = email1_mu;
        emails[1] = email2_mu;
        emails[2] = email3_mu;
        emails[3] = email4_mu;
        emails[4] = email5_mu;
        passwords[0] = password1_mu;
        passwords[1] = password2_mu;
        passwords[2] = password3_mu;
        passwords[3] = password4_mu;
        passwords[4] = password5_mu;

        CheckBox[] checkBoxes = new CheckBox[5];
        checkBoxes[0] = box1_mu;
        checkBoxes[1] = box2_mu;
        checkBoxes[2] = box3_mu;
        checkBoxes[3] = box4_mu;
        checkBoxes[4] = box5_mu;

        turn_page.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                VBox box =new VBox();
                int limit = 5;
                if (param.intValue() == users.size()/5) {
                    limit = users.size()%5;
                }

                if(param.intValue() < users.size()/5){
                    for (int i =0; i <limit; i++){
                        names[i].setText(users.get(5 * param.intValue() + i).getUserName());
                        emails[i].setText(users.get(5 * param.intValue() + i).getEmail());
                        passwords[i].setText(users.get(5 * param.intValue() + i).getPassword());
                        checkBoxes[i].setVisible(true);
                    }

                } else {
                    for (int i =0; i <limit; i++){
                        names[i].setText(users.get(5 * param.intValue() + i).getUserName());
                        emails[i].setText(users.get(5 * param.intValue() + i).getEmail());
                        passwords[i].setText(users.get(5 * param.intValue() + i).getPassword());
                        checkBoxes[i].setVisible(true);
                    }
                    for (int i = limit; i<5; i++){
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
