package EntityClass.DAO;

import EntityClass.VO.HistoryData;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface HistoryDataDAO {
    // insert
    Boolean insertHistoryData(HistoryData historyData);

    // select
    ArrayList<HistoryData> queryByUserName(String userName);
}
