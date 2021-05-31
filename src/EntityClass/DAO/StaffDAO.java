package EntityClass.DAO;

import EntityClass.VO.Staff;

import java.util.ArrayList;

/**
 * javadoc of StaffDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface StaffDAO {
    /**
     * This method insert a Staff class into staff.sv
     * @param staff A Staff class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertStaff(Staff staff);

    /**
     * This method query a staff record by userName and delete the record
     * @param staff A Staff class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deleteStaff(Staff staff);

    /**
     * This method query a staff record by userName and change the password value of the record
     * @param userName The userName of a staff
     * @param password The password value of a staff
     * @return A Staff class after changing
     */
    Staff changeStaffPassword(String userName, String password);

    /**
     * This method query a staff record by userName and change the email value of the record
     * @param userName The userName of a staff
     * @param email The email value of a staff
     * @return A Staff class after changing
     */
    Staff changeStaffEmail(String userName, String email);

    /**
     * This method query a staff record by userName and change the telephone number of the record
     * @param userName The userName of a staff
     * @param teleNo The telephone number of a staff
     * @return A Staff class after changing
     */
    Staff changeStaffTeleNo(String userName, String teleNo);

    /**
     * This method query a staff record by user name
     * @param userName The userName of a staff
     * @return A Staff class
     */
    Staff queryByUserName(String userName);

    /**
     * This method query all the staff records
     * @return A array list of Staff class
     */
    ArrayList<Staff> queryAll();
}
