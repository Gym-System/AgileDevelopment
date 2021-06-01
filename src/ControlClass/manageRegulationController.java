package ControlClass;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import EntityClass.DAO.Impl.ManagerDAOImpl;
import EntityClass.VO.Regulation;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class manageRegulationController {
    private ArrayList<TextField> vip_min = new ArrayList<>();
    private ArrayList<TextField> vip_max = new ArrayList<>();
    private ArrayList<TextField> vip_discount = new ArrayList<>();
    private ArrayList<Regulation> regulations = new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink regu_mr;

    @FXML
    private TextField vip3_max;

    @FXML
    private Hyperlink user_hyplink_mr;

    @FXML
    private TextField vip2_min;

    @FXML
    private Hyperlink trainer_hyplink_mr;

    @FXML
    private Label name1_mi;

    @FXML
    private Label record_hour3_mi;

    @FXML
    private Label record_hour1_mi;

    @FXML
    private Hyperlink out_hyplink_mr;

    @FXML
    private Label name3_mi;

    @FXML
    private TextField vip3_min;

    @FXML
    private TextField vip5_discount;

    @FXML
    private Hyperlink income_hyplink_mr;

    @FXML
    private TextField vip2_discount;

    @FXML
    private TextField vip2_max;

    @FXML
    private TextField vip1_discount;

    @FXML
    private TextField vip4_discount;

    @FXML
    private TextField vip5_min;

    @FXML
    private Label record_hour1_mi1;

    @FXML
    private TextField vip4_min;

    @FXML
    private TextField vip1_max;

    @FXML
    private Label record_hour4_mi;

    @FXML
    private TextField vip1_min;

    @FXML
    private Label name2_mi;

    @FXML
    private Label name_mi;

    @FXML
    private TextField vip5_max;

    @FXML
    private Label record_hour2_mi;

    @FXML
    private Label name4_mi;

    @FXML
    private TextField vip3_discount;

    @FXML
    private TextField vip4_max;

    @FXML
    private Button save_regulation;

    @FXML
    void click_user_hyplink_mr(MouseEvent event) throws IOException {
        Stage stage = (Stage) income_hyplink_mr.getScene().getWindow();
        new APP().jump(stage,"manage_user");
    }

    @FXML
    void click_trainer_hyplink_mr(MouseEvent event) throws IOException {
        Stage stage = (Stage) income_hyplink_mr.getScene().getWindow();
        new APP().jump(stage,"manage_trainer");
    }

    @FXML
    void click_income_hyplink_mr(MouseEvent event) throws IOException {
        Stage stage = (Stage) income_hyplink_mr.getScene().getWindow();
        new APP().jump(stage,"manage_income");
    }

    @FXML
    void click_regu_hyplink_mr(MouseEvent event) throws IOException {
        Stage stage = (Stage) income_hyplink_mr.getScene().getWindow();
        new APP().jump(stage,"manage_regulation");
    }

    @FXML
    void click_out_hyplink_mr(MouseEvent event) throws IOException {
        Stage stage = (Stage) income_hyplink_mr.getScene().getWindow();
        new APP().jump(stage,"login");
    }

    @FXML
    void click_save_regulation(MouseEvent event) {
        vip_min.add(vip1_min);
        vip_min.add(vip2_min);
        vip_min.add(vip3_min);
        vip_min.add(vip4_min);
        vip_min.add(vip5_min);
        vip_max.add(vip1_max);
        vip_max.add(vip2_max);
        vip_max.add(vip3_max);
        vip_max.add(vip4_max);
        vip_max.add(vip5_max);
        vip_discount.add(vip1_discount);
        vip_discount.add(vip2_discount);
        vip_discount.add(vip3_discount);
        vip_discount.add(vip4_discount);
        vip_discount.add(vip5_discount);
        for (int i = 0; i <= 4; i++) {
            if (vip_max.get(i).getText().equals("MAX")) {
                regulations.add(new Regulation((i + 1), Double.parseDouble(vip_min.get(i).getText()), Double.POSITIVE_INFINITY, Double.parseDouble(vip_discount.get(i).getText())));
            }
            else {
                regulations.add(new Regulation((i + 1), Double.parseDouble(vip_min.get(i).getText()), Double.parseDouble(vip_max.get(i).getText()), Double.parseDouble(vip_discount.get(i).getText())));
            }
        }

        new ManagerDAOImpl().queryByUserName(passValue.getValue()).changeRegulation(regulations);

    }

    @FXML
    void initialize() {
        assert regu_mr != null : "fx:id=\"regu_mr\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip3_max != null : "fx:id=\"vip3_max\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert user_hyplink_mr != null : "fx:id=\"user_hyplink_mr\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip2_min != null : "fx:id=\"vip2_min\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert trainer_hyplink_mr != null : "fx:id=\"trainer_hyplink_mr\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert name1_mi != null : "fx:id=\"name1_mi\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert record_hour3_mi != null : "fx:id=\"record_hour3_mi\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert record_hour1_mi != null : "fx:id=\"record_hour1_mi\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert out_hyplink_mr != null : "fx:id=\"out_hyplink_mr\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert name3_mi != null : "fx:id=\"name3_mi\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip3_min != null : "fx:id=\"vip3_min\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip5_discount != null : "fx:id=\"vip5_discount\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert income_hyplink_mr != null : "fx:id=\"income_hyplink_mr\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip2_discount != null : "fx:id=\"vip2_discount\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip2_max != null : "fx:id=\"vip2_max\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip1_discount != null : "fx:id=\"vip1_discount\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip4_discount != null : "fx:id=\"vip4_discount\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip5_min != null : "fx:id=\"vip5_min\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert record_hour1_mi1 != null : "fx:id=\"record_hour1_mi1\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip4_min != null : "fx:id=\"vip4_min\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip1_max != null : "fx:id=\"vip1_max\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert record_hour4_mi != null : "fx:id=\"record_hour4_mi\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip1_min != null : "fx:id=\"vip1_min\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert name2_mi != null : "fx:id=\"name2_mi\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert name_mi != null : "fx:id=\"name_mi\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip5_max != null : "fx:id=\"vip5_max\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert record_hour2_mi != null : "fx:id=\"record_hour2_mi\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert name4_mi != null : "fx:id=\"name4_mi\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip3_discount != null : "fx:id=\"vip3_discount\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert vip4_max != null : "fx:id=\"vip4_max\" was not injected: check your FXML file 'manage_regulation.fxml'.";
        assert save_regulation != null : "fx:id=\"save_regulation\" was not injected: check your FXML file 'manage_regulation.fxml'.";

    }
}
