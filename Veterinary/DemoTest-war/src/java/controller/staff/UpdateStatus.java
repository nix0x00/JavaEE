/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller.staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.customer.Diagnosis;
import model.customer.DiagnosisFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "UpdateStatus", urlPatterns = {"/staff/UpdateStatus"})
public class UpdateStatus extends HttpServlet {
    
    @EJB
            DiagnosisFacade df;
    List<Diagnosis> d;
    private long id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            id = Long.parseLong(request.getParameter("pk"));
            d = df.getListDiagnosis(id);
            
            if(d != null) {
                request.setAttribute("diagnosis", d);
                request.getRequestDispatcher("./pet_status.jsp").include(request, response);
            } else {
                out.print("<html>Error: Please try again.</html>");
                request.getRequestDispatcher("./index.jsp").include(request, response);
            }
            
        } catch(Exception x) {
            out.print("<html>Error: Please try again.</html>");
            request.getRequestDispatcher("./index.jsp").include(request, response);
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
