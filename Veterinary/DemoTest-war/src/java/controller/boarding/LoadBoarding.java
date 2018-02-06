/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller.boarding;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.customer.Boarding;
import model.customer.BoardingFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "LoadBoarding", urlPatterns = {"/receptionist/boarding/LoadBoarding"})
public class LoadBoarding extends HttpServlet {
    
    @EJB
            BoardingFacade bf;
    List<Boarding> b = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            b = bf.findAll();
            if(b.get(0) != null || b != null) {
                request.setAttribute("boarding", b);
                request.getRequestDispatcher("./edit-boarding.jsp").include(request, response);
            } else {
                request.getRequestDispatcher("./edit-boarding.jsp").include(request, response);
                out.print("Error: Please try again.");
            }
        } catch (Exception x) {
            request.getRequestDispatcher("./edit-boarding.jsp").include(request, response);
            out.print("Error: Please try again.");
            x.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
