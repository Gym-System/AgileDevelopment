package EntityClass.DAO.impl;

import EntityClass.DAO.OrderDAO;
import EntityClass.DAO.ToolDAO;
import EntityClass.VO.Order;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.*;
import java.util.ArrayList;

import static EntityClass.DAO.impl.PersonDAOImpl.recordToCsv;

/**
 * javadoc of OrderDAOImpl class
 * @author Kaiyi Zhao
 * @version 1.0
 * {@inheritDoc}
 */
public class OrderDAOImpl implements ToolDAO, OrderDAO {
    private Order order = null;
    private final String fileName = "order.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    /**
     * This method insert a Order class into order.sv
     * @param order A Order class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertOrder(Order order) {
        if(!searchSame(order)) {
            return insertInfo(order);
        }
        else {
            return false;
        }
    }

    /**
     * This method query a Oder record by courseId and delete the record
     * @param order A Order class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteOrder(Order order) {
        return deleteInfo(order);
    }

    /**
     * This method query a Order record by courseId
     * @param courseId The ID of a Oder
     * @return A Order class
     */
    @Override
    public Order queryByCourseId(long courseId) {
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(courseId == Long.parseLong(record[0])) {
                    order = new Order(Long.parseLong(record[0]), record[1], Double.parseDouble(record[2]));
                    break;
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return order;
    }

    /**
     * This method query order records by user name
     * @param userName The name of the user who make the order
     * @return A array list of Order class
     */
    @Override
    public ArrayList<Order> queryByUserName(String userName) {
        ArrayList<Order> orders = new ArrayList<>();
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                if(userName.equals(record[1])) {
                    order = new Order(Long.parseLong(record[0]), record[1], Double.parseDouble(record[2]));
                    orders.add(order);
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    /**
     * This method insert a Object class into csv file
     *
     * @param obj A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean insertInfo(Object obj) {
        if(obj instanceof Order) {
            Order order = (Order) obj;
            boolean flag = false;
            File outFile = new File(filePath);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));
                CsvWriter csvWriter = new CsvWriter(writer,',');
                csvWriter.writeRecord(order.toStrArray());
                csvWriter.close();
                flag = true;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return flag;
        }
        else {
            return false;
        }
    }

    /**
     * This method query a object record and delete the record
     *
     * @param object A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean deleteInfo(Object object) {
        if(object instanceof Order) {
            Order order = (Order) object;
            Boolean flag = false;
            File inFile = new File(filePath);
            try {
                String[] record;
                ArrayList<String[]> records = new ArrayList<>();
                BufferedReader reader = new BufferedReader(new FileReader(inFile));
                CsvReader csvReader = new CsvReader(reader, ',');
                while(csvReader.readRecord()){
                    record = csvReader.getRawRecord().split(",");
                    if(order.getCourseId() == Long.parseLong(record[0])) {
                        continue;
                    }
                    assert records != null;
                    records.add(record);
                }
                csvReader.close();
                recordToCsv(records, filePath);
                flag = true;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return flag;
        }
        else {
            return false;
        }
    }

    /**
     * This method search file for the same object
     * @param order A Object class
     * @return A boolean value indicating whether the operation is completed successfully
     */
    @Override
    public Boolean searchSame(Object order) {
        Order orderExist = null;
        File inFile = new File(filePath);
        try {
            String[] record;
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            CsvReader csvReader = new CsvReader(reader, ',');
            while(csvReader.readRecord()){
                record = csvReader.getValues();
                orderExist = new Order(Long.parseLong(record[0]), record[1], Double.parseDouble(record[2]));;
                if(order.equals(orderExist)) {
                    return true;
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}