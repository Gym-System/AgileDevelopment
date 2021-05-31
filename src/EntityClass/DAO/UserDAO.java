package EntityClass.DAO;

import EntityClass.VO.User;

import java.util.ArrayList;

/**
 * javadoc of PreUserDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface UserDAO {
    /**
     * This method insert a User class into user.sv
     * @param user A User class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertUser(User user);

    /**
     * This method query a user record by userName and delete the record
     * @param user A User class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deleteUser(User user);

    /**
     * This method query a user record by userName and change the password value of the record
     * @param userName The userName of a user
     * @param password The password value of a user
     * @return A User class after changing
     */
    User changeUserPassword(String userName, String password);

    /** This method query a user record by userName and change the email value of the record
     * @param userName The userName of a user
     * @param email The email value of a user
     * @return A User class after changing
     */
    User changeUserEmail(String userName, String email);

    /**
     * This method query a user record by userName and change the telephone number of the record
     * @param userName The userName of a user
     * @param teleNo The telephone number of a user
     * @return A User class after changing
     */
    User changeUserTeleNo(String userName, String teleNo);

    /**
     * This method query a user record by userName and change the telephone number of the record
     * @param userName The userName of a user
     * @param balance The balance of a user
     * @return A User class after changing
     */
    User changeUserBalance(String userName, Double balance);

    /**
     * This method query a user record by user name
     * @param userName The userName of a user
     * @return A User class
     */
    User queryByUserName(String userName);

    /**
     * This method query all the user records
     * @return A array list of user class
     */
    ArrayList<User> queryAll();

    /**
     * This method search file for the same object
     *
     * @param user A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean searchSame(Object user);
}
