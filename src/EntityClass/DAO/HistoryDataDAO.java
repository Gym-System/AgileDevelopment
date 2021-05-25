package EntityClass.DAO;

import EntityClass.VO.HistoryData;

import java.util.ArrayList;

public interface HistoryDataDAO {
    // insert
    Boolean insertHistoryData(HistoryData historyData);

    // delete
    Boolean deleteHistoryData(Long courseId);

    // select
    ArrayList<HistoryData> queryByUserName(String userName);
}
