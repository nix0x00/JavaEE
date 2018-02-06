/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller.report;

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
@WebServlet(name = "ReportFour", urlPatterns = {"/manager/report/ReportFour"})
public class ReportFour extends HttpServlet {
    
    @EJB
    DiagnosisFacade df;
    List<Diagnosis> d;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            d = df.findAll();
            if(d != null) {
                request.setAttribute("diagnosis", d);
                request.getRequestDispatcher("./report_four.jsp").include(request, response);
            } else {
                out.print("Error: Please try again.");
                request.getRequestDispatcher("./report_four.jsp").include(request, response);
            }
        } catch(Exception x) {
            x.printStackTrace();
            
            request.getRequestDispatcher("./reports.jsp").include(request, response);
            out.print("Error: Please try again.");
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
