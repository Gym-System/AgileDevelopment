package Test;

import EntityClass.DAO.Impl.UserDAOImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

    public boolean loginValidation(String name, String password){
        boolean flag = true;
        UserDAOImpl userDAO = new UserDAOImpl();
        if (name.equals("") || password.equals("")){
            flag = false;
        } else {
            if (userDAO.queryByUserName(name) == null){
                flag = false;
            } else {
                if (!userDAO.queryByUserName(name).getPassword().equals(password)){
                    flag = false;
                }
            }
        }
        return flag;
    }

    public boolean registerValidation(String name, String emailAddress, String gender, String password, String confirmPassword, String date, String telNo) throws ParseException {
        boolean flag = true;
        SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd");


        if (name.equals("")){
            flag = false;
        }
        if (!emailAddress.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$") || emailAddress.equals("")) {
            flag =false;
        }
        if (!gender.equals("male") && !gender.equals("female")) {
            flag = false;
        }
        if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,}$") || password.equals("")){
            flag = false;
        }
        if (!confirmPassword.equals(password) || confirmPassword.equals("")) {
            flag = false;
        }
        if (pattern.parse(date).after((new Date()))){
            flag = false;
        }

        if (!telNo.matches("^(1[0-9])\\d{9}$") || telNo.equals("")) {
            flag = false;
        }
        return flag;
    }
}
