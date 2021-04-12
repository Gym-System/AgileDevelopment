package EntityClass.DAO;

import EntityClass.VO.User;

import java.util.ArrayList;

public interface UserDAO {
    // insert
    Boolean insertUser(User user);

    // delete
    Boolean deleteUser(String userName);

    // update
    User changeUserPassword(String userName, String password);
    User changeUserEmail(String userName, String email);
    User changeUserTeleNo(String userName, String teleNo);
    User changeUserBalance(String userName, Double balance);

    // select
    User queryByUserName(String userName);
    ArrayList<User> queryAll();
}
