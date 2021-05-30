package EntityClass.DAO;

import EntityClass.VO.PhyData;

import java.util.ArrayList;

/**
 * javadoc of PhyDataDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface PhyDataDAO {
    /**
     * This method insert a PhyData class into phyData.sv
     * @param phyData A PhyData class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertPhyData(PhyData phyData);

    /**
     * This method query a phyData record by userName and delete the record
     * @param userName The userName of a person
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deletePhyData(String userName);

    /**
     * This method query a person record by userName and change the height value of the record
     * @param userName The userName of a person
     * @param height The height value of a person
     * @return A PhyData class after changing
     */
    PhyData changePhyDataHeight(String userName, double height);

    /**
     * This method query a person record by userName and change the weight value of the record
     * @param userName The userName of a person
     * @param weight The weight value of a person
     * @return A PhyData class after changing
     */
    PhyData changePhyDataWeight(String userName, double weight);

    /**
     * This method query a person record by userName and change the experience value of the record
     * @param userName The userName of a person
     * @param experience The experience value of a person
     * @return A PhyData class after changing
     */
    PhyData changePhyDataExperience(String userName, int experience);

    /**
     * This method query a person record by userName and change the interest value of the record
     * @param userName The userName of a person
     * @param interest The interest value of a person
     * @return A PhyData class after changing
     */
    PhyData changePhyDataInterest(String userName, String interest);

    /**
     * This method query a person record by userName and change the BRF value of the record
     * @param userName The userName of a person
     * @param BRF The BRF value of a person
     * @return A PhyData class after changing
     */
    PhyData changePhyDataBFR(String userName, double BRF);

    /**
     * This method query a PhyData record by user name
     * @param userName The userName of a person
     * @return A PhyData class
     */
    PhyData queryByUserName(String userName);

    /**
     * This method query all the PhyData records
     * @return A array list of PhyData class
     */
    ArrayList<PhyData> queryAll();
}
