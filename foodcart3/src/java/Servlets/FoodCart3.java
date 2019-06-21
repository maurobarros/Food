/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.Food;
import Classes.FoodCartDbUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FoodCart3")
public class FoodCart3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        //String [] foodItems={"a","b","c"};
    
        try {
            
           List<Food>  foodItems = FoodCartDbUtil.getFoodList();
           request.setAttribute("foodItems", foodItems);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FoodCart3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FoodCart3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FoodCart3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FoodCart3.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        RequestDispatcher dispatcher=request.getRequestDispatcher("show-food.jsp");
        dispatcher.forward(request, response);

    }
}
   