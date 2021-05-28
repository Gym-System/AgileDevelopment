package EntityClass.DAO;

import EntityClass.VO.FavoriteVideo;
import EntityClass.VO.WatchedVideo;

import java.util.ArrayList;

public interface FavoriteVideoDAO {
    // insert
    Boolean insertHistoryData(FavoriteVideo favoriteVideo);

    // delete
    Boolean deleteHistoryData(Long courseId);

    // select
    ArrayList<FavoriteVideo> queryByUserName(String userName);
}
