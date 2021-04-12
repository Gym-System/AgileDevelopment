package EntityClass.DAO;

import EntityClass.VO.LiveSession;

import java.util.ArrayList;
import java.util.Date;

public interface LiveSessionDAO {
    // insert
    Boolean insertLiveSession(LiveSession liveSession);

    // delete
    Boolean deleteLiveSession(long courseId);

    // update
    LiveSession changeLiveSessionGift(long courseId, int gift);
    LiveSession changeLiveSessionStar(long courseId, double star);
    LiveSession changeLiveSessionStartTime(long courseId, String startTime);

    // select
    LiveSession queryByCourseId(long courseId);
    ArrayList<LiveSession> queryByTrainerName(String trainerName);
    ArrayList<LiveSession> queryByUserName(String userName);
    ArrayList<LiveSession> queryAll();
}
