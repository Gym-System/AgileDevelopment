package EntityClass.DAO;

import EntityClass.VO.Course;
import EntityClass.VO.Order;

import java.util.ArrayList;

public interface OrderDAO {
    // insert
    Boolean insertOrder(Order order);

    // delete
    Boolean deleteOrder(long courseId);

    // select
    Order queryByCourseId(long courseId);
    ArrayList<Order> queryByUserName(String userName);
}
