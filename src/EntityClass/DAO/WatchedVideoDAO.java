package EntityClass.DAO;

import EntityClass.VO.WatchedVideo;

import java.util.ArrayList;

/**
 * javadoc of CourseDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface WatchedVideoDAO {
    /**
     * This method insert a WatchedVideo class into watchedVideo.sv
     * @param watchedVideo A WatchedVideo class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertHistoryData(WatchedVideo watchedVideo);

    /**
     * This method query a watchedVideo record by courseId and delete the record
     * @param watchedVideo A WatchedVideo class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deleteHistoryData(WatchedVideo watchedVideo);

    /**
     * This method query a course record by userName
     * @param userName The name of a user
     * @return A array list of WatchedVideo classes
     */
    ArrayList<WatchedVideo> queryByUserName(String userName);
}
