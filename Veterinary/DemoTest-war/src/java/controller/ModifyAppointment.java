/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Vet;
import model.customer.AppointmentFacade;
import model.customer.Customer;
import model.customer.CustomerFacade;
import model.customer.Pet;
import model.customer.PetFacade;
import model.customer.Appointment;
import org.jboss.weld.servlet.SessionHolder;

/**
 *
 * @author abspk
 */
@WebServlet(name = "modifyAppointment", urlPatterns = {"/receptionist/ModifyAppointment"})
public class ModifyAppointment extends HttpServlet {
    
    @EJB
            CustomerFacade customerFacade;
    Customer customer;
    @EJB
            PetFacade petFacade;
    Pet pet;
    @EJB
            AppointmentFacade appointmentFacade;
    Appointment appointment;
    Vet vet;
    private String custName;
    private String custEmail;
    private String tel;
    private String petName;
    private String type;
    private String service;
    private String date;
    private SimpleDateFormat format;
    private Date d;
    private String vetEmail;
    private String oldDate;
    private long petID;
    private String id;
    private long appointmentID;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession s = request.getSession(false);
            custName = request.getParameter("name");
            custEmail = request.getParameter("email");
            tel = request.getParameter("telephone");
            petName = request.getParameter("petName");
            type = request.getParameter("petType");
            service = request.getParameter("reason");
            vet = new Vet();
            vetEmail = request.getParameter("vet");
            vet.setEmail(vetEmail);
            date = request.getParameter("date");
            format = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy");
            oldDate = String.valueOf(s.getAttribute("app"));
            id = request.getParameter("petID");
            petID = Long.parseLong(id);
            appointmentID = Long.parseLong(request.getParameter("pk"));
            
            //create pet
            pet = petFacade.getPet(petID);
            pet.setName(petName);
            pet.setType(type);
            petFacade.edit(pet);
            
            //create customer
            customer = customerFacade.getCustomer(custEmail);
            //customer.setEmail(custEmail);
            customer.setName(custName);
            customer.setTel(tel);
            customer.setPet(pet);
            customerFacade.edit(customer);
            
            //modifyAppointment
            d = format.parse(oldDate);
            appointment = appointmentFacade.getSingleAppointment(appointmentID);
            
            try {
                format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                d = format.parse(date);
            } catch(ParseException x) {
                format = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy");
                d = format.parse(date);
            }
            appointment.setAppointmentDate(d);
            appointment.setCustEmail(custEmail);
            appointment.setCustName(custName);
            appointment.setTel(tel);
            appointment.setCustomer(customer);
            appointment.setPet(pet);
            appointment.setService(service);
            appointment.setPetName(petName);
            appointment.setVet(vet);
            appointment.setType(type);
            appointment.setVetEmail(vetEmail);
            appointmentFacade.edit(appointment);
            
            request.getRequestDispatcher("./index.jsp").include(request, response);
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
