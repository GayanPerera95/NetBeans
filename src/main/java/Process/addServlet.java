/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gayan Perera
 */
public class addServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String bname = request.getParameter("bname");
            String author = request.getParameter("author");
            String description = request.getParameter("des");
            int price = Integer.parseInt(request.getParameter("price"));
            Book b = new Book();
            b.addBook(bname,author,description,price);
            
            ArrayList blist = b.viewMovie();
            request.setAttribute("book_res", blist);
            RequestDispatcher rd = request.getRequestDispatcher("View.jsp");
           rd.forward(request, response);
         
        } catch (SQLException ex) {
            Logger.getLogger(addServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
