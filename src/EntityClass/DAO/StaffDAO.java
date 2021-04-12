package EntityClass.DAO;

import EntityClass.VO.Staff;

import java.util.ArrayList;

public interface StaffDAO {
    // insert
    Boolean insertStaff(Staff staff);

    // delete
    Boolean deleteStaff(String userName);

    // update
    Staff changeStaffPassword(String userName, String password);
    Staff changeStaffEmail(String userName, String email);
    Staff changeStaffTeleNo(String userName, String teleNo);

    // select
    Staff queryByUserName(String userName);
    ArrayList<Staff> queryAll();
}
