package EntityClass.DAO;

import EntityClass.VO.PremierUser;
import EntityClass.VO.User;

public interface PreUserDAO {
    // insert
    Boolean insertPreUser(PremierUser premierUser);

    // delete
    Boolean deletePreUser(String userName);

    // update
    PremierUser changePreUserPassword(String userName, String password);
    PremierUser changePreUserEmail(String userName, String email);
    PremierUser changePreUserTeleNo(String userName, String teleNo);
    PremierUser changePreUserBalance(String userName, Double balance);
    PremierUser changePreUserType(String userName, int userType);

    // select
    PremierUser queryByUserName(String userName);
}
