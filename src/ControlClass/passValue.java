package ControlClass;

import EntityClass.VO.Trainer;
import javafx.stage.Stage;

import java.util.ArrayList;

public class passValue {
    private static String value;
    private static Stage stage;
    private static String trainerName;
    private static ArrayList<Trainer> trainerlist;


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
}

