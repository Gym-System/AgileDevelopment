package EntityClass.DAO;

import EntityClass.VO.Trainer;

import java.util.ArrayList;

/**
 * javadoc of TrainerDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface TrainerDAO {
    /**
     * This method insert a Trainer class into trainer.sv
     * @param trainer A Trainer class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertTrainer(Trainer trainer);

    /**
     * This method query a trainer record by userName and delete the record
     * @param userName The userName of a trainer
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deleteTrainer(String userName);

    /**
     * This method query a trainer record by userName and change the password value of the record
     * @param userName The userName of a trainer
     * @param password The password value of a trainer
     * @return A Trainer class after changing
     */
    Trainer changeTrainerPassword(String userName, String password);

    /**
     * This method query a trainer record by userName and change the email value of the record
     * @param userName The userName of a trainer
     * @param email The email value of a trainer
     * @return A Trainer class after changing
     */
    Trainer changeTrainerEmail(String userName, String email);

    /**
     * This method query a trainer record by userName and change the telephone number of the record
     * @param userName The userName of a trainer
     * @param teleNo The telephone number of a trainer
     * @return A Trainer class after changing
     */
    Trainer changeTrainerTeleNo(String userName, String teleNo);

    /**
     * This method query a trainer record by userName and change the telephone number of the record
     * @param userName The userName of a trainer
     * @param salary The salary of a trainer
     * @return A Trainer class after changing
     */
    Trainer changeTrainerSalary(String userName, double salary);

    /**
     * This method query a trainer record by userName and change the telephone number of the record
     * @param userName The userName of a trainer
     * @param label The label of a trainer
     * @return A Trainer class after changing
     */
    Trainer changeTrainerLabel(String userName, String label);

    /**
     * This method query a trainer record by userName and change the telephone number of the record
     * @param userName The userName of a trainer
     * @param CV The CV of a trainer
     * @return A Trainer class after changing
     */
    Trainer changeTrainerCV(String userName, String CV);

    /**
     * This method query a trainer record by userName and change the telephone number of the record
     * @param userName The userName of a trainer
     * @param price The price of a trainer
     * @return A Trainer class after changing
     */
    Trainer changeTrainerPrice(String userName, double price);

    /**
     * This method query a trainer record by user name
     * @param userName The userName of a trainer
     * @return A Trainer class
     */
    Trainer queryByUserName(String userName);

    /**
     * This method query all the trainer records
     * @return A array list of Trainer class
     */
    ArrayList<Trainer> queryAll();
}
