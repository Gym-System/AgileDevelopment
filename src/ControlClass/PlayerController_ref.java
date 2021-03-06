package ControlClass;

import EntityClass.DAO.Impl.FavoriteVideoImpl;
import EntityClass.DAO.Impl.PreUserDAOImpl;
import EntityClass.DAO.Impl.RecVideoDAOImpl;
import EntityClass.DAO.Impl.UserDAOImpl;
import EntityClass.VO.FavoriteVideo;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.fxml.Initializable;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * create by Intellij IDEA
 * Author: Al-assad
 * E-mail: yulinying@1994.com
 * Github: https://github.com/Al-assad
 * Date: 2017/1/20 14:22
 * Description:
 */
public class PlayerController_ref implements Initializable {
Boolean flag;
//    @FXML Button playBT;
//    @FXML Button stopBT;
//    @FXML Button maxBT;
//    @FXML Button volumeBT;
//    @FXML Label timeLB;
//    @FXML Slider processSD;
//    @FXML Slider volumeSD;
//    @FXML MediaView mediaView;
//    @FXML VBox controlBar;
//    @FXML BorderPane mediaPane;
    @FXML
    private AnchorPane bigAnchorPane;

    @FXML
    private AnchorPane Biggest;

    @FXML
    private AnchorPane medium;

    @FXML
    private Button stopBT;

    @FXML
    private ImageView add_favorite_image;

    @FXML
    private ImageView recommend_image3_urs11;

    @FXML
    private Hyperlink user_calendar_hyper;

    @FXML
    private VBox controlBar;

    @FXML
    private ImageView user_image_urs;

    @FXML
    private Label recommend_type1_urs;

    @FXML
    private ImageView logo;

    @FXML
    private Label user_com3_urs;

    @FXML
    private Button maxBT;

    @FXML
    private Hyperlink user_live_hyper;

    @FXML
    private ImageView user_profile_pic;

    @FXML
    private Label recommend_dur3_urs11;

    @FXML
    private Button send_flower_urs;

    @FXML
    private Label recommend_dur2_urs1;

    @FXML
    private Label user_name2_urs;

    @FXML
    private Label user_com2_urs;

    @FXML
    private Label user_name1_urs;

    @FXML
    private Label user_com1_urs;

    @FXML
    private ImageView recommend_image1_urs;

    @FXML
    private Hyperlink user_facorites_hyper;

    @FXML
    private Label recommend_type2_urs1;

    @FXML
    private ImageView recommend_image2_urs1;

    @FXML
    private Label user_name3_urs;

    @FXML
    private Button playBT;

    @FXML
    private Button send_comment_urs;

    @FXML
    private MediaView mediaView;

    @FXML
    private Hyperlink recommend_hyper1_urs;

    @FXML
    private Slider processSD;

    @FXML
    private ImageView user_image3_urs;

    @FXML
    private TextArea user_comment_urs;

    @FXML
    private Label recommend_coach1_urs;

    @FXML
    private Label recommend_type3_urs11;

    @FXML
    private Hyperlink user_logout_hyper;

    @FXML
    private BorderPane controlBorderPane;

    @FXML
    private Button volumeBT;

    @FXML
    private Hyperlink user_recording_hyper;

    @FXML
    private Hyperlink recommend_hyper2_urs1;

    @FXML
    private Label recommend_coach2_urs1;

    @FXML
    private ImageView user_image1_urs;

    @FXML
    private Slider volumeSD;

    @FXML
    private TextField flower_num_urs;

    @FXML
    private Label recommend_dur1_urs;

    @FXML
    private Label timeLB;

    @FXML
    private Hyperlink recommend_hyper3_urs11;

    @FXML
    private ImageView user_image2_urs;

    @FXML
    private Hyperlink user_history_hyper;

    @FXML
    private Label recommend_coach3_urs11;

    @FXML
    private BorderPane mediaPane;

    @FXML
    private Button collectBT;

    @FXML
    private Label video_view_times;

    @FXML
    private Label video_title;

    @FXML
    void user_favorites_click(MouseEvent event) throws IOException {
        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
        Stage stage = (Stage) user_facorites_hyper.getScene().getWindow();
        new APP().jump(stage,"user_favorites");

    }

    @FXML
    void user_recording_click(MouseEvent event) throws IOException {
        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
        Stage stage = (Stage) user_recording_hyper.getScene().getWindow();
        new APP().jump(stage,"user_recording");

    }

