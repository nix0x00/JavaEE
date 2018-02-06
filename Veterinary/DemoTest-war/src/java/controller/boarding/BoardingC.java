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

/**
 *
 * @author abspk
 */
@WebServlet(name = "BoardingC", urlPatterns = {"/receptionist/boarding/BoardingC"})
public class BoardingC extends HttpServlet {
    
    @EJB
    private BoardingFacade bf;
    private Boarding b;
    Customer customer;
    private double price;
    private String duration;
    private String email;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            duration = request.getParameter("duration");
            email = request.getParameter("customer");

            switch(duration) {
                case "1":
                    price = 200;
                    break;
                case "2":
                    price = 400;
                    break;
                case "3":
                    price = 600;
                    break;
                case "4":
                    price = 800;
                    break;
                case "5":
                    price = 1000;
                    break;
                default:
                    price = 1300;
                    break;
            }

            customer = new Customer();
            customer.setEmail(email);
            b = new Boarding();
            b.setCust(customer);
            b.setDuration(duration);
            b.setPrice(price);
            bf.create(b);
            
            request.getRequestDispatcher("./index.jsp").include(request, response);
        } catch(Exception x) {
            request.getRequestDispatcher("./create-boarding.jsp").include(request, response);
            out.print("<html>Error: Please try again.<html>");
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
