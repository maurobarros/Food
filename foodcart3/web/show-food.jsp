<%-- 
    Document   : newjsp
    Created on : 21/Jun/2019, 12:13:42
    Author     : Mauro
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <table border="1" cellpadding="30%">
           
            <tr>
                <th>Code</th> <th>Item</th> <th>Price</th>
            </tr>
      
    <c:forEach var="items" items="${foodItems}">
         <tr>
        <td>${items.id}</td> 
         <td>${items.item}</td> 
          <td>${items.price}</td> 
          
        </tr>     
   </c:forEach>     
   
    </table>
        
    </body>
</html>
