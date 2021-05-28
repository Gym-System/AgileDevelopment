package ControlClass;

import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import EntityClass.DAO.impl.TrainerDAOImpl;
import EntityClass.VO.Trainer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class manageIncomeController {
    Label[] names = new Label[4];
    Label[] live_hours = new Label[4];
    Label[] recording_hours = new Label[4];
    Label[] awards = new Label[4];
    Label[] incomes = new Label[4];

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label record_hour_mi;

    @FXML
    private Pagination turn_page_mi;

    @FXML
    private Hyperlink user_hyplink_mi;

    @FXML
    private Label live_hour_mi;

    @FXML
    private Label c_income3_mi;

    @FXML
    private Label c_income1_mi;

    @FXML
    private Button button_find_mi;

    @FXML
    private TextField text_find_mi;

    @FXML
    private Label name1_mi;

    @FXML
    private Label record_hour3_mi;

    @FXML
    private Label record_hour1_mi;

    @FXML
    private Label name3_mi;

    @FXML
    private Hyperlink trainer_hyplink_mi;

    @FXML
    private Hyperlink out_hyplink_mi;

    @FXML
    private Label award4_mi;

    @FXML
    private Label award2_mi;

    @FXML
    private Label live_hour4_mi;

    @FXML
    private Label live_hour2_mi;

    @FXML
    private Hyperlink income_hyplink_mi;

    @FXML
    private Label c_income4_mi;

    @FXML
    private Label c_income2_mi;

    @FXML
    private ChoiceBox<?> chosice_sort_mi;

    @FXML
    private Label award_mi;

    @FXML
    private Label award1_mi;

    @FXML
    private Label record_hour4_mi;

    @FXML
    private Label c_income_mi;

    @FXML
    private Label name2_mi;

    @FXML
    private Label name_mi;

    @FXML
    private Label record_hour2_mi;

    @FXML
    private Label name4_mi;

    @FXML
    private Hyperlink regu_mi;

    @FXML
    private Label award3_mi;

    @FXML
    private Label live_hour1_mi;

    @FXML
    private Label live_hour3_mi;

    TrainerDAOImpl TrainerDAO = new TrainerDAOImpl();
    ArrayList<Trainer> trainers = TrainerDAO.queryAll();

    @FXML
    void click_user_hyplink_mi(ActionEvent event) {

    }

    @FXML
    void click_trainer_hyplink_mi(ActionEvent event) {

    }

    @FXML
    void click_income_hyplink_mi(ActionEvent event) {

    }

    @FXML
    void click_regu_hyplink_mi(ActionEvent event) {

    }

    @FXML
    void click_out_hyplink_mi(ActionEvent event) {

    }

    @FXML
    void click_find_mi(MouseEvent event) {
        names[0] = name1_mi;
        names[1] = name2_mi;
        names[2] = name3_mi;
        names[3] = name4_mi;
        live_hours[0] = live_hour1_mi;
        live_hours[1] = live_hour2_mi;
        live_hours[2] = live_hour3_mi;
        live_hours[3] = live_hour4_mi;
        recording_hours[0] = record_hour1_mi;
        recording_hours[1] = record_hour2_mi;
        recording_hours[2] = record_hour3_mi;
        recording_hours[3] = record_hour4_mi;
        awards[0]=award1_mi;
        awards[1]=award2_mi;
        awards[2]=award3_mi;
        awards[3]=award4_mi;
        //What if nothing is entered and all user information is returned
        if (text_find_mi.getText().equals("")){
            turn_page_mi.setPageCount((int) Math.ceil(trainers.size()/4.0));
            turn_page_mi.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int limit = 4;
                    if (param.intValue() == trainers.size() / 4) {
                        limit = trainers.size() % 4;
                    }

                    if (param.intValue() < trainers.size() /4) {
                        for (int i = 0; i < limit; i++) {
                            names[i].setText(trainers.get(4 * param.intValue() + i).getUserName());
                            try {
                                live_hours[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getLiveTime()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            try {
                                recording_hours[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getRecTime()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            try {
                                awards[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getGift()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            int money1=0;
                            int money2=0;
                            int money3=0;
                            try {
                                money1=(trainers.get(4 * param.intValue() + i).getLiveTime()*300);
                                money2=(trainers.get(4 * param.intValue() + i).getRecTime()*25);
                                money3=(trainers.get(4 * param.intValue() + i).getGift()*100);
                                incomes[i].setText(Integer.toString((money1+money2+money3)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }

                    } else {
                        for (int i =0; i <limit; i++){
                            names[i].setText(trainers.get(4 * param.intValue() + i).getUserName());
                            try {
                                live_hours[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getLiveTime()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            try {
                                recording_hours[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getRecTime()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            try {
                                awards[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getGift()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            int money1=0;
                            int money2=0;
                            int money3=0;
                            try {
                                money1=(trainers.get(4 * param.intValue() + i).getLiveTime()*300);
                                money2=(trainers.get(4 * param.intValue() + i).getRecTime()*25);
                                money3=(trainers.get(4 * param.intValue() + i).getGift()*100);
                                incomes[i].setText(Integer.toString((money1+money2+money3)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = limit; i < 4; i++) {
                            names[i].setText("");
                            try {
                                live_hours[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getLiveTime()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            try {
                                recording_hours[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getRecTime()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            try {
                                awards[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getGift()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            int money1=0;
                            int money2=0;
                            int money3=0;
                            try {
                                money1=(trainers.get(4 * param.intValue() + i).getLiveTime()*300);
                                money2=(trainers.get(4 * param.intValue() + i).getRecTime()*25);
                                money3=(trainers.get(4 * param.intValue() + i).getGift()*100);
                                incomes[i].setText(Integer.toString((money1+money2+money3)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                    return box;
                }});
        }
        //If the user name is not found, no message is returned
        if (!TrainerDAO.queryByUserName(text_find_mi.getText()).getUserName().equals(text_find_mi.getText()) && !text_find_mi.getText().equals("")){
            System.out.println("not same");
            turn_page_mi.setPageCount(1);
            turn_page_mi.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    for (int i = 0; i < 4; i++) {
                        names[i].setText("");
                        live_hours[i].setText("");
                        recording_hours[i].setText("");
                        awards[i].setText("");
                        incomes[i].setText("");

                    }
                    return box;
                }
            });
        }
        //If a user name is queried, the user information is returned
        if (!text_find_mi.getText().equals("") && TrainerDAO.queryByUserName(text_find_mi.getText()).getUserName().equals(text_find_mi.getText())){
            turn_page_mi.setPageCount(1);
            turn_page_mi.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int limit = 4;
                    if (param.intValue() == 1 / 4) {
                        limit = 1 % 4;
                    }

                    if (param.intValue() < limit) {
                        for (int i = 0; i < limit; i++) {
                            names[i].setText(TrainerDAO.queryByUserName(text_find_mi.getText()).getUserName());
                            try {
                                live_hours[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getLiveTime()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            try {
                                recording_hours[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getRecTime()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            try {
                                awards[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getGift()));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            int money1=0;
                            int money2=0;
                            int money3=0;
                            try {
                                money1=(trainers.get(4 * param.intValue() + i).getLiveTime()*300);
                                money2=(trainers.get(4 * param.intValue() + i).getRecTime()*25);
                                money3=(trainers.get(4 * param.intValue() + i).getGift()*100);
                                incomes[i].setText(Integer.toString((money1+money2+money3)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int i = limit; i < 4; i++) {
                            names[i].setText("");
                            live_hours[i].setText("");
                            recording_hours[i].setText("");
                            awards[i].setText("");
                            incomes[i].setText("");
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
    void click_turn_page_mi(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert record_hour_mi != null : "fx:id=\"record_hour_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert turn_page_mi != null : "fx:id=\"turn_page_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert user_hyplink_mi != null : "fx:id=\"user_hyplink_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert live_hour_mi != null : "fx:id=\"live_hour_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert c_income3_mi != null : "fx:id=\"c_income3_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert c_income1_mi != null : "fx:id=\"c_income1_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert button_find_mi != null : "fx:id=\"button_find_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert text_find_mi != null : "fx:id=\"text_find_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert name1_mi != null : "fx:id=\"name1_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert record_hour3_mi != null : "fx:id=\"record_hour3_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert record_hour1_mi != null : "fx:id=\"record_hour1_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert name3_mi != null : "fx:id=\"name3_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert trainer_hyplink_mi != null : "fx:id=\"trainer_hyplink_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert out_hyplink_mi != null : "fx:id=\"out_hyplink_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert award4_mi != null : "fx:id=\"award4_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert award2_mi != null : "fx:id=\"award2_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert live_hour4_mi != null : "fx:id=\"live_hour4_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert live_hour2_mi != null : "fx:id=\"live_hour2_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert income_hyplink_mi != null : "fx:id=\"income_hyplink_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert c_income4_mi != null : "fx:id=\"c_income4_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert c_income2_mi != null : "fx:id=\"c_income2_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert chosice_sort_mi != null : "fx:id=\"chosice_sort_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert award_mi != null : "fx:id=\"award_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert award1_mi != null : "fx:id=\"award1_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert record_hour4_mi != null : "fx:id=\"record_hour4_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert c_income_mi != null : "fx:id=\"c_income_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert name2_mi != null : "fx:id=\"name2_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert name_mi != null : "fx:id=\"name_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert record_hour2_mi != null : "fx:id=\"record_hour2_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert name4_mi != null : "fx:id=\"name4_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert regu_mi != null : "fx:id=\"regu_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert award3_mi != null : "fx:id=\"award3_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert live_hour1_mi != null : "fx:id=\"live_hour1_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        assert live_hour3_mi != null : "fx:id=\"live_hour3_mi\" was not injected: check your FXML file 'manage_income.fxml'.";
        ArrayList<Trainer> trainers = TrainerDAO.queryAll();
        turn_page_mi.setPageCount((int) Math.ceil(trainers.size()/4.0));
        for (Trainer trainer:trainers){
            trainer.getUserName();
        }
        names[0] = name1_mi;
        names[1] = name2_mi;
        names[2] = name3_mi;
        names[3] = name4_mi;
        live_hours[0] = live_hour1_mi;
        live_hours[1] = live_hour2_mi;
        live_hours[2] = live_hour3_mi;
        live_hours[3] = live_hour4_mi;
        recording_hours[0] = record_hour1_mi;
        recording_hours[1] = record_hour2_mi;
        recording_hours[2] = record_hour3_mi;
        recording_hours[3] = record_hour4_mi;
        awards[0]=award1_mi;
        awards[1]=award2_mi;
        awards[2]=award3_mi;
        awards[3]=award4_mi;
        incomes[0]=c_income1_mi;
        incomes[1]=c_income2_mi;
        incomes[2]=c_income3_mi;
        incomes[3]=c_income4_mi;



        turn_page_mi.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                VBox box =new VBox();
                int limit = 4;
                if (param.intValue() == trainers.size()/4) {
                    limit = trainers.size()%4;
                }
                if(param.intValue() < trainers.size()/4){
                    for (int i =0; i <limit; i++){
                        names[i].setText(trainers.get(4 * param.intValue() + i).getUserName());
                        try {
                            live_hours[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getLiveTime()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        try {
                            recording_hours[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getRecTime()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        try {
                            awards[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getGift()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        int money1=0;
                        int money2=0;
                        int money3=0;
                        try {
                            money1=(trainers.get(4 * param.intValue() + i).getLiveTime()*300);
                            money2=(trainers.get(4 * param.intValue() + i).getRecTime()*25);
                            money3=(trainers.get(4 * param.intValue() + i).getGift()*100);
                            incomes[i].setText(Integer.toString((money1+money2+money3)));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }

                } else {
                    for (int i =0; i <limit; i++){
                        names[i].setText(trainers.get(4 * param.intValue() + i).getUserName());
                        try {
                            live_hours[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getLiveTime()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        try {
                            recording_hours[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getRecTime()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        try {
                            awards[i].setText(Integer.toString(trainers.get(4 * param.intValue() + i).getGift()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        int money1=0;
                        int money2=0;
                        int money3=0;
                        try {
                            money1=(trainers.get(4 * param.intValue() + i).getLiveTime()*300);
                            money2=(trainers.get(4 * param.intValue() + i).getRecTime()*25);
                            money3=(trainers.get(4 * param.intValue() + i).getGift()*100);
                            incomes[i].setText(Integer.toString((money1+money2+money3)));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int i = limit; i<4; i++){
                        names[i].setText("");
                        live_hours[i].setText("");
                        recording_hours[i].setText("");
                        awards[i].setText("");
                        incomes[i].setText("");
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

}

