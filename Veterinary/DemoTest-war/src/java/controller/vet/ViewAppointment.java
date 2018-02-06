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
import javax.servlet.http.HttpSession;
import model.customer.AppointmentFacade;
import model.customer.Appointment;

/**
 *
 * @author abspk
 */
@WebServlet(name = "ViewAppointment", urlPatterns = {"/vet/ViewAppointment"})
public class ViewAppointment extends HttpServlet {
    
    @EJB
            AppointmentFacade af;
    List<Appointment> ap;
    HttpSession s;
    String email;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            s = request.getSession(false);
            email = String.valueOf(s.getAttribute("username"));
            ap = af.getVet(email);
            if(ap != null) {
                request.setAttribute("appointment", ap);
                request.getRequestDispatcher("./view-appointment.jsp").include(request, response);
            } else {
                request.getRequestDispatcher("./index.jsp").include(request, response);
                out.print("Error: Please try again.");
            }
            
        } catch(Exception x) {
            request.getRequestDispatcher("./index.jsp").include(request, response);
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
