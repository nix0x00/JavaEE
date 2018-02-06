/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

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
import model.customer.AppointmentFacade;
import model.customer.Appointment;

/**
 *
 * @author abspk
 */
@WebServlet(name = "SearchAppointment", urlPatterns = {"/receptionist/SearchAppointment"})
public class SearchAppointment extends HttpServlet {
    
    @EJB
            AppointmentFacade af;
    List<Appointment> appointment;
    private String custName;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            custName = request.getParameter("customerName");
            appointment = new ArrayList<>();
            appointment = af.getAppointment(custName);
            request.setAttribute("appointment", appointment);
            
            try {
                if(request.getParameter("delete").equals("delete")) {
                    request.getRequestDispatcher("./delete-appointment.jsp").include(request, response);
                } else {
                    request.getRequestDispatcher("./edit-appointment.jsp").include(request, response);
                }
            } catch(NullPointerException x) {
                request.getRequestDispatcher("./edit-appointment.jsp").include(request, response);
            }
            
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
