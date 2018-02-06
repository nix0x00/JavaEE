/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vet;
import model.VetFacade;
import model.customer.AppointmentFacade;
import model.customer.Appointment;

/**
 *
 * @author abspk
 */
@WebServlet(name = "EditAppointment", urlPatterns = {"/receptionist/EditAppointment"})
public class EditAppointment extends HttpServlet {
    
    private long id;
    private String date;
    private SimpleDateFormat format;
    @EJB
            AppointmentFacade af;
    List<Appointment> ap;
    @EJB
            VetFacade vetFacade;
    List<Vet> vet;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            format = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy");
            date = request.getParameter("appointmentDate");
            id = Long.parseLong(request.getParameter("pk"));
            
            Date d = format.parse(date);
            
            boolean val = af.ifExists(d);
            
            if(val) {
                ap = af.getAppointment(id);
                //out.print("<html>" + ap.getCustEmail() + "</html>");
                request.setAttribute("appoint", ap);
                vet = new ArrayList<Vet>();
                vet = vetFacade.findAll();
                request.setAttribute("vetList", vet);
                request.getRequestDispatcher("./modify.jsp").include(request, response);
            } else {
                response.sendError(500);
            }
        } catch(Exception x) {
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
