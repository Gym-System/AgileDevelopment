package EntityClass.DAO;

/**
 * javadoc of ToolDAO interface
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public interface ToolDAO {
    /**
     * This method insert a Object class into csv file
     * @param obj A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean insertInfo(Object obj);

    /**
     * This method query a object record and delete the record
     * @param object A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean deleteInfo(Object object);

    /**
     * This method search file for the same object
     * @param object A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    Boolean searchSame(Object object);
}
