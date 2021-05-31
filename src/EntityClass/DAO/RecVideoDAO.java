package EntityClass.DAO;

import EntityClass.VO.RecVideo;

import java.util.ArrayList;

/**
 * javadoc of RecVideoDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface RecVideoDAO {
    /**
     * This method insert a RecVideo class into recVideo.sv
     * @param recVideo A RecVideo class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertRecVideo(RecVideo recVideo);

    /**
     * This method query a recVideo record by courseId and delete the record
     * @param recVideo A RecVideo class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deleteRecVideo(RecVideo recVideo);

    /**
     * This method query a recVideo record by courseId and change the gift value of the record
     * @param courseId The ID of a recVideo
     * @param gift The new gift value
     * @return A RecVideo class after changing
     */
    RecVideo changeRecVideoGift(long courseId, int gift);

    /**
     * This method query a recVideo record by courseId and change the star value of the record
     * @param courseId The ID of a recVideo
     * @param star The new star value
     * @return A RecVideo class after changing
     */
    RecVideo changeRecVideoStar(long courseId, double star);

    /**
     * This method query a recVideo record by courseId and change the viewTime of the record
     * @param courseId The ID of a recVideo
     * @param viewTime How much time did the recorded video viewed
     * @return A RecVideo class after changing
     */
    RecVideo changeRecVideoViewTime(long courseId, int viewTime);

    /**
     * This method query a recVideo record by courseId and change the star value of the record
     * @param courseId The ID of a recVideo
     * @param rateTime How much time did the recorded video rated
     * @return A RecVideo class after changing
     */
    RecVideo changeRecVideoRateTime(long courseId, int rateTime);

    /**
     * This method query a recVideo record by courseId
     * @param courseId The ID of a recVideo
     * @return A RecVideo class
     */
    RecVideo queryByCourseId(long courseId);

    /**
     * This method query recVideo records by trainerName
     * @param trainerName The trainerName of recVideo
     * @return A array list of RecVideo class
     */
    ArrayList<RecVideo> queryByTrainerName(String trainerName);

    /**
     * This method query recVideo records by subject
     * @param subject The subject of recVideo
     * @return A array list of RecVideo class
     */
    ArrayList<RecVideo> queryBySubject(String subject);

    /**
     * This method query all the recVideo records
     * @return A array list of RecVideo class
     */
    ArrayList<RecVideo> queryAll();
}
