package EntityClass.DAO;

import EntityClass.VO.Person;

import java.util.ArrayList;

/**
 * javadoc of ManagerDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface PersonDAO {
    /**
     * This method insert a Person class into person.sv
     * @param person A Person class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertPerson(Person person);

    /**
     * This method query a person record by userName and delete the record
     * @param userName The userName of a person
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deletePerson(String userName);

    /**
     * This method query a person record by userName and change the password value of the record
     * @param userName The userName of a person
     * @param password The password value of a person
     * @return A Person class after changing
     */
    Person changePersonPassword(String userName, String password);

    /**
     * This method query a person record by userName and change the email value of the record
     * @param userName The userName of a person
     * @param email The email value of a person
     * @return A Person class after changing
     */
    Person changePersonEmail(String userName, String email);

    /**
     * This method query a person record by userName and change the telephone number of the record
     * @param userName The userName of a person
     * @param teleNo The telephone number of a person
     * @return A Person class after changing
     */
    Person changePersonTeleNo(String userName, String teleNo);

    /**
     * This method query a person record by user name
     * @param userName The userName of a person
     * @return A Person class
     */
    Person queryByUserName(String userName);

    /**
     * This method query all the person records
     * @return A array list of person class
     */
    ArrayList<Person> queryAll();
}
