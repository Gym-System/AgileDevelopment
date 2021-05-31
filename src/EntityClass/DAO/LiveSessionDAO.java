package EntityClass.DAO;

import EntityClass.VO.LiveSession;

import java.util.ArrayList;

/**
 * javadoc of LiveSessionDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface LiveSessionDAO {
    /**
     * This method insert a LiveSession class into liveSession.sv
     * @param liveSession A LiveSession class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertLiveSession(LiveSession liveSession);

    /**
     * This method query a LiveSession record by courseId and delete the record
     * @param liveSession A LiveSession class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deleteLiveSession(LiveSession liveSession);

    /**
     * This method query a LiveSession record by courseId and change the gift value of the record
     * @param courseId The ID of a LiveSession
     * @param gift The new gift value
     * @return A LiveSession class after changing
     */
    LiveSession changeLiveSessionGift(long courseId, int gift);

    /**
     * This method query a LiveSession record by courseId and change the star value of the record
     * @param courseId The ID of a LiveSession
     * @param star The new star value
     * @return A LiveSession class after changing
     */
    LiveSession changeLiveSessionStar(long courseId, double star);

    /**
     * This method query a LiveSession record by courseId and change the startTime value of the record
     * @param courseId The ID of a LiveSession
     * @param startTime The new startTime value
     * @return A LiveSession class after changing
     */
    LiveSession changeLiveSessionStartTime(long courseId, String startTime);

    /**
     * This method query a LiveSession record by courseId
     * @param courseId The ID of a LiveSession
     * @return A LiveSession class
     */
    LiveSession queryByCourseId(long courseId);

    /**
     * This method query LiveSession records by trainer name
     * @param trainerName The trainer name of LiveSession
     * @return A array list of LiveSession class
     */
    ArrayList<LiveSession> queryByTrainerName(String trainerName);

    /**
     * This method query LiveSession records by user name
     * @param userName The user name of LiveSession
     * @return A array list of LiveSession class
     */
    ArrayList<LiveSession> queryByUserName(String userName);

    /**
     * This method query all LiveSession records
     * @return A array list of LiveSession class
     */
    ArrayList<LiveSession> queryAll();
}
