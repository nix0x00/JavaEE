/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller.report;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.customer.Appointment;
import model.customer.AppointmentFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "ReportThree", urlPatterns = {"/manager/report/ReportThree"})
public class ReportThree extends HttpServlet {
    
    @EJB
            AppointmentFacade af;
    List<Appointment> ap;
    double price;
    Appointment app;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ap = af.getPrice();
            if(ap != null) {
                for(int i = 0; i < ap.size(); i++) {
                    price += ap.get(i).getPrice();
                }
                app = new Appointment();
                app.setPrice(price);
                app.setTel(String.valueOf(ap.size()));
                ap = new ArrayList<Appointment>();
                ap.add(app);
                request.setAttribute("appointment", ap);
                request.getRequestDispatcher("./report_three.jsp").include(request, response);
            } else {
                request.getRequestDispatcher("./report_three.jsp").include(request, response);
            }
            
        } catch(Exception x) {
            out.print("Error: Please try again.");
            request.getRequestDispatcher("./report_three.jsp").include(request, response);
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
