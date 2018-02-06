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
@WebServlet(name = "SearchDiagnosis", urlPatterns = {"/staff/SearchDiagnosis"})
public class SearchDiagnosis extends HttpServlet {
    
    @EJB
            DiagnosisFacade df;
    List<Diagnosis> d = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            d = df.findAll();
            if(d!= null) {
                
                request.setAttribute("diagnosis", d);
                request.getRequestDispatcher("./pet-status.jsp").include(request, response);
            } else {
                request.getRequestDispatcher("./pet-status.jsp").include(request, response);
                out.println("Error: Please try again later.");
            }
        } catch(Exception x) {
            request.getRequestDispatcher("./pet-status.jsp").include(request, response);
            out.println("Error: Please try again later.");
            x.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
