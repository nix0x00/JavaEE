/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller.staff;

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
import model.customer.Diagnosis;
import model.customer.DiagnosisFacade;

/**
 *
 * @author abspk
 */
@WebServlet(name = "UpdateLastFeed", urlPatterns = {"/staff/UpdateLastFeed"})
public class UpdateLastFeed extends HttpServlet {
    
    @EJB
    DiagnosisFacade df;
    Diagnosis d;
    private String status;
    private String feed;
    private long id;
    @EJB
    private StaffFacade sf;
    private Staff staff;
    
    HttpSession session;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            feed = request.getParameter("feed");
            status = request.getParameter("status");
            id = Long.parseLong(request.getParameter("pk"));
            d = df.getDiagnosis(id);
            session = request.getSession(false);
            staff = sf.getStaff(String.valueOf(session.getAttribute("username")));

            if(d != null) {
                d.setStatus(status);
                d.setLastFed(feed);
                d.setStaff(staff);
                df.edit(d);
                out.print("<html>Success!</html>");
                request.getRequestDispatcher("./index.jsp").include(request, response);
            } else {
                out.print("Error: Please try again.");
                request.getRequestDispatcher("./index.jsp").include(request, response);
            } 
        } catch(Exception x) {
            out.print("Error: Please try again.");
            request.getRequestDispatcher("./index.jsp").include(request, response);
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
