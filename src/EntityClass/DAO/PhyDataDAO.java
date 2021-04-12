package EntityClass.DAO;

import EntityClass.VO.PhyData;

public interface PhyDataDAO {
    // insert
    Boolean insertPhyData(PhyData phyData);

    // delete
    Boolean deletePhyData(String userName);

    // update
    PhyData changePhyDataHeight(String userName, double height);
    PhyData changePhyDataWeight(String userName, double weight);
    PhyData changePhyDataExperience(String userName, int experience);
    PhyData changePhyDataInterest(String userName, String interest);
    PhyData changePhyDataBFR(String userName, double BRF);

    // select
    PhyData queryByUserName(String userName);
}
