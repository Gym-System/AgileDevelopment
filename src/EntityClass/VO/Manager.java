package EntityClass.VO;

import EntityClass.DAO.impl.TrainerDAOImpl;
import EntityClass.DAO.impl.UserDAOImpl;

import java.util.Date;

public class Manager extends Staff {
    private int managerType = 0;

    public Manager(String userName, String password, String email) {
        super(userName, password, email);
    }

    public Manager(String userName, String password, String email, String gender, String telNo, Date doB, String companyName) {
        super(userName, password, email, gender, telNo, doB, companyName);
    }

    public Manager(String userName, String password, String email, String gender, String telNo, Date doB, String companyName, int managerType) {
        super(userName, password, email, gender, telNo, doB, companyName);
        this.managerType = managerType;
    }

    public int getManagerType() {
        return managerType;
    }

    public void setManagerType(int managerType) {
        this.managerType = managerType;
    }

    public boolean deleteUserInfo(String userName) {
        UserDAOImpl userDAO = new UserDAOImpl();
        return userDAO.deleteUser(userName);
    }

    public boolean deleteTrainerInfo(String userName) {
        TrainerDAOImpl trainerDAO = new TrainerDAOImpl();
        return trainerDAO.deleteTrainer(userName);
    }

    public Trainer changeTrainerSalary(String userName, double salary) {
        TrainerDAOImpl trainerDAO = new TrainerDAOImpl();
        return trainerDAO.changeTrainSalary(userName, salary);
    }

    @Override
    public String[] toStrArray() {
        String text = "" + super.getUserName() + "," + super.getPassword() + "," + super.getEmail() + "," + super.getGender() + "," +
                super.getTelNo() + "," + super.getDoB() + "," + super.getCompanyName() + "," + managerType;
        return text.split(",");
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerType=" + managerType +
                "} " + super.toString();
    }
}
