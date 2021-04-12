package EntityClass.DAO;

import EntityClass.VO.Trainer;

import java.util.ArrayList;

public interface TrainerDAO {
    // insert
    Boolean insertTrainer(Trainer trainer);

    // delete
    Boolean deleteTrainer(String userName);

    // update
    Trainer changeTrainerPassword(String userName, String password);
    Trainer changeTrainerEmail(String userName, String email);
    Trainer changeTrainerTeleNo(String userName, String teleNo);
    Trainer changeTrainSalary(String userName, double salary);

    // select
    Trainer queryByUserName(String userName);
    ArrayList<Trainer> queryAll();
}
