/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller.report;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.customer.Appointment;
import model.customer.AppointmentFacade;
import model.customer.Boarding;
import model.customer.BoardingFacade;
import model.customer.Diagnosis;
import model.customer.DiagnosisFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "ReportFive", urlPatterns = {"/manager/report/ReportFive"})
public class ReportFive extends HttpServlet {
    @EJB
    AppointmentFacade af;
    Appointment app;
    List<Appointment> ap;
    @EJB
    BoardingFacade df;
    List<Boarding> d;
    Boarding boarding;
    double price;
    double diagPrice;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ap = af.getPrice();
            d = df.findAll();
            if(ap != null && d != null) {
                for(int i = 0; i < ap.size(); i++) {
                    price += ap.get(i).getPrice();
                }
                for(int i = 0; i < d.size(); i++) {
                    diagPrice += d.get(i).getPrice();
                }
                
                app = new Appointment();
                app.setPrice(price);
                app.setTel(String.valueOf(ap.size()));
                ap = new ArrayList<Appointment>();
                ap.add(app);
                boarding = new Boarding();
                boarding.setPrice(diagPrice);
                d = new ArrayList<Boarding>();
                d.add(boarding);
                
                request.setAttribute("boarding", d);
                request.setAttribute("appointment", ap);
                request.getRequestDispatcher("./report_five.jsp").include(request, response);
            } else {
                request.getRequestDispatcher("./report_five.jsp").include(request, response);
            }
            
        } catch(Exception x) {
            out.print("Error: Please try again.");
            request.getRequestDispatcher("./report_five.jsp").include(request, response);
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
