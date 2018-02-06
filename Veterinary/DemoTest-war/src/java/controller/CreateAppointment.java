/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vet;
import model.customer.AppointmentFacade;
import model.customer.Appointment;
import model.customer.Customer;
import model.customer.CustomerFacade;
import model.customer.Pet;
import model.customer.PetFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "CreateAppointment", urlPatterns = {"/receptionist/CreateAppointment"})
public class CreateAppointment extends HttpServlet {
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
    private double price;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
            format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            
            switch(service) {
                case "bath":
                    price = 500;
                    break;
                case "cut":
                    price = 200;
                    break;
                case "surgery":
                    price = 3000;
                    break;
                case "exam":
                    price = 500;
                    break;
                case "visit":
                    price = 150;
                    break;
                case "annual":
                    price = 1500;
                    break;
                case "vaccination":
                    price = 850;
                    break;
                default:
                    price = 400;
                    break;
                    
            }
            //create pet
            pet = new Pet();
            pet.setName(petName);
            pet.setType(type);
            petFacade.create(pet);
            
            //create customer
            customer = new Customer();
            customer.setEmail(custEmail);
            customer.setName(custName);
            customer.setTel(tel);
            customer.setPet(pet);
            customerFacade.create(customer);
            
            //createAppointment
            appointment = new Appointment();
            d = format.parse(date);
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
            appointment.setPrice(price);
            appointmentFacade.create(appointment);
            
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
