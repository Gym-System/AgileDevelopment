package ControlClass;
import EntityClass.DAO.UserDAO;
import EntityClass.DAO.impl.PhyDataDAOImpl;
import EntityClass.DAO.impl.UserDAOImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;

public class userInfoController {

    @FXML
    private Label birthday;

    @FXML
    private Label gender;

    @FXML
    private Label city;

    @FXML
    private Label level;

    @FXML
    private Label totalTime;

    @FXML
    private Label weight;

    @FXML
    private Label balance;

    @FXML
    private Label name;

    @FXML
    private Label ID;

    @FXML
    private Label email;

    @FXML
    private Label height;

    @FXML
    private Label bmi;

    @FXML
    private Label energy;

    @FXML
    void initialize() {
        String username = passValue.getValue();
        UserDAOImpl userDAO = new UserDAOImpl();
        PhyDataDAOImpl phyDataDAO = new PhyDataDAOImpl();
        name.setText( userDAO.queryByUserName(username).getUserName());
        //ID在csv文件中并没有存储
        gender.setText(userDAO.queryByUserName(username).getGender());
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd ");
        String date = formatter.format(userDAO.queryByUserName(username).getDoB());
        birthday.setText(date);
        //city在csv文件中并没有存储
        email.setText(userDAO.queryByUserName(username).getEmail());
        level.setText("You are not a member!");
        balance.setText(Double.toString(userDAO.queryByUserName(username).getBalance()));
        weight.setText(Double.toString(phyDataDAO.queryByUserName(username).getWeight()));
        height.setText(Double.toString(phyDataDAO.queryByUserName(username).getHeight()));
        double result=(10000*phyDataDAO.queryByUserName(username).getWeight())/(phyDataDAO.queryByUserName(username).getHeight()*phyDataDAO.queryByUserName(username).getHeight());
        bmi.setText(Double.toString(result));
        totalTime.setText(Integer.toString(phyDataDAO.queryByUserName(username).getExperience()));//这个是一周的总运动时间吗？？？
        energy.setText("这一栏对应的是数据库的啥");


    }
}

