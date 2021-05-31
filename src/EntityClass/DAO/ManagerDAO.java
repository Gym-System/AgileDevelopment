package EntityClass.DAO;

import EntityClass.VO.Manager;

import java.util.ArrayList;

/**
 * javadoc of ManagerDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface ManagerDAO {
    /**
     * This method insert a Manager class into manager.sv
     * @param manager A Manager class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertManager(Manager manager);

    /**
     * This method query a manager record by userName and delete the record
     * @param manager A Manager class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deleteManager(Manager manager);

    /**
     * This method query a manager record by userName and change the password value of the record
     * @param userName The userName of a manager
     * @param password The password value of a manager
     * @return A Manager class after changing
     */
    Manager changeManagerPassword(String userName, String password);

    /**
     * This method query a manager record by userName and change the email value of the record
     * @param userName The userName of a manager
     * @param email The email value of a manager
     * @return A Manager class after changing
     */
    Manager changeManagerEmail(String userName, String email);

    /**
     * This method query a manager record by userName and change the telephone number of the record
     * @param userName The userName of a manager
     * @param teleNo The telephone number of a manager
     * @return A Manager class after changing
     */
    Manager changeManagerTeleNo(String userName, String teleNo);

    /**
     * This method query a manager record by userName and change the manager type of the record
     * @param userName The userName of a manager
     * @param managerType The manager type of a manager
     * @return A Manager class after changing
     */
    Manager changeManagerType(String userName, int managerType);

    /**
     * This method query a manager record by user name
     * @param userName The userName of a manager
     * @return A Manager class
     */
    Manager queryByUserName(String userName);

    /**
     * This method query all the manager records
     * @return A array list of manager class
     */
    ArrayList<Manager> queryAll();
}