    @FXML
    void user_live_click(MouseEvent event) throws IOException {
        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
        Stage stage = (Stage) user_live_hyper.getScene().getWindow();
        new APP().jump(stage,"user_live");

    }

    @FXML
    void user_calendar_click(MouseEvent event) throws IOException {
        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
        Stage stage = (Stage) user_calendar_hyper.getScene().getWindow();
        new APP().jump(stage,"user_calendar");

    }

    @FXML
    void user_history_click(MouseEvent event) throws IOException {
        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
        Stage stage = (Stage) user_history_hyper.getScene().getWindow();
        new APP().jump(stage,"user_history");

    }

    @FXML
    void user_logout_click(MouseEvent event) throws IOException {
        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
        Stage stage = (Stage) user_history_hyper.getScene().getWindow();
        new APP().jump(stage,"login");

    }

    @FXML
    void add_collect(MouseEvent event) {
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
        long courseid = passValue.getCourseID();
        UserDAOImpl UserDAO = new UserDAOImpl();
        if(flag==false){
            System.out.println(courseid);
            UserDAO.queryByUserName(passValue.getValue()).favoriteVideo(courseid);
            JOptionPane.showMessageDialog(null, "Add favorite successfully", "Add favorite successfully", JOptionPane.INFORMATION_MESSAGE);
            collectBT.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
            flag=true;
        }else{
            UserDAO.queryByUserName(passValue.getValue()).unFavoriteVideo(new FavoriteVideo(courseid, passValue.getValue()));
            JOptionPane.showMessageDialog(null, "Delete favorite successfully", "Delete favorite successfully", JOptionPane.INFORMATION_MESSAGE);
            collectBT.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
            flag=false;
        }

    }

    @FXML
    void click_enter_recom_recording1(ActionEvent event) {

    }

    @FXML
    void click_enter_recom_recording2(ActionEvent event) {

    }

    @FXML
    void click_enter_recom_recording3(ActionEvent event) {

    }

