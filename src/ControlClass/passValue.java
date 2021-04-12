package ControlClass;


public class passValue {
    private static String value;

    public static String getValue(){
        return value;
    }

    public static void setValue(String value){
        passValue.value=value;
    }
}
