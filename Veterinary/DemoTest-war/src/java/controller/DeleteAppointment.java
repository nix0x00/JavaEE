/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DeleteAppointment", urlPatterns = {"/receptionist/DeleteAppointment"})
public class DeleteAppointment extends HttpServlet {
    
    @EJB
            AppointmentFacade appointmentFacade;
    Appointment ap;
    long id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            id = Long.parseLong(request.getParameter("pk"));
            try {
                ap = appointmentFacade.getSingleAppointment(id);
                appointmentFacade.remove(ap);
                request.getRequestDispatcher("./delete-appointment.jsp").include(request, response);
            } catch(Exception x) {
                request.getRequestDispatcher("./delete-appointment.jsp").include(request, response);
                out.print("<html>Unable to delete. Please try again!</html>");
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