    @FXML
    void click_send_flower(MouseEvent event) {
        UserDAOImpl userDAO = new UserDAOImpl();
        PreUserDAOImpl preUserDAO = new PreUserDAOImpl();
        try{
            int flowernumber = Integer.parseInt(flower_num_urs.getText());
        }catch (Exception E){
            JOptionPane.showMessageDialog(null, "Please check the input", "Please check the input", JOptionPane.ERROR_MESSAGE);
        }
        if (Integer.parseInt(flower_num_urs.getText())>=0){
            if(preUserDAO.queryByUserName(passValue.getValue())==null){
                JOptionPane.showMessageDialog(null, "Out of balance", "Please check the balance", JOptionPane.ERROR_MESSAGE);
            }
            else{
                Boolean state;
                state=preUserDAO.queryByUserName(passValue.getValue()).sendGift2RecVideo(Integer.parseInt(flower_num_urs.getText()),passValue.getCourseID());
                if(state){
                    JOptionPane.showMessageDialog(null, "send "+flower_num_urs.getText()+" flowers successfully", "send flowers successfully", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Out of balance", "Please check the balance", JOptionPane.ERROR_MESSAGE);
                }
            }


        }



    }

    @FXML
    void click_send_comment(ActionEvent event) {

    }

    @FXML
    void click_add_favorite_image(ActionEvent event) {

    }

    //??????????????????
    private String playIcon  = getClass().getResource("/BoundaryClass/Resource/play.png").toString();
    private String pauseIcon  = getClass().getResource("/BoundaryClass/Resource/pause.png").toString();
    private String stopIcon  = getClass().getResource("/BoundaryClass/Resource/stop.png").toString();
    private String volOffIcon  = getClass().getResource("/BoundaryClass/Resource/volume_off.png").toString();
    private String volOnIcon  = getClass().getResource("/BoundaryClass/Resource/volume_On.png").toString();
    private String maxIcon  = getClass().getResource("/BoundaryClass/Resource/max.png").toString();
    private MediaPlayer mediaPlayer;
    private Media media;
    private String url;     //?????????url??????
    private boolean popup;   //??????????????????
    private Scene scene ;  //????????????

    private boolean atEndOfMedia = false;    //????????????????????????????????????
    private final boolean repeat = false;   //??????????????????????????????
    private double volumeValue;      //????????????????????????????????????
    private Duration duration ;        //????????????????????????
    private int mediaHeight;        //?????????????????????
    private int mediaWidth;

    private int currentHeight;    //??????????????????????????????
    private int currentWidth;
    private  Stage primaryStage=null;
    public void setScene(Scene scene){
        this.scene = scene;
    }


    //????????????????????????????????????
    public void Anotherstart(String url, boolean popup, int width, int height){

        this.url = url;
        this.popup = popup;

        File file = new File("src/BoundaryClass/Resource/Video/"+ passValue.getCourseID() +".mp4");
        url = file.toURI().toString();
        System.out.println(url);


        //MediaView??????
        media = new Media(url);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        //??????????????????????????????????????????????????????????????????????????????????????????????????????
        setMediaPlayer(width,height);

        //???????????????????????????
        setMediaViewOnClick();
        setPlayButton();
        setStopButton();
        setVolumeButton();
        setVolumeSD();
        setProcessSlider();

    }


    //??????mediaPlayer(?????????????????????????????????)
    void setMediaPlayer(int width,int height){
        mediaPlayer.setCycleCount(repeat ? MediaPlayer.INDEFINITE : 1);
        //????????????????????? ????????? ?????????????????????????????????,??????????????????
        mediaPlayer.setOnReady(new Runnable(){
            @Override
            public void run() {
                duration = mediaPlayer.getMedia().getDuration();
                volumeValue = mediaPlayer.getVolume();
                mediaHeight = media.getHeight();
                mediaWidth = media.getWidth();

                //??????????????????
                setSize(width,height);

                //??????????????????????????????????????????????????????????????????

                if (scene!= null) {
                    scene.widthProperty().addListener(new ChangeListener<Number>() {
                        @Override
                        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                            setSize(newValue.intValue(),currentHeight);}
                    });
                    scene.heightProperty().addListener(new ChangeListener<Number>() {
                        @Override
                        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                            setSize(currentWidth,newValue.intValue());
                        }
                    });
                }
                //??????????????????UI??????:??????????????????????????????MediaView????????????
                EventHandler onScreen = new EventHandler<InputEvent>(){
                    @Override
                    public void handle(InputEvent event) {
                        controlBar.setVisible(true);
                    }
                };
                EventHandler offScreen = new EventHandler<InputEvent>(){
                    @Override
                    public void handle(InputEvent event) {
                        controlBar.setVisible(false);
                    }
                };
                if(scene != null && popup){
                    ((Stage)scene.getWindow()).fullScreenProperty().addListener(new ChangeListener<Boolean>() {
                        @Override
                        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                            if (newValue.booleanValue()) {
                                controlBar.setVisible(false);
                                mediaPane.addEventHandler(MouseEvent.MOUSE_CLICKED, onScreen);
                                controlBar.addEventHandler(MouseEvent.MOUSE_EXITED, offScreen);
                            }else{
                                controlBar.setVisible(true);
                                mediaPane.removeEventHandler(MouseEvent.MOUSE_CLICKED,onScreen);
                                controlBar.removeEventHandler(MouseEvent.MOUSE_EXITED,offScreen);
                            }
                        }
                    });
                }

                updateValues();


            }
        });
        //mediaPlayer?????????????????????????????????????????? ?????????????????????????????????
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>(){
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                updateValues();
            }
        });
    }
    //????????????MediaView??????????????????
    private void setMediaViewOnClick(){
        mediaView.setOnMouseClicked(event -> {
            if(media == null)
                return;
            MediaPlayer.Status status = mediaPlayer.getStatus();
            if(status == MediaPlayer.Status.UNKNOWN || status == MediaPlayer.Status.HALTED ){
                return;
            }
            //???????????????????????????????????????
            if(status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.READY || status == MediaPlayer.Status.STOPPED){
                //???????????????????????????????????????
                if(atEndOfMedia){
                    mediaPlayer.seek(mediaPlayer.getStartTime());
                    atEndOfMedia = false;
                }
                mediaPlayer.play();
                setIcon(playBT,pauseIcon,25);
            }else{   //??????????????????????????????
                mediaPlayer.pause();
                setIcon(playBT,playIcon,25);
            }
        });
    }

    //????????????????????????
    private void setPlayButton(){
        playBT.setOnAction((ActionEvent e)->{
            if(media == null)
                return;
            MediaPlayer.Status status = mediaPlayer.getStatus();
            if(status == MediaPlayer.Status.UNKNOWN || status == MediaPlayer.Status.HALTED ){
                return;
            }
            //???????????????????????????????????????
            if(status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.READY || status == MediaPlayer.Status.STOPPED){
                //???????????????????????????????????????
                if(atEndOfMedia){
                    mediaPlayer.seek(mediaPlayer.getStartTime());
                    atEndOfMedia = false;
                }
                mediaPlayer.play();
                setIcon(playBT,pauseIcon,25);
            }else{   //??????????????????????????????
                mediaPlayer.pause();
                setIcon(playBT,playIcon,25);
            }
        });
    }

    //????????????????????????
    private void setStopButton(){
        stopBT.setOnAction((ActionEvent e )->{
            if(media == null)
                return;
            mediaPlayer.stop();
            setIcon(playBT,playIcon,25);
        } );
    }

    //???????????????????????????
    private void setProcessSlider(){
        processSD.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(processSD.isValueChanging()){     //??????Slider????????????????????????????????????update??????????????????mediaPlayer??????????????????
                    mediaPlayer.seek(duration.multiply(processSD.getValue()/100.0));
                }
            }
        });
    }


    //???????????????????????????
