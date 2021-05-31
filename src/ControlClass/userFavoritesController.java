package ControlClass;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import EntityClass.DAO.impl.FavoriteVideoImpl;
import EntityClass.DAO.impl.RecVideoDAOImpl;
import EntityClass.VO.FavoriteVideo;
import EntityClass.VO.RecVideo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class userFavoritesController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label favName4_label;

    @FXML
    private Label favTime3_label;

    @FXML
    private ImageView userFav1_pic;

    @FXML
    private Pagination turn_page;

    @FXML
    private Label favTime1_label;

    @FXML
    private Hyperlink user_calendar_hyper;

    @FXML
    private Label favName1_label;

    @FXML
    private Label favCoa2_label;

    @FXML
    private Hyperlink favEnter2_hyper;

    @FXML
    private Hyperlink user_logout_hyper;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView userFav2_pic;

    @FXML
    private Hyperlink user_live_hyper;

    @FXML
    private ImageView user_profile_pic;

    @FXML
    private Label favName3_label;

    @FXML
    private CheckBox user_yoga_check;

    @FXML
    private Hyperlink user_recording_hyper;

    @FXML
    private Label favTime2_label;

    @FXML
    private Hyperlink favEnter4_hyper;

    @FXML
    private Label favTime4_label;

    @FXML
    private ImageView userFav3_pic;

    @FXML
    private CheckBox user_hitt_check;

    @FXML
    private Button user_find_button;

    @FXML
    private Label favCoa4_label;

    @FXML
    private Hyperlink favEnter1_hyper;

    @FXML
    private Label favCoa3_label;

    @FXML
    private Label favName2_label;

    @FXML
    private Hyperlink user_favorites_hyper;

    @FXML
    private Hyperlink user_history_hyper;

    @FXML
    private TextField user_find_text;

    @FXML
    private CheckBox user_strength_check;

    @FXML
    private Hyperlink favEnter3_hyper;

    @FXML
    private ImageView userFav4_pic;

    @FXML
    private Label favCoa1_label;

    RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
    FavoriteVideoImpl favoriteVideo = new FavoriteVideoImpl();

    @FXML
    public void userinfo_hyperlink(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_favorites_hyper.getScene().getWindow();
        new APP().jump(stage,"UserInfo");
    }

    @FXML
    void user_favorites_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_favorites_hyper.getScene().getWindow();
        new APP().jump(stage,"user_favorites");
    }

    @FXML
    void user_recording_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_recording_hyper.getScene().getWindow();
        new APP().jump(stage,"user_recording");
    }

    @FXML
    void user_live_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_live_hyper.getScene().getWindow();
        new APP().jump(stage,"user_live");
    }

    @FXML
    void user_calendar_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_calendar_hyper.getScene().getWindow();
        new APP().jump(stage,"user_calendar");
    }

    @FXML
    void user_history_click(MouseEvent event) throws IOException {
        Stage stage = (Stage) user_history_hyper.getScene().getWindow();
        new APP().jump(stage,"user_history");
    }

    @FXML
    void user_logout_click(MouseEvent event) {

    }

    @FXML
    void click_find(MouseEvent event) {
        Label[] labelName = new Label[4];
        labelName[0] = favName1_label;
        labelName[1] = favName2_label;
        labelName[2] = favName3_label;
        labelName[3] = favName4_label;

        Label[] labelCoach = new Label[4];
        labelCoach[0] = favCoa1_label;
        labelCoach[1] = favCoa2_label;
        labelCoach[2] = favCoa3_label;
        labelCoach[3] = favCoa4_label;

        Label[] labelTime = new Label[4];
        labelTime[0] = favTime1_label;
        labelTime[1] = favTime2_label;
        labelTime[2] = favTime3_label;
        labelTime[3] = favTime4_label;

        Hyperlink[] hyperlinks = new Hyperlink[4];
        hyperlinks[0] = favEnter1_hyper;
        hyperlinks[1] = favEnter2_hyper;
        hyperlinks[2] = favEnter3_hyper;
        hyperlinks[3] = favEnter4_hyper;

        ImageView[] imageViews = new ImageView[4];
        imageViews[0] = userFav1_pic;
        imageViews[1] = userFav2_pic;
        imageViews[2] = userFav3_pic;
        imageViews[3] = userFav4_pic;

        ArrayList<FavoriteVideo> favoriteVideos = favoriteVideo.queryByUserName("kaiyi");

        //nothing enters, return whole list
        if (user_find_text.getText().equals("")) {
            turn_page.setPageCount((int) Math.ceil(favoriteVideos.size()/4.0));
            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int limit = 4;
                    if (param.intValue() == favoriteVideos.size()/4) {
                        limit = favoriteVideos.size()%4;
                    }

                    if(param.intValue() < favoriteVideos.size()/4){
                        RecVideoDAOImpl recVideoDAO;
                        RecVideo recVideos;
                        for (int i =0; i <limit; i++){
                            recVideoDAO = new RecVideoDAOImpl();
                            recVideos = recVideoDAO.queryByCourseId(favoriteVideos.get(4 * param.intValue() + i).getCourseId());

                            labelName[i].setText(recVideos.getSubject());
                            labelCoach[i].setText("Coach: "+ recVideos.getUserName());
                            labelTime[i].setText(String.valueOf(recVideos.getUploadedTime()));
                            hyperlinks[i].setVisible(true);
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                        }

                    } else {
                        RecVideoDAOImpl recVideoDAO;
                        RecVideo recVideos;
                        for (int i =0; i <limit; i++){
                            recVideoDAO = new RecVideoDAOImpl();
                            recVideos = recVideoDAO.queryByCourseId(favoriteVideos.get(4 * param.intValue() + i).getCourseId());

                            labelName[i].setText(recVideos.getSubject());
                            labelCoach[i].setText("Coach: "+ recVideos.getUserName());
                            labelTime[i].setText(String.valueOf(recVideos.getUploadedTime()));
                            hyperlinks[i].setVisible(true);
                            imageViews[i].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                        }
                        for (int i = limit; i<4; i++){
                            labelCoach[i].setText("");
                            labelName[i].setText("");
                            labelTime[i].setText("");
                            hyperlinks[i].setVisible(false);
                            imageViews[i].setImage(null);
                        }

                    }
                    return box;
                }
            });
        }
        //if it doesn't type of viddeos, return nothing
        RecVideo recVideos;
        for (FavoriteVideo fav : favoriteVideos) {
            recVideos = recVideoDAO.queryByCourseId(fav.getCourseId());
            if (!user_find_text.getText().equals("") && !recVideos.getSubject().equals(user_find_text.getText())){
                turn_page.setPageCount(1);
                turn_page.setPageFactory(new Callback<Integer, Node>() {
                    @Override
                    public Node call(Integer param) {
                        VBox box = new VBox();

                        for (int i = 0; i < 4;i++){
                            labelCoach[i].setText("");
                            labelName[i].setText("");
                            labelTime[i].setText("");
                            hyperlinks[i].setVisible(false);
                            imageViews[i].setImage(null);
                        }

                        return box;
                    }
                });
            }
        }

        for (FavoriteVideo fav: favoriteVideos) {
            recVideos = recVideoDAO.queryByCourseId(fav.getCourseId());
            //if it has type, then return this type of the video
            if (!user_find_text.getText().equals("") && recVideos.getSubject().equals(user_find_text.getText())) {
                ArrayList<FavoriteVideo> favoriteVideos1 = new ArrayList<>();
                RecVideo recVideo;
                for (FavoriteVideo v:favoriteVideos) {
                    recVideoDAO = new RecVideoDAOImpl();
                    recVideo = recVideoDAO.queryByCourseId(v.getCourseId());
                    if (recVideo.getSubject().equals(user_find_text.getText())){
                        favoriteVideos1.add(v);
                    }
                }
                turn_page.setPageCount((int) Math.ceil(favoriteVideos1.size()/4.0));

                turn_page.setPageFactory(new Callback<Integer, Node>() {
                    @Override
                    public Node call(Integer param) {
                        VBox box = new VBox();
                        int recordt1 = 0;
                        int recordt2 = 0;
                        int recordt3 = 0;
                        int limit = 4;
                        if (param.intValue() == favoriteVideos1.size()/4) {
                            limit = favoriteVideos1.size()%4;
                        }

                        if(param.intValue() < favoriteVideos1.size()/4){
                            RecVideoDAOImpl recVideoDAO;
                            RecVideo recVideos;
                            for (int i =0; i <limit; i++){
                                recVideoDAO = new RecVideoDAOImpl();
                                recVideos = recVideoDAO.queryByCourseId(favoriteVideos1.get(4 * param.intValue() + i).getCourseId());

                                if (user_find_text.getText().equals("Hiit")){
                                    if (recVideos.getSubject().equals("Hiit")) {
                                        labelName[recordt1].setText(recVideos.getSubject());
                                        labelCoach[recordt1].setText("Coach: "+ recVideos.getUserName());
                                        labelTime[recordt1].setText(String.valueOf(recVideos.getUploadedTime()));
                                        hyperlinks[recordt1].setVisible(true);
                                        imageViews[recordt1].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                        recordt1 += 1;
                                        System.out.println(recordt1);
                                    }
                                } else if (user_find_text.getText().equals("Yoga")){
                                    if (recVideos.getSubject().equals("Yoga")){
                                        labelName[recordt2].setText(recVideos.getSubject());
                                        labelCoach[recordt2].setText("Coach: "+ recVideos.getUserName());
                                        labelTime[recordt2].setText(String.valueOf(recVideos.getUploadedTime()));
                                        hyperlinks[recordt2].setVisible(true);
                                        imageViews[recordt2].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                        recordt2 += 1;
                                        System.out.println(recordt2);
                                    }
                                } else if(user_find_text.getText().equals("Strength")) {
                                    if (recVideos.getSubject().equals("Strength")) {
                                        labelName[recordt3].setText(recVideos.getSubject());
                                        labelCoach[recordt3].setText("Coach: "+ recVideos.getUserName());
                                        labelTime[recordt3].setText(String.valueOf(recVideos.getUploadedTime()));
                                        hyperlinks[recordt3].setVisible(true);
                                        imageViews[recordt3].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                        recordt3 += 1;
                                        System.out.println(recordt3);
                                    }
                                }
                            }
                        } else {
                            RecVideoDAOImpl recVideoDAO;
                            RecVideo recVideos;
                            for (int i =0; i <limit; i++){
                                recVideoDAO = new RecVideoDAOImpl();
                                recVideos = recVideoDAO.queryByCourseId(favoriteVideos1.get(4 * param.intValue() + i).getCourseId());

//                                switch (user_find_text.equals("Hiit"))

                                if (user_find_text.getText().equals("Hiit")){
                                    if (recVideos.getSubject().equals("Hiit")) {
                                        labelName[recordt1].setText(recVideos.getSubject());
                                        labelCoach[recordt1].setText("Coach: "+ recVideos.getUserName());
                                        labelTime[recordt1].setText(String.valueOf(recVideos.getUploadedTime()));
                                        hyperlinks[recordt1].setVisible(true);
                                        imageViews[recordt1].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                        recordt1 += 1;
                                        System.out.println(recordt1);
                                    }
                                } else if (user_find_text.getText().equals("Yoga")){
                                    if (recVideos.getSubject().equals("Yoga")){
                                        labelName[recordt2].setText(recVideos.getSubject());
                                        labelCoach[recordt2].setText("Coach: "+ recVideos.getUserName());
                                        labelTime[recordt2].setText(String.valueOf(recVideos.getUploadedTime()));
                                        hyperlinks[recordt2].setVisible(true);
                                        imageViews[recordt2].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                        recordt2 += 1;
                                        System.out.println(recordt2);
                                    }
                                } else if(user_find_text.getText().equals("Strength")) {
                                    if (recVideos.getSubject().equals("Strength")) {
                                        labelName[recordt3].setText(recVideos.getSubject());
                                        labelCoach[recordt3].setText("Coach: "+ recVideos.getUserName());
                                        labelTime[recordt3].setText(String.valueOf(recVideos.getUploadedTime()));
                                        hyperlinks[recordt3].setVisible(true);
                                        imageViews[recordt3].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                        recordt3 += 1;
                                        System.out.println(recordt3);
                                    }
                                }
                            }

                            if (user_find_text.getText().equals("Hiit")){
                                for (int i = recordt1; i<4; i++){
                                    labelCoach[i].setText("");
                                    labelName[i].setText("");
                                    labelTime[i].setText("");
                                    hyperlinks[i].setVisible(false);
                                    imageViews[i].setImage(null);
                                }
                            } else if (user_find_text.getText().equals("Yoga")) {
                                for (int i = recordt2; i<4; i++){
                                    labelCoach[i].setText("");
                                    labelName[i].setText("");
                                    labelTime[i].setText("");
                                    hyperlinks[i].setVisible(false);
                                    imageViews[i].setImage(null);
                                }
                            } else if (user_find_text.getText().equals("Strength")) {
                                for (int i = recordt3; i<4; i++){
                                    labelCoach[i].setText("");
                                    labelName[i].setText("");
                                    labelTime[i].setText("");
                                    hyperlinks[i].setVisible(false);
                                    imageViews[i].setImage(null);
                                }
                            }


                        }
                        return box;
                    }
                });
            }
        }


    }

    @FXML
    void click_turn_page(ActionEvent event) {

    }


    @FXML
    void click_check_yoga(MouseEvent event) {
        if (user_yoga_check.isSelected() && !user_hitt_check.isSelected() && !user_strength_check.isSelected()){
            Label[] labelName = new Label[4];
            labelName[0] = favName1_label;
            labelName[1] = favName2_label;
            labelName[2] = favName3_label;
            labelName[3] = favName4_label;

            Label[] labelCoach = new Label[4];
            labelCoach[0] = favCoa1_label;
            labelCoach[1] = favCoa2_label;
            labelCoach[2] = favCoa3_label;
            labelCoach[3] = favCoa4_label;

            Label[] labelTime = new Label[4];
            labelTime[0] = favTime1_label;
            labelTime[1] = favTime2_label;
            labelTime[2] = favTime3_label;
            labelTime[3] = favTime4_label;

            Hyperlink[] hyperlinks = new Hyperlink[4];
            hyperlinks[0] = favEnter1_hyper;
            hyperlinks[1] = favEnter2_hyper;
            hyperlinks[2] = favEnter3_hyper;
            hyperlinks[3] = favEnter4_hyper;

            ImageView[] imageViews = new ImageView[4];
            imageViews[0] = userFav1_pic;
            imageViews[1] = userFav2_pic;
            imageViews[2] = userFav3_pic;
            imageViews[3] = userFav4_pic;

            ArrayList<FavoriteVideo> favoriteVideos = favoriteVideo.queryByUserName("kaiyi");
            ArrayList<FavoriteVideo> favoriteVideos1 = new ArrayList<>();
            RecVideo recVideo;
            for (FavoriteVideo v:favoriteVideos) {
                recVideoDAO = new RecVideoDAOImpl();
                recVideo = recVideoDAO.queryByCourseId(v.getCourseId());
                if (recVideo.getSubject().equals("Yoga")){
                    favoriteVideos1.add(v);
                }
            }
            turn_page.setPageCount((int) Math.ceil(favoriteVideos1.size()/4.0));

            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int recordt1 = 0;
                    int recordt2 = 0;
                    int recordt3 = 0;
                    int limit = 4;
                    if (param.intValue() == favoriteVideos1.size()/4) {
                        limit = favoriteVideos1.size()%4;
                    }

                    if(param.intValue() < favoriteVideos1.size()/4){
                        RecVideoDAOImpl recVideoDAO;
                        RecVideo recVideos;
                        for (int i =0; i <limit; i++){
                            recVideoDAO = new RecVideoDAOImpl();
                            recVideos = recVideoDAO.queryByCourseId(favoriteVideos1.get(4 * param.intValue() + i).getCourseId());

                            if (user_yoga_check.getText().equals("Hiit")){
                                if (recVideos.getSubject().equals("Hiit")) {
                                    labelName[recordt1].setText(recVideos.getSubject());
                                    labelCoach[recordt1].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt1].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt1].setVisible(true);
                                    imageViews[recordt1].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt1 += 1;
                                    System.out.println(recordt1 + "?");
                                }
                            } else if (user_yoga_check.getText().equals("Yoga")){
                                if (recVideos.getSubject().equals("Yoga")){
                                    labelName[recordt2].setText(recVideos.getSubject());
                                    labelCoach[recordt2].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt2].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt2].setVisible(true);
                                    imageViews[recordt2].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt2 += 1;
                                    System.out.println(recordt2);
                                }
                            } else if(user_yoga_check.getText().equals("Strength")) {
                                if (recVideos.getSubject().equals("Strength")) {
                                    labelName[recordt3].setText(recVideos.getSubject());
                                    labelCoach[recordt3].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt3].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt3].setVisible(true);
                                    imageViews[recordt3].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt3 += 1;
                                    System.out.println(recordt3+"zheli");
                                }
                            }
                        }

                        if (user_yoga_check.getText().equals("Hiit")){
                            for (int i = recordt1; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        } else if (user_yoga_check.getText().equals("Yoga")) {
                            for (int i = recordt2; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        } else if (user_yoga_check.getText().equals("Strength")) {
                            for (int i = recordt3; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        }
                    } else {
                        RecVideoDAOImpl recVideoDAO;
                        RecVideo recVideos;
                        for (int i =0; i <limit; i++){
                            recVideoDAO = new RecVideoDAOImpl();
                            recVideos = recVideoDAO.queryByCourseId(favoriteVideos1.get(4 * param.intValue() + i).getCourseId());

//                                switch (user_find_text.equals("Hiit"))

                            if (user_yoga_check.getText().equals("Hiit")){
                                if (recVideos.getSubject().equals("Hiit")) {
                                    labelName[recordt1].setText(recVideos.getSubject());
                                    labelCoach[recordt1].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt1].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt1].setVisible(true);
                                    imageViews[recordt1].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt1 += 1;
                                    System.out.println(recordt1);
                                }
                            } else if (user_yoga_check.getText().equals("Yoga")){
                                if (recVideos.getSubject().equals("Yoga")){
                                    labelName[recordt2].setText(recVideos.getSubject());
                                    labelCoach[recordt2].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt2].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt2].setVisible(true);
                                    imageViews[recordt2].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt2 += 1;
                                    System.out.println(recordt2);
                                }
                            } else if(user_yoga_check.getText().equals("Strength")) {
                                if (recVideos.getSubject().equals("Strength")) {
                                    labelName[recordt3].setText(recVideos.getSubject());
                                    labelCoach[recordt3].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt3].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt3].setVisible(true);
                                    imageViews[recordt3].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt3 += 1;
                                    System.out.println(recordt3);
                                }
                            }
                        }

                        if (user_yoga_check.getText().equals("Hiit")){
                            for (int i = recordt1; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        } else if (user_yoga_check.getText().equals("Yoga")) {
                            for (int i = recordt2; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        } else if (user_yoga_check.getText().equals("Strength")) {
                            for (int i = recordt3; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        }

                    }
                    return box;
                }
            });
        }
        else if (!user_yoga_check.isSelected() && !user_hitt_check.isSelected() && !user_strength_check.isSelected()) {
            click_find(event);
        }
        else {
            if (user_yoga_check.isSelected()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("WARN");
                alert.setContentText("You can only choose one subject");
                alert.setHeaderText("WARN");
                alert.showAndWait();
            }

        }
    }

    @FXML
    void click_check_strength(MouseEvent event) {
        if (user_strength_check.isSelected() && !user_hitt_check.isSelected() && !user_yoga_check.isSelected()){
            Label[] labelName = new Label[4];
            labelName[0] = favName1_label;
            labelName[1] = favName2_label;
            labelName[2] = favName3_label;
            labelName[3] = favName4_label;

            Label[] labelCoach = new Label[4];
            labelCoach[0] = favCoa1_label;
            labelCoach[1] = favCoa2_label;
            labelCoach[2] = favCoa3_label;
            labelCoach[3] = favCoa4_label;

            Label[] labelTime = new Label[4];
            labelTime[0] = favTime1_label;
            labelTime[1] = favTime2_label;
            labelTime[2] = favTime3_label;
            labelTime[3] = favTime4_label;

            Hyperlink[] hyperlinks = new Hyperlink[4];
            hyperlinks[0] = favEnter1_hyper;
            hyperlinks[1] = favEnter2_hyper;
            hyperlinks[2] = favEnter3_hyper;
            hyperlinks[3] = favEnter4_hyper;

            ImageView[] imageViews = new ImageView[4];
            imageViews[0] = userFav1_pic;
            imageViews[1] = userFav2_pic;
            imageViews[2] = userFav3_pic;
            imageViews[3] = userFav4_pic;
            ArrayList<FavoriteVideo> favoriteVideos = favoriteVideo.queryByUserName("kaiyi");
            ArrayList<FavoriteVideo> favoriteVideos1 = new ArrayList<>();
            RecVideo recVideo;
            for (FavoriteVideo v:favoriteVideos) {
                recVideoDAO = new RecVideoDAOImpl();
                recVideo = recVideoDAO.queryByCourseId(v.getCourseId());
                if (recVideo.getSubject().equals("Strength")){
                    favoriteVideos1.add(v);
                }
            }

            turn_page.setPageCount((int) Math.ceil(favoriteVideos1.size()/4.0));

            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int recordt1 = 0;
                    int recordt2 = 0;
                    int recordt3 = 0;
                    int limit = 4;
                    if (param.intValue() == favoriteVideos1.size()/4) {
                        limit = favoriteVideos1.size()%4;
                    }

                    if(param.intValue() < favoriteVideos1.size()/4){
                        RecVideoDAOImpl recVideoDAO;
                        RecVideo recVideos;
                        for (int i =0; i <limit; i++){
                            recVideoDAO = new RecVideoDAOImpl();
                            recVideos = recVideoDAO.queryByCourseId(favoriteVideos1.get(4 * param.intValue() + i).getCourseId());

                            if (user_strength_check.getText().equals("Hiit")){
                                if (recVideos.getSubject().equals("Hiit")) {
                                    labelName[recordt1].setText(recVideos.getSubject());
                                    labelCoach[recordt1].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt1].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt1].setVisible(true);
                                    imageViews[recordt1].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt1 += 1;
                                    System.out.println(recordt1 + "?");
                                }
                            } else if (user_strength_check.getText().equals("Yoga")){
                                if (recVideos.getSubject().equals("Yoga")){
                                    labelName[recordt2].setText(recVideos.getSubject());
                                    labelCoach[recordt2].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt2].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt2].setVisible(true);
                                    imageViews[recordt2].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt2 += 1;
                                    System.out.println(recordt2);
                                }
                            } else if(user_strength_check.getText().equals("Strength")) {
                                if (recVideos.getSubject().equals("Strength")) {
                                    labelName[recordt3].setText(recVideos.getSubject());
                                    labelCoach[recordt3].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt3].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt3].setVisible(true);
                                    imageViews[recordt3].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt3 += 1;
                                    System.out.println(recordt3+"zheli");
                                }
                            }
                        }

                        if (user_strength_check.getText().equals("Hiit")){
                            for (int i = recordt1; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        } else if (user_strength_check.getText().equals("Yoga")) {
                            for (int i = recordt2; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        } else if (user_strength_check.getText().equals("Strength")) {
                            for (int i = recordt3; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        }
                    } else {
                        RecVideoDAOImpl recVideoDAO;
                        RecVideo recVideos;
                        for (int i =0; i <limit; i++){
                            recVideoDAO = new RecVideoDAOImpl();
                            recVideos = recVideoDAO.queryByCourseId(favoriteVideos1.get(4 * param.intValue() + i).getCourseId());

//                                switch (user_find_text.equals("Hiit"))

                            if (user_strength_check.getText().equals("Hiit")){
                                if (recVideos.getSubject().equals("Hiit")) {
                                    labelName[recordt1].setText(recVideos.getSubject());
                                    labelCoach[recordt1].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt1].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt1].setVisible(true);
                                    imageViews[recordt1].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt1 += 1;
                                    System.out.println(recordt1);
                                }
                            } else if (user_strength_check.getText().equals("Yoga")){
                                if (recVideos.getSubject().equals("Yoga")){
                                    labelName[recordt2].setText(recVideos.getSubject());
                                    labelCoach[recordt2].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt2].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt2].setVisible(true);
                                    imageViews[recordt2].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt2 += 1;
                                    System.out.println(recordt2);
                                }
                            } else if(user_strength_check.getText().equals("Strength")) {
                                if (recVideos.getSubject().equals("Strength")) {
                                    labelName[recordt3].setText(recVideos.getSubject());
                                    labelCoach[recordt3].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt3].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt3].setVisible(true);
                                    imageViews[recordt3].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt3 += 1;
                                    System.out.println(recordt3);
                                }
                            }
                        }

                        if (user_strength_check.getText().equals("Hiit")){
                            for (int i = recordt1; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        } else if (user_strength_check.getText().equals("Yoga")) {
                            for (int i = recordt2; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        } else if (user_strength_check.getText().equals("Strength")) {
                            for (int i = recordt3; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        }

                    }
                    return box;
                }
            });
        }
        else if (!user_yoga_check.isSelected() && !user_hitt_check.isSelected() && !user_strength_check.isSelected()) {
            click_find(event);
        }
        else {
            if (user_strength_check.isSelected()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("WARN");
                alert.setContentText("You can only choose one subject");
                alert.setHeaderText("WARN");
                alert.showAndWait();
            }

        }
    }

    @FXML
    void click_check_hitt(MouseEvent event) {
        if (user_hitt_check.isSelected() && !user_yoga_check.isSelected() && ! user_strength_check.isSelected()){
            Label[] labelName = new Label[4];
            labelName[0] = favName1_label;
            labelName[1] = favName2_label;
            labelName[2] = favName3_label;
            labelName[3] = favName4_label;

            Label[] labelCoach = new Label[4];
            labelCoach[0] = favCoa1_label;
            labelCoach[1] = favCoa2_label;
            labelCoach[2] = favCoa3_label;
            labelCoach[3] = favCoa4_label;

            Label[] labelTime = new Label[4];
            labelTime[0] = favTime1_label;
            labelTime[1] = favTime2_label;
            labelTime[2] = favTime3_label;
            labelTime[3] = favTime4_label;

            Hyperlink[] hyperlinks = new Hyperlink[4];
            hyperlinks[0] = favEnter1_hyper;
            hyperlinks[1] = favEnter2_hyper;
            hyperlinks[2] = favEnter3_hyper;
            hyperlinks[3] = favEnter4_hyper;

            ImageView[] imageViews = new ImageView[4];
            imageViews[0] = userFav1_pic;
            imageViews[1] = userFav2_pic;
            imageViews[2] = userFav3_pic;
            imageViews[3] = userFav4_pic;
            ArrayList<FavoriteVideo> favoriteVideos = favoriteVideo.queryByUserName("kaiyi");
            ArrayList<FavoriteVideo> favoriteVideos1 = new ArrayList<>();
            RecVideo recVideo;
            for (FavoriteVideo v:favoriteVideos) {
                recVideoDAO = new RecVideoDAOImpl();
                recVideo = recVideoDAO.queryByCourseId(v.getCourseId());
                if (recVideo.getSubject().equals("Hiit")){
                    favoriteVideos1.add(v);
                }
            }
            turn_page.setPageCount((int) Math.ceil(favoriteVideos1.size()/4.0));

            turn_page.setPageFactory(new Callback<Integer, Node>() {
                @Override
                public Node call(Integer param) {
                    VBox box = new VBox();
                    int recordt1 = 0;
                    int recordt2 = 0;
                    int recordt3 = 0;
                    int limit = 4;
                    if (param.intValue() == favoriteVideos1.size()/4) {
                        limit = favoriteVideos1.size()%4;
                    }

                    if(param.intValue() < favoriteVideos1.size()/4){
                        RecVideoDAOImpl recVideoDAO;
                        RecVideo recVideos;
                        for (int i =0; i <limit; i++){
                            recVideoDAO = new RecVideoDAOImpl();
                            recVideos = recVideoDAO.queryByCourseId(favoriteVideos1.get(4 * param.intValue() + i).getCourseId());

                            if (user_hitt_check.getText().equals("Hiit")){
                                if (recVideos.getSubject().equals("Hiit")) {
                                    labelName[recordt1].setText(recVideos.getSubject());
                                    labelCoach[recordt1].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt1].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt1].setVisible(true);
                                    imageViews[recordt1].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt1 += 1;
                                    System.out.println(recordt1 + "?");
                                }
                            } else if (user_hitt_check.getText().equals("Yoga")){
                                if (recVideos.getSubject().equals("Yoga")){
                                    labelName[recordt2].setText(recVideos.getSubject());
                                    labelCoach[recordt2].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt2].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt2].setVisible(true);
                                    imageViews[recordt2].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt2 += 1;
                                    System.out.println(recordt2);
                                }
                            } else if(user_hitt_check.getText().equals("Strength")) {
                                if (recVideos.getSubject().equals("Strength")) {
                                    labelName[recordt3].setText(recVideos.getSubject());
                                    labelCoach[recordt3].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt3].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt3].setVisible(true);
                                    imageViews[recordt3].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt3 += 1;
                                    System.out.println(recordt3+"zheli");
                                }
                            }
                        }

                        if (user_hitt_check.getText().equals("Hiit")){
                            for (int i = recordt1; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        } else if (user_hitt_check.getText().equals("Yoga")) {
                            for (int i = recordt2; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        } else if (user_hitt_check.getText().equals("Strength")) {
                            for (int i = recordt3; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        }
                    } else {
                        RecVideoDAOImpl recVideoDAO;
                        RecVideo recVideos;
                        for (int i =0; i <limit; i++){
                            recVideoDAO = new RecVideoDAOImpl();
                            recVideos = recVideoDAO.queryByCourseId(favoriteVideos1.get(4 * param.intValue() + i).getCourseId());

//                                switch (user_find_text.equals("Hiit"))

                            if (user_hitt_check.getText().equals("Hiit")){
                                if (recVideos.getSubject().equals("Hiit")) {
                                    labelName[recordt1].setText(recVideos.getSubject());
                                    labelCoach[recordt1].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt1].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt1].setVisible(true);
                                    imageViews[recordt1].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt1 += 1;
                                    System.out.println(recordt1);
                                }
                            } else if (user_hitt_check.getText().equals("Yoga")){
                                if (recVideos.getSubject().equals("Yoga")){
                                    labelName[recordt2].setText(recVideos.getSubject());
                                    labelCoach[recordt2].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt2].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt2].setVisible(true);
                                    imageViews[recordt2].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt2 += 1;
                                    System.out.println(recordt2);
                                }
                            } else if(user_hitt_check.getText().equals("Strength")) {
                                if (recVideos.getSubject().equals("Strength")) {
                                    labelName[recordt3].setText(recVideos.getSubject());
                                    labelCoach[recordt3].setText("Coach: "+ recVideos.getUserName());
                                    labelTime[recordt3].setText(String.valueOf(recVideos.getUploadedTime()));
                                    hyperlinks[recordt3].setVisible(true);
                                    imageViews[recordt3].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                                    recordt3 += 1;
                                    System.out.println(recordt3);
                                }
                            }
                        }

                        if (user_hitt_check.getText().equals("Hiit")){
                            for (int i = recordt1; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        } else if (user_hitt_check.getText().equals("Yoga")) {
                            for (int i = recordt2; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        } else if (user_hitt_check.getText().equals("Strength")) {
                            for (int i = recordt3; i<4; i++){
                                labelCoach[i].setText("");
                                labelName[i].setText("");
                                labelTime[i].setText("");
                                hyperlinks[i].setVisible(false);
                                imageViews[i].setImage(null);
                            }
                        }

                    }
                    return box;
                }
            });
        }
        else if (!user_yoga_check.isSelected() && !user_hitt_check.isSelected() && !user_strength_check.isSelected()) {
            click_find(event);
        }
        else{
            if (user_hitt_check.isSelected()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("WARN");
                alert.setContentText("You can only choose one subject");
                alert.setHeaderText("WARN");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void click_enterrec1(MouseEvent event) throws IOException {
        Stage stage = (Stage) favTime1_label.getScene().getWindow();
        new APP().jump(stage,"user_recording_video");
    }

    @FXML
    void click_enterrec2(ActionEvent event) {

    }


    @FXML
    void click_enterrec3(ActionEvent event) {

    }

    @FXML
    void ebebeb(ActionEvent event) {

    }

    @FXML
    void click_enterrec4(ActionEvent event) {

    }

    @FXML
    void d0d0d0(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        show();
    }

    public void show(){
        Label[] labelName = new Label[4];
        labelName[0] = favName1_label;
        labelName[1] = favName2_label;
        labelName[2] = favName3_label;
        labelName[3] = favName4_label;

        Label[] labelCoach = new Label[4];
        labelCoach[0] = favCoa1_label;
        labelCoach[1] = favCoa2_label;
        labelCoach[2] = favCoa3_label;
        labelCoach[3] = favCoa4_label;

        Label[] labelTime = new Label[4];
        labelTime[0] = favTime1_label;
        labelTime[1] = favTime2_label;
        labelTime[2] = favTime3_label;
        labelTime[3] = favTime4_label;

        Hyperlink[] hyperlinks = new Hyperlink[4];
        hyperlinks[0] = favEnter1_hyper;
        hyperlinks[1] = favEnter2_hyper;
        hyperlinks[2] = favEnter3_hyper;
        hyperlinks[3] = favEnter4_hyper;

        ImageView[] imageViews = new ImageView[4];
        imageViews[0] = userFav1_pic;
        imageViews[1] = userFav2_pic;
        imageViews[2] = userFav3_pic;
        imageViews[3] = userFav4_pic;

        ArrayList<FavoriteVideo> favoriteVideos = favoriteVideo.queryByUserName("kaiyi");

        turn_page.setPageCount((int) Math.ceil(favoriteVideos.size()/4.0));
        turn_page.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                VBox vBox = new VBox();
                int limit = 4;
                if (param.intValue() == favoriteVideos.size()/4) {
                    limit = favoriteVideos.size()%4;
                }

                if(param.intValue() < favoriteVideos.size()/4){
                    RecVideoDAOImpl recVideoDAO;
                    RecVideo recVideos;
                    for (int i =0; i <limit; i++){
                        recVideoDAO = new RecVideoDAOImpl();
                        recVideos = recVideoDAO.queryByCourseId(favoriteVideos.get(4 * param.intValue() + i).getCourseId());

                        labelName[i].setText(recVideos.getSubject());
                        labelCoach[i].setText("Coach: "+ recVideos.getUserName());
                        labelTime[i].setText(String.valueOf(recVideos.getUploadedTime()));
                        hyperlinks[i].setVisible(true);
                        imageViews[i].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));

                    }

                } else {
                    RecVideoDAOImpl recVideoDAO;
                    RecVideo recVideos;
                    for (int i =0; i <limit; i++){
                        recVideoDAO = new RecVideoDAOImpl();
                        recVideos = recVideoDAO.queryByCourseId(favoriteVideos.get(4 * param.intValue() + i).getCourseId());

                        labelName[i].setText(recVideos.getSubject());
                        labelCoach[i].setText("Coach: "+ recVideos.getUserName());
                        labelTime[i].setText(String.valueOf(recVideos.getUploadedTime()));
                        hyperlinks[i].setVisible(true);
                        imageViews[i].setImage(new Image("BoundaryClass/Resource/Subject/"+recVideos.getSubject()+".jpg"));
                    }
                    for (int i = limit; i<4; i++){
                        labelCoach[i].setText("");
                        labelName[i].setText("");
                        labelTime[i].setText("");
                        hyperlinks[i].setVisible(false);
                        imageViews[i].setImage(null);
                    }

                }

                return vBox;
            }
        });
    }


}

