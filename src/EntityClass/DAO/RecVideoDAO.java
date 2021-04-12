package EntityClass.DAO;

import EntityClass.VO.RecVideo;

import java.util.ArrayList;

public interface RecVideoDAO {
    // insert
    Boolean insertRecVideo(RecVideo recVideo);

    // delete
    Boolean deleteRecVideo(long courseId);

    // update
    RecVideo changeRecVideoGift(long courseId, int gift);
    RecVideo changeRecVideoStar(long courseId, double star);
    RecVideo changeRecVideoViewTime(long courseId, int viewTime);

    // select
    RecVideo queryByCourseId(long courseId);
    ArrayList<RecVideo> queryByTrainerName(String trainerName);
    ArrayList<RecVideo> queryBySubject(String subject);
    ArrayList<RecVideo> queryAll();
}
