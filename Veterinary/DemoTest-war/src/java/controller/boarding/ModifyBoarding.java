/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.boarding;


import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.customer.Boarding;
import model.customer.BoardingFacade;
import model.customer.Customer;
import model.customer.CustomerFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "ModifyBoarding", urlPatterns = {"/receptionist/boarding/ModifyBoarding"})
public class ModifyBoarding extends HttpServlet {
    
    @EJB
    BoardingFacade bf;
    Boarding b;
    @EJB
    CustomerFacade cf;
    Customer c;
    
    private long id;
    private String duration;
    private double price;
    private String email;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            id = Long.parseLong(request.getParameter("pk"));
            duration = request.getParameter("duration");
            email = request.getParameter("customer");
            price = Double.parseDouble(request.getParameter("price"));
            c = cf.getCustomer(email);
            
            b = bf.getBoardingObject(id);
            b.setDuration(duration);
            b.setPrice(price);
            b.setCust(c);
            bf.edit(b);
            request.getRequestDispatcher("../index.jsp").include(request, response);
        } catch(Exception x) {
            request.getRequestDispatcher("../index.jsp").include(request, response);
            out.print("Something went wrong. Please check your input!");
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
