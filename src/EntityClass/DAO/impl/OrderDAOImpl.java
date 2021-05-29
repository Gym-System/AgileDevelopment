package EntityClass.DAO.impl;

import EntityClass.DAO.OrderDAO;
import EntityClass.VO.Order;
import com.csvreader.CsvReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static EntityClass.DAO.impl.CourseDAOImpl.deleteInfo;
import static EntityClass.DAO.impl.PersonDAOImpl.insertInfo;

public class OrderDAOImpl implements OrderDAO {
    private Order order = null;
    private final String fileName = "order.csv";
    private String filePath = PersonDAOImpl.fileFolder + fileName;

    @Override
    public Boolean insertOrder(Order order) {
        return insertInfo(filePath, order.toStrArray());
    }

    @Override
    public Boolean deleteOrder(long courseId) {
        return deleteInfo(courseId, filePath);
    }

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
                    order = new Order(Long.parseLong(record[0]), record[1], Double.parseDouble(record[3]));
                    break;
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return order;
    }

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
                    order = new Order(Long.parseLong(record[0]), record[1], Double.parseDouble(record[3]));;
                    orders.add(order);
                }
            }
            csvReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return orders;
    }
}