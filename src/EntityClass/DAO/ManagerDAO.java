package EntityClass.DAO;

import EntityClass.VO.Manager;

import java.util.ArrayList;

public interface ManagerDAO {
    // insert
    Boolean insertManager(Manager manager);

    // delete
    Boolean deleteManager(String userName);

    // update
    Manager changeManagerPassword(String userName, String password);
    Manager changeManagerEmail(String userName, String email);
    Manager changeManagerTeleNo(String userName, String teleNo);
    Manager changeManagerType(String userName, int managerType);

    // select
    Manager queryByUserName(String userName);
    ArrayList<Manager> queryAll();
}
