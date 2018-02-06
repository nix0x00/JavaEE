/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller.vet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Staff;
import model.StaffFacade;
import model.Vet;
import model.VetFacade;
import model.customer.Appointment;
import model.customer.AppointmentFacade;
import model.customer.Customer;
import model.customer.CustomerFacade;
import model.customer.Diagnosis;
import model.customer.DiagnosisFacade;
import model.customer.Pet;
import model.customer.PetFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "CreateDiagnosis", urlPatterns = {"/vet/CreateDiagnosis"})
public class CreateDiagnosis extends HttpServlet {
    
    private String status;
    private long id;
    private String petName;
    private String petType;
    private String custName;
    private String custID;
    private long petID;
    private long vetID;
    
    @EJB
    DiagnosisFacade df;
    Diagnosis d;
    @EJB
    private CustomerFacade cf;
    private Customer c;
    @EJB
    private VetFacade vf;
    private Vet v;
    @EJB
    private PetFacade pf;
    private Pet p;
    @EJB
    private AppointmentFacade af;
    private Appointment ap;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            status = request.getParameter("status");
            petName = request.getParameter("petName");
            petType = request.getParameter("petType");
            custName = request.getParameter("custName");
            custID = request.getParameter("custID");
            id = Long.parseLong(request.getParameter("pk"));
            ap = af.getSingleAppointment(id);
            p = pf.getPet(ap.getPet().getId());
            v = vf.getVet(ap.getVetEmail());
            c = cf.getCustomer(ap.getCustEmail());
            boolean bool = df.validateDiagnosis(c.getEmail());
            if(bool) {
                request.getRequestDispatcher("./index.jsp").include(request, response);
                out.print("Error: already Diagnosed.");
                return;
            }
            d = new Diagnosis();
            d.setAppointment(ap);
            d.setCustomer(c);
            d.setLastFed("");
            d.setVet(v);
            d.setStatus(status);
            d.setPet(p);
            //d.setStaff(staff);
            df.create(d);
            
            request.getRequestDispatcher("./index.jsp").include(request, response);
            
        } catch(Exception x) {
            request.getRequestDispatcher("./index.jsp").include(request, response);
            out.print("Error: Please try again.");
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
