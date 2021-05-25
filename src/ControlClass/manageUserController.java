package ControlClass;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import EntityClass.DAO.impl.UserDAOImpl;
import EntityClass.VO.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
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
    void click_user_hyplink_mu(ActionEvent event) {

    }

    @FXML
    void click_trainer_hyplink_mu(ActionEvent event) {

    }

    @FXML
    void click_income_hyplink_mu(ActionEvent event) {

    }

    @FXML
    void click_regu_hyplink_mu(ActionEvent event) {

    }

    @FXML
    void click_out_hyplink_mu(ActionEvent event) {

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
                        }

                    } else {
                        for (int i =0; i <limit; i++){
                            names[i].setText(users.get(5 * param.intValue() + i).getUserName());
                            emails[i].setText(users.get(5 * param.intValue() + i).getEmail());
                            passwords[i].setText(users.get(5 * param.intValue() + i).getPassword());
                        }
                        for (int i = limit; i < 5; i++) {
                            names[i].setText("");
                            emails[i].setText("");
                            passwords[i].setText("");
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
                        }
                        for (int i = limit; i < 5; i++) {
                            names[i].setText("");
                            emails[i].setText("");
                            passwords[i].setText("");
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
        assert email1_mu != null : "fx:id=\"email1_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert text_find_mu != null : "fx:id=\"text_find_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert trainer_hyplink_mu != null : "fx:id=\"trainer_hyplink_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert email3_mu != null : "fx:id=\"email3_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert name2_mu != null : "fx:id=\"name2_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert regu_mu != null : "fx:id=\"regu_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert turn_page != null : "fx:id=\"turn_page\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert button_delete_mu != null : "fx:id=\"button_delete_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert password2_mu != null : "fx:id=\"password2_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert password4_mu != null : "fx:id=\"password4_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert out_hyplink_mu != null : "fx:id=\"out_hyplink_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert income_hyplink_mu != null : "fx:id=\"income_hyplink_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert name3_mu != null : "fx:id=\"name3_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert email5_mu != null : "fx:id=\"email5_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert name5_mu != null : "fx:id=\"name5_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert box4_mu != null : "fx:id=\"box4_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert box2_mu != null : "fx:id=\"box2_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert email2_mu != null : "fx:id=\"email2_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert name1_mu != null : "fx:id=\"name1_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert password_mu != null : "fx:id=\"password_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert password1_mu != null : "fx:id=\"password1_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert password3_mu != null : "fx:id=\"password3_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert password5_mu != null : "fx:id=\"password5_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert email_mu != null : "fx:id=\"email_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert user_hyplink_mu != null : "fx:id=\"user_hyplink_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert name4_mu != null : "fx:id=\"name4_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert email4_mu != null : "fx:id=\"email4_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert box5_mu != null : "fx:id=\"box5_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert button_find_mu != null : "fx:id=\"button_find_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert name_mu != null : "fx:id=\"name_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert box1_mu != null : "fx:id=\"box1_mu\" was not injected: check your FXML file 'manage_user.fxml'.";
        assert box3_mu != null : "fx:id=\"box3_mu\" was not injected: check your FXML file 'manage_user.fxml'.";


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
                    }

                } else {
                    for (int i =0; i <limit; i++){
                        names[i].setText(users.get(5 * param.intValue() + i).getUserName());
                        emails[i].setText(users.get(5 * param.intValue() + i).getEmail());
                        passwords[i].setText(users.get(5 * param.intValue() + i).getPassword());
                    }
                    for (int i = limit; i<5; i++){
                        names[i].setText("");
                        emails[i].setText("");
                        passwords[i].setText("");
                    }

                }

//                System.out.println("当前的页面索引 = " + param.intValue());
//
//
//                Node node = null;

//                if (param.intValue() == (int)users.size()/5){
//                    System.out.println(param.intValue());
//                }
//                GridPane gridPane;
//                GridPane gridPane = new GridPane();
//                gridPane.setHgap(6);
//                gridPane.setVgap(4);
//                gridPane.setVgap(62);
//                gridPane.setHgap(150);
//
////                RowConstraints rowConstraints0 = new RowConstraints();
////                rowConstraints0.setPrefHeight(30);
////                gridPane.getRowConstraints().add(rowConstraints0);
//
//                gridPane.setAlignment(Pos.CENTER);
//                page(param.intValue());
//                int length = users.size();
//                names[0] = name0;
//                names[1] = name1;
//                names[2] = name2;
//                names[3] = name3;
//                names[4] = name4;
//                emails[0] = email0;
//                emails[1] = email1;
//                emails[2] = email2;
//                emails[3] = email3;
//                emails[4] = email4;
//                passwords[0] = password0;
//                passwords[1] = password1;
//                passwords[2] = password2;
//                passwords[3] = password3;
//                passwords[4] = password4;
//
//
//
//                System.out.println();
//                int limit = 5;
//                if (param.intValue() == users.size()/5) limit = length%5;
//                System.out.println("1111111111");
//
//                for (int i =0; i < limit; i++){
//                    System.out.println(users.get(5 * param.intValue() + i).getUserName());
//                    names[i].setText(users.get(5 * param.intValue() + i).getUserName());
//                    emails[i].setText(users.get(5 * param.intValue() + i).getEmail());
//                    passwords[i].setText(users.get(5 * param.intValue() + i).getPassword());
//                    gridPane.add(names[i],0,i);
//                    gridPane.add(emails[i],1,i);
//                    gridPane.add(passwords[i],2,i);
//                }
//                if (param.intValue() > users.size()/5){
//                    return null;
//                }

