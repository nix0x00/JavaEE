/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller.vet;

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
@WebServlet(name = "DiagnosisReport", urlPatterns = {"/vet/DiagnosisReport"})
public class DiagnosisReport extends HttpServlet {
    
    @EJB
            DiagnosisFacade df;
    List<Diagnosis> d = null;
    List<Diagnosis> diagnosis = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            d = df.findAll();
            if(d!= null) {
                for(int i = 0; i < d.size(); i++) {
                    if(!d.get(i).getLastFed().equals("") || d.get(i).getLastFed() != null) {
                        diagnosis.add(d.get(i));
                    }
                }
                request.setAttribute("diagnosis", diagnosis);
                request.getRequestDispatcher("./report.jsp").include(request, response);
            } else {
                request.getRequestDispatcher("./report.jsp").include(request, response);
                out.println("Error: Please try again later.");
            }
        } catch(Exception x) {
            request.getRequestDispatcher("./report.jsp").include(request, response);
            out.println("Error: Please try again later.");
            x.printStackTrace();
        }
    }
    
    
}