//    public void setMaximizeButton(){
//        maxBT.setOnAction((ActionEvent e)->{
//            if(popup){
//                ((Stage)scene.getWindow()).setFullScreen(true);
//            }else{
//                mediaPlayer.pause();
//                setIcon(playBT,pauseIcon,25);
//                SimpleMediaPlayer_ref player = SimpleMediaPlayer_ref.popup(url);
//                player.getController().getMediaPlayer().seek(this.mediaPlayer.getCurrentTime());
//
//            }
//        });
//    }


    //????????????????????????
    private void setVolumeButton(){
        volumeBT.setOnAction((ActionEvent e)->{
            if(media == null)
                return;

            if(mediaPlayer.getVolume()>0){
                volumeValue = mediaPlayer.getVolume();
                volumeSD.setValue(0);
                setIcon(volumeBT,volOffIcon,25);
            }else{
                mediaPlayer.setVolume(volumeValue);
                volumeSD.setValue(volumeValue * 100);
                setIcon(volumeBT,volOnIcon,15);
            }
        });
    }

    //????????????????????????
    private void setVolumeSD(){
        volumeSD.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(newValue.doubleValue()/100);
            }
        });
    }

    //?????????????????????????????? ????????????????????????????????????
    protected void updateValues(){
        if(processSD != null && timeLB!=null && volumeSD != null && volumeBT != null){
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    Duration currentTime = mediaPlayer.getCurrentTime();
                    timeLB.setText(formatTime(currentTime,duration));    //??????????????????
                    processSD.setDisable(duration.isUnknown());   //????????????????????????????????????
                    if(!processSD.isDisabled() && duration.greaterThan(Duration.ZERO) && !processSD.isValueChanging()){
                        processSD.setValue(currentTime.toMillis()/duration.toMillis() * 100);   //???????????????
                    }
                    if(!volumeSD.isValueChanging()){
                        volumeSD.setValue((int)Math.round(mediaPlayer.getVolume() *100));   //???????????????
                        if(mediaPlayer.getVolume() == 0){        //??????????????????
                            setIcon(volumeBT,volOffIcon,20);
                        }else{
                            setIcon(volumeBT,volOnIcon,20);
                        }
                    }
                }
            });
        }
    }

    //???Duration??????????????????????????????????????????
    protected String formatTime(Duration elapsed,Duration duration){
        //?????????Duartion??????????????? hh???mm???ss??????????????????
        int intElapsed = (int)Math.floor(elapsed.toSeconds());
        int elapsedHours = intElapsed / (60 * 60);
        int elapsedMinutes = (intElapsed - elapsedHours *60 *60)/ 60;
        int elapsedSeconds = intElapsed - elapsedHours * 60 * 60 - elapsedMinutes * 60;
        if(duration.greaterThan(Duration.ZERO)){
            int intDuration = (int)Math.floor(duration.toSeconds());
            int durationHours = intDuration / (60 * 60);
            int durationMinutes = (intDuration - durationHours *60 * 60) / 60;
            int durationSeconds = intDuration - durationHours * 60 * 60 - durationMinutes * 60;

            if(durationHours > 0){
                return String.format("%02d:%02d:%02d / %02d:%02d:%02d",elapsedHours,elapsedMinutes,elapsedSeconds,durationHours,durationMinutes,durationSeconds);
            }else{
                return String.format("%02d:%02d / %02d:%02d",elapsedMinutes,elapsedSeconds,durationMinutes,durationSeconds);
            }
        }else{
            if(elapsedHours > 0){
                return String.format("%02d:%02d:%02d / %02d:%02d:%02d",elapsedHours,elapsedMinutes,elapsedSeconds);
            }else{
                return String.format("%02d:%02d / %02d:%02d",elapsedMinutes,elapsedSeconds);
            }
        }
    }

    //?????????????????????
    private void setIcon(Button button,String path,int size){
        Image icon = new Image(path);
        ImageView imageView = new ImageView(icon);
        imageView.setFitWidth(size);
        imageView.setFitHeight((int)(size * icon.getHeight() / icon.getWidth()));
        button.setGraphic(imageView);
        //???????????????????????????
        ColorAdjust colorAdjust = new ColorAdjust();
        button.setOnMousePressed(event ->  {
            colorAdjust.setBrightness(0.5);
            button.setEffect(colorAdjust);
        });
        button.setOnMouseReleased(event -> {
            colorAdjust.setBrightness(0);
            button.setEffect(colorAdjust);
        });
    }

    public MediaPlayer getMediaPlayer(){
        return this.mediaPlayer;
    }


    //??????????????????????????????????????????????????????????????????
   public void destroy(){
       if(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
           mediaPlayer.stop();
       }
       mediaPlayer.dispose();   //??????meidaPlayer???Media??????
       media = null;
       mediaPlayer = null;
       System.gc();    //??????JVM???????????????

   }


   //?????????????????????
    public void setSize(int width,int height){
        currentWidth = width;
        currentHeight  = height;
        setUISuitable();

    }
    //UI?????????????????????
    private void setUISuitable(){
//        bigAnchorPane.setPrefSize(currentWidth,currentHeight);
//        bigAnchorPane.setBottomAnchor(controlBar, 0.0);    //?????????????????????
//        bigAnchorPane.setTopAnchor(mediaPane,((double)currentHeight  - (double)currentWidth *(double)mediaHeight / (double)mediaWidth - 50)/2);  //????????????????????????
        mediaView.setFitWidth(currentWidth);       //??????MediaView??????
        mediaView.setFitHeight((double)currentWidth*(double)mediaHeight / (double)mediaHeight);
        controlBar.setPrefWidth(currentWidth);  //?????????????????????


    }

    public boolean getPopup(){
        return this.popup;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setIcon(playBT,playIcon,25);
        setIcon(stopBT,stopIcon,25);
        setIcon(volumeBT,volOnIcon,15);
        RecVideoDAOImpl RecVideoDAO = new RecVideoDAOImpl();
        video_view_times.setText(Integer.toString(RecVideoDAO.queryByCourseId(passValue.getCourseID()).getViewTime()));
        video_title.setText(RecVideoDAO.queryByCourseId(passValue.getCourseID()).getSubject()+"-Coach: "+RecVideoDAO.queryByCourseId(passValue.getCourseID()).getUserName());
        FavoriteVideo favoriteVideo = new FavoriteVideo(passValue.getCourseID(),passValue.getValue());
        FavoriteVideoImpl favoriteVideoDA0 = new FavoriteVideoImpl();
        if(favoriteVideoDA0.searchSame(favoriteVideo)){
            flag=true;
            collectBT.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
        }else{
            flag=false;
            collectBT.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        }
        //        setIcon(maxBT,maxIcon,25);
        //SimpleMediaPlayer_ref.newInstance("aa");


//        Parent root = FXMLLoader.load(getClass().getResource("../fxml/user_recording_video.fxml"));
//        rootVBox.getChildren().setAll(root);

//        Stage primaryStage = (Stage) playBT.getScene().getWindow();
//        primaryStage.setTitle("Test Meida");
//        Group root = new Group();
//        BorderPane pane = new BorderPane();
//
//        root.getChildren().add(pane);
//        HBox hbox = new HBox();
//        hbox.setAlignment(Pos.CENTER);
//        pane.setBottom(hbox);
//        Button popup = new Button("Popup");
//        Button popup2 = new Button("Popup small");
//        hbox.getChildren().addAll(popup,popup2);
//
//        SimpleMediaPlayer_ref player = SimpleMediaPlayer_ref.newInstance(getClass().getResource("/resource/WeChat_20210427231911.mp4").toString());
//        pane.setCenter(player);
//        pane.setAlignment(player,Pos.CENTER);
//
//
//        popup.setOnAction((ActionEvent e)->{
//            SimpleMediaPlayer_ref.popup(getClass().getResource("/resource/WeChat_20210427231911.mp4").toString());
//        });
//        popup2.setOnAction((ActionEvent e)->{
//            SimpleMediaPlayer_ref.popup(getClass().getResource("/resource/WeChat_20210427231911.mp4").toString(),550,400);
//        });
//
//
//        primaryStage.setScene(new Scene(root, 600, 500));
//        primaryStage.show();
    }

    public void playvideo(MouseEvent mouseEvent) {
        primaryStage = (Stage) playBT.getScene().getWindow();
        primaryStage.setTitle("Test Media");
        Group root = new Group();
        BorderPane pane = new BorderPane();
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.queryByUserName(passValue.getValue()).watchRecVideo(passValue.getCourseID());
        root.getChildren().add(pane);
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BASELINE_CENTER);
        pane.setCenter(hbox);


        //?????????????????????
        System.out.println(passValue.getCourseID());
        SimpleMediaPlayer_ref player = SimpleMediaPlayer_ref.newInstance(getClass().getResource("/BoundaryClass/Resource/Video/"+passValue.getCourseID()+".mp4").toString());
        pane.setCenter(player);
        pane.setAlignment(player,Pos.CENTER);



        //primaryStage.setScene(new Scene(root, 1500, 1000));
        primaryStage.setScene(new Scene(root, 1350, 807));
        primaryStage.show();
    }

