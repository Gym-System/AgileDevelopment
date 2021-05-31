package EntityClass.DAO;

import EntityClass.VO.PremierUser;

import java.util.ArrayList;

/**
 * javadoc of PreUserDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface PreUserDAO {
    /**
     * This method insert a PremierUser class into premierUser.sv
     * @param premierUser A PremierUser class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertPreUser(PremierUser premierUser);

    /**
     * This method query a premierUser record by userName and delete the record
     * @param userName The userName of a premierUser
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deletePreUser(String userName);

    /**
     * This method query a premierUser record by userName and change the password value of the record
     * @param userName The userName of a premierUser
     * @param password The password value of a premierUser
     * @return A PremierUser class after changing
     */
    PremierUser changePreUserPassword(String userName, String password);

    /** This method query a premierUser record by userName and change the email value of the record
     * @param userName The userName of a premierUser
     * @param email The email value of a premierUser
     * @return A PremierUser class after changing
     */
    PremierUser changePreUserEmail(String userName, String email);

    /**
     * This method query a premierUser record by userName and change the telephone number of the record
     * @param userName The userName of a premierUser
     * @param teleNo The telephone number of a premierUser
     * @return A PremierUser class after changing
     */
    PremierUser changePreUserTeleNo(String userName, String teleNo);

    /**
     * This method query a premierUser record by userName and change the telephone number of the record
     * @param userName The userName of a premierUser
     * @param balance The balance of a premierUser
     * @return A PremierUser class after changing
     */
    PremierUser changePreUserBalance(String userName, Double balance);

    /**
     * This method query a premierUser record by userName and change the telephone number of the record
     * @param userName The userName of a premierUser
     * @param userType The userType of a premierUser
     * @return A PremierUser class after changing
     */
    PremierUser changePreUserType(String userName, int userType);

    /**
     * This method query a premierUser record by user name
     * @param userName The userName of a person
     * @return A PremierUser class
     */
    PremierUser queryByUserName(String userName);

    /**
     * This method query all the premierUser records
     * @return A array list of PremierUser class
     */
    ArrayList<PremierUser> queryAll();

    /**
     * This method search file for the same object
     *
     * @param preUser A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean searchSame(Object preUser);
}
