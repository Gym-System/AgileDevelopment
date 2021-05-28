package EntityClass.DAO;

import EntityClass.VO.WatchedVideo;

import java.util.ArrayList;

public interface WatchedVideoDAO {
    // insert
    Boolean insertHistoryData(WatchedVideo watchedVideo);

    // delete
    Boolean deleteHistoryData(Long courseId);

    // select
    ArrayList<WatchedVideo> queryByUserName(String userName);
}
