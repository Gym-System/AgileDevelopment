package ControlClass;

import javafx.stage.Stage;

public class passValue {
    private static String value;
    private static Stage stage;

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
}
