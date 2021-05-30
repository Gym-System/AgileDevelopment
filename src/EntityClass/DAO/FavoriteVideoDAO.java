package EntityClass.DAO;

import EntityClass.VO.FavoriteVideo;

import java.util.ArrayList;

/**
 * javadoc of FavoriteVideoDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface FavoriteVideoDAO {
    /**
     * This method insert a FavoriteVideo class into favoriteVideo.sv
     * @param favoriteVideo A FavoriteVideo class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertFavoriteVideo(FavoriteVideo favoriteVideo);

    /**
     * This method query a FavoriteVideo record by courseId and delete the record
     * @param courseId The ID of a FavoriteVideo
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deleteFavoriteVideo(Long courseId);

    /**
     * This method query a FavoriteVideo record by userName
     * @param userName The userName in a record
     * @return A array list of FavoriteVideo class
     */
    ArrayList<FavoriteVideo> queryByUserName(String userName);
}
