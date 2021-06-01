package EntityClass.DAO;

import EntityClass.VO.Course;
import EntityClass.VO.Regulation;

import java.util.ArrayList;

/**
 * javadoc of RegulationDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface RegulationDAO {
    /**
     * This method insert a Regulation class into regulation.sv
     * @param regulation A Regulation class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertRegulation(Regulation regulation);

    /**
     * This method query a Regulation record by userType and delete the record
     * @param regulation A Regulation class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deleteRegulation(Regulation regulation);

    /**
     * This method query a regulation record by user type
     * @param userType The user type of regulation
     * @return A Regulation class
     */
    Regulation queryByUserType(int userType);

    /**
     * This method query all the regulation records
     * @return A array list of regulation class
     */
    ArrayList<Regulation> queryAll();
}