//
//
//    public void Anotherstart(){
//        Stage primaryStage = (Stage) playBT.getScene().getWindow();
//
//        primaryStage.setTitle("Test Meida");
//        Group root = new Group();
//        BorderPane pane = new BorderPane();
//
//        root.getChildren().add(pane);
//        HBox hbox = new HBox();
//        hbox.setAlignment(Pos.CENTER);
//        pane.setBottom(hbox);
//        Button popup = new Button("Popup");
//        Button popup2 = new Button("Popup small");
//        hbox.getChildren().addAll(popup,popup2);
//
//        SimpleMediaPlayer_ref player = SimpleMediaPlayer_ref.newInstance(getClass().getResource("/resource/WeChat_20210427231911.mp4").toString());
//        pane.setCenter(player);
//        pane.setAlignment(player,Pos.CENTER);
//
//
//        popup.setOnAction((ActionEvent e)->{
//            SimpleMediaPlayer_ref.popup(getClass().getResource("/resource/WeChat_20210427231911.mp4").toString());
//        });
//        popup2.setOnAction((ActionEvent e)->{
//            SimpleMediaPlayer_ref.popup(getClass().getResource("/resource/WeChat_20210427231911.mp4").toString(),550,400);
//        });
//
//
//        primaryStage.setScene(new Scene(root, 600, 500));
//        primaryStage.show();
//    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        setIcon(playBT,playIcon,25);
//        setIcon(stopBT,stopIcon,25);
//        setIcon(volumeBT,volOnIcon,15);
//        setIcon(maxBT,maxIcon,25);
//        System.out.println("hhhhhhhhhhhh");
//        primaryStage.setTitle("Test Meida");
//        Group root = new Group();
//        BorderPane pane = new BorderPane();
//
//        root.getChildren().add(pane);
//        HBox hbox = new HBox();
//        hbox.setAlignment(Pos.CENTER);
//        pane.setBottom(hbox);
//        Button popup = new Button("Popup");
//        Button popup2 = new Button("Popup small");
//        hbox.getChildren().addAll(popup,popup2);
//
//        SimpleMediaPlayer_ref player = SimpleMediaPlayer_ref.newInstance(getClass().getResource("/resource/WeChat_20210427231911.mp4").toString());
//        pane.setCenter(player);
//        pane.setAlignment(player,Pos.CENTER);
//
//
//        popup.setOnAction((ActionEvent e)->{
//            SimpleMediaPlayer_ref.popup(getClass().getResource("/resource/WeChat_20210427231911.mp4").toString());
//        });
//        popup2.setOnAction((ActionEvent e)->{
//            SimpleMediaPlayer_ref.popup(getClass().getResource("/resource/WeChat_20210427231911.mp4").toString(),550,400);
//        });
//
//
//        primaryStage.setScene(new Scene(root, 600, 500));
//        primaryStage.show();
//    }
}
