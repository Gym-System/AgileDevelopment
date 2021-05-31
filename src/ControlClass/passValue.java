package ControlClass;

import EntityClass.VO.RecVideo;
import EntityClass.VO.Trainer;
import javafx.stage.Stage;

import java.util.ArrayList;

public class passValue {
    private static String value;
    private static Stage stage;
    private static String trainerName;
    private static long courseID;

    public static String getRecType() {
        return recType;
    }

    public static void setRecType(String recType) {
        passValue.recType = recType;
    }

    private static String recType;
    public static ArrayList<RecVideo> getRecVideoslist() {
        return recVideoslist;
    }

    public static long getCourseID() {
        return courseID;
    }

    public static void setCourseID(long courseID) {
        passValue.courseID = courseID;
    }

    public static void setRecVideoslist(ArrayList<RecVideo> recVideoslist) {
        passValue.recVideoslist = recVideoslist;
    }

    private static ArrayList<Trainer> trainerlist;
    private static String uploadCourseID;
    private static ArrayList<RecVideo> recVideoslist;


    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        passValue.stage = stage;
    }

    public static String getValue(){
        return value;
    }

    public static void setValue(String value){
        passValue.value=value;
    }
    public static String getTrainerName(){
        return trainerName;
    }

    public static void setTrainerName(String trainerName){
        passValue.trainerName=trainerName;
    }

    public static ArrayList<Trainer> getTrainernamelist() {
        return trainerlist;
    }

    public static void setTrainernamelist(ArrayList<Trainer> trainernamelist) {
        passValue.trainerlist = trainernamelist;
    }

    public static String getUploadCourseID() {
        return uploadCourseID;
    }

    public static void setUploadCourseID(String uploadCourseID) {
        passValue.uploadCourseID = uploadCourseID;
    }
}

