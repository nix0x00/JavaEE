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
import model.customer.Customer;
import model.customer.CustomerFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "CreateBoarding", urlPatterns = {"/receptionist/boarding/CreateBoarding"})
public class CreateBoarding extends HttpServlet {
    
    @EJB
    private CustomerFacade cf;
    private List<Customer> customer;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            customer = cf.findAll();
            request.setAttribute("custList", customer);
            request.getRequestDispatcher("./create-boarding.jsp").include(request, response);
        } catch(Exception x) {
            out.println("<html>Error: No customer found!</html>");
            request.getRequestDispatcher("./create-boarding.jsp").include(request, response);
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
