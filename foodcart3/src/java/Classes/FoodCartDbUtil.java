/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauro
 */
public class FoodCartDbUtil {
    
    private static Connection conn;
    private static Statement statement;

    public static List<Food> getFoodList() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        ArrayList<Food> food = new ArrayList<>();

        if (conn == null) {
            String url = "jdbc:mysql://localhost/";
            String DbName = "food";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "";

            try {
                Class.forName(driver);
                conn = (Connection) DriverManager.getConnection(url + DbName, userName, password);
                System.out.println("conection sucess");
                statement=conn.createStatement();
                 ResultSet rs=statement.executeQuery("select * from foodcart");
                //process the result

                while (rs.next()) {
                    int id = rs.getInt(1);
                    String item = rs.getString(2);
                    float price = rs.getFloat(3);
                    Food f = new Food(id, item, price);
                    food.add(f);
                }

            } catch (ClassNotFoundException | SQLException sqle) {
                System.out.println("conection FAIL");
            }

        } else {
            System.out.println("Ligacao ja aberta!!");
        }

        return food;

    }
}