//                Label label1 = new Label(user.getUserName());
//                label1.setAlignment(Pos.CENTER);
//                gridPane.setPrefSize(870,424);
//                int page = param.intValue() *5;
//                if (param.intValue() > users.size()/5){
//                    return null;
//                } else if(param.intValue() < users.size()/5) {
//                    for (int i = page; i < page +5; i++){
//
//                    }
//                } else if (param.intValue() == users.size()/5){
//                    for (int i = page; i< page + users.size()%5;){
//
//                    }
//
//                }

//                for (int i=0; i<100;i++){
//                    if (i == 0) {
//                        for (int j =0; j<5; j++) {
//                            name0.setText(users.get(j).getUserName());
//                            gridPane.add(new Label(users.get(j).getUserName()),0,j);
//                            gridPane.add(name0,0,j);
//                            gridPane.add(new Label(users.get(j).getEmail()),1,j);
//                            gridPane.add(new Label(users.get(j).getPassword()),2,j);
//                        }
//                    }
//                    if (i >=1 && i<=param.intValue()) {
//                        for (int j =0; j<users.size()%5; j++) {
//                            gridPane.add(new Label(users.get((j + i*5)).getUserName()),0,j);
//                            gridPane.add(new Label(users.get((j + i*5)).getEmail()),1,j);
//                            gridPane.add(new Label(users.get((j + i*5)).getPassword()),2,j);
//                        }
//                    }
//                }


//                for (int j = 0; j <= (int)users.size()/5; j++) {
//                    if (j == (int)users.size()/5) {
//                        for (int i =0; i<5; i++) {
//                            gridPane.add(new Label(users.get(j * 5 +users.size()%5 - 1).getUserName()),0,i);
//                            gridPane.add(new Label(users.get(j * 5 +users.size()%5 - 1).getEmail()),1,i);
//                            gridPane.add(new Label(users.get(j * 5 +users.size()%5 - 1).getPassword()),2,i);
//                        }
//                    }else {
//                        for(int i=0;i< 5 ;i++){
//                            //                    Separator separator = new Separator();
//                            //                    separator.setLayoutX(100.0);
//                            //                    separator.setLayoutY(100.0);
//                            //                    separator.setPrefHeight(0);
//                            //                    separator.setPrefWidth(800);
//                            //                    gridPane.add(separator,0,0);
//                            //                    GridPane.setHgrow(label,Priority.ALWAYS);
//                            //                    GridPane.setVgrow(label, Priority.ALWAYS);
//                            if (param.intValue() == (int)users.size()/5){
//                                System.out.println(param.intValue());
//                            }
//                            gridPane.add(new Label(users.get(i).getUserName()),0,i);
//                            gridPane.add(new Label(users.get(i).getEmail()),1,i);
//                            gridPane.add(new Label(users.get(i).getPassword()),2,i);
//                            //                    gridPane.getColumnConstraints().add(new ColumnConstraints(150));
//                            //                    gridPane.getRowConstraints().add(new RowConstraints(50));
//
//                        }
//                    }
//
//                }
//                System.out.println(getClass().getResource("../fxml/manager_userInfo.fxml"));
//                Node root = null;
//                try {
//                    root = FXMLLoader.load(getClass().getResource("../fxml/manager_userInfo.fxml"));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                VBox vBox = new VBox();
//                vBox.getChildren().add(root);
//                return vBox;

//                VBox box = new VBox(5);
//                for (int i = param.intValue(); i<param.intValue() + 5 ; i++) {
//                    VBox element = new VBox();
//                    Label text = new Label("用户" + i);
//                    element.getChildren().addAll(text);
//                    box.getChildren().addAll(element);
//                }
//
//
//                Node node = null;
//                return box;
            return box;
            }
        });
    }

//    public void page(int pageNo) {
//        UserDAOImpl userDAO = new UserDAOImpl();
//        ArrayList<User> users = userDAO.queryUser();
//        int length = users.size();
//        names[0] = name0;
//        names[1] = name1;
//        names[2] = name2;
//        names[3] = name3;
//        names[4] = name4;
//        if (pageNo < users.size()/5) {
//            for (int i =0; i <5; i++){
//                names[i].setText(users.get(5 * pageNo + i).getUserName());
//
//            }
//        }
//        if (pageNo == users.size()/5) {
//            for (int i =0; i < length%5; i++){
//                names[i].setText(users.get(5 * pageNo + i).getUserName());
//            }
//        }
//
//    }


    public void deleteRow(GridPane pane,int row) {
        Set<Node> deleteRows = new HashSet<>();
        for (Node child: pane.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(child);

            int r = rowIndex == null ? 0:rowIndex;

            if (r > row) {
                GridPane.setRowIndex(child,r-1);
            } else if (r == row) {
                deleteRows.add(child);
            }
        }
        pane.getChildren().removeAll(deleteRows);


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
                System.out.println(index);
            }
        }

    }



}
