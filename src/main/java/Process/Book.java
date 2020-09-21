/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gayan Perera
 */
class Book {
 
    Statement st;
  
    
    void addBook(String bname, String author, String description, int price) throws SQLException {
       
        connectToDb();
        String sql;
        sql = "INSERT INTO `book` (`Name`, `Author`, `Description`, `Unit Price`) VALUES ('"+bname+"', '"+author+"', '"+description+"', '"+price+"');";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void connectToDb() throws SQLException {
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/Onlinebookshop";
        
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,"root", "");
            st = con.createStatement();
            
            System.out.println("Connected! )");
            
         } catch (ClassNotFoundException|SQLException ex) {
            
            
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    ArrayList viewMovie() throws SQLException {
        
        connectToDb();
        String query = "SELECT * FROM book";
        List<String> Books = new ArrayList();
            Books.add("Hello");
       try{ 
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            Books.add(rs.getString("Name"));
            Books.add(rs.getString("Author"));
            Books.add(rs.getString("Description"));
            Books.add(rs.getInt("Unit Price") + " ");
         //   Books.add();
        }
      
         } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        
    }
            return  (ArrayList) Books;


   

       }}

