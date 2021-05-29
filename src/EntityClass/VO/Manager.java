package EntityClass.VO;

import EntityClass.DAO.impl.TrainerDAOImpl;
import EntityClass.DAO.impl.UserDAOImpl;

import java.util.Date;

/**
 * javadoc of Manager class
 * @author Kaiyi Zhao
 * @version 1.0
 */
public class Manager extends Staff {
    private int managerType = 0;

    /**
     * This constructor contains major params needed to make a instance of Manager class.
     * @param userName The userName of a manager
     * @param password The password of a manager
     * @param email The email of a manager
     */
    public Manager(String userName, String password, String email) {
        super(userName, password, email);
    }

    /**
     * This constructor contains all params needed to make a instance of Manager class.
     * @param userName The userName of a manager
     * @param password The password of a manager
     * @param email The email of a manager
     * @param gender The gender of a manager
     * @param telNo The telephone number of a manager
     * @param doB The date of birth of a manager
     * @param companyName Name of the company manager is in
     * @param managerType Which level does the manager in
     */
    public Manager(String userName, String password, String email, String gender, String telNo, Date doB, String companyName, int managerType) {
        super(userName, password, email, gender, telNo, doB, companyName);
        this.managerType = managerType;
    }

    /**
     * The getter method of managerType
     * @return managerType
     */
    public int getManagerType() {
        return managerType;
    }

    /**
     * The setter method of managerType
     * @param managerType Which level does the manager in
     */
    public void setManagerType(int managerType) {
        this.managerType = managerType;
    }

    /**
     * The method delete user information from user.csv
     * @param userName The userName of a user
     * @return boolean value indicates whether the delete operation is completed
     */
    public boolean deleteUserInfo(String userName) {
        UserDAOImpl userDAO = new UserDAOImpl();
        return userDAO.deleteUser(userName);
    }

    /**
     * The method delete trainer information from trainer.csv
     * @param userName The userName of a trainer
     * @return boolean value indicates whether the delete operation is completed
     */
    public boolean deleteTrainerInfo(String userName) {
        TrainerDAOImpl trainerDAO = new TrainerDAOImpl();
        return trainerDAO.deleteTrainer(userName);
    }

    /**
     * The method change trainer salary from trainer.csv
     * @param userName The userName of a trainer
     * @param salary The salary of a trainer
     * @return Trainer class after the change
     */
    public Trainer changeTrainerSalary(String userName, double salary) {
        TrainerDAOImpl trainerDAO = new TrainerDAOImpl();
        return trainerDAO.changeTrainerSalary(userName, salary);
    }

    /**
     * This method organize instance variables of Manager class into a string array
     * @return A string array contain instance variables of Manager class
     */
    @Override
    public String[] toStrArray() {
        String text = "" + super.getUserName() + "," + super.getPassword() + "," + super.getEmail() + "," + super.getGender() + "," +
                super.getTelNo() + "," + super.getDoB() + "," + super.getCompanyName() + "," + managerType;
        return text.split(",");
    }

    /**
     * This method organize instance variables of Manager class into a readable way
     * @return A string contains instance variables of Manager class
     */
    @Override
    public String toString() {
        return "Manager{" +
                "managerType=" + managerType +
                "} " + super.toString();
    }
}
