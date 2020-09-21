<%-- 
    Document   : View
    Created on : Jul 22, 2020, 10:05:13 AM
    Author     : Gayan Perera 
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        
        <h1>Books Details</h1>
        
       <% 
          List res = new ArrayList();
          res = (List)request.getAttribute("book_res");
          Iterator it = res.iterator();
            while(it.hasNext()){ %>
            <h2><%= it.next() %></h2>
             <%}%>
       
       
</html>
