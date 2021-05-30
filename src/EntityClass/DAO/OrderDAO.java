package EntityClass.DAO;

import EntityClass.VO.Order;

import java.util.ArrayList;

/**
 * javadoc of OrderDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 */
public interface OrderDAO {
    /**
     * This method insert a Order class into order.sv
     * @param order A Order class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertOrder(Order order);

    /**
     * This method query a Oder record by courseId and delete the record
     * @param courseId The ID of a course
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deleteOrder(long courseId);

    /**
     * This method query a Order record by courseId
     * @param courseId The ID of a Oder
     * @return A Order class
     */
    Order queryByCourseId(long courseId);

    /**
     * This method query order records by user name
     * @param userName The name of the user who make the order
     * @return A array list of Order class
     */
    ArrayList<Order> queryByUserName(String userName);
}
