package ControlClass;

import EntityClass.DAO.impl.RecVideoDAOImpl;
import EntityClass.DAO.impl.UserDAOImpl;
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
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.fxml.Initializable;

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
        mediaPlayer.stop();
        Stage stage = (Stage) user_facorites_hyper.getScene().getWindow();
        new APP().jump(stage,"user_favorites");

    }

    @FXML
    void user_recording_click(MouseEvent event) throws IOException {
        mediaPlayer.stop();
        Stage stage = (Stage) user_recording_hyper.getScene().getWindow();
        new APP().jump(stage,"user_recording");

    }

    @FXML
    void user_live_click(MouseEvent event) throws IOException {
        mediaPlayer.stop();
        Stage stage = (Stage) user_live_hyper.getScene().getWindow();
        new APP().jump(stage,"user_live");

    }

    @FXML
    void user_calendar_click(MouseEvent event) throws IOException {
        mediaPlayer.stop();
        Stage stage = (Stage) user_calendar_hyper.getScene().getWindow();
        new APP().jump(stage,"user_calendar");

    }

    @FXML
    void user_history_click(MouseEvent event) throws IOException {
        mediaPlayer.stop();
        Stage stage = (Stage) user_history_hyper.getScene().getWindow();
        new APP().jump(stage,"user_history");

    }

    @FXML
    void user_logout_click(MouseEvent event) throws IOException {
        mediaPlayer.stop();
        Stage stage = (Stage) user_history_hyper.getScene().getWindow();
        new APP().jump(stage,"login");

    }

    @FXML
    void add_collect(MouseEvent event) {
        RecVideoDAOImpl recVideoDAO = new RecVideoDAOImpl();
        //recVideoDAO.
        long courseid = passValue.getCourseID();
        System.out.println(courseid);
        UserDAOImpl UserDAO = new UserDAOImpl();
        UserDAO.queryByUserName(passValue.getValue()).favoriteVideo(courseid);
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
    void click_send_flower(ActionEvent event) {

    }

    @FXML
    void click_send_comment(ActionEvent event) {

    }

    @FXML
    void click_add_favorite_image(ActionEvent event) {

    }

    //控件素材图片
    private String playIcon  = getClass().getResource("/BoundaryClass/Resource/play.png").toString();
    private String pauseIcon  = getClass().getResource("/BoundaryClass/Resource/pause.png").toString();
    private String stopIcon  = getClass().getResource("/BoundaryClass/Resource/stop.png").toString();
    private String volOffIcon  = getClass().getResource("/BoundaryClass/Resource/volume_off.png").toString();
    private String volOnIcon  = getClass().getResource("/BoundaryClass/Resource/volume_On.png").toString();
    private String maxIcon  = getClass().getResource("/BoundaryClass/Resource/max.png").toString();
    private MediaPlayer mediaPlayer;
    private Media media;
    private String url;     //资源的url地址
    private boolean popup;   //窗口弹出方式
    private Scene scene ;  //父类窗口

    private boolean atEndOfMedia = false;    //记录视频是否处播放到结束
    private final boolean repeat = false;   //记录视频是否重复播放
    private double volumeValue;      //储存静音操作前的音量数据
    private Duration duration ;        //记录视频持续时间
    private int mediaHeight;        //视频资源的尺寸
    private int mediaWidth;

    private int currentHeight;    //当前整个播放器的尺寸
    private int currentWidth;
    private  Stage primaryStage=null;
    public void setScene(Scene scene){
        this.scene = scene;
    }


    //程序启动项，传入必要参数
    public void Anotherstart(String url, boolean popup, int width, int height){

        this.url = url;
        this.popup = popup;

        File file = new File("src/BoundaryClass/Resource/Video/"+ passValue.getCourseID() +".mp4");
        url = file.toURI().toString();
        System.out.println(url);


        //MediaView设置
        media = new Media(url);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        //设置播放器，在媒体资源加载完毕后，获取相应的数据，设置组件自适应布局
        setMediaPlayer(width,height);

        //设置各组件动作事件
        setMediaViewOnClick();
        setPlayButton();
        setStopButton();
        setVolumeButton();
        setVolumeSD();
        setProcessSlider();
        setMaximizeButton();

    }


    //设置mediaPlayer(参数：整个播放器的尺寸)
    void setMediaPlayer(int width,int height){
        mediaPlayer.setCycleCount(repeat ? MediaPlayer.INDEFINITE : 1);
        //视频就绪时更新 进度条 、时间标签、音量条数据,设置布局尺寸
        mediaPlayer.setOnReady(new Runnable(){
            @Override
            public void run() {
                duration = mediaPlayer.getMedia().getDuration();
                volumeValue = mediaPlayer.getVolume();
                mediaHeight = media.getHeight();
                mediaWidth = media.getWidth();

                //设置布局尺寸
                setSize(width,height);

                //设置尺寸随窗口改变自适应变化（只使用于弹窗）

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
                //设置全屏时的UI变化:工具栏只有在鼠标进入MediaView时才出现
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
        //mediaPlayer当前进度发生改变时候，进度条 、时间标签、音量条数据
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>(){
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                updateValues();
            }
        });
    }
    //设置点击MediaView时暂停或开始
    private void setMediaViewOnClick(){
        mediaView.setOnMouseClicked(event -> {
            if(media == null)
                return;
            MediaPlayer.Status status = mediaPlayer.getStatus();
            if(status == MediaPlayer.Status.UNKNOWN || status == MediaPlayer.Status.HALTED ){
                return;
            }
            //当资源处于暂停或停止状态时
            if(status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.READY || status == MediaPlayer.Status.STOPPED){
                //当资源播放结束时，重绕资源
                if(atEndOfMedia){
                    mediaPlayer.seek(mediaPlayer.getStartTime());
                    atEndOfMedia = false;
                }
                mediaPlayer.play();
                setIcon(playBT,pauseIcon,25);
            }else{   //当资源处于播放状态时
                mediaPlayer.pause();
                setIcon(playBT,playIcon,25);
            }
        });
    }

    //设置播放按钮动作
    private void setPlayButton(){
        playBT.setOnAction((ActionEvent e)->{
            if(media == null)
                return;
            MediaPlayer.Status status = mediaPlayer.getStatus();
            if(status == MediaPlayer.Status.UNKNOWN || status == MediaPlayer.Status.HALTED ){
                return;
            }
            //当资源处于暂停或停止状态时
            if(status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.READY || status == MediaPlayer.Status.STOPPED){
                //当资源播放结束时，重绕资源
                if(atEndOfMedia){
                    mediaPlayer.seek(mediaPlayer.getStartTime());
                    atEndOfMedia = false;
                }
                mediaPlayer.play();
                setIcon(playBT,pauseIcon,25);
            }else{   //当资源处于播放状态时
                mediaPlayer.pause();
                setIcon(playBT,playIcon,25);
            }
        });
    }

    //设置停止按钮动作
    private void setStopButton(){
        stopBT.setOnAction((ActionEvent e )->{
            if(media == null)
                return;
            mediaPlayer.stop();
            setIcon(playBT,playIcon,25);
        } );
    }

    //设置视频进度条动作
    private void setProcessSlider(){
        processSD.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(processSD.isValueChanging()){     //加入Slider正在改变的判定，否则由于update线程的存在，mediaPlayer会不停地回绕
                    mediaPlayer.seek(duration.multiply(processSD.getValue()/100.0));
                }
            }
        });
    }


    //设置最大化按钮动作
    public void setMaximizeButton(){
        maxBT.setOnAction((ActionEvent e)->{
            if(popup){
                ((Stage)scene.getWindow()).setFullScreen(true);
            }else{
                mediaPlayer.pause();
                setIcon(playBT,pauseIcon,25);
                SimpleMediaPlayer_ref player = SimpleMediaPlayer_ref.popup(url);
                player.getController().getMediaPlayer().seek(this.mediaPlayer.getCurrentTime());

            }
        });
    }


    //设置音量按钮动作
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

    //设置音量滑条动作
    private void setVolumeSD(){
        volumeSD.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(newValue.doubleValue()/100);
            }
        });
    }

    //更新视频数据（进度条 、时间标签、音量条数据）
    protected void updateValues(){
        if(processSD != null && timeLB!=null && volumeSD != null && volumeBT != null){
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    Duration currentTime = mediaPlayer.getCurrentTime();
                    timeLB.setText(formatTime(currentTime,duration));    //设置时间标签
                    processSD.setDisable(duration.isUnknown());   //无法读取时间是隐藏进度条
                    if(!processSD.isDisabled() && duration.greaterThan(Duration.ZERO) && !processSD.isValueChanging()){
                        processSD.setValue(currentTime.toMillis()/duration.toMillis() * 100);   //设置进度条
                    }
                    if(!volumeSD.isValueChanging()){
                        volumeSD.setValue((int)Math.round(mediaPlayer.getVolume() *100));   //设置音量条
                        if(mediaPlayer.getVolume() == 0){        //设置音量按钮
                            setIcon(volumeBT,volOffIcon,20);
                        }else{
                            setIcon(volumeBT,volOnIcon,20);
                        }
                    }
                }
            });
        }
    }

    //将Duration数据格式化，用于播放时间标签
    protected String formatTime(Duration elapsed,Duration duration){
        //将两个Duartion参数转化为 hh：mm：ss的形式后输出
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

    //为按钮获取图标
    private void setIcon(Button button,String path,int size){
        Image icon = new Image(path);
        ImageView imageView = new ImageView(icon);
        imageView.setFitWidth(size);
        imageView.setFitHeight((int)(size * icon.getHeight() / icon.getWidth()));
        button.setGraphic(imageView);
        //设置图标点击时发亮
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


    //设置关闭窗口时的动作，手动释放资源，回收内存
   public void destroy(){
       if(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
           mediaPlayer.stop();
       }
       mediaPlayer.dispose();   //释放meidaPlayer的Media资源
       media = null;
       mediaPlayer = null;
       System.gc();    //通知JVM垃圾回收器

   }


   //设置播放器尺寸
    public void setSize(int width,int height){
        currentWidth = width;
        currentHeight  = height;
        setUISuitable();

    }
    //UI控件自适应大小
    private void setUISuitable(){
//        bigAnchorPane.setPrefSize(currentWidth,currentHeight);
//        bigAnchorPane.setBottomAnchor(controlBar, 0.0);    //设置控制条位置
//        bigAnchorPane.setTopAnchor(mediaPane,((double)currentHeight  - (double)currentWidth *(double)mediaHeight / (double)mediaWidth - 50)/2);  //设置视频面板位置
        mediaView.setFitWidth(currentWidth);       //设置MediaView尺寸
        mediaView.setFitHeight((double)currentWidth*(double)mediaHeight / (double)mediaHeight);
        controlBar.setPrefWidth(currentWidth);  //设置工具条宽度


    }

    public boolean getPopup(){
        return this.popup;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setIcon(playBT,playIcon,25);
        setIcon(stopBT,stopIcon,25);
        setIcon(volumeBT,volOnIcon,15);
        setIcon(maxBT,maxIcon,25);
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

        root.getChildren().add(pane);
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BASELINE_CENTER);
        pane.setCenter(hbox);


        //测试嵌入式调用
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
