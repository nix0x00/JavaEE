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
import model.customer.Appointment;
import model.customer.AppointmentFacade;
import model.customer.Customer;
import model.customer.CustomerFacade;
import model.customer.Pet;
import model.customer.PetFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "LoadDiagnosis", urlPatterns = {"/vet/LoadDiagnosis"})
public class LoadDiagnosis extends HttpServlet {
    
    @EJB
    AppointmentFacade af;
    List<Appointment> ap;
    @EJB
            PetFacade pf;
    Pet pet;
    @EJB
            CustomerFacade cf;
    Customer customer;
    private long id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            id = Long.parseLong(request.getParameter("pk"));
            ap = af.getAppointment(id);
            request.setAttribute("app", ap);  
            
            request.getRequestDispatcher("./create-diagnosis.jsp").include(request, response);
        } catch(Exception x) {
            request.getRequestDispatcher("./index.jsp").include(request, response);
            out.print("Error: Please try again later.");
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
