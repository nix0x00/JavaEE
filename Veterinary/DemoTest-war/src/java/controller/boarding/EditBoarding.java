/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.boarding;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.customer.BoardingFacade;
import model.customer.Boarding;
import model.customer.Customer;
import model.customer.CustomerFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "EditBoarding", urlPatterns = {"/receptionist/boarding/EditBoarding"})
public class EditBoarding extends HttpServlet {

    @EJB
    BoardingFacade bf;
    List<Boarding> b;
    long id;
    @EJB
    CustomerFacade cf;
    List<Customer> c;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            id = Long.parseLong(request.getParameter("pk"));
            b = bf.getBoardingAppointment(id);
            c = cf.findAll();
            if(b == null || c == null) {
                request.getRequestDispatcher("./edit-boarding").include(request, response);
                out.print("Error: Please try again.");
            } else {
                request.setAttribute("boarding", b);
                request.setAttribute("custList", c);
                request.getRequestDispatcher("./modifyBoarding.jsp").include(request, response);
            }
            
        } catch(Exception x) {
            x.printStackTrace();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
